package array;

public class FindMedian {
  
  public float findMedianSortedArrays(int[] nums1, int[] nums2) {
    if ((nums1.length + nums2.length) % 2 != 0) {
      return findKthSmall(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2 + 1);
    } else {
      return (findKthSmall(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2 + 1) + findKthSmall(nums1, nums2, 0, 0, (nums1.length + nums2.length) / 2)) / 2;
    }
  }
  
  public float findKthSmall(int[] a, int[] b, int a_left, int b_left, int k) {
    if (a_left >= a.length) {
      return b[b_left + k - 1];
    }
    if (b_left >= b.length) {
      return a[a_left + k - 1];
    }
    if (k == 1) {
      return Math.min(a[a_left], b[b_left]);
    }
    
    int a_mid = a_left + k / 2 - 1;
    int b_mid = b_left + k / 2 - 1;
    int a_val;
    if (a_mid >= a.length) {
      a_val = Integer.MAX_VALUE;
    } else {
      a_val = a[a_mid];
    }
    int b_val;
    if (b_mid >= b.length) {
      b_val = Integer.MAX_VALUE;
    } else {
      b_val = b[b_mid];
    }
    
    if (a_val <= b_val) {
      return findKthSmall(a, b, a_mid + 1, b_left, k - k / 2);
    } else {
      return findKthSmall(a, b, a_left, b_mid + 1, k - k / 2);
    }
  }
}