package graphSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    
    List<Integer> tmp = new ArrayList<>();
    Arrays.sort(nums);
    helper(nums, 0, result, tmp);
    
    return result;
  }
  
  public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subList) {
    result.add(new ArrayList<>(subList));
    
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[index]) continue;
      subList.add(nums[i]);
      helper(nums, i + 1, result, subList);
      subList.remove(subList.size() - 1);
    }
  }
}