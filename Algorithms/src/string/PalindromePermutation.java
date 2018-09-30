package string;

import java.util.HashMap;

public class PalindromePermutation {
  
  public boolean canPermutePalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), 1);
      } else {
        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
      }
    }
    
    boolean hasOdd = false;
    for (Character c : map.keySet()) {
      if (map.get(c) % 2 == 1) {
        if (!hasOdd) {
          hasOdd = true;
        } else {
          return false;
        }
      }
    }
    
    return true;
  }
}