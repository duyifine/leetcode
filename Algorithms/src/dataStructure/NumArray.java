package dataStructure;

public class NumArray {
   class SegmentTreeNode {
     int start;
     int end;
     int sum;
     SegmentTreeNode left;
     SegmentTreeNode right;
     public SegmentTreeNode(int start, int end) {
       this.start = start;
       this.end = end;
       this.left = null;
       this.right = null;
       this.sum = 0;
     }
   }
   
   SegmentTreeNode root = null;
   public SegmentTreeNode buildTree(int[] nums, int start, int end) {
     if (start > end) {
       return null;
     }
     
     SegmentTreeNode node = new SegmentTreeNode(start, end);
     if (start == end) {
       node.sum = nums[start];
     } else {
       int mid = start + (end - start) / 2;
       node.left = buildTree(nums, start, mid);
       node.right = buildTree(nums, mid + 1, end);
       node.sum = node.left.sum + node.right.sum;
     }
     return node;
   }
   
   public NumArray(int[] nums) {
     root = buildTree(nums, 0, nums.length - 1);
   }
   
   public void update(SegmentTreeNode root, int pos, int val) {
     if (root.start == root.end) {
       root.sum = val;
       return;
     }
     
     int mid = root.start + (root.end - root.start) / 2;
     if (pos <= mid) {
       update(root.left, pos, val);
     } else {
       update(root.right, pos, val);
     }
     root.sum = root.left.sum + root.right.sum;
   }
   
   public int sumRange(SegmentTreeNode root, int i, int j) {
     if (root.start == i && root.end == j) {
       return root.sum;
     }
     
     int mid = root.start + (root.end - root.start) / 2;
     if (i > mid) {
       return sumRange(root.right, i, j);
     } else if (j <= mid) {
       return sumRange(root.left, i, j);
     } else {
       return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
     }
   }
}