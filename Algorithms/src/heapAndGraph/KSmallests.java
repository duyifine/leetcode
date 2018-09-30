package heapAndGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallests {
  
  public int[] getKSmallestFromKSizeHeap(int[] array, int k) {
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,
        new Comparator<Integer>() {
          public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2)) {
              return 0;
            } else if (o1 > o2) {
              return -1;
            } else {
              return 1;
            }
          }
    });
    
    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = maxHeap.poll();
    }
    
    return result;
  }
  
  public int[] quickSelect(int[] array, int k) {
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    
    quickSelect(array, k, 0, array.length - 1);
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = array[i];
    }
    return result;
  }
  
  public void quickSelect(int[] array, int k, int left, int right) {
    if (left >= right) {
      return;
    }
    
    int pivotIndex = partition(array, k, left, right);
    if (pivotIndex >= k) {
      quickSelect(array, k, left, pivotIndex - 1);
    } else {
      quickSelect(array, k, left, pivotIndex - 1);
      quickSelect(array, k, pivotIndex + 1, right);
    }
  }
  
  public int partition(int[] array, int k, int left, int right) {
    int pivot = getRandomPivot(left, right);
    swap(array, pivot, right);
    int i = 0;
    int j = right - 1;
    while (i <= j) {
      if (array[i] < array[right]) {
        i++;
      } else {
        swap(array, i, j--);
      }
    }
    swap(array, i, right);
    return i;
  }
  
  public int getRandomPivot(int left, int right) {
    return left + (int) ((right - left + 1) * Math.random());
  }
  
  public void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
  
  public static void main(String[] args) {
    int[] array = {7,4,6,2,7,8,3,7,0,2,9};
    int k1 = 3;
    int k2 = 5;
    KSmallests t = new KSmallests();
    int[] result = t.quickSelect(array, k1);
    for (int i = 0; i < k1; i++) {
      System.out.println(result[i]);
    }
  }
}