package Educative.LibraryManagement.bookdetails;

import Educative.LibraryManagement.enums.BookStatus;

import java.time.LocalDate;
// BookItemFactory (Factory Pattern)
public class BookItemFactory {
    public static BookItem createBookItem(String id, boolean isReferenceOnly, double price, BookStatus status, LocalDate dateOfPurchase, LocalDate publicationDate, Rack placedAt, Book book) {
        return new BookItem(id, isReferenceOnly, price, status, dateOfPurchase, publicationDate, placedAt, book);
    }
}
