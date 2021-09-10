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
    private int req_geradas;
    Random gerador = new Random();


    public GeradorDeRequisitos(int mx, int mn){
        this.max = mx;
        this.min = mn;
        this.req_geradas = 0;
    }

    public Requisicao gerarRequisicao(){
        Requisicao req = new Requisicao(gerador.nextInt(max) + min);
        req_geradas++;
        return req;        
    }

    public int getReqGeradas(){
        return req_geradas;
    }

    
} 