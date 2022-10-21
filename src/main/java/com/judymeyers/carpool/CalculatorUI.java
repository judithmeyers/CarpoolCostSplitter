package com.judymeyers.carpool;

import com.judymeyers.carpool.CarpoolCalculator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class CalculatorUI {
    private final Scanner keyboard = new Scanner(System.in);
    private CarpoolCalculator carpoolCalculator;
    private Trip trip;
    private Car car;


    public CalculatorUI(CarpoolCalculator carpoolCalculator, Trip trip, Car car) {
        this.carpoolCalculator = carpoolCalculator;
        this.trip = trip;
        this.car = car;
    }

    public void run() {

        System.out.println("**********************************");
        System.out.println("Welcome to the carpool calculator!");
        System.out.println("**********************************");
        System.out.println();

        while (true) {
            System.out.print("How many miles is the trip to your destination? ");
            String milesOneWayString = keyboard.nextLine().trim();

            try {
                BigDecimal milesOneWay = new BigDecimal(milesOneWayString);
                if (milesOneWay.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Please enter a positive number.");
                } else {
                    trip.setMilesToDestination(milesOneWay);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. Please enter a numeric value for number of miles.");
            }
        }

        while (true) {
            System.out.println();
            System.out.print("Is your trip the same distance both ways? Enter Y (yes) or N (no). ");
            String response = keyboard.nextLine().trim();

            try {
                trip.setDistanceSameBothWays(carpoolCalculator.yesReturnsTrueNoReturnsFalse(response));
                break;
            } catch (invalidInputException e) {
                System.out.println("INVALID INPUT. Is your trip the same distance both ways? Please enter Y (yes) or N (no).");
            }
        }

        if (!trip.isDistanceSameBothWays()) {
            System.out.println();
            System.out.print("What is the distance for the return portion of your trip in miles? ");
            String returnDistanceString = keyboard.nextLine().trim();

            try {
                BigDecimal returnDistanceMiles = new BigDecimal(returnDistanceString);
                if (returnDistanceMiles.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Please enter a positive number.");
                }
                trip.setMilesToDestination(trip.getMilesToDestination().add(returnDistanceMiles));
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. Please enter a numeric value for number of miles.");
            }
        } else {
            trip.setMilesToDestination(trip.getMilesToDestination().multiply(BigDecimal.valueOf(2)));
        }

        while (true) {
            System.out.println();
            System.out.print("Are there any tolls on your route? Enter Y (yes) or N (no). ");
            String response = keyboard.nextLine().trim();

            try {
                trip.setTollsExist(carpoolCalculator.yesReturnsTrueNoReturnsFalse(response));
                break;
            } catch (invalidInputException e) {
                System.out.println("INVALID INPUT. Is your trip the same distance both ways? Please enter Y (yes) or N (no). ");
            }
        }

        if (trip.isTollsExist()) {
            System.out.println();
            System.out.print("What is the total cost in dollars for the tolls on your trip? Enter a number (without dollar sign). ");
            String response = keyboard.nextLine();

            try {
                BigDecimal tollsCost = new BigDecimal(response);
                if (tollsCost.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Please enter a positive number.");
                }
                trip.setTollsTotalCost(tollsCost);
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. Please enter total tolls cost without dollar signs. ");
            }
        }

        while (true) {
            System.out.println();
            System.out.print("What is the price of gas per gallon. Enter a number without dollar signs. ");
            String response = keyboard.nextLine().trim();

            try {
                BigDecimal gasCostPerGallon = new BigDecimal(response);
                if (gasCostPerGallon.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Please enter a positive number.");
                }
                trip.setGasCostPerGallon(gasCostPerGallon);
                break;
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. Please enter a number representing the price of gas per gallon (no dollar sign).");
            }
        }

        while (true) {
            System.out.println();
            System.out.print("What is your car's fuel efficiency? Give a number of miles per gallon. ");
            String response = keyboard.nextLine().trim();

            try {
                BigDecimal fuelEfficiency = new BigDecimal(response);
                if (fuelEfficiency.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("Please enter a positive number.");
                }
                car.setFuelEfficiencyMPG(fuelEfficiency);
                break;
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. Please enter your car's fuel efficiency with a whole number of miles per gallon.");
            }

        }

        while (true) {
            System.out.println();
            System.out.print("How many people do you want to split with? ");
            String carRidersString = keyboard.nextLine().trim();

            try {
                Integer carRiders = Integer.parseInt(carRidersString);
                if (carRiders <= 0) {
                    System.out.println("Please enter a number greater than zero.");
                }
                car.setCarRiders(carRiders);
                break;
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT. Please enter a number of car riders you want to split the cost with.");
            }
        }

        trip.setTotalCost(carpoolCalculator.calculateTotalCost());
        trip.setCostPerRider(carpoolCalculator.divideCostByRiders());

        System.out.println("  ------------------------------------------------------------------------------------------- ");
        System.out.println("| The total cost of the car trip including tolls and gas will be: " + NumberFormat.getCurrencyInstance().format(trip.getTotalCost()) + "|");
        System.out.println("| Each car rider should pay: " + NumberFormat.getCurrencyInstance().format(trip.getCostPerRider()) + " |");
        System.out.println("  ------------------------------------------------------------------------------------------- ");

        System.out.println();
        System.out.println("Enter 'Q' to exit.");
        String input = keyboard.next();

        if (input.equalsIgnoreCase("Q")) {
            System.exit(0);
        }
    }
}

