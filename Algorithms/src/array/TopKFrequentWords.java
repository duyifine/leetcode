package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
  
  public List<String> topKFrequent(String[] words, int k) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) return result;
    
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (!map.containsKey(word)) {
        map.put(word, 1);
      } else {
        map.put(word, map.get(word) + 1);
      }
    }
    
    PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (map.get(s1) < map.get(s2)) {
          return -1;
        } else if (map.get(s1) > map.get(s2)) {
          return 1;
        } else {
          return -s1.compareTo(s2);
        }
      }
    });
    
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      minHeap.offer(entry.getKey());
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    
    while (!minHeap.isEmpty()) {
      result.add(0, minHeap.poll());
    }
    
    return result;
  }
}