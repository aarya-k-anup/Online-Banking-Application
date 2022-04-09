//MVC (model view controller) class

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;

public class ModelClass
{
    
    //to get ans set the username value
    private StringProperty userName;
    public void setUserName(String value)
    {
        userNameProperty().set(value);
    }
    public String getUserName()
    {
        return userNameProperty().get();
    }
    public StringProperty userNameProperty()
    {
        if(userName==null)
            userName=new SimpleStringProperty(this, "userName");
        return userName;
    }
    
    //to get ans set the accountNo value
    private StringProperty accountNo;
    public void setAccountNo(String value)
    {
        accountNoProperty().set(value);
    }
    public String getAccountNo()
    {
        return accountNoProperty().get();
    }
    public StringProperty accountNoProperty()
    {
        if(accountNo==null)
            accountNo=new SimpleStringProperty(this, "userName");
        return accountNo;
    }
    
     //to get ans set the blance value
    private IntegerProperty balance;
    public void setBalance(int value)
    {
        balanceProperty().set(value);
    }
    public int getBalance()
    {
        return balanceProperty().get();
    }
    public IntegerProperty balanceProperty()
    {
        if(balance==null)
            balance=new SimpleIntegerProperty(this, "userName");
        return balance;
    }
}