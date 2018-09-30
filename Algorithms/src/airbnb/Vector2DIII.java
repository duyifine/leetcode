package airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2DIII implements Iterator<Integer> {
  
  private int row;
  private int col;
  private List<List<Integer>> vec;
  
  public Vector2DIII(List<List<Integer>> vec2d) {
    this.vec = vec2d;
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#hasNext()
   */
  @Override
  public boolean hasNext() {
    if (vec == null || vec.isEmpty()) return false;
    
    while (row < vec.size()) {
      if (col < vec.get(row).size()) {
        return true;
      } else {
        row++;
        col = 0;
      }
    }
    
    return false;
  }

  /* (non-Javadoc)
   * @see java.util.Iterator#next()
   */
  @Override
  public Integer next() {
    return vec.get(row).get(col++);
  }
  
  public void remove() {
    vec.get(row).remove(col - 1);
    col--;
  }
  
  public static void main(String[] args) {
    List<List<Integer>> test = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>();
    row1.add(1);
    row1.add(2);
    row1.add(3);
    test.add(row1);
    List<Integer> row2 = new ArrayList<>();
    test.add(row2);
    List<Integer> row3 = new ArrayList<>();
    row3.add(4);
    row3.add(5);
    test.add(row3);
    
    Vector2DIII sol = new Vector2DIII(test);
    while (sol.hasNext()) {
      int result = sol.next();
      System.out.println(result);
      
      if (result == 3) {
        sol.remove();
        System.out.println("remove result = 3");
      }
    }
    
    System.out.println("finished iteration...");
    
    for (List<Integer> row : test) {
      for (int elem : row) {
        System.out.println(elem);
      }
    }
  }
}