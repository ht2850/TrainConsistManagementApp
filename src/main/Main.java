import model.PassengerBogie;
import model.GoodsBogie;
import model.SafetyValidator;
import model.InvalidCapacityException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Create Passenger Bogies ---
        List<PassengerBogie> passengerBogies = new ArrayList<>();
        try {
            passengerBogies.add(new PassengerBogie("Sleeper", 72));
            passengerBogies.add(new PassengerBogie("AC Chair", 60));
            passengerBogies.add(new PassengerBogie("First Class", 0)); // This will throw exception
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating passenger bogie: " + e.getMessage());
        }

        System.out.println("Passenger Bogies:");
        for (PassengerBogie bogie : passengerBogies) {
            System.out.println(" - " + bogie);
        }

        // --- Create Goods Bogies ---
        List<GoodsBogie> goodsBogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal"),
                new GoodsBogie("Open", "Grain")
        );

        // --- Safety Validation ---
        boolean trainSafe = SafetyValidator.isTrainSafe(goodsBogies);
        System.out.println("Goods bogies safe: " + trainSafe);

        // --- UC13 Performance Benchmarking (Loop vs Stream) ---
        int threshold = 60;

        // Loop-based
        long startLoop = System.nanoTime();
        List<PassengerBogie> filteredLoop = new ArrayList<>();
        for (PassengerBogie b : passengerBogies) {
            if (b.getCapacity() > threshold) {
                filteredLoop.add(b);
            }
        }
        long endLoop = System.nanoTime();
        System.out.println("Loop filtering took: " + (endLoop - startLoop) + " ns");

        // Stream-based
        long startStream = System.nanoTime();
        List<PassengerBogie> filteredStream = passengerBogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .toList();
        long endStream = System.nanoTime();
        System.out.println("Stream filtering took: " + (endStream - startStream) + " ns");

        // Verify results match
        System.out.println("Loop and Stream results match: " + (filteredLoop.size() == filteredStream.size()));

        System.out.println("Program continues safely...");
    }
}