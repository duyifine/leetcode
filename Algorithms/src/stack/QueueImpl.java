package stack;

import java.util.Deque;
import java.util.LinkedList;

public class QueueImpl {
  private Deque<Integer> in;
  private Deque<Integer> out;
  
  public QueueImpl() {
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  
  public Integer poll() {
    move();
    if (out.isEmpty()) {
      return null;
    } else {
      return out.pollLast();
    }
  }
  
  public void offer(int value) {
    in.offerLast(value);
  }
  
  public Integer peek() {
    move();
    if (out.isEmpty()) {
      return null;
    } else {
      return out.peekLast();
    }
  }
  
  public boolean isEmpty() {
    if (in.isEmpty() && out.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
  
  private void move() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerLast(in.pollLast());
      }
    }
  }
}