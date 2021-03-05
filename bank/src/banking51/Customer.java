package banking51;

public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccounts;

    public Customer(String f , String l) {
        this.firstName = f;
        this.lastName = l;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account acct) {
        accounts[numberOfAccounts++] = acct;
    }
    public Account getAccount(int index) {
        return accounts[index];
    }
    public int getNumOfAccounts() {
        return numberOfAccounts;
    }


}
