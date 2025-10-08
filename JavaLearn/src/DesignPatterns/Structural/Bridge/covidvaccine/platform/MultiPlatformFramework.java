package DesignPatterns.Structural.Bridge.covidvaccine.platform;

import DesignPatterns.Structural.Bridge.covidvaccine.User;

import java.util.HashMap;

public interface MultiPlatformFramework {
    HashMap<String, User> userDetails = new HashMap<>();

    boolean bookAppointment(String date , String userId , String slot , String centerId);

    User getUserDetails(String userId);

    void registerUser(User user);

    void uploadVaccineCount(String userId, String date, int noOfVaccines);
}
