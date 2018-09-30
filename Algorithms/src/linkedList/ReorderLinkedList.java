package linkedList;

public class ReorderLinkedList {
  
  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    MiddleOfLinkedList m = new MiddleOfLinkedList();
    ListNode middle = m.findMiddle(head);
    ReverseLinkedList r = new ReverseLinkedList();
    ListNode second_half = r.reverseIterative(middle.next);
    // De-link the first half from the list
    middle.next = null;
    
    ListNode dummyHead = new ListNode(0);
    ListNode newHead = dummyHead.next;
    while (head != null && second_half != null) {
      dummyHead.next = head;
      head = head.next;
      dummyHead.next.next = second_half;
      second_half = second_half.next;
      dummyHead = dummyHead.next.next;
    }
    
    if (head != null) {
      dummyHead.next = head;
    } else if (second_half != null) {
      dummyHead.next = second_half;
    }
    
    return newHead;
  }
}