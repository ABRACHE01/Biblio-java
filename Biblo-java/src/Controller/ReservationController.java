package Controller;
import Domain.BookCopy;
import Domain.Client;
import Domain.Reservation;
import Service.ReservationService;
import java.sql.Date;


public class ReservationController {
    private ReservationService reservationService;

    public ReservationController() {
        this.reservationService = new ReservationService();
    }

    public void addReservation(int isbn, BookCopy bookCopy, Client client, Date dateOfBorrowing, Date dateOfReturn) {
        Reservation reservation = new Reservation(isbn, bookCopy, client, dateOfBorrowing, dateOfReturn);
        reservationService.addReservation(reservation);
    }

}
