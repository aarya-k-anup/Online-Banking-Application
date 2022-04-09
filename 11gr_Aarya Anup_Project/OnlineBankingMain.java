

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class OnlineBankingMain extends Application
{
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        stage = primaryStage;
        stage.setResizable(false);
        Parent root=FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, 800,400);
        stage.setTitle("Online Banking Application");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
    
    //general method to change the scene according to the parameter given, which is a fxml file
    public void changeScene(String fxml) throws Exception
    {
        Parent parent=FXMLLoader.load(getClass().getResource(fxml));
        
        stage.setTitle("Account Summary");
        stage.getScene().setRoot(parent);
    }
}
