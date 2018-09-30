package linkedList;

public class EvenNodesRemoval {
  
  public ListNode removeEven(ListNode root) {
    if (root == null) {
      return null;
    }
    if (root.next == null) {
      return root;
    }
    
    ListNode next = removeEven(root.next.next);
    ListNode curNext = root.next;
    root.next = next;
    curNext.next = null;
    
    return root;
  }
  
  public ListNode removeEvenII(ListNode root) {
    if (root == null) {
      return null;
    }
    
    ListNode cur = root;
    while (cur != null) {
      if (cur.next != null && cur.next.next != null) {
        ListNode nextOdd = cur.next.next;
        cur.next.next = null;
        cur.next = nextOdd;
        cur = nextOdd;
      } else {
        cur.next = null;
        cur = cur.next;
      }
    }
    
    return root;
  }
}