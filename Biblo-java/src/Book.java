
import java.util.ArrayList;
public class Book {
    private int isbn;
    private String title;
    private int countity ;
    private Author author;
    private ArrayList<BookCopy> bookCopy;
    public Book(){

    }
    public Book(int isbn , String title , int countity ){
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setCountity(countity);
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountity() {
        return countity;
    }

    public void setCountity(int countity) {
        this.countity = countity;
    }


    public ArrayList<BookCopy> getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(ArrayList<BookCopy> bookCopy) {
        this.bookCopy = bookCopy;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}