package Educative.Facebook.profilesdetails;

import java.time.LocalDate;

public class Education {
    private String school;
    private String degree;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Education(String school, String degree, String description, LocalDate startDate, LocalDate endDate) {
        this.school = school;
        this.degree = degree;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
