package binaryTree;

public class SymmetricBinaryTree {
  
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    return isSymmetric(root.left, root.right);
  }
  
  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    } else if (left == null || right == null) {
      return false;
    } else if (left.value != right.value) {
      return false;
    }
    
    return isSymmetric(left.left, left.right) && isSymmetric(right.left, right.right);
  }
}