package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {
  
  public List<String> removeInvalidParentheses(String s) {
    HashSet<String> result = new HashSet<>();
    if (s == null || s.length() == 0) return new ArrayList<String>();
    
    int leftLimit = 0;
    int rightLimit = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        leftLimit++;
      } else if (s.charAt(i) == ')' && leftLimit > 0) {
        leftLimit--;
      } else if (s.charAt(i) == ')' && leftLimit == 0) {
        rightLimit++;
      }
    }
    
    StringBuilder sb = new StringBuilder();
    helper(s, 0, leftLimit, rightLimit, result, sb, 0);
    return new ArrayList<String>(result);
  }
  
  public void helper(String s, int index, int leftLimit, int rightLimit, HashSet<String> result, StringBuilder sb, int open) {
    if (leftLimit < 0 || rightLimit < 0 || open < 0) return;
    
    if (index == s.length()) {
      if (leftLimit == 0 && rightLimit == 0 && open == 0) {
        result.add(sb.toString());
      }
      return;
    }
    
    int len = sb.length();
    if (s.charAt(index) == '(') {
      helper(s, index + 1, leftLimit - 1, rightLimit, result, sb, open);
      helper(s, index + 1, leftLimit, rightLimit, result, sb.append('('), open + 1);
    } else if (s.charAt(index) == ')') {
      helper(s, index + 1, leftLimit, rightLimit - 1, result, sb, open);
      helper(s, index + 1, leftLimit, rightLimit, result, sb.append(')'), open - 1);
    } else {
      helper(s, index + 1, leftLimit, rightLimit, result, sb.append(s.charAt(index)), open);
    }
    sb.setLength(len);
  }
}