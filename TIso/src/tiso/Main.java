
package tiso;


/**
 *
 * @author indra
 */
public class Main {   
    public static void main(String[] args) {
        //TESTE DO VETOR DE REQUISICOES -------- 
        int tamanho_vetor = 100;
        int tamanho_variavel = 10;
        VetorRequisicoes vetor_requisicoes = new VetorRequisicoes(tamanho_vetor);
        //TESTE DE INSERÇÃO
        vetor_requisicoes.inserir(new Requisicao(tamanho_variavel));
        vetor_requisicoes.getVetor();
        //TESTE DE REMOÇÃO
        //TESTE DE TAMANHO 
    }
    
}
