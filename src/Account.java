import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account{

    private int customerNum;
    private int pinNum;
    private double currentAccBalance = 0;
    private double savingAccBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat currentFormat = new DecimalFormat("'$'###,###0.00");

    // Setters
    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
        //return customerNum;
    }

    public void setPinNum(int pinNum) {
        this.pinNum = pinNum;
    }


    // Getters
    public int getCustomerNum(){
        return this.customerNum;
    }

    public int getPinNum(){
        return this.pinNum;
    }

    public double getCurrentAccBalance() {
        return this.currentAccBalance;
    }

    public double getSavingAccBalance() {
        return this.savingAccBalance;
    }


    public void calcCheckingWithdraw( double amount) {
        currentAccBalance -= amount;
    }

    public void calcSavingWithdraw(double amount) {
        savingAccBalance -= amount;
    }

    public void calcCurrentDeposit(double amount) {
        currentAccBalance += amount;
    }

    public void calcSavingDeposit(double amount) {
        savingAccBalance += amount;
    }

    public void getCurrentWithdrawInput() {
        System.out.println("Current account balance: " +
                currentFormat.format(currentAccBalance));
        System.out.print("Enter the amount you wish to withdraw: ");
        double amount = input.nextDouble();

        if ((currentAccBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New current account balance is: " + currentFormat.format(currentAccBalance));
        } else {
            System.out.println("Sorry, Insufficient funds.\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving account balance: " +
                currentFormat.format(savingAccBalance));
        System.out.print("Enter the amount you wish to withdraw: ");
        double amount = input.nextDouble();

        if ((savingAccBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New saving account balance is: " +
                    currentFormat.format(savingAccBalance));
        } else {
            System.out.println("Sorry, Insufficient funds.\n");
        }
    }

    public void getCurrentDepositInput() {
        System.out.println("Current account balance: " +
                currentFormat.format(currentAccBalance));
        System.out.print("Enter the amount you wish to deposit: ");

        // Getting input from the user
        double amount = getInput();

        if (amount >= 0) {
            calcCurrentDeposit(amount);
            System.out.println("New saving account balance is: " +
                    currentFormat.format(savingAccBalance));
        } else {
            System.out.println("Sorry, Invalid amount.\n");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Saving account balance: " +
                currentFormat.format(savingAccBalance));
        System.out.print("Enter the amount you wish to deposit: ");

        double amount = getInput();

        if (amount >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New saving account balance is: " +
                    currentFormat.format(savingAccBalance));
        } else {
            System.out.println("Sorry, Invalid amount.\n");
        }
    }

    public double getInput() {
        double amount = -1;
        try {
            amount = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
        return amount;
    }
}
