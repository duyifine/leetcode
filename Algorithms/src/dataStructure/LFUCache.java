package dataStructure;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
  
  HashMap<Integer, Integer> values;
  HashMap<Integer, Integer> counts;
  HashMap<Integer, LinkedHashSet<Integer>> freqLists;
  
  int limit;
  int min = 0;
  public LFUCache(int capacity) {
    this.limit = capacity;
    values = new HashMap<>();
    counts = new HashMap<>();
    freqLists = new HashMap<>();
    freqLists.put(1, new LinkedHashSet<>());
  }
  
  public int get(int key) {
    if (!values.containsKey(key)) {
      return -1;
    }
   
    int count = counts.get(key);
    counts.put(key, count + 1);
    freqLists.get(count).remove(key);
    if (count == min && freqLists.get(count).isEmpty()) {
      min++;
    }
    if (!freqLists.containsKey(count + 1)) {
      freqLists.put(count + 1, new LinkedHashSet<>());
    }
    freqLists.get(count + 1).add(key);
    return values.get(key);
  }
  
  public void set(int key, int value) {
    if (values.containsKey(key)) {
      values.put(key, value);
      get(key);
    } else {
      if (values.size() >= limit) {
        int evict = freqLists.get(min).iterator().next();
        freqLists.get(min).remove(evict);
        values.remove(evict);
      }
      values.put(key, value);
      counts.put(key, 1);
      min = 1;
      freqLists.get(1).add(key);
    }
  }
}