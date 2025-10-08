package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.exception;

public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String message) {
        super(message);
    }
}