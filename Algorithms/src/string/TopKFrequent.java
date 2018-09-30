package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
  
  public List<String> findTopK(String[] words, int k) {
    List<String> result = new ArrayList<String>();
    if (words == null || words.length == 0 || k == 0) {
      return result;
    }
    
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < words.length; i++) {
      if (!map.containsKey(words[i])) {
        map.put(words[i], 1);
      } else {
        map.put(words[i], map.get(words[i]) + 1);
      }
    }
    
    PriorityQueue<String> maxHeap = new PriorityQueue<String>(map.size(), 
        new Comparator<String>() {
        public int compare(String s1 , String s2) {
          if (map.get(s1) == map.get(s2)) {
            return s1.compareTo(s2);
          } else if (map.get(s1) > map.get(s2)) {
            return -1;
          } else {
            return 1;
          }
        }
    });
    
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      maxHeap.offer(entry.getKey());
    }
    
    int i = 0;
    while (i < k) {
      result.add(maxHeap.poll());
      i++;
    }
    return result;
  }
  
  public static void main(String[] args) {
    int k = 2;
    String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
    TopKFrequent t = new TopKFrequent();
    System.out.println(t.findTopK(words, k));
  }
}