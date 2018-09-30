package binaryTree;

public class SimmilarBinaryTree {
  
  public boolean isSimilar(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null || root2 == null) {
      return false;
    }
    if (root1.value != root2.value) {
      return false;
    }
    
    return (isSimilar(root1.left, root2.left) && isSimilar(root1.right, root2.right)) || (isSimilar(root1.left, root2.right) && isSimilar(root1.right, root2.left));
  }
}