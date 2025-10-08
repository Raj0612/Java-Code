package DesignPatterns.Behavioral.Observer.weather;

import java.util.ArrayList;

public class DisplayForecast {
    WeatherData currentWd;

    ArrayList<WeatherData> wdList = new ArrayList<>();

    void update(WeatherData wd){
        currentWd = wd;
        display();
        wdList.add(wd);
    }

    void display(){
        System.out.println("Current Pressure: " + currentWd.pressure);
        System.out.println("Current Temperature: " + currentWd.temp);
        System.out.println("Current Humidity: " + currentWd.humidity);
    }
}
