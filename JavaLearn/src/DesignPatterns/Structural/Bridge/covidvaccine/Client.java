package DesignPatterns.Structural.Bridge.covidvaccine;

import DesignPatterns.Structural.Bridge.covidvaccine.platform.AndroidPlatform;
import DesignPatterns.Structural.Bridge.covidvaccine.platform.WindowsPlatform;
import DesignPatterns.Structural.Bridge.covidvaccine.userinterface.AdminUserInterface;
import DesignPatterns.Structural.Bridge.covidvaccine.userinterface.NormalUserInterface;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        WindowsPlatform windowsPlatform = new WindowsPlatform();
        NormalUserInterface userInterface = new NormalUserInterface(windowsPlatform);
        // Register User and its linked beneficiaries
        List<User> beneficiaries = new ArrayList<User>();
        User member1 = new User("John2345","John",29,"male", IdType.DRIVING_LICENSE,
                "KT48****5567");
        User member2 = new User("Tushar2345","Tushar Yadav",27,"male",IdType.VOTER_ID,
                "18****5567");
        beneficiaries.add(member1);
        beneficiaries.add(member2);
        User user = new NormalUser("Ravi2345","Ravi Bhatt",27,"male",IdType.AADHAAR_CARD,
                "********5567",beneficiaries);
        userInterface.registerUser(user);

        userInterface.showWelcomePage("Ravi2345");

        userInterface.bookAppointment("14/05/2021","Ravi2345","09:00 am -11:00 am","center123");

        System.out.println("-----------------Next Use Case--------------------------");

        /* Using Android platform to upload the vaccineCount for admin user */
        AndroidPlatform androidPlatform = new AndroidPlatform();
        AdminUserInterface adminUserInterface = new AdminUserInterface(androidPlatform);

        AdminUser.Center center = new AdminUser.Center("center123","Apollo hostpital noida",
                310,3000);
        User adminUser = new AdminUser("Rakesh2345","Rakesh",27,"male",IdType.AADHAAR_CARD,
                "********5567",center);
        adminUserInterface.registerUser(adminUser);

        adminUserInterface.showWelcomePage("Rakesh2345");

        adminUserInterface.uploadVaccineCount("Rakesh2345","13/05/2021",500);
    }
}
