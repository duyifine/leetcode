package array;

public class MajorityElement {
  
  public int findMajority(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    
    int major = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        major = nums[i];
        count++;
      } else if (major == nums[i]) {
        count++;
      } else {
        count--;
      }
    }
    return major;
  }
}