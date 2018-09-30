package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxRectangle {
  
  public int largestArea(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    
    Deque<Integer> stack = new LinkedList<Integer>();
    int result = 0;
    for (int i = 0; i <= array.length; i++) {
      int cur;
      if (i == array.length) {
        cur = 0;
      } else {
        cur = array[i];
      }
      while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        int left;
        if (stack.isEmpty()) {
          left = 0;
        } else {
          left = stack.peekFirst() + 1;
        }
        result = Math.max(result, height * (i - left));
      }
      stack.offerFirst(i);
    }
    
    return result;
  }
}