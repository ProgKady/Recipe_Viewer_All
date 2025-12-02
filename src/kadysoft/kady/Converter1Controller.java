/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class Converter1Controller implements Initializable {

    
    @FXML
    private JFXTextField input;

    @FXML
    private JFXButton browse1;

    @FXML
    private JFXTextField filename,date;

    @FXML
    private JFXTextField output;

    @FXML
    private JFXButton convert;

    @FXML
    private ComboBox<String> filetype,stage,model;

    @FXML
    private JFXButton browse2;
    
    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;

    @FXML
    void browse1action(ActionEvent event) {

    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLSX Files", new String[] { "*.xlsx" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLS Files", new String[] { "*.xls" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();   ///Excel File Path.
    String filenamee=dialogResult.getName().replace(".xlsx","").replace(".xls","").toString();
    input.setText(filePath);
    filename.setText(filenamee);
    
    }
    
    
    

    @FXML
    void browse2action(ActionEvent event) {

        String reppath = System.getProperty("user.home") + "\\Desktop";
        DirectoryChooser dcho=new DirectoryChooser ();
        dcho.setInitialDirectory(new File(reppath));
        File f = dcho.showDialog((Window)null);
        String pathy = f.getAbsolutePath().toString();
        output.setText(pathy);
        
    }

    @FXML
    void convertaction(ActionEvent event) throws IOException {

        String mypath,mydes,mytype,myname;
        mypath=input.getText();
        mydes=output.getText();
        mytype=filetype.getSelectionModel().getSelectedItem().toString();
        myname=filename.getText();
        
        Workbook workbook = new Workbook();
        workbook.loadFromFile(mypath);
        workbook.getConverterSetting().setSheetFitToPage(true);
        
        if (mytype.equals("CSV")) {
            workbook.saveToFile(mydes+"\\"+myname+"."+mytype, FileFormat.CSV);
            Notifications noti = Notifications.create();
            noti.title("Congratulation!");
            noti.text("Successful Conversion.");
            noti.hideAfter(Duration.seconds(3.0D));
            noti.position(Pos.CENTER);
            noti.showInformation();
            Desktop desk;
            desk=Desktop.getDesktop();
            desk.open(new File (mydes+"\\"+myname+"."+mytype));
        }
       else if (mytype.equals("KS")) {
            workbook.saveToFile(mydes+"\\"+myname+"."+"ks", FileFormat.HTML);
            /////////////////////ADD TO DB//////////////////////
            
            
            try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, date.getText());
      this.pst.setString(2, stage.getSelectionModel().getSelectedItem().toString());
      this.pst.setString(3, model.getSelectionModel().getSelectedItem().toString());
      this.pst.setString(4, filename.getText());
      this.pst.setString(5, output.getText()+"\\"+filename.getText()+".ks");
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not Revised");
      this.pst.execute();
    } catch (Exception e) {
     
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
            
            
            ////////////////////////////////////////////////////
            Notifications noti = Notifications.create();
            noti.title("Congratulation!");
            noti.text("Successful Conversion.");
            noti.hideAfter(Duration.seconds(3.0D));
            noti.position(Pos.CENTER);
            noti.showInformation();
            Desktop desk;
            desk=Desktop.getDesktop();
            desk.open(new File (mydes+"\\"+myname+"."+mytype));
        }
        else if (mytype.equals("ODS")) {
            workbook.saveToFile(mydes+"\\"+myname+"."+mytype, FileFormat.ODS);
            Notifications noti = Notifications.create();
            noti.title("Congratulation!");
            noti.text("Successful Conversion.");
            noti.hideAfter(Duration.seconds(3.0D));
            noti.position(Pos.CENTER);
            noti.showInformation();
            Desktop desk;
            desk=Desktop.getDesktop();
            desk.open(new File (mydes+"\\"+myname+"."+mytype));
        }
        else if (mytype.equals("PDF")) {
            workbook.saveToFile(mydes+"\\"+myname+"."+mytype, FileFormat.PDF);
            Notifications noti = Notifications.create();
            noti.title("Congratulation!");
            noti.text("Successful Conversion.");
            noti.hideAfter(Duration.seconds(3.0D));
            noti.position(Pos.CENTER);
            noti.showInformation();
            Desktop desk;
            desk=Desktop.getDesktop();
            desk.open(new File (mydes+"\\"+myname+"."+mytype));
        }
        else if (mytype.equals("XML")) {
            workbook.saveToFile(mydes+"\\"+myname+"."+mytype, FileFormat.XML);
            Notifications noti = Notifications.create();
            noti.title("Congratulation!");
            noti.text("Successful Conversion.");
            noti.hideAfter(Duration.seconds(3.0D));
            noti.position(Pos.CENTER);
            noti.showInformation();
            Desktop desk;
            desk=Desktop.getDesktop();
            desk.open(new File (mydes+"\\"+myname+"."+mytype));
        }
        else if (mytype.equals("XPS")) {
            workbook.saveToFile(mydes+"\\"+myname+"."+mytype, FileFormat.XPS);
            Notifications noti = Notifications.create();
            noti.title("Congratulation!");
            noti.text("Successful Conversion.");
            noti.hideAfter(Duration.seconds(3.0D));
            noti.position(Pos.CENTER);
            noti.showInformation();
            Desktop desk;
            desk=Desktop.getDesktop();
            desk.open(new File (mydes+"\\"+myname+"."+mytype));
        }
        else {
            //Notification
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Please Choose a Valid Type First.");
      noti.hideAfter(Duration.seconds(10.0D));
      noti.position(Pos.CENTER);
      noti.showInformation();
        }      

        
        
        
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
        
    }
    
    @FXML
    void onhiddenaction(Event event) {

     String hk=  filetype.getSelectionModel().getSelectedItem().toString();
       
       if (hk.equals("KS")) {
           
            date.setDisable(false);
            stage.setDisable(false);
            model.setDisable(false);
           
       }
       else {
           date.setDisable(true);
            stage.setDisable(true);
            model.setDisable(true);
           
       }
        
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        conn = db.java_db(); 
        
    filetype.getItems().addAll("CSV","KS","ODS","PDF","XML","XPS");
        
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    this.date.setText(timeString);
    stage.getItems().addAll(new String[] { "DEVELOPMENT", "PRODUCTION", "PILOT", "BLANKET", "SHRINK" });
        
    }    
    
}
