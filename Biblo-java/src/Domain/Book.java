package Domain;

import Domain.Enum.Status;

public class Book {
    private int isbn;
    private String title;
    private int quantity;
    private Status status;
    private String author;

    public Book() {
    }

    public Book(int isbn, String title, int quantity, String author) {
        setIsbn(isbn);
        setTitle(title);
        setQuantity(quantity);
        setAuthor(author);
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {

        if (isbn <= 0  ) {
            throw new IllegalArgumentException("ISBN must be a positive integer.");
        }
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty.");
        }
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be a non-negative integer.");
        }
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author must not be null or empty.");
        }
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", author='" + author + '\'' +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}