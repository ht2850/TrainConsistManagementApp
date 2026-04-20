package main.model;

public class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCapacity() {
        // Simplified capacity for UC13 benchmarking
        return 100;
    }

    // UC15: Safe cargo assignment
    public void assignCargo(String cargo) {
        if ("Rectangular".equals(type) && "Petroleum".equals(cargo)) {
            throw new CargoSafetyException("Cannot assign petroleum to rectangular bogie!");
        }
        this.cargo = cargo;
    }
}