package linkedList;

public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || head.next == null) return head;
    
    ListNode left = head;
    int i = m - 1;
    while (i > 1) {
        if (left == null) return null;
        left = left.next;
        i--;
    }
    ListNode right = head;
    int j = n - 1;
    while (j > 0) {
        if (right == null) return null;
        right = right.next;
        j--;
    }
    
    ListNode prev = null;
    if (m != 1) {
        prev = left;
        left = left.next;
    }
    ListNode next = null;
    if (right != null) {
        next = right.next;
    }
    right.next = null;
    System.out.println(left.value);
    System.out.println(right.value);
    ListNode newHead = reverse(left);
    left.next = next;
    if (prev != null) {
        prev.next = newHead;
        return head;
    } else {
        return newHead;
    }
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
        System.out.println("cur=" + cur.value);
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    
    return prev;
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    ReverseLinkedListII s = new ReverseLinkedListII();
    s.reverseBetween(head, 2, 4);
  }
}