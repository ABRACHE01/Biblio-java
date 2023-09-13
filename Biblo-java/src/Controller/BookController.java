package Controller;

import Domain.Book;
import Domain.Enum.Status;
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

    public List<Book> searchBooks(String key) {
       return  bookService.searchBooks(key);
    }
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public boolean updateBook(int isbn, String title, int quantity, String author) {
        Book book = new Book(isbn, title, quantity, author);
        bookService.updateBook(book);
        return false;
    }

    public void deleteBook(int isbn) {
        bookService.deleteBook(isbn);
    }

    public int getBookCountByStatus(Status status) {
        return  bookService.getBookCountByStatus(status);
        
    }
}