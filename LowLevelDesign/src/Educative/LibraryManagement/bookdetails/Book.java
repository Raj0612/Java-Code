package Educative.LibraryManagement.bookdetails;

import Educative.LibraryManagement.enums.BookFormat;

import java.time.LocalDate;
import java.util.*;

public abstract class Book {
    private String isbn;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private BookFormat bookFormat;
    private List<Author> authors;
    private LocalDate publicationDate;

    public Book(String isbn, String title, String subject, String publisher, String language, int numberOfPages, BookFormat bookFormat, List<Author> authors, LocalDate publicationDate) {
        this.isbn = isbn;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.bookFormat = bookFormat;
        this.authors = authors;
        this.publicationDate = publicationDate;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
