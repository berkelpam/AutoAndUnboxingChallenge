package com.UdemyCAB;

import java.util.ArrayList;

public class Branch {
    private int number;
    private String name;
    private Customer customer;
    private ErrorHandler errorHandler = new ErrorHandler();
    private ErrorCodes errorCodes;

    private ArrayList<Customer> customers ;

    public Branch(int number, String name) {
        this.number = number;
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

//    private boolean customerExists(String customerName) {
//
//        if (findCustomer(customerName)!=null) {
//            return true;
//        }
//        return false;
//    }

//    private boolean customerExists(int customerId) {
//        if (customerId >= 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean addCustomer(String name,  double initialAmount) {

        if (findCustomer(name)!=null) {
            errorHandler.raiseError(errorCodes.ADD_CUSTOMER_FAILED);
            errorHandler.raiseError(errorCodes.CUSTOMER_ALREADY_EXISTS);
          return false;
        } else {
//            Customer customer = new Customer(name, accountNumber, initialAmount);
//            customers.add(customer);
              this.customers.add(new Customer(name,23d));
            return true;
        }
    }

    public int branchNumber() {
        return number;
    }

    private int findCustomer(Customer customer) {
        return this.customers.indexOf(customer);
    }

//    private int findCustomer(String customerName) {
//        for (int i = 0; i < this.customers.size(); i++) {
//            Customer customer = this.customers.get(i);
//            if (customer.getName().equals(customerName)) {
//                return i;
//            }
//        }
//        return -1;
//
//    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer existingCustomer = this.customers.get(i);
            if (existingCustomer.getName().equals(customerName)) {
                return existingCustomer;
            }
        }
        return null;

    }


    public boolean   deleteCustomer(String name) {

        if (findCustomer(name)!=null) {
            this.customers.remove(findCustomer(name));
            return true;

        } else {
            errorHandler.raiseError(errorCodes.CUSTOMER_DOES_NOT_EXIST);
            return false;
        }

    }

    public boolean executeTransaction(String customerName, double amount) {
        Customer existingCustomer=findCustomer(customerName);

        if (existingCustomer!=null){
            existingCustomer.depositAmount(amount);
//        if (findCustomer(customerName)>=0) {
//            customer.depositAmount(amount);
//            return true;
        }
        errorHandler.raiseError(errorCodes.CUSTOMER_DOES_NOT_EXIST);
        errorHandler.raiseError(errorCodes.TRANSACTION_FAILED);
        return false;

    }

    public String name() {
        return this.name;
    }

    public void listCustomers(boolean displayTransactions) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = this.customers.get(i);
            //customer.displayAcountnumber();
            customer.displayName();
            if (displayTransactions) {
                customer.displayTransactions();
            }
        }
    }


}

