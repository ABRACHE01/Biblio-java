package Domain;

public class Client {

    private int member_number;
    private int cin;
    private String client_name;

    public Client() {
    }

    public Client(int member_number, int cin, String client_name) {
        setMemberNumber(member_number);
        setCin(cin);
        setClientName(client_name);
    }

    public int getMemberNumber() {
        return member_number;
    }

    public void setMemberNumber(int member_number) {
        if (member_number <= 0) {
            throw new IllegalArgumentException("Member number must be a positive integer.");
        }
        this.member_number = member_number;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        if (cin <= 0) {
            throw new IllegalArgumentException("CIN must be a positive integer.");
        }
        this.cin = cin;
    }

    public String getClientName() {
        return client_name;
    }

    public void setClientName(String client_name) {
        if (client_name == null || client_name.isEmpty()) {
            throw new IllegalArgumentException("Client name must not be null or empty.");
        }
        this.client_name = client_name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "member_number=" + member_number +
                ", cin=" + cin +
                ", client_name='" + client_name + '\'' +
                '}';
    }
}
