package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindKLengthSubstr {
  
  public List<String> findKLength(String s, int k) {
    if (s == null || s.length() == 0 || k == 0 || k > s.length()) {
      return null;
    }
    
    List<String> result = new ArrayList<String>();
    HashSet<String> set = new HashSet<String>();
    int i = 0;
    while (i <= s.length() - k) {
      if (!set.contains(s.substring(i, i + k))) {
        result.add(s.substring(i, i + k));
        set.add(s.substring(i, i + k));
      }
//      while (i <= s.length() - k - 1 && s.charAt(i + 1) == s.charAt(i) && s.charAt(i + k) == s.charAt(i + k - 1)) {
//        i++;
//      }
      i++;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    String s = "caaab";
    FindKLengthSubstr f = new FindKLengthSubstr();
    System.out.println(f.findKLength(s, 2));
    String s2 = "caaabaaacaa";
    System.out.println(f.findKLength(s2, 3));
  }
}