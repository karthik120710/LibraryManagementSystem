package Controller;

import Entity.Member;
import Service.LibraryManagementService;

public class RemoveMemberCommand implements CommandHandler {
    private final LibraryManagementService service;

    public RemoveMemberCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: REMOVE_MEMBER <member_id>");
            return;
        }

        String memberId = args[1];
        Member member = service.findMemberById(memberId);

        if (member == null) {
            System.out.println("Error: Member with ID " + memberId + " not found");
            return;
        }

        boolean success = service.removeMember(member);
        if (success) {
            System.out.println("Member with ID " + memberId + " removed successfully");
        } else {
            System.out.println("Failed to remove member. Member might have borrowed books.");
        }
    }
}