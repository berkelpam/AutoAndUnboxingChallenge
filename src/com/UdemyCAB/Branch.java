package com.UdemyCAB;

import java.util.ArrayList;

public class Branch {
    private int number;
    private String name;
    private Customer customer;
    private ErrorHandler errorHandler=new ErrorHandler();
    private ErrorCodes errorCodes;

    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(int number, String name) {
        this.number = number;
        this.name = name;
    }

    private boolean customerExists(String customerName) {

        if (findCustomer(customerName)>=0) {
            return true;
        }
        return false;
    }

    private boolean customerExists(int customerId) {
        if (customerId >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addCustomer(String name, String accountNumber, double initialAmount) {

        if (customerExists(name)) {
            errorHandler.raiseError(errorCodes.CUSTOMER_ALREADY_EXISTS);
        } else {
            Customer customer = new Customer(name, accountNumber, initialAmount);
            customers.add(customer);
        }

    }

    public int branchNumber() {
        return number;
    }

    private int findCustomer(Customer customer) {
        return this.customers.indexOf(customer);
    }

    private int findCustomer(String customerName) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        errorHandler.raiseError(errorCodes.CUSTOMER_DOES_NOT_EXIST);
        return -1;

    }

    public void deleteCustomer(String name) {

        if (customerExists(name)) {
            this.customers.remove(findCustomer(name));

        } else {
            errorHandler.raiseError(errorCodes.CUSTOMER_DOES_NOT_EXIST);
        }

    }

    public boolean   executeTransaction(String customerName, double amount) {
        if (customerExists(customerName)) {
            Customer customer = this.customers.get(findCustomer(customerName));
            customer.depositAmount(amount);
            return true;
        }

        return false;

    }

    public String name() {
        return this.name;
    }

    public void listCustomers() {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            customer.displayName();
            customer.displayTransactions();

        }
    }
}

