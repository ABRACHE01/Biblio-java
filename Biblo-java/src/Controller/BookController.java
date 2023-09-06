package Controller;

import Domain.Book;
import Service.BookService;

import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public void addBook(int isbn, String title, int quantity, String author) {
        Book book = new Book(isbn, title, quantity, author);
        bookService.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public void updateBook(int isbn, String title, int quantity, String author) {
        Book book = new Book(isbn, title, quantity, author);
        bookService.updateBook(book);
    }

    public void deleteBook(int isbn) {
        bookService.deleteBook(isbn);
    }
}