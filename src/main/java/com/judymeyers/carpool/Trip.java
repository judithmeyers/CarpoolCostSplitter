package com.judymeyers.carpool;

import java.math.BigDecimal;

public class Trip {
    private BigDecimal milesToDestination = BigDecimal.ZERO;
    private boolean isDistanceSameBothWays;
    private boolean tollsExist;
    private BigDecimal tollsTotalCost = BigDecimal.ZERO;
    private BigDecimal gasCostPerGallon;
    private BigDecimal totalCost;
    private BigDecimal costPerRider;


    public BigDecimal getMilesToDestination() {
        return milesToDestination;
    }

    public void setMilesToDestination(BigDecimal milesToDestination) {
        this.milesToDestination = milesToDestination;
    }

    public boolean isDistanceSameBothWays() {
        return isDistanceSameBothWays;
    }

    public void setDistanceSameBothWays(boolean distanceSameBothWays) {
        isDistanceSameBothWays = distanceSameBothWays;
    }

    public boolean isTollsExist() {
        return tollsExist;
    }

    public void setTollsExist(boolean tollsExist) {
        this.tollsExist = tollsExist;
    }

    public BigDecimal getTollsTotalCost() {
        return tollsTotalCost;
    }

    public void setTollsTotalCost(BigDecimal tollsTotalCost) {
        this.tollsTotalCost = tollsTotalCost;
    }

    public BigDecimal getGasCostPerGallon() {
        return gasCostPerGallon;
    }

    public void setGasCostPerGallon(BigDecimal gasCostPerGallon) {
        this.gasCostPerGallon = gasCostPerGallon;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getCostPerRider() {
        return costPerRider;
    }

    public void setCostPerRider(BigDecimal costPerRider) {
        this.costPerRider = costPerRider;
    }
}


