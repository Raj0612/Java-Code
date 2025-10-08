package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    City getCityById(Long id);

    void createCity(City city);
}
