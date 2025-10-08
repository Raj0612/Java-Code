package Educative.Linkedin.profiledetails;

import Educative.Linkedin.accounts.Address;

import java.time.LocalDate;

public class Experience {
    private String title;
    private String company;
    private Address location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public Experience(String title, String company, Address location, LocalDate startDate, LocalDate endDate, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
