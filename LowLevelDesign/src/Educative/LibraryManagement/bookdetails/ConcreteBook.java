package Educative.LibraryManagement.bookdetails;

import Educative.LibraryManagement.enums.BookFormat;

import java.time.LocalDate;
import java.util.List;

public class ConcreteBook extends Book {
    public ConcreteBook(String isbn, String title, String subject, String publisher, String language, int numberOfPages, BookFormat format, List<Author> authors, LocalDate pubDate) {
        super(isbn, title, subject, publisher, language, numberOfPages, format, authors, pubDate);
    }
}
