package main;

import main.model.PassengerSorter;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC16: Bubble Sort on Passenger Bogie Capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Before Sorting: ");
        PassengerSorter.printArray(capacities);

        PassengerSorter.bubbleSort(capacities);

        System.out.print("After Sorting: ");
        PassengerSorter.printArray(capacities);
    }
}