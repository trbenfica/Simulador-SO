

package tiso;
import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author WillianS
 */

public class GeradorDeRequisitos{
    /*private int buffer; // tamanho max da fila circular
      private int itens; // nº de itens não consumidos*/
    private int max; 
    private int min; 
    ThreadLocalRandom gerador;

    public GeradorDeRequisitos(int mx, int mn){
        this.max = mx;
        this.min = mn;
        gerador = ThreadLocalRandom.current();
    }

    public void defineTamanho(){}
    public Requisicao gerarRequisicao(){
        Requisicao req = new Requisicao(gerador.nextInt(min, max + 1));
        return req;        
    }
} 