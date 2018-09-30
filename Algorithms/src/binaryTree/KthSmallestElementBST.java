package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElementBST {
  
  public int kthSmallest(TreeNode root, int k) {
    if (root == null || k <= 0) return 0;
    
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;
    while (cur != null) {
      stack.offerFirst(cur);
      cur = cur.left;
    }
    
    int count = 0;
    while (!stack.isEmpty()) {
      TreeNode top = stack.pollFirst();
      count++;
      if (count == k) return top.value;
      TreeNode right = top.right;
      while (right != null) {
        stack.offerFirst(right);
        right = right.left;
      }
    }
    
    return 0;
  }
  
  public int kthSmallestII(TreeNode root, int k) {
    if (root == null || k <= 0) return 0;
    
    int leftNodes = countNodes(root.left);
    if (leftNodes + 1 == k) {
      return root.value;
    } else if (leftNodes + 1 < k) {
      return kthSmallestII(root.right, k - leftNodes - 1);
    } else {
      return kthSmallestII(root.left, k);
    }
  }
  
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}