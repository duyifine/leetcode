package graphSearch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Parenthesis {
  
  public List<List<String>> permute(int k) {
    List<List<String>> result = new ArrayList<List<String>>();
    if (k == 0) {
      return result;
    }
    
    List<String> tmpList = new ArrayList<>();
    helper(k, k, result, tmpList);
    return result;
  }
  
  public void helper(int left, int right, List<List<String>> result, List<String> tmpList) {
    if (left == 0 && right == 0) {
      result.add(new ArrayList<>(tmpList));
      return;
    }
    
    if (left != 0) {
      tmpList.add("(");
      helper(left - 1, right, result, tmpList);
      tmpList.remove(tmpList.size() - 1);
    }
    if (right > left) {
      tmpList.add(")");
      helper(left, right - 1, result, tmpList);
      tmpList.remove(tmpList.size() - 1);
    }
  }
  
  public boolean isParenthesisValid(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    
    Deque<Character> stack = new LinkedList<Character>();
    Map<Character, Character> map = new HashMap<Character, Character>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        stack.offerFirst(s.charAt(i));
      } else {
        if (stack.isEmpty() || map.get(stack.pollFirst()) != s.charAt(i)) {
          return false;
        }
      }
    }
    if (stack.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean checkValidString(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else {
        count--;
        if (count < 0) {
          return false;
        }
      }
    }
    if (count == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean checkValidStringWithStar(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    
    return check(s, 0, 0);
  }
  
  public boolean check(String s, int start, int count) {
    if (count < 0) {
      return false;
    }
    
    for (int i = start; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
        if (count < 0) {
          return false;
        }
      } else {
        return check(s, i + 1, count - 1) || check(s, i + 1, count + 1) || check(s, i + 1, count);
      }
    }
    if (count == 0) {
      return true;
    } else {
      return false;
    }
  }
  
  public List<List<String>> validParentheses(int l, int m, int n) {
    List<List<String>> result = new ArrayList<List<String>>();
    if (l == 0 && m == 0 && n == 0) {
      return result;
    }
    
    List<String> tmpList = new ArrayList<>();
    Deque<String> stack = new LinkedList<String>();
    int length = 2 * (l + m + n);
    validParentheses(l, m, n, result, tmpList, stack, length);
    return result;
  }
  
  public void validParentheses(int l, int m, int n, List<List<String>> result, List<String> tmpList, Deque<String> stack, int length) {
    if (tmpList.size() == length) {
      result.add(new ArrayList<>(tmpList));
      return;
    }
    
    if (l > 0) {
      tmpList.add("(");
      stack.offerFirst("(");
      validParentheses(l - 1, m, n, result, tmpList, stack, length);
      tmpList.remove(tmpList.size() - 1);
      stack.pollFirst();
    }
    if (m > 0) {
      tmpList.add("[");
      stack.offerFirst("[");
      validParentheses(l, m - 1, n, result, tmpList, stack, length);
      tmpList.remove(tmpList.size() - 1);
      stack.pollFirst();
    }
    if (n > 0) {
      tmpList.add("{");
      stack.offerFirst("{");
      validParentheses(l, m, n - 1, result, tmpList, stack, length);
      tmpList.remove(tmpList.size() - 1);
      stack.pollFirst();
    }
    if (!stack.isEmpty()) {
      if (stack.peekFirst() == "(") {
        stack.pollFirst();
        tmpList.add(")");
        validParentheses(l, m, n, result, tmpList, stack, length);
        tmpList.remove(tmpList.size() - 1);
        stack.offerFirst("(");
      } else if (stack.peekFirst() == "[") {
        stack.pollFirst();
        tmpList.add("]");
        validParentheses(l, m, n, result, tmpList, stack, length);
        tmpList.remove(tmpList.size() - 1);
        stack.offerFirst("[");
      } else if (stack.peekFirst() == "{"){
        stack.pollFirst();
        tmpList.add("}");
        validParentheses(l, m, n, result, tmpList, stack, length);
        tmpList.remove(tmpList.size() - 1);
        stack.offerFirst("{");
      }
    }
  }
  
  public static void main(String[] args) {
    Parenthesis p = new Parenthesis();
    System.out.println(p.permute(3));
    String s = "(){[]}";
    System.out.println(p.isParenthesisValid(s));
    String s1 = "())";
    System.out.println(p.isParenthesisValid(s1));
    String s2 = "())";
    System.out.println(p.checkValidString(s2));
    String s3 = ")(";
    System.out.println(p.checkValidString(s3));
    String s4 = "()";
    System.out.println(p.checkValidString(s4));
    String s5 = "(*))";
    System.out.println(p.checkValidStringWithStar(s5));
    System.out.println(p.checkValidStringWithStar(s3));
    System.out.println(p.validParentheses(1, 1, 1));
  }
}