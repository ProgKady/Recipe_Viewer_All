
package kadysoft.kady;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class PerformanceController implements Initializable {

   
     @FXML
    void dataqueryaction(MouseEvent event) throws IOException {

        
             
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Data_Query.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Data Query");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
        
    }

    
    
    
    @FXML
    void newentryaction(MouseEvent event) throws IOException {

        
             
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("New_Entry.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("New Entry");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        
        
        
    }    
    
}
