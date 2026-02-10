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

    public String execute(String bookId, String memberId) {
        Optional<Book> bookOpt = repo.findBookById(bookId);
        Optional<Member> memberOpt = repo.findMemberById(memberId);

        if (bookOpt.isEmpty()) return "Book not found.";
        if (memberOpt.isEmpty()) return "Member not found.";

        Book book = bookOpt.get();
        if (!book.isAvailable()) return "Book is already borrowed.";

        // Mark book unavailable
        book.setAvailable(false);

        BorrowRecord record = new BorrowRecord(
                UUID.randomUUID().toString(),
                bookId,
                memberId,
                LocalDate.now()
        );
        repo.addBorrowRecord(record);

        return "Borrowed successfully.";
    }
}
