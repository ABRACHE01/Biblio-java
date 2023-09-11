package Controller;
import Domain.Book;
import Domain.Client;
import Domain.Enum.Status;
import Domain.Reservation;
import Service.ReservationService;
import java.sql.Date;
import java.util.List;


public class ReservationController {
    private ReservationService reservationService;

    public ReservationController() {
        this.reservationService = new ReservationService();
    }

    public void addReservation(int isbn, Status status , Client client, Date dateOfBorrowing, Date dateOfReturn) {
        Reservation reservation = new Reservation(isbn, status , client, dateOfBorrowing, dateOfReturn);
        reservationService.addReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        return ReservationService.getAllReservation();
    }


    public boolean bookExists(int reserIsbn) {
        return ReservationService.bookExists(reserIsbn);
    }

    public void returnBook(int returnIsbn, int returnMemberNumber) {
        reservationService.returnBook(returnIsbn, returnMemberNumber);
    }
}
