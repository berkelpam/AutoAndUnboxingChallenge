package com.UdemyCAB;

public class Main {

    private ErrorCodes errorCodes;
    private static ErrorHandler errorHandler= new ErrorHandler();

    public static void main(String[] args) {

        //create bank:
        Bank bank = new Bank("Rabobank");

        //create branches:
        bank.addBranch("Veldhoven");
        bank.addBranch("Eindhoven");
        bank.addBranch("Tilburg");

        //Add customers;
        bank.addCustomer("Veldhoven","Jan",200d);
        bank.addCustomer("Veldhoven","Piet",22d);

        //Execute additional transactions:
        bank.executeTransaction("Veldhoven","Jan", 200d);
        bank.executeTransaction("Veldhoven","Wim", 8d);
        bank.executeTransaction("Veldhoven","Pipo", 8d);

        //create bank 2:
        Bank Tridios = new Bank("Tridios Bank");

        //add branches:
        Tridios.addBranch("Tilburg");
        Tridios.addBranch("Veenendaal");

        //add customers:
        Tridios.addCustomer("Tilburg","Jan",230000d);
        Tridios.addCustomer("Tilburg","Piop",23d);
        Tridios.addCustomer("Tilburg","pipo",112d);
        Tridios.addCustomer("Tilburg","pipO",9399d);


        //Start tests:
        System.out.println("Start tests.");
        System.out.println("============");


        //check if trying to add an existing branch fails:
        if(!bank.addBranch("Veldhoven")){
            errorHandler.raiseError(ErrorCodes.BRANCH_ALREADY_EXIST);
        }

        //check if customer already exists:
        if (!bank.addCustomer("Veldhoven","Jan",01.2d)){
            errorHandler.raiseError(ErrorCodes.CUSTOMER_ALREADY_EXISTS);
        }

        //check if branch does not exist:
        if (!bank.addCustomer("Wallonie","Karel",01.2d)){
            System.out.println("Branche test case 1:");
            errorHandler.raiseError(ErrorCodes.BRANCH_DOES_NOT_EXIST);
        }

        if(!bank.findBranche("Wallonie")){
            System.out.println("Branche test case 2:");
            errorHandler.raiseError(ErrorCodes.BRANCH_DOES_NOT_EXIST);
        }

        if(!bank.executeTransaction("Wallonie","Jan",23d)){
            System.out.println("Branche test case 3:");
            errorHandler.raiseError(ErrorCodes.BRANCH_DOES_NOT_EXIST);

        }

        //check if the customer exists
        if (!bank.executeTransaction("Eindhoven","Peter",12d)){
            errorHandler.raiseError(ErrorCodes.CUSTOMER_DOES_NOT_EXIST);
        }

    }
}
