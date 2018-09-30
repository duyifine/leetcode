package binaryTree;

public class MaxNodePathSum {
  
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int[] result = new int[] {Integer.MIN_VALUE};
    helper(root, result);
    return result[0];
  }
  
  public int helper(TreeNode root, int[] result) {
    if (root == null) {
      return 0;
    }
    
    int leftMax = helper(root.left, result);
    int rightMax = helper(root.right, result);
    int max = Math.max(Math.max(root.value, leftMax + root.value), Math.max(rightMax + root.value, leftMax + rightMax + root.value));
    result[0] = Math.max(result[0], max);
    
    if (leftMax < 0 && rightMax < 0) {
      return root.value;
    }
    return Math.max(leftMax, rightMax) + root.value;
  }
}