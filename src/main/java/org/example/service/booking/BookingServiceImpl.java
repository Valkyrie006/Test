package main.java.org.example.service.booking;

import main.java.org.example.enums.VehicleSelection;
import main.java.org.example.enums.VehicleType;
import main.java.org.example.factory.VehicleSelectionFactory;
import main.java.org.example.helper.TimeUtils;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.timeslot.TimeSlot;
import main.java.org.example.model.user.User;
import main.java.org.example.model.vehicle.Vehicle;
import main.java.org.example.service.branch.BranchService;
import main.java.org.example.strategy.VehicleSelectionStrategy;

import java.util.List;
import java.util.Map;

public class BookingServiceImpl implements BookingService {

    private BranchService branchService;

    public BookingServiceImpl(BranchService branchService) {
        this.branchService = branchService;
    }

    @Override
    public Vehicle rentVehicleByVehicleTypeAndTimeSlot(User renter, VehicleType vehicleType, TimeSlot timeSlot) {
        // validation for timeslot
        if (!TimeUtils.isTimeSlotValid(timeSlot)) {
            return null;
        }

        Map<Integer, Branch> branchMap = branchService.getAllBranches();
        VehicleSelectionStrategy vehicleSelectionStrategy = VehicleSelectionFactory.getVehicleSelectionFactory(VehicleSelection.LOWEST_PRICE);
        Vehicle vehicle = vehicleSelectionStrategy.selectVehicle(vehicleType, timeSlot, branchMap);
        List<TimeSlot> timeSlotList = vehicle.getBookingSlots();
        timeSlotList.add(timeSlot);
        vehicle.setBookingSlots(timeSlotList);
        return vehicle;
    }
}
