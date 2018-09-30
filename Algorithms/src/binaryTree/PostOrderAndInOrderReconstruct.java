package binaryTree;

import java.util.HashMap;

public class PostOrderAndInOrderReconstruct {
  
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
      return null;
    }
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    
    return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1, map);
  }
  
  public TreeNode helper(int[] inorder, int inorder_left, int inorder_right, int[] postorder, int postorder_index, HashMap<Integer, Integer> map) {
    if (postorder_index < 0 || inorder_left > inorder_right) {
      return null;
    }
    
    TreeNode root = new TreeNode(postorder[postorder_index]);
    int inorderIndex = map.get(postorder[postorder_index]);
    root.left = helper(inorder, inorder_left, inorderIndex - 1, postorder, postorder_index + (inorderIndex - inorder_right) - 1, map);
    root.right = helper(inorder, inorderIndex + 1, inorder_right, postorder, postorder_index - 1, map);
    return root;
  }
}