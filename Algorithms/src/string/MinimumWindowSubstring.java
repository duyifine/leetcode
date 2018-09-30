package string;

import java.util.HashMap;

public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
      return "";
    }
    
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      if (!map.containsKey(t.charAt(i))) {
        map.put(t.charAt(i), 1);
      }
      map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
    }
    
    int count = map.size();
    int start = 0;
    int end = 0;
    String result = "";
    int min = Integer.MAX_VALUE;
    while (end < s.length()) {
      if (map.containsKey(s.charAt(end))) {
        map.put(s.charAt(end), map.get(s.charAt(end) - 1));
        if (map.get(s.charAt(end)) == 0) {
          count--;
        }
      }
      end++;
      while (count == 0) {
        if (end - start < min) {
          min = end - start;
          result = s.substring(start, end);
        }
        if (map.containsKey(s.charAt(start))) {
          map.put(s.charAt(start), map.get(s.charAt(start) + 1));
          if (map.get(s.charAt(start)) > 0) {
            count++;
          }
        }
        start++;
      }
    }
    
    return result;
  }
  
  public String slidingWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 ||t.length() == 0) return "";
    
    HashMap<Character, Integer> map = new HashMap<>();
    int count = 0;
    for (char c : t.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, 1);
        count++;
      } else {
        map.put(c, map.get(c) + 1);
      }
    }
    
    int i = 0;
    int j = 0;
    int min = Integer.MAX_VALUE;
    String result = "";
    while (j < s.length()) {
      if (map.containsKey(s.charAt(j))) {
        map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
        if (map.get(s.charAt(j)) == 0) count--;
      }
      j++;
      
      while (count == 0) {
        if (j - i < min) {
          min = j - i;
          result = s.substring(i, j);
        }
        if (map.containsKey(s.charAt(i))) {
          map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
          if (map.get(s.charAt(i)) > 0) count++;
        }
        i++;
      }
    }
    
    return result;
  }
}