package LowLevelDesign.Github.imk13.cab_booking_system.service;


import LowLevelDesign.Github.imk13.cab_booking_system.entity.Cab;
import LowLevelDesign.Github.imk13.cab_booking_system.entity.CabBookingRequest;

public interface ICabAssignStrategy {
  Cab assignCab(CabBookingRequest cabBookingRequest);
}
