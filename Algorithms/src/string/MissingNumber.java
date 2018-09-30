package string;

import java.util.HashSet;

public class MissingNumber {
  
  public Integer getMissing(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < array.length; i++) {
      set.add(array[i]);
    }
    for (int i = 0 ;i < array.length + 1; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return null;
  }
}