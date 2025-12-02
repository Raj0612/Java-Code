package DesignPatterns.Creational.Builder.UserDTOInner;

import DesignPatterns.Creational.Builder.User.Address;

import java.time.LocalDate;
import java.time.Period;

public class User {

    private String name;

    private String address;

    private String age;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nage=" + age + "\naddress=" + address ;
    }
    //Get builder instance
    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }
    //Builder
    public static class UserBuilder {

        private String firstName;

        private String lastName;

        private String age;

        private String address;

        private User userDTO;

        public UserBuilder withFirstName(String fname) {
            this.firstName = fname;
            return this;
        }

        public UserBuilder withLastName(String lname) {
            this.lastName = lname;
            return this;
        }

        public UserBuilder withBirthday(LocalDate date) {
            age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
            return this;
        }

        public UserBuilder withAddress(Address address) {
            this.address = address.getHouseNumber() + " " +address.getStreet()
                    + "\n"+address.getCity()+", "+address.getState()+" "+address.getZipcode();

            return this;
        }

        public User build() {
            this.userDTO = new User();
            userDTO.setName(firstName+" " + lastName);
            userDTO.setAddress(address);
            userDTO.setAge(age);
            return this.userDTO;
        }

        public User getUserDTO() {
            return this.userDTO;
        }
    }
}
