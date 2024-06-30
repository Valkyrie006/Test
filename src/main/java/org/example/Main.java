package main.java.org.example;

import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.user.Owner;
import main.java.org.example.model.user.Renter;
import main.java.org.example.model.vehicle.Vehicle;
import main.java.org.example.service.booking.BookingService;
import main.java.org.example.service.booking.BookingServiceImpl;
import main.java.org.example.service.branch.BranchService;
import main.java.org.example.service.branch.CityServiceImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BranchService branchService = new CityServiceImpl();

        Owner owner1 = new Owner(1, "Ram");

        Map<VehicleType, Double> priceMap1 = new HashMap<>();
        priceMap1.put(VehicleType.SEDAN, 2.0);
        priceMap1.put(VehicleType.SUV, 3.0);

        Branch branch1 = new Branch(1, "Super cars 1", owner1, priceMap1);

        Owner owner2 = new Owner(2, "Shyam");

        Map<VehicleType, Double> priceMap2 = new HashMap<>();
        priceMap2.put(VehicleType.SEDAN, 5.0);
        priceMap2.put(VehicleType.SUV, 1.0);

        Branch branch2= new Branch(2, "New cars", owner1, priceMap2);

        branchService.addBranch(branch1.getId(), branch1.getName(), owner1, priceMap1);
        branchService.addBranch(branch2.getId(), branch2.getName(), owner2, priceMap2);

        Vehicle sedan1 = new Vehicle(1, "2342", priceMap1.get(VehicleType.SEDAN), VehicleType.SEDAN, branch1);
        Vehicle sedan2 = new Vehicle(2, "453245", priceMap2.get(VehicleType.SEDAN), VehicleType.SEDAN, branch2);
        branchService.addVehicle(branch1.getId(), sedan1);
        branchService.addVehicle(branch2.getId(), sedan2);

        Renter renter = new Renter(1, "Lakhan");

        BookingService bookingService = new BookingServiceImpl(branchService);

        TimeSlot timeSlot = new TimeSlot(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3));
        Vehicle vehicle = bookingService.rentVehicleByVehicleTypeAndTimeSlot(renter, VehicleType.SEDAN, timeSlot);
        System.out.println(vehicle);
        Vehicle vehicle1 = bookingService.rentVehicleByVehicleTypeAndTimeSlot(renter, VehicleType.SUV, timeSlot);
        System.out.println(vehicle1); // null
    }
}