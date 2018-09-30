package recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || (matrix.length == 0 && matrix[0].length == 0)) {
      return result;
    }
    
    helper(matrix, 0, result);
    return result;
  }
  
  public void helper(int[][] matrix, int curRow, List<Integer> result) {
    int row = matrix.length;
    int col = matrix[0].length;
    if (row % 2 == 0) {
      if (curRow >= row / 2) {
        return;
      }
    } else {
      if (col % 2 == 1) {
        if (curRow >= row / 2 + 1) {
          result.add(matrix[row / 2][col / 2]);
          return;
        }
      }
      if (curRow >= row / 2 + 1) {
        return;
      }
    } 
    
    for (int i = curRow; i < col - curRow - 1; i++) {
      result.add(matrix[curRow][i]);
    }
    for (int i = curRow; i < row - curRow - 1; i++) {
      result.add(matrix[i][col - curRow - 1]);
    }
    for (int i = col - curRow - 1; i > curRow; i--) {
      result.add(matrix[row - curRow - 1][i]);
    }
    for (int i = row - curRow - 1; i > curRow; i--) {
      result.add(matrix[i][curRow]);
    }
    helper(matrix, curRow + 1, result);
  }
  
  public List<Integer> spiralOrder2(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = col - 1;
    int up = 0;
    int down = row - 1;
    while (left < right && up < down) {
      for (int i = left; i <= right; i++) {
        result.add(matrix[up][i]);
      }
      for (int i = up + 1; i <= down - 1; i++) {
        result.add(matrix[i][right]);
      }
      for (int i = right; i >= left; i--) {
        result.add(matrix[down][i]);
      }
      for (int i = down - 1; i >= up + 1; i--) {
        result.add(matrix[i][left]);
      }
      up++;
      right--;
      down--;
      left++;
    }
    
    if (left > right && up > down) {
      return result;
    }
    if (left == right) {
      for (int i = up; i <= down; i++) {
        result.add(matrix[i][left]);
      }
    } else {
      for (int i = left; i <= right; i++) {
        result.add(matrix[up][i]);
      }
    }
    return result;
  }
  
  
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{4,5,6,},{7,8,9}};
    SpiralMatrix s = new SpiralMatrix();
    System.out.println(s.spiralOrder2(matrix));
    int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    System.out.println(s.spiralOrder2(matrix2));
    int[][] matrix3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    System.out.println(s.spiralOrder2(matrix3));
    int[][] matrix4 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    System.out.println(s.spiralOrder2(matrix4));
    int[][] matrix5 = {{1},{2},{3},{4},{5}};
    System.out.println(s.spiralOrder2(matrix5));
  }
}