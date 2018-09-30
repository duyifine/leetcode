package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        if (l1.value < l2.value) {
          return -1;
        } else if (l1.value == l2.value) {
          return 0;
        } else {
          return 1;
        }
      }
    });
    
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    //pre-loading the listnodes to the min heap
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        minHeap.offer(lists[i]);
      }
    }
    
    while (!minHeap.isEmpty()) {
      ListNode top = minHeap.poll();
      if (top.next != null) {
        minHeap.offer(top.next);
      }
      cur.next = top;
      cur = cur.next;
    }
    
    return dummy.next;
  }
}