package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCombinationSum {
  
  double eps = 10e-6;
  
  public List<List<Double>> getCombos(double[] prices, double target) {
    List<List<Double>> result = new ArrayList<>();
    if (prices == null || prices.length == 0 || target <= 0.0) return result;
    
    Arrays.sort(prices);
    List<Double> subList = new ArrayList<>();
    helper(prices, target, 0, result, subList);
    
    return result;
  }
  
  public void helper(double[] prices, double target, int index, List<List<Double>> result, List<Double> subList) {
    if (target < eps && target >= 0) {
      result.add(new ArrayList<>(subList));
      return;
    }
    if (target < 0) return;
    
    for (int i = index; i < prices.length; i++) {
      if (i > index && prices[i] == prices[i - 1]) continue;
      if (prices[i] > target) break;
      subList.add(prices[i]);
      helper(prices, target - prices[i], i + 1, result, subList);
      subList.remove(subList.size() - 1);
    }
  }
  
  public static void main(String[] args) {
    MenuCombinationSum s = new MenuCombinationSum();
    double[] prices = {10.02, 1.11, 2.22, 3.01, 4.02, 2.00, 5.03};
    List<List<Double>> combos = s.getCombos(prices, 7.03);
    System.out.println(combos);
  }
}