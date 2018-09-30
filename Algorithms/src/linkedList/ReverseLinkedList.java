package linkedList;

public class ReverseLinkedList {
  public ListNode reverseIterative(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    
    return prev;
  }
  
  public ListNode reverseRecursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

}