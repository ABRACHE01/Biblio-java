package Domain;

public class Book {
    private int isbn;
    private String title;
    private int countity ;
    private String author;
    public Book(){

    }
    public Book(int isbn , String title , int countity , String author ){
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setCountity(countity);
        this.setAuthor(author);
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




    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", countity=" + countity +
                ", author =" + author +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}