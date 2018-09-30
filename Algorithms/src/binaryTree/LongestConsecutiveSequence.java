package binaryTree;

public class LongestConsecutiveSequence {
  
  public int longestConsecutive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int[] result = new int[1];
    helper(root, 0, 0, result);
    return result[0];
  }
  
  public void helper(TreeNode root, int curMax, int prevValue, int[] result) {
    if (root == null) {
      return;
    }
    
    if (root.value == prevValue + 1) {
      curMax++;
    } else {
      curMax = 1;
    }
    result[0] = Math.max(result[0], curMax);
    helper(root.left, curMax, root.value, result);
    helper(root.right, curMax, root.value, result);
  }
  
  public static void main(String[] args) {
    LongestConsecutiveSequence t = new LongestConsecutiveSequence();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    System.out.println(t.longestConsecutive(root));
    TreeNode root2 = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.right.left = new TreeNode(2);
    root2.right.left.left = new TreeNode(1);
    System.out.println(t.longestConsecutive(root2));
  }
}