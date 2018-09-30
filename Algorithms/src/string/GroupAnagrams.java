package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  
  public List<List<String>> group(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }
    
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] array = str.toCharArray();
      Arrays.sort(array);
      String keyStr = String.valueOf(array);
      if (!map.containsKey(keyStr)) {
        map.put(keyStr, new ArrayList<>());
      }
      map.get(keyStr).add(str);
    }
    
    String s1 = new String("haha");
    String s2 = new String("haha");
    if (s1 == s2) {
      System.out.println("true");
    }
    
    return new ArrayList<List<String>>(map.values());
  }
  
  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "ate", "nat", "tan", "bat"};
    GroupAnagrams g = new GroupAnagrams();
    System.out.println(g.group(strs));
  }
}