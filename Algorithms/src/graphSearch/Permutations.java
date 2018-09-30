package graphSearch;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    
    List<Integer> set = new ArrayList<>();
    helper(nums, 0, result, set);
    return result;
  }
  
  public void getPermutations(int[] nums, int index, List<List<Integer>> result, List<Integer> subList) {
    if (index == nums.length) {
      result.add(new ArrayList<>(subList));
      return;
    }
    
    for (int i = index; i < nums.length; i++) {
      swap(nums, i, index);
      subList.add(nums[index]);
      getPermutations(nums, index + 1, result, subList);
      subList.remove(subList.size() - 1);
      swap(nums, i, index);
    }
  }
  
  public void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> set) {
    if (index == nums.length) {
      result.add(new ArrayList<>(set));
    } else {
    
      for (int i = index; i < nums.length; i++) {
        swap(nums, index, i);
        set.add(nums[index]);
        helper(nums, index + 1, result, set);
        swap(nums, index, i);
        set.remove(set.size() - 1);
      }
    
    }
  }
  
  public List<List<Integer>> permute2(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    
    List<Integer> tmpList = new ArrayList<>();
    helper2(nums,result, tmpList);
    return result;
  }
  
  public void helper2(int[] nums, List<List<Integer>> result, List<Integer> tmpList) {
    if (tmpList.size() == nums.length) {
      result.add(new ArrayList<>(tmpList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tmpList.contains(nums[i])) continue;
        tmpList.add(nums[i]);
        helper2(nums, result, tmpList);
        tmpList.remove(tmpList.size() - 1);
      }
    }
  }
  
  public void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
  
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    Permutations p = new Permutations();
    System.out.println(p.permute(nums));
    System.out.println(p.permute2(nums));
  }
}