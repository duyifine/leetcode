package threads;

public class OddEvenVolatile {
  
  boolean printEven;
  boolean printOdd;
  
  class PrintEven implements Runnable {
    public void run() {
      for (int i = 0; i <= 10; i += 2) {
        while (!printEven) {
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(i);
        
        synchronized(this) {
          printEven = false;
          printOdd = true;
        }
      }
    }
  }
  
  class PrintOdd implements Runnable {
    public void run() {
      for (int i = 1; i < 10; i += 2) {
        while (!printOdd) {
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(i);
        
        synchronized(this) {
          printOdd = false;
          printEven = true;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    OddEvenVolatile t = new OddEvenVolatile();
    PrintEven e = t.new PrintEven();
    PrintOdd o = t.new PrintOdd();
    
    Thread to = new Thread(o);
    Thread te = new Thread(e);
    te.start();
    to.start();
    t.printEven = true;
  }
}