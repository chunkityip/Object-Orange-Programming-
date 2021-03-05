package banking7;

public class Bank {
	private Customer[] customers;

	private int numberOfCustomer;

	private Bank() {
		customers = new Customer[5];
	}

	private static Bank instance = new Bank();

	public static Bank getBank(){
		return instance;
	}

	public void addCustomer(String firstName, String lastName){
		Customer cust = new Customer(firstName, lastName);
		customers[numberOfCustomer] = cust;
		numberOfCustomer++;
	}

}