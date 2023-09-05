import java.util.ArrayList;

public class Book {
    private int isbn;
    private String title;
    private int countity ;
    private ArrayList<Author> author;

    public Book(int isbn , String title , int countity , ArrayList<Author> author){

        this.isbn =  isbn ;
        this.title =  title ;
        this.countity = countity ;
    }

    //ISBN getter and setter
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int newIsbn) {
        this.isbn = newIsbn;
    }

    //title getter and setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    //Countity getter and setter
    public int getCountity() {
        return countity;
    }
    public void setCountity(int newCountity) {
        this.countity = newCountity;
    }

    //Author
    public ArrayList<Author> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }


}