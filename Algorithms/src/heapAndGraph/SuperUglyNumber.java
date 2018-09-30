package heapAndGraph;

import java.util.PriorityQueue;

public class SuperUglyNumber {
  
  public int nthSuperUglyNumber(int n, int[] primes) {
    if (n <= 0 || primes == null || primes.length  == 0) {
        return -1;
    }
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(1);
    int top = 1;
    int prev = 0;
    while (!minHeap.isEmpty() && n > 0) {
        top = minHeap.poll();
        System.out.println("top=" + top);
        if (prev != top) {
          n--;
        }
        for (int i = 0; i < primes.length; i++) {
            minHeap.offer(top * primes[i]);
        }
        prev = top;
    }
    
    return top;
  }
  
  public static void main(String[] args) {
    SuperUglyNumber t = new SuperUglyNumber();
    int n = 12;
    int[] primes = {2,7,13,19};
    System.out.println(t.nthSuperUglyNumber(n, primes));
  }
}