import java.util.ArrayList;


public class AlocadorTrhead implements Runnable{
    //private int tamanhoHeap;
	private long tempo;
	private int reqs_proces , inicio, reqs_totais, tam_heap, removidas;
	private ArrayList<Variavel> controle = new ArrayList<>();
	private AnalisadorDeMemoria analiser = new AnalisadorDeMemoria();
	public static DesalocadorDeMemoria desaloc = new DesalocadorDeMemoria();
	private Requisitos r;
	//private DesalocadorDeMemoria desaloc = new DesalocadorDeMemoria();
	//Construtor da classe.
	public AlocadorTrhead (int tamanhoHeap, long t, int req_T){
		this.reqs_proces = 0;
		this.tempo = t;
		this.reqs_totais = req_T;
		this.tam_heap = tamanhoHeap;
		this.removidas = 0;
	}

	// Recebe uma requisição, inserindo a variável na heap, byte a byte.
	// Retorna true se tudo der certo, caso contrário, retornará false.
	public void run(){
		while(reqs_proces <= reqs_totais){
			//MainTrhead.gestorVet.acquire();
			synchronized(MainTrhead.vetor_Req){
				// sempre pega o primeiro
				r = MainTrhead.vetor_Req.remover();
			}
				if(r != null){
					inicio = analiser.primeiroEncaixe(r.getTamanho());
					if(inicio != -1){
						Variavel variavel_alocada = r.getVariavel();
						variavel_alocada.setRegTamanho((inicio + r.getTamanho() - 1));
						controle.add (variavel_alocada);
						char [] cont = variavel_alocada.gerCont_Char();
						//MainTrhead.gestorHeap.acquire();
						synchronized(MainTrhead.userHeap){
							for (int i = 0; i < variavel_alocada.getTam(); i++)
								MainTrhead.userHeap.addHeap (cont[i], inicio + i);
						}
						//MainTrhead.gestorHeap.release();
					} else {// chamar o desalocador
						for(Variavel v: controle){
							if(r.getTamanho() < v.getTam()){
								desaloc.desalocarVar(v);
								if(controle.remove(v))
									removidas++;
									System.out.println("Removeu: " + removidas);
								break;
							}
						}
						
					}
				}else sleep();
			}
			//MainTrhead.gestorVet.release();
			
			analiser.atualizarBuracos();
	}
			

	public void sleep(){
		long tI = System.currentTimeMillis();
		long tF, tR = 0;
		while(tR <= tempo){
			tF = System.currentTimeMillis();
			tR = tF - tI;
		}
	}
	
}
