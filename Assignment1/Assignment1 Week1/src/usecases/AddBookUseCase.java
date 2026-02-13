package usecases;

import entities.Book;

public class AddBookUseCase {
    private final LibraryRepository repo;

    public AddBookUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public void execute(String title, String author, String isbn, int copies) {
        Book book = new Book(title, author, isbn, copies);
        repo.addBook(book);
    }
}