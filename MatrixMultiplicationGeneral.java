public class MatrixMultiplicationGeneral{
  public static void main(String[] args) {
    /* taking size of matrix A (and therefore B) from the user 
     * to make the multiplication work for matrix of any size */
    int[][] A = new int[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
    int[][] B = new int[A.length][A.length];
    
    // in this approach, have to change the size of the array manually
    //int[][] A = new int[3][3];
    //int[][] B = new int[A.length][A.length];
    
    // using a for loop to take in the arguments from the user
    for(int i = 0; i < A.length; i++){
      for (int j = 0; j < A.length; j++){
        A[i][j] = Integer.parseInt(args[(A.length * i) + j + 1]);
        B[i][j] = Integer.parseInt(args[(int)Math.pow(A.length,2) + (A.length * i) + j + 1]);
      }
    }
      // original, tedious way of storing input from user
     /*int[] rowA1 = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
     int[] rowA2 = {Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])};
     int[] rowA3 = {Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8])};
     
     int[] rowB1 = {Integer.parseInt(args[9]), Integer.parseInt(args[10]), Integer.parseInt(args[11])};
     int[] rowB2 = {Integer.parseInt(args[12]), Integer.parseInt(args[13]), Integer.parseInt(args[14])};
     int[] rowB3 = {Integer.parseInt(args[15]), Integer.parseInt(args[16]), Integer.parseInt(args[17])}; */
     
    // printing the matrices A and B
     for(int i = 0; i < A.length; i++) {
       for(int j = 0; j < A.length; j++){
         System.out.print(A[i][j] + " ");
      }
       System.out.print("     ");
       for (int j = 0; j < A.length; j++) {
         System.out.print(B[i][j] + " ");
       }
       System.out.println();
     }
      
     int[][] AB = new int[A.length][A.length];
     
     for(int i = 0; i < A.length; i++) {     
       for (int j = 0; j < A.length; j++){
         for (int k = 0; k < A.length; k++) {
           //AB[i][j] += A[j][k] * B[k][j]; (previous incorrect code, off by only a little bit, but anyways very crucial)
           
           /*     **** THE MOST KEY PIECE OF CODE. EVERYTHING COMES FROM HERE *******
            * THIS FORMULA CAN BE USED FOR PRODUCT OF ANY 2 SQUARE MATRICES OF SAME SIZE */
           AB[i][j] += A[i][k] * B[k][j];
         }
       }   
     }      
     System.out.println();
     
     for(int i = 0; i < A.length; i++) {
       for(int j = 0; j < A.length; j++) {
         System.out.print(AB[i][j] + " ");
       }
       System.out.println();
     }
  }
}