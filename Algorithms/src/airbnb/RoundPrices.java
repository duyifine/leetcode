package airbnb;

import java.util.Arrays;

public class RoundPrices {
  
  public int[] roundUp(double[] prices) {
    if (prices == null || prices.length == 0) return new int[0];
    
    int[] result = new int[prices.length];
    int floorSum = 0;
    double sum = 0.0;
    double[][] diff = new double[prices.length][2];
    for (int i = 0; i < prices.length; i++) {
      int floor = (int) Math.floor(prices[i]);
      floorSum = floorSum + floor;
      sum = sum + prices[i];
      result[i] = floor;
      diff[i][0] = prices[i] - floor;
      diff[i][1] = i;
    }
    int roundedSum = (int) Math.round(sum);
    int count = roundedSum - floorSum;
    if (count == 0) return result;
    
    Arrays.sort(diff, (i1, i2) -> (Double.compare(i2[0], i1[0])));
    int i = 0;
    while (count > 0 && i < result.length) {
      result[(int)diff[i][1]] = result[(int)diff[i][1]] + 1;
      i++;
      count--;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    RoundPrices sol = new RoundPrices();
    double[] prices = {1.2, 3.7, 2.3, 4.8};
    int[] result = sol.roundUp(prices);
    for (int num : result) {
      System.out.println(num);
    }
    System.out.println("\n");
    
    double[] arr = new double[]{1.2, 2.3, 3.4};
    int[] res1 = sol.roundUp(arr);
    for (int num : res1) {
      System.out.println(num);
    }
    System.out.println("\n");

    double[] arr2 = new double[]{1.2, 3.7, 2.3, 4.8};
    int[] res2 = sol.roundUp(arr2);
    for (int num : res2) {
      System.out.println(num);
    }
    System.out.println("\n");

    double[] arr3 = new double[]{1.2, 2.5, 3.6, 4.0};
    int[] res3 = sol.roundUp(arr3);
    for (int num : res3) {
      System.out.println(num);
    }
    System.out.println("\n");
    
    double[] arr4 = new double[]{-0.4, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3, 1.3};
    int[] res4 = sol.roundUp(arr4);
    for (int num : res4) {
      System.out.println(num);
    }
    System.out.println("\n");
  }
}