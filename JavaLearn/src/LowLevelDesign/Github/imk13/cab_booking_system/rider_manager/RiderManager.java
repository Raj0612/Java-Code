package LowLevelDesign.Github.imk13.cab_booking_system.rider_manager;

import LowLevelDesign.Github.imk13.cab_booking_system.entity.CabBookingRequest;
import LowLevelDesign.Github.imk13.cab_booking_system.entity.Location;
import LowLevelDesign.Github.imk13.cab_booking_system.entity.Rider;
import LowLevelDesign.Github.imk13.cab_booking_system.service.CabBookingService;
import LowLevelDesign.Github.imk13.cab_booking_system.service.SimpleCabAssignStrategy;

import java.util.HashMap;

public class RiderManager {
  HashMap<String, Rider> riderHashMap;
  private static RiderManager instance = null;
  private RiderManager(){
    riderHashMap = new HashMap<>();
  }

  public static RiderManager getInstance(){
    if(instance == null){
      instance = new RiderManager();
    }
    return instance;
  }

  public Rider findRider(String name) {
    if(riderHashMap.containsKey(name)){
      return riderHashMap.get(name);
    }
    return null;
  }
  public void addRider(Rider rider){
    if(!riderHashMap.containsKey(rider.getRiderAccount().getName())){
      riderHashMap.put(rider.getRiderAccount().getName(), rider);
    }
  }

  public void removeRider(Rider rider){
    if(riderHashMap.containsKey(rider.getRiderAccount().getName())){
      riderHashMap.remove(rider.getRiderAccount().getName());
    }
  }

  public CabBookingRequest requestCab(Rider rider, Location toLocation){
    CabBookingRequest cabBookingRequest = new CabBookingRequest(rider.getLocation(), toLocation, rider);
    new CabBookingService().useStrategy(new SimpleCabAssignStrategy()).assignCab(cabBookingRequest);
    return cabBookingRequest;
  }
}
