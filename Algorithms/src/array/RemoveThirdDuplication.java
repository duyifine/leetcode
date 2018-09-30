package array;

public class RemoveThirdDuplication {
  public int[] remove(int[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    int slow = 2;
    int fast = 2;
    while (fast < array.length) {
      if (array[fast] == array[slow - 2]) {
        fast++;
      } else {
        array[slow++] = array[fast++];
      }
    }
    
    int[] result = new int[slow];
    for (int i = 0; i < slow; i++) {
      result[i] = array[i];
    }
    return result;
  }
  
  public static void main(String[] args) {
    int[] array = {1,1,1,2,2,3};
    RemoveThirdDuplication r = new RemoveThirdDuplication();
    int[] result = r.remove(array);
    for (int i : result) {
      System.out.println(i);
    }
  }
}