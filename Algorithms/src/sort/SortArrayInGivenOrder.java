package sort;

import java.util.HashMap;

public class SortArrayInGivenOrder {
  
  public int[] sort(int[] array, int[] order) {
    if (array == null || array.length == 0) {
      return null;
    }
    if (order == null || order.length == 0) {
      return array;
    }
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < order.length; i++) {
      map.put(order[i], i);
    }
    helper(array, map, 0, array.length - 1);
    return array;
  }
  
  public void helper(int[] array, HashMap<Integer, Integer> map, int left, int right) {
    if (left >= right) {
      return;
    }
    
    int mid = left + (right - left) / 2;
    helper(array, map, left, mid);
    helper(array, map, mid + 1, right);
    merge(array, left, mid, right, map);
  }
  
  public void merge(int[] array, int left, int mid, int right, HashMap<Integer, Integer> map) {
    int[] tmp = new int[array.length];
    for (int i = left; i <= right; i++) {
      tmp[i] = array[i];
    }
    int leftIndex = left;
    int rightIndex = mid + 1;
    while (leftIndex <= mid && rightIndex <= right) {
      if (map.containsKey(tmp[leftIndex]) && map.containsKey(tmp[rightIndex])) {
        if (map.get(tmp[leftIndex]) < map.get(tmp[rightIndex])) {
          array[left++] = tmp[leftIndex++];
        } else {
          array[left++] = tmp[rightIndex++];
        }
      } else if (map.containsKey(tmp[leftIndex])) {
        array[left++] = tmp[leftIndex++];
      } else if (map.containsKey(tmp[rightIndex])) {
        array[left++] = tmp[rightIndex++];
      } else {
        array[left++] = tmp[leftIndex++];
      }
    }
    while (leftIndex <= mid) {
      array[left++] = tmp[leftIndex++];
    }
    while (rightIndex <= right) {
      array[left++] = tmp[rightIndex++];
    }
  }
  
  public static void main(String[] args) {
    int[] array = {2,1,2,5,7,1,9,3,6,8,8};
    int[] order = {2,1,8,3};
    SortArrayInGivenOrder s = new SortArrayInGivenOrder();
    int[] result = s.sort(array, order);
    for (int i : result) {
      System.out.println(i);
    }
  }
}