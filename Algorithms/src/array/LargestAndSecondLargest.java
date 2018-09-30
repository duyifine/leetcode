package array;

import java.util.ArrayList;
import java.util.List;

public class LargestAndSecondLargest {
  
  public List<Integer> largestAndSecond(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) {
      return null;
    }
    
    List<Integer> result = new ArrayList<>();
    int largest = array[0];
    int second = Integer.MIN_VALUE;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > largest) {
        second = largest;
        largest = array[i];
      } else if (array[i] < largest && array[i] > second) {
        second = array[i];
      }
    }
    result.add(largest);
    result.add(second);
    return result;
  }
  
  public int secondLargest(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) {
      return Integer.MIN_VALUE;
    }
    
    int largest = array[0];
    int second = Integer.MIN_VALUE;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > largest) {
        second = largest;
        largest = array[i];
      } else if (array[i] < largest && array[i] > second) {
        second = array[i];
      }
    }
    
    return second;
  }
  
  public static void main(String[] args) {
    int[] array = {10,9,8,7,6,5,4,3};
    LargestAndSecondLargest l = new LargestAndSecondLargest();
    System.out.println(l.secondLargest(array));
    System.out.println(l.largestAndSecond(array));
    int[] array2 = {1,2};
    System.out.println(l.secondLargest(array2));
    System.out.println(l.largestAndSecond(array2));
    int[] array3 = {8};
    System.out.println(l.secondLargest(array3));
    System.out.println(l.largestAndSecond(array3));
  }
}