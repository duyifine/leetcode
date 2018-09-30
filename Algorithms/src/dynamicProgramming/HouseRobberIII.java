package dynamicProgramming;

import binaryTree.TreeNode;

public class HouseRobberIII {
  
  public int rob(TreeNode root) {
    if (root == null) return 0;
    
    int[] result = helper(root);
    
    return Math.max(result[0], result[1]);
  }
  
  public int[] helper(TreeNode root) {
    if (root == null) return new int[2];
    
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    int[] result = new int[2];
    result[0] = left[1] + right[1] + root.value;
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    
    return result;
  }
}