package binaryTree;

import java.util.HashMap;

public class SerializeAndDeserialize {
//Encodes a tree to a single string.
  public String serialize(TreeNode root) {
      if (root == null) {
          return null;
      }
      StringBuilder preOrderSb = new StringBuilder("");
      StringBuilder inOrderSb = new StringBuilder("");
      preOrder(root, preOrderSb);
      inOrder(root, inOrderSb);
      
      inOrderSb.deleteCharAt(inOrderSb.length() - 1);
      return preOrderSb.append(inOrderSb).toString();
  }
  
  public void preOrder(TreeNode root, StringBuilder sb) {
      if (root == null) {
          return;
      }
      
      sb.append(root.value).append(",");
      preOrder(root.left, sb);
      preOrder(root.right, sb);
  }
  
  public void inOrder(TreeNode root, StringBuilder sb) {
      if (root == null) {
          return;
      }
      
      inOrder(root.left, sb);
      sb.append(root.value).append(",");
      inOrder(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      if (data == null) {
          return null;
      }
      
      String[] splitted = data.split(",");
      int len = splitted.length;
      int[] preOrder = new int[len / 2];
      int[] inOrder = new int[len / 2];
      for (int i = 0; i < len / 2; i++) {
          preOrder[i] = Integer.parseInt(splitted[i]);
      }
      for (int i = 0; i < len / 2; i++) {
          inOrder[i] = Integer.parseInt(splitted[i + len / 2]);
      }
      
      HashMap<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
      for (int i = 0; i < inOrder.length; i++) {
          inOrderMap.put(inOrder[i], i);
      }
      return construct(preOrder, 0, inOrder, 0, inOrder.length - 1, inOrderMap);
  }
  
  public TreeNode construct(int[] preOrder, int index, int[] inOrder, int left, int right, HashMap<Integer, Integer> map) {
      if (index >= preOrder.length || left > right) {
          return null;
      }
      
      TreeNode root = new TreeNode(preOrder[index]);
      int mid = map.get(preOrder[index]);
      root.left = construct(preOrder, index + 1, inOrder, left, mid - 1, map);
      root.right = construct(preOrder, index + mid + 1 - left, inOrder, mid + 1, right, map);
      return root;
  }
  
  public static void main(String[] args) {
    SerializeAndDeserialize t = new SerializeAndDeserialize();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(t.serialize(root));
    t.deserialize(t.serialize(root));
  }
}