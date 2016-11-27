public class SystemOfEquations{
  public static void main(String[] args) {
    int[][] A = new int[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
    // assigning values to the array A from the user input
    for(int i = 0; i < A.length; i++){
      for (int j = 0; j < A.length; j++){
        A[i][j] = Integer.parseInt(args[(A.length * i) + j + 1]);
      }
    }
    
    // matrix B is the RHS(constant value) of the equation in a system of equation
    int[] B = new int [A.length];
    for(int i = 0; i < A.length; i++){
      B[i] = Integer.parseInt(args[(int)(Math.pow(A.length,2)) + i + 1]);
    }
    
    // matrix X is the solution matrix (x, y, z)
    String[] X  = new String[A.length];
    
    // printing the matrix A
    for(int i = 0; i < A.length; i++) {
       for(int j = 0; j < A.length; j++){
         System.out.print(A[i][j] + " ");
      }
       System.out.println();
    }          
     
    System.out.println();
    
    // finding and printing the determinant of A
    int [][][][] Z = allCofactors(A);
    double determinant = 0;
    for (int j = 0; j < A.length; j++){
      determinant += Math.pow(-1, 0 + j) * A[0][j] * determinantOfMatrix(Z[0][j]);
   }
    
    System.out.println("Determinant of matrix inputted by user is " + determinant);
    System.out.println();
    
    // printing the matrix B
    System.out.println("The matrix B is ");
    for(int i = 0; i < A.length; i++){
      System.out.println(B[i]);
    }
    System.out.println();
    
    
    int allZeroesInB = 0;
    if(determinant == 0) {
        for(int i = 0; i < A.length; i++){
          if(B[i] == 0){
            allZeroesInB++;
        }
      }
        if(allZeroesInB == A.length){
          System.out.println("The given system has infinitely many solutions");
        }
        else{
          System.out.println("The given system has no solution");
        }
        return;
    }
    
    // finding adjoint(A) x B
    int[][] adjoint = adjointOfMatrix(A);
    int[] adjointxB  = new int[A.length];
    for(int i = 0; i < A.length; i++){
      for(int j = 0; j < A.length; j++){
        adjointxB[i] += B[j] * adjoint[i][j];
    }
  }
    
   
    // printing the matrice D
    /* int[][] D = partialCofactors(A);
    for(int i = 0; i < A.length - 1; i++) {
       for(int j = 0; j < A.length - 1; j++) {
         // for(int k = 0; k < A.length - 1; k++) {
         System.out.print(D[i][j] + " ");
      }
       System.out.println();
     }
       System.out.println(); */
       
       // printing the determinant of partial cofactor
       //int determinantOfCofactor = determinantOfMatrix(partialCofactors(A));
       // System.out.println("Determinant of partial cofactor is " + determinantOfCofactor);
       
    // printing all the cofactors 
    // int[][][][] Z = allCofactors(A);
    /* for(int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++) {
        for (int k = 0; k < A.length - 1; k++) {
          for (int p = 0; p < A.length - 1; p++){
            System.out.print(Z[i][j][k][p] + " ");
          }
          System.out.println();
        }
        System.out.println();
      }
      System.out.println();
      System.out.println();
    }
    System.out.println(); */
    
    
    // printing the adjoint of matrix A
    //int[][] adjoint = adjointOfMatrix(A); don't include this. already called this method up above
    System.out.println("Adjoint of inputted matrix is ");
    for(int i = 0; i < A.length; i++){
      for(int j = 0; j < A.length; j++){
        System.out.print(adjoint[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
    
    
    /* printing the matrix adjointxB
    System.out.println("The product of adjoint(A) and B is ");
    for(int i = 0; i < A.length; i++){
      System.out.println(adjointxB[i]); 
    }
    System.out.println();
    System.out.println(); */
    
    // finding X and printing X
    System.out.println("The system has the following solution ");
    String[] variables = {"x", "y", "z"};
    for(int i = 0; i < A.length; i++){
      X[i] = adjointxB[i] + " / " + determinant;
      System.out.println(variables[i] + " = " + X[i]);
   }
 } 
  public static double determinantOfMatrix(int[][] D) {
    // D will be a 2x2 matrix always
    /* int[] LengthOfA = new int[A.length];
    int [] C = LengthOfA;
    for (int i = 0; i < A.length; i++) {
      C[i] = i;
      System.out.print(C[i] + " ");
    }
    System.out.println(); */
    double determinant = 0;
    //for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < D.length; j++) {
         determinant += Math.pow(-1, 0+j) * (D[0][j] * D[D.length - 1][D.length - j - 1]);
    }
     return determinant;  
  }
  
  public static int[][] partialCofactors(int[][] A, int rowNumber, int columnNumber) {
    // D is a 2x2 matrix
    //int[][][] Z = new int[(int)Math.pow(A.length,2)][A.length - 1][A.length - 1];
    int[][] D = new int[A.length - 1][A.length - 1];
   //for (int p = 0; p < (int)Math.pow(A.length,2); p++) {  
    /* for(int index1 = 0; index1 < A.length - 1; index1++){
      for(int index2 = 0; index2 < A.length - 1; index2++) { */
      int index1 = 0;
      int index2 = 0;
      /* while(index1 < A.length - 1) {
        while(index2 < A.length - 1) { */
         for(int i = 0; i < A.length; i++) {
           for (int j = 0; j < A.length; j++) {
             if (i != rowNumber && j != columnNumber){
                D[index1][index2] = A[i][j];
                index2++;
                  if(index2 == A.length - 1) {
                    index1++;
                    index2 = 0;
                 }
               } 
            }
         }
      return D;
   }
  public static int[][][][] allCofactors(int[][] A) {
     int[][][][] Z = new int[A.length][A.length][A.length - 1][A.length - 1];
      for(int i = 0; i < A.length; i++) {
        for (int j = 0; j < A.length; j++){
          Z[i][j] = partialCofactors(A, i, j);
        }
     }
      return Z;
  }
  
  public static int[][] adjointOfMatrix(int[][] A) {
    int[][] adjoint = new int[A.length][A.length];
    int[][][][] Z = allCofactors(A);
    for(int i = 0; i < A.length; i++){
      for (int j = 0; j < A.length; j++) {
        adjoint[j][i] = (int) Math.pow(-1, i+j) * (int)determinantOfMatrix(Z[i][j]);
      }
    }
    return adjoint;
  }

}