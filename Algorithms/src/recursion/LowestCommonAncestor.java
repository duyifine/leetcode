package recursion;

import binaryTree.TreeNode;

public class LowestCommonAncestor {
  
  public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    
    if (root == p || root == q) {
      return root;
    }
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null) {
      return root;
    } else {
      if (left != null) {
        return left;
      } else {
        return right;
      }
    }
  }
}