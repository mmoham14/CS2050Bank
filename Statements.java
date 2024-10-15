//Momen Suliman
public class Statements <T extends Accounts> {
    private T infoToPrint;

    public Statements() {
        infoToPrint = null;
    }
    public void printStatement(T accToPrint) {
        infoToPrint = accToPrint;
        Main.sop("User's account number is " + infoToPrint.getAccountNumber());
        Main.sop("User's balance is $" + infoToPrint.getBalance() + "\n");
    }
}