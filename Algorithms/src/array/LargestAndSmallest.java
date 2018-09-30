package array;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSmallest {
  
  public List<Integer> findLargestAndSmallest(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    List<Integer> large = new ArrayList<Integer>();
    List<Integer> small = new ArrayList<Integer>();
    for (int i = 0; i < array.length; i = i + 2) {
      if (i == array.length - 1) {
        large.add(array[i]);
        small.add(array[i]);
        break;
      }
      if (array[i] > array[i + 1]) {
        large.add(array[i]);
        small.add(array[i + 1]);
      } else {
        large.add(array[i + 1]);
        small.add(array[i]);
      }
    }
    int largest = findLargest(large);
    int smallest = findSmallest(small);
    List<Integer> result = new ArrayList<>();
    result.add(largest);
    result.add(smallest);
    return result;
  }
  
  public int findLargest(List<Integer> large) {
    int largest = large.get(0);
    for (int i = 1; i < large.size(); i++) {
      if (large.get(i) > largest) {
        largest = large.get(i);
      }
    }
    return largest;
  }
  
  public int findSmallest(List<Integer> small) {
    int smallest = small.get(0);
    for (int i = 1; i < small.size(); i++) {
      if (small.get(i) < smallest) {
        smallest = small.get(i);
      }
    }
    return smallest;
  }
  
  public static void main(String[] args) {
    int[] array = {1,2,3,4,5,6,7,8,9};
    LargestAndSmallest l = new LargestAndSmallest();
    System.out.println(l.findLargestAndSmallest(array));
  }
}