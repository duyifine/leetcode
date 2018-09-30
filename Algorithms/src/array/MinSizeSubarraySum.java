package array;

public class MinSizeSubarraySum {
  
  public int minSubarrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    
    int slow = 0;
    int fast = 0;
    int sum = 0;
    int len = Integer.MAX_VALUE;
    while (fast < nums.length) {
      if (sum < s) {
        sum = sum + nums[fast++];
      }
      while (sum >= s) {
        len = Math.min(len, fast - slow);
        sum = sum - nums[slow++];
      }        
    }
    
    if (len == Integer.MAX_VALUE) {
      return 0;
    }
    return len;
  }
  
  public static void main(String[] args) {
    int[] nums = {2,3,1,2,4,3};
    int s = 7;
    MinSizeSubarraySum m = new MinSizeSubarraySum();
    System.out.println(m.minSubarrayLen(s, nums));
  }
}