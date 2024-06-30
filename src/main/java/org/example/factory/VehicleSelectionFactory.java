package main.java.org.example.factory;

import main.java.org.example.enums.VehicleSelection;
import main.java.org.example.strategy.LowestPriceSelectionStrategyImpl;
import main.java.org.example.strategy.VehicleSelectionStrategy;

public class VehicleSelectionFactory {

    public static VehicleSelectionStrategy getVehicleSelectionFactory(VehicleSelection vehicleSelection) {
        switch (vehicleSelection) {
            case LOWEST_PRICE:
                return new LowestPriceSelectionStrategyImpl();
            default:
                System.out.println("No such strategy");
                return null;
        }
    }
}
