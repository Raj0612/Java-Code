package Educative.VendingMachine.subjects;


import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Integer, Rack> racks = new HashMap<>();

    public void addRack(Rack rack) {
        racks.put(rack.getRackNumber(), rack);
    }

    public Rack getRack(int rackNumber) {
        return racks.get(rackNumber);
    }

    public boolean isAvailable(int rackNumber) {
        Rack rack = racks.get(rackNumber);
        return rack != null && !rack.isEmpty();
    }
}
