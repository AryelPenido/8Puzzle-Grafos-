
package tp1;

public class Vertice {
    
    int m[][] = new int[3][3];

    
    
    public Vertice (int[] value){
        int pos = 0;
        for(int i = 0; i< 3; i++){
            //System.out.println(" ");
            for(int j = 0 ; j<3; j++){
                this.m[i][j] = value[pos];
                pos++;
            }

        }
        //System.out.println("aqui");
    }
    
   
    public void ImprimeVertice(){
       for (int i = 0; i < 3; i++)  {  
       for (int j = 0; j < 3; j++)     { 
            System.out.print(" "+m[i][j]);
       }  
       System.out.println(" "); //muda de linha
     }  
    
    
}
}
