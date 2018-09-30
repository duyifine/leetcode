package graphSearch;

public class ValidParenthesisString {
  
  public boolean checkValidString(String s) {
    if (s == null || s.length() == 0) return true;
    
    return helper(s, 0, 0);
  }
  
  public boolean helper(String s, int start, int count) {
    if (count < 0) return false;
    
    for (int i = start; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
        if (count < 0) return false;
      } else {
        return helper(s, i + 1, count) || helper(s, i + 1, count - 1) || helper(s, i + 1, count + 1);
      }
    }
    
    if (count == 0) {
      return true;
    }
    return false;
  }
}