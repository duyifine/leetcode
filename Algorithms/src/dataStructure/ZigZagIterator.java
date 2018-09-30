package dataStructure;

import java.util.Iterator;
import java.util.List;

public class ZigZagIterator {
  
  Iterator<Integer> it1;
  Iterator<Integer> it2;
  int turns;
  public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
    it1 = v1.iterator();
    it2 = v2.iterator();
    turns = 0;
  }
  
  public int next() {
    if (!hasNext()) {
      return 0;
    }
    turns = 1 - turns;
    if (turns % 2 == 1 && it1.hasNext() || !it2.hasNext()) {
      return it1.next();
    } else if (turns % 2 == 0 && it2.hasNext() || !it1.hasNext()) {
      return it2.next();
    }
    return 0;
  }
  
  public boolean hasNext() {
    if (it1.hasNext() || it2.hasNext()) {
      return true;
    }
    return false;
  }
}