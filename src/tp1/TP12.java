/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.pkg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aryels
 */
public class TP12 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int meta[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };

        
        Scanner s = new Scanner(System.in);
        int opcao;
        
        while(true){
            System.out.println("## Menu ##\n");
            System.out.println("## Digite 0 para sair ##");
            System.out.println("## Digite 1 para matriz aleatoria ##");
            System.out.println("## Digite 2 para entrar com uma matriz ##");
             int[] peças  = new int [9];
            opcao = s.nextInt();
        
      switch(opcao){
          case 0:
              System.exit(0);
              break;
          case 1:
              ArrayList numeros = new ArrayList<>();
            for (int i = 0; i < 9 ; i++) { 
            numeros.add(i);
            }

            Collections.shuffle(numeros);
            
           
           /* for(int i = 0; i< numeros.size(); i++){
                peças[i] =(int)numeros.get(i);
                System.out.println("peças: "+peças[i]);
            }*/
             
             break;
            
          case 2:
            for(int i = 0; i < 9; i++){
                System.out.println("entre com os valores da matriz,sem repetição, 0 representa a posição vazia");
                peças[i] = s.nextInt();
            }
         
            break;
      }
      
    /* Puzzle v = new Puzzle(peças);
     System.out.println("");
     v.ImprimeVertice();
     v.Movebaixo();
     System.out.println("");
     v.ImprimeVertice();
     v.Movebaixo();
     System.out.println("");
     v.ImprimeVertice();
     v.Movebaixo();
     System.out.println("");
     v.ImprimeVertice();
     v.Movebaixo();
     System.out.println("");
     v.ImprimeVertice();
     */
    Arvore a = new Arvore(peças);
    //a.BuscaProfundidade(meta, a);
    Puzzle resultado = a.BuscaLargura(meta,a);
    a.ImpriemResultado(resultado);
    /*Puzzle v = new Puzzle(peças);
    List<Puzzle> movimentos =  v.CriaFilhos();
    System.out.println("jogos da lista");
    for(Puzzle f: movimentos){
        //System.out.println(movimentos.get(i));
        f.ImprimeVertice();
    }*/
   
    
    //a.ImprimeLista(resposta);
     //Puzzle v = new Puzzle(peças);
    /* v.ImprimeVertice();
     Puzzle copia = new Puzzle(v);
     System.out.println("");
     v.Movebaixo();
     System.out.println("V após movimento");
     v.ImprimeVertice();
     System.out.println("");
     copia.ImprimeVertice();
     */
     //Puzzle v = a.Getjogo();
     
     
     
     
     
     
     
     
    //Arvore a = new Arvore(peças);
   
    System.out.println("");
  
    System.out.println("");
   
    //a.BuscaLargura(meta);
    
  
    
}
    }
}
