package probability;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {
  private PriorityQueue<Integer> minHeap;
  private PriorityQueue<Integer> maxHeap;
  
  public MedianTracker() {
    maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
    minHeap = new PriorityQueue<Integer>(); // Nature order -- min heap by default
  }
  
  public void read(int value) {
    if (maxHeap.isEmpty()) {
      maxHeap.offer(value);
    } else {
      if (maxHeap.size() > minHeap.size()) {
        if (maxHeap.peek() > value) {
          minHeap.offer(maxHeap.poll());
          maxHeap.offer(value);
        } else {
          minHeap.offer(value);
        }
      } else if (maxHeap.size() == minHeap.size()) {
        if (minHeap.peek() < value) {
          maxHeap.offer(minHeap.poll());
          minHeap.offer(value);
        } else {
          maxHeap.offer(value);
        }
      }
    }
  }
  
  public Double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return (double) maxHeap.peek();
    } else {
      return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }
  }
  
  public static void main(String[] args) {
    MedianTracker m = new MedianTracker();
    m.read(1);
    System.out.println(m.findMedian());
    m.read(2);
    System.out.println(m.findMedian());
    m.read(3);
    System.out.println(m.findMedian());
  }
}