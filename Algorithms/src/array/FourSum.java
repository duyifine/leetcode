package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
  
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      while (i - 1 >= 0 && i < nums.length && nums[i] == nums[i - 1]) {
        i++;
      }
      if (i >= nums.length) {
        break;
      }
      for (int j = i + 1; j < nums.length; j++) {
        while (j - 1 >= i + 1 && j < nums.length && nums[j] == nums[j - 1]) {
          j++;
        }
        if (j >= nums.length) {
          break;
        }
        int left = j + 1;
        int right = nums.length - 1;
        while (left < right) {
          while (left - 1 >= j + 1 && left < nums.length && nums[left] == nums[left - 1]) {
            left++;
          }
          if (left >= nums.length) {
            break;
          }
          if (nums[left] + nums[right] == target - nums[i] - nums[j]) {
            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);
            cur.add(nums[j]);
            cur.add(nums[left]);
            cur.add(nums[right]);
            result.add(cur);
            left++;
            right--;
          } else if (nums[left] + nums[right] < target - nums[i] - nums[j]) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
    int target = -9;
    FourSum f = new FourSum();
    System.out.println(f.fourSum(nums, target));
  }
}