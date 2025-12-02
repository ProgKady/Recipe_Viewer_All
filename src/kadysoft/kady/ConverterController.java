
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.spire.xls.ExcelVersion;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
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
public class ConverterController implements Initializable {

    @FXML
    private JFXButton cancel;

    @FXML
    private Pane browsepane;
    
    @FXML
    private ImageView dragpane;
    
    
    
    @FXML
    void browseaction(MouseEvent event) throws IOException {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    
    
    //Getting Link,.....................
    
            Workbook workbook = new Workbook();
            workbook.loadFromHtml(pathy);
            //AutoFit rows
            Worksheet sheet=workbook.getWorksheets().get(0);
            sheet.setName("Made_By_Kadysoft_Ltd");
            sheet.autoFitRow(1);
            //Save the document to file
            workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx",FileFormat.Version2016);
             
                
            Workbook wb = new Workbook();
            wb.loadFromFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx");
            Worksheet sheety = wb.getWorksheets().get(0);
            for (int i = sheety.getLastRow(); i >= 1; i--)
            {
            
       if (sheety.getRows()[i-1].isBlank())

            {

                sheety.deleteRow(i);

            }

        }

        for (int j = sheety.getLastColumn(); j >= 1; j--)

        {

            if (sheety.getColumns()[j-1].isBlank())

            {


                sheety.deleteColumn(j);

            }

        }

      wb.saveToFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx", ExcelVersion.Version2016);
      
      /////////////////////////////////////////////////////////////////
      
      Workbook workbookyy = new Workbook();
      workbookyy.loadFromFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx");
      Worksheet sheetyy = workbookyy.getWorksheets().get(0);
      sheetyy.getAutoFilters().setRange(sheet.getCellRange("A1:Z1"));
      workbookyy.saveToFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx", ExcelVersion.Version2016);
      
      /////////////////////////////////////////////////////////////////
      
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("Aiar have removed the rows and columns successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx"));
           
              /////////////////////////////////////////////////////////////////////

    
        
        
        
    }

    @FXML
    void cancelaction(ActionEvent event) {

        
        Stage jk = (Stage)this.dragpane.getScene().getWindow();
        jk.close();
        
        
    }
    

    @FXML
    void dragdroppedd(DragEvent event) throws IOException {

        Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    String path=db.getFiles().toString().replace("[","").replace("]","");
                    success = true;
                    
          if (path.endsWith(".html")||path.endsWith(".ks")) {
             
              //Convert and remove blanks here/////////////////////////////////////
              
            Workbook workbook = new Workbook();
            workbook.loadFromHtml(path);
            //AutoFit rows
            Worksheet sheet=workbook.getWorksheets().get(0);
            sheet.setName("Made_By_Kadysoft_Ltd");
            sheet.autoFitRow(1);
            //Save the document to file
            workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx",FileFormat.Version2016);
             
              ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
              
//              try {
//   XSSFWorkbook wbo = new XSSFWorkbook(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx");
//   XSSFSheet sheeto = wbo.getSheetAt(0);
//
//   //create random rows of data
//   
//
//   for (int c = 0; c < 4; c++) sheeto.autoSizeColumn(c);
//
//   int lastRow = sheeto.getLastRowNum();
//   sheeto.setAutoFilter(new CellRangeAddress(0, lastRow, 0, 3));
//
//   wbo.write(new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadyoooosoft_Ltd.xlsx"));
//   wbo.close();
//  } catch (Exception e) {
//    e.printStackTrace();
//  }
// 
//              
              
              ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
              
             
            Workbook wb = new Workbook();
            wb.loadFromFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx");
            Worksheet sheety = wb.getWorksheets().get(0);
            for (int i = sheety.getLastRow(); i >= 1; i--)
            {
            
       if (sheety.getRows()[i-1].isBlank())

            {

                sheety.deleteRow(i);

            }

        }

        for (int j = sheety.getLastColumn(); j >= 1; j--)

        {

            if (sheety.getColumns()[j-1].isBlank())

            {


                sheety.deleteColumn(j);

            }

        }

      wb.saveToFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx", ExcelVersion.Version2016);
      
      /////////////////////////////////////////////////////////////////
      
      Workbook workbookyy = new Workbook();
      workbookyy.loadFromFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx");
      Worksheet sheetyy = workbookyy.getWorksheets().get(0);
      sheetyy.getAutoFilters().setRange(sheet.getCellRange("A1:Z1"));
      workbookyy.saveToFile(System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx", ExcelVersion.Version2016);
      
      /////////////////////////////////////////////////////////////////
      
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("Aiar have removed the rows and columns successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop\\Made_By_Kadysoft_Ltd.xlsx"));
           
              /////////////////////////////////////////////////////////////////////
              
          }
         
          else {
              Notifications noti = Notifications.create();
              noti.title("Wrong Choice");
              noti.text("Choose another type of files with extension .html or .ks only");
              noti.hideAfter(Duration.seconds(3.0D));
              noti.position(Pos.CENTER);
              noti.showError();
          }
                    
                }
                event.setDropCompleted(success);
                event.consume();
        
    }

    @FXML
    void dragoverr(DragEvent event) {
        if (event.getGestureSource() != dragpane
                        && event.getDragboard().hasFiles()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }       
}
