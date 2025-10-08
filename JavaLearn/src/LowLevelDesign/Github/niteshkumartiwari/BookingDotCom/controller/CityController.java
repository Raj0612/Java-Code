package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.controller;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.City;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.CityService;

import java.util.List;

public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    public void createCity(City city) {
         cityService.createCity(city);
    }

}
