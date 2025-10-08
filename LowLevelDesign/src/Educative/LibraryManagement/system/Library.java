package Educative.LibraryManagement.system;

import Educative.LibraryManagement.accounts.*;
import Educative.LibraryManagement.bookdetails.*;
import Educative.LibraryManagement.catalogs.*;
import Educative.LibraryManagement.notifications.*;
import Educative.LibraryManagement.reservations.*;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private static Library instance = null;
    private String name;
    private Address address;
    private Catalog catalog = new Catalog();
    private Map<String, BookItem> bookItems = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    private Map<String, Librarian> librarians = new HashMap<>();
    private Map<String, BookReservation> reservations = new HashMap<>();
    private Map<String, BookLending> lendings = new HashMap<>();

    private Library() {
    }

    public static Library getInstance() {
        if (instance == null) instance = new Library();
        return instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void addBook(Book book) {
        catalog.addBook(book);
    }

    public void addBookItem(BookItem item) {
        bookItems.put(item.getId(), item);
    }

    public void addMember(Member m) {
        members.put(m.getId(), m);
    }

    public void addLibrarian(Librarian l) {
        librarians.put(l.getId(), l);
    }

    public BookItem getBookItem(String itemId) {
        return bookItems.get(itemId);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public BookLending getLending(String bookItemId) {
        return lendings.get(bookItemId);
    }

    public void addLending(BookLending lending) {
        lendings.put(lending.getBookItemId(), lending);
    }

    public void removeLending(String bookItemId) {
        lendings.remove(bookItemId);
    }

    public void addReservation(BookReservation reservation) {
        reservations.put(reservation.getBookItemId(), reservation);
    }

    public BookReservation getReservation(String bookItemId) {
        return reservations.get(bookItemId);
    }

    public void removeReservation(String bookItemId) {
        reservations.remove(bookItemId);
    }

    public List<BookItem> getAllBookItems() {
        return new ArrayList<>(bookItems.values());
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public List<Librarian> getAllLibrarians() {
        return new ArrayList<>(librarians.values());
    }

    public void checkOverdueBooksAndNotify() {
        for (BookLending lending : lendings.values()) {
            if (lending.isOverdue()) {
                Member member = members.get(lending.getMemberId());
                String content = "Book item " + lending.getBookItemId() + " is overdue!";
                new EmailNotification(UUID.randomUUID().toString(), LocalDate.now(), content, member.getPerson().getEmail()).sendNotification();
            }
        }
    }
}
