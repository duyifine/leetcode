package binaryTree;

import java.util.List;

public class KNodesLCA {
  
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    if (root == null) {
      return root;
    }
    for (TreeNode node : nodes) {
      if (root == node) {
        return root;
      }
    }
    TreeNode left = lowestCommonAncestor(root.left, nodes);
    TreeNode right = lowestCommonAncestor(root.right, nodes);
    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else {
      return right;
    }
  }
}