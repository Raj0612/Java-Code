package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.dto.RatingReport;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.Hotel;

import java.util.List;

public interface RatingService {
    RatingReport getRatingAverage(Long cityId);

    RatingReport getRatingAverage(List<Hotel> hotels);
}
