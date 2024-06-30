package main.java.org.example.model.branch;

import main.java.org.example.enums.BookingType;
import main.java.org.example.enums.VehicleType;
import main.java.org.example.model.user.User;
import main.java.org.example.model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {
    private Integer id;
    private String name;
    private User owner;
    private Map<VehicleType, List<Vehicle>> vehicles; // vehicles by {vehicle type, List<Vehicle>}
    private Map<VehicleType, Double> prices; // price per timeslot per vehicle type

    public Branch(Integer id, String name, User owner, Map<VehicleType, Double> prices) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.vehicles = new HashMap<>();
        this.prices = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Map<VehicleType, List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<VehicleType, List<Vehicle>> vehicles) {
        this.vehicles = vehicles;
    }

    public Map<VehicleType, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<VehicleType, Double> prices) {
        this.prices = prices;
    }
}
