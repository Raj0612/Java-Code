package ashishps1.parkinglot.fee;

import ashishps1.parkinglot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
