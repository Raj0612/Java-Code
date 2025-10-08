package Educative.LibraryManagement.bookdetails;

import java.util.*;

public class Rack {
    private int number;
    private String locationIdentifier;
    private List<BookItem> bookItems = new ArrayList<>();

    public Rack(int number, String locationIdentifier) {
        this.number = number;
        this.locationIdentifier = locationIdentifier;
    }

    public void addBookItem(BookItem bookItem) {
        bookItems.add(bookItem);
    }

    public int getNumber() {
        return number;
    }

    public String getLocationIdentifier() {
        return locationIdentifier;
    }

    public List<BookItem> getBookItems() {
        return bookItems;
    }
}
