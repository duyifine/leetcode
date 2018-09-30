package stack;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
  public boolean isValid(String s) {
    if (s == null || s.length() == 0) return true;
    
    Deque<Character> stack = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.offerFirst(c);
      } else if (c == ')') {
        if (stack.isEmpty() || stack.peekFirst() != '(') {
          return false;
        } else {
          stack.pollFirst();
        }
      } else if (c == ']') {
        if (stack.isEmpty() || stack.peekFirst() != '[') {
          return false;
        } else {
          stack.pollFirst();
        }
      } else if (c == '}') {
        if (stack.isEmpty() || stack.peekFirst() != '{') {
          return false;
        } else {
          stack.pollFirst();
        }
      }
    }
    
    if (stack.isEmpty()) return true;
    return false;
  }
}