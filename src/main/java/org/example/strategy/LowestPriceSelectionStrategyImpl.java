package main.java.org.example.strategy;

import main.java.org.example.enums.BookingType;
import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.vehicle.Vehicle;

import java.time.LocalDateTime;
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
                        if ((isBeforeByHour(timeSlot.getStartTime(), bookedSlots.getEndTime()) && isAfterByHour(timeSlot.getStartTime(), bookedSlots.getStartTime()))
                        || (isBeforeByHour(timeSlot.getEndTime(), bookedSlots.getEndTime()) && isAfterByHour(timeSlot.getEndTime(), bookedSlots.getStartTime()))) {
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

    private static boolean isBeforeByHour(LocalDateTime dt1, LocalDateTime dt2) {
        if (dt1.getYear() != dt2.getYear()) {
            return dt1.getYear() < dt2.getYear();
        }
        if (dt1.getMonthValue() != dt2.getMonthValue()) {
            return dt1.getMonthValue() < dt2.getMonthValue();
        }
        if (dt1.getDayOfMonth() != dt2.getDayOfMonth()) {
            return dt1.getDayOfMonth() < dt2.getDayOfMonth();
        }
        return dt1.getHour() <= dt2.getHour();
    }

    private static boolean isAfterByHour(LocalDateTime dt1, LocalDateTime dt2) {
        if (dt1.getYear() != dt2.getYear()) {
            return dt1.getYear() > dt2.getYear();
        }
        if (dt1.getMonthValue() != dt2.getMonthValue()) {
            return dt1.getMonthValue() > dt2.getMonthValue();
        }
        if (dt1.getDayOfMonth() != dt2.getDayOfMonth()) {
            return dt1.getDayOfMonth() > dt2.getDayOfMonth();
        }
        return dt1.getHour() >= dt2.getHour();
    }

}
