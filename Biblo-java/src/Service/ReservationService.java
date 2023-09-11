package Service;
import Domain.Enum.Status;
import Domain.Reservation;
import Repository.ReservationRepository;

import java.util.List;

public class ReservationService {
    private static ReservationRepository reservationRepository;

    public ReservationService() {
        this.reservationRepository = new ReservationRepository();
    }

    public static List<Reservation> getAllReservation() {
        return  ReservationRepository.getAllReservations();
    }

    public static boolean bookExists(int reserIsbn) {
     return    reservationRepository.bookExists(reserIsbn);
    }

    public static int getBookCountByStatus(Status status) {
        reservationRepository.getBookCountByStatus(status);
        return 0;
    }


    public void addReservation(Reservation reservation) {
        reservationRepository.addReservation(reservation);
    }


    public void returnBook(int returnIsbn, int returnMemberNumber) {
        Reservation reservation = reservationRepository.getReservation(returnIsbn, returnMemberNumber);
        if (reservation != null) {
            reservation.setStatus(Status.AVAILABLE);
            reservationRepository.updateReservation(reservation);
        }
    }
}