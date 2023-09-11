package Repository;
import Domain.MyJDBC;
import Domain.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class  ReservationRepository {


    public static void addReservation(Reservation reservation) {
        try (Connection connection = MyJDBC.getConnection()) {

            PreparedStatement bookCopyStatement = connection.prepareStatement(
                    "INSERT INTO bookcopy ( id ,status, isbn ) VALUES (?,?, ?)"
            );
            bookCopyStatement.setInt(1,reservation.getBookCopy().getId());
            bookCopyStatement.setString(2, String.valueOf(reservation.getBookCopy().getStatus()));
            bookCopyStatement.setInt(3, reservation.getBookCopy().getBookIsbn());
            bookCopyStatement.executeUpdate();


            PreparedStatement clientStatement = connection.prepareStatement(
                    "INSERT INTO client (member_number, cin , client_name) VALUES (?, ? , ?)"
            );
            clientStatement.setInt(1, reservation.getClient().getMember_number());
            clientStatement.setString(2, String.valueOf(reservation.getClient().getCin()));
            clientStatement.setString(3, reservation.getClient().getClient_name());
            clientStatement.executeUpdate();


            PreparedStatement reservationStatement = connection.prepareStatement(
                    "INSERT INTO reservation (  member_number, date_of_borrowing, date_of_return , copy_id) " +
                            "VALUES ( ?, ?, ?,?)"
            );
            reservationStatement.setInt(1, reservation.getClient().getMember_number());
            reservationStatement.setDate(2, reservation.getDate_of_borrowing());
            reservationStatement.setDate(3, reservation.getDate_of_return());
            reservationStatement.setInt(4, reservation.getBookCopy().getId());
            reservationStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
