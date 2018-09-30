package array;

public class RemoveRepeatedElements {
  
  public int[] remove(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    int slow = 0;
    int fast = 1;
    boolean repeated = false;
    while (fast < array.length) {
      if (array[fast] == array[slow]) {
        fast++;
        repeated = true;
      } else if (array[fast] != array[slow] && !repeated) {
        slow++;
        array[slow] = array[fast++];
      } else {
        array[slow] = array[fast++];
        repeated = false;
      }
    }
    int[] result = new int[slow];
    for (int i = 0; i < slow; i++) {
      result[i] = array[i];
    }
    return result;
  }
  
  public static void main(String[] args) {
    int[] array = {1,1,2,3,3,3};
    RemoveRepeatedElements r = new RemoveRepeatedElements();
    int[] result = r.remove(array);
    for (int i : result) {
      System.out.println(i);
    }
  }
}