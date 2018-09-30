package graphSearch;

import java.util.Deque;
import java.util.LinkedList;

public class Maze {
  
  public boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
    if (maze == null || start == null || destination == null) return false;
    
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    
    return helper(maze, start[0], start[1], destination, visited);
  }
  
  int[] dx = {0, 0, -1, 1};
  int[] dy = {-1, 1, 0, 0};
  public boolean helper(int[][] maze, int x, int y, int[] destination, boolean[][] visited) {
    if (visited[x][y]) return false;    
    if (x < 0 || x > maze.length || y < 0 || y > maze[0].length) return false;
    if (x == destination[0] && y == destination[1]) return true;
    
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int r = x + dx[i];
      int c = y + dy[i];
      if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == 0) {
        if (helper(maze, r, c, destination, visited)) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
    if (maze == null || start == null || destination == null) return false;
    
    Deque<int[]> queue = new LinkedList<>();
    queue.offerFirst(start);
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    visited[start[0]][start[1]] = true;
    
    while (!queue.isEmpty()) {
      int[] top = queue.pollLast();
      if (top[0] == destination[0] && top[1] == destination[1]) return true;
      
      for (int i = 0; i < 4; i++) {
        int x = top[0] + dx[i];
        int y = top[1] + dy[i];
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 && !visited[x][y]) {
          queue.offerFirst(new int[] {x, y});
          visited[x][y] = true;
        }
      }
    }
    
    return false;
  }
}