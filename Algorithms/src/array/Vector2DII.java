package array;

import java.util.Iterator;
import java.util.List;

public class Vector2DII implements Iterator<Integer> {
  
  Iterator<List<Integer>> iter;
  Iterator<Integer> cur;
  
  public Vector2DII(List<List<Integer>> vec2d) {
    this.iter = vec2d.iterator();
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#hasNext()
   */
  @Override
  public boolean hasNext() {
    while ((cur == null || !cur.hasNext()) && iter.hasNext()) {
      cur = iter.next().iterator();
    }
    
    return cur == null && cur.hasNext();
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#next()
   */
  @Override
  public Integer next() {
    hasNext();
    return cur.next();
  }
  
  public void remove() {
    while (cur == null && iter.hasNext()) {
      cur = iter.next().iterator();
    }
    if (cur != null) cur.remove();
  }
}