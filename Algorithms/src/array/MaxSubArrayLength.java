package array;

import java.util.HashMap;

public class MaxSubArrayLength {
  
  public int maxLength(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int sum = 0;
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (!map.containsKey(sum)) {
        map.put(sum, i);
      } 
      if (sum == k) {
        result = Math.max(result, i + 1);
      } else if (map.containsKey(sum - k)) {
        result = Math.max(result, i - map.get(sum - k));
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    MaxSubArrayLength m = new MaxSubArrayLength();
    int[] nums1 = {1,-1,5,-2,3};
    int k1 = 3;
    System.out.println(m.maxLength(nums1, k1));
    int[] nums2 = {-2,-1,2,1};
    int k2 = 1;
    System.out.println(m.maxLength(nums2, k2));
  }
}