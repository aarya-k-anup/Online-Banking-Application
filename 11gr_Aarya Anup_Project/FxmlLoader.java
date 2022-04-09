//fxml loader 
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class FxmlLoader
{
    private Pane view;
    
    public Pane getPage(String fileName)
    {
        try
        {
            URL fileUrl = OnlineBankingMain.class.getResource(fileName);
            if(fileUrl == null)
                throw new FileNotFoundException("FXML file can not be found");
            view = new FXMLLoader().load(fileUrl);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return view;
    }
}