package linkedList;

public class InsertNode {
  
  public ListNode insertInSortedLinkedList(ListNode head, int target) {
    ListNode insertNode = new ListNode(target);
    if (head == null || target <= head.value) {
      insertNode.next = head;
      return insertNode;
    }
    
    ListNode cur = head;
    ListNode prev = cur;
    while (cur != null && cur.value <= target) {
      prev = cur;
      cur = cur.next;
    }
    prev.next = insertNode;
    insertNode.next = cur;
    
    return head;
  }
}