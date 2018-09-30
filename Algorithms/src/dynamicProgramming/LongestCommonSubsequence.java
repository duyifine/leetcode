package dynamicProgramming;

public class LongestCommonSubsequence {
  
  public int longest(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return 0;
    }
    
    int[][] longest = new int[s.length()][t.length()];
    for (int i = 0; i < t.length(); i++) {
      if (t.charAt(i) == s.charAt(0)) {
        longest[0][i] = 1;
      } else if (i >= 1) {
        longest[0][i] = longest[0][i - 1];
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t.charAt(0)) {
        longest[i][0] = 1;
      } else if (i >= 1) {
        longest[i][0] = longest[i - 1][0];
      }
    }
    
    for (int i = 1; i < s.length(); i++) {
      for (int j = 1; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          longest[i][j] = longest[i - 1][j - 1] + 1;
        } else {
          longest[i][j] = Math.max(longest[i][j - 1], longest[i - 1][j]);
        }
      }
    }
    
    return longest[s.length() - 1][t.length() - 1];
  }
  
  public static void main(String[] args) {
    LongestCommonSubsequence t = new LongestCommonSubsequence();
    String s1 = "student";
    String s2 = "swedenasyt";
    System.out.println(t.longest(s1, s2));
  }
}