package DesignPatterns.Creational.SimpleFactory.shipmentplan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
    public static void main(String args[]) throws IOException {
        GetPlan plan = new GetPlan();

        System.out.print("Enter the name of plan for bill generation: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planName = br.readLine();
        System.out.print("Enter the number of units consumed: ");
        int units = Integer.parseInt(br.readLine());

        Plan p = plan.getPlan(planName);

        System.out.print(
                "Bill amount for " + planName + " of  " + units + " units is: "
        );
        p.getRate();
        p.calculateBill(units);
    }
}
