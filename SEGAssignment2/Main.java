import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example Loyalty Program
        LoyaltyProgram program = new LoyaltyProgram(500, "Silver");

        // Example Client (using a subclass, since Client is abstract)
        Date birthDate = new Date();
        Student student = new Student("C001", "Alice", "123 King St", birthDate, "123-456-7890", "University of Ottawa", birthDate);

        // Example Bank Account (abstract, so we use a subclass)
        ChequingAccount cheq = new ChequingAccount(1001, 2500.0, student, "Main Account");
        SavingsAccount save = new SavingsAccount(1002, 5000.0, student, "Vacation Fund", 2.5);

        // Adding accounts to client
        student.addBankAccount(cheq);
        student.addBankAccount(save);

        // Add client to loyalty program
        program.addClient(student);

        // List accounts
        student.listBankAccounts();

        // Update loyalty points
        program.updateTier(student, 100);

        // List loyalty program clients
        program.listClients();
    }
}
