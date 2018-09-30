package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
  int[] father;
  public void union(int index1, int index2) {
    int root1 = find(index1);
    int root2 = find(index2);
    if (root1 == root2) return;
    father[root1] = root2;
  }
  
  public int find(int index) {
    if (father[index] != index) {
      father[index] = find(father[index]);
    }
    return father[index];
  }
  
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    if (m <= 0 || n <= 0 || positions == null || positions.length == 0) {
      return result;
    }
    
    father = new int[m * n];
    int count = 0;
    int[][] matrix = new int[m][n];
    for (int[] position : positions) {
      int x = position[0];
      int y = position[1];
      int index = x * n + y;
      father[index] = index;
      matrix[x][y] = 1;
      count++;
      for (int i = 0; i < 4; i++) {
        int x1 = x + dx[i];
        int y1 = y + dy[i];
        if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] == 1) {
          if (find(x1 * n + y1) != find(index)) {
            count--;
            union(index, x1 * n + y1);
          }
        }
      }
      result.add(count);
    }
    
    return result;
  }
}