package recursion;

import java.util.ArrayList;
import java.util.List;

public class MirrorNumbers {
  
  int[] digits = {0, 1, 6, 8, 9};
  public List<String> mirrorNumber(int digitNum) {
    List<String> result = new ArrayList<>();
    if (digitNum <= 0) {
      return result;
    }
    
    StringBuilder sb = new StringBuilder();
    helper(digitNum, 0, sb, result);
    
    return result;
  }
  
  public void helper(int digitNum, int index, StringBuilder sb, List<String> result) {
    String tmp = sb.toString();
    if (tmp.length() > 0 && (tmp.charAt(0) != tmp.charAt(tmp.length() - 1) || tmp.length() == 1)) {
      result.add(tmp);
    }
    if (index == digitNum) {
      return;
    }
    
    int len = sb.length();
    for (int i : digits) {
      if ((index == 0 || index == digitNum -1) && i == 0) continue;
      sb.append(i);
      helper(digitNum, index + 1, sb, result);
      sb.setLength(len);
    }
  }
  
  public static void main(String[] args) {
    MirrorNumbers t = new MirrorNumbers();
    System.out.println(t.mirrorNumber(3));
  }
}