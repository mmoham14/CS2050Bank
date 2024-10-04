import java.io.Serializable;
import java.lang.*;
public class Savings extends Accounts implements Serializable {

    public Savings (Integer aNum, Double aBalance) {
        setAccountNumber(aNum);
        setBalance(aBalance);
    }
}