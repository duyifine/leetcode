package airbnb;

public class MedianInLargeFiles {
  
  public Double findMedian(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    
    int len = nums.length;
    if (len % 2 != 0) {
      return (double) helper(nums, len / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    } else {
      long lower = helper(nums, len / 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
      long upper = helper(nums, len / 2 + 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
      
      return (double) (lower + upper) / 2;
    }
  }
  
  public long helper(int[] nums, int k, long lower, long upper) {
    if (lower >= upper) return lower;
    
    long mid = lower + (lower + upper) / 2;
    int smallerCount = 0;
    long result = lower;
    for (int num : nums) {
      if (num <= mid) {
        smallerCount++;
        result = Math.max(num, result);
      }
    }
    
    if (smallerCount == k) {
      return result;
    } else if (smallerCount < k) {
      return helper(nums, k, Math.max(result + 1, mid), upper);
    } else {
      return helper(nums, k, lower, result);
    }

  }
}