package DesignPatterns.Structural.Bridge.covidvaccine.userinterface;

import DesignPatterns.Structural.Bridge.covidvaccine.AdminUser;
import DesignPatterns.Structural.Bridge.covidvaccine.platform.MultiPlatformFramework;
import DesignPatterns.Structural.Bridge.covidvaccine.User;

public class AdminUserInterface implements UserInterface{

    protected MultiPlatformFramework framework;

    public AdminUserInterface(MultiPlatformFramework framework){
        this.framework = framework;
    }

    @Override
    public void showWelcomePage(String userId) {
        AdminUser user = (AdminUser) framework.getUserDetails(userId);
        System.out.println("Dear "+user.getUserName()+" Welcome to Cowin APP! ");
        System.out.println("~~~~~~~~~~~~~~ Your Personal Details ~~~~~~~~~~~~~~~~~~");
        System.out.println("UserId: "+ user.getUserId());
        System.out.println("UserName: "+ user.getUserName());
        System.out.println("Gender: "+ user.getGender());
        System.out.println(user.getIdType()+":"+user.getIdNumber());
        System.out.println("Age: "+ user.getAge());
        System.out.println("No of vaccines dozes administered till now : "+user.getVaccineCenter().getNoOfDozesGiven());
        System.out.println("As per updated data , No of remaining vaccines : "+user.getVaccineCenter().getNoOfVaccines());
        System.out.println("You are an admin user ! You can upload vaccine availability details here");
    }

    @Override
    public void registerUser(User user) {
        framework.registerUser(user);
    }

    public void uploadVaccineCount(String userId , String date , int noOfVaccines){
        framework.uploadVaccineCount(userId,date,noOfVaccines);
    }

}
