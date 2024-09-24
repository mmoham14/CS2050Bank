import java.lang.*;
public class Checking extends ACCOUNT {

    public Checking (String aName,String aDOB,Integer aNum, Double aBalance){
        nameOfUser = aName;
        DOB = aDOB;
        accountNumber = aNum;
        balance = aBalance;
    }

    public void setNameOfUser(String name){
        nameOfUser = name;
    }
    public void getNameOfUser(){
        System.out.println("your name is " + nameOfUser);
    }

    public void setDOB(String date){
        DOB = date;
    }
    public void getDOB(){
        System.out.println("your DOB is " + DOB);
    }

    public void setAccountNumber(Integer accNum){
        accountNumber = accNum;
    }
    public void getAccountNumber(){
        System.out.println("your account number is " + accountNumber);
    }

    public void setBalance(Double editBalance){
        balance = balance + editBalance;
    }
    public void getBalance(){
        System.out.println("Your current Checking's balance is: $" + balance);
    }
}