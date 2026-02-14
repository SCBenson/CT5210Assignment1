package controller;

import entities.Book;
import entities.Member;
import entities.BorrowRecord;
import frameworks.InMemoryLibraryRepository;
import usecases.*;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class LibraryController {
    private final InMemoryLibraryRepository repository;
    private final AddBookUseCase addBookUseCase;
    private final BorrowBookUseCase borrowBookUseCase;
    private final ListBookUseCase listBookUseCase;
    private final RegisterMemberUseCase registerMemberUseCase;
    private final ReturnBookUseCase returnBookUseCase;

    public LibraryController() {
        this.repository = new InMemoryLibraryRepository();
        this.addBookUseCase = new AddBookUseCase(repository);
        this.borrowBookUseCase = new BorrowBookUseCase(repository);
        this.listBookUseCase = new ListBookUseCase(repository);
        this.registerMemberUseCase = new RegisterMemberUseCase(repository);
        this.returnBookUseCase = new ReturnBookUseCase(repository);
    }

    public void addBook(String title, String author, String isbn, int copies) {
        try {
            Book book = new Book(title, author, isbn, copies);
            addBookUseCase.execute(book);
            System.out.println("Book added Successfully: " + title);
        } catch (Exception e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    public ArrayList<Book> listAllBooks() {
        try {
            List<Book> books = listBookUseCase.execute();
            return new ArrayList<>(books);
        } catch (Exception e) {
            System.err.println("Error listing books: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Boolean borrowBook(String memberId, String bookId) {
        try {
            boolean success = borrowBookUseCase.execute(memberId, bookId);
            if (success) {
                System.out.println("Book borrowed successfully!");
            } else {
                System.out.println("Failed to borrow book. Check your member ID and book ID.");
            }
            return success;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<BorrowRecord> listBorrowRecord() {
        try {
            List<BorrowRecord> borrowRecord = repository.getAllBorrowRecords();
            return new ArrayList<>(borrowRecord);
        } catch (Exception e) {
            System.err.println("Error listing borrow records:");
            return new ArrayList<>();
        }
    }

    public boolean returnBook(String memberId, String bookId) {
        try {
            boolean success = returnBookUseCase.execute(bookId);
            if (success) {
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Failed to return book. Check your member ID and book ID");
            }
            return success;
        } catch (Exception e) {
            System.err.println("Failed to return book: " + bookId);
            return false;
        }
    }

    public Optional<Book> findBookById(String isbn) {
        try {
            return repository.findBookById(isbn);
        } catch (Exception e) {
            System.err.println("Error finding book: " + e.getMessage());
            return null;
        }
    }

    public void registerMember(String name, String memberId) {
        try {
            Member member = new Member(name, memberId);
            registerMemberUseCase.execute(member);
            System.out.println("Member registered successfully: " + name);
        } catch (Exception e) {
            System.err.println("Error registering member: " + name);
        }
    }

    public boolean isValidBook(String title, String author, String isbn, int copies) {
        return title != null && !title.trim().isEmpty() &&
                author != null && !author.trim().isEmpty() &&
                isbn != null && !isbn.trim().isEmpty() &&
                copies > 0;
    }

    public boolean isValidMember(String name, String memberId) {
        return name != null && !name.trim().isEmpty() &&
                memberId != null && !memberId.trim().isEmpty();
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        try {
            List<Book> searchedBook = repository.searchBooksByTitle(title);
            return new ArrayList<>(searchedBook);
        } catch (Exception e) {
            System.err.println("Error searching books by title: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Book> searchBooksByAuthor(String author) {
        try {
            List<Book> searchedBook = repository.searchBooksByAuthor(author);
            return new ArrayList<>(searchedBook);
        } catch (Exception e) {
            System.err.println("Error searching books by author: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Book> getAvailableBooks() {
        try {
            List<Book> availableBooks = repository.findAvailableBooks();
            return new ArrayList<>(availableBooks);
        } catch (Exception e) {
            System.err.println("Error finding available books: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
