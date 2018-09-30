package array;

public class BombEnemy {
  
  public int maxKilledEnemies(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    
    int rows = 0;
    int[] columns = new int[grid[0].length];
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (j == 0 || grid[i][j - 1] == 'W') {
          rows = 0;
          for (int k = j; k < grid[0].length && grid[i][k] != 'W'; k++) {
            if (grid[i][k] == 'E') {
              rows++;
            }
            j++;
          }
        }
        if (i == 0 || grid[i - 1][j] == 'W') {
          columns[j] = 0;
          for (int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
            if (grid[k][j] == 'E') {
              columns[j]++;
            }
          }
        }
        
        if (grid[i][j] == '0') {
          result = Math.max(result, rows + columns[j]);
        }
      }
    }
    
    return result;
  }
}