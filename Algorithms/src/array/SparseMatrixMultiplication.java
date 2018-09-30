package array;

public class SparseMatrixMultiplication {
  
  public int[][] multiply(int[][] A, int[][] B) {
    if (A == null || B == null || A[0].length != B.length) {
      return null;
    }
    
    int[][] C = new int[A.length][B[0].length];
    for (int i = 0; i < A.length; i++) {
      for (int k = 0; k < A[0].length; k++) {
        if (A[i][k] != 0) {
          for (int j = 0; j < B[0].length; j++) {
            C[i][j] = C[i][j] + A[i][k] * B[k][j];
          }
        }
      }
    }
    return C;
  }
  
  public static void main(String[] args) {
    SparseMatrixMultiplication s = new SparseMatrixMultiplication();
    int[][] A = {{1,2,3}, {3,0,8}, {0,0,2}};
    int[][] B = {{1,2}, {0,0}, {1,0}};
    int[][] C = s.multiply(A, B);
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < C[0].length; j++) {
        System.out.println("C[" +i + "][" + j + "]=" + C[i][j]);
      }
    }
    
  }
}