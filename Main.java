import java.io.*;
public class Main {
    public static void sop(String s) {
        System.out.println(s);
    }
    public static double rng() {
        return 10010000 + (Math.random() * (10099999 - 10010000));
    }
    public static void main(String[] args) {
        Checking myChecking = new Checking((int) rng(), 0.0);
        Customer me = new Customer("Momen Suliman", 900915295, myChecking);
        me.getNameOfCustomer();
        me.getCustomerID();
        me.getAccount();

        AccountStack<Checking> checkStack = new AccountStack<>();
        AccountStack<Savings> saveStack = new AccountStack<>();
        for (int i=0; i<=24; i++) {
            checkStack.push(new Checking((int) rng(),0.0));
            saveStack.push(new Savings((int) rng(),0.0));
        }

        try {
            ObjectOutputStream checkingWriter = new ObjectOutputStream(new FileOutputStream("CheckStack"));
            for (int i=0; i<=24; i++){
                checkingWriter.writeObject(checkStack.peek());
                checkStack.pop();
            }
            checkingWriter.close();

            ObjectOutputStream savingWriter = new ObjectOutputStream(new FileOutputStream("SaveStack"));
            for (int i=0; i<=24; i++){
                savingWriter.writeObject(saveStack.peek());
                saveStack.pop();
            }
            savingWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sop("\ndata has been saved!\nchecking stack size is: "+checkStack.size());
        sop("savings stack size is: "+ saveStack.size() + "\n");
        try {
            ObjectInputStream checkingReader = new ObjectInputStream(new FileInputStream("CheckStack"));
            for (int i=0; i<=24; i++){
                checkStack.push((Checking) checkingReader.readObject());
                Checking printCheck = checkStack.peek();
                System.out.print("Checking ");
                printCheck.getAccountNumber();
            }
            checkingReader.close();
            sop("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ObjectInputStream savingsReader = new ObjectInputStream(new FileInputStream("SaveStack"));
            for (int i=0; i<=24; i++){
                saveStack.push((Savings) savingsReader.readObject());
                Savings printSave = saveStack.peek();
                System.out.print("Savings ");
                printSave.getAccountNumber();
            }
            savingsReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sop("\ndata has been retrieved!\nchecking stack size is: "+checkStack.size());
        sop("savings stack size is: "+ saveStack.size() + "\n");
    }
}