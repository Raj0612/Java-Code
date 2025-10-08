package LowLevelDesign.Github.imk13.cab_booking_system.service;

import java.util.ArrayList;

import LowLevelDesign.Github.imk13.cab_booking_system.cab_manager.CabManager;
import LowLevelDesign.Github.imk13.cab_booking_system.constants.CabBookingConstants;
import LowLevelDesign.Github.imk13.cab_booking_system.entity.Cab;
import LowLevelDesign.Github.imk13.cab_booking_system.entity.CabBookingRequest;
import LowLevelDesign.Github.imk13.cab_booking_system.entity.Location;

public class SimpleCabAssignStrategy implements ICabAssignStrategy {

  @Override
  public Cab assignCab(CabBookingRequest cabBookingRequest){
    ArrayList<Cab> cabs = CabManager.getInstance().findAvailableCabs();
    Double minDistance = CabBookingConstants.MAX_PICKUP_DISTANCE;
    Cab foundCab = null;
    for(int i  = 0; i < cabs.size(); i++) {
      // max pickup distance logic and return one cab;
      Double distance = calculateDistance(cabs.get(i).getLocation(), cabBookingRequest.getRiderInfo().getLocation());
      if(distance <=  minDistance){
        minDistance = distance;
        foundCab = cabs.get(i);
      }
    }
    return  foundCab;
  }

  private Integer getDiffSquare(Integer n1, Integer n2) {
    return (n1-n2) * (n1-n2);
  }
  private Double calculateDistance(Location p1, Location p2){
    return Math.sqrt(getDiffSquare(p1.getX(), p2.getX()) + getDiffSquare(p1.getY(), p2.getY()));
  }
}
