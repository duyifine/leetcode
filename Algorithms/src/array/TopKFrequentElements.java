package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
  
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (!map.containsKey(num)) {
        map.put(num, 1);
      } else {
        map.put(num, map.get(num) + 1);
      }
    }
    
    List<Integer>[] buckets = new List[nums.length + 1];
    for (int n : map.keySet()) {
      int freq = map.get(n);
      if (buckets[freq] == null) {
        buckets[freq] = new ArrayList<>();
      }
      buckets[freq].add(n);
    }
    
    for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
      if (buckets[i] != null) {
        List<Integer> cur = buckets[i];
        result.addAll(cur);
        k = k - cur.size();
      }
    }
    
    return result;
  }
}