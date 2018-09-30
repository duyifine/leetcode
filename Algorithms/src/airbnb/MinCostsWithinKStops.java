package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostsWithinKStops {
  
  public int minCost(List<String> lines, String src, String dest, int k) {
    if (lines == null || lines.size() == 0 || k < 0) return -1;
    if (src.equals(dest)) return 0;
    
    HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    for (String line : lines) {
      String[] str = line.trim().split(",");
      String[] stops = str[0].trim().split("->");
      String source = stops[0];
      String destination = stops[1];
      int cost = Integer.valueOf(str[1].trim());
      if (!map.containsKey(source)) {
        map.put(source, new HashMap<>());
      }
      map.get(source).put(destination, cost);
    }
    
    PriorityQueue<String[]> minHeap = new PriorityQueue<>(11, (s1, s2) -> (Integer.valueOf(s1[0]) - Integer.valueOf(s2[0])));
    minHeap.offer(new String[] {"0", src, String.valueOf(k)});
    while (!minHeap.isEmpty()) {
      String[] top = minHeap.poll();
      int price = Integer.valueOf(top[0]);
      String city = top[1];
      int stops = Integer.valueOf(top[2]);
      if (city.equals(dest)) return price;
      visited.add(city);
      if (stops >= 0) {
        if (map.containsKey(city)) {
          for (String c : map.get(city).keySet()) {
            if (!visited.contains(c)) {
              int costs = Integer.valueOf(map.get(city).get(c)) + price;
              minHeap.offer(new String[] {String.valueOf(costs), c, String.valueOf(stops - 1)});
            }
          }
        }
      }
    }
    
    return -1;
  }
  
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    if (n <= 0 || flights == null || flights.length == 0 || K < 0) return -1;
    int[][] dp = new int[n][K + 2];
    int max = 10000 * (K + 1) + 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < K + 2; j++) {
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
      result = Math.min(result, dp[dst][j]);
    }
    
    if (result == max) return -1;
    return result;
  }
  
  public static void main(String[] args) {
    MinCostsWithinKStops sol = new MinCostsWithinKStops();
    List<String> lines = new ArrayList<>();
    lines.add("A->B,100");
    lines.add("A->C,400");
    lines.add("B->C,100");
    lines.add("C->D,100");
    lines.add("C->A,10");
    System.out.println(sol.minCost(lines, "A", "D", 0));
    System.out.println(sol.minCost(lines, "A", "D", 1));
    System.out.println(sol.minCost(lines, "A", "D", 2));
  }
}