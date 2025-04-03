package Exceptions;

public class Account {
    
    private double balance;

    Account(double initial) {
        balance = initial;
    }

    public void deposit(double amount) {
        balance += amount;
    }


    public void withdraw(double amount) throws CustomInsufficientBalanceFundsException {
        if ((balance - amount) < 0.0) throw new CustomInsufficientBalanceFundsException("Error! withdrawl amount exceeds current balance");
        balance -= amount;
    }

    public void checkBalance() {
        System.out.println("Your Current Balance is: $" + balance);
    }
    
}
