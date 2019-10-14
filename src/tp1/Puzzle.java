
package tp1;

import java.util.ArrayList;

public class Puzzle {
    
    int m[][] = new int[3][3];
    //ArrayList <Puzzle> filhos;
    
    
    
    public Puzzle (int[] value){
        int pos = 0;
        for(int i = 0; i< 3; i++){
            for(int j = 0 ; j<3; j++){
                this.m[i][j] = value[pos];
                pos++;
            }
        }  
    }
    
    public Puzzle(Puzzle saida){
        
        for(int i = 0; i< 3; i++){
            for(int j = 0 ; j<3; j++){
                saida.m[i][j] = this.m[i][j];
            }
        }  
       
    }
    
  
    public boolean FimJogo(int[][] meta){
        int[][] atual = this.m;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(atual[i][j] != meta[i][j]){
                    return false;
                }
            }
        }
        System.out.println("fim do jogo");
        return true;
    }
    
    public int[] GetEstadoCriar(){
        int[] estado = new int[9];
        for(int i = 0 ; i < 3; i++){
            for(int j =0; j <3; j++){
                estado[i] = m[i][j];
            }
        }
        return estado;
    }
   
    public Puzzle GetEstadoConsulta(){
        return this;
    }
    
    public boolean Movecima(){
        System.out.println("cima");
     for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (i > 0){
                m[i][j] = m[i-1][j];
                m[i-1][j] = 0;
                return true;
                }
            }
        }
    }
      return false;
        
    }
    
   public boolean MoveEsq(){
       System.out.println("esq");
       for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (j > 0){
                m[i][j] = m[i][j-1];
                m[i][j-1] = 0;
                return true;

            }
        }
    } 
   }
       return false;
   }
   
   
   
    public boolean MoveDir(){
        System.out.println("dir");
      for (int i = 0; i < 3; i++){
       for (int j = 0; j < 3; j++){
           if (m[i][j] == 0){
               if (j > 0){
               m[i][j] = m[i][j-1];
               m[i][j-1] = 0;
               return true;
           }
           
       }
   
  }
     
    }
         return false;
    }

     
    public boolean Movebaixo(){
        System.out.println("baixo");
    for (int i = 0; i < 3; i++){
     for (int j = 0; j < 3; j++){
         if (m[i][j] == 0){
             if (j!= 2){
             m[i][j] = m[i+1][j];
             m[i+1][j] = 0;
             return true;

         }
     }
 }
      
   }
   return false;
 }
    
    public void ImprimeVertice(){
       for (int i = 0; i < 3; i++)  {  
       for (int j = 0; j < 3; j++)     { 
            System.out.print(" "+m[i][j]);
       }  
       System.out.println(" ");
     }    
}
}
