package Exceptions;

public class Main {
    
    public static void main(String[] args) {
        Account myAccount = new Account(1000.12);

        myAccount.checkBalance();


        System.out.println("Depositing Money...");
        myAccount.deposit(10.10);

        System.out.println();
        myAccount.checkBalance();

        System.out.println("\nWithdrawing Money");
        try{
            myAccount.withdraw(3999.59);
        } catch (CustomInsufficientBalanceFundsException e) {
            System.err.println(e);
        }


        try{
            myAccount.withdraw(100.83);
        } catch (CustomInsufficientBalanceFundsException e) {
            System.err.println(e);
        }

        System.out.println("\n");
        myAccount.checkBalance();

    }


    
}
