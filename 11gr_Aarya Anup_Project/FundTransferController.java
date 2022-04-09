//to transfer fund to the beneficiary

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class FundTransferController implements Initializable
{
    public static ModelClass model = new ModelClass();
    
    @FXML
    private Label balanceDisplay;
    @FXML
    private TextField beneficiaryNameTxt;
    @FXML
    private TextField transferFundAmountTxt;
    @FXML
    private Label invaidAmountLbl;  
    
    //to initially display the balance amount
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        balanceDisplay.setText(Integer.toString(model.getBalance()));
    }
    
    //to set the balance amount
    public static void setBalance(int balance)
    {
        model.setBalance(balance);
    }  
    
    //to input the beneficiary name and amount tobe tranfersed after check for errors and then ereduce the balcne amount b
    public void transferFundAction(ActionEvent actionEvent) throws Exception
    {
        String beneficiaryName = beneficiaryNameTxt.getText();
        String transferAmount = transferFundAmountTxt.getText();
        int availableBalance = model.getBalance();
        int balance;
        
        
        invaidAmountLbl.setText("");
        if(beneficiaryName.isEmpty() || transferAmount.isEmpty())
            invaidAmountLbl.setText("Please enter the details required");
        
        if(ErrorCatch.isInteger(transferAmount)==false)
            invaidAmountLbl.setText("Please enter a valid positive number");
        
        else if((Integer.parseInt(transferAmount))>availableBalance)
        {
            invaidAmountLbl.setText("Not enough balance available for transfer");
        }        
        else
        {
            int amount=Integer.parseInt(transferAmount);
            balance = availableBalance - amount;
        
            model.setBalance(balance);
            balanceDisplay.setText(Integer.toString(balance));
            balanceDisplay.setText(Integer.toString(model.getBalance()));
            AccountSummaryController.setBalance(balance);
            AddAmountController.setBalance(balance);
            FixedDepositController.setBalance(balance);
            beneficiaryNameTxt.clear();
            transferFundAmountTxt.clear();
        }
    }
}