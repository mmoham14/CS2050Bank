//Momen Suliman
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Program7 {
    public static void sop(String s) {
        System.out.println(s);
    }

    public static double formatDouble(double value) {
        return Double.parseDouble(String.format("%.03f", value));
    }

    public static double rng() {
        return 10001000 + (Math.random() * (9999 - 1000));
    }

    public static double rng2() {
        return 2001000 + (Math.random() * (9999 - 1000));
    }

    public static double cashGen() {
        double cash = -100 + (Math.random() * (417));
        return formatDouble(cash);
    }

    public static String cashFormat(double cash) {
        DecimalFormat cashFormat = new DecimalFormat("#,##0.00");
        return cashFormat.format(cash);
    }

    public static void main(String[] args) {
        String[] names = {"Himari Koharu", "Rin Midori", "Yuina Sui", "Iroha Yuzuki", "Mei Ritsu", "Fūma Nagisa", "Haruto Ren", "Haru Aoi", "Koharu Tsumugi", "Nagi Sō"};
//Stacks => have 30 of each account type ready for the new customers in the line/queue.
        AccountStack<Checking> checkingStack = new AccountStack<>();
        for (int i = 1; i <= 30; i++) {
            Checking checkAcc = new Checking((int) rng2(), 0.0);
            checkingStack.push(checkAcc);
        }
        AccountStack<Savings> savingsStack = new AccountStack<>();
        for (int i = 1; i <= 30; i++) {
            Savings saveAcc = new Savings((int) rng2(), 0.0);
            savingsStack.push(saveAcc);
        }
//Queue => customers walk into the bank at 8:30am to make new bank accounts and stand in the line/queue.
        CustomerQueue<Customer> customerQueue = new CustomerQueue<>();
        for (int i = 0; i <= 9; i++) {
            Customer someCus = new Customer(names[i], (int) rng(), null); //account-less customers.
            customerQueue.enqueue(someCus);
        }
//assigning accounts => based on their state ID's they will want either a checking or savings account.
        for (int i = 1; i <= 10; i++) {
            Customer luckyCus = customerQueue.dequeue(); //customer comes off queue
            int luckyNum = luckyCus.getCustomerID();
            if (luckyNum % 2 == 1) { //odd customer ID's want checking
                luckyCus.setUserAccount(checkingStack.peek()); //customer gets their new Checking account
                checkingStack.pop(); //account is removed from stack
            } else { //even customer ID's want savings
                luckyCus.setUserAccount(savingsStack.peek()); //customer gets their new Savings account
                savingsStack.pop(); //account is removed from stack
            }
            customerQueue.enqueue(luckyCus);//customer returns back to back of line/queue.
        }
//simulation => run the queue now that all the customers registered for an account.
        for (int i = 1; i <= 30; i++) {
            Customer cusProcessed = customerQueue.dequeue();
            if (cusProcessed.getAccount() instanceof Checking) {
                Checking temp = (Checking) cusProcessed.getAccount();
                temp.setBalance(cashGen() + cashGen()); //customer will give or take a random amount from the account (overdraft is enabled!).
                cusProcessed.setUserAccount(temp);
            }
            else if (cusProcessed.getAccount() instanceof Savings) {
                Savings temp = (Savings) cusProcessed.getAccount();
                double save = cashGen();
                temp.setBalance((save * save)-(save * save / 2)); //customer will give or take a random amount from the account (overdraft NOT enabled!).
                cusProcessed.setUserAccount(temp);
            }
            customerQueue.enqueue(cusProcessed);//customer returns back to back of line/queue.
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Program7.txt"));
            bw.write("Momen Suliman"); bw.newLine();
            for (int i = 1; i <= 10; i++) { //customers get their statements before leaving the bank.
                Customer cusPrinted = customerQueue.dequeue();
                if (cusPrinted.getAccount() instanceof Checking) {
                    bw.newLine(); bw.write("Name of customer is: " + cusPrinted.getNameOfCustomer()); bw.newLine();
                    bw.write("   Customer's ID is: " + cusPrinted.getCustomerID()); bw.newLine();
                    bw.write("   Checking account number is: " + cusPrinted.getCustomerAccountNumber()); bw.newLine();
                    bw.write("   Checking's balance is: $" + cashFormat(cusPrinted.getCustomerBalance()) + "\n"); bw.newLine();
                }
                else if (cusPrinted.getAccount() instanceof Savings) {
                    bw.newLine(); bw.write("Name of customer is: " + cusPrinted.getNameOfCustomer()); bw.newLine();
                    bw.write("   Customer's ID is: " + cusPrinted.getCustomerID()); bw.newLine();
                    bw.write("   Savings account number is: " + cusPrinted.getCustomerAccountNumber()); bw.newLine();
                    bw.write("   Savings' balance is: $" + cashFormat(cusPrinted.getCustomerBalance()) + "\n"); bw.newLine();
                }
            }
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}