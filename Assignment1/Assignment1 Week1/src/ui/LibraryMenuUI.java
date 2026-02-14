package ui;

import entities.Book;
import entities.BorrowRecord;
import controller.LibraryController;
import java.util.Scanner;
import java.util.List;

public class LibraryMenuUI {
    private final LibraryController controller;
    private final Scanner scanner;
    private boolean running;

    public LibraryMenuUI(LibraryController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void start() {
        System.out.println("===============Library Repository Application===============");

        while (running) {
            displayMenu();
            int choice = getUserChoice();
            handleMenuChoice(choice);
        }

        scanner.close();
        System.out.println("Thank you for using the Library Repository Application!");
    }

    private void displayMenu() {
        System.out.println("===============Main Menu===============");
        System.out.println("1) Add a Book");
        System.out.println("2) Register a Member");
        System.out.println("3) Borrow a Book");
        System.out.println("4) Return a Book");
        System.out.println("5) List All Books");
        System.out.println("6) Search Books by Title");
        System.out.println("7) Search Books by Author");
        System.out.println("8) View Available Books Only");
        System.out.println("9) Find Book by ISBN");
        System.out.println("10) View All Borrow Records");
        System.out.println("11) Exit");
        System.out.println("Please select an option from above.");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> handleAddBook();
            case 2 -> handleRegisterMember();
            case 3 -> handleBorrowBook();
            case 4 -> handleReturnBook();
            case 5 -> handleListBooks();
            case 6 -> handleSearchByTitle();
            case 7 -> handleSearchByAuthor();
            case 8 -> handleListAvailableBooks();
            case 9 -> handleSearchByISBN();
            case 10 -> handleListAllBorrowRecords();
            case 11 -> handleExit();
            default -> System.out.println("Invalid option. Please choose an option 1-6.");
        }
    }

    private void handleAddBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter author: ");
        String author = scanner.nextLine().trim();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();

        System.out.print("Enter number of copies: ");
        int copies = scanner.nextInt();
        try {
            // int copies = Integer.parseInt(scanner.nextLine().trim());
            controller.addBook(title, author, isbn, copies);
            System.out.println("Book added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of copies. Make sure it is a non-zero whole number.");
        }
    }

    private void handleRegisterMember() {
        System.out.println("\n--- Register New Member ---");
        System.out.print("Enter member name: ");
        String name = scanner.nextLine().trim();

        System.out.println("Enter member ID: ");
        String memberId = scanner.nextLine().trim();

        controller.registerMember(name, memberId);
        System.out.println("Member registered successfully!");

    }

    private void handleBorrowBook() {
        System.out.println("\n--- Borrow a Book ---");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();

        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine().trim();

        if (controller.borrowBook(memberId, bookId)) {
            System.out.println("Book borrowed Successful!");
        } else {
            System.out.println("Unable to borrow book. Please check member ID and book availability.");
        }
    }

    private void handleReturnBook() {
        System.out.println("\n--- Return a Book ---");
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();

        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine().trim();

        if (controller.returnBook(memberId, bookId)) {
            System.out.println("Book has been returned successfully!");
        } else {
            System.out.println("Unable to return your book. Please check your member ID and book ID.");
        }
    }

    private void handleListBooks() {
        System.out.println("\n--- All Books ---");
        List<Book> books = controller.listAllBooks();

        if (books.isEmpty()) {
            System.out.println("There are currently no books available in the library. Please try again later!");
        } else {
            System.out.printf("%-20s %-20s %-15s %-10s%n", "Title", "Author", "ISBN", "Available");
            System.out.print("-".repeat(70));
            for (Book book : books) {
                System.out.printf("%-20s %-20s %-15s %-10s%n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getIsbn(),
                        book.getAvailableCopies());
            }
        }
    }

    private void handleSearchByTitle() {
        System.out.println("\n--- Search Book by Title ---");
        System.out.print("Enter title: ");
        String title = scanner.nextLine().trim();

        List<Book> books = controller.searchBooksByTitle(title);

        if (books.isEmpty()) {
            System.out.println("No books found with title containing: " + title);
        } else {
            System.out.printf("%-20s %-20s %-15s %-10s%n", "Title", "Author", "ISBN", "Available");
            System.out.print("-".repeat(70));
            for (Book book : books) {
                System.out.printf("%-20s %-20s %-15s %-10s%n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getIsbn(),
                        book.getAvailableCopies());
            }
        }
    }

    private void handleSearchByAuthor() {
        System.out.println("\n--- Search Book by Author ---");
        System.out.print("Enter author: ");
        String author = scanner.nextLine().trim();

        List<Book> books = controller.searchBooksByTitle(author);

        if (books.isEmpty()) {
            System.out.println("No books found with author containing: " + author);
        } else {
            System.out.printf("%-20s %-20s %-15s %-10s%n", "Title", "Author", "ISBN", "Available");
            System.out.print("-".repeat(70));
            for (Book book : books) {
                System.out.printf("%-20s %-20s %-15s %-10s%n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getIsbn(),
                        book.getAvailableCopies());
            }
        }
    }

    private void handleListAvailableBooks() {
        System.out.println("\n--- List of Available Books ---");

    }

    private void handleSearchByISBN() {
        System.out.println("\n--- Search Book by ISBN ---");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();

        List<Book> books = controller.searchBooksByTitle(isbn);

        if (books.isEmpty()) {
            System.out.println("No books found with ISBN: " + isbn);
        } else {
            System.out.printf("%-20s %-20s %-15s %-10s%n", "Title", "Author", "ISBN", "Available");
            System.out.print("-".repeat(70));
            for (Book book : books) {
                System.out.printf("%-20s %-20s %-15s %-10s%n",
                        book.getTitle(),
                        book.getAuthor(),
                        book.getIsbn(),
                        book.getAvailableCopies());
            }
        }
    }

    private void handleListAllBorrowRecords() {
        System.out.println("\n--- All Borrow Records ---");
        List<BorrowRecord> records = controller.listBorrowRecord();

        if (records.isEmpty()) {
            System.out.println("No borrow records found in the system.");
        } else {
            System.out.printf("%-20s %-20s %-15s %-10s%n", "Title", "Author", "ISBN", "Available");
            System.out.print("-".repeat(70));
            for (BorrowRecord record : records) {
                System.out.printf("%-20s %-20s %-15s %-10s%n",
                        record.getMemberId(),
                        record.getBookId(),
                        record.getBorrowDate(),
                        record.getReturnDate() != null ? record.getReturnDate().toString() : "Not Returned");
            }
        }

    }

    private void handleExit() {
        running = false;
    }
    // introduce user to the library
    // provide a selection 1 through X of options to choose from
    // 1) Add a book
    // 2) Loan a book
    // i) list out available books
    // //user selects from list.
    // //update inmemorylibraryrepository.
    // 3) Check availability of a book
    // i) search by book id
    // ii) search by title
    // Scan for the input and send the choice to the controller.
}
