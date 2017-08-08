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
        bank.listCustomersForBranch("Veldhoven",true);
        bank.addCustomer("Veldhoven","Piet",22d);
        //bank.addCustomer("Veldhoven","Piet",3d);
//        bank.addCustomer("Veldhoven","Wim",134.33d);
        bank.listCustomersForBranch("Veldhoven",true);
        bank.listCustomersForBranch("Veldhoven",false);
        bank.executeTransaction("Veldhoven","Jan", 200d);
        bank.executeTransaction("Veldhoven","Wim", 8d);
        bank.executeTransaction("Veldhoven","Pipo", 8d);
         bank.listCustomersForBranch("Veldhoven",true);
        bank.listCustomersForBranch("Veldhoven",false );

        Bank Tridios = new Bank("Tridios Bank");
        Tridios.addBranch("Tilburg");
        Tridios.addCustomer("Tilburg","Jan",230000d);
        Tridios.addCustomer("Tilburg","Piop",23d);
        Tridios.addCustomer("Tilburg","pipo",112d);
        Tridios.addCustomer("Tilburg","pipO",9399d);
        Tridios.listCustomersForBranch("Tilburg",true);
        Tridios.deleteCustomer("Tilburg","Piop");
    }
}
