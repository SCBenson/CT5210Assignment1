package usecases;

import entities.Book;

import java.util.List;

public class ListBooksUseCase {
    private final LibraryRepository repo;

    public ListBooksUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public List<Book> execute() {
        return repo.getAllBooks();
    }
}
