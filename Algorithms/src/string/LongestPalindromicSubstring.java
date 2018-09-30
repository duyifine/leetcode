package string;

public class LongestPalindromicSubstring {
  
  public String longestPalindrom(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    if (s.length() == 1) {
      return s;
    }
    
    String result = s.substring(0,1);
    for (int i = 0; i < s.length(); i++) {
      String tmp = helper(s, i, i);
      if (tmp.length() > result.length()) {
        result = tmp;
      }
      tmp = helper(s, i, i + 1);
      if (tmp.length() > result.length()) {
        result = tmp;
      }
    }
    return result;
  }
  
  public String helper(String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    return s.substring(start + 1, end);
  }
}