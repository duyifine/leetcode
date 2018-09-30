package graphSearch;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BloodRelationship {
  
  public static class Person {
    Person[] parents;
  }
  
  public boolean isBloodRelated(Person p1, Person p2) {
    Set<Person> p1Ancestors = new HashSet<>();
    Set<Person> p2Ancestors = new HashSet<>();
    
    Deque<Person> p1Discovered = new LinkedList<>();
    p1Discovered.offerFirst(p1);
    Deque<Person> p2Discovered = new LinkedList<>();
    p2Discovered.offerFirst(p2);
    
    while (!p1Discovered.isEmpty() || !p2Discovered.isEmpty()) {
      Person nextP1 = p1Discovered.pollLast();
      if (nextP1 != null) {
        if (p2Ancestors.contains(nextP1)) {
          return true;
        }
        
        for (Person parent : nextP1.parents) {
          p1Discovered.offerFirst(parent);
        }
        p1Ancestors.add(nextP1);
      }
      
      Person nextP2 = p2Discovered.pollLast();
      if (nextP2 != null) {
        if (p1Ancestors.contains(nextP2)) {
          return true;
        }
        
        for (Person parent : nextP2.parents) {
          p2Discovered.offerFirst(parent);
        }
        p2Ancestors.add(nextP2);
      }
    }
    
    return false;
  }
}