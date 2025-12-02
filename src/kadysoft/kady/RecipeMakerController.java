package kadysoft.kady;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperPrint;
import org.controlsfx.control.Notifications;

public class RecipeMakerController   <T extends Comparable<T>> implements Initializable {
    
  public static String filePath;
  
  public static String contentpath;
  
  @FXML
  private MenuItem createnewrecipe;
  
  @FXML
  private MenuItem openoldrecipe;
  
  @FXML
  private MenuItem editedit;
  
  @FXML
  private MenuItem exceltohtml;
  
  @FXML
  private Menu editmenu;
  
  @FXML
  private Menu filemenu;
  
  @FXML
  private MenuItem exit;
  
  @FXML
    private MenuItem editorprint;
  
  @FXML
  private MenuItem savetohtml;
  
  @FXML
  private MenuItem exporttoexcel;
  
  @FXML
  private MenuItem viewrecipes;
  
  @FXML
  private MenuItem openrecipesfolder;
  
  @FXML
  private MenuItem audit;
  
  @FXML
  private MenuItem copyarecipe;
  
  @FXML
  public JFXTextArea textarea;
  
  @FXML
  public TextArea water;
  
  @FXML
  public TextArea chemicals;
  
  @FXML
  private ComboBox<String> actionname;
  
  @FXML
  private ComboBox<String> chemical;
  
  @FXML
  private ComboBox<String> chemicalsign;
  
  @FXML
  private ComboBox<String> stage;
  
  @FXML
  private ComboBox<String> model;
  
  @FXML
  private ComboBox<String> units;
  
  @FXML
  private JFXTextField chemicallot;
  
  @FXML
  private JFXCheckBox control;
  
  @FXML
  private JFXCheckBox nochemicals;
  
  public static File costsfolder;
  
  public static File watercost;
  
  public static File chemicalscost;
  
  @FXML
  private JFXTextField time;
  
  @FXML
  private JFXTextField notes;
  
  @FXML
  private JFXTextField temprature;
  
  @FXML
  private JFXTextField handcode;
  
  @FXML
  private JFXTextField whiskercode;
  
  @FXML
  private JFXTextField amount;
  
  @FXML
  private JFXTextField liters;
  
  @FXML
  private HBox createpane;
  
  @FXML
  private JFXTextField date;
  
  @FXML
  private JFXTextField washname;
  
  @FXML
  private JFXTextField kg;
  
  @FXML
  private JFXTextField pcs;
  
  @FXML
  private JFXTextField customer;
  
  @FXML
  private JFXTextField stylename;
  
  @FXML
  private JFXButton createbtn;
  
  @FXML
  private JFXButton addstep;
  
  @FXML
  private JFXButton emptyrow;
  
  @FXML
  private JFXButton notesrow;
  
  @FXML
  private HBox buttonspane;
  
  @FXML
  private JFXButton editrecipe;
  
  @FXML
  private JFXButton saveme;
  
  @FXML
  private JFXButton noty;
  
  @FXML
  private JFXButton preview;
  
  @FXML
  private MenuItem editadv;
  
  @FXML
  private MenuItem about;
  
  @FXML
  private MenuItem selectall;
  
  @FXML
  private MenuItem undo;
  
  @FXML
  private MenuItem redo;
  
  @FXML
  private MenuItem cut;
  
  @FXML
  private MenuItem copy;
  
  @FXML
  private MenuItem paste;
  
  @FXML
  private MenuItem logout;
  
  @FXML
  private MenuItem clearall;
  
  @FXML
  private MenuItem saverecipe;
  
  @FXML
  private WebView view;
  
