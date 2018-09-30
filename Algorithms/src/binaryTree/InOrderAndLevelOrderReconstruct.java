package binaryTree;

import java.util.HashMap;

public class InOrderAndLevelOrderReconstruct {
  
  public TreeNode buildTree(int[] inorder, int[] levelorder) {
    if (inorder == null || levelorder == null || inorder.length == 0 || levelorder.length == 0) {
      return null;
    }
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(inorder, 0, inorder.length - 1, levelorder, map);
  }
  
  public TreeNode helper(int[] inorder, int inorder_left, int inorder_right, int[] levelorder, HashMap<Integer, Integer> map) {
    if (inorder_left > inorder_right) {
      return null;
    }
    
    TreeNode root = new TreeNode(levelorder[0]);
    int inorderIndex = map.get(levelorder[0]);
    int[] left = new int[inorderIndex - inorder_left];
    int[] right = new int[levelorder.length - left.length - 1];
    HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorderIndex; i++) {
      leftMap.put(inorder[i], i);
    }
    int left_index = 0;
    int right_index = 0;
    for (int i = 1; i < levelorder.length; i++) {
      if (leftMap.containsKey(levelorder[i])) {
        left[left_index++] = levelorder[i];
      } else {
        right[right_index++] = levelorder[i];
      }
    }
    root.left = helper(inorder, inorder_left, inorderIndex - 1, left, map);
    if (root.left != null) {
      System.out.println("root.left=" + root.left.value);
    }
    root.right = helper(inorder, inorderIndex + 1, inorder_right, right, map);
    if (root.right != null) {
      System.out.println("root.right=" + root.right.value);
    }
    if (root != null) {
      System.out.println("root=" + root.value);
    }
    return root;
  }
  
  public static void main(String[] args) {
    int[] inorder = {4,8,10,12,14,20,22};
    int[] levelorder = {20,8,22,4,12,10,14};
    InOrderAndLevelOrderReconstruct t = new InOrderAndLevelOrderReconstruct();
    t.buildTree(inorder, levelorder);
  }
}