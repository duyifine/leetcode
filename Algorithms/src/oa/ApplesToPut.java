package oa;

import java.util.Arrays;

public class ApplesToPut {
  public int maxAppleNum(int[] weights, int total) {
    if (weights == null || weights.length == 0 || total <= 0) {
      return 0;
    }
    
    int self_weight = weights[0];
    int diff = total - self_weight;
    Arrays.sort(weights, 1, weights.length);
    int count = 0;
    for (int i = 1; i < weights.length; i++) {
      if (diff <= 0) {
        break;
      }
      diff = diff - weights[i];
      count++;
    }
    
    if (diff == 0) {
      return count;
    }
    if (count - 1 < 0) {
      return 0;
    }
    return count - 1;
  }
  
  public static void main(String[] args) {
    ApplesToPut t = new ApplesToPut();
    int total = 5000;
    int[] weights = {4000, 500, 400, 300};
    System.out.println(t.maxAppleNum(weights, total));
    int[] weights2 = {4000, 500, 300, 200};
    System.out.println(t.maxAppleNum(weights2, total));
    int[] weights3 = {5001, 100, 200, 300};
    System.out.println(t.maxAppleNum(weights3, total));
    int[] weights4 = {4000};
    System.out.println(t.maxAppleNum(weights4, total));
    int[] weights5 = {4000, 300, 600, 200, 150};
    System.out.println(t.maxAppleNum(weights5, total));
  }
}