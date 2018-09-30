package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
  
  private Deque<Integer> queue;
  private int size;
  private double sum;
  public MovingAverage(int size) {
    this.queue = new LinkedList<>();
    this.size = size;
  }
  
  public double next(int val) {
    if (queue.size() < size) {
      queue.offerFirst(val);
      sum = sum + val;
    } else {
      sum = sum - queue.pollLast();
      queue.offerFirst(val);
      sum = sum + val;
    }
    return sum / queue.size();
  }
}