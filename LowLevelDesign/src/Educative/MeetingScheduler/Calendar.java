package Educative.MeetingScheduler;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<Meeting> meetings;

    public Calendar() {
        this.meetings = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public boolean isAvailable(Interval interval) {
        for (Meeting m : meetings) {
            if (m.getTimeSlot().overlaps(interval)) {
                return false;
            }
        }
        return true;
    }
}
