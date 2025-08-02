package Entity;

public class Book {
    private String title,author;
    private String book_id;
    private Member member;

    public Book(String title, String author, String book_id) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (book_id == null || book_id.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be null or empty");
        }
        
        this.title = title.trim();
        this.author = author.trim();
        this.book_id = book_id.trim();
        this.member = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // The condition checks if the title is null, or if after removing leading/trailing whitespace (using trim()), the title is an empty string (isEmpty()).
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author.trim();
    }

    public String getBookId() {
        return book_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBookId(String book_id) {
        if (book_id == null || book_id.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be null or empty");
        }
        this.book_id = book_id.trim();
    }

    public void setBook_id(String book_id) {
        setBookId(book_id);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return book_id.equals(book.book_id);
    }

    @Override
    public int hashCode() {
        return book_id.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + book_id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + (member == null) +
                '}';
    }
}
