package oa;

public class SortMillionsIntegers {
  
  public int[] sortIntegers(int[] n) {
    if (n == null || n.length == 0 || n.length == 1) {
      return n;
    }
    
    int[] buckets = new int[10];
    for (int i = 0; i < n.length; i++) {
      buckets[n[i] - 1]++;
    }
    
    int index = 0;
    int bindex = 0;
    while (index < n.length) {
      while (buckets[bindex] < 1) {
        bindex++;
      }
      n[index++] = bindex + 1;
      buckets[bindex]--;
    }
    
    return n;
  }
  
  public static void main(String[] args) {
    SortMillionsIntegers t = new SortMillionsIntegers();
    int[] n = {3, 1, 4, 1, 5, 9, 2, 6, 5};
    int[] result = t.sortIntegers(n);
    for (int i : result) {
      System.out.println(i);
    }
  }
}