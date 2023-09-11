package Service;

import Domain.Book;
import Repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public void deleteBook(int isbn) {
        bookRepository.deleteBook(isbn);
    }

    public List<Book> searchBooks(String key) {
        return bookRepository.searchBooks(key);
    }
}
