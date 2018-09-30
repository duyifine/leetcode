package graphSearch;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  public List<List<Integer>> combineCoins(int target, int[] coins) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (target == 0 || coins == null || coins.length == 0) {
      return result;
    }
    
    List<Integer> tmpList = new ArrayList<Integer>();
    combineCoins(target, coins, result, tmpList, 0);
    return result;
  }
  
  public void combineCoins(int remains, int[] coins, List<List<Integer>> result, List<Integer> tmpList, int index) {
    if (index == coins.length - 1) {
      if (remains % coins[index] == 0) {
        tmpList.add(remains / coins[index]);
        result.add(new ArrayList<>(tmpList));
        tmpList.remove(tmpList.size() - 1);
      }
      return;
    }
    
    int max = remains / coins[index];
    for (int i = 0; i <= max; i++) {
      tmpList.add(i);
      combineCoins(remains - i * coins[index], coins, result, tmpList, index + 1);
      tmpList.remove(tmpList.size() - 1);
    }
  }
  
  public static void main(String[] args) {
    int[] coins = {5, 2, 1};
    int target = 11;
    Combinations c = new Combinations();
    System.out.println(c.combineCoins(target, coins));
  }
}