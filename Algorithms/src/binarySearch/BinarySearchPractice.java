package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchPractice {
  
  public Integer first_occurrence(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (target <= array[mid]) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    
    if (array[right] == target) {
        return right;
    } else {
        return null;
    }

  }
  
  public Integer first_occurrence2(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (target == array[mid]) {
        right = mid; 
      } else if (target < array[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    
    if (array[left] == target) {
      return left;
    } else if (array[right] == target) {
      return right;
    } else {
      return null;
    }
  }
  
  public Integer binarySearch(int[] array, int target, int left, int right) {
    if (left > right) {
      return null;
    }

    int mid = left + (right - left) / 2;
    if (target == array[mid]) {
      return mid;
    } else if (target > array[mid]) {
      return binarySearch(array, target, mid + 1, right);
    } else {
      return binarySearch(array, target, left, mid - 1);
    }

  }
  
  public int getClosestNumber(int[] array, int target) {
    int left = 0;
    int right = array.length;
    
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (target == array[mid]) {
        return mid;
      } else if (target < array[mid]) {
        right = mid;
      } else {
        left = mid;
      }
    }
    
    if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
      return array[left];
    } else {
      return array[right];
    }
  }
  
  public List<Integer> getKClosestNumbers(int[] array, int target, int k) {
    if (k == 0) {
      System.out.println("Error! The value of k cannot be 0.");
      return null;
    } 
    if (k > array.length) {
      System.out.println("Error! The value of k cannot be larger than the size of array");
      return null;
    } 
    List<Integer> result = new ArrayList<Integer>();
    if (k == array.length) {
      for (int i = 0; i < array.length; i++) {
        result.add(array[i]);
      }
      return result;
    }
    
    int left = 0;
    int right = array.length;
    int closest_index = -1;
    
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (target == array[mid]) {
        closest_index = mid;
       break;
      } else if (target < array[mid]){
        right = mid;
      } else {
        left = mid;
      }
    }
    
    if (closest_index == -1) {
      if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
        closest_index = left;
      } else {
        closest_index = right;
      }
    }
    
    int left_most;
    int right_most;
    if (closest_index == 0) {
      left_most = 0;
      right_most = k - 1;
    } else if (closest_index == array.length - 1) {
      right_most = array.length - 1;
      left_most = array.length - 2 - k;
    } else {
      int i = 0;
      left_most = closest_index;
      right_most = closest_index;
      while (left_most > 0 && right_most < array.length - 1 && i < k - 1) {
        if (Math.abs(array[left_most - 1] - target) <= Math.abs(array[right_most + 1] - target)) {
          left_most--;
          i++;
        } else {
          right_most++;
          i++;
        }
      }

      while (i < k - 1) {
        if (left_most == 0) {
          right_most++;
        } else {
          left_most--;
        }
      }      
    }
    
    for (int index = left_most; index <= right_most; index++) {
      result.add(array[index]);
    }    
    return result;
  }
  
  public static void main(String[] args) {
    int[] array = {4,5,5,5,5,5,5};
    BinarySearchPractice test = new BinarySearchPractice();
    int target1 = 5;
    Integer result1 = test.first_occurrence(array, target1);
    if (result1.equals(1)) {
      System.out.println("Test 1 passed");
    }
    int target2 = 4;
    Integer result2 = test.first_occurrence(array, target2);
    if (result2.equals(0)) {
      System.out.println("Test 2 passed");
    }
    int target3 = 9;
    Integer result3 = test.first_occurrence(array, target3);
    if (result3 == null) {
      System.out.println("Test 3 passed");
    }
    
    int[] array2 = {1,2,4,5,7,8,9};
    int tar = 4;
    Integer reslt = test.binarySearch(array2, tar, 0, array2.length - 1);
    if (reslt.equals(2)) {
      System.out.println("Binary search test passed");
    }
    
    int[] array3 = {1,2,3,8,9};
    int num = 4;
    if (test.getClosestNumber(array3, num) == 3) {
      System.out.println("Closest number found.");
    }
    
    int[] array4 = {1,2,3,4,5};
    int k1 = 4;
    int x1 = 3;
    System.out.println(test.getKClosestNumbers(array4, x1, k1));
    int k2 = 4;
    int x2 = -1;
    System.out.println(test.getKClosestNumbers(array4, x2, k2));
  }
}