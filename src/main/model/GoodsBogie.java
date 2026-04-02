package model;

public class GoodsBogie {

    private String type;
    private String cargo;   // used for safety checks
    private int capacity;   // used for performance tests

    // Constructor for safety tests
    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
        this.capacity = 0; // default capacity
    }

    // Constructor for performance tests
    public GoodsBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.cargo = ""; // no cargo for performance tests
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        if (!cargo.isEmpty()) {
            return type + "(" + cargo + ")";
        } else {
            return type + "(capacity=" + capacity + ")";
        }
    }
}