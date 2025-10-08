package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.impl;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.Hotel;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.HotelService;

import java.util.ArrayList;
import java.util.List;

public class DefaultHotelService implements HotelService {

    List<Hotel> hotels;

    public DefaultHotelService(){
        hotels =new ArrayList<>();
    }
    @Override
    public List<Hotel> getAllHotels() {
        return hotels;
    }

    @Override
    public List<Hotel> getHotelsByCity(Long cityId) {
        return null;
    }

    @Override
    public void createNewHotel(Hotel hotel) {
         hotels.add(hotel);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotels.stream().filter(hotel -> hotel.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    @Override
    public void deleteHotelById(Long id) {
        hotels.remove(hotels.stream().filter(hotel -> hotel.getId()==id).findFirst().orElseThrow(() -> new RuntimeException("Hotel not found")));
    }
}
