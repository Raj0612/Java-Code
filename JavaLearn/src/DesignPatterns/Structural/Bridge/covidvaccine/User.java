package DesignPatterns.Structural.Bridge.covidvaccine;

public class User {

    private String userId;
    private String userName;
    private int age;
    private String gender;
    private IdType idType;
    private String idNumber;

    public User(String userId, String userName, int age, String gender, IdType idType, String idNumber) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.idType = idType;
        this.idNumber = idNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public IdType getIdType() {
        return idType;
    }

    public String getIdNumber() {
        return idNumber;
    }
}
