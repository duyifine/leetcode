package airbnb;

import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
  
  public int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    
    Deque<Integer> stack = new LinkedList<>();
    char ops = '+';
    for (int i = 0; i < s.length(); i++) {
      int num = 0;
      if (s.charAt(i) == ' ') continue;
      while (i < s.length() && Character.isDigit(s.charAt(i))) {
        num = num * 10 + s.charAt(i) - '0';
        i++;
      }
      if (ops == '+') {
        stack.offerFirst(num);
      } else if (ops == '-') {
        stack.offerFirst(-num);
      } else if (ops == '*') {
        int top = stack.pollFirst();
        stack.offerFirst(top * num);
      } else if (ops == '/') {
        int top = stack.pollFirst();
        stack.offerFirst(top / num);
      }
      
      if (i < s.length()) {
        ops = s.charAt(i);
      }
    }
    
    int sum = 0;
    while (!stack.isEmpty()) {
      sum = sum + stack.pollFirst();
    }
    
    return sum;
  }
}