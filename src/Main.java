import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.println("       === Train Consist Management App === ");
        System.out.println("========================================================\n");

        List<String> trainConsist = new LinkedList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Inital Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist);

        System.out.println("\nSystem ready for operations...");

        System.out.println("===========================");
        System.out.println("Add Passenger Bogies to Train (UC2)");
        System.out.println("===========================");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nAfter adding Bogies: ");
        System.out.println("Passenger Bogies: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair': ");
        System.out.println("Passenger Bogies: " + passengerBogies);

        System.out.println("\nChecking if 'Sleeper' exists: ");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

        System.out.println("\nFinal Train Passenger Consist: ");
        System.out.println(passengerBogies);

        System.out.println("\nCRUD operations(UC2) completed successfully...");

        System.out.println("\n\n===========================");
        System.out.println("Track Unique Bogie IDs (UC3)");
        System.out.println("===========================\n");

        Set<String> bogiesSet = new HashSet<>();
        bogiesSet.add("BG101");
        bogiesSet.add("BG102");
        bogiesSet.add("BG103");
        bogiesSet.add("BG104");
        bogiesSet.add("BG101");
        bogiesSet.add("BG102");

        System.out.println("Bogie IDs After Insertion: ");
        System.out.println(bogiesSet);

        System.out.println("\nNote:\nDuplicates are automatically ignored by the HashSet.\n");

        System.out.println("Uniqueness validation completed... (UC3)");

        System.out.println("\n\n=======================================");
        System.out.println("  Maintain Ordered Bogie Consist (UC4)");
        System.out.println("========================================\n");

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: ");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2: ");
        System.out.println(trainConsist);

        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("\nAfter removing First and Last Bogie: ");
        System.out.println(trainConsist);

        System.out.println("\nOrdered consist operations completed... (UC4)");

        System.out.println("\n\n========================================");
        System.out.println("  Preserve Insertion Order of Bogies (UC5)");
        System.out.println("=========================================\n");

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Guard");
        formation.add("Cargo");

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:\nLinkedHashSet preserves the insertion order and removes duplicates automatically.\n");
        System.out.println("Formation setup completed... (UC5)");

        System.out.println("\n\n========================================");
        System.out.println("  Map Bogie to Capacity (HashMap) (UC6)");
        System.out.println("========================================\n");

        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nBogie-capacity mapping completed... (UC6)");

        System.out.println("\n\n========================================");
        System.out.println("  Sort Bogies by Capacity (UC7)");
        System.out.println("========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));

        System.out.println("Before Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (Low to High Capacity):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nSorting operation completed... (UC7)");

        System.out.println("\n\n========================================");
        System.out.println("  Filter Passenger Bogies (UC8)");
        System.out.println("========================================\n");

        System.out.println("All Passenger Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        List<Bogie> filteredBogies = bogies
                .stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }

        System.out.println("\nFiltering operation completed... (UC8)");

        System.out.println("\n\n========================================");
        System.out.println("  Group Bogies by Type (UC9)");
        System.out.println("========================================\n");

        Map<String, List<Bogie>> groupedBogies = bogies
                .stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\n" + entry.getKey() + ":");
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
            }
        }

        System.out.println("\nGrouping operation completed... (UC9)");

        System.out.println("\n\n========================================");
        System.out.println("  Count Total Seats in Train (UC10)");
        System.out.println("========================================\n");

        int totalSeats = bogies
                .stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Passenger Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        System.out.println("\nAggregation operation completed... (UC10)");
    }
}