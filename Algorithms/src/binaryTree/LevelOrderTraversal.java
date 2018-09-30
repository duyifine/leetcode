package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {
  
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offerFirst(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> layer = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode top = queue.pollLast();
        if (top.left != null) {
          queue.offerFirst(top.left);
        }
        if (top.right != null) {
          queue.offerFirst(top.right);
        }
        layer.add(top.value);
      }
      result.add(layer);
    }
    
    return result;
  }
}