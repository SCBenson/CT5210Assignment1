package frameworks;

import entities.Book;
import entities.Member;
import entities.BorrowRecord;
import java.util.ArrayList;
import java.util.Optional;

import usecases.LibraryRepository;

public class InMemoryLibraryRepository implements LibraryRepository {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books);
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
    public ArrayList<BorrowRecord> getAllBorrowRecords() {
        return new ArrayList<>(borrowRecords);
    }
}