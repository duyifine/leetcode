package linkedList;

import java.util.HashMap;

public class CopyLinkedList {
  
  public ListNode copy(ListNode head) {
    if (head == null) {
      return head;
    }
    
    HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
    ListNode newHead = new ListNode(head.value);
    ListNode dummyHead = newHead;
    map.put(head, newHead);
    while (head != null) {
      if (head.next != null) {
        if (map.containsKey(head.next)) {
          newHead.next = map.get(head.next);
        } else {
          newHead.next = new ListNode(head.next.value);
          map.put(head.next, newHead.next);
        }
      }
      head = head.next;
      newHead = newHead.next;
    }
    return dummyHead;
  }
  
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return head;
    }
    
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cur = dummy;
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    while (head != null) {
      if (!map.containsKey(head)) {
        map.put(head, new RandomListNode(head.label));
      }
      cur.next = map.get(head);
      if (head.random != null) {
        if (!map.containsKey(head.random)) {
          map.put(head.random, new RandomListNode(head.random.label));
        }
        cur.next.random = map.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}