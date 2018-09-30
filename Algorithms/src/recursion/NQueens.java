package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
  
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (n == 0) {
      return result;
    }
    
    List<Integer> cur = new ArrayList<>();
    helper(n, 0, result, cur);
    return result;
  }
  
  public void helper(int n, int row, List<List<Integer>> result, List<Integer> cur) {
    if (row == n) {
      result.add(new ArrayList<>(cur));
      return;
    }
    
    for (int i = 0; i < n; i++) {
      cur.add(i);
      if (isValid(cur)) {
        helper(n, row + 1, result, cur);
      }
      cur.remove(cur.size() - 1);
    }
  }
  
  public boolean isValid(List<Integer> cur) {
    int size = cur.size();
    for (int i = 0; i < size - 1; i++) {
      if (cur.get(i).equals(cur.get(size - 1)) || cur.get(i) - cur.get(size - 1) == i - size + 1
          || cur.get(i) - cur.get(size - 1) == size - 1 - i) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    NQueens t = new NQueens();
    System.out.println(t.nqueens(8));
  }
}