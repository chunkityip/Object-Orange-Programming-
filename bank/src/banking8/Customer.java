package banking8;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Customer {
        private String firstName;
        private String lastName;

        private List<Account> accounts;

        private int numberOfAccounts;

        public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;

            accounts = new ArrayList<>(Account);
        }

        public banking7.Account getAccount(int index) {
            return accounts[index];
        }

        public void addAccount(Account account) {
            accounts[numberOfAccounts++] = account;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getNumOfAccounts(){
            return numberOfAccounts;
        }
    }
}
