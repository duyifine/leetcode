package string;

import java.util.HashMap;

public class AnagramValidation {
  
  public boolean isAnagram(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }
    
    HashMap<Character, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (!map.containsKey(s1.charAt(i))) {
        map.put(s1.charAt(i), 1);
        count++;
      } else {
        map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
      }
    }
    
    for (int i = 0; i < s2.length(); i++) {
      if (map.containsKey(s2.charAt(i))) {
        map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
        if (map.get(s2.charAt(i)) == 0) {
          count--;
        }
      }
    }
    
    if (count == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  public static void main(String[] args) {
    String s1 = "test";
    String s2 = "ttew";
    String s3 = "estt";
    AnagramValidation a = new AnagramValidation();
    System.out.println(a.isAnagram(s1, s2));
    System.out.println(a.isAnagram(s1, s3));
  }
}