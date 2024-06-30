package main.java.org.example.model.booking;

import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.user.User;
import main.java.org.example.model.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Booking {
    private Integer id;
    private User user;
    private Vehicle vehicle;
    private LocalDateTime bookingTime;
    private TimeSlot bookingTimeSlot;

    public Booking(Integer id, User user, Vehicle vehicle, LocalDateTime bookingTime, TimeSlot bookingTimeSlot) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingTime = bookingTime;
        this.bookingTimeSlot = bookingTimeSlot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public TimeSlot getBookingTimeSlot() {
        return bookingTimeSlot;
    }

    public void setBookingTimeSlot(TimeSlot bookingTimeSlot) {
        this.bookingTimeSlot = bookingTimeSlot;
    }
}
