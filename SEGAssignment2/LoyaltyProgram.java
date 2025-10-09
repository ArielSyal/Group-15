import java.util.*;

public class LoyaltyProgram {
    private int pointsBalance;
    private String tierLevel;
    private List<Client> clients;

    public LoyaltyProgram(int pointsBalance, String tierLevel) {
        this.pointsBalance = pointsBalance;
        this.tierLevel = tierLevel;
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        if (client == null) {
            System.out.println("cannot add null client");
            return;
        }
        if (clients.contains(client)) {
            System.out.println("client already enrolled in loyalty program");
            return;
        }
        clients.add(client);
        System.out.println("client added to loyalty program");
    }

    public void removeClient(Client client) {
        if (client == null || !clients.contains(client)) {
            System.out.println("client not found in loyalty program");
            return;
        }
        clients.remove(client);
        System.out.println("client removed from loyalty program");
    }

    public void addPoints(Client client, int points) {
        if (client == null || !clients.contains(client)) {
            System.out.println("client not found in loyalty program");
            return;
        }
        if (points <= 0) {
            System.out.println("points must be positive");
            return;
        }
        this.pointsBalance += points;
        System.out.println("added " + points + " points to " + client.getName() + ". points balance: " + pointsBalance);
    }

    public void redeemPoints(Client client, int points) {
        if (client == null || !clients.contains(client)) {
            System.out.println("client not found in loyalty program");
            return;
        }
        if (points <= 0) {
            System.out.println("points to redeem must be positive");
            return;
        }
        if (this.pointsBalance < points) {
            System.out.println("insufficient points: " + pointsBalance + ", Requested: " + points);
            return;
        }
        this.pointsBalance -= points;
        System.out.println("redeemed " + points + " points for " + client.getName() + ". points balance: " + pointsBalance);
    }

    public int getPoints(Client client) {
        if (client == null || !clients.contains(client)) {
            System.out.println("client not found in loyalty program");
            return -1;
        }
        return this.pointsBalance; 
    }

    public void listClients() {
        if (clients.isEmpty()) {
            System.out.println("no clients enrolled in loyalty program");
        } else {
            System.out.println("clients enrolled in loyalty program:");
            for (Client c : clients) {
                System.out.println(" - " + c.getName());
            }
        }
    }

    public int getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public String gettierLevel() {
        return tierLevel;
    }

    public void settierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }
}
