package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreePathTargetSum {
  
  public boolean containsTargetSum(TreeNode root, int target) {
    if (root == null) {
      return false;
    }
    
    List<Integer> path = new ArrayList<Integer>();
    return helper(root, target, path);
  }
  
  public boolean helper(TreeNode root, int target, List<Integer> path) {
    if (root == null) {
      return false;
    }
    
    path.add(root.value);
    if (checkTarget(target, path)) {
      return true;
    }
    if (helper(root.left, target, path)) {
      return true;
    }
    if (helper(root.right, target, path)) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }
  
  public boolean checkTarget(int target, List<Integer> path) {
    int sum = 0;
    for (int i = path.size() - 1; i >= 0; i--) {
      sum = sum + path.get(i);
      if (sum == target) {
        return true;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(11);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(14);
    root.right.left.left = new TreeNode(8);
    root.right.left.right = new TreeNode(9);
    TreePathTargetSum t = new TreePathTargetSum();
    System.out.println(t.containsTargetSum(root, 17));
    System.out.println(t.containsTargetSum(root, 10));
  }
}