package banking8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    public class Bank {
        private List<Customer> customers;


        private Bank() {
            customers = new ArrayList<Customer>();
        }

        private static Bank instance = new Bank();

        public static Bank getBank(){
            return instance;
        }

        public void addCustomer(String firstName, String lastName){
            Customer cust = new Customer(firstName, lastName);
            customers.add(cust);
        }
        public int getNumOfCustomers(){
            return customers.size();
        }
        public Customer getCustomer(int index){
            return customers.get(index);
        }
        Iterator<Customer> getCustomers(){
            return customers.iterator();
        }
    }
}
