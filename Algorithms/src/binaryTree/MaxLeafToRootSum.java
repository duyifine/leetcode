package binaryTree;

public class MaxLeafToRootSum {
  
  public int maxLeafToRootSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftSum = maxLeafToRootSum(root.left);
    int rightSum = maxLeafToRootSum(root.right);
    return Math.max(leftSum, rightSum) + root.value;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(-2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(8);
    root.left.right = new TreeNode(-4);
    root.right.left = new TreeNode(-1);
    root.right.right = new TreeNode(-2);
    MaxLeafToRootSum m = new MaxLeafToRootSum();
    System.out.println(m.maxLeafToRootSum(root));
  }
}