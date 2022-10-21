package com.judymeyers.carpool;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CarpoolCalculator {
    private Car car;
    private Trip trip;

    public CarpoolCalculator(Car car, Trip trip) {
        this.car = car;
        this.trip = trip;
    }

    public boolean yesReturnsTrueNoReturnsFalse (String inputYesOrNo) throws invalidInputException {

        if (inputYesOrNo.equalsIgnoreCase("y") || inputYesOrNo.equalsIgnoreCase("yes")) {
            return true;
        } else if (inputYesOrNo.equalsIgnoreCase("n") || inputYesOrNo.equalsIgnoreCase("no")) {
            return false;
        } else {
            throw new invalidInputException("Invalid input.");
        }
    }

    public BigDecimal calculateTotalCost() {
        BigDecimal totalCostDollars;

        BigDecimal gallonsGasNeeded = (trip.getMilesToDestination()).divide(car.getFuelEfficiencyMPG(), 2, RoundingMode.HALF_UP);
        totalCostDollars = gallonsGasNeeded.multiply(trip.getGasCostPerGallon());

        return totalCostDollars;
    }

    public BigDecimal divideCostByRiders() {
        BigDecimal costPerRider;

        costPerRider = (trip.getTotalCost()).divide(BigDecimal.valueOf(car.getCarRiders()), 2, RoundingMode.HALF_UP);

        return costPerRider;
    }

}
