package jason.company;

import java.util.ArrayList;

public class Bank {
    // TODO: keep the functionality relating to each class separate
    // TODO: could redo some things here
    private ArrayList<Branch> branches;

    public Bank() {
        this.branches = new ArrayList<Branch>();
    }

    // add branches
    public boolean addBranch(String name) {
        if (findBranch(name) >= 0) {
            System.out.println("Branch already exists");
            return false;
        }
        Branch branch = new Branch(name);
        branches.add(branch);
        System.out.println("Branch " + branch.getName() + " added");
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, Double initialDeposit) {
        int branchIndex = findBranch(branchName);

        if (branchIndex < 0) {
            System.out.println("Branch does not exist");
            return false;
        }

        Branch branch = branches.get(branchIndex);

        if (branch.findCustomer(customerName) >= 0) {
            System.out.println(customerName + " already exists at " + branchName);
            return false;
        }

        branch.addNewCustomer(customerName, initialDeposit);
        return true;
    }

    public boolean addTransaction(String customerName, Double amount) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println(customerName + " does not exist at any branch");
            return false;
        }
        customer.addTransaction(amount);
        System.out.println("Transaction completed for " + customer.getName());
        return true;
    }

    public boolean getCustomersByBranch(String branchName) {
        int branchIndex = findBranch(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch does not exist");
            return false;
        }

        Branch branch = findBranch(branchIndex);
        System.out.println("Customers for " + branchName + ": ");
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            System.out.println((i + 1) + " - " + branch.findCustomer(i).getName());
        }
        return true;
    }

    public boolean getTransactionsByBranch(String branchName) {
        int branchIndex = findBranch(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch does not exist");
            return false;
        }

        Branch branch = findBranch(branchIndex);
        System.out.println("Customers for " + branchName + ": ");
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            System.out.println((i + 1) + " - " + branch.findCustomer(i).getTransactions());
        }
        return true;
    }

    public boolean getTransactionsByCustomer(String customerName) {
        if (findCustomer(customerName) == null) {
            System.out.println("Customer does not exist");
            return false;
        }

        Customer customer = findCustomer(customerName);
        System.out.println("Transactions for " + customerName + ": ");
        System.out.println(customer.getTransactions());
        return true;
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.findCustomer(customerName) >= 0) {
                return branch.findCustomer(i);
            }
        }
        return null;
    }

    private Branch findBranch(int index) {
        return branches.get(index);
    }

    private int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void getBranches() {
        System.out.println("Branches: ");
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            System.out.println((i + 1) + " - " + branch.getName());
        }
    }

}
