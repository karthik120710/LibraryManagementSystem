import Controller.CommandDispatcher;
import Entity.*;
import Service.LibraryManagementService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize library with sample data
        Library library = initializeLibrary();
        LibraryManagementService service = new LibraryManagementService(library);
        CommandDispatcher dispatcher = new CommandDispatcher(service);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== Welcome to Library Management System ===");
        System.out.println("Type 'HELP' to see available commands or 'EXIT' to quit");
        
        String input;
        while ((input = reader.readLine()) != null) {
            if (input.equalsIgnoreCase("EXIT")) {
                System.out.println("Thank you for using Library Management System!");
                break;
            }
            dispatcher.process(input);
        }
        
        reader.close();
    }
    
    private static Library initializeLibrary() {
        // Initialize with sample librarians
        Librarian librarian1 = new Librarian("John Doe", "LIB001");
        librarian1.setPersonalId("EMP001");
        
        // Initialize with sample members
        Member member1 = new Member("Alice Smith", "MEM001");
        Member member2 = new Member("Bob Johnson", "MEM002");
        
        // Initialize with sample books
        Book book1 = new Book("Java Programming", "James Gosling", "BOOK001");
        Book book2 = new Book("Clean Code", "Robert Martin", "BOOK002");
        Book book3 = new Book("Design Patterns", "Gang of Four", "BOOK003");
        
        return new Library(
            new ArrayList<>(Arrays.asList(book1, book2, book3)),
            new ArrayList<>(Arrays.asList(member1, member2)),
            new ArrayList<>(Arrays.asList(librarian1))
        );
    }
}