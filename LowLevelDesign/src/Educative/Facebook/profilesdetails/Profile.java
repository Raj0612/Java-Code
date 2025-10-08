package Educative.Facebook.profilesdetails;

import Educative.Facebook.enums.FriendsListVisibility;
import Educative.Facebook.accounts.User;

import java.util.*;

public class Profile {
    private String gender;
    private byte[] profilePicture;
    private byte[] coverPhoto;
    private FriendsListVisibility friendsListVisibility = FriendsListVisibility.PUBLIC;
    private boolean isProfileLocked = false;
    private boolean isProfilePictureLocked = false;
    private List<User> friends = new ArrayList<>();
    private List<Integer> usersFollowed = new ArrayList<>();
    private List<Integer> pagesFollowed = new ArrayList<>();
    private List<Integer> groupsJoined = new ArrayList<>();
    private List<Work> workExperience = new ArrayList<>();
    private List<Education> educationInfo = new ArrayList<>();
    private List<Places> places = new ArrayList<>();

    public Profile() {
    }

    public FriendsListVisibility getFriendsListVisibility() {
        return friendsListVisibility;
    }
    public void setFriendsListVisibility(FriendsListVisibility visibility) {
        this.friendsListVisibility = visibility;
    }

    public boolean isProfileLocked() {
        return isProfileLocked;
    }
    public void setProfileLocked(boolean profileLocked) {
        isProfileLocked = profileLocked;
    }

    public boolean isProfilePictureLocked() {
        return isProfilePictureLocked;
    }
    public void setProfilePictureLocked(boolean profilePictureLocked) {
        isProfilePictureLocked = profilePictureLocked;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Integer> getUsersFollowed() {
        return usersFollowed;
    }

    public void setUsersFollowed(List<Integer> usersFollowed) {
        this.usersFollowed = usersFollowed;
    }

    public List<Integer> getPagesFollowed() {
        return pagesFollowed;
    }

    public void setPagesFollowed(List<Integer> pagesFollowed) {
        this.pagesFollowed = pagesFollowed;
    }

    public List<Integer> getGroupsJoined() {
        return groupsJoined;
    }

    public void setGroupsJoined(List<Integer> groupsJoined) {
        this.groupsJoined = groupsJoined;
    }

    public List<Work> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<Work> workExperience) {
        this.workExperience = workExperience;
    }

    public List<Education> getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(List<Education> educationInfo) {
        this.educationInfo = educationInfo;
    }

    public List<Places> getPlaces() {
        return places;
    }

    public void setPlaces(List<Places> places) {
        this.places = places;
    }

    public boolean addWorkExperience(Work work) {
        return this.workExperience.add(work);
    }

    public boolean addEducation(Education education) {
        return this.educationInfo.add(education);
    }

    public boolean addPlace(Places place) {
        return this.places.add(place);
    }

    public boolean addProfilePicture(byte[] image) {
        this.profilePicture = image;
        return true;
    }

    public boolean addCoverPhoto(byte[] image) {
        this.coverPhoto = image;
        return true;
    }

    public boolean addGender(String gender) {
        this.gender = gender;
        return true;
    }
}
