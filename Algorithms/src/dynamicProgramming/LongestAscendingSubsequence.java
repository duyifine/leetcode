package dynamicProgramming;

public class LongestAscendingSubsequence {
  public int longestSubsequence(int[] array) {
    if (array == null) {
      return -1;
    }
    
    int[] length = new int[array.length];
    length[0] = 1;
    int longest = 1;
    for (int i = 1; i < array.length; i++) {
      int curLongest = 0;
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          curLongest = Math.max(curLongest, length[j]);
        }
      }
      length[i] = 1 + curLongest;
      longest = Math.max(longest, length[i]);
    }
    
    return longest;
  }
  
  public static void main(String[] args) {
    int[] array = {10,9,2,5,3,7,101,18};
    LongestAscendingSubsequence l = new LongestAscendingSubsequence();
    System.out.println(l.longestSubsequence(array));
  }
}