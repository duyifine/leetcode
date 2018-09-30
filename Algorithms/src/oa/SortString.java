package oa;

import java.util.PriorityQueue;

public class SortString {
  
  public String sortSegments(String s) {
    if (s == null || s.length() == 0 || s.length() == 1) {
      return s;
    }
    
    PriorityQueue<Character> minHeap = new PriorityQueue<>();
    boolean numFlag = (s.charAt(0) <= '9' && s.charAt(0) >= '0');
    boolean preFlag = numFlag;
    
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < s.length()) {
      numFlag = (s.charAt(i) <= '9' && s.charAt(i) >= '0');
      if (numFlag == preFlag) {
        minHeap.offer(s.charAt(i));
        i++;
      } else {
        StringBuilder tmp = new StringBuilder();
        while (!minHeap.isEmpty()) {
          tmp.append(minHeap.poll());
        }
        sb.append(tmp.toString());
      }
      preFlag = numFlag;
    }
    
    while (!minHeap.isEmpty()) {
      sb.append(minHeap.poll());
    }
    
    return sb.toString();
  }
  
  public static void main(String[] args) {
    SortString t = new SortString();
    System.out.println(t.sortSegments("AYUKB17053UI903TBC"));
  }
}