package main.java.org.example.service.booking;

import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.user.User;
import main.java.org.example.model.vehicle.Vehicle;

public interface BookingService {
    Vehicle rentVehicleByVehicleTypeAndTimeSlot(User renter, VehicleType vehicleType, TimeSlot timeSlot);
}
