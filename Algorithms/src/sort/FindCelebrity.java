package sort;

import java.util.ArrayList;
import java.util.List;

public class FindCelebrity {
  
  public int find(int n) {
    if (n <= 0) {
      return n - 1;
    }
    
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      list.add(i);
    }
    
    while (list.size() > 1) {
      List<Integer> nextRound = new ArrayList<Integer>();
      for (int i = 0; i < list.size(); i = i + 2) {
        if (i + 1 < list.size()) {
          if (knows(list.get(i), list.get(i + 1))) {
            nextRound.add(list.get(i + 1));
          } else {
            nextRound.add(list.get(i));
          }
        } else {
          nextRound.add(list.get(i));
        }
      }
      System.out.println("nextRound=" + nextRound);
      list = nextRound;
    }
    return list.get(0);
  }
  
  public int findII(int n) {
    if (n <= 0) {
      return n - 1;
    }
    
    int i = 0;
    int j = n - 1;
    while (i < j) {
      if (knows(i, j)) {
        i++;
      } else {
        j--;
      }
    }
    int result = i;
    for (int k = 0; k < n; k++) {
      if (result != k && (knows(result, k) || !knows(k, result))) {
        return -1;
      }
    }
    
    return result;
  }
  
  public boolean knows(int i, int j) {
    if (j == 12) {
      return true;
    }
    if (i == 12) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    FindCelebrity f = new FindCelebrity();
    System.out.println(f.find(50));
    System.out.println(f.findII(50));
  }
}