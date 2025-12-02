
package kadysoft.kady;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.JOptionPane;

public class CVLoaderController implements Initializable {
  @FXML
  WebView webview;
  
  MenuItem m1;
  
  MenuItem m2;
  
  MenuItem m3;
  
  MenuItem m4;
  
  MenuItem m5;
  
  MenuItem m6;
  
  @FXML
  private TextArea area;
  
  String pathy;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  
  public void unsign () {
        
    }
  
  public void initialize(URL url, ResourceBundle rb) {
      
      conn = db.java_db();
      
    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    
    
    this.m1 = new MenuItem("Open Recipe");
    this.m1.setOnAction(uu -> {
        
          FileChooser fcho = new FileChooser();
          String go = NewDir.file_dir;
          fcho.setInitialDirectory(new File(go));
          fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
          fcho.setTitle("Kady Choose");
          File f = fcho.showOpenDialog((Window)null);
          pathy = f.getAbsolutePath().toString();
          /*
          ///////////////Modify DB and Signature////////////////
          
          String filename=f.getName().replace(".html","");
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          
          try {
              ////////////////////Read And Write///////////////////

              BufferedReader buf = new BufferedReader(new FileReader(pathy));
              PrintWriter pw = new PrintWriter(new FileWriter(pathy));
              String line;
    while ((line = buf.readLine()) != null)  {
      
         area.appendText(line + "\n"); 
         
    }
    area.setText(area.getText().replace("<b>Mr_Mohammed Signature: </b>",""));
    pw.println(area.getText()+"\n");
    pw.close();
    buf.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(CVLoaderController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(CVLoaderController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          /////////////////////////////////////////////////////
          
          try{
              
             String sql= "update Creation set Name='"+filename+"',Date='"+value0+"',Type='Pending',Revised_Date='Not_Revised' where Name='"+filename+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
              }catch(Exception e){    
            }
            finally {
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){
                }
          }
          //////////////////////////////////////////////////////
          
          */
          
          //////////////////////////////////////////////////////
          String newpathyy=pathy.replace(".ks", ".html");
          URI uri = Paths.get(newpathyy).toAbsolutePath().toUri();
          webview.getEngine().load(uri.toString());
          
          
          
          
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
     String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
              try {
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String line="";
                   while ((line=sNumReader.readLine())!=null) {
                       output.append(line+"\n");
                   }
                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, value1);
          this.pst.setString(2, "Someone");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Someone is editing a recipe via simple editor.");
          
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
          
          
          
        });
    
    
    this.m2 = new MenuItem("Open In Browser");
    this.m2.setOnAction(uu -> {
          String newpathyy=pathy.replace(".ks", ".html");
          Desktop des = Desktop.getDesktop();
          try {
            des.open(new File(newpathyy));
          } catch (IOException iOException) {}
        });
    
    this.m3 = new MenuItem("Exit");
    this.m3.setOnAction(uu -> System.exit(0));
    this.m5 = new MenuItem("Increase Scale");
    this.m5.setOnAction(uu -> this.webview.setFontScale(this.webview.getFontScale() + 1.0D));
    this.m6 = new MenuItem("Decrease Scale");
    this.m6.setOnAction(uu -> this.webview.setFontScale(this.webview.getFontScale() - 1.0D));
    
    this.m4 = new MenuItem("Print Recipe");
    this.m4.setOnAction(uu -> {
        
        PrinterJob job = PrinterJob.createPrinterJob();
        job.showPageSetupDialog(null);
        job.showPrintDialog(null);
        this.webview.getEngine().print(job);
        job.endJob();
            
        });
    
    ContextMenu cm = new ContextMenu();
    cm.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
    cm.getItems().addAll(new MenuItem[] { this.m1, this.m4, this.m5, this.m6, this.m3 });
    this.webview.setContextMenuEnabled(false);
    this.webview.setOnMousePressed(e -> {
          if (e.getButton() == MouseButton.SECONDARY) {
            cm.show(this.webview, e.getSceneX(), e.getSceneY());
          } else {
            cm.hide();
          } 
        });
    
    
    this.webview.setOnKeyReleased(gg -> {
          String code = (String)this.webview.getEngine().executeScript("document.documentElement.outerHTML");
          try {
              
            OutputStream instream=new FileOutputStream(pathy);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println();
            pw.print(code);
            pw.close();
          } catch (IOException iOException) {}
        });
    
    
  }
}