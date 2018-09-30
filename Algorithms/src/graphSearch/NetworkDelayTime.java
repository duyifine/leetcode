package graphSearch;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
  
  public int networkDelayTime(int[][] times, int N, int K) {
    if (times == null || times.length == 0) return -1;
    
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    for (int[] time : times) {
      if (!map.containsKey(time[0])) {
        map.put(time[0], new HashMap<>());
      }
      map.get(time[0]).put(time[1], time[2]);
    }
    
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(11, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        if (i1[1] < i2[1]) {
          return -1;
        } else if (i1[1] == i2[1]) {
          return 0;
        } else {
          return 1;
        }
      }
    });
    
    HashSet<Integer> visited = new HashSet<>();
    
    minHeap.offer(new int[] {K, 0});
    int result = 0;
    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      if (!visited.contains(top[0])) {
        result = top[1];
        visited.add(top[0]);
        HashMap<Integer, Integer> sourceMap = map.get(top[0]);
        if (sourceMap != null) {
          for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {
            int source = entry.getKey();
            if (!visited.contains(source)) {
              int time = result + entry.getValue();
              minHeap.offer(new int[] {source, time});
            }
          }
        }
      }
    }
    
    if (visited.size() == N) {
      return result;
    }
    
    return -1;
  }
}