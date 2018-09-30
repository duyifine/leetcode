package sort;

public class ArrayShuffling {
  
  public void moveZeros(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      if (array[i] != 0) {
        i++;
      } else if (array[j] == 0) {
        j--;
      } else {
        swap(array, i++, j--);
      }
    }
  }
  
  public void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}