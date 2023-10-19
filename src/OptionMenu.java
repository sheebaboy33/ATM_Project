import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionMenu extends Account{

    Scanner input = new Scanner(System.in);
    DecimalFormat currencyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> accountInfo = new HashMap<Integer, Integer>();

    public void getLogin(){
        int x = 1;
        do {
            try {
                // Inserts the account information (Pre-added)
                accountInfo.put(20222253, 1985558);
                accountInfo.put(20222263, 1975558);

                System.out.println("Welcome to the ATM Project!");
                System.out.print("Enter your customer number: ");
                setCustomerNum(input.nextInt());

                System.out.print("Enter your PIN: ");
                setPinNum(input.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s).\nOnly numbers!\n");
                x = 2;
            }

            int customerNum = getCustomerNum();
            int pinNumber = getPinNum();

            if (accountInfo.containsKey(customerNum) && accountInfo.get(customerNum) == pinNumber) {
                getAccountType();
            } else {
                System.out.println("\nWrong customer number or PIN number");
            }
        } while (x == 1);
    }

    public void getAccountType(){
        System.out.println("Select the account you want to access: \n" +
                "Type 1 - Current Account\n" +
                "Type 2 - Saving Account\n" +
                "Type 3 - Exit\n");

        int selection = getInputSelection();

        switch (selection) {
            case 1 -> getCurrent();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank you for using this ATM." +
                    "Have a Good day!\n");
            default -> {
                System.out.println("\nInvalid choice\n");
                getAccountType();
            }
        }
    }

    public void getCurrent() {
        System.out.println("Current Account: \n" +
                "Type 1 - View Balance\n" +
                "Type 2 - Withdraw Funds\n" +
                "Type 3 - Deposit Funds\n" +
                "Type 4 - Exit\n");

        int selection = getInputSelection();

        switch (selection) {
            case 1 -> {
                System.out.println("Checking account balance: " +
                        currencyFormat.format(getCurrentAccBalance()));
                getAccountType();
            }
            case 2 -> {
                getCurrentWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCurrentDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this ATM! \nHave a Nice day!");
            default -> {
                System.out.println("\n" + "Invalid Choice. Please Try again.\n");
                getCurrent();
            }
        }
    }

    public void getSaving(){
        System.out.println("Saving Account: \n" +
                "Type 1 - View Balance\n" +
                "Type 2 - Withdraw Funds\n" +
                "Type 3 - Deposit Funds\n" +
                "Type 4 - Exit\n");

        int selection = getInputSelection();

        switch (selection) {
            case 1 -> {
                System.out.println("Checking account balance: " +
                        currencyFormat.format(getSavingAccBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this ATM! \nHave a Nice day!");
            default -> {
                System.out.println("\nInvalid Choice. Please Try again.\n");
                getSaving();
            }
        }
    }

    public int getInputSelection(){
        int selection = -1;

        try {
            System.out.print("Choice: ");
            input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
        return selection;
    }
}
