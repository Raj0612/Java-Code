package Educative.Linkedin.profiledetails;

import java.time.LocalDate;

public class Education {
    private String school;
    private String degree;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public Education(String school, String degree, LocalDate startDate, LocalDate endDate, String description) {
        this.school = school;
        this.degree = degree;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    // Getters and setters...
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
