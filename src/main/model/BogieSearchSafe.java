package main.model;

public class BogieSearchSafe {

    public static boolean safeSearch(String[] arr, String key) {

        // Defensive check (Fail-Fast)
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search.");
        }

        // Linear Search (can also plug binary search here)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return true;
            }
        }

        return false;
    }
}
