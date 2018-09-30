package binaryTree;

public class HouseRobber {
  
  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int[] result = helper(root);
    return Math.max(result[0], result[1]);
  }
  
//  result[0]: the max money robbed without the current root val
//  result[1]: the max money robbed with the current root val
  public int[] helper(TreeNode root) {
    if (root == null) {
      return new int[2];
    }
    
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    int[] result = new int[2];
    result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    result[1] = left[0] + right[0] + root.value;
    
    return result;
  }
}