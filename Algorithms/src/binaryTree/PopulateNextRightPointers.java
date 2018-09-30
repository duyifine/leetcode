package binaryTree;

public class PopulateNextRightPointers {
  
  public static class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
      val = x;
    }
  }
  
  public void connect(TreeLinkNode root) {
    if (root == null) return;
    
    if (root.left != null) {
      root.left.next = root.right;
    }
    if (root.right != null && root.next != null) {
      root.right.next = root.next.left;
    }
    
    connect(root.left);
    connect(root.right);
  }
  
  public void connectIterative(TreeLinkNode root) {
    if (root == null) return;
    
    TreeLinkNode levelStart = root;
    while (levelStart != null) {
      TreeLinkNode cur = levelStart;
      while (cur != null) {
        if (cur.left != null) {
          cur.left.next = cur.right;
        }
        if (cur.right != null && cur.next != null) {
          cur.right.next = cur.next.left;
        }
        cur = cur.next;
      }
      levelStart = levelStart.left;
    }
  }
  
  public void connectII(TreeLinkNode root) {
    if (root == null) return;
    
    if (root.left != null) {
      if (root.right != null) {
        root.left.next = root.right;
      } else {
        root.left.next = getNext(root);
      }
    }
    if (root.right != null) {
      root.right.next = getNext(root);
    }
    
    connectII(root.right);
    connectII(root.left);
  }
  
  public TreeLinkNode getNext(TreeLinkNode root) {
    TreeLinkNode next = root.next;
    while (next != null) {
      if (next.left != null) {
        return next.left;
      }
      if (next.right != null) {
        return next.right;
      }
      next = next.next;
    }
    return next;
  }
}