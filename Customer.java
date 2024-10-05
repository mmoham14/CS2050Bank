import java.io.Serializable;

public class Customer implements Serializable {

    public Customer(String aName,Integer cusID, Accounts anAccount){
        nameOfCustomer = aName;
        customerID = cusID;
        userAccount = anAccount;
    }

    private Accounts userAccount;
    public void getAccount() {
        Statements<Accounts> accPrinter = new Statements<>();
        accPrinter.printStatement(userAccount);
    }

    private String nameOfCustomer;
    public void setNameOfCustomer(String cusName){
        nameOfCustomer = cusName;
    }
    public void getNameOfCustomer() {
        System.out.println("Name of user is: " + nameOfCustomer);
    }

    private Integer customerID;
    public void setCustomerID(Integer cusNum){
        customerID = cusNum;
    }
    public void getCustomerID() {
        System.out.println("Customer's ID is: " + customerID);
    }
}