/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aryel
 */
public class Puzzle {


    
    int m[][] = new int[3][3];
    int nivel;
    ArrayList <Puzzle> filhos ;
    Puzzle pai;
    
    
    
    public Puzzle (int[] value){
        int pos = 0;
        for(int i = 0; i< 3; i++){
            for(int j = 0 ; j<3; j++){
                this.m[i][j] = value[pos];
                pos++;
            }
        }  
       this.filhos = new ArrayList<>();
        
    }
    
    public Puzzle(Puzzle saida){
        
        for(int i = 0; i< 3; i++){
            for(int j = 0 ; j<3; j++){
                this.m[i][j]=  saida.m[i][j];
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
        //this.ImprimeVertice();
        return this;
    }
    
    public Puzzle Movecima(){
       // System.out.println("cima");
     for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (i > 0){
                m[i][j] = m[i-1][j];
                m[i-1][j] = 0;
                 return this.GetEstadoConsulta();
                }
            }
        }
    }
      return null;
        
    }
   
   public Puzzle MoveEsq(){
       //System.out.println("esq");
       for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (j <2 ){
                m[i][j] = m[i][j+1];
                m[i][j+1] = 0;
                  return this.GetEstadoConsulta();
                }
            }
        } 
        }
      return null;
   }
   
   
   
    public Puzzle MoveDir(){
       // System.out.println("dir");
      for (int i = 0; i < 3; i++){
       for (int j = 0; j < 3; j++){
           if (m[i][j] == 0){
               if (j > 0){
               m[i][j] = m[i][j-1];
               m[i][j-1] = 0;
                 return this.GetEstadoConsulta();
                }
           
            }
   
        }
     
        }
         return null;
    }

     
    public Puzzle Movebaixo(){
    for (int i = 0; i < 3; i++){
     for (int j = 0; j < 3; j++){
         if (m[i][j] == 0){
             if (i < 2){
             m[i][j] = m[i+1][j];
             m[i+1][j] = 0;
              return this.GetEstadoConsulta();
         }
     }
     }  
      
   }
    return null;
 
 }
    public void addFilhos(Puzzle ff){
      this.filhos.add(ff);
    }
    
    
    public void setPai(Puzzle pai){
        this.pai = pai;
    }
    public List CriaFilhos(Puzzle jogoAtual){
       System.out.println("Criando filhos");
       List <Puzzle> sucessores = new ArrayList<>();
       Puzzle jogo = new Puzzle(jogoAtual.GetEstadoConsulta());
       jogoAtual = jogoAtual.MoveDir();
      // System.out.println("jogo muda?");
      // jogo.ImprimeVertice();
       if(jogoAtual!= null){
           System.out.println("apos direita");
           jogoAtual.ImprimeVertice();
           sucessores.add(jogoAtual);
       }
       Puzzle swap = new Puzzle (jogo);
        swap = swap.MoveEsq();
        //System.out.println("jogo  muda2?");
       // jogo.ImprimeVertice();
       if(swap != null){
           System.out.println("apos esquerda");
           swap.ImprimeVertice();
           sucessores.add(swap);
       } 
       swap = new Puzzle (jogo);
       swap = swap.Movebaixo();
        //System.out.println("jogo  muda3?");
        //jogo.ImprimeVertice();
       if(swap != null){
           System.out.println("apos baixo");
           swap.ImprimeVertice();
           sucessores.add(swap);
       }
       swap = new Puzzle (jogo);
       swap = swap.Movecima();
       // System.out.println("jogo  muda4?");
       // jogo.ImprimeVertice();
       if(swap!= null){
           System.out.println("apos cima");
           swap.ImprimeVertice();
          sucessores.add(swap);
       }
       
       return sucessores;
    }
    
    
    public void ImprimeVertice(){
        System.out.println("");
       for (int i = 0; i < 3; i++)  {  
       for (int j = 0; j < 3; j++)     { 
            System.out.print(" "+m[i][j]);
       }  
       System.out.println(" ");
     }    
}
}

    

