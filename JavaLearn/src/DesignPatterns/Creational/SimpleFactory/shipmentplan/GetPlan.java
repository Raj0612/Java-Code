package DesignPatterns.Creational.SimpleFactory.shipmentplan;

public class GetPlan {
    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase("DOMESTIC")) {
            return new Domestic();
        } else if (planType.equalsIgnoreCase("COMMERCIAL")) {
            return new Commercial();
        } else if (planType.equalsIgnoreCase("INSTITUTIONAL")) {
            return new Institutional();
        }
        return null;
    }
}
