package Repository;
import Domain.Client;
import Domain.Enum.Status;
import Domain.MyJDBC;
import Domain.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  ReservationRepository {


    public static void addReservation(Reservation reservation) {
        try (Connection connection = MyJDBC.getConnection()) {



            PreparedStatement clientStatement = connection.prepareStatement(
                    "INSERT INTO client (member_number, cin , client_name) VALUES (?, ? , ?)"
            );
            clientStatement.setInt(1, reservation.getClient().getMemberNumber());
            clientStatement.setString(2, String.valueOf(reservation.getClient().getCin()));
            clientStatement.setString(3, reservation.getClient().getClientName());
            clientStatement.executeUpdate();


            PreparedStatement reservationStatement = connection.prepareStatement(
                    "INSERT INTO reservation (  member_number, date_of_borrowing, date_of_return , book_isbn , status) " +
                            "VALUES ( ?, ?, ?,?,?)"
            );
            reservationStatement.setInt(1, reservation.getClient().getMemberNumber());
            reservationStatement.setDate(2, reservation.getDate_of_borrowing());
            reservationStatement.setDate(3, reservation.getDate_of_return());
            reservationStatement.setString(4, String.valueOf(reservation.getIsbn()));
            reservationStatement.setString(5, String.valueOf(reservation.getStatus()));

            reservationStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();

        try (Connection connection = MyJDBC.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reservation");

            while (resultSet.next()) {
                int isbn = resultSet.getInt("book_isbn");
                int memberNumber = resultSet.getInt("member_number");
                Date dateOfBorrowing = resultSet.getDate("date_of_borrowing");
                Date dateOfReturn = resultSet.getDate("date_of_return");
                String statusStr = resultSet.getString("status");
                Status status = Status.valueOf(statusStr.toUpperCase());

                Client client = getClientByMemberNumber(memberNumber);
                Reservation reservation = new Reservation(isbn, status, client, dateOfBorrowing, dateOfReturn);
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    private static Client getClientByMemberNumber(int memberNumber) {

        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM client WHERE member_number = ?");
            statement.setInt(1, memberNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int cin = resultSet.getInt("cin");
                String clientName = resultSet.getString("client_name");
                return new Client(memberNumber, cin, clientName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean bookExists(int isbn) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM book WHERE isbn = ?");
            statement.setInt(1, isbn);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public Reservation getReservation(int returnIsbn, int returnMemberNumber) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM reservation WHERE book_isbn = ? AND member_number = ?");
            statement.setInt(1, returnIsbn);
            statement.setInt(2, returnMemberNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int isbn = resultSet.getInt("book_isbn");
                int memberNumber = resultSet.getInt("member_number");
                Date dateOfBorrowing = resultSet.getDate("date_of_borrowing");
                Date dateOfReturn = resultSet.getDate("date_of_return");
                String statusStr = resultSet.getString("status");
                Status status = Status.valueOf(statusStr.toUpperCase());

                Client client = getClientByMemberNumber(memberNumber);
                return new Reservation(isbn, status, client, dateOfBorrowing, dateOfReturn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateReservation(Reservation reservation) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE reservation SET date_of_borrowing = ?, date_of_return = ?, status = ? WHERE book_isbn = ? AND member_number = ?"
            );
            statement.setDate(1, reservation.getDate_of_borrowing());
            statement.setDate(2, reservation.getDate_of_return());
            statement.setString(3, reservation.getStatus().name());
            statement.setInt(4, reservation.getIsbn());
            statement.setInt(5, reservation.getClient().getMemberNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBookCountByStatus(Status status) {
        try (Connection connection = MyJDBC.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM reservation WHERE status = ?"
            );
            statement.setString(1, status.name());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Count of " + status.name() + " books: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

