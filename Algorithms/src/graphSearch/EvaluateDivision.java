package graphSearch;

import java.util.HashMap;
import java.util.HashSet;

public class EvaluateDivision {
  
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    double[] result = new double[queries.length];
    if (equations == null || values == null) {
      return result;
    }
    
    HashMap<String, HashMap<String, Double>> map = new HashMap<>();
    for (int i = 0; i < equations.length; i++) {
      for (int j = 0; j < equations[0].length; j++) {
        String a = equations[i][0];
        String b = equations[i][1];
        if (!map.containsKey(a)) {
          map.put(a, new HashMap<>());
        }
        map.get(a).put(b, values[i]);
        if (!map.containsKey(b)) {
          map.put(b, new HashMap<>());
        }
        map.get(b).put(a, 1.0 / values[i]);
      }
    }
    
    for (int i = 0; i < queries.length; i++) {
      result[i] = dfs(queries[i][0], queries[i][1], map, new HashSet<String>());
    }
    
    return result;
  }
  
  public double dfs(String a, String b, HashMap<String, HashMap<String, Double>> map, HashSet<String> visited) {
    double res = -1.0;
    String key = a + "/" + b;
    if (visited.contains(key)) {
      return -1.0;
    }
    if (!map.containsKey(a) || !map.containsKey(b)) {
      return -1.0;
    }
    if (a.equals(b)) {
      return 1.0;
    }
    
    HashMap<String, Double> valueMap = map.get(a);
    visited.add(key);
    for (String denom : valueMap.keySet()) {
      double result = dfs(denom, b, map, visited);
      if (result != -1.0) {
        res = result * valueMap.get(denom);
      }
    }
    visited.remove(key);
    return res;
  }
}