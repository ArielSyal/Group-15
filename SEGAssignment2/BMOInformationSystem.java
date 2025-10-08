import java.util.ArrayList;
import java.util.List;

public class BMOInformationSystem {
    private List<Client> clients;
    private List<NonClient> nonClients;

    public BMOInformationSystem() {
        this.clients = new ArrayList<>();
        this.nonClients = new ArrayList<>();
    }

    public void addClient(Client client) {
        if (client == null) {
            System.out.println("Cannot add null client.");
            return;
        }
        if (clients.contains(client)) {
            System.out.println("Client already exists in system.");
            return;
        }
        clients.add(client);
        System.out.println("Client added to BMO system: " + client.getName());
    }

    public void removeClient(Client client) {
        if (client == null || !clients.contains(client)) {
            System.out.println("Client not found in system.");
            return;
        }
        clients.remove(client);
        System.out.println("Client removed from BMO system: " + client.getName());
    }

    public void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients in BMO system.");
            return;
        }
        System.out.println("BMO Clients:");
        for (Client c : clients) {
            System.out.println(" - " + c.getName() + " (" + c.getClientId() + ")");
        }
    }

    public void addNonClient(NonClient nonClient) {
        if (nonClient == null) {
            System.out.println("Cannot add null non-client.");
            return;
        }
        if (nonClients.contains(nonClient)) {
            System.out.println("Non-client already exists.");
            return;
        }
        nonClients.add(nonClient);
        System.out.println("Non-client added: " + nonClient.getName());
    }

    public void removeNonClient(NonClient nonClient) {
        if (nonClient == null || !nonClients.contains(nonClient)) {
            System.out.println("Non-client not found.");
            return;
        }
        nonClients.remove(nonClient);
        System.out.println("Non-client removed: " + nonClient.getName());
    }

    public void listNonClients() {
        if (nonClients.isEmpty()) {
            System.out.println("No non-clients in system.");
            return;
        }
        System.out.println("BMO Non-Clients:");
        for (NonClient n : nonClients) {
            System.out.println(" - " + n.getName() + " (" + n.getNonClientId() + ")");
        }
    }

    public Client findClientById(String clientId) {
        if (clientId == null) return null;
        for (Client c : clients) {
            if (clientId.equals(c.getClientId())) return c;
        }
        return null;
    }
}
