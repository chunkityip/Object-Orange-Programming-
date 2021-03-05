package banking52;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        customers = new Customer[6];
    }
    public void addCustomer(String f , String l) {
        Customer c = new Customer(f, l);
        customers[numberOfCustomer] = c;
        numberOfCustomer ++;


    }
    public int getNumOfCustomers() {
        return numberOfCustomer;
    }
    public Customer getCustomer(int index) {
        return customers[index];
    }
}
