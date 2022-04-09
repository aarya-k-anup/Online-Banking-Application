//the account summary page controller
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Button;

import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

public class HomePageController implements Initializable
{
    public static ModelClass model = new ModelClass();
  
    @FXML
    private Label accountNoDisplay;
    @FXML
    private Label balanceDisplay;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button logoutBtn;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        //Display AccountSummary FXML by default
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AccountSummaryPage.fxml");
        mainPane.setCenter(view);  
    }
    
    public static void setUserName(String userName)
    {
        model.setUserName(userName);
    }
    
     public static void setAccountNo(String accountNo)
    {
        model.setAccountNo(accountNo);
    }
    
    @FXML
    private void accountSummaryAction(ActionEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AccountSummaryPage.fxml");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void addAmountAction(ActionEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("AddAmountPage.fxml");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void transferFundAction(ActionEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("FundTransferPage.fxml");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void fixedDepositAction(ActionEvent event)
    {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("FixedDepositPage.fxml");
        mainPane.setCenter(view);
    }
    
    @FXML
    private void logoutAction(ActionEvent event) throws Exception
    {
        //to go to the page 1  scene, which is login Page
        OnlineBankingMain onlineBankingMain=new OnlineBankingMain();
        onlineBankingMain.changeScene("LoginPage.fxml"); 
        AccountSummaryController.setBalance(0);
        FundTransferController.setBalance(0);
        FixedDepositController.setBalance(0);
        AddAmountController.setBalance(0);
    }
}