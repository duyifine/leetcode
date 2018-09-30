package heapAndGraph;

import java.util.Deque;
import java.util.LinkedList;

import binaryTree.TreeNode;

public class CompletedBinaryTree {
  
  public boolean isCompleted(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    if ((root.left != null && root.right == null) || (root.right != null && root.left == null)) {
      return false;
    }
    return isCompleted(root.left) && isCompleted(root.right);
  }
  
  public boolean checkCompleted(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offerFirst(root);
    while (!queue.isEmpty()) {
      TreeNode top = queue.pollLast();
      if (top.left == null && top.right == null) {
        return true;
      } else if (top.left != null && top.right != null) {
        queue.offerFirst(top.left);
        queue.offerFirst(top.right);
      } else {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = null;
    root.left.right.left = new TreeNode(9);
    root.left.right.right = null;
    root.left.left.left = null;
    root.left.left.right = null;
    root.right.left.left = null;
    root.right.left.right = null;
    
    CompletedBinaryTree c = new CompletedBinaryTree();
    System.out.println(c.checkCompleted(root));
    System.out.println(c.isCompleted(root));
    
    TreeNode root2 = new TreeNode(10);
    System.out.println(c.checkCompleted(root2));
    System.out.println(c.isCompleted(root2));
  }
}