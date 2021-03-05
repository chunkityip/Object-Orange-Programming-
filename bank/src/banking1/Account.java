package banking1;

public class Account {
    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }
    public double deposit(double amt) {
        return balance += amt;
    }
    public double withdraw(double amt) {
        return balance -= amt;
    }
}
