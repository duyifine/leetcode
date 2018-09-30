package dataStructure;

import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
  private int totalLevels;
  private List<ParkingSpot> spots;
  private Deque<ParkingSpot> smallSpots;
  private Deque<ParkingSpot> mediumSpots;
  private Deque<ParkingSpot> largeSpots;
  private Deque<ParkingSpot> extraLargeSpots;
  private HashMap<Vehicle, ParkingSpot> map;
  
  public enum VehicleSize {
    Small, Medium, Large, ExtraLarge;
  }
  
  public abstract class Vehicle {
    protected String plateNum;
    protected VehicleSize size;
    
    public String getPlateNum() {
      return this.plateNum;
    }
    
    public VehicleSize getSize() {
      return this.size;
    }
  }
  
  public class Motocycle extends Vehicle {
    public Motocycle(String plateNum) {
      this.plateNum = plateNum;
      this.size = VehicleSize.Small;
    }
  }
  
  public class ParkingSpot {
    private long spotId;
    private int spotLevel;
    private boolean isOccupied;
    private VehicleSize spotSize;
    
    public ParkingSpot(long spotId, int spotLevel, VehicleSize spotSize) {
      this.spotId = spotId;
      this.spotLevel = spotLevel;
      this.spotSize = spotSize;
      this.isOccupied = false;
    }
    
    public void setOccupied(boolean isOccupied) {
      this.isOccupied = isOccupied;
    }
    
    public long getSpotId() {
      return this.spotId;
    }
    
    public int getSpotLevel() {
      return this.spotLevel;
    }
    
    public VehicleSize getSpotSize() {
      return this.spotSize;
    }
    
    public boolean isOccupied() {
      return this.isOccupied;
    }
  }
  
  public ParkingLot(int levels, List<ParkingSpot> spots) {
    this.totalLevels = levels;
    Collections.sort(spots, new Comparator<ParkingSpot>() {
      @Override
      public int compare(ParkingSpot s1, ParkingSpot s2) {
        if (s1.getSpotId() > s2.getSpotId()) {
          return -1;
        } else if (s1.getSpotId() == s2.getSpotId()) {
          return 0;
        } else {
          return 1;
        }
      }
    });
    this.spots = spots;
    for (ParkingSpot spot : this.spots) {
      if (spot.getSpotSize() == VehicleSize.Small) {
        smallSpots.offerFirst(spot);
      } else if (spot.getSpotSize() == VehicleSize.Medium) {
        mediumSpots.offerFirst(spot);
      } else if (spot.getSpotSize() == VehicleSize.Large) {
        largeSpots.offerFirst(spot);
      } else {
        extraLargeSpots.offerFirst(spot);
      }
    }
  }
  
  public ParkingSpot park(Vehicle vehicle) {
    ParkingSpot spot = null;
    if (smallSpots.isEmpty() && mediumSpots.isEmpty() && largeSpots.isEmpty() && extraLargeSpots.isEmpty()) {
      return null;
    }
    if (vehicle.getSize() == VehicleSize.Small) {
      if (smallSpots.isEmpty() && !mediumSpots.isEmpty()) {
        spot = mediumSpots.pollFirst();
        spot.setOccupied(true);
        map.put(vehicle, spot);
      } else if (smallSpots.isEmpty() && !largeSpots.isEmpty()) {
        spot = largeSpots.pollFirst();
        spot.setOccupied(true);
        map.put(vehicle, spot);
      } else if (smallSpots.isEmpty() && !extraLargeSpots.isEmpty()) {
        spot = extraLargeSpots.pollFirst();
        spot.setOccupied(true);
        map.put(vehicle, spot);
      } else {
        spot = smallSpots.pollFirst();
        spot.setOccupied(true);
        map.put(vehicle, spot);
      }
    } else if (vehicle.getSize() == VehicleSize.Medium) {
      
    } else if (vehicle.getSize() == VehicleSize.Large) {
      
    } else {
      
    }
    
    return spot;
  }
  
  public void move(Vehicle vehicle) {
    ParkingSpot spot = map.get(vehicle);
    spot.setOccupied(false);
    map.remove(vehicle);
    if (spot.spotSize == VehicleSize.Small) {
      smallSpots.offerFirst(spot);
    } else if (spot.spotSize == VehicleSize.Medium) {
      
    } else if (spot.spotSize == VehicleSize.Large) {
      
    } else {
      
    }
  }
}