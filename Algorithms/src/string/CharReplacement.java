package string;

import java.util.ArrayList;
import java.util.List;

public class CharReplacement {
  
  public String replace(String input, String s, String t) {
    if (input == null || input.length() == 0) {
      return input;
    }
    
    if (s.length() >= t.length()) {
      return replaceFromLeft(input, s, t);
    } else {
      return replaceFromRight(input, s, t);
    }
  }
  
  public String replaceFromLeft(String input, String s, String t) {
    char[] array = input.toCharArray();
    int slow = 0;
    int fast = 0;
    while (fast < input.length()) {
      if (array[fast] == s.charAt(0) && fast + s.length() < input.length()) {
        int i = 0;
        while (i < s.length()) {
          if (array[fast + i] == s.charAt(i)) {
            i++;
          }
        }
        if (i == s.length()) {
          for (int j = 0; j < t.length(); j++) {
            array[slow++] = t.charAt(j);
          }
          fast = fast + s.length();
        }
      } else {
        array[slow++] = array[fast++];
      }
    }
    return new String(array, 0, slow);
  }
  
  public String replaceFromRight(String input, String s, String t) {
    char[] array = input.toCharArray();
    List<Integer> indexes = new ArrayList<Integer>();
    int fast = 0;
    while (fast < input.length() - s.length()) {
      if (array[fast] == s.charAt(0)) {
        int i = 0;
        while (i < s.length()) {
          if (array[fast + i] == s.charAt(i)) {
            i++;
          }
        }
        if (i == s.length()) {
          indexes.add(fast + s.length() - 1);
        }
        fast = fast + s.length();
      } else { 
        fast++;
      }
    }
    
    int newLength = input.length() + indexes.size() * (t.length() - s.length());
    char[] result = new char[newLength];
    int lastIndex = indexes.size() - 1;
    int slow = newLength - 1;
    int curIndex = array.length - 1;
    while (curIndex >= 0) {
      if (lastIndex >=0 && curIndex == indexes.get(lastIndex)) {
        for (int j = t.length() - 1; j >= 0; j--) {
          result[slow--] = t.charAt(j);
        }
        lastIndex--;
        curIndex = curIndex - s.length();
      } else {
        result[slow--] = array[curIndex--];
      }
    }
    
    return new String(result);
  }
  
  public static void main(String[] args) {
    String input1 = "student";
    String s1 = "den";
    String t1 = "ha";
    CharReplacement c = new CharReplacement();
    System.out.println(c.replace(input1, s1, t1));
    String input2 = "www.yahoo.com/?q=m/?p=n";
    String s2 = "/?";
    String t2 = "20%";
    System.out.println(c.replace(input2, s2, t2));
  }
}