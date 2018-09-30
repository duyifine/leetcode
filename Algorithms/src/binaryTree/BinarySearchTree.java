package binaryTree;

public class BinarySearchTree {
  
  public boolean isBST(TreeNode root) {
     return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public boolean isBST(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    
    if (root.value <= min || root.value >= max) {
      return false;
    }
    return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
  }
  
  public void nodeInGivenRange(TreeNode root, int min, int max) {
    if (root == null) {
      return;
    }
    
    if (root.value > min) {
      nodeInGivenRange(root.left, min, max);
    }
    if (root.value >= min && root.value <= max) {
      System.out.println(root.value);
    }
    if (root.value < max) {
      nodeInGivenRange(root.right, min, max);
    }
  }
}