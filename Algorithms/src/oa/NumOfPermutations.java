package oa;

import java.util.HashMap;

public class NumOfPermutations {
  
  public int permutationNum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
    }
    
    int total = permutations(nums.length);
    for (int value : map.values()) {
      total = total / permutations(value);
    }
    return total;
  }
  
  public int permutations(int n) {
    int result = 1;
    for (int i = n; i >= 1; i--) {
      result = result * i;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    NumOfPermutations t = new NumOfPermutations();
    int[] nums = {1,2,1};
    System.out.println(t.permutationNum(nums));
    int[] nums2 = {1,2,1,3};
    System.out.println(t.permutationNum(nums2));
    int[] nums3 = {1};
    System.out.println(t.permutationNum(nums3));
  }
}