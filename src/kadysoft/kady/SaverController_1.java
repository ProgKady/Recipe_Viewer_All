

/*
// Saver App For Recipe System.
*/


package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class SaverController_1 implements Initializable {

    
    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;
    
    @FXML
    private JFXButton save;
    
    @FXML
    private JFXTextArea code;
    
    static String filePath;
    PrintWriter pw;
       
    @FXML
    private JFXTextField date;

    @FXML
    private ComboBox<String> stage;

    @FXML
    private JFXTextField washname;

    @FXML
    private ComboBox<String> model;
    
    @FXML
    private JFXCheckBox signme;
    
    
    
    @FXML
    void shift1action(ActionEvent event) {

//      if (signme.isSelected()==false) {
//      signme.setSelected(true);
//      //Noti
//      Notifications noti = Notifications.create();
//      noti.title("Fatal Error!");
//      noti.text("It must be selected.");
//      noti.position(Pos.CENTER);
//      noti.showError();
//      }
        
    }
    
    
    
    

    @FXML
    void areaclick(MouseEvent event) {

         code.paste();
        
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
    void saveaction(ActionEvent event) throws FileNotFoundException, IOException {
   
        if (signme.isSelected()==true) {
            
            
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modelname = this.model.getSelectionModel().getSelectedItem();
            String stagename = this.stage.getSelectionModel().getSelectedItem();
            String washnamee=washname.getText().replace(" ","_");
            String datee=date.getText();
            String pathe = NewDir.file_dir;
            File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
            directory.mkdirs();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(directory);
            dialog.setInitialFileName(washnamee);
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
             if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modelname+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //////////////////////////////////////////////We will add save to db here , don't forget.
            
            String pathl=pathe + "\\" + stagename + "\\" + modelname+"\\"+washnamee+".ks";
            
     try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, datee);
      this.pst.setString(2, stagename);
      this.pst.setString(3, modelname);
      this.pst.setString(4, washnamee);
      this.pst.setString(5, pathl);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
     
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
     
       /////////////////////////////////////////////////// 
    code.clear();
    BufferedReader bi=new BufferedReader (new FileReader (filePath));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.appendText("\n"+lo
       .replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    PrintWriter pw=new PrintWriter (new FileWriter (filePath));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    code.clear();

       //////////////////////////////////////////////////
            
     
     
     
     
     
     
     
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
    
            
       ///////////////////////////////////////////////////
            
        }
        
        else {
            
            
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modelname = this.model.getSelectionModel().getSelectedItem();
            String stagename = this.stage.getSelectionModel().getSelectedItem();
            String washnamee=washname.getText().replace(" ","_");
            String datee=date.getText();
            String pathe = NewDir.file_dir;
            File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
            directory.mkdirs();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(directory);
            dialog.setInitialFileName(washnamee);
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
             if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modelname+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //////////////////////////////////////////////We will add save to db here , don't forget.
            
            String pathl=pathe + "\\" + stagename + "\\" + modelname+"\\"+washnamee+".ks";
            
     try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, datee);
      this.pst.setString(2, stagename);
      this.pst.setString(3, modelname);
      this.pst.setString(4, washnamee);
      this.pst.setString(5, pathl);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
     
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
     
     
     
     
         
               /////////////////////////////////////////////////// 
    code.clear();
    BufferedReader bi=new BufferedReader (new FileReader (filePath));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.appendText("\n"+lo
       .replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    PrintWriter pw=new PrintWriter (new FileWriter (filePath));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    code.clear();

       //////////////////////////////////////////////////
            
     
     
     
     
     
     
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
    
            
       ///////////////////////////////////////////////////
            
        }
        
         
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    conn = db.java_db(); 
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
