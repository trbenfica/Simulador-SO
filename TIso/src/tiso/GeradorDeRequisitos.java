

package tiso;
import java.util.Random;
/**
 * 
 * @author WillianS
 */

public class GeradorDeRequisitos{
    //private int buffer; // tamanho max da fila circular
    //private int itens; // nº de itens não consumidos
    private int max; 
    private int min; 
    Random gerador = new Random();

    public GeradorDeRequisitos(int mx, int mn){
        this.max = mx;
        this.min = mn;
    }

    public void defineTamanho(){}
    public Requisicao gerarRequisicao(){
        Requisicao req = new Requisicao(gerador.nextInt(max) + min);
        return req;        
    }
} 