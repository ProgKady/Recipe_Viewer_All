
package kadysoft.kady;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author KADY
 */


public class DecryptController implements Initializable {

   
    @FXML
    private JFXButton decrypt;

    @FXML
    private JFXTextField recipe;
    
    @FXML
    private JFXTextField filename;

    @FXML
    private TextArea area;

    @FXML
    private JFXTextField destination;

    @FXML
    void decryptaction(ActionEvent event) throws IOException {

        String recipepath=recipe.getText();
        String destinationpath=destination.getText();
        String filoname=filename.getText();
        
        //Reading only
        
      try {
      BufferedReader buf = new BufferedReader(new FileReader(recipepath));
      String line;
      while ((line = buf.readLine()) != null) {
        area.appendText(line);
      } 
      buf.close();
    } 
    catch (FileNotFoundException fileNotFoundException) {
    
    }
      
      //GetText
      
      String newcode=area.getText().replaceAll("tablee","table").replaceAll("tbodyy","tbody").replaceAll("trr","tr").replaceAll("tdd","td");
      OutputStream instream=new FileOutputStream(destinationpath+"\\"+filoname+".ks");
      PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
      pw.println(newcode);
      pw.close();
      
      //Delete Kadysoft File
      
      File del=new File (recipepath);
      del.delete();
      
      //Desktop desk = Desktop.getDesktop();
      //desk.open(new File(destinationpath+"\\"+filoname+".html"));
      
      Stage jk = (Stage)this.area.getScene().getWindow();
      jk.close();
        
    }
    
    @FXML
    void desaction(MouseEvent event) {

    destination.clear();
    DirectoryChooser dialog = new DirectoryChooser();
    dialog.setInitialDirectory(new File (NewDir.file_dir));
    dialog.setTitle("Kadysoft Ltd.");
    File dialogResult = dialog.showDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    destination.setText(filePath);
        
    }

    @FXML
    void recaction(MouseEvent event) {
    
    recipe.clear();
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File (NewDir.file_dir));
    //dialog.setInitialFileName("Kadysoft Ltd.");
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[] { "*.kadysoft" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    recipe.setText(filePath);
    String filenamee= dialogResult.getName().replace(".kadysoft","");
    filename.setText(filenamee);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
        
    }    
    
}
