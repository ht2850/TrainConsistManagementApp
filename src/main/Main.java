import model.GoodsBogie;
import model.PassengerBogie;
import model.SafetyValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // UC13: Performance Comparison
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
            goodsBogies.add(new GoodsBogie("Box", "Coal"));
        }

        // Loop-based filtering
        long startLoop = System.nanoTime();
        List<GoodsBogie> loopFiltered = new ArrayList<>();
        for (GoodsBogie b : goodsBogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        System.out.println("Loop filtering time: " + (endLoop - startLoop) + " ns");

        // Stream-based filtering
        long startStream = System.nanoTime();
        List<GoodsBogie> streamFiltered = goodsBogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
        long endStream = System.nanoTime();
        System.out.println("Stream filtering time: " + (endStream - startStream) + " ns");

        // UC14: Handle Invalid PassengerBogie Capacity
        try {
            PassengerBogie p1 = new PassengerBogie("Sleeper", 50);
            PassengerBogie p2 = new PassengerBogie("AC Chair", -5); // Invalid
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // UC15: Safe Cargo Assignment using try-catch-finally
        GoodsBogie g1 = new GoodsBogie("Rectangular", null);
        try {
            g1.assignCargo("Petroleum"); // unsafe assignment
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment validation completed.");
        }
    }
}