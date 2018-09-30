package dynamicProgramming;

public class MinSwapsIncreasingSequences {
  
  public int minSwap(int[] A, int[] B) {
    if (A == null || B == null || A.length == 0 || B.length == 0) {
      return -1;
    }
    
    int[] swap = new int[A.length];
    int[] fixed = new int[A.length];
    swap[0] = 1;
    fixed[0] = 0;
    for (int i = 1; i < A.length; i++) {
      if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
        fixed[i] = fixed[i - 1];
        swap[i] = swap[i - 1] + 1;
      } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
        swap[i] = fixed[i - 1] + 1;
        fixed[i] = swap[i - 1];
      } else {
        fixed[i] = Math.min(swap[i - 1], fixed[i - 1]);
        swap[i] = fixed[i] + 1;
      }
    }
    
    return Math.min(swap[A.length - 1], fixed[A.length - 1]);
  }
}