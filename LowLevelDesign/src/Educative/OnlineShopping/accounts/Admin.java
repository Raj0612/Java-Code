package Educative.OnlineShopping.accounts;

import Educative.OnlineShopping.enums.AccountStatus;
import Educative.OnlineShopping.products.ProductCategory;

public class Admin {
    private Account account;

    public Admin(Account account) {
        this.account = account;
    }

    public boolean blockUser(Account accountToBlock) {
        accountToBlock.setStatus(AccountStatus.BLOCKED);
        System.out.println("Account '" + accountToBlock.getUserName() + "' blocked by Admin '" + account.getUserName() + "'.");
        return true;
    }

    public boolean addNewProductCategory(ProductCategory category) {
        System.out.println("Product category '" + category.getName() + "' added by Admin '" + account.getUserName() + "'.");
        return true;
    }

    public boolean modifyProductCategory(ProductCategory category) {
        System.out.println("Product category '" + category.getName() + "' modified by Admin '" + account.getUserName() + "'.");
        return true;
    }

    public boolean deleteProductCategory(ProductCategory category) {
        System.out.println("Product category '" + category.getName() + "' deleted by Admin '" + account.getUserName() + "'.");
        return true;
    }
}
