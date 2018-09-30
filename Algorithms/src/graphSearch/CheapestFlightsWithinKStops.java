package graphSearch;

import java.util.HashMap;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
  
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if (n <= 0 || flights == null || flights.length == 0 || K < 0) return -1;
    
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    for (int[] flight: flights) {
      if (!map.containsKey(flight[0])) {
        map.put(flight[0], new HashMap<>());
      }
      map.get(flight[0]).put(flight[1], flight[2]);
    }
    
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> (a1[0] - a2[0]));
    minHeap.offer(new int[] {0, src, K});
    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      int price = top[0];
      int city = top[1];
      int stops = top[2];
      if (city == dst) return price;
      if (stops >= 0) {
        if (map.containsKey(city)) {
          for (int c : map.get(city).keySet()) {
            minHeap.offer(new int[] {price + map.get(city).get(c), c, stops - 1});
          }
        }
      }
    }
    
    return -1;
  }
  
  public int findCheapestPriceII(int n, int[][] flights, int src, int dst, int K) {
    if (n <= 0 || flights == null || flights.length == 0 || K < 0) return -1;
    // dp[i][j] indicates the prices of reaching loc j within j stops
    int[][] dp = new int[n][K + 2];
    // the max price of each flight is 10000
    int max = 10000 * (K + 1) + 1; 
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= K + 1; j++) {
        dp[i][j] = max;
      }
    }
    
    dp[src][0] = 0;
    
    for (int j = 1; j <= K + 1; j++) {
      for (int[] flight : flights) {
        dp[flight[1]][j] = Math.min(dp[flight[1]][j], dp[flight[0]][j - 1] + flight[2]);
      }
    }
    
    int result = max;
    for (int j = 1; j <= K + 1; j++) {
      result = Math.min(dp[dst][j], result);
    }
    
    if (result == max) return -1;
    return result;
  }
}