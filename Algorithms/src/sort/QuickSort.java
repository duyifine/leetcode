package sort;

public class QuickSort {
  
  public void sort(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    
    quickSort(array, 0, array.length - 1);
  }
  
  public void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    
    int pivot_index = partition(array, left, right);
    quickSort(array, left, pivot_index - 1);
    quickSort(array, pivot_index + 1, right);
  }
  
  public int partition(int[] array, int left, int right) {
    int pivot_index = getRandomPivot(left, right);
    swap(array, pivot_index, right);
    int i = 0;
    int j = right - 1;
    while (i <= j) {
      if (array[i] <= array[right]) {
        i++;
      } else {
        swap(array, i, j);
        j--;
      }
    }
    swap(array, i, right);
    return i;
  }
  
  public int getRandomPivot(int left, int right) {
    return left + (int) ((right - left + 1) * Math.random());
  }
  
  public void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
  
  public static void main(String[] args) {
    QuickSort quick = new QuickSort();
    int[] array1 = {10, 80, 30, 90, 40, 50, 70};
    quick.sort(array1);
    for (int i = 0; i < array1.length; i++) {
      System.out.println(array1[i]);
    }
    
    int[] array2 = {10, 7, 8, 9, 1, 5};
    quick.sort(array2);
    for (int i = 0; i < array2.length; i++) {
      System.out.println(array2[i]);
    }
  }
}