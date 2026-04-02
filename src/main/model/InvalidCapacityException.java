package model;

// UC14: Custom checked exception
public class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}