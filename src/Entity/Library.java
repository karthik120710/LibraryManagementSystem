package Entity;

import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Librarian> librarians;

    public Library(List<Book> books, List<Member> members, List<Librarian> librarians) {
        this.books = books;
        this.members = members;
        this.librarians = librarians;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }
}
