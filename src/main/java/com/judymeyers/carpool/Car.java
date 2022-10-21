package com.judymeyers.carpool;

import java.math.BigDecimal;

public class Car {
   private BigDecimal fuelEfficiencyMPG;
   private int carRiders;

   public BigDecimal getFuelEfficiencyMPG() {
      return fuelEfficiencyMPG;
   }

   public void setFuelEfficiencyMPG(BigDecimal fuelEfficiencyMPG) {
      this.fuelEfficiencyMPG = fuelEfficiencyMPG;
   }

   public int getCarRiders() {
      return carRiders;
   }

   public void setCarRiders(int carRiders) {
      this.carRiders = carRiders;
   }
}
