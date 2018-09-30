package binaryTree;

public class CountCompletedTreeNodes {
  
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    if (getLeftHeight(root.left) == getRightHeight(root.right)) {
      return (1 << getLeftHeight(root)) - 1;
    }
    return countNodes(root.left) + countNodes(root.right);
  }
  
  public int getLeftHeight(TreeNode root) {
    int height = 0;
    while (root != null) {
      root = root.left;
      height++;
    }
    
    return height;
  }
  
  public int getRightHeight(TreeNode root) {
    int height = 0;
    while (root != null) {
      root = root.right;
      height++;
    }
    return height;
  }
}