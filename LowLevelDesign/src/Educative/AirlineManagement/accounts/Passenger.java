package Educative.AirlineManagement.accounts;

import java.time.LocalDate;

public class Passenger {
    private int passengerId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String passportNumber;

    public Passenger(int passengerId, String name, String gender, LocalDate dateOfBirth, String passportNumber) {
        this.passengerId = passengerId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
