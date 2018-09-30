package binaryTree;

public class LCAInBinarySearchTree {
  
  public TreeNode lca(TreeNode root, TreeNode one, TreeNode two) {
    if (root == null) {
      return root;
    }
    if (root.value < one.value && root.value < two.value) {
      return lca(root.right, one, two);
    } else if (root.value > one.value && root.value > two.value) {
      return lca(root.left, one, two);
    } else {
      return root;
    }
  }
}