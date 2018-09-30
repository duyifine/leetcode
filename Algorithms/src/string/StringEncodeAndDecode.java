package string;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeAndDecode {
  
  public String encode(List<String> strs) {
    if (strs == null) {
      return null;
    }
    if (strs.size() == 0) {
      return "";
    }
    
    StringBuilder sb = new StringBuilder();
    for (String str: strs) {
      sb.append(str.length()).append('#').append(str);
    }
    
    return sb.toString();
  }
  
  public List<String> decode(String s) {
    if (s == null) {
      return null;
    }
    if (s == "") {
      return new ArrayList<>();
    }
    
    List<String> result = new ArrayList<>();
    int start = 0;
    int end = 0;
    while (end < s.length()) {
      while (end < s.length() && s.charAt(end) != '#') {
        end++;
      }
      int len = Integer.valueOf(s.substring(start, end));
      result.add(s.substring(end + 1, end + len + 1));
      start = end + len + 1;
      end = start;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    StringEncodeAndDecode t = new StringEncodeAndDecode();
    List<String> strs = new ArrayList<>();
    strs.add("a");
    strs.add("sbc");
    strs.add("bb3#a");
    System.out.println(t.encode(strs));
    System.out.println(t.decode(t.encode(strs)));
  }
}