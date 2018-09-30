package dynamicProgramming;

public class MinPathSum {
  
  public int minPathSum(int[][] grid) {
    if (grid == null || (grid.length == 0 && grid[0].length == 0)) {
      return 0;
    }
    
    int m = grid.length;
    int n = grid[0].length;
    int[][] minPath = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          if (j == 0) {
            minPath[i][j] = grid[0][0];
          } else {
            minPath[i][j] = grid[i][j] + minPath[i][j - 1];
          }
        } else if (j == 0) {
          minPath[i][j] = grid[i][j] + minPath[i - 1][j];
        } else {
          minPath[i][j] = Math.min(minPath[i][j - 1], minPath[i - 1][j]) + grid[i][j];
        }
      }
    }
    
    return minPath[m - 1][n - 1];
  }
  
  public static void main(String[] args) {
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    MinPathSum m = new MinPathSum();
    System.out.println(m.minPathSum(grid));
  }
}