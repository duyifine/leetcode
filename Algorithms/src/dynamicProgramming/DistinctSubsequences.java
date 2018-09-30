package dynamicProgramming;

public class DistinctSubsequences {
  public int numDistinct(String s, String t) {
    if (s == null || t == null) return 0;
    
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i < s.length() + 1; i++) {
        dp[i][0] = 1;
    }
    
    for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
            } else {
                dp[i + 1][j + 1] = dp[i][j + 1];
            }
        }
    }
    
    return dp[s.length()][t.length()];
  }
  
  public static void main(String[] args) {
    DistinctSubsequences sol = new DistinctSubsequences();
    String s = "rabbbit";
    String t = "rabbit";
    System.out.println(sol.numDistinct(s, t));
  }
}