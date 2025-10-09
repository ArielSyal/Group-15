import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Client {
    private String clientId;
    private String name;
    private String address;
    private Date dateOfBirth;
    private String phoneNumber;
    private List<BankAccount> accounts;
    private LoyaltyProgram loyaltyProgram;

    public Client(String clientId, String name, String address, Date dateOfBirth, String phoneNumber) {
        this.clientId = clientId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
        this.loyaltyProgram = null;
    }

    public void addBankAccount(BankAccount newAccount) {
        if (newAccount == null) {
            System.out.println("Cannot add empty account.");
            return;
        }
        if (accounts.contains(newAccount)) {
            System.out.println("Account already exists.");
            return;
        }
        if (newAccount.getOwner() != null && newAccount.getOwner() != this) {
            System.out.println("Account is owned by a different client.");
            return;
        }
        newAccount.setOwner(this);
        accounts.add(newAccount);
        System.out.println("Account has been added for client " + name + ".");
    }

    public void removeBankAccount(BankAccount deleteAccount) {
        if (deleteAccount == null || !accounts.contains(deleteAccount)) {
            System.out.println("Account cannot be found.");
            return;
        }
        if (accounts.size() <= 1) { // multiplicity: client must retain at least one account
            System.out.println("Must have at least one account. Cannot remove.");
            return;
        }
        accounts.remove(deleteAccount);
        deleteAccount.setOwner(null);
        System.out.println("Account has been removed for client " + name + ".");
    }

    public void listBankAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found for " + name + ".");
        } else {
            System.out.println("Accounts for " + name + ":");
            for (BankAccount a : accounts) {
                System.out.println(" - " + a.displayInfo());
            }
        }
    }

    public void addLoyaltyProgram(LoyaltyProgram rewards) {
        if (rewards == null) {
            System.out.println("Cannot add a null loyalty program.");
            return;
        }
        if (this.loyaltyProgram != null) {
            System.out.println(name + " already has a loyalty program.");
            return;
        }
        this.loyaltyProgram = rewards;
        rewards.addClient(this);
        System.out.println(name + " added to loyalty program.");
    }

    public void removeLoyaltyProgram() {
        if (this.loyaltyProgram == null) {
            System.out.println(name + " isn't a part of the loyalty program.");
            return;
        }
        this.loyaltyProgram.removeClient(this);
        this.loyaltyProgram = null;
        System.out.println(name + " has been removed from the loyalty program.");
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        if (clientId == null || clientId.isEmpty()) {
            System.out.println("Client ID isn't valid.");
            return;
        }
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            System.out.println("Address cannot be empty.");
            return;
        }
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            System.out.println("Date of Birth cannot be empty.");
            return;
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println("Phone number cannot be empty.");
            return;
        }
        this.phoneNumber = phoneNumber;
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(accounts);
    }

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }
}
