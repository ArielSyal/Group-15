import java.util.*;

public class LoyaltyProgram {
    private int pointsBalance;
    private String level;
    private List<Client> clients;

    public LoyaltyProgram(int pointsBalance, String level) {
        this.pointsBalance = pointsBalance;
        this.level = level;
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        if (client == null) {
            System.out.println("Cannot add null client.");
            return;
        }
        if (clients.contains(client)) {
            System.out.println("Client already enrolled in loyalty program.");
            return;
        }
        clients.add(client);
        System.out.println("Client added to loyalty program.");
    }

    public void removeClient(Client client) {
        if (client == null || !clients.contains(client)) {
            System.out.println("Client not found in loyalty program.");
            return;
        }
        clients.remove(client);
        System.out.println("Client removed from loyalty program.");
    }

    public void updateTier(Client client, int points) {
        if (client == null || !clients.contains(client)) {
            System.out.println("Client not found in loyalty program.");
            return;
        }
        this.pointsBalance += points;
        System.out.println("Updated points for " + client.getName() + ". New balance: " + pointsBalance);
    }

    public void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients enrolled in loyalty program.");
        } else {
            System.out.println("Clients enrolled in loyalty program:");
            for (Client c : clients) {
                System.out.println(" - " + c.getName());
            }
        }
    }

    // Getters and setters (only what's in UML)
    public int getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTierLevel() {
    return level;
    }

}
