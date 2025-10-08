package DesignPatterns.Behavioral.Observer.weather;

public class DisplayCurrentData {

    WeatherData currentWd;

    void update(WeatherData wd){
        currentWd = wd;
        display();
    }

    void display(){
        System.out.println("Current Pressure: " + currentWd.pressure);
        System.out.println("Current Temperature: " + currentWd.temp);
        System.out.println("Current Humidity: " + currentWd.humidity);
    }
}
