package usecases;

import entities.Book;
import entities.BorrowRecord;
import entities.Member;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class BorrowBookUseCase {
    private final LibraryRepository repo;

    public BorrowBookUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public Boolean execute(String bookId, String memberId) {
        Optional<Book> bookOpt = repo.findBookById(bookId);
        Optional<Member> memberOpt = repo.findMemberById(memberId);

        if (bookOpt.isEmpty())
            return false;
        if (memberOpt.isEmpty())
            return false;

        Book book = bookOpt.get();
        if (book.getAvailableCopies() < 1)
            return false;

        // mark bookunavailable

        BorrowRecord record = new BorrowRecord(
                UUID.randomUUID().toString(),
                bookId,
                memberId,
                LocalDate.now());
        repo.addBorrowRecord(record);

        return true;
    }
}
