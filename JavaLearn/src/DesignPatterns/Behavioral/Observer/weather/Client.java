package DesignPatterns.Behavioral.Observer.weather;

public class Client {
    public static void main(String[] args) {
        Sensor sensor1 = new Sensor();
        WeatherData wd = new WeatherData();
        wd.humidity = 32;
        wd.temp = 23;
        wd.pressure = 35;

        WeatherStation station = new WeatherStation();
        station.setWd(wd);

    }
}
