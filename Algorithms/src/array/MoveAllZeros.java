package array;

public class MoveAllZeros {
  public int[] moveZeros(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      if (array[fast] == 0) {
        fast++;
      } else {
        array[slow++] = array[fast++];
      }
    }
    while (slow < array.length) {
      array[slow++] = 0;
    }
    return array;
  }
  
  public static void main(String[] args) {
    int[] array = {1,9,8,4,0,0,2,7,0,6,0};
    MoveAllZeros m = new MoveAllZeros();
    int[] result = m.moveZeros(array);
    for (int i : result) {
      System.out.println(i);
    }
  }
}