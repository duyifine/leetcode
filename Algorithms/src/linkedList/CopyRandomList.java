package linkedList;

import java.util.HashMap;

public class CopyRandomList {
  
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) return null;
    
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode cur = dummy;
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