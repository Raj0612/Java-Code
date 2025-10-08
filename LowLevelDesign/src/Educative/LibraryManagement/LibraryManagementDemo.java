package Educative.LibraryManagement;

import Educative.LibraryManagement.accounts.*;
import Educative.LibraryManagement.bookdetails.*;
import Educative.LibraryManagement.enums.*;
import Educative.LibraryManagement.reservations.*;
import Educative.LibraryManagement.system.Library;
import Educative.LibraryManagement.accounts.LibraryCard;

import java.time.LocalDate;
import java.util.*;

public class LibraryManagementDemo {

    public static void main(String[] args) {
        // Initialize Library
        Library library = Library.getInstance();
        library.setName("City Library");
        library.setAddress(new Address("123 Main St", "Metropolis", "NY", 10001, "USA"));

        // Create Librarian
        Address librarianAddress = new Address("789 Library Ave", "Metropolis", "NY", 10001, "USA");
        Person librarianPerson = new Person("Mr. John Doe", librarianAddress, "john.doe@library.com", "555-0000");
        LibraryCard librarianCard = new LibraryCard("LIB1001", LocalDate.now(), LocalDate.now().plusYears(5));
        Librarian librarian = new Librarian("L001", "admin123", AccountStatus.ACTIVE, librarianPerson, librarianCard);
        library.addLibrarian(librarian);

        // Create Member
        Address memberAddress = new Address("456 Elm St", "Metropolis", "NY", 10001, "USA");
        Person memberPerson = new Person("Alice Smith", memberAddress, "alice@example.com", "555-1234");
        LibraryCard memberCard = new LibraryCard("CARD1001", LocalDate.now(), LocalDate.now().plusYears(1));
        Member member = new Member("M001", "password", AccountStatus.ACTIVE, memberPerson, memberCard, LocalDate.now());
        library.addMember(member);

        // Create Book and BookItem
        Author author1 = new Author("Jane Austen");
        Book book1 = new ConcreteBook(
                "9780141439518",
                "Pride and Prejudice",
                "Fiction",
                "Penguin",
                "English",
                432,
                BookFormat.PAPERBACK,
                Arrays.asList(author1),
                LocalDate.of(1813, 1, 28)
        );
        librarian.addBook(book1);

        Rack rack1 = new Rack(1, "A1");
        BookItem bookItem1 = new BookItem(
                "B001",
                false,
                10.0,
                BookStatus.AVAILABLE,
                LocalDate.now(),
                book1.getPublicationDate(),
                rack1,
                book1
        );
        librarian.addBookItem(bookItem1);
        rack1.addBookItem(bookItem1);

        // Search for the book
        System.out.println("\nSearching for 'Pride and Prejudice'...");
        List<Book> foundBooks = library.getCatalog().searchByTitle("Pride and Prejudice");
        System.out.println("Found " + foundBooks.size() + " book(s):");
        for (Book b : foundBooks) {
            System.out.println(" - " + b.getTitle() + " by " + b.getAuthors().get(0).getName());
        }

        // Member tries to borrow the book
        System.out.println("\nMember attempts to borrow the book...");
        if (bookItem1.checkout(member.getId())) {
            member.incrementBooksCheckedOut();
            BookLending lending = new BookLending(bookItem1.getId(), LocalDate.now(), LocalDate.now().plusDays(15), member.getId());
            library.addLending(lending);
            System.out.println("Book checked out successfully by " + member.getPerson().getName());
        } else {
            System.out.println("Book could not be checked out.");
        }

        // Librarian blocks the member
        System.out.println("\nLibrarian blocks the member...");
        librarian.blockMember(member);
        System.out.println("Member status: " + member.getStatus());

        // Librarian unblocks the member
        System.out.println("\nLibrarian unblocks the member...");
        librarian.unBlockMember(member);
        System.out.println("Member status: " + member.getStatus());

        // Simulate overdue and notification
        System.out.println("\nChecking for overdue books and sending notifications...");
        // Manually set lending's due date to simulate overdue
        BookLending lending = library.getLending(bookItem1.getId());
        // Simulate that the due date was 5 days ago
        if (lending != null) {
            lending.setReturnDate(null); // Not yet returned
            lending = new BookLending(bookItem1.getId(), LocalDate.now().minusDays(20), LocalDate.now().minusDays(5), member.getId());
            library.addLending(lending);
        }
        library.checkOverdueBooksAndNotify();

        // Member returns the book (late)
        System.out.println("\nMember returns the book (late)...");
        if (bookItem1.returnBook()) {
            member.decrementBooksCheckedOut();
            BookLending returnedLending = library.getLending(bookItem1.getId());
            LocalDate actualReturnDate = LocalDate.now();
            if (returnedLending != null) {
                returnedLending.setReturnDate(actualReturnDate);
                double fine = Fine.calculateFine(returnedLending.getDueDate(), returnedLending.getReturnDate());
                if (fine > 0) {
                    System.out.println("Fine to be paid: $" + fine);
                } else {
                    System.out.println("Book returned on time, no fine.");
                }
                library.removeLending(bookItem1.getId());
            }
            System.out.println("Book returned successfully by " + member.getPerson().getName());
        } else {
            System.out.println("Book could not be returned.");
        }
    }
}
