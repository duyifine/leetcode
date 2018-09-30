package linkedList;

public class QueueImpl {
  
  public static class QNode {
    int key;
    QNode next;
    
    public QNode(int key) {
      this.key = key;
      this.next = null;
    }
  }
  
  QNode head;
  QNode tail;
  
  public QueueImpl() {
    this.head = null;
    this.tail = null;
  }
  
  public void offer(int key) {
    QNode cur = new QNode(key);
    if (this.head == null) {
      this.head = this.tail = cur;
    } else {
      this.tail.next = cur;
      this.tail = cur;
    }
  }
  
  public QNode poll() {
    if (this.head == null) {
      return null;
    }
    QNode cur = this.head;
    this.head = this.head.next;
    if (this.head == null) {
      this.tail = null;
    }
    return cur;
  }
}