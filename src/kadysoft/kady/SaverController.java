

/*
// Saver App For Recipe System.
*/


package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
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
public class SaverController implements Initializable {

    
    @FXML
    private JFXButton save;
    
    @FXML
    private JFXTextArea code;
    
    @FXML
    private ComboBox<String> modell;
    
    @FXML
    private JFXCheckBox signme;
    

    static String filePath;
    PrintWriter pw;
    
    
    
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
    void modellrel(Event event) {

         this.modell.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.modell.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        
    }
    
    
    @FXML
    void modellhide(Event event) {

        save.setDisable(false);
        
        
    }

    
    
    
    
    @FXML
    void saveaction(ActionEvent event) throws FileNotFoundException, IOException {
/*
        //Getting File Link
        String filelink="Z:\\Recipe_System\\Editor\\index.html";  // It will Change For Every User   (NOTES).
        
        BufferedReader buf = new BufferedReader(new FileReader(filelink));
        String line = null;
        while ((line = buf.readLine()) != null) {
       
          
          System.out.println();
          
        } 
        buf.close();
      */  
       ////////////////////////////////////////////////// 
   /*     
    File file = new File("Z:\\Recipe_System\\Editor\\index.html");
    Scanner scanner = null;
    String line = "";

    // access file
    try {
        scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        return; // don't continue if the file is not found
    }

    // if more lines in file, go to next line
    Boolean started = false;
    
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File("Z:\\Recipe_System\\Recipes"));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
    
    while (scanner.hasNext()) {
        line = scanner.nextLine();

        if (line.equals("</tbody></table></center>\n" +
"</body></html>")) {
            started = false;
            // if you also immediately want to go out of the loop,
            // un-comment the following line:
            // break;
        }

        
            
        
        if (started) // tag in the txt to locate position
        {
            
            
            
            pw.println(line);
            
           
            
          //  System.out.println(line);
            
        }

        if (line.equals("<html lang=\"en-US\" contenteditable=\"\"><head>")) {
            started = true;
        }
    }
    scanner.close();
    pw.close();
    // Desktop
    
    Desktop desk = Desktop.getDesktop();
    desk.open(new File (filePath));
    
      Stage jk = (Stage)this.save.getScene().getWindow();
      jk.close();
       */
   
   
   if (signme.isSelected()==true) {
       
       
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=modell.getSelectionModel().getSelectedItem().toString();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(NewDir.file_dir));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
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
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
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
   
       //////////////////////////////////////////////////
       
   }
   
   
   else {
       
       
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=modell.getSelectionModel().getSelectedItem().toString();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(NewDir.file_dir));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
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
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
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
   
       ///////////////////////////////////////////////////
   }
   
   
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
