package DesignPatterns.Behavioral.Observer.weather;

public class Sensor {

    WeatherStation ws;

    void updateWs(WeatherData wd){
        ws.setWd(wd);
    }
}
