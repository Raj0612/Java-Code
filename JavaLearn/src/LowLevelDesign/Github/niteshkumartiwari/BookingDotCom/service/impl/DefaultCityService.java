package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.impl;

import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.exception.CityNotFoundException;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.model.City;
import LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.service.CityService;

import java.util.ArrayList;
import java.util.List;

public class DefaultCityService implements CityService {

    List<City> cities;
    public DefaultCityService() {
        cities = new ArrayList<>();
    }

    @Override
    public City getCityById(Long id) {
        City city = cities.stream()
                .filter(city1 -> city1.getId() == id)
                .findFirst()  // Optional: use findFirst for clarity
                .orElseThrow(() -> new CityNotFoundException("Could not find city with ID provided"));

       return city;
    }

    @Override
    public List<City> getAllCities() {
        return cities;
    }

    @Override
    public void createCity(City city) {
        cities.add(city);
    }
}
