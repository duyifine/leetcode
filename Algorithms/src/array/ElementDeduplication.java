package array;

public class ElementDeduplication {
  public int[] deduplicate(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
      if (array[fast] != array[slow]) {
        array[++slow] = array[fast++];
      } else {
        fast++;
      }
    }
    
    int[] result = new int[slow + 1];
    for (int i = 0; i <= slow; i++) {
      result[i] = array[i];
    }
    return result;
  }
  
  
  public static void main(String[] args) {
    int[] array = {1,1,2,2,3};
    ElementDeduplication e = new ElementDeduplication();
    int[] result = e.deduplicate(array);
    for (int i : result) {
      System.out.println(i);
    }
  }
}