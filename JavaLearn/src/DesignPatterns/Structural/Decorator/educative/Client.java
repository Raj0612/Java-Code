package DesignPatterns.Structural.Decorator.educative;

public class Client {
    public static void main(String[] args) {
        IAircraft simpleBoeing = new Boeing747();
        IAircraft luxuriousBoeing = new LuxuryFittings(simpleBoeing);
        IAircraft bulletProofBoeing = new BulletProof(luxuriousBoeing);
        float netWeight = bulletProofBoeing.getWeight();
        System.out.println("Final weight of the plane: " + netWeight);

        IAircraft simpleBoeing1 = new Boeing747();
        IAircraft luxuriousBoeing1 = new LuxuryFittings(simpleBoeing1   );
        float netWeight1 = luxuriousBoeing1.getWeight();
        System.out.println("Final weight of the plane1: " + netWeight1);

        IAircraft bulletProofBoeing1 =new BulletProof(new Boeing747());
        float netWeight2 = bulletProofBoeing1.getWeight();
        System.out.println("Final weight of the plane: " + netWeight2);

    }
}
