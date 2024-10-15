//Momen Suliman
import java.io.Serializable;
import java.lang.*;
public abstract class Accounts implements Serializable {

    private Integer accountNumber;
    public void setAccountNumber(Integer accNum){
        accountNumber = accNum;
    }
    public Integer getAccountNumber(){
        return accountNumber;
    }

    private Double balance=0.0;
    public void setBalance(Double editBalance){
        balance = balance + editBalance;
    }
    public Double getBalance(){
        return balance;
    }
}