//fixed deposit

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.CheckBox;


public class FixedDepositController implements Initializable
{
    public static ModelClass model = new ModelClass();
    
    @FXML
    private Label balanceDisplay;
    @FXML
    private TextField enterAmountTxt;
    @FXML
    private TextField enterTenorTxt;  
    @FXML
    private Label rateDisplay;
    @FXML
    private CheckBox seniorCitizenChB;
    @FXML
    private Label invalidInputLbl;
    
    @FXML
    private BorderPane mainPane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        balanceDisplay.setText(Integer.toString(model.getBalance()));
    }
    
    public static void setBalance(int balance)
    {
        model.setBalance(balance);
    } 
    
    public void fixedDepositAction(ActionEvent actionEvent) throws Exception
    {
        String enterAmount = enterAmountTxt.getText();
        String enterTenor = enterTenorTxt.getText();
        int availableBalance = model.getBalance();
        double maturityAmount=0.0;
        int balance=0;
        
        invalidInputLbl.setText("");
        if(enterAmount.isEmpty() || enterTenor.isEmpty())
            invalidInputLbl.setText("Please enter the details required");
            
        
        if(ErrorCatch.isInteger(enterAmount)==false || ErrorCatch.isInteger(enterTenor)==false)
            invalidInputLbl.setText("Please enter a valid positive number");
            
        else if((Integer.parseInt(enterAmount))>availableBalance)
        {
            invalidInputLbl.setText("Not enough balance available for opening fixed deposit");
        } 
        else
        {
            int amount=Integer.parseInt(enterAmount);
            double tenor=Double.parseDouble(enterTenor);
            rateDisplay.setText(Double.toString(0.0));
            if(tenor>=1.0 && tenor<2.0)
            {
                if(seniorCitizenChB.isSelected()==true)
                maturityAmount =((amount * 7 * tenor)/100);
                else
                maturityAmount =((amount * 6 * tenor)/100);
            }
            else if (tenor>=2.0 && tenor<3.0 )
            {
                if(seniorCitizenChB.isSelected()==true)
                maturityAmount =((amount * 8 * tenor)/100);
                else
                maturityAmount =((amount * 7 * tenor)/100);
            }
            else if(tenor>=3.0)
            {
                if(seniorCitizenChB.isSelected()==true)
                maturityAmount =((amount * 9 * tenor)/100);
                else
                maturityAmount =((amount * 8 * tenor)/100);
            }
            else
            {
                invalidInputLbl.setText("Invalid Input");
            }
            rateDisplay.setText(Double.toString(maturityAmount));
            
            
            balance = availableBalance - amount;
        
            model.setBalance(balance);
            balanceDisplay.setText(Integer.toString(balance));
            balanceDisplay.setText(Integer.toString(model.getBalance()));
            AccountSummaryController.setBalance(balance);
            AddAmountController.setBalance(balance);
            FundTransferController.setBalance(balance);
            enterAmountTxt.clear();
            enterTenorTxt.clear();
        }     
        enterAmountTxt.clear();
        enterTenorTxt.clear();
    }
     
    @FXML   
    private void viewInterestRatesAction(ActionEvent actionEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewInterestRates.fxml"));
               
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, 600,400);
        Stage stage = new Stage();
        
        // Specifies the modality for new window ( ie it should move or not)
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Interest Rate");
        stage.setScene(scene);
        stage.show();
    }
}