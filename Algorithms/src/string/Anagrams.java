package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
  
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<Integer>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) {
      return result;
    }
    
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < p.length(); i++) {
      if (map.containsKey(p.charAt(i))) {
        map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
      } else {
        map.put(p.charAt(i), 1);
      }
    }
    
    int slow = 0;
    int fast = 0;
    int count = map.size();
    while (fast < s.length()) {
      if (map.containsKey(s.charAt(fast))) {
        map.put(s.charAt(fast), map.get(s.charAt(fast)) - 1);
        if (map.get(s.charAt(fast)) == 0) {
          count--;
        }
      }
      fast++;
      
      while (count == 0) {
        if (map.containsKey(s.charAt(slow))) {
          map.put(s.charAt(slow), map.get(s.charAt(slow)) + 1);
          if (map.get(s.charAt(slow)) > 0) {
            count++;
          }
        } 
        if (fast - slow == p.length()) {
          result.add(slow);
        }
        slow++;
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    String s = "cbaebabacd";
    String p = "abc";
    Anagrams a = new Anagrams();
    System.out.println(a.findAnagrams(s, p));   
  }
}