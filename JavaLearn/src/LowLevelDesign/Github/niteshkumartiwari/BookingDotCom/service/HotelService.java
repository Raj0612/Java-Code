package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    List<Hotel> getHotelsByCity(Long cityId);

    void createNewHotel(Hotel hotel);

    Hotel getHotelById(Long id);

    void deleteHotelById(Long id);
}
