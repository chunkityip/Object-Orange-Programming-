package banking52;

public class Customer {
    private String firstName;
    private String lastName;
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;


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

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
}
