package ashishps1.parkinglot.fee;

import ashishps1.parkinglot.Ticket;
import ashishps1.parkinglot.vehicletype.VehicleType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleType, Double> hourlyRates;
    public VehicleBasedFeeStrategy() {
        Map<VehicleType, Double> rates = new HashMap<>();
        rates.put(VehicleType.CAR, 20.0);
        rates.put(VehicleType.BIKE, 10.0);
        rates.put(VehicleType.TRUCK, 30.0);

        // Wrap the HashMap in an unmodifiable map
        hourlyRates = Collections.unmodifiableMap(rates);
    }

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * hourlyRates.get(ticket.getVehicle().getType());
    }
}