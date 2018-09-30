package stack;

import java.util.Stack;

public class StringDecode {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
        return "";
    }
    
    Stack<String> strStack = new Stack<>();
    Stack<Integer> countStack = new Stack<>();
    strStack.push("");
    int i = 0;
    while (i < s.length()) {
        if (Character.isDigit(s.charAt(i))) {
            int count = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }
            System.out.println("push " + count + " to the stack");
            countStack.push(count);
        } else if (s.charAt(i) == '[') {
            System.out.println("push " + "" + " to the stack");
            strStack.push("");
            i++;
        } else if (s.charAt(i) == ']') {
            String tmp = strStack.pop();
            if (tmp == null) {
                tmp = "";
            }
            StringBuilder sb = new StringBuilder();
            int repeating = countStack.pop();
            for (int j = 0; j < repeating; j++) {
                sb.append(tmp);
            }
            String pre = strStack.pop();
            System.out.println("push " + pre + sb.toString() + " to the stack");
            strStack.push(pre + sb.toString());
            i++;
        } else {
            String pre = strStack.pop();
            System.out.println("push " + pre + s.charAt(i) + " to the stack");
            strStack.push(pre + s.charAt(i));
            i++;
        }
    }
    
    return strStack.pop();
  }
  
  public static void main(String[] args) {
    StringDecode t = new StringDecode();
    String s = "3[a]2[bc]";
    System.out.println(t.decodeString(s));
  }
}