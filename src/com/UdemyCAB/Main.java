package com.UdemyCAB;

public class Main {

    public static void main(String[] args) {
	Customer customer = new Customer("Jan","234",23.0d);
        System.out.println(customer.getBalance());
	customer.depositAmount(23d);
        System.out.println(customer.getBalance());
        customer.displayTransactions();
    }
}
