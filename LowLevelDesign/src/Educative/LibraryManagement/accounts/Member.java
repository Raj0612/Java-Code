package Educative.LibraryManagement.accounts;

import Educative.LibraryManagement.enums.AccountStatus;
import Educative.LibraryManagement.reservations.BookLending;

import java.time.LocalDate;
import java.util.*;

public class Member extends User {
    private LocalDate dateOfMembership;
    private int totalBooksCheckedOut;

    private List<BookLending> lendings = new ArrayList<>();

    public Member(String id, String password, AccountStatus status, Person person, LibraryCard card, LocalDate dateOfMembership) {
        super(id, password, status, person, card);
        this.dateOfMembership = dateOfMembership;
        this.totalBooksCheckedOut = 0;
    }

    public int getTotalBooksCheckedOut() {
        return totalBooksCheckedOut;
    }

    public List<BookLending> getLendings() {
        return lendings;
    }

    public boolean canCheckout() {
        return totalBooksCheckedOut < 10;
    }

    public void incrementBooksCheckedOut() {
        totalBooksCheckedOut++;
    }

    public void decrementBooksCheckedOut() {
        if (totalBooksCheckedOut > 0) totalBooksCheckedOut--;
    }

    @Override
    public boolean resetPassword(String newPassword) {
        this.password = newPassword;
        return true;
    }
}
