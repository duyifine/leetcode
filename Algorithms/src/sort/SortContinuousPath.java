package sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortContinuousPath {
  
  public static class Pair<K, V> {
    K key;
    V value;
    Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }
    K getKey() {
      return this.key;
    }
    V getValue() {
      return this.value;
    }
    public String toString() {
      String s = "key=" + this.key + ",value=" + this.value + ";";
      return s;
    }
  }
  
  public Pair<Integer, Integer>[] sortPath(Pair<Integer, Integer>[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    
    Arrays.sort(array, new Comparator<Pair<Integer, Integer>>(){
      @Override
      public int compare(Pair<Integer, Integer> e1, Pair<Integer, Integer> e2) {
        int min1;
        int max1;
        if (e1.getKey() < e1.getValue()) {
          min1 = e1.getKey();
          max1 = e1.getValue();
        } else {
          min1 = e1.getValue();
          max1 = e1.getKey();
        }
        int min2;
        int max2;
        if (e2.getKey() < e2.getValue()) {
          min2 = e2.getKey();
          max2 = e2.getValue();
        } else {
          min2 = e2.getValue();
          max2 = e2.getKey();
        }
        if (min1 < min2) {
          return -1;
        } else if (min1 > min2) {
          return 1;
        } else {
          return max1 < max2 ? -1 : 1;
        }
      }
    });
    
    return array;
  }
  
  public static void main(String[] args) {
    Pair<Integer, Integer> p1 = new Pair(4,5);
    Pair<Integer, Integer> p2 = new Pair(9,4);
    Pair<Integer, Integer> p3 = new Pair(11,9);
    Pair<Integer, Integer> p4 = new Pair(5,1);
    Pair<Integer, Integer>[] array = new Pair[4];
    array[0] = p1;
    array[1] = p2;
    array[2] = p3;
    array[3] = p4;
    SortContinuousPath s = new SortContinuousPath();
    Pair<Integer, Integer>[] result = s.sortPath(array);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i].toString());
    }
  }
}