package sort;

public class SelectionSort {
  
  public void sort(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    
    for (int i = 0; i < array.length - 1; i++) {
      int global_min = array[i];
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < global_min) {
          global_min = array[j];
        }
      }
      swap(array[i], global_min);
    }
  }
  
  public void swap(int a1, int a2) {
    int tmp = a1;
    a1 = a2;
    a2 = tmp;
  }
}