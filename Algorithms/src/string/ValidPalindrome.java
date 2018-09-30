package string;

public class ValidPalindrome {
  
  public boolean isPalindrome(String s) {
    if (s == null) return false;
    if (s.length() == 0) return true;
    
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (!Character.isLetterOrDigit(s.charAt(i))) i++;
      if (!Character.isLetterOrDigit(s.charAt(j))) j--;
      if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))) {
        if (Character.isLetterOrDigit(s.charAt(i)) != Character.isLetterOrDigit(s.charAt(j))) {
          return false;
        }
        i++;
        j--;
      }
    }
    
    return true;
  }
}