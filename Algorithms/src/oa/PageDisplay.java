package oa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class PageDisplay {
  
  public List<String> displayPages(List<String> input, int pageSize) {
    List<String> result = new ArrayList<>();
    if (input == null || input.size() == 0 || pageSize <= 0) return result;
    
    HashSet<String> visited = new HashSet<>();
    Iterator<String> iter = input.iterator();
    int count = pageSize;
    while (iter.hasNext()) {
      String cur = iter.next();
      String id = cur.split(",")[0];
      if (!visited.contains(id)) {
        result.add(cur);
        visited.add(id);
        iter.remove();
        count--;
      }
      
      if (count == 0) {
        if (!input.isEmpty()) {
          result.add(" ");
        }
        visited.clear();
        count = pageSize;
        iter = input.iterator();
      }
      
      if (!iter.hasNext()) {
        visited.clear();
        iter = input.iterator();
      }
    }
    
    return result;
  }
  
  public String[] displayPagesII(String[] input, int pageSize) {
    List<String> list = new ArrayList<>();
    if (input == null || input.length == 0 || pageSize <= 0) return new String[0];
    
    HashSet<String> visited = new HashSet<>();
    LinkedList<String> strList = new LinkedList<>(Arrays.asList(input));
    Iterator<String> iter = strList.iterator();
    int count = pageSize;
    while (iter.hasNext()) {
      String cur = iter.next();
      String id = cur.split(",")[0];
      if (!visited.contains(id)) {
        list.add(cur);
        visited.add(id);
        iter.remove();
        count--;
      }
      
      if (count == 0) {
        if (!strList.isEmpty()) {
          list.add(" ");
        }
        visited.clear();
        count = pageSize;
        iter = strList.iterator();
      }
      
      if (!iter.hasNext()) {
        visited.clear();
        iter = strList.iterator();
      }
    }
    
    String[] result = new String[list.size()];
    result = list.toArray(result);
    
    return result;
  }
  
  public String[] displayPagesIII(String[] input, int pageSize) {
    if (input == null || input.length == 0 || pageSize <= 0) return new String[0];
    
    LinkedHashMap<String, LinkedList<Integer>> map = new LinkedHashMap<>();
    for (int i = 0; i < input.length; i++) {
      String id = input[i].split(",")[0];
      if (!map.containsKey(id)) {
        map.put(id, new LinkedList<>());
      }
      map.get(id).add(i);
    }
    
    int uniqeSize = map.size();
    if (uniqeSize < pageSize) {
      PriorityQueue<String> minHeap = new PriorityQueue<>(uniqeSize, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
          String id1 = s1.split(",")[0];
          String id2 = s2.split(",")[0];
          if (map.get(id1).get(0) < map.get(id2).get(0)) {
            return -1;
          } else if (map.get(id1).get(0) > map.get(id2).get(0)) {
            return 1;
          } else {
            return 0;
          }
        }
      });
      
      int count = pageSize;
      int resultLen = 0;
      int index = 0;
      if (input.length % pageSize == 1) {
        resultLen = input.length + input.length / pageSize;
      } else {
        resultLen = input.length + input.length / pageSize - 1;
      }
      String[] result = new String[resultLen];
      while (index < resultLen) {
        for (Map.Entry<String, LinkedList<Integer>> entry : map.entrySet()) {
          if (entry.getValue().size() > 0) {
            minHeap.offer(entry.getKey());
          }
        }
        while(!minHeap.isEmpty() && count > 0) {
          if (!minHeap.isEmpty()) {
            String top = minHeap.poll();
            result[index++] = input[map.get(top).get(0)];
            if (map.get(top).size() > 0) {
              map.get(top).remove(0);
            }
            count--;
          }
        }
        while (!minHeap.isEmpty()) {
          minHeap.poll();
        }
        if (count == 0 && index < resultLen) {
          result[index++] = " ";
          count = pageSize;
        }
      }
      
      return result;
    } else {
      return displayPagesII(input, pageSize);
    }
  }
  
  public List<String> displayPagesIII(List<String> input, int pageSize) {
    List<String> result = new ArrayList<>();
    if (input == null || input.size() == 0 || pageSize <= 0) return result;
    
    LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<>();
    for (int i = 0; i < input.size(); i++) {
      String id = input.get(i).split(",")[0];
      if (!map.containsKey(id)) {
        map.put(id, new ArrayList<>());
      }
      map.get(id).add(i);
    }
    
    int size = map.size();
    PriorityQueue<String> minHeap = new PriorityQueue<>(size, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (map.get(s1).get(0) < map.get(s2).get(0)) {
          return -1;
        } else if (map.get(s1).get(0) > map.get(s2).get(0)) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    
    int count = pageSize;
    int resultLen = 0;
    int index = 0;
    if (input.size() % pageSize == 1) {
      resultLen = input.size() + input.size() / pageSize;
    } else {
      resultLen = input.size() + input.size() / pageSize - 1;
    }
    while (result.size() < resultLen) {
      for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
        if (entry.getValue().size() > 0) {
          minHeap.offer(entry.getKey());
        }
      }
      while(!minHeap.isEmpty() && count > 0) {
        String top = minHeap.poll();
        result.add(input.get(map.get(top).get(0)));
        if (map.get(top).size() > 0) {
          map.get(top).remove(0);
        }
        count--;
      }
      while (!minHeap.isEmpty()) {
        minHeap.poll();
      }
      if (count == 0 && result.size() < resultLen) {
        result.add(" ");
        count = pageSize;
      }
    }
    
    return result;
  }
