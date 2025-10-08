package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.controller;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.dto.RatingReport;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.RatingService;

public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    public RatingReport getRatingByCity(Long cityId) {
        return ratingService.getRatingAverage(cityId);
    }
}
