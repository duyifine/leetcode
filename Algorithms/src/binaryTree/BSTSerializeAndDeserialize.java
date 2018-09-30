package binaryTree;

public class BSTSerializeAndDeserialize {
  
  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    StringBuilder sb = new StringBuilder();
    preorder(root, sb);
    return sb.toString();
  }
  
  public void preorder(TreeNode root, StringBuilder sb) {
    if (root == null) return;
    
    sb.append(root.value).append(",");
    preorder(root.left, sb);
    preorder(root.right, sb);
  }
  
  public TreeNode serialize(String data) {
    if (data == null) return null;
    
    String[] arr = data.split(",");
    int[] index = {0};
    return helper(arr, index, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  public TreeNode helper(String[] arr, int[] index, long min, long max) {
    if (index[0] >= arr.length) return null;
    
    TreeNode root = null;
    int val = Integer.parseInt(arr[index[0]]);
    if (val > min && val < max) {
      root = new TreeNode(val);
      index[0]++;
      root.left = helper(arr, index, min, val);
      root.right = helper(arr, index, val, max);
    }
    
    return root;
  }
}