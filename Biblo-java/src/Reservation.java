import java.util.ArrayList;

public class Reservation {
    private int id ;
    private String isbn ;

    private int date_of_borrowing ;
    private int date_of_return ;
    private Client client ;
    private  BookCopy bookCopy ;
    public Reservation(){

    }
    public Reservation(int id, String isbn, ArrayList<BookCopy> bookCopy, ArrayList<Client> clients, int dateOfBorrowing, int dateOfReturn) {
        this.id = id;
        this.isbn = isbn;
        this.date_of_borrowing = dateOfBorrowing;
        this.date_of_return = dateOfReturn;
    }
    public int getCopy_id() {
        return id;
    }

    public void setCopy_id(int copy_id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getDate_of_borrowing() {
        return date_of_borrowing;
    }

    public void setDate_of_borrowing(int date_of_borrowing) {
        this.date_of_borrowing = date_of_borrowing;
    }

    public int getDate_of_return() {
        return date_of_return;
    }

    public void setDate_of_return(int date_of_return) {
        this.date_of_return = date_of_return;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
