package DesignPatterns.Structural.Bridge.covidvaccine.platform;

import DesignPatterns.Structural.Bridge.covidvaccine.AdminUser;
import DesignPatterns.Structural.Bridge.covidvaccine.User;

import java.time.LocalDateTime;
import java.util.Random;

public class IOSPlatform implements MultiPlatformFramework{

    @Override
    public boolean bookAppointment(String date, String userId, String slot, String centerId) {
        Random random = new Random();
        int decidingFactor = random.nextInt(100);
        if(decidingFactor<=40){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User getUserDetails(String userId) {
        User user = userDetails.get(userId);
        return user;
    }

    @Override
    public void registerUser(User user) {
        userDetails.put(user.getUserId(), user);
        System.out.println("User registered successfully by IOS application at "+ LocalDateTime.now());
    }

    @Override
    public void uploadVaccineCount(String userId, String date, int noOfVaccines) {
        //normally we used to update the vaccine count in the AdminUser table in database , but here we mimic database as cache
        AdminUser user = (AdminUser) userDetails.get(userId);
        AdminUser.Center center = user.getVaccineCenter();
        center.setNoOfVaccines(center.getNoOfVaccines()+noOfVaccines);
        System.out.println("Vaccine count is updated by "+user.getUserName()+" of center = "+center+" by IOS platform");
    }
}
