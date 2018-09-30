package linkedList;

public class MergeTwoSortedList {
  
  public ListNode merge(ListNode head1, ListNode head2) {
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    
    ListNode newHead;
    if (head1.value <= head2.value) {
      newHead = head1;
      head1 = head1.next;
    } else {
      newHead = head2;
      head2 = head2.next;
    }
    ListNode cur = newHead;
    
    while (head1 != null && head2 != null) {
      if (head1.value <= head2.value) {
        cur.next = head1;
        head1 = head1.next;
      } else {
        cur.next = head2;
        head2 = head2.next;
      }
      cur = cur.next;
    }
    
    while (head1 != null) {
      cur.next = head1;
      head1 = head1.next;
      cur = cur.next;
    }
    while (head2 != null) {
      cur.next = head2;
      head2 = head2.next;
      cur = cur.next;
    }
    
    return newHead;
  }
}