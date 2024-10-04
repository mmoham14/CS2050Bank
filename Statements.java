public class Statements <T extends Accounts> {
    private T infoToPrint;

    public Statements() {
        infoToPrint = null;
    }
    public void printStatement(T accToPrint) {
        infoToPrint = accToPrint;
        infoToPrint.getAccountNumber();
        infoToPrint.getBalance();
    }
}