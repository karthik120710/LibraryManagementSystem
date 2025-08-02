package Controller;

import Entity.Book;
import Entity.Librarian;
import Service.LibraryManagementService;

public class AddBookCommand implements CommandHandler {
    private final LibraryManagementService service;
    public AddBookCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 5) {
            System.out.println("Usage: ADD_BOOK <book_id> \"<title>\" \"<author>\" <librarian_id>");
            System.out.println("Example: ADD_BOOK BOOK004 \"Clean Architecture\" \"Robert Martin\" LIB001");
            return;
        }

        String bookId = args[1];
        // For simplicity, assume title and author are single arguments
        // In a real application, you might want to use quotes parsing
        String title = args[2];
        String author = args[3];
        String librarianId = args[4];

        Book book = new Book(title, author, bookId);
        Librarian librarian = service.findLibrarianById(librarianId);

        if (librarian == null) {
            System.out.println("Error: Librarian with ID " + librarianId + " not found");
            return;
        }

        boolean success = service.addBook(book, librarian);
        if (success) {
            System.out.println("Book '" + title + "' added successfully with ID: " + bookId);
        } else {
            System.out.println("Failed to add book. Book with ID " + bookId + " might already exist or librarian not authorized.");
        }
    }
}