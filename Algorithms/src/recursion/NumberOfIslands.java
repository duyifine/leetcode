package recursion;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
  
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
        }
        result++;
      }
    }
    return result;
  }
  
  public void dfs(char[][] grid, int x, int y) {
    if (x == grid.length || y == grid[0].length || x < 0 || y < 0) {
      return;
    }
    
    if (grid[x][y] == '1') {
      grid[x][y] = '0';
      dfs(grid, x + 1, y);
      dfs(grid, x, y + 1);
      dfs(grid, x - 1, y);
      dfs(grid, x, y - 1);
    }
  }
  
  int[] father;
  public int find(int index) {
    if (index == father[index]) {
      return index;
    }
    father[index] = find(father[index]);
    return father[index];
  }
  
  public void union(int index1, int index2) {
    int root1 = find(index1);
    int root2 = find(index2);
    if (root1 == root2) {
      return;
    }
    father[root2] = root1;
  }
  
  int[] dx = {0, 0, -1, 1};
  int[] dy = {1, -1, 0, 0};
  public List<Integer> numIslands2(int n, int m, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    if (n <= 0 || m <= 0 || positions == null || positions.length == 0) {
      return result;
    }
    
    father = new int[m * n];
    int[][] matrix = new int[m][n];
    int count = 0;
    for (int i = 0; i < positions.length; i++) {
      int[] curPos = positions[i];
      int index = curPos[0] *n + curPos[1];
      father[index] = index;
      matrix[curPos[0]][curPos[1]] = 1;
      count++;
      
      for (int j = 0; j < 4; j++) {
        int px = curPos[0] + dx[i];
        int py = curPos[1] + dy[i];
        if (px >= 0 && px < n && py >= 0 && py < m && matrix[px][py] == 1) {
          if (find(index) != find(px * n + py)) {
            count--;
            union(index, px * n + py);
          }
        }
      }
      result.add(count);
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    NumberOfIslands t = new NumberOfIslands();
    int m = 3;
    int n = 3;
    int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
    System.out.println(t.numIslands2(n, m, positions));
  }
}