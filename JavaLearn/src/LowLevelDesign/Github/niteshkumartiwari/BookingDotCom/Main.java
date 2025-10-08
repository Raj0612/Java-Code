package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.CityService;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.HotelService;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.impl.DefaultCityService;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.impl.DefaultHotelService;

public class Main {

    public static void main(String[] args) {
        CityService cityService = new DefaultCityService();
        HotelService hotelService = new DefaultHotelService();
    }
}
