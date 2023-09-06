package Domain;

 public class Reservation {
        private int id;
        private int isbn;
        private int date_of_borrowing;
        private int date_of_return;
        private Client client;
        private BookCopy bookCopy;

        public Reservation() {
        }

        public Reservation(int id, int isbn, BookCopy bookCopy, Client client, int dateOfBorrowing, int dateOfReturn) {
            this.setId(id);
            this.setIsbn(isbn);
            this.setBookCopy(bookCopy);
            this.setClient(client);
            this.setDate_of_borrowing(dateOfBorrowing);
            this.setDate_of_return(dateOfReturn);
        }


        @Override
        public String toString() {
            return "Reservation{" +
                    "id=" + getId() +
                    ", isbn='" + getIsbn() + '\'' +
                    ", date_of_borrowing=" + getDate_of_borrowing() +
                    ", date_of_return=" + getDate_of_return() +
                    ", client=" + getClient().getClient_name() +
                    ", bookCopy=" + getBookCopy().getId() +
                    '}';
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public BookCopy getBookCopy() {
            return bookCopy;
        }

        public void setBookCopy(BookCopy bookCopy) {
            this.bookCopy = bookCopy;
        }

     public int getIsbn() {
         return isbn;
     }

     public void setIsbn(int isbn) {
         this.isbn = isbn;
     }
 }