package airbnb;

import java.util.ArrayList;
import java.util.List;

public class QueueByArrayLists {
  
  private int size;
  private int headCol;
  private int headRow;
  private int tailCol;
  private int tailRow;
  private int count;
  private List<List<Integer>> list;
  
  public QueueByArrayLists(int fixedSize) {
    size = fixedSize;
    list = new ArrayList<>();
    list.add(new ArrayList<>());
  }
  
  public void offer(int num) {
    if (tailCol == size - 1) {
      list.add(new ArrayList<>());
      tailRow++;
      tailCol = 0;
      list.get(tailRow).add(num);
    } else {
      list.get(tailRow).add(num);
      tailCol++;
    }
    count++;
  }
  
  public Integer poll() {
    if (headCol == size) {
      headRow++;
      headCol = 0;
    }
    if (list.get(headRow) == null || list.get(headRow).isEmpty()) return null;
    Integer num = list.get(headRow).get(headCol);
    if (num == null) return null;
    headCol++;
    count--;
    return num;
  }
  
  public int size() {
    return count;
  }
  
  public static void main(String[] args) {
    QueueByArrayLists queue = new QueueByArrayLists(5);
    System.out.println(queue.poll());
    queue.offer(1);
    queue.offer(2);
    int res = queue.poll();
    System.out.println(res);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    queue.offer(6);
    queue.offer(7);
    queue.offer(8);
    queue.offer(9);
    res = queue.poll();
    System.out.println(res);
    res = queue.poll();
    System.out.println(res);
  }
}