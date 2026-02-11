package entities;

import java.time.LocalDate; // was java.util.LocalDate --> Changed to java.time.LocalDate

public class BorrowRecord {
    private final String recordId;
    private final String bookId;
    private final String memberId;
    private final LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(String recordId, String bookId, String memberId, LocalDate borrowDate) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public void markReturned(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "BorrowRecord{recordId='" + recordId + "', bookId='" + bookId + "', memberId='" + memberId +
                "', borrowDate=" + borrowDate + ", returnDate=" + returnDate + "}";
    }
}
