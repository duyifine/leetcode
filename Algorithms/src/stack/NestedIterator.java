package stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
  
  Deque<NestedInteger> stack = new LinkedList<>();
  
  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.offerFirst(nestedList.get(i));
    }
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#hasNext()
   */
  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      NestedInteger top = stack.peekFirst();
      if (top.isInteger()) {
        return true;
      }
    
      stack.pollFirst();
      for (int i = top.getList().size() - 1; i >= 0; i--) {
        stack.offerFirst(top.getList().get(i));
      }
    }
    return false;
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#next()
   */
  @Override
  public Integer next() {
    return stack.pollFirst().getInteger();
  }
  
}