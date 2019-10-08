
package tp1;

public class Vertice {
    
    int m[][] = new int[3][3];

    
    
    public Vertice (int[] value){
        int pos = 0;
        for(int i = 0; i< 3; i++){
            //System.out.println(" ");
            for(int j = 0 ; j<3; j++){
                this.m[i][j] = value[pos];
                //1System.out.println("valor entrando"+value[pos]);
                System.out.print(" "+m[i][j]);
                pos++;
            }
            System.out.println("");
        }
        //System.out.println("aqui");
    }
    
   
    public void ImprimeVertice(){
       for (int l = 0; l < m.length; l++)  {  
       for (int c = 0; c < m.length; c++)     { 
           System.out.print(m[l][c] + " "); //imprime caracter a caracter
       }  
       System.out.println(" "); //muda de linha
     }  
    
    
}
}
