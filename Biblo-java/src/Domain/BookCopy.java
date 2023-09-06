package Domain;

import Domain.Enum.Status;

import java.util.ArrayList;

public class BookCopy {
    private int id;
    private Status status ;

    private Book book ;



    public BookCopy(){

    }
    public BookCopy(int id , Status status ) {
        this.id = id;
        this.status = status;
    }
    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", status=" + status +
                ", book=" + book.getTitle() +
                '}';
    }
}