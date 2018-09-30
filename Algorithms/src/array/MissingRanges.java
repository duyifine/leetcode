package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
  
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0 || lower > upper) {
      return result;
    }
    
    int i = 0;
    int j = 1;
    if (nums[0] > lower) {
      result.add(getRange(lower, nums[0] - 1));
    }
    
    while (j < nums.length) {
      if (nums[j] - nums[i] > 1) {
        result.add(getRange(nums[i] + 1, nums[j] - 1));
      } 
      j++;
      i++;      
    }
    
    if (nums[nums.length - 1] < upper) {
      result.add(getRange(nums[nums.length - 1] + 1, upper));
    }
    
    return result;
  }
  
  public String getRange(int from, int to) {
    if (to == from) {
      return String.valueOf(to);
    }
    return from + "->" + to;
  }
  
  public static void main(String[] args) {
    MissingRanges m = new MissingRanges();
    int[] nums = {0, 1, 3, 50, 75};
    int lower = 0;
    int upper = 99;
    System.out.println(m.findMissingRanges(nums, lower, upper));
  }
}