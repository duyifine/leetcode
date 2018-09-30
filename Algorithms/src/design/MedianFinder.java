package design;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
  
  private PriorityQueue<Integer> maxHeap;
  private PriorityQueue<Integer> minHeap;
  
  public MedianFinder() {
    this.maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
    this.minHeap = new PriorityQueue<>();
  }
  
  public void addNum(int num) {
    if (maxHeap.isEmpty()) {
      maxHeap.offer(num);
    } else if (maxHeap.size() > minHeap.size()) {
      if (num >= maxHeap.peek()) {
        minHeap.offer(num);
      } else {
        minHeap.offer(maxHeap.poll());
        maxHeap.offer(num);
      }
    } else if (maxHeap.size() == minHeap.size()) {
      if (num <= minHeap.peek()) {
        maxHeap.offer(num);
      } else {
        maxHeap.offer(minHeap.poll());
        minHeap.offer(num);
      }
    }
  }
  
  public double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return (double) maxHeap.peek();
    } else {
      return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }
  }
}