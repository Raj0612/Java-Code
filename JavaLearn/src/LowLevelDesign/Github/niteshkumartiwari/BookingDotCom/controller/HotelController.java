package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.controller;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.Hotel;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.HotelService;

import java.util.List;

public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }


    public Hotel getHotelById(final Long id){
        Hotel hotel = hotelService.getHotelById(id);
        return hotel;
    }

    public void deleteHotelById(Long id){
        hotelService.deleteHotelById(id);
    }

    public void createHotel(Hotel hotel) {
        hotelService.createNewHotel(hotel);
    }
}
