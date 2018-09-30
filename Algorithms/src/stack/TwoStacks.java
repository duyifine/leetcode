package stack;

import java.util.Deque;
import java.util.LinkedList;

public class TwoStacks {
  private Deque<Integer> in;
  private Deque<Integer> min;
  
  public TwoStacks() {
    in = new LinkedList<Integer>();
    min = new LinkedList<Integer>();
  }
  
  public Integer getMin() {
    if (min.isEmpty()) {
      return null;
    } 
      
    return min.peekLast();
  }
  
  public void push(int value) {
    in.offerLast(value);
    if (min.isEmpty() || min.peekLast() >= value) {
      min.offerLast(value);
    } 
  }
  
  public Integer pop() {
    if (in.isEmpty()) {
      return null;
    }
    
    if (in.peekLast().equals(min.peekLast())) {
      min.pollLast();
    }
    return in.pollLast();
  }
  
  public Integer top() {
    if (in.isEmpty()) {
      return null;
    }
    
    return in.peekLast();
  }
}