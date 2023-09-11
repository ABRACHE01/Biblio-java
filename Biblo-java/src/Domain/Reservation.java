package Domain;

import Domain.Enum.Status;

import java.sql.Date;

public class Reservation {
    private int isbn;
    private Date date_of_borrowing;
    private Date date_of_return;


    private Client client;

    private Status status ;

    private Book book ;

    public Reservation() {
    }

    public Reservation(int isbn, Status status, Client client, Date dateOfBorrowing, Date dateOfReturn) {
        this.isbn = isbn;
        this.date_of_borrowing = dateOfBorrowing;
        this.date_of_return = dateOfReturn;
        this.client = client;
        this.status = status;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "isbn='" + getIsbn() +
                ", date_of_borrowing=" + getDate_of_borrowing() +
                ", date_of_return=" + getDate_of_return() +
                ", client=" + getClient().getClientName() +
                '}';
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        if (isbn <= 0) {
            throw new IllegalArgumentException("ISBN must be a positive integer.");
        }
        this.isbn = isbn;
    }

    public Date getDate_of_borrowing() {
        return date_of_borrowing;
    }

    public void setDate_of_borrowing(Date date_of_borrowing) {
        if (date_of_borrowing == null) {
            throw new IllegalArgumentException("Date of borrowing must not be null.");
        }
        this.date_of_borrowing = date_of_borrowing;
    }

    public Date getDate_of_return() {
        return date_of_return;
    }

    public void setDate_of_return(Date date_of_return) {
        if (date_of_return == null) {
            throw new IllegalArgumentException("Date of return must not be null.");
        }
        if (date_of_return.before(date_of_borrowing)) {
            throw new IllegalArgumentException("Date of return must be after the date of borrowing.");
        }
        this.date_of_return = date_of_return;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client must not be null.");
        }
        this.client = client;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}