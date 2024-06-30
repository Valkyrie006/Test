package main.java.org.example.strategy;

import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.vehicle.Vehicle;

import java.util.Map;

public interface VehicleSelectionStrategy {

    Vehicle selectVehicle(VehicleType vehicleType, TimeSlot timeSlot, Map<Integer, Branch> branchMap);
}
