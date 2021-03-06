package com.UdemyCAB;

/**
 * Created by pauljava on 04/08/2017.
 */
public class ErrorHandler {

    public ErrorHandler() {
    }

    public void raiseError(int errorCode) {


        switch (errorCode) {

            case 1:
                //customer does not exist
                System.out.println("Customer does not exist");
                break;

            case 2:
                //customer already exists
                System.out.println("Customer already exits");
                break;

            case 3:
                //branche does not exist
                System.out.println("Branche does not exist");
                break;

            case 4:
                //Transaction failed
                System.out.printf("Transaction failed.");
                break;

            case 5:
                //.ADD_CUSTOMER_FAILED
                System.out.println("Adding customer failed.");
                break;

            case 6:
                //BRANCH_ALREADY_EXIST=6;
                System.out.println("Branch already exists");
                break;

            default:
                // no message defined
                System.out.println("Encountered an undefined error");
                break;

        }
    }
}