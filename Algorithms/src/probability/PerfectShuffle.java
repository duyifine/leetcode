package probability;

public class PerfectShuffle {
  public void shuffle(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    
    for (int i = 0; i < array.length; i++) {
      int index = (int) (Math.random() * (array.length - i) + i);
      swap(array, i, index);
    }
  }
  
  public void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}