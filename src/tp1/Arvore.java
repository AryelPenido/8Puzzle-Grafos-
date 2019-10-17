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
    private int nosCriados;
   
    
    
    public Arvore(int[] peças){
        jogo = new Puzzle(peças);
       nosCriados = 0;
    }
    
   
    
    public Puzzle Getjogo(){
        return jogo;
    }
    
    public int getnos(){
        return nosCriados;
    }
       
    
    public Puzzle BuscaLargura(int[][] meta){
       Set<Puzzle> visitados = new HashSet<>();
       Puzzle jogoAtual = new Puzzle(jogo);

       Queue <Puzzle> lista = new LinkedList<>();
       boolean testa = jogoAtual.FimJogo(meta);
       while(!testa){
           visitados.add(jogoAtual);
           if(jogoAtual.nivel > 31){
               this.nosCriados = visitados.size();
               return jogo;
           }
           List <Puzzle> movimentos = jogoAtual.CriaFilhos();
           
           if(movimentos != null){
               for(Puzzle f: movimentos){
                    if(Compara(f,visitados))
                        continue;
                    visitados.add(f);
                    Puzzle filho = new Puzzle(f);
                    jogoAtual.addFilhos(filho,jogoAtual);
                    filho.setPai(jogoAtual);
                    lista.add(filho);
                }
            }
           jogoAtual = lista.poll();
           testa  = jogoAtual.FimJogo(meta);
        }
       this.nosCriados = visitados.size();
       return jogoAtual;
    }
    
    
    public Puzzle BuscaProfundidade(int meta[][]){

        Puzzle jogoAtual = new Puzzle(this.jogo);
        Stack <Puzzle> pilha = new Stack<>();
        pilha.add(jogoAtual);
        Set<Puzzle> visitados = new HashSet<>();
       while(!pilha.empty()){
            jogoAtual = pilha.pop();
            visitados.add(jogoAtual);
            if(jogoAtual.FimJogo(meta)){
                this.nosCriados = visitados.size();
                 return jogoAtual;
            }    
            else{
                if(jogoAtual.nivel < 25){
                    
                    List <Puzzle> movimentos = jogoAtual.CriaFilhos();
                    for(Puzzle f: movimentos){
                         if(Compara(f,visitados)){
                                 continue;
                         }
                        visitados.add(f);
                        Puzzle filho = new Puzzle(f);
                        jogoAtual.addFilhos(filho,jogoAtual);
                        filho.setPai(jogoAtual);
                        pilha.push(filho);    
                    }

            }
            
            }
       }
       this.nosCriados = visitados.size();
       return jogo;
}
    
    
    
    public boolean Compara(Puzzle f,Set<Puzzle> vi){
        for(Puzzle v: vi){
            if(Compara(v,f))
                return true;
        }
        return false;
    }
    
    public boolean Compara(Puzzle f, Puzzle v){
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(f.m[i][j]!= v.m[i][j])
                    return false;
            }
        }
        return true;
    }
    
    
    
    
    public void ImpriemResultado(Puzzle r){
        Stack<Puzzle> pilha = new Stack<>();
        Puzzle aux = r;
        Puzzle aux2;
        System.out.println("jogo Inicial:");
        this.jogo.ImprimeVertice();
         System.out.println("------------");
        System.out.println("nós criados: "+this.nosCriados);
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

