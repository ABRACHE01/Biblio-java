import java.util.ArrayList;
public class Client {
    private int member_number ;
    private String client_name ;
    private ArrayList<Reservation> reservations;

    public Client(){

    }

    public Client(int member_number , String client_name ){
        this.member_number = member_number ;
        this.client_name = client_name ;
    }

    public int getMember_number() {
        return member_number;
    }

    public void setMember_number(int member_number) {
        this.member_number = member_number;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
