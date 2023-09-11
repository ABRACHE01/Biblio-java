package Service;
import Domain.Reservation;
import Repository.ReservationRepository;

public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService() {
        this.reservationRepository = new ReservationRepository();
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.addReservation(reservation);
    }
}