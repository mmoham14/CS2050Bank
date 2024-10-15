//Momen Suliman
import java.io.Serializable;
public class Customer implements Serializable {

    public Customer(String aName,Integer cusID, Accounts anAccount){
        nameOfCustomer = aName;
        customerID = cusID;
        userAccount = anAccount;
    }

    private Accounts userAccount;
    public Accounts getAccount() {
        return userAccount;
    }

    private String nameOfCustomer;
    public void setNameOfCustomer(String cusName){
        nameOfCustomer = cusName;
    }
    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    private Integer customerID;
    public void setCustomerID(Integer cusNum){
        customerID = cusNum;
    }
    public Integer getCustomerID() {
        return customerID;
    }
}