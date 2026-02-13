package entities;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final String isbn;
    private int copies;
    private Boolean available; // should not be final, as the availability of the book will change.

    public Book(String id, String title, String author, String isbn, int copies, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return copies;
    }

    public boolean isAvailable() {
        return available; // need to refactor to check if copies is non-zero and flip availability if not.
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{ id='" + id + "', title='" + title + "', author='" + author + "', available=" + available + "}";
    }
}