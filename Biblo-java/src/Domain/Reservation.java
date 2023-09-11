package Domain;

import java.sql.Date;

public class Reservation {


        private int isbn;
        private Date date_of_borrowing;
        private Date date_of_return;
        private Client client;
        private BookCopy bookCopy;

        public Reservation() {
        }

        public Reservation(   int isbn, BookCopy bookCopy, Client client, Date dateOfBorrowing, Date dateOfReturn) {

            this.setIsbn(isbn);
            this.setBookCopy(bookCopy);
            this.setClient(client);
            this.setDate_of_borrowing(dateOfBorrowing);
            this.setDate_of_return(dateOfReturn);
        }


    @Override
        public String toString() {
            return "Reservation{" +
                    ", isbn='" + getIsbn()  +
                    ", date_of_borrowing=" + getDate_of_borrowing() +
                    ", date_of_return=" + getDate_of_return() +
                    ", client=" + getClient().getClient_name() +
                    '}';
        }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Date getDate_of_borrowing() {
        return date_of_borrowing;
    }

    public void setDate_of_borrowing(Date date_of_borrowing) {
        this.date_of_borrowing = date_of_borrowing;
    }

    public Date getDate_of_return() {
        return date_of_return;
    }

    public void setDate_of_return(Date date_of_return) {
        this.date_of_return = date_of_return;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
}