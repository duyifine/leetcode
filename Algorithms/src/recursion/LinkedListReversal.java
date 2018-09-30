package recursion;

import linkedList.ListNode;

public class LinkedListReversal {
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode reHead = reverseInPairs(head.next.next);
    ListNode newHead = head.next;
    newHead.next = head;
    head.next = reHead;
    return newHead;
  }
}