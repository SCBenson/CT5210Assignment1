package controller;

import entities.Book;
import frameworks.InMemoryLibraryRepository;
import usecases.*;

import java.util.List;
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

    private void addBook(String title, String author, String isbn, int copies) {
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

}
