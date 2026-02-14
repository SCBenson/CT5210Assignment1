package frameworks;

import entities.Book;
import entities.Member;
import entities.BorrowRecord;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import usecases.LibraryRepository;

public class InMemoryLibraryRepository implements LibraryRepository {

    private List<Book> books;
    private List<Member> members;
    private List<BorrowRecord> borrowRecords;

    public InMemoryLibraryRepository() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new List<>(books);
    }

    @Override
    public Optional<Book> findBookById(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public Optional<Member> findMemberById(String memberId) {
        return members.stream().filter(member -> member.getMemberId().equals(memberId)).findFirst();
    }

    @Override
    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    @Override
    public Optional<BorrowRecord> findActiveBorrowByBookId(String bookId) {
        return borrowRecords.stream().filter(record -> record.getBookId().equals(bookId)).findFirst();
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return new List<>(borrowRecords);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return new List<>(Book);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        return new List<>(Book);
    }
}
