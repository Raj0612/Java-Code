package Educative.MeetingScheduler;

import java.time.LocalDateTime;

public class Interval {

    private LocalDateTime startTime;
    private LocalDateTime  endTime;

    public Interval(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean overlaps(Interval other) {
        return startTime.isBefore(other.endTime) && endTime.isAfter(other.startTime);
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

}
