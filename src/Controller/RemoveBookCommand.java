package Controller;

import Entity.Book;
import Entity.Librarian;
import Service.LibraryManagementService;

public class RemoveBookCommand implements CommandHandler {
    private final LibraryManagementService service;

    public RemoveBookCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: REMOVE_BOOK <book_id> <librarian_id>");
            return;
        }

        String bookId = args[1];
        String librarianId = args[2];

        Book book = service.findBookById(bookId);
        Librarian librarian = service.findLibrarianById(librarianId);

        if (book == null) {
            System.out.println("Error: Book with ID " + bookId + " not found");
            return;
        }

        if (librarian == null) {
            System.out.println("Error: Librarian with ID " + librarianId + " not found");
            return;
        }

        boolean success = service.removeBook(book, librarian);
        if (success) {
            System.out.println("Book with ID " + bookId + " removed successfully");
        } else {
            System.out.println("Failed to remove book. It might be currently borrowed.");
        }
    }
}