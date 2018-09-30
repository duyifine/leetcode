package airbnb;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class SlidingPuzzle {
  
  public int slidingPuzzle(int[][] board) {
    if (board == null || board.length == 0) return -1;
    
    String start = Arrays.deepToString(board).replaceAll("\\[|\\]|\\,|\\s", "");
    String target = "123456780";
    if (start.equals(target)) return 0;
    
    Deque<String> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();
    queue.offerFirst(start);
    visited.add(start);
    
    int[][] swapArray = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8}, {3, 7}, {4, 6, 8}, {5, 7}};
    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String top = queue.pollLast();
        if (top.equals(target)) return count;
        int index = top.indexOf('0');
        for (int j = 0; j < swapArray[index].length; j++) {
          String next = swap(top, index, swapArray[index][j]);
          if (!visited.contains(next)) {
            queue.offerFirst(next);
            visited.add(next);
          }
        }
      }
      count++;
    }
    
    return -1;
  }
  
  public String swap(String input, int i, int j) {
    char[] array = input.toCharArray();
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
    return String.valueOf(array);
  }
  
  public static void main(String[] args) {
    SlidingPuzzle sol = new SlidingPuzzle();
    int[][] matrix = {
        {3, 1, 4},
        {6, 2, 0},
        {7, 5, 8}
    };
    System.out.println(sol.slidingPuzzle(matrix));
  }
}