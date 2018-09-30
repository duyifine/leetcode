package heapAndGraph;

import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallestProduct {
  
  public int kthSmallest(int k) {
    if (k == 0) {
      return 0;
    }
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
    minHeap.offer(3 * 5 * 7);
    HashSet<Integer> visited = new HashSet<Integer>();
    visited.add(3 * 5 * 7);
    while (k > 1) {
      int top = minHeap.poll();
      if (visited.add(top * 3)) {
        minHeap.offer(top * 3);
      }
      if (visited.add(top * 5)) {
        minHeap.offer(top * 5);
      }
      if (visited.add(top * 7)) {
        minHeap.offer(top * 7);
      }
      k--;
    }
    
    return minHeap.peek();
  }
  
  public static void main(String[] args) {
    int k = 5;
    KthSmallestProduct t = new KthSmallestProduct();
    System.out.println(t.kthSmallest(k));
  }
}