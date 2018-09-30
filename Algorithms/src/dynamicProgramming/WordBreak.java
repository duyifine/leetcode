package dynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
  
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return false;
    }
    
    boolean[] canBreak = new boolean[s.length()];
    HashSet<String> set = new HashSet<>();
    for (String w : wordDict) {
      set.add(w);
    }
    
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.substring(0, i + 1))) {
        canBreak[i] = true;
        continue;
      }
      
      for (int j = 0; j < i; j++) {
        if (canBreak[j] && set.contains(s.substring(j + 1, i + 1))) {
          canBreak[i] = true;
          break;
        }
      }
    }
    return canBreak[s.length() - 1];
  }
  
}