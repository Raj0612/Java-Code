package Educative.OnlineShopping.accounts;

import Educative.OnlineShopping.enums.AccountStatus;
import Educative.OnlineShopping.payments.CreditCard;
import Educative.OnlineShopping.payments.ElectronicBankTransfer;
import Educative.OnlineShopping.products.Product;
import Educative.OnlineShopping.products.ProductReview;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userName;
    private String password;
    private String name;
    private List<Address> shippingAddresses;
    private AccountStatus status;
    private String email;
    private String phone;
    private List<CreditCard> creditCards;
    private List<ElectronicBankTransfer> bankAccounts;

    public Account(String userName, String password, String name, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.shippingAddresses = new ArrayList<>();
        this.creditCards = new ArrayList<>();
        this.bankAccounts = new ArrayList<>();
        this.status = AccountStatus.ACTIVE;
    }


    public Address getShippingAddress() {
        if (!shippingAddresses.isEmpty()) {
            return shippingAddresses.get(0);
        }
        return null;
    }

    public boolean addProduct(Product product) {
        System.out.println("Product '" + product.getName() + "' added by account " + this.userName);
        return true;
    }

    public boolean addProductReview(ProductReview review, Product product) {
        product.getReviews().add(review);
        System.out.println("Review added for product '" + product.getName() + "' by account " + this.userName);
        return true;
    }

    public boolean deleteProduct(Product product) {
        System.out.println("Product '" + product.getName() + "' deleted by account " + this.userName);
        return true;
    }

    public boolean deleteProductReview(ProductReview review, Product product) {
        product.getReviews().remove(review);
        System.out.println("Review removed for product '" + product.getName() + "' by account " + this.userName);
        return true;
    }

    public boolean resetPassword() {
        System.out.println("Password reset for account " + userName);
        return true;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<Address> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
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

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<ElectronicBankTransfer> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<ElectronicBankTransfer> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
