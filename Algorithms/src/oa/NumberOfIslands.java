package oa;

public class NumberOfIslands {
  
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          helper(grid, i, j);
          count++;
        }
      }
    }
    
    return count;
  }
  
  public void helper(char[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
    
    grid[r][c] = '0';
    helper(grid, r + 1, c);
    helper(grid, r, c + 1);
    helper(grid, r - 1, c);
    helper(grid, r, c - 1);
  }
}