package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PyramidTransitionMatrix {
  
  public boolean pyrimadTransition(String bottom, List<String> allowed) {
    if (bottom == null || bottom.length() == 0 || allowed == null || allowed.size() == 0) return false;
    
    HashMap<String, List<String>> map = new HashMap<>();
    for (String a : allowed) {
      String key = a.substring(0, 2);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(a.substring(2));
    }
    
    if (bottom.length() == 2) {
      return map.containsKey(bottom);
    }
    
    return helper(bottom, 0, map, "");
  }
  
  public boolean helper(String bottom, int index, HashMap<String, List<String>> map, String nextLevel) {
    if (bottom == null) return false;
    if (bottom.length() == 1) return true;
    
    if (index == bottom.length() - 1) return helper(nextLevel, 0, map, "");
    
    String key = bottom.substring(index, index + 2);
    if (!map.containsKey(key)) return false;
    List<String> values = map.get(key);
    for (String value : values) {
      if (helper(bottom, index + 1, map, nextLevel + value)) {
        return true;
      }
    }
    
    return false;
  }
}