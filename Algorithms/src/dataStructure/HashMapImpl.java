package dataStructure;

import java.util.concurrent.locks.ReentrantLock;

public class HashMapImpl {
  
  public static class Entry extends ReentrantLock {
    MyObject key;
    String value;
    Entry next = null;
    
    public Entry(MyObject key, String value) {
      this.key = key;
      this.value = value;
    }
    
    public MyObject getKey() {
      return this.key;
    }
    
    public void setValue(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return this.value;
    }
  }
  
  int bucket_size = 128;
  Entry[] table = new Entry[bucket_size];
  
  private int getSupplementalHash(int h) {
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
  }
  
  private int getBucket(int hashed) {
    return hashed % bucket_size;
  }
  
  public void put(MyObject key, String value) {
    int userHash = key.hashCode();
    int hash = getSupplementalHash(userHash);
    int bucket = getBucket(hash);
    
    Entry existing = table[bucket];
    existing.lock();
    try {
//    synchronized (existing) {
    while (existing != null) {
      if (existing.getKey().equals(key)) {
        existing.value = value;
        break;
      }
      existing = existing.next;
    }
    if (existing == null) {
      existing = new Entry(key, value);
    }
    } finally {
      existing.unlock();
    }
//    }
  }
  
  public String get(MyObject key) {
    int userHash = key.hashCode();
    int hash = getSupplementalHash(userHash);
    int bucket = getBucket(hash);
    
    Entry existing = table[bucket];
//    synchronized (existing) {
    while (existing != null) {
      if (existing.getKey().equals(key)) {
        return existing.value;
      }
      existing = existing.next;
    }
//    }
    return null;
  }
  
  public int hashCode(char[] key,int HASH_SIZE) {
    int N = key.length;
    long sum = 0;
    for (int i = 0; i < N; i++) {
        sum = (sum * 33 + (int) (key[i])) % HASH_SIZE;
    }

    return (int) (sum);
  }
  
  static class MyObject {
    private Integer id;
    private String value;
    
    @Override
    public int hashCode() {
      return id % 10;
    }
    
    @Override
    public boolean equals(Object obj) {
      MyObject myObj = (MyObject) obj;
      if (myObj.value.equals(this.value)) {
        return true;
      }
      return false;
    }
  }
  
}