/**  
  public class indexComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      String id1 = s1.split(",")[0];
      String id2 = s2.split(",")[0];
      if (map.get(id1).get(0) < map.get(id2).get(0)) {
        return -1;
      } else if (map.get(id1).get(0) > map.get(id2).get(0)) {
        return 1;
      } else {
        return 0;
      }
    }
  }**/
  
  public static class UnitTest {
    @Test
    public void test() {
      PageDisplay s = new PageDisplay();
      String[] strs = new String[]{
        "1,28,300.1,SanFrancisco",
        "4,5,209.1,SanFrancisco",
        "20,7,208.1,SanFrancisco",
        "23,8,207.1,SanFrancisco",
        "16,10,206.1,Oakland",
        "1,16,205.1,SanFrancisco",
        "6,29,204.1,SanFrancisco",
        "7,20,203.1,SanFrancisco",
        "8,21,202.1,SanFrancisco",
        "2,18,201.1,SanFrancisco",
        "2,30,200.1,SanFrancisco",
        "15,27,109.1,Oakland",
        "10,13,108.1,Oakland",
        "11,26,107.1,Oakland",
        "12,9,106.1,Oakland",
        "13,1,105.1,Oakland",
        "22,17,104.1,Oakland",
        "1,2,103.1,Oakland",
        "28,24,102.1,Oakland",
        "18,14,11.1,SanJose",
        "6,25,10.1,Oakland",
        "19,15,9.1,SanJose",
        "3,19,8.1,SanJose",
        "3,11,7.1,Oakland",
        "27,12,6.1,Oakland",
        "1,3,5.1,Oakland",
        "25,4,4.1,SanJose",
        "5,6,3.1,SanJose",
        "29,22,2.1,SanJose",
        "30,23,1.1,SanJose"
      };
      List<String> input = new ArrayList<>(Arrays.asList(strs));
      List<String> result = s.displayPages(input, 12);
      System.out.println(result);
      assertEquals(32, result.size());
      assertEquals("1,28,300.1,SanFrancisco", result.get(0));
      assertEquals("11,26,107.1,Oakland", result.get(11));
      assertEquals(" ", result.get(12));
      assertEquals("1,16,205.1,SanFrancisco", result.get(13));
      assertEquals("2,30,200.1,SanFrancisco", result.get(14));
      assertEquals("25,4,4.1,SanJose", result.get(24));
      assertEquals(" ", result.get(25));
      assertEquals("1,2,103.1,Oakland", result.get(26));
      assertEquals("3,11,7.1,Oakland", result.get(27));
      assertEquals("30,23,1.1,SanJose", result.get(30));
      assertEquals("1,3,5.1,Oakland", result.get(31));
    }
    
    @Test
    public void test2() {
        PageDisplay sol = new PageDisplay();
        String[] strs = new String[]{
                "1,28,310.6,SF",
                "4,5,204.1,SF",
                "20,7,203.2,Oakland",
                "6,8,202.2,SF",
                "6,10,199.1,SF",
                "1,16,190.4,SF",
                "6,29,185.2,SF",
                "7,20,180.1,SF",
                "6,21,162.1,SF",
                "2,18,161.2,SF",
                "2,30,149.1,SF",
                "3,76,146.2,SF",
                "2,14,141.1,San Jose"

        };
        List<String> input = new ArrayList<>(Arrays.asList(strs));
        List<String> result = sol.displayPages(input, 5);
        assertEquals(15, result.size());
        assertEquals("1,28,310.6,SF", result.get(0));
        assertEquals("7,20,180.1,SF", result.get(4));
        assertEquals(" ", result.get(5));
        assertEquals("6,10,199.1,SF", result.get(6));
        assertEquals("6,29,185.2,SF", result.get(10));
        assertEquals(" ", result.get(11));
        assertEquals("6,21,162.1,SF", result.get(12));
        assertEquals("2,14,141.1,San Jose", result.get(14));
    }
    
    @Test
    public void test3() {
      PageDisplay s = new PageDisplay();
      String[] strs = new String[]{
        "1,28,300.1,SanFrancisco",
        "4,5,209.1,SanFrancisco",
        "20,7,208.1,SanFrancisco",
        "23,8,207.1,SanFrancisco",
        "16,10,206.1,Oakland",
        "1,16,205.1,SanFrancisco",
        "6,29,204.1,SanFrancisco",
        "7,20,203.1,SanFrancisco",
        "8,21,202.1,SanFrancisco",
        "2,18,201.1,SanFrancisco",
        "2,30,200.1,SanFrancisco",
        "15,27,109.1,Oakland",
        "10,13,108.1,Oakland",
        "11,26,107.1,Oakland",
        "12,9,106.1,Oakland",
        "13,1,105.1,Oakland",
        "22,17,104.1,Oakland",
        "1,2,103.1,Oakland",
        "28,24,102.1,Oakland",
        "18,14,11.1,SanJose",
        "6,25,10.1,Oakland",
        "19,15,9.1,SanJose",
        "3,19,8.1,SanJose",
        "3,11,7.1,Oakland",
        "27,12,6.1,Oakland",
        "1,3,5.1,Oakland",
        "25,4,4.1,SanJose",
        "5,6,3.1,SanJose",
        "29,22,2.1,SanJose",
        "30,23,1.1,SanJose"
      };
      String[] result = s.displayPagesII(strs, 12);
      for (String str : result) {
        System.out.println(str);
      }
      assertEquals(32, result.length);
      assertEquals("1,28,300.1,SanFrancisco", result[0]);
      assertEquals("11,26,107.1,Oakland", result[11]);
      assertEquals(" ", result[12]);
      assertEquals("1,16,205.1,SanFrancisco", result[13]);
      assertEquals("2,30,200.1,SanFrancisco", result[14]);
      assertEquals("25,4,4.1,SanJose", result[24]);
      assertEquals(" ", result[25]);
      assertEquals("1,2,103.1,Oakland", result[26]);
      assertEquals("3,11,7.1,Oakland", result[27]);
      assertEquals("30,23,1.1,SanJose", result[30]);
      assertEquals("1,3,5.1,Oakland", result[31]);
    }
    
    @Test
    public void test4() {
        PageDisplay sol = new PageDisplay();
        String[] strs = new String[]{
                "1,28,310.6,SF",
                "4,5,204.1,SF",
                "20,7,203.2,Oakland",
                "6,8,202.2,SF",
                "6,10,199.1,SF",
                "1,16,190.4,SF",
                "6,29,185.2,SF",
                "7,20,180.1,SF",
                "6,21,162.1,SF",
                "2,18,161.2,SF",
                "2,30,149.1,SF",
                "3,76,146.2,SF",
                "2,14,141.1,San Jose"

        };
        String[] result = sol.displayPagesII(strs, 5);
        assertEquals(15, result.length);
        assertEquals("1,28,310.6,SF", result[0]);
        assertEquals("7,20,180.1,SF", result[4]);
        assertEquals(" ", result[5]);
        assertEquals("6,10,199.1,SF", result[6]);
        assertEquals("6,29,185.2,SF", result[10]);
        assertEquals(" ", result[11]);
        assertEquals("6,21,162.1,SF", result[12]);
        assertEquals("2,14,141.1,San Jose", result[14]);
    }
    
    @Test
    public void test5() {
        PageDisplay sol = new PageDisplay();
        String[] strs = new String[]{
                "1,28,310.6,SF",
                "1,5,204.1,SF",
                "1,7,203.2,Oakland",
                "1,8,202.2,SF",
                "1,10,199.1,SF",
                "1,16,190.4,SF",
                "1,29,185.2,SF",
                "1,20,180.1,SF",
                "1,21,162.1,SF",
                "1,18,161.2,SF",
                "1,30,149.1,SF",
                "1,76,146.2,SF",
                "1,14,141.1,San Jose"

        };
        String[] result = sol.displayPagesII(strs, 3);
        assertEquals(17, result.length);
        assertEquals("1,28,310.6,SF", result[0]);
        assertEquals("1,7,203.2,Oakland", result[2]);
        assertEquals(" ", result[3]);
        assertEquals("1,8,202.2,SF", result[4]);
        assertEquals("1,29,185.2,SF", result[8]);
        assertEquals("1,14,141.1,San Jose", result[16]);
    }
    
    @Test
    public void test6() {
        PageDisplay sol = new PageDisplay();
        String[] strs = new String[]{
                "1,28,310.6,SF",
                "1,5,204.1,SF",
                "1,7,203.2,Oakland",
                "1,8,202.2,SF",
                "1,10,199.1,SF",
                "1,16,190.4,SF",
                "1,29,185.2,SF",
                "1,20,180.1,SF",
                "1,21,162.1,SF",
                "1,18,161.2,SF",
                "1,30,149.1,SF",
                "1,76,146.2,SF",
                "1,14,141.1,San Jose"

        };
        String[] result = sol.displayPagesIII(strs, 3);
        for (String str : result) {
          System.out.println(str);
        }
        assertEquals(17, result.length);
        assertEquals("1,28,310.6,SF", result[0]);
        assertEquals("1,7,203.2,Oakland", result[2]);
        assertEquals(" ", result[3]);
        assertEquals("1,8,202.2,SF", result[4]);
        assertEquals("1,29,185.2,SF", result[8]);
        assertEquals("1,14,141.1,San Jose", result[16]);
    }
  }
}