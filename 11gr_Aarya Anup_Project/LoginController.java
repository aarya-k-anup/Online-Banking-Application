//login page controller

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class LoginController
{
    AccountSummaryController accountSummaryController=new AccountSummaryController();
    @FXML
    private TextField userNameTxt;
    @FXML
    private TextField accountNumberTxt;
    @FXML
    private Label loginErrorDisplayLbl;
    
    public void loginAction(ActionEvent actionEvent) throws Exception
    {
        String userName=userNameTxt.getText();
        String accountNo=accountNumberTxt.getText();
        
        
        accountSummaryController.setAccountNo(accountNo);
        
        if(userName.isEmpty() || accountNo.isEmpty()){
            loginErrorDisplayLbl.setText("Please enter in the credentials");
        }
        else
        {
            OnlineBankingMain onlineBankingMain=new OnlineBankingMain();
            onlineBankingMain.changeScene("HomePage.fxml"); 
        }
    }
}