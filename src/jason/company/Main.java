package jason.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {

        bank.addBranch("one");
        bank.addBranch("two");

        boolean quit = false;
        printMenu();

        while (!quit) {
            System.out.println("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    printMenu();
                    break;

                case 1:
                    addNewBranch();
                    break;

                case 2:
                    addNewCustomer();
                    break;

                case 3:
                    addTransaction();
                    break;

                case 4:
                    showCustomersByBranch();
                    break;

                case 5:
                    showTransactionsByBranch();
                    break;

                case 6:
                    showTransactionsByCustomer();
                    break;

                case 7:
                    bank.getBranches();
                    break;

                default:
                    quit = true;
                    break;
            }
        }
    }

    private static void showTransactionsByCustomer() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        bank.getTransactionsByCustomer(customerName);
    }

    private static void showTransactionsByBranch() {
        System.out.println("Enter branch name to show list of transactions: ");
        String branchName = scanner.nextLine();
        bank.getTransactionsByBranch(branchName);
    }

    private static void showCustomersByBranch() {
        System.out.println("Enter branch name to show list of customers: ");
        String branchName = scanner.nextLine();
        bank.getCustomersByBranch(branchName);
    }

    private static void addTransaction() {
        System.out.println("Enter customer name to add transaction: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter transaction amount: ");
        Double amount = scanner.nextDouble();
        scanner.nextLine();

        bank.addTransaction(customerName, amount);
    }

    private static void addNewBranch() {
        System.out.println("Enter name of branch to add: ");
        String newBranch = scanner.nextLine();

        bank.addBranch(newBranch);
    }

    private static void addNewCustomer() {
        System.out.println("Which branch to add customer: ");
        String branchName = scanner.nextLine();

        System.out.println("Enter new customer name: ");
        String newCustomer = scanner.nextLine();

        System.out.println("Enter initial deposit amount: ");
        Double initialDeposit = scanner.nextDouble();
        scanner.nextLine();

        bank.addCustomer(branchName, newCustomer, initialDeposit);
    }

    private static void printMenu() {
        System.out.print("\n Press ");
        System.out.print("\n 0 - To see menu");
        System.out.print("\n 1 - To add new branch");
        System.out.print("\n 2 - To add new customer");
        System.out.print("\n 3 - To add transaction for a customer");
        System.out.print("\n 4 - To show customers by branch");
        System.out.print("\n 5 - To show transactions by branch");
        System.out.print("\n 6 - To show transactions by customer");
        System.out.print("\n 7 - To show list of branches");
        System.out.println("\n Other number To quit");
    }
}
