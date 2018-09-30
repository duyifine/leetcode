package heapAndGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {
  
  static class Coordinate {
    int x;
    int y;
    int val;
    
    Coordinate(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
  
  public int kthSmallest(int[][] matrix, int k) {
    int row = matrix.length;
    int col = matrix[0].length;
    
    PriorityQueue<Coordinate> minHeap = new PriorityQueue<Coordinate>(k, new Comparator<Coordinate>() {
      @Override
      public int compare(Coordinate c1, Coordinate c2) {
        if (c1.val == c2.val) {
          return 0;
        } else if (c1.val < c2.val) {
          return -1;
        } else {
          return 1;
        }
      }
    });
    
    minHeap.offer(new Coordinate(0, 0, matrix[0][0]));
    boolean[][] visited = new boolean[row][col];
    visited[0][0] = true;
    int j = 0;
    Coordinate top = null;
    while (!minHeap.isEmpty() && j < k) {
      top = minHeap.poll();
      j++;
      if (top.x + 1 < row && !visited[top.x + 1][top.y]) {
        minHeap.offer(new Coordinate(top.x + 1, top.y, matrix[top.x + 1][top.y]));
        visited[top.x + 1][top.y] = true;
      }
      if (top.y + 1 < col && !visited[top.x][top.y + 1]) {
        minHeap.offer(new Coordinate(top.x, top.y + 1, matrix[top.x][top.y + 1]));
        visited[top.x][top.y + 1] = true;
      }     
    }
    return top.val;
  }
}