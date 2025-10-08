package Educative.MeetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private List<Notification> notifications;

    private final Calendar calendar;

    // Two-way association with Meeting
    private List<Meeting> meetings;
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.notifications = new ArrayList<>();
        this.meetings = new ArrayList<>();
        this.calendar = new Calendar();
    }

    public void respondInvitation(Notification invite){

    }

    public void acceptInvitation(Notification invite){

    }

    public void rejectInvitation(Notification invite){

    }

    public void addMeeting(Meeting meeting) {
        if (!meetings.contains(meeting)) {
            meetings.add(meeting);
            meeting.addParticipant(this); // Maintain two-way association
        }
    }

    public void removeMeeting(Meeting meeting) {
        if (meetings.contains(meeting)) {
            meetings.remove(meeting);
            meeting.removeParticipant(this); // Maintain two-way association
        }
    }

    public void receiveNotification(Notification notification) {
       System.out.println(this.name + " received notification: " + notification.getContent());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void addMeetings(Meeting meeting) {
        this.meetings.add(meeting);
    }

    public Calendar getCalendar() { return calendar; }
}
