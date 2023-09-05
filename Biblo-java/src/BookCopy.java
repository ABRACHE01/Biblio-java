import java.util.ArrayList;
public class BookCopy {
    private int id;
    private ArrayList<Book> book;
    private Status status ;

    public BookCopy(int id, ArrayList<Book> book , Status status ) {
        this.id = id;
        this.book = book;
        this.status = status;
    }
    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //book
    public ArrayList<Book> getBook() {
        return book;
    }
    public void setBook(ArrayList<Book> book) {
        this.book = book;
    }

    //Status
    public Status getStatus(){
        return status ;
    }
    public void setStatus(Status newStatus){
        this.status = newStatus ;
    }


}
