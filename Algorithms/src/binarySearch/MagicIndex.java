package binarySearch;

public class MagicIndex {
  
  public int getMagicIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    
    int left = 0;
    int right = nums.length -1 ;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == mid) {
        return mid;
      } else if (nums[mid] > mid) {
        right = Math.min(mid - 1, nums[mid]);
      } else {
        left = Math.max(mid + 1, nums[mid]);
      }
    }
    return -1;
  }
  
  public int getMagicIndexII(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    
    return helper(nums, 0, nums.length - 1);
  }
  
  public int helper(int[] nums, int left, int right) {
    if (left > right) {
      return -1;
    }
    
    int mid = left + (right - left) / 2;
    if (nums[mid] == mid) {
      return mid;
    } else if (nums[mid] > mid) {
      right = Math.min(mid - 1, nums[mid]);
    } else {
      int leftAnwser = helper(nums, left, Math.min(mid - 1, nums[mid]));
      if (leftAnwser != -1) {
        return leftAnwser;
      }
      int rightAnwser = helper(nums, Math.max(mid + 1, nums[mid]), right);
      return rightAnwser;
    }
    return -1;
  }
  
  public static void main(String[] args) {
    MagicIndex m = new MagicIndex();
    int[] nums = {-5,-2,0,3,5,7,8};
    System.out.println(m.getMagicIndex(nums));
    int[] nums2 = {-10,-5,2,2,2,3,4,7,9,12,13};
    System.out.println(m.getMagicIndexII(nums2));
  }
}