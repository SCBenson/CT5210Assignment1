package entities;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final String isbn;
    private int copies;

    public Book(String id, String title, String author, String isbn, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
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

    @Override
    public String toString() {
        return "Book{ id='" + id + "', title='" + title + "', author='" + author + "', isbn='" + isbn + "', copies='"
                + copies + "'}";
    }
}