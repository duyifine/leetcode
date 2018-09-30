package dynamicProgramming;

public class BackPack {
  
  public int backPack(int m, int[] A) {
    if (m == 0 || A == null || A.length == 0) {
      return 0;
    }
    
    boolean[][] dp = new boolean[A.length + 1][m + 1];
    for (int i = 0; i <= A.length; i++) {
      dp[i][0] = true;
    }
    
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= m; j++) {
        dp[i][j] = dp[i - 1][j] || (j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]]);
      }
    }
    
    for (int j = m; j >= 0; j--) {
      if (dp[A.length][j]) {
        return j;
      }
    }
    
    return 0;
  }
  
  public static void main(String[] args) {
    BackPack t = new BackPack();
    int[] A = {2,3,4,7};
    int m = 11;
    System.out.println(t.backPack(m, A));
  }
}