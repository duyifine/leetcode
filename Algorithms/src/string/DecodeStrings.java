package string;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeStrings {
  
  /**
   * s = "3[a]2[bc]", return "aaabcbc".
     s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
   * @param s
   * @return
   */ 
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    
    Deque<String> strStack = new LinkedList<>();
    Deque<Integer> countStack = new LinkedList<>();
    strStack.offerFirst("");
    int i = 0;
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int count = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          count = count * 10 + s.charAt(i) - '0';
          i++;
        }
        countStack.offerFirst(count);
      } else if (s.charAt(i) == '[') {
        strStack.offerFirst("");
        i++;
      } else if (s.charAt(i) == ']') {
        String top = strStack.pollFirst();
        int repeating = countStack.pollFirst();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < repeating; j++) {
          sb.append(top);
        }
        String pre = strStack.pollFirst();
        strStack.offerFirst(pre + sb.toString());
        i++;
      } else {
        String pre = strStack.pollFirst();
        strStack.offerFirst(pre + s.charAt(i));
        i++;
      }
    }
    
    return strStack.pollFirst();
  }
  
  public String decode(String s) {
    if (s == null || s.length() == 0) return "";
    
    Deque<String> strStack = new LinkedList<>();
    Deque<Integer> numStack = new LinkedList<>();
    strStack.offerFirst("");
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int count = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          count = count * 10 + s.charAt(i) - '0';
          i++;
        }
        numStack.offerFirst(count);
      } else if (c == '[') {
        strStack.offerFirst("");
        i++;
      } else if (c == ']') {
        String top = strStack.pollFirst();
        int repeating = numStack.pollFirst();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < repeating; j++) {
          sb.append(top);
        }
        String pre = strStack.pollFirst();
        strStack.offerFirst(pre + sb.toString());
        i++;
      } else {
        String pre = strStack.pollFirst();
        strStack.offerFirst(pre + c);
        i++;
      }
    }
    
    return strStack.pollFirst();
  }
}