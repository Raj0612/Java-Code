package Educative.MeetingScheduler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class MeetingSchedulerDemo {
    public static void main(String[] args) {
        // Create users
        User alice = new User("Alice", "Alice@gmail.com");
        User bob = new User("Bob", "Bob@gmail.com");

        // Create meeting rooms
        MeetingRoom roomA = new MeetingRoom(1,  5,"Room A");
        MeetingRoom roomB = new MeetingRoom(2,  3, "Room B");

        List<User> users = Arrays.asList(alice, bob);
        List<MeetingRoom> rooms = Arrays.asList(roomA, roomB);

        // Initialize scheduler
        MeetingScheduler scheduler = new MeetingScheduler(users, rooms);

        // Define meeting time
        LocalDateTime start = LocalDateTime.of(2025, 5, 23, 10, 0);
        LocalDateTime end = LocalDateTime.of(2025, 5, 23, 11, 0);
        Interval interval = new Interval(start, end);

        // Schedule a meeting
        Meeting meeting = scheduler.scheduleMeeting("Project Kickoff", users, interval);

        if (meeting != null) {
            System.out.println("Meeting scheduled in " + meeting.getRoom().getName() + ": " + meeting.getSubject());
            for (User user : users) {
                System.out.println(user.getName() + "'s notifications:");
                for (Notification n : user.getNotifications()) {
                    System.out.println("- " + n.getContent());
                }
            }
        } else {
            System.out.println("Could not schedule meeting. Check participant or room availability.");
        }
    }
}
