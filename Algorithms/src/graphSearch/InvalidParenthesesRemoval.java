package graphSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvalidParenthesesRemoval {
  
  public List<String> removeInvalidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    
    int leftRmLimit = 0;
    int rightRmLimit = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        leftRmLimit++;
      } else if (s.charAt(i) == ')' && leftRmLimit > 0) {
        leftRmLimit--;
      } else if (s.charAt(i) == ')' && leftRmLimit == 0) {
        rightRmLimit++;
      }
    }
    
    Set<String> result = new HashSet<String>();
    StringBuilder st = new StringBuilder();
    helper(s, 0, leftRmLimit, rightRmLimit, result, st, 0);
    return new ArrayList<String>(result);
  }
  
  public void helper(String s, int index, int leftRmLimit, int rightRmLimit, Set<String> result, StringBuilder st, int openParens) {
    if (leftRmLimit < 0 || rightRmLimit < 0 || openParens < 0) {
      return;
    }
    if (index == s.length()) {
      if (leftRmLimit == 0 && rightRmLimit == 0 && openParens == 0) {
        result.add(st.toString());
      }
      return;
    }
    
    int len = st.length();
    if (s.charAt(index) == '(') {
      helper(s, index + 1, leftRmLimit - 1, rightRmLimit, result, st, openParens);
      helper(s, index + 1, leftRmLimit, rightRmLimit, result, st.append(s.charAt(index)), openParens + 1);
    } else if (s.charAt(index) == ')') {
      helper(s, index + 1, leftRmLimit, rightRmLimit - 1, result, st, openParens);
      helper(s, index + 1, leftRmLimit, rightRmLimit, result, st.append(s.charAt(index)), openParens - 1);
    } else {
      helper(s, index + 1, leftRmLimit, rightRmLimit, result, st.append(s.charAt(index)), openParens);
    }
    st.setLength(len);
  }
  
  public static void main(String[] args) {
    InvalidParenthesesRemoval t = new InvalidParenthesesRemoval();
    String s = "()())()";
    System.out.println(t.removeInvalidParentheses(s));
  }
}