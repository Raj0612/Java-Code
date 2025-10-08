package Educative.CarRentalSyatem.designpatterns;

//Implemented in NotificationService
public interface  Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
