package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    
    List<Integer> subList = new ArrayList<Integer>();
    helper(candidates, target, result, subList, 0);
    return result;
  }
  
  public void combination(int[] candidates, int target, List<List<Integer>> result, List<Integer> subList, int index) {
    if (target == 0) {
      result.add(new ArrayList<>(subList));
      return;
    }
    
    if (target < 0) return;
    
    for (int i = index; i < candidates.length; i++) {
      subList.add(candidates[i]);
      combination(candidates, target - candidates[i], result, subList, i);
      subList.remove(subList.size() - 1);
    }
  }
  
  public void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> subList, int index) {
    if (target == 0) {
      result.add(new ArrayList<Integer>(subList));
      return;
    }
    if (target < 0) {
      return;
    }
    
    for (int i = index; i < candidates.length; i++) {
      subList.add(candidates[i]);
      helper(candidates, target - candidates[i], result, subList, i);
      subList.remove(subList.size() - 1);
    }
  }
  
  public static void main(String[] args) {
    int[] candidates = {2,3,6,7};
    int target = 7;
    CombinationSum c = new CombinationSum();
    System.out.println(c.combinationSum(candidates, target));
  }
}