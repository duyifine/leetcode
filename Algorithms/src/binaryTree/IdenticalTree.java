package binaryTree;

public class IdenticalTree {
  
  public boolean isIdentical(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null || root2 == null) {
      return false;
    } else if (root1.value != root2.value) {
      return false;
    }
    
    return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
  }
}