package main;

import main.model.PassengerSorter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC17: Sort Bogie Names using Arrays.sort()
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting: " + Arrays.toString(bogieTypes));

        Arrays.sort(bogieTypes);

        System.out.println("After Sorting: " + Arrays.toString(bogieTypes));
    }
}