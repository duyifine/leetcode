package sort;

public class MergeSort {
  
  public void sort(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
  }
  
  public void mergeSort(int[] array, int[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }
  
  public void merge(int[] array, int[] helper, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    
    int left_index = left;
    int right_index = mid + 1;
    while (left_index <= mid && right_index <= right) {
      if (helper[left_index] <= helper[right_index]) {
        array[left++] = helper[left_index++];
      } else {
        array[left++] = helper[right_index++];
      }
    }
    while (left_index <= mid) {
      array[left++] = helper[left_index++];
    }
    while (right_index <= right) {
      array[left++] = helper[right_index++];
    }
  }
}