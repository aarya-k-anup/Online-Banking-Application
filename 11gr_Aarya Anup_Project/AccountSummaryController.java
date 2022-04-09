//account summary page
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class AccountSummaryController implements Initializable
{
    public static ModelClass model = new ModelClass();
    @FXML
    private Label accountNumberDisplay;
    @FXML
    private Label balanceDisplay;
        
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        accountNumberDisplay.setText(model.getAccountNo());
        balanceDisplay.setText(Integer.toString(model.getBalance()));
    }
    
    public static void setAccountNo(String accountNo)
    {
        model.setAccountNo(accountNo);
    }
    
    public static void setBalance(int balance)
    {
        model.setBalance(balance);
    }   
}
