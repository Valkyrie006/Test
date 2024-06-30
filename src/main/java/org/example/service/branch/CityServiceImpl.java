package main.java.org.example.service.branch;

import main.java.org.example.enums.BookingType;
import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.user.User;
import main.java.org.example.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Branch service at a city level
public class CityServiceImpl implements BranchService {
    private Map<Integer, Branch> branches; // {branchId, Branch}

    public CityServiceImpl() {
        this.branches = new HashMap<>();
    }

    // add branch by branch id, name, owner, prices
    @Override
    public Boolean addBranch(Integer branchId, String branchName, User branchOwner, Map<VehicleType, Double> prices) {
        Branch branch = new Branch(branchId, branchName, branchOwner, prices);
        branches.put(branch.getId(), branch);
        return Boolean.TRUE;
    }

    // remove branch by branch id
    @Override
    public Boolean removeBranch(Integer branchId) {
        branches.remove(branchId);
        return Boolean.TRUE;
    }

    // add vehicle by branch id and vehicle
    @Override
    public Boolean addVehicle(Integer branchId, Vehicle vehicle) {
        if (!branches.containsKey(branchId)) {
            System.out.println("Branch is not present with id: " + branchId);
            return Boolean.FALSE;
        }
        // add vehicle to our details
        Map<VehicleType, List<Vehicle>> vehicles = branches.get(branchId).getVehicles();

//        branches.get(branchId).getVehicles().getOrDefault(vehicle.getVehicleType(), new ArrayList<>()).add(vehicle);

        List<Vehicle> vehicleList = branches.get(branchId).getVehicles().get(vehicle.getVehicleType());
        if (vehicleList == null) {
            vehicleList = new ArrayList<>();
            vehicles.put(vehicle.getVehicleType(), vehicleList);
        }
        vehicleList.add(vehicle);
        return Boolean.TRUE;
    }

    @Override
    public Map<Integer, Branch> getAllBranches() {
        return branches;
    }
}
