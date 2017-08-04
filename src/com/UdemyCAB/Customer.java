package com.UdemyCAB;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String acountnumber;
    private double balance;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, String acountnumber, double initialAmount) {
        this.name = name;
        this.acountnumber = acountnumber;
        this.transactions.add(initialAmount);
        this.balance+=initialAmount;
    }

    public void depositAmount(double amount){
        this.transactions.add(amount);
        this.balance+=amount;
    }

    public double getBalance() {
        return balance;
    }

    public void displayTransactions(){
        for (int i = 0; i <this.transactions.size() ; i++) {
            System.out.println("Transaction "+ (i+1)+" is: " + this.transactions.get(i));

        }
    }
}
