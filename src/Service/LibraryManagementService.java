package Service;
import Entity.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementService {
    private Library library;
    private List<Book> books;
    private List<Librarian> librarians;
    private List<Member> members;
    private Map<Book, Member> activeBorrowing;

    public LibraryManagementService(Library library) {
        this.library=library;
        this.activeBorrowing=new HashMap<>();
        this.books = library.getBooks();
        this.librarians = library.getLibrarians();
        this.members = library.getMembers();
        this.activeBorrowing = new HashMap<>();
    }

    // Search Methods
    public Book searchBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            return null;
        }
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }
        return null;
    }

    public Book findBookById(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            return null;
        }
        for (Book book : books) {
            if (book.getBookId().equals(bookId.trim())) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        if (memberId == null || memberId.trim().isEmpty()) {
            return null;
        }
        for (Member member : members) {
            if (member.getId().equals(memberId.trim())) {
                return member;
            }
        }
        return null;
    }

    public Librarian findLibrarianById(String librarianId) {
        if (librarianId == null || librarianId.trim().isEmpty()) {
            return null;
        }
        for (Librarian librarian : librarians) {
            if (librarian.getId().equals(librarianId.trim())) {
                return librarian;
            }
        }
        return null;
    }

    // Member Methods
    public boolean borrowBook(Member member, String bookId) {
        if (member == null || bookId == null || bookId.trim().isEmpty()) {
            return false;
        }
        
        Book book = findBookById(bookId.trim());
        if (book != null && book.getMember() == null) {
            book.setMember(member);
            activeBorrowing.put(book, member);
            return true;
        }
        return false;
    }

    public boolean returnBook(Member member, String bookId) {
        if (member == null || bookId == null || bookId.trim().isEmpty()) {
            return false;
        }
        
        Book book = findBookById(bookId.trim());
        if (book != null && book.getMember() != null && 
            book.getMember().getId().equals(member.getId())) {
            book.setMember(null);
            activeBorrowing.remove(book);
            return true;
        }
        return false;
    }

    // Librarian Operations
    public boolean addBook(Book book, Librarian librarian) {
        if (book == null || librarian == null) {
            return false;
        }
        
        if (librarians.contains(librarian) && findBookById(book.getBookId()) == null) {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book, Librarian librarian) {
        if (book == null || librarian == null) {
            return false;
        }
        
        if (librarians.contains(librarian) && books.contains(book) && book.getMember() == null) {
            books.remove(book);
            activeBorrowing.remove(book);
            return true;
        }
        return false;
    }

    public boolean addMember(Member member) {
        if (member == null || member.getId() == null || member.getName() == null) {
            return false;
        }
        
        if (findMemberById(member.getId()) == null) {
            members.add(member);
            return true;
        }
        return false;
    }

    public boolean removeMember(Member member) {
        if (member == null) {
            return false;
        }
        
        // Check if member has any borrowed books
        for (Book book : books) {
            if (book.getMember() != null && book.getMember().getId().equals(member.getId())) {
                return false; // Cannot remove member with borrowed books
            }
        }
        
        if (members.contains(member)) {
            members.remove(member);
            return true;
        }
        return false;
    }
}
