package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D {
  
  List<Iterator<Integer>> iters;
  int cur = 0;
  
  public Vector2D(List<List<Integer>> vec2d) {
    this.iters = new ArrayList<Iterator<Integer>>();
    for (List<Integer> l : vec2d) {
      if (l.size() > 0) {
        this.iters.add(l.iterator());
      }
    }
  }
  
  public int next() {
    Integer res = iters.get(cur).next();
    if (!iters.get(cur).hasNext()) {
      cur++;
    }
    
    return res;
  }
  
  public boolean hadNext() {
   if (cur < iters.size() && iters.get(cur).hasNext()) {
     return true;
   }
   return false;
  }
}