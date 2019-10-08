/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author aryels
 */
public class Test {
    
    

    public static void main(String[] args) {
        //int[] peças = new int[9];
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
            
           
            for(int i = 0; i< numeros.size(); i++){
                peças[i] =(int)numeros.get(i);
                System.out.println("peças: "+peças[i]);
            }
             
             break;
            
          case 2:
            for(int i = 0; i < 9; i++){
                System.out.println("entre com os valores da matriz,sem repetição, 0 representa a posição vazia");
                peças[i] = s.nextInt();
            }
         
            break;
      }
      Vertice v = new Vertice(peças);
     // v.ImprimeVertice();
      
      
        
        
        
     
        
       // System.out.println("hello grafo");
    }
    
}
}

