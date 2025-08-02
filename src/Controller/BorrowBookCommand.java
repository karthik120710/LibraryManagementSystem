package Controller;

import Entity.Member;
import Service.LibraryManagementService;

public class BorrowBookCommand implements CommandHandler {
    private final LibraryManagementService service;

    public BorrowBookCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: BORROW_BOOK <member_id> <book_id>");
            return;
        }

        String memberId = args[1];
        String bookId = args[2];

        Member member = service.findMemberById(memberId);
        if (member == null) {
            System.out.println("Error: Member with ID " + memberId + " not found");
            return;
        }

        boolean success = service.borrowBook(member, bookId);
        if (success) {
            System.out.println("Book with ID " + bookId + " borrowed successfully by " + member.getName());
        } else {
            System.out.println("Failed to borrow book. Book might not exist or is already borrowed.");
        }
    }
}