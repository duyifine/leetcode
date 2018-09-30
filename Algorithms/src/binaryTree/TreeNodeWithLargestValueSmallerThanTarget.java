package binaryTree;

public class TreeNodeWithLargestValueSmallerThanTarget {
  
  public TreeNode findLargest(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    
    while (root != null && root.value >= target) {
      root = root.left;
    }
    while (root != null && root.right.value < target) {
      root = root.right;
    }
    
    return root;
  }
  
  public TreeNode findLargest2(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    
    TreeNode result = null;
    while (root != null) {
      if (root.value >= target) {
        root = root.left;
      } else {
        result = root;
        root = root.right;
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(-4);
    root.left.right = new TreeNode(-3);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);
    TreeNodeWithLargestValueSmallerThanTarget t = new TreeNodeWithLargestValueSmallerThanTarget();
    System.out.println(t.findLargest(root, 4).value);
  }
}