package string;

import java.util.HashSet;

public class LongestSubstringUniqueChars {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    
    HashSet<Character> set = new HashSet<>();
    int result = 0;
    int start = 0;
    int end = 0;
    while (end < s.length()) {
      if (!set.contains(s.charAt(end))) {
        end++;
        set.add(s.charAt(end));
      } else {
        result = Math.max(result, end - start);
        set.remove(s.charAt(start));
        start++;
      }
    }
    
    result = Math.max(result, end - start);
    return result;
  }
}