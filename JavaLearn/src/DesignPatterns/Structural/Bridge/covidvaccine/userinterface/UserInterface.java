package DesignPatterns.Structural.Bridge.covidvaccine.userinterface;

import DesignPatterns.Structural.Bridge.covidvaccine.User;

public interface UserInterface {

    void showWelcomePage(String userId);

    void registerUser(User user);
}
