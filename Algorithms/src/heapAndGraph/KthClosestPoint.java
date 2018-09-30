package heapAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class KthClosestPoint {
/**  
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    List<Integer> result = new ArrayList<>();
    if (a == null || b == null || c == null || a.length == 0 || b.length == 0 || c.length == 0 || k == 0) {
      return result;
    }
    
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>(k,
        new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> l1, List<Integer> l2) {
        int x1 = a[l1.get(0)];
        int y1 = b[l1.get(1)];
        int z1 = c[l1.get(2)];
        int x2 = a[l2.get(0)];
        int y2 = b[l2.get(1)];
        int z2 = c[l2.get(2)];
        if (x1 * x1 + y1 * y1 + z1 * z1 < x2 * x2 + y2 * y2 + z2 * z2) {
          return -1;
        } else if (x1 * x1 + y1 * y1 + z1 * z1 > x2 * x2 + y2 * y2 + z2 * z2) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
    List<Integer> cur = Arrays.asList(0,0,0);
    minHeap.offer(cur);
    visited.add(cur);
    while (k > 0) {
      cur = minHeap.poll();
      List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if (next.get(0) < a.length && visited.add(next)) {
        minHeap.offer(next);
      }
      next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if (next.get(1) < b.length && visited.add(next)) {
        minHeap.offer(next);
      }
      next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if (next.get(2) < c.length && visited.add(next)) {
        minHeap.offer(next);
      }
      k--;
    }
    cur.set(0, a[cur.get(0)]);
    cur.set(1, a[cur.get(1)]);
    cur.set(2, a[cur.get(2)]);
    
    return cur;
  }
  
  public static void main(String[] args) {
    KthClosestPoint t = new KthClosestPoint();
    int k = 3;
    int[] a = {1,2,3};
    int[] b = {2,4,5};
    int[] c = {-2, -1, 8};
    t.closest(a, b, c, k);
  } **/
}