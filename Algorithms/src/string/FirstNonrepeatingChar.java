package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class FirstNonrepeatingChar {
  
  public int firstNonrepeating(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }
    HashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
    HashSet<Character> set = new HashSet<Character>();
    for (int i = 0; i < s.length(); i++) {
      if (!set.contains(s.charAt(i))) {
        set.add(s.charAt(i));
        map.put(s.charAt(i), i);
      } else {
        if (map.containsKey(s.charAt(i))) {
          map.remove(s.charAt(i));
        }
      }
    }
    
    if (map.size() == 0) {
      return -1;
    } else {
      return map.entrySet().iterator().next().getValue();
    }
  }
  
  public int findFirst(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }
    
    int[] freq = new int[256];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (freq[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    String s = "loveleetcode";
    FirstNonrepeatingChar f = new FirstNonrepeatingChar();
    System.out.println(f.firstNonrepeating(s));
    System.out.println(f.findFirst(s));
  }
}