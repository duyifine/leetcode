package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {
  
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
        return new int[0];
    }
    
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> list = null;
    if (nums1.length < nums2.length) {       
        list = helper(nums2, nums1);
    } else {
        list = helper(nums1, nums2);
    }
    if (list.size() == 0) {
        return new int[0];
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        result[i] = list.get(i);
    }
    return result;
  }

  public List<Integer> helper(int[] large, int[] small) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < small.length; i++) {
        int left = 0;
        int right = large.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (large[mid] == small[i]) {
                result.add(small[i]);
                break;
            } else if (large[mid] < small[i]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return result;
  }
}