package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.impl;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.dto.RatingReport;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.Hotel;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.HotelService;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.RatingService;

import java.util.List;

public class DefaultRatingService implements RatingService {

    HotelService hotelService;

    public DefaultRatingService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public RatingReport getRatingAverage(Long cityId) {
        return getRatingAverage(hotelService.getHotelsByCity(cityId));
    }

    @Override
    public RatingReport getRatingAverage(List<Hotel> hotels) {
        double ratingSum = 0;
        int ratingCount = 0;

        for (Hotel hotel : hotels) {
            ratingSum += hotel.getRating();
            ratingCount++;
        }

        return new RatingReport(ratingCount, ratingSum / ratingCount);
    }
}
