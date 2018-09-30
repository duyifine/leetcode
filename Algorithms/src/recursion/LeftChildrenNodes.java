package recursion;

import binaryTree.TreeNode;

public class LeftChildrenNodes {
  
  public int getLeftChildrenTotal(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    getTotalNodes(root);
    return root.leftChildNum;
  }
  
  public int getTotalNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftNum = getTotalNodes(root.left);
    int rightNum = getTotalNodes(root.right);
    root.leftChildNum = leftNum;
    return leftNum + rightNum + 1;
  }
}