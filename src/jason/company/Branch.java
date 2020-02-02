package jason.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    // create branch
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public static Branch createBranch(String branch) {
        return new Branch(branch);
    }

    // add new customer
    public boolean addNewCustomer(String customerName, double initialDeposit) {
        // make sure this is a new account
        if (findCustomer(customerName) >= 0) {
            System.out.println("Customer is not new. Transaction Canceled");
            return false;
        }
        Customer newCustomer = new Customer(customerName, initialDeposit);
        customers.add(newCustomer);
        return true;
    }

    // get list of all customers
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // return index of customer, -1 if not found
    public Customer findCustomer(int index) {
        return customers.get(index);
    }

    // return index of customer, -1 if not found
    public int findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }
}
