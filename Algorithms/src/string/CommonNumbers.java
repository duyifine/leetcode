package string;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbers {
  
  public List<Integer> getCommonNum(int[] a, int[] b) {
    List<Integer> result = new ArrayList<Integer>();
    if (a == null || b == null || a.length == 0 || b.length == 0) {
      return result;
    }
    
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        result.add(a[i]);
        i++;
        j++;
      } else if (a[i] < b[j]) {
        i++;
      } else {
        j++;
      }
    }
    return result;
  }
  
  public List<Integer> getCommonByBinarySearch(int[] a, int[] b) {
    List<Integer> result = new ArrayList<Integer>();
    if (a == null || b == null || a.length == 0 || b.length == 0) {
      return result;
    }
    
    int a_length = a.length;
    int b_length = b.length;
    if (a_length <= b_length) {
      helper(a, b, result);
    } else {
      helper(b, a, result);
    }
    return result;
  }
  
  public void helper(int[] small, int[] large, List<Integer> result) {
    for (int i = 0; i < small.length; i++) {
      if (binarySearch(large, small[i])) {
        result.add(small[i]);
      }
    }
  }
  
  public boolean binarySearch(int[] array, int target) {
    if (array == null || array.length == 0) {
      return false;
    }
    
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return true;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    CommonNumbers c = new CommonNumbers();
    int[] a = {1,3,5,7,9,21,25,40};
    int[] b = {3,7,10,21,24,40};
    System.out.println(c.getCommonByBinarySearch(a, b));
    System.out.println(c.getCommonNum(a, b));
  }
}