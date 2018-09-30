package threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerPattern {
  
  
  public static class BlockingQueue {
    private int[] buffer;
    private int head;
    private int tail = -1;
    private int size;
    
    public BlockingQueue(int k) {
      buffer = new int[k];
    }
    
    public synchronized void enQueue(int value) throws InterruptedException {
      while (size == buffer.length) {
        wait();
      }
      tail = (tail + 1) % buffer.length;
      buffer[tail] = value;
      size++;
      System.out.println(Thread.currentThread().getName() + " offer " + value);
      notifyAll();
    }
    
    public synchronized int deQueue() throws InterruptedException {
      while (size == 0) {
        wait();
      }
      int value = buffer[head];
      head = (head + 1) % buffer.length;
      size--;
      notifyAll();
//      System.out.println(Thread.currentThread().getName() + " poll " + value);
      return value;
    }
  }
  
  public static class Producer extends Thread {
    private BlockingQueue queue;
    private static int id;
    private Random random;
    
    public Producer(String name, BlockingQueue queue, int seed) {
      super(name);
      this.queue = queue;
      this.random = new Random(seed);
    }
    
    public void run() {
      try {
        while (true) {
          Thread.sleep(random.nextInt(1000));
          queue.enQueue(nextId());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    
    public static synchronized int nextId() {
      return id++;
    }
  }
  
  public static class Consumer extends Thread {
    private Random random;
    private BlockingQueue queue;
    
    public Consumer(String name, BlockingQueue queue, int seed) {
      super(name);
      this.queue = queue;
      this.random = new Random(seed);
    }
    
    public void run() {
      try {
        while (true) {
          int value = queue.deQueue();
          Thread.sleep(random.nextInt(1000));
          System.out.println(Thread.currentThread().getName() + " poll " + value);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    ProducerConsumerPattern main = new ProducerConsumerPattern();
    BlockingQueue queue = new BlockingQueue(10);
//    new Producer("producer-1", queue, 24).start();
//    new Producer("producer-2", queue, 25).start();
//    new Producer("producer-3", queue, 26).start();
//    new Consumer("consumer-1", queue, 27).start();
//    new Consumer("consumer-2", queue, 28).start();
//    new Consumer("consumer-3", queue, 29).start();
    ExecutorService executorSerivce = Executors.newFixedThreadPool(5);
    executorSerivce.submit(new Producer("producer-1", queue, 1));
    executorSerivce.submit(new Consumer("consumer-1", queue, 1));
  }
}