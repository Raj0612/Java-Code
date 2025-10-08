package DesignPatterns.Behavioral.Observer.weather;

public class WeatherStation {

    WeatherData current_wd;
    DisplayCurrentData disp1 = new DisplayCurrentData();
    DisplayForecast disp2 = new DisplayForecast();
    void setWd(WeatherData wd){
        this.current_wd = wd;
        notifyAllSubscribers();
    }

    void notifyAllSubscribers(){
        disp1.update(current_wd);
        disp2.update(current_wd);
    }
}
