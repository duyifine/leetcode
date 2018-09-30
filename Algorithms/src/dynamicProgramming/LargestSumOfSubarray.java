package dynamicProgramming;

public class LargestSumOfSubarray {
  public int maxSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    
    int[] maxValue = new int[nums.length];
    maxValue[0] = nums[0];
    int max = maxValue[0];
    for (int i = 1; i < nums.length; i++) {
      maxValue[i] = Math.max(maxValue[i - 1] + nums[i], nums[i]);
      max = Math.max(max, maxValue[i]);
    }
    
    return max;
  }
  
}