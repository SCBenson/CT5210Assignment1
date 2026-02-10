package usecases;

import entities.Book;
import entities.BorrowRecord;

import java.time.LocalDate;
import java.util.Optional;

public class ReturnBookUseCase {
    private final LibraryRepository repo;

    public ReturnBookUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public String execute(String bookId) {
        Optional<Book> bookOpt = repo.findBookById(bookId);
        if (bookOpt.isEmpty()) return "Book not found.";

        Optional<BorrowRecord> recordOpt = repo.findActiveBorrowByBookId(bookId);
        if (recordOpt.isEmpty()) return "This book is not currently borrowed.";

        BorrowRecord record = recordOpt.get();
        record.markReturned(LocalDate.now());

        Book book = bookOpt.get();
        book.setAvailable(true);

        return "Returned successfully.";
    }
}

