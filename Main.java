import java.io.*;
public class Main {
    public static void sop(String s) {
        System.out.println(s);
    }
    public static double rng() {
        return 10010000 + (Math.random() * (10099999 - 10010000));
    }
    public static Checking accGen() {
        Checking someChecking = new Checking((int) rng(), 0.0);
        return someChecking;
    }
    public static void main(String[] args) {

        Checking myChecking = new Checking((int) rng(), 0.0);
        myChecking.setBalance(147.38);
        Customer me = new Customer("Momen Suliman", 900915295, myChecking);

        CustomerQueue<Customer> cusQue = new CustomerQueue<>();
        cusQue.enqueue(me);
        for (int i=0; i<9; i++) {
            Customer someCus = new Customer("John Doe", (int) rng(), accGen());
            cusQue.enqueue(someCus);
        }

        try {
            ObjectOutputStream customerWriter = new ObjectOutputStream(new FileOutputStream("Customers"));
            for (int i=0; i<=9; i++) {
                customerWriter.writeObject(cusQue.dequeue());
            }
            customerWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sop("\nis Queue empty? " + cusQue.isEmpty() + "\n");

        try {
            ObjectInputStream customerReader = new ObjectInputStream(new FileInputStream("Customers"));
            for (int i=0; i<=9; i++) {
                Customer toQueue = (Customer) customerReader.readObject();
                cusQue.enqueue(toQueue);
                toQueue.getNameOfCustomer(); toQueue.getCustomerID(); toQueue.getAccount();
            }
            customerReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sop("data has been retrieved!");
    }
}
