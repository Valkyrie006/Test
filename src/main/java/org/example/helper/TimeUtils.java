package main.java.org.example.helper;

import main.java.org.example.model.timeslot.TimeSlot;

import java.time.LocalDateTime;

public class TimeUtils {

    public static Boolean isTimeSlotValid(TimeSlot timeSlot) {
        LocalDateTime currentTime = LocalDateTime.now();
        if (currentTime.isBefore(timeSlot.getStartTime()) && currentTime.isBefore(timeSlot.getEndTime()) && timeSlot.getStartTime().isBefore(timeSlot.getEndTime())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
