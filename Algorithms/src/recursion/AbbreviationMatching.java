package recursion;

public class AbbreviationMatching {
 
  public boolean match(String input, String pattern) {
    return match(input, pattern, 0, 0);
  }
  
  public boolean match(String s, String t, int si, int ti) {
    if (si == s.length() && ti == t.length()) {
      return true;
    }
    if (si >= s.length() || ti >= t.length()) {
      return false;
    }
    
    if (!isDigit(t.charAt(ti))) {
      if (s.charAt(si) != t.charAt(ti)) {
        return false;
      }
      return match(s, t, si + 1, ti + 1);
    }
    int count = 0;
    while (isDigit(t.charAt(ti))) {
      count = count * 10 + t.charAt(ti) - '0';
      ti++;
    }
    return match(s, t, si + count, ti);
  }
  
  public boolean isDigit(char c) {
    if (c - '0' >= 0 && c - '9' <=0) {
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    String input = "sophisticated";
    String pattern = "s11d";
    AbbreviationMatching a = new AbbreviationMatching();
    System.out.println(a.match(input, pattern));
  }
}