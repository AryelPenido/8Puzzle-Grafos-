/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.pkg2;

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
       this.nivel = 0;
    }
    
    public Puzzle(Puzzle saida){
        
        for(int i = 0; i< 3; i++){
            for(int j = 0 ; j<3; j++){
                this.m[i][j]=  saida.m[i][j];
            }
        }
        this.filhos = new ArrayList<>();
        this.nivel = saida.nivel++;
    }
    
  public void setNivel(int nivel){
      this.nivel = nivel;
  }
    
    
    public Puzzle GetPai(){
        return this.pai;
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
    
    
    public boolean FimJogo(int[][] meta){
        int[][] atual = this.m;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(atual[i][j] != meta[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public void Movecima(){
       // System.out.println("cima");
     for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (i > 0){
                m[i][j] = m[i-1][j];
                m[i-1][j] = 0;
                 return;
                }
            }
        }
     }    
    }
   
   public void MoveEsq(){
       for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (j <2 ){
                m[i][j] = m[i][j+1];
                m[i][j+1] = 0;
                return;
                }
            }
        } 
       }
     
   }
   
   
   
    public void MoveDir(){
      for (int i = 0; i < 3; i++){
       for (int j = 0; j < 3; j++){
           if (m[i][j] == 0){
               if (j > 0){
               m[i][j] = m[i][j-1];
               m[i][j-1] = 0;
                return;
                }
           
            }
   
        }
     
       }
      
    }

     
    public void Movebaixo(){
    for (int i = 0; i < 3; i++){
     for (int j = 0; j < 3; j++){
         if (m[i][j] == 0){
             if (i < 2){
             m[i][j] = m[i+1][j];
             m[i+1][j] = 0;
             return;
         }
     }
     }  
      
   }

 }
    public void addFilhos(Puzzle ff,Puzzle ja){
      ja.filhos.add(ff);
    }
    
    
    public void setPai(Puzzle pai){
        this.pai = pai;
    }
    public List CriaFilhos(){
       List <Puzzle> sucessores = new ArrayList<>();
       Puzzle jogo = new Puzzle(this.GetEstadoConsulta());
       jogo.MoveDir();
       sucessores.add(jogo);
       
       jogo = new Puzzle (this.GetEstadoConsulta());
       jogo.MoveEsq();
       sucessores.add(jogo);
       
       jogo =new Puzzle(this.GetEstadoConsulta());
       jogo.Movebaixo();
       sucessores.add(jogo);
               
       jogo = new Puzzle (this.GetEstadoConsulta());
       jogo.Movecima();
       sucessores.add(jogo);
       return sucessores;
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

    