package graphSearch;

import java.util.Deque;
import java.util.LinkedList;

public class TreasureInMaze {
  
  class Room {
    int id;
    Door[] doors;
    boolean hasTreasure;
    Key[] keys;
    boolean visited;
  }
  
  class Door {
    int id;
    Room[] roomPair;
    boolean locked = true;
    Key key;
  }
  
  class Key {
    int id;
    Door door;
    boolean found;
  }
  
  public int maze(Room start) {
    Deque<Room> roomsToExplore = new LinkedList<>();
    Deque<Door> lockedDoors = new LinkedList<>();
    
    roomsToExplore.offerFirst(start);
    start.visited = true;
    while (!roomsToExplore.isEmpty() || !lockedDoors.isEmpty()) {
      if (roomsToExplore.isEmpty()) {
        int size = lockedDoors.size();
        while (size > 0) {
          Door top = lockedDoors.pollLast();
          if (top.key.found) {
            top.locked = false;
            Room r1 = top.roomPair[0];
            Room r2 = top.roomPair[1];
            if (r1.visited && !r2.visited) {
              roomsToExplore.offerFirst(r2);
              r2.visited = true;
            } else if (!r1.visited && r2.visited) {
              roomsToExplore.offerFirst(r1);
              r1.visited = true;
            }
          } else {
            lockedDoors.offerFirst(top);
          }
          size--;
        }
      } else {
        Room topRoom = roomsToExplore.pollFirst();
        if (topRoom.hasTreasure) return topRoom.id;
        for (Key k : topRoom.keys) {
          k.found = true;
        }
        for (Door d : topRoom.doors) {
          if (d.locked) {
            if (d.key.found) {
              d.locked = false;
            } else {
              lockedDoors.offerFirst(d);
              continue;
            }
          }
          Room r1 = d.roomPair[0];
          Room r2 = d.roomPair[1];
          if (r1.visited && !r2.visited) {
            roomsToExplore.offerFirst(r2);
            r2.visited = true;
          } else if (!r1.visited && r2.visited) {
            roomsToExplore.offerFirst(r1);
            r1.visited = true;
          }
        }
      }      
    }
    
    return -1;
  }
}