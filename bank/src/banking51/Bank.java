package banking51;

public class Bank {
    private banking51.Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
        customers = new banking51.Customer[6];
    }
    public void addCustomer(String f , String l) {
        banking51.Customer c = new banking51.Customer(f, l);
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
