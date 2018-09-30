package graphSearch;

import java.util.Deque;
import java.util.LinkedList;

public class MazeII {
  
  int[] dx = {0, 0, -1, 1};
  int[] dy = {-1, 1, 0, 0};
  public int shortestDistance(int[][] maze, int[] start, int[] dest) {
    if (maze == null || start == null || dest == null) return 0;
    
    Deque<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    queue.offerFirst(new int[] {start[0], start[1], 1});
    visited[start[0]][start[1]] = true;
    
    while (!queue.isEmpty()) {
      int[] top = queue.pollLast();
      if (top[0] == dest[0] && top[1] == dest[1]) return top[2];
      for (int i = 0; i < 4; i++) {
        int x = top[0] + dx[i];
        int y = top[1] + dy[i];
        while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
          x = x + dx[i];
          y = y + dy[i];
        }
        if (!visited[x - dx[i]][y - dy[i]]) {
          queue.offerFirst(new int[] {x - dx[i], y - dy[i], top[2] + 1});
          visited[x - dx[i]][y - dy[i]] = true;
        }
      }
    }
    
    return -1;
  }
}