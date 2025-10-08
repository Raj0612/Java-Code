package Educative.Linkedin.search;

import Educative.Linkedin.accounts.User;
import Educative.Linkedin.features.*;
import Educative.Linkedin.profiledetails.Job;

import java.util.*;

public class SearchCatalog implements Search {
    private Map<String, List<User>> usersByName;
    private Map<String, List<CompanyPage>> companiesByName;
    private Map<String, List<Group>> groupsByName;
    private Map<String, List<Job>> jobsByTitle;

    public SearchCatalog() {
        this.usersByName = new HashMap<>();
        this.companiesByName = new HashMap<>();
        this.groupsByName = new HashMap<>();
        this.jobsByTitle = new HashMap<>();
    }

    public void addNewUser(User user) {
        usersByName.computeIfAbsent(user.getName().toLowerCase(), k -> new ArrayList<>()).add(user);
    }

    public void addNewCompany(CompanyPage company) {
        companiesByName.computeIfAbsent(company.getName().toLowerCase(), k -> new ArrayList<>()).add(company);
    }

    public void addNewGroup(Group group) {
        groupsByName.computeIfAbsent(group.getName().toLowerCase(), k -> new ArrayList<>()).add(group);
    }

    public void addNewJob(Job job) {
        jobsByTitle.computeIfAbsent(job.getJobTitle().toLowerCase(), k -> new ArrayList<>()).add(job);
    }

    @Override
    public List<User> searchUser(String name) {
        return usersByName.getOrDefault(name.toLowerCase(), Collections.emptyList());
    }

    @Override
    public List<CompanyPage> searchCompany(String name) {
        return companiesByName.getOrDefault(name.toLowerCase(), Collections.emptyList());
    }

    @Override
    public List<Group> searchGroup(String name) {
        return groupsByName.getOrDefault(name.toLowerCase(), Collections.emptyList());
    }

    @Override
    public List<Job> searchJob(String title) {
        return jobsByTitle.getOrDefault(title.toLowerCase(), Collections.emptyList());
    }
}
