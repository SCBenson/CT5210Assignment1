package entities;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private Boolean available; // should not be final, as the availability of the book will change.

    public Book(String id, String title, String author, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{ id='" + id + "', title='" + title + "', author='" + author + "', available=" + available + "}";
    }
}