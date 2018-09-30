package dynamicProgramming;

public class EncodingStringWithShortestLength {
  
  public String encode(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    
    String[][] dp = new String[s.length()][s.length()];
    
    for (int len = 0; len < s.length(); len++) {
      for (int i = 0; i + len < s.length(); i++) {
        int j = i + len;
        String subStr = s.substring(i, j + 1);
        dp[i][j] = subStr;
        if (len < 4) continue;
        
        for (int k = i; k < j; k++) {
          String repeating = s.substring(i, k + 1);
          if (subStr.length() % (k + 1 - i) == 0 && subStr.replaceAll(repeating, "").length() == 0) {
            String ss = subStr.length() / repeating.length() + "[" + dp[i][k] + "]";
            if (ss.length() < dp[i][j].length()) {
              dp[i][j] = ss;
            }
          }
        }
        for (int k = i; k < j; k++) {
          if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
            dp[i][j] = dp[i][k] + dp[k + 1][j];
          }
        }
        
/**        for (int k = i; k < j; k++) {
          String repeating = s.substring(i, k + 1);
          if (subStr.length() % (k + 1 - i) == 0 && subStr.replaceAll(repeating, "").length() == 0) {
            String ss = subStr.length() / repeating.length() + "[" + dp[i][k] + "]";
            if (ss.length() < dp[i][j].length()) {
              dp[i][j] = ss;
            }
          } 
        } **/
      }
    }
    
    return dp[0][s.length() - 1];
  }
  
  public static void main(String[] args) {
    EncodingStringWithShortestLength t = new EncodingStringWithShortestLength();
    System.out.println(t.encode("aaa"));
    System.out.println(t.encode("aaaaa"));
    System.out.println(t.encode("aaaaaaaaaa"));
    System.out.println(t.encode("aabcaabcd"));
    System.out.println(t.encode("abbbabbbcabbbabbbc"));
  }
}