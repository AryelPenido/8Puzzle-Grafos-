
package tp1;

public class Puzzle {
    
    int m[][] = new int[3][3];

    
    
    public Puzzle (int[] value){
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
    
    public boolean MoveUp(){
        
     for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (i > 0){
                m[i][j] = m[i-1][j];
                m[i-1][j] = 0;
                return true;
                }
            }
        }
    }
      return false;
        
    }
    
   public boolean MoveLeft(){
       for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (j > 0){
                m[i][j] = m[i][j-1];
                m[i][j-1] = 0;
                return true;

            }
        }
    } 
   }
       return false;
   }
   
   
   
     public boolean MoveRigth(){
       for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                //if (i > 0){
                m[i][j] = m[i][j-11];
                m[i][j-11] = 0;
                return true;

            }
        }
    }
      return false;
       
   }
     
     
       public boolean MoveDown(){
       for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (m[i][j] == 0){
                if (j!= 2){
                m[i][j] = m[i+1][j];
                m[i+1][j] = 0;
                return true;

            }
        }
    }
      
   }
   
   return false;
 }


    
    
    
    public Puzzle solverBl(){
        
        
        
        
        
        
        
        return this;
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
