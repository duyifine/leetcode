package binaryTree;

public class MaxLeafPathSum {
  
  public int maxLeafPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int[] result = new int[] {Integer.MIN_VALUE};
    maxPathSum(root, result);
    return result[0];
  }
  
  public int maxPathSum(TreeNode root, int[] result) {
    if (root == null) {
      return 0;
    }
    
    int leftMax = maxPathSum(root.left, result);
    int rightMax = maxPathSum(root.right, result);
    if (root.left != null && root.right != null) {
      result[0] = Math.max(result[0], leftMax + rightMax + root.value);
    }

    return Math.max(rightMax, leftMax) + root.value;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(-15);
    root.left = new TreeNode(5);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(-8);
    root.left.right = new TreeNode(1);
    root.left.left.left = new TreeNode(2);
    root.left.left.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(9);
    root.right.right.right = new TreeNode(0);
    root.right.right.right.left = new TreeNode(4);
    root.right.right.right.right = new TreeNode(-1);
    root.right.right.right.right.left = new TreeNode(10);
    MaxLeafPathSum m = new MaxLeafPathSum();
    System.out.println(m.maxLeafPathSum(root));
  }
}