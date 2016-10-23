public class MatrixMultiplication {
  public static void main(String[] args) {
    /* int[][] A = new int[2][2];
    int[][] B = new int[2][2];
    A[1] = {Integer.parseInt(args[2]), Integer.parseInt(args[3])};
    rowB1[] = {Integer.parseInt(args[4]), Integer.parseInt(args[5])};
    rowB2[] = {Integer.parseInt(args[6]), Integer.parseInt(args[7])};
    for(int i = 0; i < A.length; i++) {
      for(int j = 0; j < A.length; j++) {}
        System.out.println(A[i][j]); */
     int[] rowA1 = {Integer.parseInt(args[0]), Integer.parseInt(args[1])};
     int[] rowA2 = {Integer.parseInt(args[2]), Integer.parseInt(args[3])};
     int[][] A = {rowA1, rowA2};
     int[] rowB1 = {Integer.parseInt(args[4]), Integer.parseInt(args[5])};
     int[] rowB2 = {Integer.parseInt(args[6]), Integer.parseInt(args[7])};
     int[][] B = {rowB1, rowB2};
     for(int i = 0; i < A.length; i++) {
       for(int j = 0; j < A.length; j++){
         System.out.print(A[i][j] + " ");
      }
       System.out.print("     ");
       for (int j = 0; j < B.length; j++) {
         System.out.print(B[i][j] + " ");
       }
       System.out.println();
     }
     
     
     int[] rowAB1 = new int[2];
     int[] rowAB2 = new int[2];
     int[][] AB = {rowAB1, rowAB2};
     //for (int i = 0; i < rowAB1.length; i++)
     
       /* for (int j = 0; j < rowAB1.length; j++){
         for (int k = 0; k < rowAB1.length; k++) {
            //AB[i][j] += A[j][k] * B[k][j];
           rowAB1[j] += A[0][k] * B[k][j];
       }
     }   
         for (int p = 0; p < rowAB2.length; p++){
           for (int q = 0; q < rowAB2.length; q++) {
             rowAB2[p] += A[1][q] * B[q][p];
       }
     } */
     
     for(int i = 0; i < 2; i++) {     
       for (int j = 0; j < rowAB1.length; j++){
         for (int k = 0; k < rowAB1.length; k++) {
           //AB[i][j] += A[j][k] * B[k][j]; (previous incorrect code)
           AB[i][j] += A[i][k] * B[k][j];
         }
       }   
     }      
     System.out.println();
     for (int i = 0; i < 2; i++){
        System.out.print(rowAB1[i] + " ");
     }
     System.out.println();
     for (int i = 0; i < 2; i++){
        System.out.print(rowAB2[i] + " ");
     }
     System.out.println();
   }
  }