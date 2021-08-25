package tiso;

import tiso.Variavel;

/**
 *
 * @author indra
 */
public class Requisicao {
   int identificador;
   int tamanho;
   Variavel variavel;

   public Requisicao(int tm){
    this.tamanho = tm;
    variavel = new Variavel(tm); // ver se o tamanho da variavel vai ser o mesmo da requisição.
   }

   public void setIdentificador(int id){
       this.identificador = id;
   }

   public Variavel getVariavel(){
       return variavel;
   }

   public int getIdentificador(){
       return identificador;
   } 
}

