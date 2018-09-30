package string;

public class LongestRepeatingSubstr {
  
  public int[] findSubstr(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    
    int slow = 0;
    int fast = 1;
    int longest = 1;
    int length = 1;
    int[] result = new int[2];
    result[0] = 0;
    result[1] = 1;
    while (fast < s.length()) {
      if (s.charAt(fast) == s.charAt(slow)) {
        fast++;
        length++;
      } else {
        if (length > longest) {
          longest = length;
          result[0] = slow;
          result[1] = longest;
        }
        slow = fast;
        fast++;
        length = 1;
      }
    }
    
    if (result[1] < length) {
      result[0] = slow;
      result[1] = length;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    String s1 = "AAbbbbbike";
    String s2 = "aaaaaa";
    String s3 = "abde";
    String s4 = "aaabcdeeeee";
    LongestRepeatingSubstr l =  new LongestRepeatingSubstr();
    int[] r1 = l.findSubstr(s1);
    for (int i : r1) {
      System.out.println(i);
    }
    int[] r2 = l.findSubstr(s2);
    for (int i : r2) {
      System.out.println(i);
    }
    int[] r3 = l.findSubstr(s3);
    for (int i : r3) {
      System.out.println(i);
    }
    int[] r4 = l.findSubstr(s4);
    for (int i : r4) {
      System.out.println(i);
    }
  }
}