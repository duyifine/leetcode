package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  
  public List<List<Integer>> threeSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      while (i - 1 >= 0 && i < nums.length && nums[i] == nums[i - 1]) {
        i++;
      }
      if (i >= nums.length) {
        break;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] == target - nums[i]) {
          List<Integer> cur = new ArrayList<>();
          cur.add(nums[i]);
          cur.add(nums[left]);
          cur.add(nums[right]);
          result.add(cur);
          left++;
          right--;
        } else if (nums[left] + nums[right] < target - nums[i]) {
          left++;
        } else {
          right--;
        }
      }
    }
    
    return result;
  }
  
  public List<List<Integer>> threeSumII(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      
      int left = i + 1;
      int right = nums.length - 1;
      int target = -nums[i];
      while (left < right) {
        if (nums[left] + nums[right] == target) {
          List<Integer> subList = new ArrayList<>();
          subList.add(nums[i]);
          subList.add(nums[left]);
          subList.add(nums[right]);
          result.add(subList);
          while (left < right && nums[left] == nums[left + 1]) left++;
          while (left < right && nums[right] == nums[right - 1]) right--;
          left++;
          right--;
        } else if (nums[left] + nums[right] < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
  
  public List<Integer> twoSum(int[] nums, int left, int right, int target) {
    List<Integer> result = new ArrayList<Integer>();
    while (left < right) {
      while (left > 0 && left < nums.length && nums[left] == nums[left - 1]) {
        left++;
      }
      if (left >= nums.length) {
        break;
      }
      if (nums[left] + nums[right] == target) {
        result.add(nums[left]);
        result.add(nums[right]);
        break;
      } else if (nums[left] + nums[right] < target) {
        left++;
      } else {
        right--;
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    int[] nums = {-1,0,2,1,-1,-4};
    ThreeSum t = new ThreeSum();
    int target = 0;
    int[] nums2 = {1,1,1,1};
    System.out.println(t.threeSum(nums, target));
  }
}