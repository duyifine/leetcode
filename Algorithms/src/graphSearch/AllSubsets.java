package graphSearch;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {
  
  public List<List<Integer>> getSubsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    
    List<Integer> subset = new ArrayList<Integer>();
    helper(nums, 0, result, subset);
    return result;
  }
  
  public void subsetsInDistinctSet(int[] nums, List<List<Integer>> result, List<Integer> subList, int index) {
    result.add(new ArrayList<>(subList));
    
    for (int i = index; i < nums.length; i++) {
      subList.add(nums[index]);
      subsetsInDistinctSet(nums, result, subList, i + 1);
      subList.remove(subList.size() - 1);
    }
  }
  
  public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
    result.add(new ArrayList<>(subset));
    
    for (int i = index; i < nums.length; i++) {
      subset.add(nums[i]);
      helper(nums, i + 1, result, subset);
      subset.remove(subset.size() - 1);
    }
  }
  
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    AllSubsets a = new AllSubsets();
    System.out.println(a.getSubsets(nums));
  }
}