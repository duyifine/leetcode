package dataStructure;

import java.util.HashMap;

public class LRU {
  
  public static class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.next = null;
      this.prev = null;
    }
  }
  
  private int size;
  private int limit;
  private Node head;
  private Node tail;
  private HashMap<Integer, Node<Integer, Integer>> map;
  
  public LRU(int capacity) {
    this.limit = capacity;
    this.size = 0;
    this.map = new HashMap<>();
  }
  
  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    
    Node<Integer, Integer> node = map.get(key);
    remove(node);
    appendHead(node);
    return node.value;
  }
  
  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node<Integer, Integer> node = map.get(key);
      node.value = value;
      remove(node);
      appendHead(node);
    } else {
      Node<Integer, Integer> node = new Node<>(key, value);
      if (size < limit) {
//        map.put(key, node);
        appendHead(node);
      } else {
        remove(tail);
        appendHead(node);
//        map.put(key, node);
      }
    }
  }
  
  public void remove(Node<Integer, Integer> node) {
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
    node.prev = null;
    node.next = null;
  }
  
  public void appendHead(Node<Integer, Integer> node) {
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