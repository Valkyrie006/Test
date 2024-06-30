package main.java.org.example.strategy;

import main.java.org.example.enums.BookingType;
import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestPriceSelectionStrategyImpl implements VehicleSelectionStrategy {

    @Override
    public Vehicle selectVehicle(VehicleType vehicleType, TimeSlot timeSlot, Map<Integer, Branch> branchMap) {
        Vehicle selectedVehicle = null;
        for (Map.Entry<Integer, Branch> branchEntry: branchMap.entrySet()) {
            Map<VehicleType, List<Vehicle>> vehicleTypeListMap = branchEntry.getValue().getVehicles();
            List<Vehicle> vehicles = vehicleTypeListMap.getOrDefault(vehicleType, new ArrayList<>());
            for (Vehicle vehicle: vehicles) {
                if (selectedVehicle == null || selectedVehicle.getPricePerTimeSlot() > vehicle.getPricePerTimeSlot()) {
                    boolean isPossibleToBook = true;
                    for (TimeSlot bookedSlots: vehicle.getBookingSlots()) {
                        if ((timeSlot.getStartTime().isBefore(bookedSlots.getEndTime()) && timeSlot.getStartTime().isAfter(bookedSlots.getStartTime()))
                        || (timeSlot.getEndTime().isBefore(bookedSlots.getEndTime()) && timeSlot.getEndTime().isAfter(bookedSlots.getStartTime()))) {
                            isPossibleToBook = false;
                            break;
                        }
                    }
                    if (isPossibleToBook) {
                        selectedVehicle = vehicle;
                    }
                }
            }
        }
        return selectedVehicle;
    }

}
