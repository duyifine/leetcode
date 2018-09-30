package heapAndGraph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import linkedList.ListNode;

public class KWayMerge {
  
  public static class Entry {
    int x;
    int y;
    int value;
    Entry(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
  
  public int[] mergeKSortedArray(int[][] arrayOfArrays) {
    if (arrayOfArrays == null) {
      return null;
    }
    
    int k = arrayOfArrays.length;
    int length = arrayOfArrays[0].length;
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(k, new Comparator<Entry>() {
      @Override
      public int compare(Entry e1, Entry e2) {
        if (e1.value == e2.value) {
          return 0;
        } else if (e1.value < e2.value) {
          return -1;
        } else {
          return 1;
        }
      }
    });
    for (int i = 0; i < k; i++) {
      minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
    }
    int[] result = new int[k * length];
    int i = 0;
    while (!minHeap.isEmpty()) {
      Entry top = minHeap.poll();
      result[i++] = top.value;
      if (top.y < length - 1) {
        minHeap.offer(new Entry(top.x, top.y + 1, arrayOfArrays[top.x][top.y + 1]));
      }
    }
    return result;
  }
  
  public ListNode mergeKSortedList(List<ListNode> listOfLists) {
    if (listOfLists == null) {
      return null;
    }
    
    int k = listOfLists.size();
    PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode n1, ListNode n2) {
        if (n1.value == n2.value) {
          return 0;
        } else if (n1.value < n2.value) {
          return -1;
        } else {
          return 1;
        }
      }
    });
    for (ListNode node : listOfLists) {
      minHeap.offer(node);
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!minHeap.isEmpty()) {
      ListNode top = minHeap.poll();
      if (top.next != null) {
        minHeap.offer(top.next);
      }
      cur.next = top;
      cur = cur.next;
    }
    return dummy.next;
  }
  
  public static void main(String[] args) {
    int[] array1 = {1,3,5,7};
    int[] array2 = {0,3,4,6};
    int[] array3 = {3,4,5,6};
    int[][] arrayOfArrays = {array1, array2, array3};
    KWayMerge m = new KWayMerge();
    int[] result = m.mergeKSortedArray(arrayOfArrays);
    for (int i : result) {
      System.out.println(i);
    }
  }
}