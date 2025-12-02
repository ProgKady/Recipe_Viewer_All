
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class CopyARecipePathController implements Initializable {

    @FXML
    private JFXButton copy;

    @FXML
    private JFXTextField src;

    @FXML
    private JFXTextField des;
    
    @FXML
    private JFXTextField namef;

    @FXML
    private JFXButton browse;
    
    @FXML
    private JFXButton desbrowse;
    
     Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  
  
  /////////////////////////////////////////////////////////////////////////
  
  @FXML
    private ComboBox stage,model;
  
  
  @FXML
    void stageaction(Event event) {
        this.stage.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Stages.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.stage.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
    }
  
    
    @FXML
    void modelaction(Event event) {
        this.model.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.model.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
    
    copy.setDisable(false);
    }
  
    
    
  /////////////////////////////////////////////////////////////////////////
  
  

    @FXML
    void browseaction(ActionEvent event) {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    String namee=f.getName();
    String nameee=f.getName().replace(".ks","").replace(".html","");
    String newpath=pathy.replace(namee,"");
    src.setText(pathy);
    namef.setText(nameee);
    
        
    }
    
    
    @FXML
    void desbrowseaction(ActionEvent event) {

    DirectoryChooser fcho = new DirectoryChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.setTitle("Kady Choose");
    File f = fcho.showDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    des.setText(pathy);
    
        
    }

    @FXML
    void copyaction(ActionEvent event) throws IOException, InterruptedException {
        
        String filenamet=namef.getText().replace(" ","_");
        String source=src.getText();
        String destination=des.getText()+"\\"+filenamet+".ks";
        String linet = "cmd /C copy /Y "+source+" "+destination;
        Process p = Runtime.getRuntime().exec(linet);
        p.waitFor(); 
        
          /////////////////////////////////////////////////////////////////////////
        
        Date currentDate = GregorianCalendar.getInstance().getTime();
        DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value0 = timeString;
    
    
    ////////////////////////////////////////////////////////////////////////////
    String stagee=stage.getSelectionModel().getSelectedItem().toString();
    String modell=model.getSelectionModel().getSelectedItem().toString();
    ////////////////////////////////////////////////////////////////////////////
    
    
    try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, value0);
      this.pst.setString(2, stagee);
      this.pst.setString(3, modell);
      this.pst.setString(4, filenamet);
      this.pst.setString(5, destination);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }    
    
    
    
    
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
     String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
              try {
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                       output.append(linee+"\n");
                   }
                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, value1);
          this.pst.setString(2, "Recipe_Maker");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Recipe_Maker is copying a recipe its name is "+filenamet+", Model is "+modell+" in "+stagee+".");
          
          this.pst.execute();
              }
              catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }  
          
          
          //////////////////////////////////////////////////////////////////////////////
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
              Notifications noti = Notifications.create();
              noti.title("Sccessful!");
              noti.text("We have copied the recipe successfully.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showInformation();
    
    
        //////////////////////////////////////////////////////////////////////////
        
        //File fpp=new File (des.getText());
        //Desktop de=Desktop.getDesktop();
        //de.open(fpp);
        Stage jk = (Stage)this.src.getScene().getWindow();
        jk.close();
        
      
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        conn = db.java_db();
        
        
    }    
    
}
