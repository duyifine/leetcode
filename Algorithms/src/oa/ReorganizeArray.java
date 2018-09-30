package oa;

public class ReorganizeArray {
  
  public int[] reorganize(int[] array) {
    if (array == null || array.length == 0 || array.length == 1 || array.length == 2) {
      return array;
    }
    
    int i = 1;
    while (i < array.length - 1) {
      while (i < array.length - 1 && array[i] > array[i - 1] && array[i] > array[i + 1]) {
        array[i]--;
      } 
      while (i < array.length - 1 && array[i] < array[i - 1] && array[i] < array[i + 1]) {
        array[i]++;
      }
      i++;
    }
    
    return array;
  }
  
  public int[] solution(int[] A) {
    // write your code in Java SE 8
    if (A == null || A.length == 0 || A.length == 1 || A.length == 2) {
        return A;
    }
    
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    while (true) {
        if ((A[0] >= max && A[A.length - 1] <= min)|| (A[A.length - 1] >= max && A[0] <= min)) {
            break;
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int i = 1;
        while (i < A.length - 1) {
            if (A[i] < A[i - 1] && A[i] < A[i + 1]) {
                A[i]++;
            } else if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                A[i]--;
            }
            max = Math.max(max, A[i]);
            System.out.println("max=" + max);
            min = Math.min(min, A[i]);
            System.out.println("min=" + min);
            i++;
        }
    }
    
    return A;
  }
  
  public static void main(String[] args) {
    ReorganizeArray t = new ReorganizeArray();
    int[] array = {1,6,3,4,3,5};
    int[] result = t.solution(array);
    for (int i : result) {
      System.out.println(i);
    }
  }
}