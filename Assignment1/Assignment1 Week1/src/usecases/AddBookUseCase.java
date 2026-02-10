package usecases;

import entities.Book;

public class AddBookUseCase {
    private final LibraryRepository repo;

    public AddBookUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public void execute(String id, String title, String author) {
        Book book = new Book(id, title, author);
        repo.addBook(book);
    }
}