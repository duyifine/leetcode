package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTreeTraversal {
  
  public List<List<Integer>> getZigZag(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    int level = 0;
    while (!stack.isEmpty()) {
      int size = stack.size();
      List<Integer> layer = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        if (level % 2 == 0) {
          TreeNode cur = stack.pollFirst();
          if (cur.right != null) {
            stack.offerLast(cur.right);
          }
          if (cur.left != null) {
            stack.offerLast(cur.left);
          }
          layer.add(cur.value);
        } else {
          TreeNode cur = stack.pollLast();
          if (cur.left != null) {
            stack.offerFirst(cur.left);
          }
          if (cur.right != null) {
            stack.offerFirst(cur.right);
          }
          layer.add(cur.value);
        }
      }
      result.add(layer);
      level++;
    }
    return result;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(1);
    root.right.left= new TreeNode(15);
    root.right.right = new TreeNode(7);
    ZigZagTreeTraversal z = new ZigZagTreeTraversal();
    List<List<Integer>> r = z.getZigZag(root);
    System.out.println(r);
  }
}