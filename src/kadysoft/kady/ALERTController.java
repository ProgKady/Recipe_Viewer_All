

package kadysoft.kady;

import com.jfoenix.controls.JFXTextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class ALERTController implements Initializable {

   
    @FXML
    public static JFXTextArea alert;
    
    public static String useb,drib;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //Read Files Here
        //Set Text Here
        
        useb=System.getProperty("user.name");
    try {
          BufferedReader buf = new BufferedReader(new FileReader("PCs\\"+useb+".kady"));
          drib=buf.readLine();
          buf.close();   
          } catch (IOException ex) {       
      //Alert
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Fatal Error");
      alert.setContentText("Fatal Error while reading user file.\nWe can't find the specified file.");
      alert.setResizable(false);
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("cupertino-dark.css").toExternalForm());
      alert.showAndWait(); 
      Stage jk = (Stage)this.alert.getScene().getWindow();
      jk.close();
          }
        
               
        alert.clear();
          
        try {
            BufferedReader buf = new BufferedReader(new FileReader(drib+":\\Models\\Recipes\\ALERT.kady"));
            String line;
            while ((line=buf.readLine())!=null) {
            alert.appendText(line);
            }
            buf.close(); 
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
            
            
    
    
    
        
        
    }    
    
}
