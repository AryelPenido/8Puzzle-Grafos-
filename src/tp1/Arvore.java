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
    
   /* public Arvore(Puzzle joguinho){
        jogo = new Puzzle(joguinho);
        fd = null;
        fe = null;
        fc = null;
        fb = null;
    }*/
    
    
    public Puzzle Getjogo(){
        return jogo;
    }
 
       
    
    public void  BuscaLargura(int[][] meta,Arvore a){
       Set<Puzzle> visitados = new HashSet<>();
       Puzzle jogo = new Puzzle (a.Getjogo());
       Puzzle jogoAtual = new Puzzle(jogo);
        System.out.println("jogoAtual:");
        jogoAtual.ImprimeVertice();
       Queue <Puzzle> lista = new LinkedList<>();
       boolean testa = jogoAtual.FimJogo(meta);
       while(!testa){
           visitados.add(jogoAtual);
           List <Puzzle> movimentos = jogoAtual.CriaFilhos(jogoAtual);
           if(movimentos != null){
               for(Puzzle f: movimentos){
                if(visitados.contains(f))
                    continue;
                visitados.add(f);
                Puzzle filho = new Puzzle(f);
                jogoAtual.addFilhos(filho);
                filho.setPai(jogoAtual);
                lista.add(filho);
           }
           jogoAtual = lista.poll();
           }
           else{
               continue;
           }
           
       }
      // return lista;
       
       /*boolean testa = jogoAtual.FimJogo(meta);
       visitados.add(jogo);
       while(!testa){
           if(jogo == null)
               continue;
            jogoAtual = new Puzzle (jogo.MoveDir());
            if (!visitados.contains(jogoAtual) && jogoAtual!=null){
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 0);
            }
            
            jogoAtual = new Puzzle(jogo.MoveEsq());
            if (!visitados.contains(jogoAtual) && jogoAtual!=null){
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 1);
            }
           
            jogoAtual = new Puzzle (jogo.Movebaixo());
            if (!visitados.contains(jogoAtual) && jogoAtual!=null){
                    
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 2);
            }
            
            jogoAtual = new Puzzle (jogo.Movecima());
            if (!visitados.contains(jogoAtual) && jogoAtual!=null){
               
                lista.add(jogoAtual);
                visitados.add(jogoAtual);
                a.InsereNo(jogoAtual, 3);
            }
          
            jogo = lista.poll();
            System.out.println("jogo saindo da fila");
            jogo.ImprimeVertice();
            testa = jogo.FimJogo(meta);
        }
       return lista;

	*/
}
    
    
    public void ImprimeLista(Queue lista){
        for(int i = 0 ; i < lista.size();i++){
            System.out.println("jogos testados:"+i+lista.poll());
        }
    }
}


        
        
        
        
        
        
        
        
    
    
    
    
    
    

