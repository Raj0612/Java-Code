package DesignPatterns.Structural.Bridge.covidvaccine.userinterface;

import DesignPatterns.Structural.Bridge.covidvaccine.platform.MultiPlatformFramework;
import DesignPatterns.Structural.Bridge.covidvaccine.NormalUser;
import DesignPatterns.Structural.Bridge.covidvaccine.User;

public class NormalUserInterface implements UserInterface{

    protected MultiPlatformFramework framework;

    public NormalUserInterface(MultiPlatformFramework framework){
        this.framework = framework;
    }

    public void bookAppointment(String date, String userId, String slot, String centerId) {
        boolean result = framework.bookAppointment(date,userId,slot,centerId);
        if(result){
            System.out.println("You have successfully scheduled appointment for the vaccination for date = "+date +
                    " slot="+slot+" centerId="+centerId);
        } else{
            System.out.println("Sorry! Vaccination center has completely booked for all slots , Try again later");
        }
    }

    @Override
    public void showWelcomePage(String userId) {
        NormalUser user = (NormalUser) framework.getUserDetails(userId);
        System.out.println("Dear "+user.getUserName()+" Welcome to Cowin APP! ");
        System.out.println("~~~~~~~~~~~~~~ Your Personal Details ~~~~~~~~~~~~~~~~~~");
        System.out.println("UserId: "+ user.getUserId());
        System.out.println("UserName: "+ user.getUserName());
        System.out.println("Gender: "+ user.getGender());
        System.out.println(user.getIdType()+":"+user.getIdNumber());
        System.out.println("Age: "+ user.getAge());
        System.out.println("------------------Your beneficiaries ---------------------");
        for (User member: user.getBeneficiaries()) {
            System.out.println("UserId: "+ member.getUserId());
            System.out.println("UserName: "+ member.getUserName());
            System.out.println("Gender: "+ member.getGender());
            System.out.println(member.getIdType()+":"+member.getIdNumber());
            System.out.println("Age: "+ member.getAge());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("You are a regular user ! You can book the appointment for the vaccination for yourself " +
                "and your family members");
    }

    @Override
    public void registerUser(User user) {
        framework.registerUser(user);
    }
}
