package recursion;

import binaryTree.TreeNode;

public class MaxDiffNode {
  
  public TreeNode maxDiff(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    TreeNode node = new TreeNode(0);
    int diff = -1;
    numNodes(root, node, diff);
    return node;
  }
  
  public int numNodes(TreeNode root, TreeNode node, int diff) {
    if (root == null) {
      return 0;
    }
    
    int leftNodes = numNodes(root.left, node, diff);
    int rightNodes = numNodes(root.right, node, diff);
    if (Math.abs(leftNodes - rightNodes) > diff) {
      diff = Math.abs(leftNodes - rightNodes);
      node = root;
    }
    
    return leftNodes + rightNodes + 1;
  }
}