package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSum {
  
  public static class Pair {
    int first;
    int second;
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
    public String toString() {
      return new String("(" + this.first + "," + this.second + ")");
    }
  }
  
  public List<Pair> twoSumPairs(int[] nums, int target) {
    List<Pair> result = new ArrayList<Pair>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(target - nums[i])) {
        Pair pair = new Pair(nums[i], target - nums[i]);
        result.add(pair);
      }
      if (!set.contains(nums[i])) {
        set.add(nums[i]);
      }
    }
    return result;
  }
  
  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    
    int[] result = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        result[0] = map.get(target - nums[i]);
        result[1] = i;
        break;
      }
      map.put(nums[i], i);
    }
    
    return result;
  }
  
  public int[] twoSumSortedArray(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    
    int[] result = new int[2];
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      if (nums[i] + nums[j] == target) {
        result[0] = i;
        result[1] = j;
        break;
      } else if (nums[i] + nums[j] < target) {
        i++;
      } else {
        j--;
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    int[] nums = {3,2,4,1,5};
    int target = 6;
    TwoSum two = new TwoSum();
    int[] result = two.twoSum(nums, target);
    for (int i : result) {
      System.out.println(i);
    }
    System.out.println(two.twoSumPairs(nums, target).toString());
    int[] nums1 = {2,7,11,15};
    int[] result2 = two.twoSumSortedArray(nums1, target);
    for (int i : result2) {
      System.out.println(i);
    }
    System.out.println(two.twoSumPairs(nums1, target).toString());
  }
}