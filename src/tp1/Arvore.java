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
    
    
    public void  BuscaLargura(int[][] meta){
        Puzzle swap,te;
        Queue<Arvore> queue = new LinkedList<>();
        queue.add(this);
        System.out.println("bl");
       

        while (!queue.peek().jogo.FimJogo(meta)){
           
            swap = new Puzzle(queue.peek().jogo);
           
           // swap.ImprimeVertice();
            if(swap.MoveDir()){
                swap.ImprimeVertice();
               queue.add(InsereNo(swap, 0));
               
            }
            
            
           swap = new Puzzle(queue.peek().jogo);
            if(swap.MoveEsq()){
                 swap.ImprimeVertice();
               queue.add(InsereNo(swap,1));
            }
            
           swap = new Puzzle(queue.peek().jogo);
            if(swap.Movebaixo()){
                 swap.ImprimeVertice();
               queue.add(InsereNo(swap,2));
            }
            
           swap = new Puzzle(queue.peek().jogo);
            if(swap.Movecima()){
                swap.ImprimeVertice();
               queue.add(InsereNo(swap,3));
            }
            queue.remove();

            
        }
        
        
    }
    
    
   
           
           
           
            
            
            
            
            /*List<String> nodeSuccessors = NodeUtil.getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (stateSets.contains(n))
                    continue;
                stateSets.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                queue.add(child);

            }
            currentNode = queue.poll();
            time += 1;
        }

        NodeUtil.printSolution(currentNode, stateSets, root, time);
    }*/
	
}
        
        
        
        
        
        
        
        
    
    
    
    
    
    

