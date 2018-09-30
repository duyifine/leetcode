package oa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCostToDest {
  
  //vertices[i][0]: source; vertices[i][1]: destination; vertices[i][2]: weights
  public int maxCost(int[][] vertices, int dest) {
    if (vertices == null || vertices.length == 0) return 0;
    
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < vertices.length; i++) {
      if (!map.containsKey(vertices[i][1])) {
        map.put(vertices[i][1], new ArrayList<>());
      }
      //map key is the destination
      //map value contains int array: [0]: source; [1]: negation of the costs from source to dest
      map.get(vertices[i][1]).add(new int[] {vertices[i][0], -vertices[i][2]});
    }
    
    //min heap contains int array: [0]: source; [1]: negation of costs from dest
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
    
    if (!map.containsKey(dest)) return 0;
    List<int[]> sources = map.get(dest);
    for (int[] source : sources) {
      minHeap.offer(source);
    }
    
    int max = 0;
    while (!minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      max = Math.max(-top[1], max);
      if (map.get(top[0]) != null) {
        List<int[]> list = map.get(top[0]);
        for (int[] array : list) {
          minHeap.offer(new int[] {array[0], array[1] + top[1]});
        }
      }
    }
    
    return max;
  }
}