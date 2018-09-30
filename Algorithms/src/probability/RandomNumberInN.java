package probability;

import java.util.Random;

public class RandomNumberInN {
  
  public int[] getRandom(int[] S) {
    int[] result = new int[S.length];
    result[0] = S[0];
    int i = 1;
    while (i < S.length) {
      Random r = new Random();
      int rNum = r.nextInt(i + 1) + 1;
      if (rNum == 1) result[i] = S[i];
    }
    
    return result;
  }
}