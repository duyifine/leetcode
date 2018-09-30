package string;

import java.util.Deque;
import java.util.LinkedList;

public class CalculatorII {
  public int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    
    int num = 0;
    char op = '+';
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') continue;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i) - '0';
            i++;
        }
        System.out.println("num=" + num);
        if (op == '+') {
          stack.offerFirst(num);
      } else if (op == '-') {
          stack.offerFirst(-num);
      } else if (op == '*') {
          int top = stack.pollFirst();
          stack.offerFirst(top * num);
      } else if (op == '/') {
          int top = stack.pollFirst();
          stack.offerFirst(top / num);
      }
/**        if ((i < s.length() && s.charAt(i) != ' ') || i == s.length()) {
          System.out.println("char=" + s.charAt(i));
            if (op == '+') {
                stack.offerFirst(num);
            } else if (op == '-') {
                stack.offerFirst(-num);
            } else if (op == '*') {
                int top = stack.pollFirst();
                stack.offerFirst(top * num);
            } else if (op == '/') {
                int top = stack.pollFirst();
                stack.offerFirst(top / num);
            } **/
            if (i < s.length()) {
              op = s.charAt(i);
            }
            num = 0;
 //       }
    }
    
    int sum = 0;
    while (!stack.isEmpty()) {
        sum = sum + stack.pollFirst();
    }
    
    return sum;
  }
  
  public static void main(String[] args) {
    CalculatorII c = new CalculatorII();
    String s = " 3/2 ";
    System.out.println(c.calculate(s));
  }
}