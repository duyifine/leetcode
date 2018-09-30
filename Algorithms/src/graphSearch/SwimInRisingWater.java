package graphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
  
  public class Cell {
    int row;
    int col;
    int val;
    
    public Cell(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }
  
  int[] dr = {0, 0, -1, 1};
  int[] dc = {-1, 1, 0, 0};
  public int swimInWater(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(11, new Comparator<Cell>() {
      public int compare(Cell c1, Cell c2) {
        if (c1.val < c2.val) {
          return -1;
        } else if (c1.val > c2.val) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    minHeap.offer(new Cell(0, 0, grid[0][0]));
    visited[0][0] = true;
    int time = 0;
    while (!minHeap.isEmpty()) {
      Cell top = minHeap.poll();
      if (top.val > time) {
        time = top.val;
      }
      if (top.row == grid.length - 1 && top.col == grid[0].length) break;
      for (int i = 0; i < 4; i++) {
        int r = top.row + dr[i];
        int c = top.col + dc[i];
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c]) {
          minHeap.offer(new Cell(r, c, grid[r][c]));
          visited[r][c] = true;
        }
      }
    }
    
    return time;
  }
}