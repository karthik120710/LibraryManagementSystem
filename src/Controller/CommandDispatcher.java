package Controller;

import Service.LibraryManagementService;
import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {
    private final Map<String, CommandHandler> commandMap;
    private final LibraryManagementService service;

    public CommandDispatcher(LibraryManagementService service) {
        this.service = service;
        this.commandMap = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commandMap.put("ADD_BOOK", new AddBookCommand(service));
        commandMap.put("REMOVE_BOOK", new RemoveBookCommand(service));
        commandMap.put("BORROW_BOOK", new BorrowBookCommand(service));
        commandMap.put("RETURN_BOOK", new ReturnBookCommand(service));
        commandMap.put("ADD_MEMBER", new AddMemberCommand(service));
        commandMap.put("REMOVE_MEMBER", new RemoveMemberCommand(service));
        commandMap.put("SEARCH_BOOK", new SearchBookCommand(service));
        commandMap.put("HELP", new HelpCommand(service));
    }

    public void process(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Invalid input. Type 'HELP' for available commands.");
            return;
        }

        String[] parts = input.trim().split("\\s+");
        String command = parts[0].toUpperCase();

        CommandHandler handler = commandMap.get(command);
        if (handler != null) {
            try {
                handler.execute(parts);
            } catch (Exception e) {
                System.out.println("Error executing command: " + e.getMessage());
            }
        } else {
            System.out.println("Unknown command: " + command + ". Type 'HELP' for available commands.");
        }
    }
}