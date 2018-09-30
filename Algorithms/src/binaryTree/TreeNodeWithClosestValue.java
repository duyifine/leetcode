package binaryTree;

public class TreeNodeWithClosestValue {
  
  public TreeNode findClosest(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    
    TreeNode result = root;
    while (root != null) {
      if (root.value == target) {
        return root;
      } else {
        if (Math.abs(root.value - target) < Math.abs(result.value - target)) {
          result = root;
        }
        if (root.value < target) {
          root = root.right;
        } else {
          root = root.left;
        }
      }
    }
    return result;
  }
  
  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    if (root.value == target) {
      return root.value;
    }

    int childrenClosest = 0;
    if (root.value < target) {
      childrenClosest = closestValue(root.right, target);
    } else {
      childrenClosest = closestValue(root.left, target);
    }
    
    if (Math.abs(childrenClosest - target) <= Math.abs(root.value - target)) {
      return childrenClosest;
    } else {
      return root.value;
    }
  }
}