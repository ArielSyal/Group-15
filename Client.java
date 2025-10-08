import java.util.*:

public abstract class Client{
    private String clientId;
    private String name;
    private String address;
    private Date dateOfBirth;
    private String phoneNumber;
    private List<BankAccount> accounts;
    private LoyaltyProgram loyaltyProgram;

    public Client(String clientId, String name, String address, Date dateOfBirth, String phoneNumber, String photoId, Date photoIdExpire){
        this.clientId = clientId;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.photoId = photoId;
        this.photoIdExpire = photoIdExpire;
        this.loyaltyProgram = loyaltyProgram;
        this.accounts =  = new ArrayList<>(); 
    }
    public void addBankAccount (BankAccount newAccount){
        if (newAccount == null){
            System.out.println("Cannot add empty account.");
            return;
        }
        if (accounts.contains(newAccount)){
            System.out.println("Account already exists.");
            return;
        }
        if (newAccount.getOwner() != this){
            System.out.println("Account is owned to a different client.");
            return;
        }
        accounts.add(newAccount);
        newAccount.setOwner(this);
        System.out.println("Account has been added.");
        
    }

    public void removeBankAccount (BankAccount deleteAccount){
        if (accounts.size() <= 1) {
            System.out.println("Must have at least one account.");
            return;
        }
        if (deleteAccount = null || !accounts.contains(deleteAccount)){
            System.out.println("Account cannot be found.");
            return;
        }
        accounts.remove(deleteAccount);
        deleteAccount.setOwner(null);
        System.out.println("Account has been removed.");
    }

    public void listBankAccounts(){
        if (accounts.isEmpty()){
            System.out.println("No accounts found for " + name);
        }else{
            for(BankAccount a: accounts)){
                System.out.println(" - " + a.displayInfo());
            }
        }
    }
    public void addLoyaltyProgram (LoyaltyProgram rewards){
        if (this.loyaltyProgram != null){
            System.out.println(name + " already has a loyalty program.");
        } else {
            this.loyaltyProgram = rewards;
            rewards.setClient(this);
        }
    }

    public void removeLoyaltyProgram() {
        if (this.loyaltyProgram == null){
            System.out.println(name + " isn't apart of the loyalty program.");
        } else {
            this.loyaltyProgram.setClient(null);
            this.loyaltyProgram = null;
            System.out.println(name + " has been removed from the loyalty program.");
        }
    }

    public String getClientId(){
        return clientId;
    }
    public String setClientId(String clientId){
        if (clientId == null || clientId.isEmpty()){
            System.out.println("Client ID isn't valid.")
        }else{
            this.clientId = clientId;
        }
        
    }

    public String getName(){
        return name;
    }
    public String setName(String name){
        if (name == null || name.isEmpty()){
            System.out.println("Name cannot be empty.")
        }else{
            this.name = name;
        }
        
    }

    public String getAddress(){
        return address;
    }
    public String setAddress(String address){
        if (address == null || address.isEmpty()){
            System.out.println("Address cannot be empty.")
        }else{
            this.address = address;
        }
        
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    public Date setDateOfBirth(Date dateOfBirth){
        if (dateOfBirth == null || dateOfBirth.isEmpty()){
            System.out.println("Date of Birth cannot be empty.")
        }else{
            this.dateOfBirth = dateOfBirth;
        }
        
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String setPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isEmpty()){
            System.out.println("Phone number cannot be empty.")
        }else{
            this.phoneNumber = phoneNumber;
        }
        
    }
}
