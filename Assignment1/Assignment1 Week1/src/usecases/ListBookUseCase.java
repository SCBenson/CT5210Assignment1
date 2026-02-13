package usecases;

import entities.Book;
import java.util.List;

public class ListBookUseCase { // Typo it said ListBooksUseCase --> changed to ListBookUseCase
    private final LibraryRepository repo;

    public ListBookUseCase(LibraryRepository repo) {
        this.repo = repo;
    }

    public List<Book> execute() {
        return repo.getAllBooks();
    }
}
