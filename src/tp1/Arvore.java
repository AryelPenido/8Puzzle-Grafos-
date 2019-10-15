/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author aryels
 */
public class Arvore {
    private Puzzle jogo;
    Arvore pai;
    Arvore fd,fe,fc,fb;
    
    
    public Arvore(int[] peças){
        jogo = new Puzzle(peças);
        System.out.println("primeira config jogo");
        jogo.ImprimeVertice();
        fd = null;
        fe = null;
        fc = null;
        fb = null;
    }
    
    public Arvore(Puzzle joguinho){
        jogo = new Puzzle(joguinho);
        fd = null;
        fe = null;
        fc = null;
        fb = null;
    }
    
    
    public Puzzle Getjogo(){
       // System.out.println("getJogo");
       // jogo.ImprimeVertice();
        return jogo;
    }
   /* public Puzzle criaNo(int[] value){
        Puzzle novo = new Puzzle(value);
        raiz= novo;
        return novo;
    }*/
   
    public Arvore InsereNo(Puzzle no,int flag){
        switch (flag){
            case 0:
                this.fd = new Arvore(no);
                return this.fd;
             
            case 1:
                this.fe = new Arvore(no);
                return this.fe;
            case 2:
                this.fb = new Arvore(no);
                return this.fb;
            case 3:
                this.fc = new Arvore(no);
                return this.fc;
                
        }
            
        return null;
    }
    
    
    public Queue  BuscaLargura(int[][] meta,Arvore a){
       Set<Puzzle> visitados = new HashSet<>(); 
       Puzzle jogo = new Puzzle (a.Getjogo());
       Queue <Puzzle> lista = new LinkedList<>();
       Puzzle jogoAtual = new Puzzle(jogo);
       
       boolean testa = jogoAtual.FimJogo(meta);
     
       while(!testa){
            visitados.add(jogoAtual);
            jogoAtual = new Puzzle (jogo.MoveDir());
           
            if (!visitados.contains(jogoAtual)){
                
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 0);
            }
            
            jogoAtual = new Puzzle(jogo.MoveEsq());
            if (!visitados.contains(jogoAtual)){
                
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 1);
            }
           
            jogoAtual = new Puzzle (jogo.Movebaixo());
            if (!visitados.contains(jogoAtual)){
                
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 2);
            }
            
            jogoAtual = new Puzzle (jogo.Movecima());
            if (!visitados.contains(jogoAtual)){
               
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 3);
            }
            
            jogo = lista.poll();
            //System.out.println("jogo saindo da fila");
            //jogo.ImprimeVertice();
            testa = jogo.FimJogo(meta);
        }
       return lista;

	
}
    
    
    public void ImprimeLista(Queue lista){
        for(int i = 0 ; i < lista.size();i++){
            System.out.println("jogos testados:"+i+lista.poll());
        }
    }
}


        
        
        
        
        
        
        
        
    
    
    
    
    
    

