package threads;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
  private List queue = new LinkedList();
  private int limit;
  
  public BlockingQueue(int limit) {
    this.limit = limit;
  }
  
  public synchronized void enqueue(Object item) throws InterruptedException {
    while (this.queue.size() == this.limit) {
      wait();
    }
    if (this.queue.size() == 0) {
      notifyAll();
    }
    this.queue.add(item);
  }
  
  public synchronized Object deque() throws InterruptedException {
    while (this.queue.size() == 0) {
      wait();
    }
    if (this.queue.size() == limit) {
      notifyAll();
    }
    
    return this.queue.remove(0);
  }
}