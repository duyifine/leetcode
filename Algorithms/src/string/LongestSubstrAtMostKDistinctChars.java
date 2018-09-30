package string;

import java.util.HashMap;

public class LongestSubstrAtMostKDistinctChars {
  
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) {
      return 0;
    }
    
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int result = 0;
    while (right < s.length()) {
      if (!map.containsKey(s.charAt(right))) {
        map.put(s.charAt(right), 1);
      } else {
        map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
      }
      
      if (map.size() > k) {
        result = Math.max(result, right - left);
        while (map.size() > k) {
          char c = s.charAt(left);
          if (map.get(c) == 1) {
            map.remove(c);
          } else {
            map.put(c, map.get(c) - 1);
          }
          left++;
        }
      }
    }
    
    result = Math.max(result, right - left);
    return result;
  }
}