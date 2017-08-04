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

            default:
                // no message defined
                System.out.println("Encountered an undefined error");
                break;

        }
    }
}