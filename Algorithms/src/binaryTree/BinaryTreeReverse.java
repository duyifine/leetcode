package binaryTree;

public class BinaryTreeReverse {
  
  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
    
    TreeNode newRoot = reverse(root.left);
    root.left.right = root;
    root.left.left = root.right;
    root.left = null;
    root.right = null;
    return newRoot;
  }
}