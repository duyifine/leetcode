package array;

public class SecondSmallest {
  
  public Integer secondSmallest(int[] array) {
    if (array == null || array.length == 0 || array.length == 1) {
      return null;
    }
    
    int smallest = array[0];
    int secondSmallest = Integer.MAX_VALUE;
    for (int i = 1; i < array.length; i++) {
      if (array[i] < smallest) {
        secondSmallest = smallest;
        smallest = array[i];
      } else if (array[i] > smallest && array[i] < secondSmallest) {
        secondSmallest = array[i];
      }
    }
    
    if (secondSmallest == Integer.MAX_VALUE) {
      return null;
    }
    return secondSmallest;
  }
  
  public static void main(String[] args) {
    int[] array1 = {1,1,1,1};
    SecondSmallest s = new SecondSmallest();
    System.out.println(s.secondSmallest(array1));
    int[] array2 = {0,1,2,3,4};
    System.out.println(s.secondSmallest(array2));
    int[] array3 = {2,4,1,9,8,5};
    System.out.println(s.secondSmallest(array3));
  }
}