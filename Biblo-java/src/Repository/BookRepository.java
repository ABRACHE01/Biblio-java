package Repository;

import Domain.Book;
import Domain.MyJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> addBook(Book book) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO book (isbn, title, quantity, author) VALUES (?, ?, ?, ?)");
            statement.setInt(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setInt(3, book.getCountity());
            statement.setString(4, book.getAuthor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getAllBooks();
    }

    public void updateBook(Book book) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE book SET title = ?, quantity = ?, author = ? WHERE isbn = ?");
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getCountity());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getIsbn());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int isbn) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM book WHERE isbn = ?");
            statement.setInt(1, isbn);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = MyJDBC.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

            while (resultSet.next()) {
                int isbn = resultSet.getInt("isbn");
                String title = resultSet.getString("title");
                int quantity = resultSet.getInt("quantity");
                String author = resultSet.getString("author");

                Book book = new Book(isbn, title, quantity, author);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

}
