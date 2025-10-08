package Educative.HotelManagement.accounts;

public abstract class Person {
    protected String name, email, phone;
    protected Address address;
    protected Account account;

    public Person(String name, Address addr, String email, String phone, Account acc) {
        this.name = name;
        this.address = addr;
        this.email = email;
        this.phone = phone;
        this.account = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
