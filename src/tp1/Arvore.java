/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.pkg2;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author aryels
 */
public class Arvore {
    private Puzzle jogo;
   
    
    
    public Arvore(int[] peças){
        jogo = new Puzzle(peças);
        //System.out.println("primeira config jogo");
        //jogo.ImprimeVertice();
       
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
 
       
    
    public Puzzle BuscaLargura(int[][] meta,Arvore a){
       Set<Puzzle> visitados = new HashSet<>();
       Puzzle jogo = new Puzzle (a.Getjogo());
       Puzzle jogoAtual = new Puzzle(jogo);
       //System.out.println("jogoAtual:");
       //jogoAtual.ImprimeVertice();
       Queue <Puzzle> lista = new LinkedList<>();
       boolean testa = jogoAtual.FimJogo(meta);
       while(!testa){
           visitados.add(jogoAtual);
          // System.out.println("aqui");
           List <Puzzle> movimentos = jogoAtual.CriaFilhos();
           if(movimentos != null){
               for(Puzzle f: movimentos){
                    if(visitados.contains(f))
                        continue;
                    visitados.add(f);
                    Puzzle filho = new Puzzle(f);
                    jogoAtual.addFilhos(filho,jogoAtual);
                    filho.setPai(jogoAtual);
                    //System.out.println("jogo entrando na lista");
                    //movimentos.get(testados)
                    //filho.ImprimeVertice();
                    lista.add(filho);
                }
            }
           jogoAtual = lista.poll();
           testa  = jogoAtual.FimJogo(meta);
           //System.out.println("jogo saindo da lista:");
           //jogoAtual.ImprimeVertice();
        }
       return jogoAtual;
    }
    
    
    public void BuscaProfundidade(int[][] meta,Arvore a){
        Set<Puzzle> visitados = new HashSet<>();
        Puzzle jogo = new Puzzle (a.Getjogo());
        Puzzle jogoAtual = jogo;
        Stack<Puzzle> pilha = new Stack<>();
        int testados = 0;
        //pilha.push(jogo);
        boolean testa = jogoAtual.FimJogo(meta);
       while(!testa){
           visitados.add(jogoAtual);
           List <Puzzle> movimentos = jogoAtual.CriaFilhos();
           if(movimentos != null){
               for(Puzzle f: movimentos){
                    if(visitados.contains(f))
                        continue;
                    //System.out.println("numero de filhos por while");
                    //System.out.println(movimentos.size());
                    visitados.add(f);
                    Puzzle filho = new Puzzle(f);
                    jogoAtual.addFilhos(filho,jogoAtual);
                    filho.setPai(jogoAtual);
                    System.out.println("jogo entrando na pilha");
                    //movimentos.get(testados)
                    filho.ImprimeVertice();
                    pilha.push(filho);
                }
           }
           jogoAtual = pilha.pop();
           System.out.println("jogo saindo da pilha");
           jogoAtual.ImprimeVertice();
           testa = jogoAtual.FimJogo(meta);
           ++testados;
       }
        
    }
    
    
    
    public void ImpriemResultado(Puzzle r){
         Stack<Puzzle> pilha = new Stack<>();
        Puzzle aux = r;
        Puzzle aux2;
        System.out.println("solução");
        while(aux != null){
            pilha.push(aux);
            aux = aux.GetPai();
            
        }
       int movneed = pilha.size()-1;
        System.out.println("Movimentos necessarios para resolver o Puzzle: "+movneed);
       while(!pilha.empty()){
            System.out.println("------------");
            aux2 = pilha.pop();
            aux2.ImprimeVertice();
        }
        
    }
    
   
}

