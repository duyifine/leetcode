package dynamicProgramming;

public class LongestAscendingSubarray {
  
  public int longestSubarray(int[] array) {
    if (array == null || array.length == 0) {
      return -1;
    }
    
    if (array.length == 1) {
      return 1;
    }
    
    int[] subarrayLength = new int[array.length];
    int longest = 1;
    subarrayLength[0] = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        subarrayLength[i] = subarrayLength[i - 1] + 1;
        longest = Math.max(longest, subarrayLength[i]);
      } else {
        subarrayLength[i] = 1;
      }
    }
    
    return longest;
  }
  
  public static void main(String[] args) {
    int[] array = {7,2,3,1,5,8,9,6};
    LongestAscendingSubarray l = new LongestAscendingSubarray();
    System.out.println(l.longestSubarray(array));
  }
}