package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RectangleInMatrix {
  
  public boolean isRectangle(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    
    int rows = matrix.length;
    int columns = matrix[0].length;
    
    HashMap<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns - 1; j++) {
        for (int k = j + 1; k < columns; k++) {
          if (matrix[i][j] == 1 && matrix[i][k] == 1) {
            if (map.containsKey(j) && map.get(j).contains(k)) {
              return true;
            }
            if (map.containsKey(k) && map.get(k).contains(j)) {
              return true;
            }
            
            if (!map.containsKey(j)) {
              map.put(j, new HashSet<Integer>());
            }
            map.get(j).add(k);
            if (!map.containsKey(k)) {
              map.put(k, new HashSet<Integer>());
            }
            map.get(k).add(j);
          }
        }
      }
    }
    
    return false;
  }
}