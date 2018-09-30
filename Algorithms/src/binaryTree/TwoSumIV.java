package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIV {
  
  public boolean findTarget(TreeNode root, int k) {
    if (root == null || (root.left == null && root.right == null)) return false;
    
    HashSet<Integer> set = new HashSet<>();
    return helper(root, k, set);
  }
  
  public boolean helper(TreeNode root, int k, HashSet<Integer> set) {
    if (root == null) return false;
    
    if (set.contains(k - root.value)) {
      return true;
    } else {
      set.add(root.value);
      return helper(root.left, k, set) || helper(root.right, k, set);
    }
  }
  
  public boolean findTargetII(TreeNode root, int k) {
    if (root == null || (root.left == null && root.right == null)) return false;
    
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);
    int i = 0;
    int j = nums.size() - 1;
    while (i < j) {
      if (nums.get(i) + nums.get(j) == k) {
        return true;
      } else if (nums.get(i) + nums.get(j) < k) {
        i++;
      } else {
        j--;
      }
    }
    
    return false;
  }
  
  public void inorder(TreeNode root, List<Integer> nums) {
    if (root == null) return;
    
    inorder(root.left, nums);
    nums.add(root.value);
    inorder(root.right, nums);
  }
}