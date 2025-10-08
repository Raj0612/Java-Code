package Educative.LibraryManagement.catalogs;

import Educative.LibraryManagement.bookdetails.Book;

import java.time.LocalDate;
import java.util.List;

public interface Search {
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    List<Book> searchBySubject(String subject);
    List<Book> searchByPublicationDate(LocalDate publishDate);
}
