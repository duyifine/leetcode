package binaryTree;

public class MaxNodePathSumBetweenRootLeaf {
  
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
    int cur = Math.max(root.value, Math.max(leftMax + root.value, rightMax + root.value));
    result[0] = Math.max(result[0], cur);
    return cur;
   }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(-5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(11);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(14);
    MaxNodePathSumBetweenRootLeaf m = new MaxNodePathSumBetweenRootLeaf();
    System.out.println(m.maxPathSum(root));
  }
}