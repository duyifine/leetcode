package binaryTree;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ClosestLeaf {
  
  public int findClosestLeaf(TreeNode root, int k) {
    if (root == null) return -1;
    
    HashMap<TreeNode, TreeNode> backMap = new HashMap<>();
    TreeNode target = dfs(root, k, backMap);
    
    Deque<TreeNode> queue = new LinkedList<>();
    HashSet<TreeNode> visited = new HashSet<>();
    visited.add(target);
    queue.offerFirst(target);
    
    while (!queue.isEmpty()) {
      TreeNode cur = queue.pollLast();
      if (cur.left == null && cur.right == null) {
        return cur.value;
      } 
      if (cur.left != null && !visited.contains(cur.left)) {
        queue.offerFirst(cur.left);
      } 
      if (cur.right != null && !visited.contains(cur.right)) {
        queue.offerFirst(cur.right);
      }
      if (backMap.containsKey(cur) && !visited.contains(backMap.get(cur))) {
        queue.offerFirst(backMap.get(cur));
      }
    }
    
    return -1;
  }
  
  public TreeNode dfs(TreeNode root, int k, HashMap<TreeNode, TreeNode> backMap) {
    if (root == null) return null;
    if (root.value == k) return root;
    
    if (root.value > k) {
      TreeNode left = dfs(root.left, k, backMap);
      if (left != null) {
        backMap.put(left, root);
        return left;
      }
    } else if (root.value < k) {
      TreeNode right = dfs(root.right, k, backMap);
      if (right != null) {
        backMap.put(right, root);
        return right;
      }
    }
    
    return null;
  }
}