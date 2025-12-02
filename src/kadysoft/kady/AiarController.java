
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.spire.xls.ExcelVersion;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
public class AiarController implements Initializable {

    @FXML
    private JFXButton cancel;

    @FXML
    private Pane browsepane;
    
    @FXML
    private ImageView dragpane;
    
    @FXML
    private JFXTextArea coode;
    
    
    
    @FXML
    void browseaction(MouseEvent event) throws IOException, InterruptedException {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    
    
     
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
          File tw2=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
          if (!tw2.exists()) {
              tw2.createNewFile();
          }
          else {
              
          }
          
    coode.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        coode.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")        
                
               
      ); 


    }
    bi.close();
    String gf=coode.getText();
    OutputStream instreamm=new FileOutputStream(tw2);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println(""
            
             + ""
            + "<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            + ""
            + "<script>\n" +
"  \n" +
            
            
            
            "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>");
    
    pwe.println("<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>");
    
    pwe.close();
    coode.clear();
        
    Desktop gd=Desktop.getDesktop();
    gd.open(tw2);
          
    Thread.sleep(2000);
    
    PrintWriter pl=new PrintWriter(new FileWriter(tw2));
    pl.println("Powered By Kadysoft - Pilot Was Removed.");
    pl.close();
          
        
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        
    }

    
    
    
    @FXML
    void cancelaction(ActionEvent event) {

        
        Stage jk = (Stage)this.dragpane.getScene().getWindow();
        jk.close();
        
        
    }
    

    
    
    @FXML
    void dragdroppedd(DragEvent event) throws IOException, InterruptedException {

        Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    String path=db.getFiles().toString().replace("[","").replace("]","");
                    success = true;
                    
          if (path.endsWith(".html")||path.endsWith(".ks")) {
             
              
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
          File tw2=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
          if (!tw2.exists()) {
              tw2.createNewFile();
          }
          else {
              
          }
          
    coode.clear();
    InputStream inputinstream=new FileInputStream(path);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        coode.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")        
                
               
      ); 


    }
    bi.close();
    String gf=coode.getText();
    OutputStream instreamm=new FileOutputStream(tw2);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println(""
            
             + ""
            + "<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            + ""
            + "<script>\n" +
"  \n" +
            
            "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>");
    
    pwe.println("<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>");
    
    pwe.close();
    coode.clear();
        
    Desktop gd=Desktop.getDesktop();
    gd.open(tw2);
          
    Thread.sleep(2000);
    
    PrintWriter pl=new PrintWriter(new FileWriter(tw2));
    pl.println("Powered By Kadysoft - Pilot Was Removed.");
    pl.close();
          
        
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        
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
