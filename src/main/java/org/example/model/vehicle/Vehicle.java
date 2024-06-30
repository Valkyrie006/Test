package main.java.org.example.model.vehicle;

import main.java.org.example.enums.BookingType;
import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private Integer id;
    private String registrationNumber;
    private Double pricePerTimeSlot; // price per time slot
    private VehicleType vehicleType;
    private BookingType bookingType;

    private List<TimeSlot> bookingSlots;
    private User bookedBy;

    private Branch owningBranch;

    public Vehicle(Integer id, String registrationNumber, Double pricePerTimeSlot, VehicleType vehicleType, Branch branch) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.pricePerTimeSlot = pricePerTimeSlot;
        this.vehicleType = vehicleType;
        this.bookingType = BookingType.FREE;
        this.owningBranch = branch;
        this.bookingSlots = new ArrayList<>();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Double getPricePerTimeSlot() {
        return pricePerTimeSlot;
    }

    public void setPricePerTimeSlot(Double pricePerTimeSlot) {
        this.pricePerTimeSlot = pricePerTimeSlot;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public List<TimeSlot> getBookingSlots() {
        return bookingSlots;
    }

    public void setBookingSlots(List<TimeSlot> bookingSlots) {
        this.bookingSlots = bookingSlots;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Boolean isVehicleFree() {
        return BookingType.FREE.equals(bookingType);
    }

    public Branch getOwningBranch() {
        return owningBranch;
    }

    public void setOwningBranch(Branch owningBranch) {
        this.owningBranch = owningBranch;
    }
}
