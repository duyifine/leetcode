package graphSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
  
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    
    List<Integer> subList = new ArrayList<>();
    helper(nums, 0, result, subList);
    return result;
  }
  
  public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subList) {
    if (index == nums.length) {
      result.add(new ArrayList<>(subList));
      return;
    }
    
    HashSet<Integer> set = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (!set.contains(nums[i])) {
        set.add(nums[i]);
        swap(nums, i, index);
        subList.add(nums[index]);
        helper(nums, index + 1, result, subList);
        subList.remove(subList.size() - 1);
        swap(nums, i, index);
      }
    }
  }
  
  public void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}