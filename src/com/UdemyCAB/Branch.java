package com.UdemyCAB;

import java.util.ArrayList;

public class Branch {
    private int number;
    private String name;
    //private Customer customer;
    private ErrorHandler errorHandler;

    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(int number, String name) {
        this.number = number;
        this.name = name;
    }

    private boolean customerExists(String customerName) {
        int customerId = customers.indexOf(customerName);

        return customerExists(customerId);

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
            errorHandler.raiseError(2);
        } else {
            Customer customer = new Customer(name, accountNumber, initialAmount);
            customers.add(customer);
        }

    }

    public int branchNumber() {
        return number;
    }

    //    private Customer getCustomer(String customerName){
//        int customerId=this.customers.indexOf(customerName);
//        return customers.get(customerId);
//
//    }

    private int getCustomerId(String customerName) {
        int customerId = this.customers.indexOf(customerName);
        return customerId;
    }

    public void deleteCustomer(String name) {

        if (customerExists(name)) {
            this.customers.remove(getCustomerId(name));

        } else {
            errorHandler.raiseError(1);
        }

    }

    public void executeTransaction(String customerName, double amount) {
        if (customerExists(customerName)) {
            Customer customer = this.customers.get(getCustomerId(customerName));
            customer.depositAmount(amount);
        } else {
            errorHandler.raiseError(1);
        }

    }

    public String name (){
        return  this.name;
    }

    public void listCustomers(){
        for (int i = 0; i <this.customers.size() ; i++) {
            Customer customer = this.customers.get(i);
            customer.displayName();

        }
    }
}

