package oa;

import java.util.ArrayList;
import java.util.List;

public class FibonacciReversal {
  
  public List<Integer> reverse(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
      if (!isValidFibo(num)) return result;
    }
    
    result.add(nums[0]);
    result.add(nums[1]);
    int next = nums[0] - nums[1];
    while (next >= 0) {
      result.add(next);
      if (next == 0) break;
      int tmp = next;
      next = nums[1] - next;
      nums[1] = tmp;
    }
    
    return result;
  }
  
  public boolean isValidFibo(int num) {
    int f0 = 0;
    int f1 = 1;
    while (f1 <= num) {
      int tmp = f0;
      f0 = f1;
      f1 = tmp + f1;
      if (f1 == num) return true;
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    FibonacciReversal s = new FibonacciReversal();
    int[] nums = {21, 13};
    System.out.println(s.reverse(nums));
  }
}