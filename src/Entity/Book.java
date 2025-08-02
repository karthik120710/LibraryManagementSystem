package Entity;

public class Book {
    private String title,author;
    private String book_id;
    private Member member;

    public Book(String title, String author, String book_id) {
        this.title = title;
        this.author = author;
        this.book_id = book_id;
        this.member=null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
