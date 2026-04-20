package main;

import main.model.BogieSearchOptimized;
import main.model.PassengerSorter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC19: Binary Search for Bogie ID
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        // IMPORTANT: Ensure sorted (precondition)
        Arrays.sort(bogieIds);

        String searchKey = "BG309";

        boolean found = BogieSearchOptimized.binarySearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }
    }
}