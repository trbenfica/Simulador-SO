

public class MainTrhead {

    private static long tempoI, tempoF, tempoR, tempoT;
	public static long dormir = 500; // coloca as trheads para dormir por 3s
	public static int totalDeAlocacoes = 100; // Quantidade de alocações a serem feitas
	public static int tamanhoHeap = 1500; 
	public static int minVariavel = 100; // minimo para variáveis dinâmicas
	public static int maxVariavel = 200; // maximo para ...
	public static int tamanho_vetor = 50; // vetor de requisições
	public static int limiteMinOcupacao = 20; // Limite minimo para ocupação da heap
	public static int limiteMaxOcupacao = 80; // Limite maximo para ...
	public static int limiteFragmentacao = 80; // indice de fragmentação

	public static Semaforo gestorVet = new Semaforo();
	public static Semaforo gestorHeap = new Semaforo();
    public static Heap userHeap = new Heap(tamanhoHeap);
    public static GeradorDeRequisitosTrhead geradorReq = new GeradorDeRequisitosTrhead(minVariavel, maxVariavel, totalDeAlocacoes, dormir);
    public static VetorRequisicoes vetor_Req = new VetorRequisicoes(tamanho_vetor);
	public static AlocadorTrhead malloc = new AlocadorTrhead(tamanhoHeap, dormir, totalDeAlocacoes);

    public static void main(String[] args) throws InterruptedException{
		tempoI = System.currentTimeMillis();
		System.out.println("Tempo I: " + (tempoI/1000));
		Thread ger_Req_Thread = new Thread(geradorReq);
		Thread aloc_Thread = new Thread(malloc);

		ger_Req_Thread.start();
		aloc_Thread.start();

		try {
			ger_Req_Thread.join();
			aloc_Thread.join();
		} catch (Exception e) {
			
		}


		
		tempoF = System.currentTimeMillis();
		tempoR = tempoF - tempoI;
		System.out.println("Tempo: "+ tempoR);

    }
}
