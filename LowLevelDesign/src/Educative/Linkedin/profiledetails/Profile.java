package Educative.Linkedin.profiledetails;

import java.util.*;

public class Profile {
    private String headline;
    private String about;
    private String gender;
    private List<byte[]> profilePicture;
    private List<byte[]> coverPhoto;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Skill> skills;
    private List<Achievement> achievements;
    private List<Recommendation> recommendations;
    private Analytics analytics;

    public Profile() {
        this.experiences = new ArrayList<>();
        this.educations = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.achievements = new ArrayList<>();
        this.recommendations = new ArrayList<>();
        this.analytics = new Analytics(0, 0, 0, 0);
        this.profilePicture = new ArrayList<>();
        this.coverPhoto = new ArrayList<>();
    }

    public boolean addExperience(Experience experience) {
        experiences.add(experience);
        return true;
    }

    public boolean addEducation(Education education) {
        educations.add(education);
        return true;
    }

    public boolean addSkill(Skill skill) {
        skills.add(skill);
        return true;
    }

    public boolean addAchievement(Achievement achievement) {
        achievements.add(achievement);
        return true;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<byte[]> getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(List<byte[]> profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<byte[]> getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(List<byte[]> coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public Analytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }
}
