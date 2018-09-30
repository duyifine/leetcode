package dynamicProgramming;

public class Fibonacci {
  
  public int fibN(int n) {
    int[] fibsFound = new int[n + 1];
    fibsFound[0] = 0;
    fibsFound[1] = 1;
    
    for (int i = 2; i <= n; i++) {
      fibsFound[i] = fibsFound[i - 1] + fibsFound[i - 2];
    }
    
    return fibsFound[n];
  }
}