package oa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
  
  public String reorganizeString(String S) {
    if (S == null || S.length() == 0) return "";
    
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        int count = map.get(c);
        if (count + 1 > (S.length() + 1) / 2) return "";
        map.put(c, count + 1);
      }
    }
    
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(11, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        if (i1[1] > i2[1]) {
          return -1;
        } else if (i1[1] == i2[1]) {
          return 0;
        } else {
          return 1;
        }
      }      
    });
    
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      maxHeap.offer(new int[] {entry.getKey(), entry.getValue()});
    }
    
    StringBuilder sb = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      int[] top = maxHeap.poll();
      if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char) top[0]) {
        sb.append((char) top[0]);
        top[1]--;
        if (top[1] > 0) {
          maxHeap.offer(top);
        }
      } else {
        int[] next = maxHeap.poll();
        sb.append((char) next[0]);
        maxHeap.offer(top);
        next[1]--;
        if (next[1] > 0) {
          maxHeap.offer(next);
        }
      }
    }
    
    return sb.toString();
  }
  
  public static void main(String[] args) {
    String S = "aab";
    ReorganizeString s = new ReorganizeString();
    System.out.println(s.reorganizeString(S));
  }
}