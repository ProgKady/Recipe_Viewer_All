
package kadysoft.kady;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;



/**
 * FXML Controller class
 *
 * @author KADY
 */


public class SignController implements Initializable {

   
    @FXML
    private JFXButton decrypt;

    @FXML
    private JFXTextField recipe;
    

    @FXML
    private TextArea area;

    @FXML
    private ComboBox<String> signbox;

    @FXML
    void decryptaction(ActionEvent event) throws IOException {

        String recipepath=recipe.getText();
        
        
        //Reading only
        
      try {
      InputStream instream=new FileInputStream(recipepath);  
      BufferedReader buf = new BufferedReader(new InputStreamReader (instream,"UTF-8"));
      String line;
      while ((line = buf.readLine()) != null) {
        area.appendText(line);
      } 
      buf.close();
    } 
    catch (FileNotFoundException fileNotFoundException) {
    
    }
      
      //GetText
      
      String cop=area.getText();
      
      if (cop.contains("Signature:")||cop.contains("Mr_Mohammed.png")||cop.contains("Mr_Moharam.png")) {
          //Noti
      Notifications noti = Notifications.create();
      noti.title("Hello "+System.getProperty("user.name"));
      noti.text("We think that recipe already had a signature.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
      recipe.clear();
      area.clear();
      }
      else {
           
      String signname=signbox.getSelectionModel().getSelectedItem();
      String pathtosignature="file://"+NewDir.file_dirrrrr+"\\"+signname+".png";
      OutputStream instream=new FileOutputStream(recipepath);
      PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
      pw.println(cop);
      pw.println("<b>"+signname+" Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      pw.close();
      //Desktop desk = Desktop.getDesktop();
      //desk.open(new File(recipepath));
      //Stage jk = (Stage)this.area.getScene().getWindow();
      //jk.close();
      recipe.clear();
      area.clear();
      Notifications noti = Notifications.create();
      noti.title("Hello "+System.getProperty("user.name"));
      noti.text("We added your signature successfully.");
      noti.hideAfter(Duration.seconds(2));
      noti.position(Pos.CENTER);
      noti.showInformation();
      }
      
     
        
    }
    
    @FXML
    void signboxaction(Event event) {

    
         this.signbox.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Signs.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.signbox.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
    }

    @FXML
    void recaction(MouseEvent event) {
    
    recipe.clear();
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File (NewDir.file_dir));
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    recipe.setText(filePath);
    String filenamee= dialogResult.getName().replace(".kadysoft","");
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
        
    }    
    
}
