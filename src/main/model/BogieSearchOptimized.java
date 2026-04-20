package main.model;

public class BogieSearchOptimized {
    public static boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = key.compareTo(arr[mid]);

            if (result == 0) {
                return true; // found
            }
            else if (result > 0) {
                low = mid + 1; // search right
            }
            else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }
}
