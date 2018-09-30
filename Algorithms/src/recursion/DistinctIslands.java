package recursion;

import java.util.HashSet;

public class DistinctIslands {
  
  public int numDistinctIslands(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          StringBuilder sb = new StringBuilder();
          dfs(grid, i, j, sb, "o");
          set.add(sb.toString());
        }
      }
    }
    
    return set.size();
  }
  
  public void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
    if (i < 0 || i > grid.length || j < 0 || j > grid[0].length || grid[i][j] == 0) {
      return;
    }
    
    sb.append(dir);
    grid[i][j] = 0;
    dfs(grid, i - 1, j, sb, "l");
    dfs(grid, i + 1, j, sb, "r");
    dfs(grid, i, j - 1, sb, "u");
    dfs(grid, i, j + 1, sb, "d");
    sb.append("b");
  }
}