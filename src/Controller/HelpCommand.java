package Controller;

import Service.LibraryManagementService;

public class HelpCommand implements CommandHandler {
    private final LibraryManagementService service;

    public HelpCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("=== Library Management System Commands ===");
        System.out.println("ADD_BOOK <book_id> <title> <author> <librarian_id> - Add a new book");
        System.out.println("REMOVE_BOOK <book_id> <librarian_id> - Remove a book");
        System.out.println("BORROW_BOOK <member_id> <book_id> - Borrow a book");
        System.out.println("RETURN_BOOK <member_id> <book_id> - Return a book");
        System.out.println("ADD_MEMBER <member_id> <name> - Add a new member");
        System.out.println("REMOVE_MEMBER <member_id> - Remove a member");
        System.out.println("SEARCH_BOOK <title> - Search for a book by title");
        System.out.println("HELP - Show this help message");
        System.out.println("EXIT - Exit the application");
        System.out.println("==========================================");
    }
}