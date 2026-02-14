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

    public boolean execute(String bookId) {
        Optional<Book> bookOpt = repo.findBookById(bookId);
        if (bookOpt.isEmpty())
            return false;

        Optional<BorrowRecord> recordOpt = repo.findActiveBorrowByBookId(bookId);
        if (recordOpt.isEmpty())
            return false;

        BorrowRecord record = recordOpt.get();
        record.markReturned(LocalDate.now());

        Book book = bookOpt.get();

        return true;
    }
}
