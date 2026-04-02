import model.GoodsBogie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Step 1: Prepare dataset
        List<GoodsBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new GoodsBogie("Goods", 50 + i % 100)); // capacities 50-149
        }

        // ---------------- Loop-Based Filtering ----------------
        long startLoop = System.nanoTime();
        List<GoodsBogie> loopFiltered = new ArrayList<>();
        for (GoodsBogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;
        System.out.println("Loop-Based Filtering: " + loopFiltered.size() + " bogies, Time = " + loopDuration + " ns");

        // ---------------- Stream-Based Filtering ----------------
        long startStream = System.nanoTime();
        List<GoodsBogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;
        System.out.println("Stream-Based Filtering: " + streamFiltered.size() + " bogies, Time = " + streamDuration + " ns");

        // ---------------- Verification ----------------
        boolean resultsMatch = loopFiltered.size() == streamFiltered.size();
        System.out.println("Do loop and stream results match? " + resultsMatch);
    }
}