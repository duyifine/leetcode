package oa;

public class KthLargestElement {
  
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) return -1;
    
    quickSelect(nums, 0, nums.length - 1, k);
    return nums[k - 1];
  }
  
  public void quickSelect(int[] nums, int left, int right, int k) {
    if (left >= right) return;
    
    int pivot = partition(nums, left, right);
    if (pivot == k - 1) {
      return;
    } else if (pivot < k - 1) {
      quickSelect(nums, pivot + 1, right, k);
    } else {
      quickSelect(nums, left, pivot - 1, k);
    }
  }
  
  public int partition(int[] nums, int left, int right) {
    int pivotIndex = getRandomPivot(left, right);
    swap(nums, right, pivotIndex);
    int i = 0;
    int j = right - 1;
    while (i <= j) {
      if (nums[i] <= nums[right]) {
        i++;
      } else {
        swap(nums, i, j--);
      }
    }
    swap(nums, i, right);
    return i;
  }
  
  public int getRandomPivot(int left, int right) {
    return left + (int) ((right - left + 1) * Math.random());
  }
  
  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}