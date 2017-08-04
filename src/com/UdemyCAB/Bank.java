package com.UdemyCAB;
//version 0.3
import java.util.ArrayList;



public class Bank {
   private Branch brance;
   private ArrayList<Branch> branches = new ArrayList<Branch>();

   public Bank() {
   }

   public void addBranch(String branchName){
      Branch branch=new Branch((this.branches.size()+1230),branchName);
      addBranch(branch);
   }

   private void addBranch(Branch brance){
      this.branches.add(brance);
   }
}
