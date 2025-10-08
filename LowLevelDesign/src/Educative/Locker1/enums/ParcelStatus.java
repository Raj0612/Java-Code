package Educative.Locker1.enums;

public enum ParcelStatus {
    REGISTERED,     // Parcel has been registered in the system
    IN_TRANSIT,     // Parcel is in transit to the locker
    IN_LOCKER,      // Parcel is stored in a locker
    AWAITING_PICKUP, // Parcel is ready for pickup
    OUT_FOR_DELIVERY, // Parcel is out for delivery to recipient
    DELIVERED,      // Parcel has been delivered to recipient
    RETURNED,       // Parcel has been returned
    LOST,           // Parcel has been lost
    DAMAGED,        // Parcel has been damaged
    CANCELLED       // Parcel has been cancelled
}
