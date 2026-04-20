package main;
import main.model.BogieSearchSafe;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC20: Exception Handling During Search
        String[] bogieIds = {}; // empty array

        String searchKey = "BG101";

        try {
            boolean found = BogieSearchSafe.safeSearch(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " found.");
            } else {
                System.out.println("Bogie ID " + searchKey + " not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}