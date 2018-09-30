package string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestLengthProduct {
  
  public int largestProduct(String[] dict) {
    if (dict == null || dict.length == 0) {
      return 0;
    }
    
    Arrays.sort(dict, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
          return 1;
        } else if (s1.length() > s2.length()) {
          return -1;
        } else {
          return 0;
        }
      }
    });
    
    int[] bitMask = new int[dict.length];
    for (int i = 0; i < dict.length; i++) {
      for (int j = 0; j < dict[i].length(); j++) {
        bitMask[i] |= 1 << (dict[i].charAt(j) - 'a');
      }
    }
    
    int result = 0;
    for (int i = 0; i < dict.length - 1; i++) {
      for (int j = i + 1; j < dict.length; j++) {
        if (dict[i].length() * dict[j].length() < result) {
          break;
        }
        if ((bitMask[i] & bitMask[j]) == 0) {
          result = Math.max(dict[i].length() * dict[j].length(), result);
        }
      }
    }
    return result;
  }
}