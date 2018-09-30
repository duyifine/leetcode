package dataStructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  public static class Node<K, V> {
    Node<K, V> next;
    Node<K, V> prev;
    K key;
    V value;
    
    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
    
    void update(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
  
  private int size;
  private int limit;
  private Node<Integer, Integer> head;
  private Node<Integer, Integer> tail;
  private Map<Integer, Node<Integer, Integer>> map;
  public LRUCache(int capacity) {
     this.limit = capacity;
     this.size = 0;
     this.map = new HashMap<Integer, Node<Integer, Integer>>();
  }
  
  public int get(int key){
    if (map.containsKey(key)) {
      Node<Integer, Integer> node = map.get(key);
      remove(node);
      append(node);
      return node.value;
    }
    return -1;
  }
  
  public void put(int key, int value) {
    Node<Integer, Integer> node = null;
    if (map.containsKey(key)) {
      node = map.get(key);
      if (node.value == value) {
        remove(node);
        append(node);
      } else {
        remove(node);
        node.update(key, value);
        append(node);
      }
    } else if (size < limit) {
      node = new Node<Integer, Integer>(key, value);
      append(node);
    } else {
      remove(tail);
      node = new Node<Integer, Integer>(key, value);
      append(node);
    }
  }
  
  private void remove(Node<Integer, Integer> node) {
    map.remove(node.key);
    size--;
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node == head) {
      head = head.next;
    }
    if (node == tail) {
      tail = tail.prev;
    }
    node.next = null;
    node.prev = null;
  }
  
  private void append(Node<Integer, Integer> node) {
    map.put(node.key, node);
    size++;
    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
  }
  
}