package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalTraversal {
  
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
    Deque<Integer> level = new LinkedList<Integer>();
    
    queue.offer(root);
    level.offer(0);
    
    int minLevel = 0;
    int maxLevel = 0;
    
    while (!queue.isEmpty()) {
      TreeNode top = queue.poll();
      int l = level.poll();
      minLevel = Math.min(minLevel, l);
      maxLevel = Math.max(maxLevel, l);
      if (map.containsKey(l)) {
        map.get(l).add(top.value);
      } else {
        List<Integer> list = new ArrayList<Integer>();
        list.add(top.value);
        map.put(l, list);
      }
      if (top.left != null) {
        queue.offer(top.left);
        level.offer(l - 1);
      }
      if (top.right != null) {
        queue.offer(top.right);
        level.offer(l + 1);
      }
    }
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for (int i = minLevel; i <= maxLevel; i++) {
      if (map.containsKey(i)) {
        result.add(map.get(i));
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    BinaryTreeVerticalTraversal t = new BinaryTreeVerticalTraversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(7);
    System.out.println(t.verticalOrder(root));
  }
}