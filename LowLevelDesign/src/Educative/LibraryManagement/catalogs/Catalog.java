package Educative.LibraryManagement.catalogs;

import Educative.LibraryManagement.bookdetails.Author;
import Educative.LibraryManagement.bookdetails.Book;

import java.time.LocalDate;
import java.util.*;

public class Catalog implements Search {
    private Map<String, List<Book>> bookTitles = new HashMap<>();
    private Map<String, List<Book>> bookAuthors = new HashMap<>();
    private Map<String, List<Book>> bookSubjects = new HashMap<>();
    private Map<LocalDate, List<Book>> bookPublicationDates = new HashMap<>();

    public void addBook(Book book) {
        bookTitles.computeIfAbsent(book.getTitle(), k -> new ArrayList<>()).add(book);
        for (Author author : book.getAuthors()) {
            bookAuthors.computeIfAbsent(author.getName(), k -> new ArrayList<>()).add(book);
        }
        bookSubjects.computeIfAbsent(book.getSubject(), k -> new ArrayList<>()).add(book);
        bookPublicationDates.computeIfAbsent(book.getPublicationDate(), k -> new ArrayList<>()).add(book);
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookTitles.getOrDefault(title, new ArrayList<>());
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookAuthors.getOrDefault(author, new ArrayList<>());
    }

    @Override
    public List<Book> searchBySubject(String subject) {
        return bookSubjects.getOrDefault(subject, new ArrayList<>());
    }

    @Override
    public List<Book> searchByPublicationDate(LocalDate publishDate) {
        return bookPublicationDates.getOrDefault(publishDate, new ArrayList<>());
    }
}
