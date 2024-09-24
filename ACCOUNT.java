import java.lang.*;
public abstract class ACCOUNT {

    String nameOfUser;
    public abstract void setNameOfUser(String name);
    public abstract void getNameOfUser();

    String DOB;
    public abstract void setDOB(String date);
    public abstract void getDOB();

    Integer accountNumber;
    public abstract void setAccountNumber(Integer accNum);
    public abstract void getAccountNumber();

    Double balance=0.0;
    public abstract void setBalance(Double editBalance);
    public abstract void getBalance();

}