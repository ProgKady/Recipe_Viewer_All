
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class AddLogoController implements Initializable {

    
    @FXML
    private JFXTextField pathtorecipe;

    @FXML
    private JFXButton browse;

    @FXML
    private ComboBox<String> modell;

    @FXML
    void browseaction(ActionEvent event) {

    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", new String[] { "*.*" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    pathtorecipe.setText(pathy);
    
    //Write To File 
    
    String model=modell.getSelectionModel().getSelectedItem().toString();
    
    String cood="<style>\n" +
"body { \n" +
" background-image: url(\""+model+".bmp\");\n" +
" background-position: center;\n" +
" height: 170px;\n" +
" background-position-x:550px;\n" +
" background-repeat: no-repeat;\n" +
" background-size: 120px 90px;\n" +
"}\n" +
"</style>";
    
    try {
    Files.write(Paths.get(pathtorecipe.getText()), cood.getBytes(), StandardOpenOption.APPEND);
}catch (IOException e) {
    
}
    
    //Noti
    
    
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have added the logo successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      
      pathtorecipe.clear();
      browse.setDisable(true);
      modell.getSelectionModel().clearSelection();
    
        
    }

    @FXML
    void modellhide(Event event) {

        browse.setDisable(false);
        
    }

    @FXML
    void modellshow(Event event) {

      this.modell.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.modell.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
        
    }    
    
}
