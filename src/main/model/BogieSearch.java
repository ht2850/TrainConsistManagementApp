package main.model;

public class BogieSearch {

    public static boolean linearSearch(String[] arr, String key) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].equals(key)) {
                return true; // early termination
            }
        }

        return false;
    }
}