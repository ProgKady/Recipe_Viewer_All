package kadysoft.kady;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class SettingsController implements Initializable {


    
    
     @FXML
    private JFXTextField db_field;

    @FXML
    private JFXTextArea log_area;

    @FXML
    private JFXTextField tf1;

    @FXML
    private JFXTextField tf2;

//    @FXML
//    private JFXTextField tf3;

    @FXML
    private JFXTextField tf4;

//    @FXML
//    private JFXTextField tf5;
//
//    @FXML
//    private JFXTextField tf6;

    @FXML
    private JFXTextField tf7;
    
    @FXML
    private JFXTextField tf8;

    @FXML
    private JFXTextField tf9;

//    @FXML
//    private JFXTextField tf10;

    @FXML
    private JFXTextField tf11;

    @FXML
    private JFXButton save;
    
    @FXML
    private Label note;
    
    @FXML
    private JFXRadioButton light;
    
    @FXML
    private JFXRadioButton dark;
    
    
    @FXML
    void lightaction(ActionEvent event) {
        
        tf8.setText("cupertino-light.css");
        note.setText("لوسمحت اقفل البرنامج وافتحه من تاني لتطبيق الثيم الفاتح");
        
    }
    
    
    @FXML
    void darkaction(ActionEvent event) {
        
        tf8.setText("cupertino-dark.css");
        note.setText("لوسمحت اقفل البرنامج وافتحه من تاني لتطبيق الثيم الغامق");
    }
    
    
    @FXML
    void browse1action(ActionEvent event) {

      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf1.setText(dirpathe);
        
    }

    
    
    
    @FXML
    void browse2action(ActionEvent event) {

        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf2.setText(dirpathe);
        
    }

    
    
//    
//    @FXML
//    void browse3action(ActionEvent event) {
//
//      DirectoryChooser fcho = new DirectoryChooser();
//      fcho.setTitle("Kady Choose");
//      File f = fcho.showDialog((Window)null);
//      String dirpathe = f.getAbsolutePath().toString();
//      tf3.setText(dirpathe);
//        
//        
//    }
//    
//    
    
    
    

    @FXML
    void browse4action(ActionEvent event) {

        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf4.setText(dirpathe);
        
        
    }

    
    
    
    
//    
//    
//    @FXML
//    void browse5action(ActionEvent event) {
//
//        
//      DirectoryChooser fcho = new DirectoryChooser();
//      fcho.setTitle("Kady Choose");
//      File f = fcho.showDialog((Window)null);
//      String dirpathe = f.getAbsolutePath().toString();
//      tf5.setText(dirpathe);
//        
//        
//    }
//
//    
    
    
    
//    
//    @FXML
//    void browse6action(ActionEvent event) {
//
//        
//        
//      DirectoryChooser fcho = new DirectoryChooser();
//      fcho.setTitle("Kady Choose");
//      File f = fcho.showDialog((Window)null);
//      String dirpathe = f.getAbsolutePath().toString();
//      tf6.setText(dirpathe);
//        
//        
//    }
//
//    
    
    
    
    
    
    @FXML
    void browse7action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Font Files", new String[]{"*.ttf"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      String flsdf=f.getName();
      tf7.setText(flsdf);
        
        
    }

    
    @FXML
    void browse8action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSS Files", new String[]{"*.css"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      String fsdf=f.getName();
      tf8.setText(fsdf);
      
      //change and select radio with theme
      if (fsdf.equals("cupertino-light.css")) {
          light.setSelected(true);
          dark.setSelected(false);
      }
      
      else {
          dark.setSelected(true);
          light.setSelected(false);
      }
        
        
    }

    
    @FXML
    void browse9action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf9.setText(dirpathe);
        
        
    }

    
//    @FXML
//    void browse10action(ActionEvent event) {
//
//        
//        
//      FileChooser fcho = new FileChooser();
//      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
//      fcho.setTitle("Kady Choose");
//      File f = fcho.showOpenDialog((Window)null);
//      String dirpathe = f.getAbsolutePath().toString();
//      tf10.setText(dirpathe);
//        
//        
//    }

    
    @FXML
    void browse11action(ActionEvent event) {

        
        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf11.setText(dirpathe.replace("\\","").replace(":",""));
        
        
    }
    
    
    
    
    
    @FXML
    void db_browseaction(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sqlite Files", new String[]{"*.db"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sqlite Files", new String[]{"*.sqlite"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sqlite Files", new String[]{"*.sqlite3"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      db_field.setText(dirpathe);
        
        
        
    }

    
    
    
    @FXML
    void discardction(ActionEvent event) {

        
    Stage jk = (Stage)this.save.getScene().getWindow();
    jk.close();
    
        
    }
    
    

    @FXML
    void saveaction(ActionEvent event) throws IOException {

        
        
        
        //Save Data about DB and Times
        
        String dbb=db_field.getText();
        String recdb=tf1.getText();
        String recipepathth=tf2.getText();
        String secc=tf4.getText();
        String wherh=tf7.getText();
        
        String secc1=tf8.getText();
        String mach2=tf9.getText();
        String wherh4=tf11.getText();
        
        String settingsfile=System.getProperty("user.home")+"\\setto.cfg";
        PrintWriter pp=new PrintWriter (new FileWriter (settingsfile));
        pp.println("DataBase="+dbb);
        pp.println("Recipes="+recdb);
        pp.println("Mod_Recipes="+recipepathth);
        pp.println("Recipe_System="+secc);
        pp.println("Fonts="+wherh);
        pp.println("Themes="+secc1);
        pp.println("Main_Editor="+mach2);
        pp.print("Recipes_Path="+wherh4);
        
        //Continue Saving
        
        pp.close();
        
        Notifications noti = Notifications.create();
        noti.title("Successful");
        noti.text("We have updated the settings successfully.");
        noti.hideAfter(Duration.seconds(3));
        noti.position(Pos.CENTER);
        noti.showInformation();
        
       
        
        
          ////////////////////////Audit//////////////////////////
      
  
      ///////////////////////////////////////////////////////
          
      // Example: wait 3 seconds then run code
PauseTransition pauset = new PauseTransition(Duration.seconds(2));
pauset.setOnFinished(eventy -> {
    
    Stage jk = (Stage)this.save.getScene().getWindow();
    jk.close();
    
});
pauset.play();
      

        
    }
    

    
    @FXML
    void test_dbaction(ActionEvent event) {

        
        
        
        try {
         Class.forName("org.sqlite.JDBC");
         Connection conn = DriverManager.getConnection("jdbc:sqlite:"+db_field.getText());
         if (conn != null) {
         log_area.clear();
         log_area.appendText("\nSystem DataBase Connected Successfully.\n");
         }
         } catch (Exception var1) {
         log_area.clear();
         log_area.appendText("\nConnection Failed!\n");
         }
        
        
        
        
    }
    
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////   
        public static String getValueByKey(String filePath, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                String currentKey = parts[0].trim();
                if (currentKey.equals(key)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
   db_field.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "DataBase"));
   
   tf1.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipes"));
   tf2.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Mod_Recipes"));
   tf4.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipe_System"));
   tf7.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Fonts"));
   tf8.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes"));
   tf9.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
   tf11.setText(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipes_Path"));
   
        
        
        
        try {
            String fontPath = tf7.getText(); // غيّر المسار حسب مكان الخط عندك
            javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
          
        }
        
        
        ToggleGroup tgg=new ToggleGroup();
        light.setToggleGroup(tgg);
        dark.setToggleGroup(tgg);
    
        
        
    }    
    
}
