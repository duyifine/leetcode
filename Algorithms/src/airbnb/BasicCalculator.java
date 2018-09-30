package airbnb;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
  
  public int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    
    Deque<Integer> stack = new LinkedList<>();
    int sign = 1;
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') continue;
      int num = 0;
      while (i < s.length() && Character.isDigit(s.charAt(i))) {
        num = num * 10 + s.charAt(i) - '0';
        i++;
      }
      result = result * sign;
      if (i < s.length() && s.charAt(i) == '+') {
        sign = 1;
      } else if (i < s.length() && s.charAt(i) == '-') {
        sign = -1;
      } else if (i < s.length() && s.charAt(i) == '(') {
        stack.offerFirst(result);
        stack.offerFirst(sign);
        result = 0;
        sign = 1;
      } else if (i < s.length() && s.charAt(i) == ')') {
        result = result * stack.pollFirst() + stack.pollFirst();
      }
    }
    
    return result;
  }
}