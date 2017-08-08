package com.UdemyCAB;
//version 0.3

import java.util.ArrayList;


public class Bank {

    private ErrorCodes errorCodes;

    private String name;
    private Branch brance;
    private ArrayList<Branch> branches = new ArrayList<Branch>();
    private ErrorHandler errorHandler=new ErrorHandler();

    public Bank(String name) {
        this.name = name;
    }

    public void addBranch(String brancheName) {
        Branch branch = new Branch((this.branches.size() + 1230), brancheName);
        addBranch(branch);
    }

    private void addBranch(Branch branche) {
        this.branches.add(branche);
    }

    public void listBranches() {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branche = this.branches.get(i);
            System.out.println((i + 1) + " ." + branche.name());

        }
    }

    public void addCustomer(String brancheName, String customerName, double initialDeposit) {
        Branch branch = this.getBranche(brancheName);
        if (branch!=null) {
            String accountNumber = "" + branch.branchNumber() + branches.size() + 13;
            branch.addCustomer(customerName, accountNumber, initialDeposit);
        }
    }

    private Branch getBranche(String brancheName) {
        int brancheID = -1;

        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).name() == brancheName) {
                return branches.get(i);
            }
        }
        return null;
    }

    public void listCustomersForBranch(String branchName){
        Branch branch  =getBranche(branchName);
        System.out.println("List of customers for branche: " + branchName);
        branch.listCustomers();
    }

    public void executeTransaction (String branchName, String customerName, double amount){
        Branch branch = getBranche(branchName);
        if (branch!=null) {
            branch.executeTransaction(customerName, amount);
        }
        else
        {
            errorHandler.raiseError(errorCodes.BRANCH_DOES_NOT_EXIST);
        }
    }
}


