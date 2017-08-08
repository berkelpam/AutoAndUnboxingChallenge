package com.UdemyCAB;

public class Main {

    private ErrorCodes errorCodes;
    private ErrorHandler errorHandler= new ErrorHandler();

    public static void main(String[] args) {
//	Customer customer = new Customer("Jan","234",23.0d);
//        System.out.println(customer.getBalance());
//	customer.depositAmount(23d);
//        System.out.println(customer.getBalance());
//        customer.displayTransactions();

        Bank bank = new Bank("Rabobank");
        bank.addBranch("Veldhoven");
      //  bank.listBranches();
        bank.addBranch("Eindhoven");
        bank.addBranch("Tilburg");
        bank.listBranches();
        bank.addCustomer("Veldhoven","Jan",200d);
        bank.addCustomer("Veldhoven","Piet",22d);
        bank.addCustomer("Veldhoven","Wim",134.33d);
        bank.listCustomersForBranch("Veldhoven");
        bank.executeTransaction("Veldhoven","Jan", 200d);
        bank.executeTransaction("Veldhoven","Wim", 8d);
        bank.executeTransaction("Veldhoven","Pipo", 8d);
   //     bank.listCustomersForBranch("Veldhoven");
        
    }
}
