package Educative.LibraryManagement.accounts;

import Educative.LibraryManagement.bookdetails.Book;
import Educative.LibraryManagement.bookdetails.BookItem;
import Educative.LibraryManagement.enums.AccountStatus;
import Educative.LibraryManagement.system.Library;

public class Librarian extends User {
    public Librarian(String id, String password, AccountStatus status, Person person, LibraryCard card) {
        super(id, password, status, person, card);
    }
    @Override
    public boolean resetPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) return false;
        this.password = newPassword;
        return true;
    }
    public boolean addBook(Book book) {
        if (book == null) return false;
        Library.getInstance().addBook(book);
        return true;
    }
    public boolean addBookItem(BookItem bookItem) {
        if (bookItem == null) return false;
        Library library = Library.getInstance();
        library.addBookItem(bookItem);
        // Optionally, add to the rack as well
        if (bookItem.getPlacedAt() != null) {
            bookItem.getPlacedAt().addBookItem(bookItem);
        }
        return true;
    }

    public boolean blockMember(Member member) {
        if (member == null) return false;
        member.status = AccountStatus.BLACKLISTED;
        return true;
    }

    public boolean unBlockMember(Member member) {
        if (member == null) return false;
        member.status = AccountStatus.ACTIVE;
        return true;
    }
}

