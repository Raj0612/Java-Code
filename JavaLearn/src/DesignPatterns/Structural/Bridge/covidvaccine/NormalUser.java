package DesignPatterns.Structural.Bridge.covidvaccine;

import java.util.List;

public class NormalUser extends User{
    public List<User> getBeneficiaries() {
        return beneficiaries;
    }

    private List<User> beneficiaries;

    public NormalUser(String userId, String userName, int age, String gender, IdType idType, String idNumber, List<User> beneficiaries) {
        super(userId, userName, age, gender, idType, idNumber);
        this.beneficiaries = beneficiaries;
    }
}
