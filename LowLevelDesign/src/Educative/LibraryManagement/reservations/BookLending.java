package Educative.LibraryManagement.reservations;


import java.time.LocalDate;

public class BookLending {
    private String bookItemId;
    private LocalDate creationDate, dueDate, returnDate;
    private String memberId;

    public BookLending(String itemId, LocalDate creationDate, LocalDate dueDate, String memberId) {
        this.bookItemId = itemId;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.memberId = memberId;
        this.returnDate = null;
    }

    public String getBookItemId() {
        return bookItemId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }

    public boolean isOverdue() {
        return returnDate == null && dueDate != null && dueDate.isBefore(LocalDate.now());
    }
}
