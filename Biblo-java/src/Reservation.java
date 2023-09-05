import java.util.ArrayList;

public class Reservation {
    private int copy_id ;
    private String isbn ;
    private ArrayList<BookCopy> book_copy;
    private ArrayList<Client> client;
    private int date_of_borrowing ;
    private int date_of_return ;


    public Reservation(int copyId, String isbn, ArrayList<BookCopy> bookCopy, ArrayList<Client> clients, int dateOfBorrowing, int dateOfReturn) {
        this.copy_id = copyId;
        this.isbn = isbn;
        this.book_copy = bookCopy;
        this.client = clients;
        this.date_of_borrowing = dateOfBorrowing;
        this.date_of_return = dateOfReturn;
    }

    public int getCopy_id() {
        return copy_id;
    }

    public void setCopy_id(int copy_id) {
        this.copy_id = copy_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<BookCopy> getBook_copy() {
        return book_copy;
    }

    public void setBook_copy(ArrayList<BookCopy> book_copy) {
        this.book_copy = book_copy;
    }

    public ArrayList<Client> getClient() {
        return client;
    }

    public void setClient(ArrayList<Client> client) {
        client = client;
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
}
