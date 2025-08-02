package Controller;

import Entity.Book;
import Service.LibraryManagementService;

public class SearchBookCommand implements CommandHandler {
    private final LibraryManagementService service;

    public SearchBookCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: SEARCH_BOOK <title>");
            return;
        }

        // Join all arguments after the command to handle multi-word titles
        StringBuilder titleBuilder = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            if (i > 1) titleBuilder.append(" ");
            titleBuilder.append(args[i]);
        }
        String title = titleBuilder.toString();
        Book book = service.searchBook(title);

        if (book != null) {
            String status = book.getMember() != null ? 
                "Borrowed by " + book.getMember().getName() : "Available";
            System.out.println("Book found:");
            System.out.println("ID: " + book.getBookId() + ", Title: " + book.getTitle() + 
                             ", Author: " + book.getAuthor() + ", Status: " + status);
        } else {
            System.out.println("Book with title '" + title + "' not found");
        }
    }
}