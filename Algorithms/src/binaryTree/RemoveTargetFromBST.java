package binaryTree;

public class RemoveTargetFromBST {
  
  public TreeNode remove(TreeNode root, int target) {
    if (root == null) {
      return root;
    }
    
    if (root.value > target) {
      root.left = remove(root.left, target);
    } else if (root.value < target) {
      root.right = remove(root.right, target);
    } else {
      if (root.left != null && root.right != null) {
        TreeNode smallest = findSmallest(root.right);
        root.value = smallest.value;
        root.right = remove(root.right, smallest.value);
      } else if (root.left != null) {
        return root.left;
      } else {
        return root.right;
      }
    }
    return root;
  }
  
  public TreeNode findSmallest(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}