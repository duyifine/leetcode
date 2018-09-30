package array;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
  
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k <= 0) return new int[0];
    
    int[] result = new int[nums.length - k + 1];
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
        deque.pollLast();
      }
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      deque.offerLast(i);
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    
    return result;
  }
}