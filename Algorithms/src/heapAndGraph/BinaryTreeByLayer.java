package heapAndGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import binaryTree.TreeNode;

public class BinaryTreeByLayer {
  
  public List<List<Integer>> BFS(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offerFirst(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> layer = new ArrayList<Integer>();
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
  
  public List<List<Integer>> getZigZag(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offerFirst(root);
    int flag = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> layer = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        if (flag % 2 == 0) {
          TreeNode top = queue.pollLast();
          if (top.left != null) {
            queue.offerFirst(top.left);
          }
          if (top.right != null) {
            queue.offerFirst(top.right);
          }
          layer.add(top.value);
        } else {
          TreeNode top = queue.pollFirst();
          if (top.right != null) {
            queue.offerLast(top.right);
          }
          if (top.left != null) {
            queue.offerLast(top.left);
          }
          layer.add(top.value);
        }
      }
      flag++;
      result.add(layer);
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
    BinaryTreeByLayer b = new BinaryTreeByLayer();
    List<List<Integer>> r = b.getZigZag(root);
    System.out.println(r);
  }
}