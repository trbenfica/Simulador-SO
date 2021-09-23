public class DesalocadorDeMemoria{

	public DesalocadorDeMemoria(){
		
	}

	//Desalocação de uma variável da heap.
	public void desalocarVar (Variavel variavel){
		MainTrhead.gestorHeap.acquire();
		for (int i = 0; i < variavel.getTam(); i ++) {
			MainTrhead.userHeap.removeHeap(variavel.getRegBase());
		}
		MainTrhead.gestorHeap.release();
		
	}
}
