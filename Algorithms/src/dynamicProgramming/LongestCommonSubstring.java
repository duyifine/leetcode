package dynamicProgramming;

public class LongestCommonSubstring {
  
  public String longestCommon(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return null;
    }
    
    int[][] commonLength = new int[s.length()][t.length()];
    for (int i = 0; i < t.length(); i++) {
      if (s.charAt(0) == t.charAt(i)) {
        commonLength[0][i] = 1;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (t.charAt(0) == s.charAt(i)) {
        commonLength[i][0] = 1;
      }
    }
    
    int longest = 0;
    String result = "";
    for (int i = 1; i < s.length(); i++) {
      for (int j = 1; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          commonLength[i][j] = commonLength[i - 1][j - 1] + 1;
          if (commonLength[i][j] > longest) {
            longest = commonLength[i][j];
            result = s.substring(i - longest + 1, i + 1);
          }
        } else {
          commonLength[i][j] = 0;
        }
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    LongestCommonSubstring t = new LongestCommonSubstring();
    String s1 = "densew";
    String s2 = "student";
    System.out.println(t.longestCommon(s1, s2));
  }
}