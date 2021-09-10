
package tiso;


/**
 *
 * @author indra
 */
public class Main {   
    
    
    public static void main(String[] args) {
        int tamanho_vetor = 100;
        //Heap heap_user = new Heap(1000);
        VetorRequisicoes vetor_requisicoes = new VetorRequisicoes(tamanho_vetor);
        Requisicao teste;
        GeradorDeRequisitos geradorReq;
        //TESTE DO VETOR DE REQUISICOES -------- 
        geradorReq = new GeradorDeRequisitos(20, 5);
    
        for(int x = 0; x < 10 ; x++){
            teste = geradorReq.gerarRequisicao();
            //TESTE DE INSERÇÃO
            vetor_requisicoes.inserir(teste);
            vetor_requisicoes.getVetor();
        }
        //TESTE DE REMOÇÃO
        //TESTE DE TAMANHO 
    }
    
}
