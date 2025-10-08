package DesignPatterns.Structural.Adapter.educative;

public class HotAirBalloon {
    String gasUsed = "Helium";

    void fly(String gasUsed) {
        System.out.println("Flying with " + gasUsed);
    }

    // Function returns the gas used by the balloon for flight
    String inflateWithGas() {
        return gasUsed;
    }
}
