package stack;

import java.util.Deque;
import java.util.LinkedList;

public class SortStack {
  
  public void sort(Deque<Integer> stack) {
    if (stack == null || stack.isEmpty() || stack.size() == 1) {
      return;
    }
    
    Deque<Integer> helpStack = new LinkedList<Integer>();
    while (!stack.isEmpty()) {
      int top = stack.pollFirst();
      while (!helpStack.isEmpty() && helpStack.peek() > top) {
        stack.offerFirst(helpStack.pollFirst());
      }
      helpStack.offerFirst(top);
    }
    
    while (!helpStack.isEmpty()) {
      stack.offerFirst(helpStack.pollFirst());
    }
  }
}