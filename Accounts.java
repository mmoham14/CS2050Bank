import java.io.Serializable;
import java.lang.*;
public abstract class Accounts implements Serializable {

    private Integer accountNumber;
    public void setAccountNumber(Integer accNum){
        accountNumber = accNum;
    }
    public void getAccountNumber(){
        System.out.println("User's account number is: " + accountNumber);
    }

    private Double balance=0.0;
    public void setBalance(Double editBalance){
        balance = balance + editBalance;
    }
    public void getBalance(){
        System.out.println("user's balance is: $" + balance + "\n");
    }
}