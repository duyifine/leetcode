package array;

import java.util.Arrays;

public class ThreeSumSmaller {
  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return -1;
    }
    
    Arrays.sort(nums);
    int result = 0;
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            if (Math.abs(target - nums[i] - nums[left] - nums[right]) < diff) {
                diff = Math.abs(target - nums[i] - nums[left] - nums[right]);
                result = nums[left] + nums[right] + nums[i];
                System.out.println("current result=" + result);
            }
            if (nums[left] + nums[right] == target - nums[i]) {
                return result;
            } else if (nums[left] + nums[right] < target - nums[i]) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    ThreeSumSmaller t = new ThreeSumSmaller();
    int[] nums = {0, 1, 2};
    int target = 0;
    System.out.println(t.threeSumClosest(nums, target));
  }
}