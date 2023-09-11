package Domain;

import Domain.Enum.Status;


public class BookCopy {

    private int id;
    private int bookIsbn;
    private Status status ;
    private Book book ;



    public BookCopy(){

    }

    public BookCopy(int bookIsbn, Status status, Book book) {
        this.bookIsbn = bookIsbn;
        this.status = status;
        this.book = book;
    }


    //Status
    public Status getStatus(){
        return status ;
    }
    public void setStatus(Status newStatus){
        this.status = newStatus ;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "bookisbn=" + bookIsbn +
                ", status=" + status +
                ", book=" + book.getTitle() +
                '}';
    }

    public int getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(int bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
