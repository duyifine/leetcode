package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class InorderPredecessor {
  
  public static class TreeNodeP {
    int val;
    TreeNodeP parent;
    TreeNodeP left;
    TreeNodeP right;
    public TreeNodeP(int val) {
      this.val = val;
    }
  }
  
  public TreeNode predecessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) {
      return null;
    }
    
    if (root.value >= p.value) {
      return predecessor(root.left, p);
    } else {
      TreeNode right = predecessor(root.right, p);
      if (right == null) {
        return root;
      }
      return right;
    }
  }
  
  public TreeNode predecessorII(TreeNode root, TreeNode p) {
    if (root == null || p == null) {
      return null;
    }
    
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;
    TreeNode prev = null;
    while (!stack.isEmpty() || cur != null) {
      if (cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      } else {
        TreeNode top = stack.pollFirst();
        if (top.value == p.value) {
          return prev;
        }
        prev = top;
        cur = top.right;
      }
    }
    
    return null;
  }
  
  public TreeNodeP predecessor(TreeNodeP p) {
    if (p == null) {
      return null;
    }
    
    TreeNodeP dummy = p;
    if (p.left != null) {
      TreeNodeP cur = p.left;
      while (cur.right != null) {
        cur = cur.right;
      }
      return cur;
    } else {
      while (dummy.parent != null) {
        if (dummy.parent.val < p.val) {
          return dummy.parent;
        }
        dummy = dummy.parent;
      }
    }
    
    return null;
  }
  
  public static void main(String[] args) {
    InorderPredecessor t = new InorderPredecessor();
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    TreeNodeP rootP = new TreeNodeP(20);
    rootP.left = new TreeNodeP(8);
    rootP.right = new TreeNodeP(22);
    rootP.left.parent = rootP;
    rootP.right.parent = rootP;
    rootP.left.left = new TreeNodeP(4);
    rootP.left.left.parent = rootP.left;
    rootP.left.right = new TreeNodeP(12);
    rootP.left.right.parent = rootP.left;
    rootP.left.right.left = new TreeNodeP(10);
    rootP.left.right.left.parent = rootP.left.right;
    rootP.left.right.right = new TreeNodeP(14);
    rootP.left.right.right.parent = rootP.left.right;
    System.out.println(t.predecessor(root, new TreeNode(8)).value);
    System.out.println(t.predecessorII(root, new TreeNode(8)).value);
    System.out.println(t.predecessor(rootP.left).val);
    System.out.println(t.predecessor(root, new TreeNode(10)).value);
    System.out.println(t.predecessorII(root, new TreeNode(10)).value);
    System.out.println(t.predecessor(rootP.left.right.left).val);
    System.out.println(t.predecessor(root, new TreeNode(14)).value);
    System.out.println(t.predecessorII(root, new TreeNode(14)).value);
    System.out.println(t.predecessor(rootP.left.right.right).val);
  }
}