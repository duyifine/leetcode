package binaryTree;

public class BalancedBinaryTree {
  
  
  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }
  
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    int diff = getHeight(root.left) - getHeight(root.right);
    if (Math.abs(diff) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }
  
  public int isBalancedII(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int left = isBalancedII(root.left);
    int right = isBalancedII(root.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}