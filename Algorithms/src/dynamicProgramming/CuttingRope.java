package dynamicProgramming;

public class CuttingRope {
  
  public int maxProduct(int length) {
    if (length == 0 || length == 1) {
      return 0;
    }
    
    if (length == 2) {
      return 1;
    }
    
    int[] array = new int[length + 1];
    array[1] = 1;
    array[2] = 1;
    for (int i = 3; i < array.length; i++) {
      for (int j = 1; j <= i / 2; j++) {
        array[i] = Math.max(array[i], Math.max(array[j], j) * Math.max(array[i - j], i - j));
      }
    }
    
    return array[length];
  }
  
  public static void main(String[] args) {
    int length = 5;
    CuttingRope c = new CuttingRope();
    System.out.println(c.maxProduct(length));
  }
}