  JasperPrint jasperPrint;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  int i = 1;
  
  
  @FXML
    void editorprintaction(ActionEvent event) throws FileNotFoundException, IOException {

        FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\index.html"));
    pw.append("<html lang=\"en\">\n<head>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line + "\n"); 
     
    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>");
    
    
    
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\index.html"));
        
    }
  
  @FXML
  void auditaction(ActionEvent event) throws IOException {
      
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Audit_Window.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Audit Viewer");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
      
  }
  
  @FXML
  void exporttoexcelaction(ActionEvent event) throws FileNotFoundException, IOException  {
      
       FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Recipes2Excel\\index.html"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"	<head>\n" +
"		<title>Kadysoft Ltd.</title>\n" +
"		<link rel=\"stylesheet\" href=\"style.css\" />\n" +
"	</head>\n" +
"	<body>\n" +
"		<div>"
            + ""
            + ""
            + "");
    String line;
    while ((line = buf.readLine()) != null)  {
      pw.append(line); 
   
    }
     pw.append("<input type=\"button\" value=\"export\" onclick=\"exportToExcel('exTable')\" />\n" +
"		</div>\n" +
"		<script src=\"exportToExcel.js\" defer></script>\n" +
"	</body>\n" +
"</html>");
    
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Recipes2Excel\\index.html"));
    
     
      
  }
  
  
  @FXML
  void openrecipesfolderaction(ActionEvent event) throws IOException {
      
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (NewDir.file_dir));
      
  }
  
  @FXML
  void copyarecipeaction(ActionEvent event) throws IOException {
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CopyARecipe.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Recipe Copier ...");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
  }
  
  @FXML
  void saverecipeaction(ActionEvent event) throws IOException {
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Saver.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Recipe Saver ...");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
  }
  
  @FXML
  void whiskeraction(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.handcode.requestFocus(); 
  }
  
  @FXML
  void handaction(KeyEvent event) {
    this.filemenu.show();
  }
  
  @FXML
  void exceltohtmlaction(ActionEvent event) throws IOException {
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\ExcelToHTML\\index.html"));
    this.savetohtml.setDisable(false);
  }
  
  @FXML
  void savetohtmlaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Saver_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Save To HTML");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  }
  
  @FXML
  void viewrecipesaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Viewer_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipes Explorer");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  }
  
  @FXML
  void viewre(KeyEvent event) throws IOException {
      
     /*
    String p1 = NewDir.file_dir;
    String p2 = this.customer.getText();
    String p3 = this.washname.getText().replace(" ", "_");
    String stagename = this.stage.getSelectionModel().getSelectedItem();
    String code = (String)this.view.getEngine().executeScript("document.documentElement.outerHTML");
    File gk = new File(p1 + "\\" + stagename + "\\" + p2 + "\\" + p3 + ".html");
    gk.createNewFile();
    try {
      PrintWriter pw = new PrintWriter(new FileWriter(gk));
      pw.println();
      pw.print(code);
      pw.close();
    } catch (IOException iOException) {}
    
    */
  }
  
  @FXML
  void logoutaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("LogIn_GUI.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("LogIn Window");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    Stage jk = (Stage)this.createbtn.getScene().getWindow();
    jk.close();
    
    
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
          this.pst.setString(2, "Developer");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Developer Logged Out.");
          
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
          
          
    
  }
  
  @FXML
  void modelaction(ActionEvent event) {
    this.model.getSelectionModel().getSelectedItem();
    this.filemenu.setDisable(false);
    this.customer.setText(this.model.getSelectionModel().getSelectedItem());
  }
  
  @FXML
  void modelsaction(Event event) {
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
  void actionsaction(Event event) {
    this.actionname.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Action_Names.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.actionname.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
  }
  
  @FXML
  void chenameaction(Event event) throws IOException {
   
    TextField filter = this.chemical.getEditor();
    String filtertext = filter.getText();
    
    if (filtertext.isEmpty()) {
        
        try {
            this.chemicalsign.getItems().clear();
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Names.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        String cap = filtertext.toUpperCase();
        if (line.contains(cap))
          this.chemicalsign.getItems().addAll(new String[] { line }); 
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
        
    }
        
    }
    
    else {
         try {
             
             this.chemicalsign.getItems().clear();
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\FormulasNames.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        if (line.contains(filtertext))
          this.chemicalsign.getItems().addAll(new String[] { line.replace(filtertext + "=", "") }); 
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
    }
    
   
  }
  
  @FXML
  void chemicalhide(Event event) {
      
      if (chemical.getSelectionModel().getSelectedItem()!=null) {
           String fill = ((String)this.chemicalsign.getSelectionModel().getSelectedItem()).toString();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\FormulasLot.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        if (line.contains(fill)) {
          String newtype = line.replace(fill + "=", "");
          this.chemicallot.setText(newtype);
        } 
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
      }
      
      else {
          
          
      }
      
   
  }
  
  @FXML
  void desaction(Event event) {
    this.chemical.getItems().clear();
    TextField filter = this.chemical.getEditor();
    String filtertext = filter.getText();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Des.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        String cap = filtertext.toUpperCase();
        if (line.contains(cap))
          this.chemical.getItems().addAll(new String[] { line }); 
      } 
      buf.close();
    } 
    catch (FileNotFoundException fileNotFoundException) {
    
    }
    catch (IOException iOException) {}
    TextField mll = this.chemical.getEditor();
    String chemicall = mll.getText();
  }
  
  @FXML
  void createbtn(ActionEvent event) throws IOException {
    String datee = this.date.getText();
    String washnamee = this.washname.getText().replace(" ","_");
    String kgg = this.kg.getText();
    String pcss = this.pcs.getText();
    String customerr = this.customer.getText();
    String stylenamee = this.stylename.getText();
    String modell = ((String)this.model.getSelectionModel().getSelectedItem()).toString();
    String stagee = ((String)this.stage.getSelectionModel().getSelectedItem()).toString();
    String whiskerr = this.whiskercode.getText();
    String handd = this.handcode.getText();
    this.editmenu.setVisible(true);
    if (modell.equals("NoThing")) {
      this.textarea.clear();
      this.textarea.appendText("<html lang=\"en-US\" contenteditable>\n<!DOCTYPE html>\n<html lang=\"en-US\" contenteditable>\n<head>\n<title>Brought To You By Kadysoft Ltd.</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body>\n\n");
      this.textarea.appendText("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
      this.textarea.appendText("<center><table id=\"exTable\" style=\"width: 1053px; height: 150px; text-align: center; border: 1px solid black; margin-left: -0.274977%;\"><tbody>\n\n<tr>\n\n\n\t<td style=\"width: 9.89918%; text-align: center; background-color: rgb(255, 153, 0); border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Stage</strong></span></td>\n\t<td style=\"width: 23.4647%; background-color: rgb(255, 153, 0); border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + stagee + " Recipe</strong></td>\n\t<td style=\"width: 8.45204%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 8.73694%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 16.1443%; border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><strong style=\"font-size: 12px;\">Date :&nbsp;</strong></td>\n\t<td style=\"width: 30.8642%; border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + datee + "</strong></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Cust :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + customerr + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Wash Name :</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + washnamee + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO No :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO Amount</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">KG</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + kgg + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Style Name</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + stylenamee + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Machine No</strong></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><strong style=\"font-size: 12px;\">Spining</strong></td>\n\n\n\n<td style=\"width: 8.92688%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Dryer No</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">PCS:</strong></span></td>\n\t<td colspan=\"3\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + pcss + "</strong></span></td></tr><tr>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Stage</strong></span></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + stagee + "</strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Action No</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Action Name</strong></td><td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Time(MIN)</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Temp</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Liters</strong></td><td style=\"width: 7.21747%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Amt</strong></td><td style=\"width: 6.83761%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Units</strong></td><td style=\"width: 14.5299%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Description</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Name</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical LOT No</strong></td>\n\n\t\n\n\n\t</tr><tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t\n\n\n\t</tr>\n\n\n\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>Whisker</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS " + whiskerr + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10.0148%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>Hand Sand</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS " + handd + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\" text-align: center; width: 10.0148%;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td></tr>\n\n\n");
      this.buttonspane.setVisible(true);
      this.view.setVisible(true);
      this.view.getEngine().loadContent(this.textarea.getText());
      this.actionname.setDisable(false);
      this.time.setDisable(false);
      this.control.setDisable(false);
      this.temprature.setDisable(false);
      this.liters.setDisable(false);
      this.amount.setDisable(false);
      this.units.setDisable(false);
      this.chemical.setDisable(false);
      this.chemicalsign.setDisable(false);
      this.chemicallot.setDisable(false);
      this.textarea.setDisable(false);
      this.nochemicals.setDisable(false);
      //////////Creating Costs//////////////
      
//      costsfolder=new File (NewDir.file_dirrrr+"\\"+"Costs"+"\\"+stagee+"\\"+modell+"\\"+washnamee);
//      costsfolder.mkdirs();
//      watercost=new File (costsfolder+"\\"+"Water.kady");
//      chemicalscost=new File (costsfolder+"\\"+"Chemicals.kady");
//      watercost.createNewFile();
//      chemicalscost.createNewFile();
      
      
      //////////////////////////////////////
      
    } else {
      this.textarea.clear();
      this.textarea.appendText("<html lang=\"en-US\" contenteditable>\n<!DOCTYPE html>\n<html lang=\"en-US\" contenteditable>\n<head>\n<title>Brought To You By Kadysoft Ltd.</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body>\n\n");
      this.textarea.appendText("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
      this.textarea.appendText("<center><table  id=\"exTable\" style=\"width: 1053px; height: 150px; text-align: center; border: 1px solid black; margin-left: -0.274977%;\"><tbody>\n\n<tr>\n\n\n\t<td style=\"width: 9.89918%; text-align: center; background-color: rgb(255, 153, 0); border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Stage</strong></span></td>\n\t<td style=\"width: 23.4647%; background-color: rgb(255, 153, 0); border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + stagee + " Recipe</strong></td>\n\t<td style=\"width: 8.45204%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 8.73694%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 16.1443%; border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><strong style=\"font-size: 12px;\">Date :&nbsp;</strong></td>\n\t<td style=\"width: 30.8642%; border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + datee + "</strong></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Cust :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + customerr + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Model  Logo : <img src=\"" +"file://"+NewDir.file_dirrr + "\\" + modell + ".bmp\" width=\"100\" height=\"100\"></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Wash Name :</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + washnamee + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO No :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO Amount</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">KG</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + kgg + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Style Name</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + stylenamee + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Machine No</strong></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><strong style=\"font-size: 12px;\">Spining</strong></td>\n\n\n\n<td style=\"width: 8.92688%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Dryer No</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">PCS:</strong></span></td>\n\t<td colspan=\"3\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + pcss + "</strong></span></td></tr><tr>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"></strong></span></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"></strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Action No</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Action Name</strong></td><td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Time(MIN)</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Temp</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Liters</strong></td><td style=\"width: 7.21747%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Amt</strong></td><td style=\"width: 6.83761%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Units</strong></td><td style=\"width: 14.5299%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Description</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Name</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical LOT No</strong></td>\n\n\t\n\n\n\t</tr><tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t\n\n\n\t</tr>\n\n\n\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 229, 153); border: 1px solid rgb(152, 0, 0);\"><strong>Whisker</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS " + whiskerr + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10.0148%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 229, 153); border: 1px solid rgb(152, 0, 0);\"><strong>Hand Sand</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS " + handd + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\" text-align: center; width: 10.0148%;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\" width: 10%;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td></tr>\n\n\n\n");
      this.buttonspane.setVisible(true);
      this.view.setVisible(true);
      this.view.getEngine().loadContent(this.textarea.getText());
      this.actionname.setDisable(false);
      this.time.setDisable(false);
      this.control.setDisable(false);
      this.temprature.setDisable(false);
      this.liters.setDisable(false);
      this.amount.setDisable(false);
      this.units.setDisable(false);
      this.chemical.setDisable(false);
      this.chemicalsign.setDisable(false);
      this.chemicallot.setDisable(false);
      this.textarea.setDisable(false);
      this.nochemicals.setDisable(false);
      
      //////////Creating Costs//////////////
      
//      costsfolder=new File (NewDir.file_dirrrr+"\\"+"Costs"+"\\"+stagee+"\\"+modell+"\\"+washnamee);
//      costsfolder.mkdirs();
//      watercost=new File (costsfolder+"\\"+"Water.kady");
//      chemicalscost=new File (costsfolder+"\\"+"Chemicals.kady");
//      watercost.createNewFile();
//      chemicalscost.createNewFile();
      
      
      //////////////////////////////////////
      
    }
    
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
          this.pst.setString(2, "Developer");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Developer is creating a new recipe via system.");
          
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
          
          
    
    
    
  }
  
  @FXML
  void editrecipeaction(ActionEvent event) {
    this.textarea.setEditable(true);
    this.textarea.setVisible(true);
    this.editmenu.setVisible(true);
  }
  
  @FXML
  void notyaction(ActionEvent event) {
    String op = this.notes.getText();
    int pos = this.textarea.getCaretPosition();
    this.textarea.insertText(pos, "<!--Add Notes Row-->");
    this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>Notes :&nbsp;</strong></td>\n\t<td colspan=\"10\" style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 60px;\">" + op + "</strong></td>\n\t\n\t\n\t</tr>\n\n\n");
    this.view.getEngine().loadContent(this.textarea.getText());
    this.notes.clear();
  }
  
  @FXML
  void previewaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Preview.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipe Preview");
    stg.centerOnScreen();
    stg.setResizable(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();
    Stage jk = (Stage)this.textarea.getScene().getWindow();
  }
  
  @FXML
  void savemeaction(ActionEvent event) throws IOException {
    String modelname = this.model.getSelectionModel().getSelectedItem();
    String stagename = this.stage.getSelectionModel().getSelectedItem();
    String pathe = NewDir.file_dir;
    File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
    if (!directory.exists())
      directory.mkdirs(); 
    String nami = this.washname.getText().replace(" ", "_");
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(directory);
    dialog.setInitialFileName(nami);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    File dialogResult = dialog.showSaveDialog(null);
    filePath = dialogResult.getAbsolutePath().toString();
    contentpath = filePath;
    String code = this.textarea.getText();
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
    pw.println(code);
    pw.close();
    this.preview.setDisable(false);
    String stg = this.stage.getSelectionModel().getSelectedItem();
    String mod = this.model.getSelectionModel().getSelectedItem();
    String washn = this.washname.getText().replace(" ", "_");
    String pathu1 = NewDir.file_dir;
    String pathu2 = pathu1 + "\\" + stg + "\\" + mod + "\\" + washn + ".html";
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value1 = dateString;
    try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, value0);
      this.pst.setString(2, stg);
      this.pst.setString(3, mod);
      this.pst.setString(4, washn);
      this.pst.setString(5, pathu2);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not Revised");
      this.pst.execute();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
    
    
  }
  
  @FXML
  void areaclick(MouseEvent event) throws IOException {
      
     Alert al=new Alert (AlertType.WARNING);
     al.setTitle("Warning!!!!!!");
     al.setResizable(false);
     al.setHeaderText("Warning!!!!!!");
     al.setContentText("Please, Don't touch me.\nممنوع اللمس في حاجة اسمها بوج");
     al.showAndWait();
      
  /*  this.view.getEngine().loadContent(this.textarea.getText());
    String code = this.textarea.getText();
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
    pw.println(code);
    pw.close();*/
  }
  
  @FXML
  void areaaction(KeyEvent event) throws IOException {
    this.view.getEngine().loadContent(this.textarea.getText());
    String code = this.textarea.getText();
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
    pw.println(code);
    pw.close();
  }
  
  @FXML
  void stageaction(ActionEvent event) {
    this.model.setDisable(false);
    this.model.show();
  }
  
  @FXML
  void createnewrecipeaction(ActionEvent event) throws IOException {
    if (!this.textarea.getText().isEmpty()) {
      Stage jk = (Stage)this.createbtn.getScene().getWindow();
      jk.close();
      Stage stg = new Stage();
      Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeMaker_1.fxml"));
      Scene sce = new Scene(root);
      sce.getStylesheets().add("table-cell-color-example.css");
      stg.setTitle("Developer Controller");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.centerOnScreen();
      stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
      stg.show();
    } else {
      this.createpane.setVisible(true);
      this.date.requestFocus();
      String cus = this.model.getSelectionModel().getSelectedItem();
      this.customer.setText(cus);
    } 
  }
  
  @FXML
  void editeditaction(ActionEvent event) throws FileNotFoundException, IOException {
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\index.html"));
    pw.append("<html lang=\"en\">\n<head>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = buf.readLine()) != null)
        
      pw.append(line.replace(" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd.\" style=\"border-color:black;border-width:10px;\">","").replace("<b>Mr_Moharam Signature: </b><img src=\"file://Z:\\Models\\Mr_Moharam.png\"","").replace("<b>Mr_Mohammed Signature: </b><img src=\"file://Z:\\Models\\Mr_Mohammed.png\"","") + "\n"); 
    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>");
    
    
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\index.html"));
    
     ///////////////Modify DB and Signature////////////////
          
          String filename=f.getName().replace(".html","");
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
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
          
          
          
          //////////////////////////////////////////////////////
    
    this.saverecipe.setDisable(false);
    
    
    
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
          this.pst.setString(2, "Developer");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Developer is editing a recipe via advanced editor.");
          
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
          
          
    
  }
  
  @FXML
  void openoldrecipeaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CVLoader.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Modify Old Recipe");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  //  Stage jk = (Stage)this.textarea.getScene().getWindow();
  }
  
  @FXML
  void addstepaction(ActionEvent event) throws IOException {
    if (this.nochemicals.isSelected()) {
      String action = ((String)this.actionname.getSelectionModel().getSelectedItem()).toString();
      String tim = this.time.getText();
      String temp = this.temprature.getText();
      String litr = this.liters.getText();
      int pos = this.textarea.getCaretPosition();
      this.textarea.insertText(pos, "<!--Adding Step-->");
      this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + this.i++ + "</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + action + "</strong></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + tim + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + temp + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + litr + "</strong></span></td>\n\t<td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n</tr>\n\n\n\n\n");
      this.view.getEngine().loadContent(this.textarea.getText());
      this.actionname.requestFocus();
      this.actionname.show();
      chemical.getItems().clear();
      chemicalsign.getItems().clear();
      chemicallot.clear();
      /*
      water.appendText(action+"="+litr+"\n");
      String newval=water.getText();
      PrintWriter pw = new PrintWriter(new FileWriter(watercost));
      pw.print(newval);
      pw.close();
      // No Chemicals Here
      */
      
      
    } else {
      if (((String)this.actionname.getSelectionModel().getSelectedItem()).toString().equals("RINSE")) {
        this.chemical.getSelectionModel().select(" ");
        TextField ml = this.chemical.getEditor();
        ml.setText(" ");
        this.chemicalsign.getSelectionModel().select(" ");
        this.chemicallot.setText(" ");
        this.amount.setText(" ");
        this.units.getSelectionModel().select(" ");
        String tim = this.time.getText();
        String temp = this.temprature.getText();
        String litr = this.liters.getText();
        int pos = this.textarea.getCaretPosition();
        this.textarea.insertText(pos, "<!--Adding Step-->");
        this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + this.i++ + "</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">RINSE</strong></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + tim + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + temp + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + litr + "</strong></span></td>\n\t<td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n</tr>\n\n\n\n\n");
        this.view.getEngine().loadContent(this.textarea.getText());
        this.actionname.requestFocus();
        this.actionname.show();
        chemical.getItems().clear();
        chemicalsign.getItems().clear();
        chemicallot.clear();
        /*
        water.appendText("RINSE"+"="+litr+"\n");
        String newval=water.getText();
        PrintWriter pw = new PrintWriter(new FileWriter(watercost));
        pw.print(newval);
        pw.close();
        // No Chemicals Here
        */
      
        
      }
      
      else if (((String)this.actionname.getSelectionModel().getSelectedItem()).toString().equals(" ")) {
        this.time.setText("");
        this.temprature.setText("");
        this.liters.setText("");
        String amt = this.amount.getText();
        String unitt = ((String)this.units.getSelectionModel().getSelectedItem()).toString();
        TextField mll = this.chemical.getEditor();
        String chemicall = mll.getText();
        String chemicalsi = ((String)this.chemicalsign.getSelectionModel().getSelectedItem()).toString();
        String chemicallott = this.chemicallot.getText();
        int pos = this.textarea.getCaretPosition();
        this.textarea.insertText(pos, "<!--Adding Step-->");
        this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + this.i++ + "</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\"></strong></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong></strong></span></td>\n\t<td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + amt + "</strong></span></td>\n\t<td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + unitt + "</strong></span></td>\n\t<td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicall + "</strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicalsi + "</strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicallott + "</strong></span></td>\n</tr>\n\n\n\n\n");
        this.view.getEngine().loadContent(this.textarea.getText());
        this.actionname.requestFocus();
        this.actionname.show();
        chemical.getItems().clear();
        chemicalsign.getItems().clear();
        chemicallot.clear();
        /*
        //Chemicals
        water.appendText(action+"="+litr+"\n");
        String newval=water.getText();
        PrintWriter pw = new PrintWriter(new FileWriter(watercost));
        pw.print(newval);
        pw.close();*/
        
      } 
      
      if (this.control.isSelected()) {
        String action = ((String)this.actionname.getSelectionModel().getSelectedItem()).toString();
        String tim = this.time.getText();
        String temp = this.temprature.getText();
        String litr = this.liters.getText();
        String amt = this.amount.getText();
        String unitt = ((String)this.units.getSelectionModel().getSelectedItem()).toString();
        TextField mll = this.chemical.getEditor();
        String chemicall = mll.getText();
        String chemicalsi = ((String)this.chemicalsign.getSelectionModel().getSelectedItem()).toString();
        String chemicallott = this.chemicallot.getText();
        int pos = this.textarea.getCaretPosition();
        this.textarea.insertText(pos, "<!--Adding Step-->");
        this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + this.i++ + "</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + action + "</strong></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + tim + " CONT</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + temp + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + litr + "</strong></span></td>\n\t<td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + amt + "</strong></span></td>\n\t<td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + unitt + "</strong></span></td>\n\t<td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicall + "</strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicalsi + "</strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicallott + "</strong></span></td>\n</tr>\n\n\n\n\n");
        this.view.getEngine().loadContent(this.textarea.getText());
        this.actionname.requestFocus();
        this.actionname.show();
        chemical.getItems().clear();
        chemicalsign.getItems().clear();
        chemicallot.clear();
        
        /*
        
        water.appendText(action+"="+litr+"\n");
        String newval=water.getText();
        PrintWriter pw = new PrintWriter(new FileWriter(watercost));
        pw.print(newval);
        pw.close();
        //Chemicals
        water.appendText(action+"="+litr+"\n");
        String newval=water.getText();
        PrintWriter pw = new PrintWriter(new FileWriter(watercost));
        pw.print(newval);
        pw.close();
*/
      
      } else {
        String action = ((String)this.actionname.getSelectionModel().getSelectedItem()).toString();
        String tim = this.time.getText();
        String temp = this.temprature.getText();
        String litr = this.liters.getText();
        String amt = this.amount.getText();
        String unitt = ((String)this.units.getSelectionModel().getSelectedItem()).toString();
        TextField mll = this.chemical.getEditor();
        String chemicall = mll.getText();
        String chemicalsi = ((String)this.chemicalsign.getSelectionModel().getSelectedItem()).toString();
        String chemicallott = this.chemicallot.getText();
        int pos = this.textarea.getCaretPosition();
        this.textarea.insertText(pos, "<!--Adding Step-->");
        this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + this.i++ + "</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 14px;\">" + action + "</strong></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + tim + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + temp + "</strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + litr + "</strong></span></td>\n\t<td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + amt + "</strong></span></td>\n\t<td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + unitt + "</strong></span></td>\n\t<td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicall + "</strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicalsi + "</strong></span></td>\n\t<td style=\"width: 18.7085%; background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 14px;\"><strong>" + chemicallott + "</strong></span></td>\n</tr>\n\n\n\n\n");
        this.view.getEngine().loadContent(this.textarea.getText());
        this.actionname.requestFocus();
        this.actionname.show();
        chemical.getItems().clear();
        chemicalsign.getItems().clear();
        chemicallot.clear();
        /*
        water.appendText(action+"="+litr+"\n");
        String newval=water.getText();
        PrintWriter pw = new PrintWriter(new FileWriter(watercost));
        pw.print(newval);
        pw.close();
        //Chemicals
        water.appendText(action+"="+litr+"\n");
        String newval=water.getText();
        PrintWriter pw = new PrintWriter(new FileWriter(watercost));
        pw.print(newval);
        pw.close();
      */
      } 
    } 
  }
  
  @FXML
  void emptyrowaction(ActionEvent event) {
    int pos = this.textarea.getCaretPosition();
    this.textarea.insertText(pos, "<!--Add Empty Row-->");
    this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t</tr>\n\n\n\n");
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void notesrowaction(ActionEvent event) {
    String notee = this.notes.getText();
    int pos = this.textarea.getCaretPosition();
    this.textarea.insertText(pos, "<!--Add Notes Comment-->");
    this.textarea.insertText(pos, "<tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td><td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"background-color: rgb(255, 255, 0); border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong>" + notee + "</strong><br></td>\n\t<td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t</tr>\n\n\n\n");
    this.view.getEngine().loadContent(this.textarea.getText());
    this.notes.clear();
  }
  
  @FXML
  void exitaction(ActionEvent event) {
    Platform.exit();
  }
  
  @FXML
  void aboutaction(ActionEvent event) throws IOException, DocumentException {
    Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
    ImageView imgview = new ImageView();
    imgview.setImage(img);
    Notifications noti = Notifications.create();
    noti.title("About Me");
    noti.text("Hi, I'am Ahmed Elkady :) \nMade with love by Kadysoft Ltd.");
    noti.hideAfter(Duration.minutes(1.0D));
    noti.graphic(imgview);
    noti.position(Pos.CENTER);
    noti.show();
  }
  
  @FXML
  void editadvaction(ActionEvent event) throws FileNotFoundException, IOException {
    if (this.textarea.getText().contains("table")) {
      this.textarea.setVisible(true);
      int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to open another recipe to edit?\nYou will lose that one, Save it first please.", "Edit New Recipe", 0);
      if (p == 0) {
        this.textarea.clear();
        this.view.getEngine().load("");
        FileChooser fcho = new FileChooser();
        String go = NewDir.file_dir;
        fcho.setInitialDirectory(new File(go));
        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
        fcho.setTitle("Kady Choose");
        File f = fcho.showOpenDialog((Window)null);
        String pathy = f.getAbsolutePath().toString();
        BufferedReader buf = new BufferedReader(new FileReader(pathy));
        String line;
        while ((line = buf.readLine()) != null)
          this.textarea.appendText(line + "\n"); 
        buf.close();
        this.buttonspane.setVisible(true);
        this.actionname.setDisable(false);
        this.time.setDisable(false);
        this.control.setDisable(false);
        this.temprature.setDisable(false);
        this.liters.setDisable(false);
        this.amount.setDisable(false);
        this.units.setDisable(false);
        this.chemical.setDisable(false);
        this.chemicalsign.setDisable(false);
        this.textarea.setDisable(false);
        this.textarea.setEditable(true);
        this.view.setVisible(true);
        this.view.getEngine().loadContent(this.textarea.getText());
        this.model.setDisable(true);
        this.stage.setDisable(true);
        this.editmenu.setVisible(true);
      } 
    } else {
      this.textarea.setVisible(true);
      this.textarea.clear();
      this.view.getEngine().load("");
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String pathy = f.getAbsolutePath().toString();
      BufferedReader buf = new BufferedReader(new FileReader(pathy));
      String line;
      while ((line = buf.readLine()) != null)
        this.textarea.appendText(line + "\n"); 
      buf.close();
      this.buttonspane.setVisible(true);
      this.actionname.setDisable(false);
      this.time.setDisable(false);
      this.control.setDisable(false);
      this.temprature.setDisable(false);
      this.liters.setDisable(false);
      this.amount.setDisable(false);
      this.units.setDisable(false);
      this.chemical.setDisable(false);
      this.chemicalsign.setDisable(false);
      this.textarea.setDisable(false);
      this.textarea.setEditable(true);
      this.view.setVisible(true);
      this.view.getEngine().loadContent(this.textarea.getText());
      this.editmenu.setVisible(true);
    } 
  }
  
  @FXML
  void selectallaction(ActionEvent event) {
    this.textarea.selectAll();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void undoaction(ActionEvent event) {
    this.textarea.undo();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void redoaction(ActionEvent event) {
    this.textarea.redo();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void cutaction(ActionEvent event) {
    this.textarea.cut();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void copyaction(ActionEvent event) {
    this.textarea.copy();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void pasteaction(ActionEvent event) {
    this.textarea.paste();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void clearallaction(ActionEvent event) {
    this.textarea.clear();
    this.view.getEngine().loadContent(this.textarea.getText());
  }
  
  @FXML
  void dateres(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.washname.requestFocus(); 
  }
  
  @FXML
  void washres(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.kg.requestFocus(); 
  }
  
  @FXML
  void kgres(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.pcs.requestFocus(); 
  }
  
  @FXML
  void pcsres(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.customer.requestFocus(); 
  }
  
  @FXML
  void customerres(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.stylename.requestFocus(); 
  }
  
  @FXML
  void styleres(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.createbtn.fire(); 
  }
  
  @FXML
  void actionrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.time.requestFocus(); 
  }
  
  @FXML
  void timerel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.control.requestFocus(); 
  }
  
  @FXML
  void controlrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.temprature.requestFocus(); 
  }
  
  @FXML
  void tempraturerel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.liters.requestFocus(); 
  }
  
  @FXML
  void litersrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.amount.requestFocus(); 
  }
  
  @FXML
  void amountrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER) {
      this.units.requestFocus();
      this.units.show();
    } 
  }
  
  @FXML
  void unitsrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER) {
      this.chemical.requestFocus();
      this.chemical.show();
    } 
  }
  
  @FXML
  void chemicalrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER) {
      this.chemicalsign.requestFocus();
      this.chemicalsign.show();
    } 
  }
  
  @FXML
  void chemicalsignrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.chemicallot.requestFocus(); 
  }
  
  @FXML
  void chemicallotrel(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.addstep.fire(); 
  }
  
  public void initialize(URL url, ResourceBundle rb) {
      
    
//     
//     final HourService hservice = new HourService();
//        hservice.setCalendarInstance(Calendar.getInstance());
//        hservice.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // Anonymous
//
//            @Override
//            public void handle(WorkerStateEvent t) {   
//                hservice.restart();
//            }
//        });
//        hservice.start();
//    
//    
    
    
    
    view.setOnKeyReleased(gg -> {
          
        
    String p1 = NewDir.file_dir;
    String p2 = this.customer.getText();
    String p3 = this.washname.getText().replace(" ", "_");
    String stagename = this.stage.getSelectionModel().getSelectedItem();
    File gkk = new File(p1 + "\\" + stagename + "\\" + p2) ;
    String code = (String)this.view.getEngine().executeScript("document.documentElement.outerHTML");
    File gk = new File(p1 + "\\" + stagename + "\\" + p2 + "\\" + p3 + ".html");
        try {
            gk.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(RecipeMakerController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    gkk.mkdirs();
    try {
      PrintWriter pw = new PrintWriter(new FileWriter(gk));
      pw.println();
      pw.print(code);
      pw.close();
    } catch (IOException iOException) {}
    
    textarea.clear();
    String codee =code.replace("</tbody></table></center></body></html>"," ");
    textarea.setText(codee);
    textarea.end();
        
        });
      
      
    Toolkit tool = Toolkit.getDefaultToolkit();
    if (!tool.getLockingKeyState(20)) {
      tool.setLockingKeyState(20, true);
    } else {
      tool.setLockingKeyState(20, true);
    } 
    this.conn = db.java_db();
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    this.date.setText(timeString);
    this.units.getItems().addAll(new String[] { "KG", "GR", "GARDAL", " " });
    this.stage.getItems().addAll(new String[] { "DEVELOPMENT", "PRODUCTION", "PILOT", "BLANKET", "SHRINK" });
  }
}


////////////////////////////////////////////////////////////////////////////////

//   class HourService extends Service<Date>
//    {
//
//        private Calendar calendar;
//
//        public final void setCalendarInstance(Calendar c)
//        {
//            calendar = c;
//        }
//
//
//        @Override
//        protected Task<Date> createTask() {
//
//            return new Task<Date>() {
//
//                protected Date call()
//                {
//                    int secondsdelay = 14400;
//                    Date timeStarted = calendar.getTime();
//                    Date timeEnd = new Date(timeStarted.getTime() + 1000 * secondsdelay );//* 60 * 60);
//                    while( timeEnd.after(calendar.getTime()) )
//                    {
//                        try {
//                            Thread.sleep(500);
//                            calendar = Calendar.getInstance();
//                        } catch (InterruptedException e) {
//                            if (isCancelled()) {
//                                updateMessage("Cancelled");
//                                break;
//                            }
//                        }
//                    }
//                    //Close program here
//                    System.exit(0);
//                    return timeEnd;
//
//                }
//            };
//        }
//    }
//////////////////////////////////////////////////////////////////////////////////
