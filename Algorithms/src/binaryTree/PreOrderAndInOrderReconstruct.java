package binaryTree;

import java.util.HashMap;

public class PreOrderAndInOrderReconstruct {
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
      return null;
    }
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    
    return helper(preorder, 0, inorder, 0, inorder.length - 1, map);
  }
  
  public TreeNode helper(int[] preorder, int preorder_index, int[] inorder, int inorder_left, int inorder_right, HashMap<Integer, Integer> map) {
    if (preorder_index >= preorder.length || inorder_left > inorder_right) {
      return null;
    }
    
    TreeNode root = new TreeNode(preorder[preorder_index]);
    int inorderIndex = map.get(preorder[preorder_index]);
    root.left = helper(preorder, preorder_index + 1, inorder, inorder_left, inorderIndex - 1, map);
    root.right = helper(preorder, preorder_index + 1 + inorderIndex - inorder_left, inorder, inorderIndex + 1, inorder_right, map);
    return root;
  }
}