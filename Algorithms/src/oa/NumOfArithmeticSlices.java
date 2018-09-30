package oa;

import java.util.HashMap;

public class NumOfArithmeticSlices {
  
  public int numOfArithSubsequence(int[] A) {
    if (A == null || A.length == 0 || A.length < 3) {
      return 0;
    }
    
    int result = 0;
    HashMap<Integer, Integer>[] maps = new HashMap[A.length];
    for (int i = 0; i < A.length; i++) {
      maps[i] = new HashMap<>();
      int num = A[i];
      for (int j = 0; j < i; j++) {
        if ((long) num - A[j] > Integer.MAX_VALUE) {
          continue;
        }
        if ((long) num - A[j] < Integer.MIN_VALUE) {
          continue;
        }
        
        int diff = num - A[j];
        int count = maps[j].getOrDefault(diff, 0);
        maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1);
//        if (maps[i].get(diff) >= 2) {
//          result++;
//        }
        result = result + count;
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    NumOfArithmeticSlices t = new NumOfArithmeticSlices();
//   int[] A = {-1,1,3,3,3,2,1,0};
   int[] A ={2,4,6,8,10};
   System.out.println(t.numOfArithSubsequence(A));
  }
}