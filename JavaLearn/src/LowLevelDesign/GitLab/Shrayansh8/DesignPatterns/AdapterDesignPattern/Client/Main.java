package LowLevelDesign.GitLab.Shrayansh8.DesignPatterns.AdapterDesignPattern.Client;

import LowLevelDesign.GitLab.Shrayansh8.DesignPatterns.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import LowLevelDesign.GitLab.Shrayansh8.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import LowLevelDesign.GitLab.Shrayansh8.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
