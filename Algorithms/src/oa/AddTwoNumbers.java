package oa;

import linkedList.ListNode;

public class AddTwoNumbers {
  
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    
    return helper(l1, l2, 0);
  }
  
  public ListNode helper(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) return null;
    
    int sum = carry;
    if (l1 != null) {
      sum = sum + l1.value;
    }
    if (l2 != null) {
      sum = sum + l2.value;
    }
    if (sum > 9) {
      carry = 1;
      sum = sum - 10;
    } else {
      carry = 0;
    }
    
    ListNode node = new ListNode(sum);
    if (l1.next != null && l2.next != null) {
      node.next = helper(l1.next, l2.next, carry);
    } else if (l1.next != null) {
      node.next = helper(l1.next, null, carry);
    } else if (l2.next != null) {
      node.next = helper(null, l2.next, carry);
    } else {
      node.next = helper(null, null, carry);
    }
    
    return node;
  }
}