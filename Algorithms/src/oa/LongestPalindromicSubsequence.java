package oa;

public class LongestPalindromicSubsequence {
  
  public int longestPalindromicSubseq(String s) {
    if (s == null || s.length() == 0) return 0;
    
    int[][] dp = new int[s.length()][s.length()];
    for (int len = 1; len <= s.length(); len++) {
      for (int start = 0; start <= s.length() - len; start++) {
        if (len == 1) {
          dp[start][start + len - 1] = 1;
        } else {
          if (dp[start] == dp[start + len - 1]) {
            dp[start][start + len - 1] = dp[start + 1][start + len - 2] + 2;
          } else {
            dp[start][start + len - 1] = Math.max(dp[start + 1][start + len - 1], dp[start][start + len - 2]);
          }
        }
      }
    }
    
    return dp[0][s.length() - 1];
  }
}