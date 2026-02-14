package usecases;

import entities.Book;
import entities.Member;
import entities.BorrowRecord;
import java.util.List;
import java.util.Optional;

public interface LibraryRepository {

    // Books
    void addBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> findBookById(String bookId);

    List<Book> searchBooksByTitle(String title);

    List<Book> findAvailableBooks();

    // members
    void addMember(Member member);

    Optional<Member> findMemberById(String memberId);

    // Borrow records
    void addBorrowRecord(BorrowRecord record);

    Optional<BorrowRecord> findActiveBorrowByBookId(String bookId);

    List<BorrowRecord> getAllBorrowRecords();
}
