package Educative.LibraryManagement.bookdetails;

import Educative.LibraryManagement.enums.BookStatus;

import java.time.LocalDate;

public class BookItem {
    private String id;
    private boolean isReferenceOnly;
    private double price;
    private BookStatus status;
    private LocalDate dateOfPurchase, publicationDate, borrowed, dueDate;
    private Rack placedAt;
    private Book book;
    private String currentHolderId; // memberId who currently holds the book

    public BookItem(String id, boolean isReferenceOnly, double price, BookStatus status, LocalDate dateOfPurchase, LocalDate publicationDate, Rack placedAt, Book book) {
        this.id = id;
        this.isReferenceOnly = isReferenceOnly;
        this.price = price;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
        this.placedAt = placedAt;
        this.book = book;
        this.borrowed = null;
        this.dueDate = null;
        this.currentHolderId = null;
    }

    public String getId() {
        return id;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public double getPrice() {
        return price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Rack getPlacedAt() {
        return placedAt;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowed() {
        return borrowed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getCurrentHolderId() {
        return currentHolderId;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setBorrowed(LocalDate borrowed) {
        this.borrowed = borrowed;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCurrentHolderId(String memberId) {
        this.currentHolderId = memberId;
    }

    public boolean checkout(String memberId) {
        if (status != BookStatus.AVAILABLE || isReferenceOnly) return false;
        status = BookStatus.LOANED;
        borrowed = LocalDate.now();
        dueDate = borrowed.plusDays(15);
        currentHolderId = memberId;
        return true;
    }

    public boolean returnBook() {
        if (status != BookStatus.LOANED) return false;
        status = BookStatus.AVAILABLE;
        borrowed = null;
        dueDate = null;
        currentHolderId = null;
        return true;
    }

    public boolean reserve(String memberId) {
        if (status == BookStatus.AVAILABLE) return false; // Only reserve when not available
        status = BookStatus.RESERVED;
        currentHolderId = memberId;
        return true;
    }

    public boolean renew() {
        if (status != BookStatus.LOANED) return false;
        dueDate = dueDate.plusDays(15);
        return true;
    }
}
