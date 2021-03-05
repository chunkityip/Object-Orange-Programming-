package banking8;


import banking7.OverdraftException;

public class Account {

    protected double balance;

public Account(double init_balance){
        this.balance = init_balance;
        }

public double getBalance() {
        return balance;
        }


public boolean deposit(double amt){
        this.balance += amt;
        return true;
        }


public void withdraw(double amt) {

        if(amt > balance){
            throw new OverdraftException("Error", amt - balance);
        }
            this.balance -= amt;
        }
}

