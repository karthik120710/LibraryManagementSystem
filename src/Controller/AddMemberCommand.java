package Controller;

import Entity.Member;
import Service.LibraryManagementService;

public class AddMemberCommand implements CommandHandler {
    private final LibraryManagementService service;

    public AddMemberCommand(LibraryManagementService service) {
        this.service = service;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: ADD_MEMBER <member_id> <name>");
            return;
        }

        String memberId = args[1];
        // Join all arguments after member_id to handle multi-word names
        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 2; i < args.length; i++) {
            if (i > 2) nameBuilder.append(" ");
            nameBuilder.append(args[i]);
        }
        String name = nameBuilder.toString();

        Member member = new Member(name, memberId);
        boolean success = service.addMember(member);
        
        if (success) {
            System.out.println("Member '" + name + "' added successfully with ID: " + memberId);
        } else {
            System.out.println("Failed to add member. Member with ID " + memberId + " might already exist.");
        }
    }
}