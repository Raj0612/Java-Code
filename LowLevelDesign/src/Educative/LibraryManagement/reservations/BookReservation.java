package Educative.LibraryManagement.reservations;

import Educative.AirlineManagement.enums.ReservationStatus;

import java.time.LocalDate;

public class BookReservation {
    private String bookItemId;
    private LocalDate creationDate;
    private ReservationStatus status;
    private String memberId;

    public BookReservation(String itemId, LocalDate creationDate, ReservationStatus status, String memberId) {
        this.bookItemId = itemId;
        this.creationDate = creationDate;
        this.status = status;
        this.memberId = memberId;
    }

    public String getBookItemId() {
        return bookItemId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
