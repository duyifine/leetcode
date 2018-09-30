package array;

import java.util.ArrayList;
import java.util.List;

public class CommonInThreeSortedArrays {
  
  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> result = new ArrayList<>();
    if (a == null || b == null || c == null || a.length == 0 || b.length == 0 || c.length == 0) {
      return result;
    }
    
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < a.length && j < b.length && k < c.length) {
      if (a[i] == b[j] && b[j] == c[k]) {
        result.add(a[i]);
        i++;
        j++;
        k++;
      } else {
        if (a[i] <= b[j] && a[i] <= c[k]) {
          i++;
        } else if (b[j] <= a[i] && b[j] <= c[k]) {
          j++;
        } else {
          k++;
        }
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    int[] a = {1,3,4,6,9};
    int[] b = {3,4,8,10};
    int[] c = {2,3,4,5,6,7};
    CommonInThreeSortedArrays t = new CommonInThreeSortedArrays();
    System.out.println(t.common(a, b, c));
  }
}