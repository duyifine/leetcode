package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TravelBuddy {
  
  public static class Buddy implements Comparable<Buddy> {
    String name;
    int similar;
    HashSet<String> wishList;
    
    public Buddy(String name, int similar, HashSet<String> wishList) {
      this.name = name;
      this.similar = similar;
      this.wishList = wishList;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Buddy o) {
      return o.similar - this.similar;
    }
    
  }
  
  private List<Buddy> buddies;
  private HashSet<String> myWishList;
  public TravelBuddy(HashSet<String> myWishList, HashMap<String, HashSet<String>> fdWishList) {
    this.buddies = new ArrayList<>();
    this.myWishList = myWishList;
    for (String name : fdWishList.keySet()) {
      HashSet<String> wishList = fdWishList.get(name);
      HashSet<String> intersection = new HashSet<>();
//      intersection.retainAll(myWishList);
      intersection = getIntersection(myWishList, wishList);
      int similar = intersection.size();
      if (similar >= wishList.size() / 2) {
        buddies.add(new Buddy(name, similar, wishList));
      }
    }
  }
  
  public HashSet<String> getIntersection(HashSet<String> set1, HashSet<String> set2) {
    HashSet<String> result = new HashSet<>();
    for (String str : set2) {
      if (set1.contains(str)) {
        result.add(str);
      }
    }
    
    return result;
  }
  
  public List<Buddy> getTravelBuddies() {
    Collections.sort(buddies);
    return new ArrayList<>(buddies);
  }
  
  public List<String> recommendCities(int k) {
    List<String> result = new ArrayList<>();
    List<Buddy> buddies = getTravelBuddies();
    
    int i = 0;
    while (k > 0 && i < buddies.size()) {
      HashSet<String> diff = buddies.get(i).wishList;
//      diff.removeAll(myWishList);
      diff = getDiff(myWishList, diff);
      if (diff.size() < k) {
        result.addAll(diff);
        k = k - diff.size();
        i++;
      } else {
        Iterator<String> iter = diff.iterator();
        while (k > 0) {
          result.add(iter.next());
          k--;
        }
      }
    }
    
    return result;
  }
  
  public HashSet<String> getDiff(HashSet<String> set1, HashSet<String> set2) {
    HashSet<String> result = new HashSet<>();
    
    for (String str : set2) {
      if (!set1.contains(str)) {
        result.add(str);
      }
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    HashSet<String> myWishList = new HashSet<>(Arrays.asList(new String[]{"a", "b", "c", "d"}));
    HashSet<String> wishList1 = new HashSet<>(Arrays.asList(new String[]{"a", "b", "e", "f"}));
    HashSet<String> wishList2 = new HashSet<>(Arrays.asList(new String[]{"a", "c", "d", "g"}));
    HashSet<String> wishList3 = new HashSet<>(Arrays.asList(new String[]{"c", "f", "e", "g"}));
    HashMap<String, HashSet<String>> friendWishLists = new HashMap<>();
    friendWishLists.put("Buddy1", wishList1);
    friendWishLists.put("Buddy2", wishList2);
    friendWishLists.put("Buddy3", wishList3);
    TravelBuddy sol = new TravelBuddy(myWishList, friendWishLists);
    System.out.println(sol.recommendCities(10));
  }
}