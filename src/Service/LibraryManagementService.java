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

    // Search Method
    public Book searchBook(String title){
        for(Book book:books){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    // Memeber Method
    public boolean borrowBook(Member member, String bookId){
        for(Book book:books){
            if(book.getBook_id().equals(bookId) && book.getMember()==null){
                book.setMember(member);
                activeBorrowing.put(book,member);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(Member member, String bookId){
        Book returnBook=null;
        for(Book book:books){
            if(book.getBook_id()==bookId){
                returnBook=book;
            }
        }
        if(returnBook != null && returnBook.getMember() != null){
            returnBook.setMember(null);
            activeBorrowing.remove(returnBook);
            return true;
        }
        return false;
    }

    //Librarian operation

    public boolean addBook(Book book,Librarian librarian){
        if(librarians.contains(librarian) && !books.contains(book)){
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book,Librarian librarian){
        if(librarians.contains(librarian) && books.contains(book)){
            books.remove(book);
            return true;
        }
        return false;
    }

    public boolean addMember(Member member){
        if(!members.contains(member)){
            members.add(member);
            return true;
        }
        return false;
    }

    public boolean removeMember(Member member){
        if (members.contains(member)){
            members.remove(member);
            return  true;
        }

        return false;
    }
}
