package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class ClosestKElements {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    if (k == 0) {
      System.out.println("Error! The value of k cannot be 0.");
      return null;
    } 
    if (k > arr.length) {
      System.out.println("Error! The value of k cannot be larger than the size of array");
      return null;
    } 
    List<Integer> result = new ArrayList<Integer>();
    if (k == arr.length) {
      for (int i = 0; i < arr.length; i++) {
        result.add(arr[i]);
      }
      return result;  
    }

    int left = 0;
    int right = arr.length;
    int closest_index = -1;

    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (x == arr[mid]) {
        closest_index = mid;
        break;
      } else if (x < arr[mid]){
        right = mid;
      } else {
        left = mid;
      }
    }

    if (closest_index == -1) {
      if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
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
    } else if (closest_index == arr.length - 1) {
      right_most = arr.length - 1;
      left_most = arr.length - k;
    } else {
      int i = 0;
      left_most = closest_index;
      right_most = closest_index;
      while (left_most > 0 && right_most < arr.length - 1 && i < k - 1) {
        if (Math.abs(arr[left_most - 1] - x) <= Math.abs(arr[right_most + 1] - x)) {
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
        i++;
      }      
    }


    for (int index = left_most; index <= right_most; index++) {
      result.add(arr[index]);
    }    
    return result;
  }
  
  public static void main(String[] args) {
    int[] arr = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
    int k = 9;
    int x = 4;
    ClosestKElements t = new ClosestKElements();
    System.out.println(t.findClosestElements(arr, k, x));
  }
}