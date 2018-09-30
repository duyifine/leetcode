package sort;

public class RainbowSort {
  
  public void rainbowSort(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    while (j <= k) {
      if (array[j] == -1) {
        swap(array, i, j);
        i++;
        j++;
      } else if (array[j] == 0) {
        j++;
      } else {
        swap(array, j, k);
        k--;
      }
    }
  }
  
  public void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
  
  public static void main(String[] args) {
    RainbowSort r = new RainbowSort();
    int[] array1 = {0, 1, 1, -1};
    r.rainbowSort(array1);
    for (int i = 0; i < array1.length; i++) {
      System.out.println(array1[i]);
    }
    
    int[] array2 = {1, -1, 0, 1, 0};
    r.rainbowSort(array2);
    for (int i = 0; i < array2.length; i++) {
      System.out.println(array2[i]);
    }
  }
}