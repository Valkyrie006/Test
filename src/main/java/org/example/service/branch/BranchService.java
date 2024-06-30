package main.java.org.example.service.branch;

import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.branch.Branch;
import main.java.org.example.model.user.User;
import main.java.org.example.model.vehicle.Vehicle;

import java.util.Map;

public interface BranchService {

    Boolean addBranch(Integer branchId, String branchName, User branchOwner, Map<VehicleType, Double> prices);

    Boolean removeBranch(Integer branchId);

    Boolean addVehicle(Integer branchId, Vehicle vehicle);

    Map<Integer, Branch> getAllBranches();
}
