package recursion;

import java.util.Deque;
import java.util.LinkedList;

public class TheMaze {
  
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return false;
    }
    
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return helper(maze, start[0], start[1], destination, visited);
  }
  
  int[] dx = {0, 0, -1, 1};
  int[] dy = {-1, 1, 0, 0};
  public boolean helper(int[][] maze, int x, int y, int[] destination, boolean[][] visited) {
    if (visited[x][y]) {
      return false;
    }
    if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
      return false;
    }
    if (x == destination[0] && y == destination[1]) {
      return true;
    }
    
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      if (isValid(x + dx[i], y + dy[i], maze)) {
        if (helper(maze, x + dx[i], y + dy[i], destination, visited)) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  public boolean isValid(int x, int y, int[][] maze) {
    if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
      return true;
    }
    return false;
  }
  
  public boolean hasPathII(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze.length == 0 || maze[0].length == 0) {
      return false;
    }
    
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    Deque<int[]> queue = new LinkedList<int[]>();
    queue.offerFirst(start);
    visited[start[0]][start[1]] = true;
    while (!queue.isEmpty()) {
      int[] top = queue.pollLast();
      if (top[0] == destination[0] && top[1] == destination[1]) {
        return true;
      }
      for (int i = 0; i < 4; i++) {
        int x = top[0] + dx[i];
        int y = top[1] + dy[i];
/**        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
          if (!visited[x][y]) {
            queue.offerFirst(new int[] {x, y});
            visited[x][y] = true;
          }
        } **/
        while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
          x = x + dx[i];
          y = y + dy[i];
        }
        if (!visited[x - dx[i]][y - dy[i]]) {
          queue.offerFirst(new int[] {x - dx[i], y - dy[i]});
          visited[x - dx[i]][y - dy[i]] = true;
        }
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
    TheMaze t = new TheMaze();
    int[] start = {0, 4};
    int[] dest = {4, 4};
    System.out.println(t.hasPath(maze, start, dest));
    System.out.println(t.hasPathII(maze, start, dest));
  }
}