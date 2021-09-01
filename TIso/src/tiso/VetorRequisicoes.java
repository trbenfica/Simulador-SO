
package tiso;

import java.util.ArrayList;

/**
 *
 * @author indra
 */
public class VetorRequisicoes {
    //TODO! - IMPRIMIR VETOR!
    
    private int tamanho, inicio, fim;
    private ArrayList<Requisicao> fila = new ArrayList<Requisicao>();
    
    VetorRequisicoes(int tamanho){
        this.tamanho=tamanho;
        this.inicio=this.fim=-1; 
    }
    
    public boolean inserir(Requisicao requisicao){
        boolean cheia=false;
        if((inicio == 0 && fim == tamanho-1)||(fim==(inicio-1)%(tamanho-1))){
           cheia=true; 
        }else if(inicio==-1){
            inicio=0;
            fim =0;
            fila.add(fim, requisicao);
        }else if(fim==tamanho-1 && inicio !=0){
            fim=0;
            fila.set(fim, requisicao);
        }else{
            fim=(fim+1);
            if(inicio<=fim){
                fila.add(fim, requisicao);
            }else{
                fila.set(fim, requisicao);
            }
        }
        return cheia;
    }
    
    public Requisicao remover(){
        Requisicao temp=null;
        if(inicio==-1){
            return null;
        }
        temp = fila.get(inicio);
        
        if(inicio==fim){
            inicio=-1;
            fim=-1;
        }else if(inicio==tamanho-1){
            inicio =0;
        }else{
            inicio++;
        }
        return temp;
    }
    
    
    
}
