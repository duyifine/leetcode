package linkedList;

public class PartitionList {
  
  public ListNode partition(ListNode head, int target) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode dummyOne = new ListNode(0);
    ListNode curOne = dummyOne;
    ListNode dummyTwo = new ListNode(0);
    ListNode curTwo = dummyTwo;
    
    while (head != null) {
      if (head.value <= target) {
        curOne.next = head;
        curOne = curOne.next;
      } else {
        curTwo.next = head;
        curTwo = curTwo.next;
      }
      head = head.next;
    }
    // Terminate the second list
    curTwo.next = null;
    // Link two lists
    curOne.next = dummyTwo.next;
    
    return dummyOne.next;
  }
}