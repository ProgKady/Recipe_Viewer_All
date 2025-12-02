/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class Converter2Controller implements Initializable {

    
    @FXML
    private JFXTextField input;

    @FXML
    private JFXButton browse1;

    @FXML
    private JFXTextField filename;

    @FXML
    private JFXTextField output,sheetnumber;

    @FXML
    private JFXButton convert;

    @FXML
    private ComboBox<String> filetype;

    @FXML
    private JFXButton browse2;

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

        String mypath,mydes,mytype,myname,mysheetnumber;
        mypath=input.getText();
        mydes=output.getText();
        mytype=filetype.getSelectionModel().getSelectedItem().toString();
        myname=filename.getText();
        mysheetnumber=sheetnumber.getText();
        int i=Integer.parseInt(mysheetnumber);
        
        Workbook workbook = new Workbook();
        workbook.loadFromFile(mypath);
        workbook.getConverterSetting().setSheetFitToPage(true);
        
        Worksheet sheet=workbook.getWorksheets().get(i);
        
        
        if (mytype.equals("JPG")) {
            sheet.saveToImage(mydes+"\\"+myname+"."+mytype);
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
       else if (mytype.equals("JPEG")) {
            sheet.saveToImage(mydes+"\\"+myname+"."+mytype);
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
        else if (mytype.equals("PNG")) {
            sheet.saveToImage(mydes+"\\"+myname+"."+mytype);
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
        else if (mytype.equals("BMP")) {
            sheet.saveToImage(mydes+"\\"+myname+"."+mytype);
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
        else if (mytype.equals("GIF")) {
            sheet.saveToImage(mydes+"\\"+myname+"."+mytype);
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
        else if (mytype.equals("ICO")) {
            sheet.saveToImage(mydes+"\\"+myname+"."+mytype);
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filetype.getItems().addAll("JPG","JPEG","PNG","BMP","GIF","ICO");
    }    
    
}
