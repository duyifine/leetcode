package recursion;

public class ThreeColorsMap {
  
  public int[][] generateMap(int m, int n) {
    int[][] result = new int[m][n];
    if (m == 0 || n == 0) {
      return result;
    }
    
    helper(m, n, 0, 0, result);
    return result;
  }
  
  public void helper(int m, int n, int xIndex, int yIndex, int[][] result) {
    if (xIndex == m || yIndex == n) {
      return;
    }
    
    for (int x = xIndex; x < m; x++) {
      for (int y = yIndex; y < n; y++) {
        if (isValid(1, result, x, y)) {
          result[x][y] = 1;
        } else if (isValid(2, result, x, y)) {
          result[x][y] = 2;
        } else if (isValid(3, result, x, y)) {
          result[x][y] = 3;
        }
        helper(m, n, xIndex, yIndex + 1, result);
      }
      helper(m, n, xIndex + 1, 0, result);
    }
  }
  
  public boolean isValid(int val, int[][] matrix, int x, int y) {
    int countX = 0;
    if (x >= 2) {
      for (int i = x - 2; i < x; i++) {
        if (matrix[i][y] == val) {
          countX++;
        }
      }
      if (countX == 2) {
        return false;
      }
    }
    int countY = 0;
    if (y >= 2) {
      for (int i = y - 2; i < y; i++) {
        if (matrix[x][i] == val) {
          countY++;
        }
      }
      if (countY == 2) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    ThreeColorsMap t = new ThreeColorsMap();
    int[][] result = t.generateMap(2, 2);
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.println(result[i][j]);
      }
    }
  }
}