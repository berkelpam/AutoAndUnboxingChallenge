package com.UdemyCAB;

import java.util.ArrayList;

public class Branch {
    private int number;
    private String name;
    //private Customer customer;

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
            Customer customer = new Customer(name, accountNumber, initialAmount);
        } else {
            System.out.println("Customer already exits");
        }

    }

//    private Customer getCustomer(String customerName){
//        int customerId=this.customers.indexOf(customerName);
//        return customers.get(customerId);
//
//    }

    private int getCustomerId(String customerName){
        int customerId=this.customers.indexOf(customerName);
        return customerId;
    }

    public void deleteCustomer(String name) {

        if (customerExists(name)) {
            this.customers.remove(getCustomerId(name));

        } else {
            System.out.println("Customer does not exists.");
        }

    }

    public void executeTransaction(String customerName, double amount) {

    }
}
