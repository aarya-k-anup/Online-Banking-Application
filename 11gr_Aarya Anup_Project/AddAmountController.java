//to add amount
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

public class AddAmountController implements Initializable
{
    public static ModelClass model = new ModelClass();
    
    @FXML
    private Label balanceDisplay;   
    
    @FXML
    private TextField addAmountTxt;
    @FXML
    private Label addErrorDisplayLbl;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        balanceDisplay.setText(Integer.toString(model.getBalance()));
    }
    
    public static void setBalance(int balance)
    {
        model.setBalance(balance);
    }   
    
    public void addAmountAction(ActionEvent actionEvent)
    {
        String addAmount = addAmountTxt.getText();
        int amount=0;
        
        addErrorDisplayLbl.setText("");
        if(ErrorCatch.isInteger(addAmount)==false)
            addErrorDisplayLbl.setText("Please enter a valid positive number");
        
        else
        { 
            amount=Integer.parseInt(addAmount);
            int balance = model.getBalance() + amount;
        
            model.setBalance(balance);
            balanceDisplay.setText(Integer.toString(model.getBalance()));
            AccountSummaryController.setBalance(balance);
            FundTransferController.setBalance(balance);
            FixedDepositController.setBalance(balance);
            addAmountTxt.clear();
        }
        
    }
}
