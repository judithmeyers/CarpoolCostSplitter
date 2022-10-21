package com.judymeyers.carpool;

public class Application {

    public static void main(String[] args) {

    Trip trip = new Trip();
    Car car = new Car();
    CarpoolCalculator calculator = new CarpoolCalculator(car, trip);
    CalculatorUI UI = new CalculatorUI(calculator, trip, car);

    UI.run();

    }


}
