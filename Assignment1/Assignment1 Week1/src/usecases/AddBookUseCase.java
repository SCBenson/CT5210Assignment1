package usecases;

import entities.Book;

public class AddBookUseCase {
    private final LibraryRepository repo;

    public AddBookUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public void execute(Book book) {
        repo.addBook(book);
    }
}