package Educative.Linkedin.features;

import Educative.Linkedin.accounts.User;
import Educative.Linkedin.profiledetails.Job;

import java.util.*;

public class CompanyPage {
    private int pageId;
    private String name;
    private String description;
    private String type;
    private int companySize;
    private User createdBy;
    private List<Job> jobs;
    private boolean enabled;

    public CompanyPage(int pageId, String name, String description, String type, int companySize, User createdBy) {
        this.pageId = pageId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.companySize = companySize;
        this.createdBy = createdBy;
        this.jobs = new ArrayList<>();
        this.enabled = true;
    }

    public boolean createJobPosting(Job job) {
        jobs.add(job);
        return true;
    }

    public boolean deleteJobPosting(Job job) {
        return jobs.remove(job);
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCompanySize() {
        return companySize;
    }

    public void setCompanySize(int companySize) {
        this.companySize = companySize;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
