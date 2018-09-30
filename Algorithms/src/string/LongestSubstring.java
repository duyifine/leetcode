package string;

import java.util.HashSet;

public class LongestSubstring {
  
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    
    int slow = 0;
    int fast = 0;
    int result = 0;
    HashSet<Character> set = new HashSet<Character>();
    while (fast < s.length()) {
      if (!set.contains(s.charAt(fast))) {
        set.add(s.charAt(fast));
        fast++;
      } else {
        result = Math.max(result, fast - slow);
        set.remove(s.charAt(slow));
        slow++;
      }
    }
    
    result = Math.max(result, fast - slow);
    return result;
  }
  
  public static void main(String[] args) {
    String s = "abcabcbb";
    LongestSubstring l = new LongestSubstring();
    System.out.println(l.lengthOfLongestSubstring(s));
    String s2 = "abcde";
    System.out.println(l.lengthOfLongestSubstring(s2));
  }
}