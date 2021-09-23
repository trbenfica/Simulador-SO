import java.util.Random;


public class GeradorDeRequisitosTrhead implements Runnable{
    //private int buffer; // tamanho max da fila circular
	//private int itens; // nº de itens não consumidos
	private int max; //Tamanho máximo da variável.
	private int min; //Tamanho mínimo da variável
	private int req_geradas;
	private int tamanho_variavel;
	private int total_reqs;
	private boolean controle;
	private long tempo;
	Random gerador = new Random();

	//Construtor da classe.
	public GeradorDeRequisitosTrhead(int mx, int mn, int total, long t){
		this.max = mx;
		this.min = mn;
		this.total_reqs = total;
		this.req_geradas = 0;
		this.tempo = t;
	}

	//Geração do tamanho da variavel e instancia de uma nova requisição.
    @Override
    public void run() { //gerarRequisicao
        
        //while(req_geradas < total_reqs){
			tamanho_variavel = (int)Math.floor(Math.random()*(max - min + 1) + min);
        	Requisitos req = new Requisitos(tamanho_variavel, req_geradas, gerarConteudo());
        	req_geradas++;
			//MainTrhead.gestorVet.acquire();
			synchronized (MainTrhead.vetor_Req){
				controle = MainTrhead.vetor_Req.inserir(req);
				System.out.println("vetor de requisitos (critico)");
			}
			//MainTrhead.gestorVet.release();
			if(controle){
				sleep();
				System.out.println("gerador dormiu:");
			}
		//}
		System.out.println("Total de Req_geradas: " + req_geradas);
	}
	public int getReqGeradas(){ return req_geradas;}


	//Retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarConteudo(){
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "123456789";
		StringBuilder sb = new StringBuilder(tamanho_variavel);

		for (int i = 0; i < tamanho_variavel; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
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
