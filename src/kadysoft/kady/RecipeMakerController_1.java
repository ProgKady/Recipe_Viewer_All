package kadysoft.kady;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.Table;
import com.spire.doc.TableCell;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.PageOrientation;
import com.spire.doc.documents.VerticalAlignment;
import com.spire.doc.fields.TextRange;
import com.spire.pdf.PdfDocument;
import com.spire.xls.CellRange;
import com.spire.xls.ExcelVersion;
import com.spire.xls.FileFormat;
import com.spire.xls.ViewMode;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
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
import org.jsoup.Jsoup;

public class RecipeMakerController_1  <T extends Comparable<T>> implements Initializable {
    
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
  private MenuItem exit,emptyrecipeone;
  
  @FXML
  private MenuItem savetohtml,aiartool;
  
  @FXML
  private MenuItem exporttoexcel,editeditedit;
  
  @FXML
    private MenuItem editorprint;
  
  @FXML
  private MenuItem viewrecipes;
  
  @FXML
  private MenuItem openrecipesfolder;
  
  @FXML
  private MenuItem copyarecipe, addlogo;
  
  @FXML
  private MenuItem copyarecipepath,myexporttoexcel;
  
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
  private JFXTextField amount,stagefield,modelfield,actionfield,unitfield;
  
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
  private JFXTextArea myarea;
  
  
  @FXML
  private JFXButton createbtn;
  
  @FXML
  private JFXButton addstep;
  
  @FXML
  private JFXButton emptyrow;
  
  @FXML
  private JFXTextArea lili;
  
  @FXML
  private JFXButton notesrow;
  
  @FXML
  private HBox buttonspane;
  
  @FXML
  private JFXButton editrecipe,stageadd,modeladd,actionadd,unitadd;
  
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
  private MenuItem copy,signout;
  
  @FXML
  private MenuItem paste;
  
  @FXML
  private MenuItem logout,zoomin,zoomout;
  
  @FXML
  private MenuItem clearall,mailerr,encryptarecipe,decryptarecipe,kadysoftmethod,htmltohta;
  
  @FXML
  private MenuItem saverecipe;
  
  @FXML
  private WebView view;
  
  JasperPrint jasperPrint;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  int i = 1;
  
  //////////////////////////////////////////////
  
  
  
  @FXML
  void encryptoall(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("EncryptMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Encrypt Multiple Recipes");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    //stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  
  @FXML
    void emptyrecipeoneaction(ActionEvent event) throws IOException {

    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("EmptyRecipe.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Create An Empty Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
          
        
        
    }
  
  @FXML
    void encryptadvaction(ActionEvent event) throws IOException, InterruptedException {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    lili.clear();
    BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        lili.appendText("\n"+lo
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
    String gf=lili.getText();
    PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    lili.clear();

          
       
        
        
    }
  
  ///////////////////////////////////////////////////////
  
     
    @FXML
    void decryptadvaction(ActionEvent event) throws IOException {

        
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    lili.clear();
    BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        lili.appendText("\n"+lo
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
    String gf=lili.getText();
    PrintWriter pwe=new PrintWriter (new FileWriter (pathy));
    pwe.println(gf);
    pwe.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have decrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    lili.clear();
        
        
    }
  

   
  
  /////////////////////////////////////////////////////////
  
    
    @FXML
    void removesignaction(ActionEvent event) throws IOException {

        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RemoveSign.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Remove Signature");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
    }
  
  
  
  
  
  
  
  
  @FXML
  void kadysoftmethodaction (ActionEvent event) throws IOException, InterruptedException  {
      
      //Normal
      
         
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    String filename = f.getName().toString();
    String newfilename=filename.replace(".ks","").replace(".html","");
    
    File newdir=new File (System.getProperty("user.home")+"\\Temp_Files");
    
    if (!newdir.exists()) {
        newdir.mkdir();
    }
    else {
        //Continue to outside else.
    }
    
    String linet = "cmd /C copy /Y "+pathy+" "+newdir+"\\"+newfilename+".hta";
    Process p = Runtime.getRuntime().exec(linet);
    p.waitFor();
    
    File htafile=new File (newdir+"\\"+newfilename+".hta");
    
    Desktop desk=Desktop.getDesktop();
    desk.open(htafile);
    
    htafile.deleteOnExit();
      
      
      
      
      
  }
  
  
  @FXML
  void htmltohtaaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("HtmlToHta.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("HTML To HTA");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  
  
  @FXML
  void aiartoolaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Aiar Tool");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  
  @FXML
  void signoutaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Sign.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Sign A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  @FXML
  void encryptarecipeaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Encrypt.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Encrypt A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  @FXML
  void decryptarecipeaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Decrypt.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Decrypt A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  
  
  
  
  
  
  
  //////////////////////////////////////////////////
  
  @FXML
  private MenuItem protect,addsheet,removesheet,xlsxtosvg,exceltoword,exceltotext,pdftoexcel;
  
  
  
  
  
  @FXML
  void addlogoaction (ActionEvent event) throws IOException {
      
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("AddLogo.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Add Logo To Recipe");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
          
  }
  
  
  
  @FXML
    void mailerraction(ActionEvent event) throws IOException   {
        
        
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Mailer.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Kadysoft - Mailer");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
        
        
    }
  
  
  
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  @FXML
    void protectaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
      Workbook workbook = new Workbook();
      workbook.loadFromFile(pathy); 
      JFXTextField gr = new JFXTextField();
      gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      gr.setLabelFloat(true);
      gr.setPromptText("Click To Write Password .... ");
      gr.setMinSize(222.0D, 33.0D);
      Alert alo = new Alert(Alert.AlertType.INFORMATION);
      alo.setTitle("Add Password");
      alo.setGraphic((Node)gr);
      alo.setResizable(false);
      alo.showAndWait();
      String password=gr.getText();
      workbook.protect(password);
      workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have added the password successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    @FXML
    void addsheetaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Click To Write Sheet Name .... ");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Add Sheet");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().add(gr.getText());
        sheet.getCellRange("C5").setText("Created By Kadysoft Ltd, Ahmed Elkady - CEO.");
        workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);
        workbook.dispose();

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have added the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    @FXML
    void removesheetaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Remove Sheet");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet1 = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        sheet1.remove();
        workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);
        workbook.dispose();

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have removed the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    @FXML
    void deleterowsaction(ActionEvent event) throws IOException   {
        
     FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
       
    Workbook wb = new Workbook();
    wb.loadFromFile(pathy);
    JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Remove R & C");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet = wb.getWorksheets().get(Integer.parseInt(gr.getText()));
    for (int i = sheet.getLastRow(); i >= 1; i--)

        {
            
       if (sheet.getRows()[i-1].isBlank())

            {

                sheet.deleteRow(i);

            }

        }

        for (int j = sheet.getLastColumn(); j >= 1; j--)

        {

            if (sheet.getColumns()[j-1].isBlank())

            {


                sheet.deleteColumn(j);

            }

        }

      wb.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have removed the rows and columns successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
  
  
    @FXML
    void xlsxtosvgaction(ActionEvent event) throws IOException   {
        
     FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Number");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        FileOutputStream stream = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\"+nami+".svg");
        sheet.toSVGStream(stream, sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());
        stream.flush();
        stream.close();

        

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    @FXML
    void exceltowordaction(ActionEvent event) throws IOException   {
        
     FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
     //Load an Excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Number");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        Document doc = new Document();
        Section section = doc.addSection();
        section.getPageSetup().setOrientation(PageOrientation.Landscape);
        Table table = section.addTable(true);
        table.resetCells(sheet.getLastRow(), sheet.getLastColumn());
        mergeCells(sheet, table);

        for (int r = 1; r <= sheet.getLastRow(); r++) {

            //Set row Height
            table.getRows().get(r - 1).setHeight((float) sheet.getRowHeight(r));

            for (int c = 1; c <= sheet.getLastColumn(); c++) {
                CellRange xCell = sheet.getCellRange(r, c);
                TableCell wCell = table.get(r - 1, c - 1);

                //Get value of a specific Excel cell and add it to a cell of Word table
                TextRange textRange = wCell.addParagraph().appendText(xCell.getValue());

                //Copy font and cell style from Excel to Word
                copyStyle(textRange, xCell, wCell);
            }
        }

        //Save the document to a Word file
        doc.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".docx", com.spire.doc.FileFormat.Docx);
        
        
        
    }

    //Merge cells if any
    private static void mergeCells(Worksheet sheet, Table table) {
        if (sheet.hasMergedCells()) {

            //Get merged cell ranges from Excel
            CellRange[] ranges = sheet.getMergedCells();
            for (int ii = 0; ii < ranges.length; ii++) {
                int startRow = ranges[ii].getRow();
                int startColumn = ranges[ii].getColumn();
                int rowCount = ranges[ii].getRowCount();
                int columnCount = ranges[ii].getColumnCount();

                //Merge corresponding cells in Word table
                if (rowCount > 1 && columnCount > 1) {
                    for (int j = startRow; j <= startRow + rowCount ; j++) {
                        table.applyHorizontalMerge(j - 1, startColumn - 1, startColumn - 1 + columnCount - 1);
                    }
                    table.applyVerticalMerge(startColumn - 1, startRow - 1, startRow - 1 + rowCount -1);
                }
                if (rowCount > 1 && columnCount == 1 ) {
                     table.applyVerticalMerge(startColumn - 1, startRow - 1, startRow - 1 + rowCount -1);
                }
                if (columnCount > 1 && rowCount == 1 ) {
                    table.applyHorizontalMerge(startRow - 1, startColumn - 1,  startColumn - 1 + columnCount-1);
                }
            }
        }
    }

    //Copy cell style of Excel to Word table
    private static void copyStyle(TextRange wTextRange, CellRange xCell, TableCell wCell) throws IOException {

        //Copy font style
        wTextRange.getCharacterFormat().setTextColor(xCell.getStyle().getFont().getColor());
        wTextRange.getCharacterFormat().setFontSize((float) xCell.getStyle().getFont().getSize());
        wTextRange.getCharacterFormat().setFontName(xCell.getStyle().getFont().getFontName());
        wTextRange.getCharacterFormat().setBold(xCell.getStyle().getFont().isBold());
        wTextRange.getCharacterFormat().setItalic(xCell.getStyle().getFont().isItalic());

        //Copy backcolor
        wCell.getCellFormat().setBackColor(xCell.getStyle().getColor());

        //Copy horizontal alignment
        switch (xCell.getHorizontalAlignment()) {
            case Left:
                wTextRange.getOwnerParagraph().getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
                break;
            case Center:
                wTextRange.getOwnerParagraph().getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
                break;
            case Right:
                wTextRange.getOwnerParagraph().getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
                break;
        }
        
        //Copy vertical alignment
        switch (xCell.getVerticalAlignment()) {
            case Bottom:
                wCell.getCellFormat().setVerticalAlignment(VerticalAlignment.Bottom);
                break;
            case Center:
                wCell.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                break;
            case Top:
                wCell.getCellFormat().setVerticalAlignment(VerticalAlignment.Top);
                break;
        }
    
    ////////////
    
      
       
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    
    
    @FXML
    void exceltotextaction(ActionEvent event) throws IOException   {
        
   
        FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Number");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        Charset charset = Charset.forName("utf8");
        sheet.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".txt", " ", charset);
        

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    
    
    
    @FXML
    void pdftoexcelaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".pdf","");
    String pathy = f.getAbsolutePath().toString();
    
      PdfDocument pdf = new PdfDocument();
      pdf.loadFromFile(pathy);
      pdf.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx",com.spire.pdf.FileFormat.XLSX);
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the pdf successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    
    
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  @FXML
    void xlsxtopdfaction(ActionEvent event) throws IOException  {
        
    /*
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLSX Files", new String[] { "*.xlsx" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLS Files", new String[] { "*.xls" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();   ///Excel File Path.
    
    //Create a Workbook instance and load an Excel file

        Workbook workbook = new Workbook();
        workbook.loadFromFile(filePath);
        workbook.getConverterSetting().setSheetFitToPage(true);
        String reppathh = System.getProperty("user.home") + "\\Desktop";
        FileChooser dialogg = new FileChooser();
        dialogg.setInitialDirectory(new File(reppathh));
        dialogg.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.png" }));
        File dialogResultt = dialogg.showSaveDialog(null);
        String filePathh = dialogResultt.getAbsolutePath().toString();
        //System.out.println(filePathh);
        //workbook.saveToFile(filePathh, FileFormat.Bitmap); ///Choose what you want // then Notification.

        Worksheet sheet=workbook.getWorksheets().get(0);
        sheet.saveToImage(filePathh);
        */
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter1.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Convert Excel To File");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
    }
    
    @FXML
    void htmltopdfaction(ActionEvent event) throws IOException  {
        
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter2.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Convert Excel To Image");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();  
        
    }
  
  
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @FXML
    void stageaddaction(ActionEvent event) throws IOException  {
        
      /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Stages.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        stage.getItems().clear();
        String stepp=stagefield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Stages.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        stagefield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
      
    }
  
    
    
    
    
    
    
    
    
    
    @FXML
    void modeladdaction(ActionEvent event) throws IOException  {
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        model.getItems().clear();
        String stepp=modelfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Models.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        modelfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    
    
    
    
    
    
    
    
    
    @FXML
    void actionaddaction(ActionEvent event) throws IOException  {
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Action_Names.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        actionname.getItems().clear();
        String stepp=actionfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Action_Names.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        actionfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    
    
    
    
    
    
    
    
    
    @FXML
    void unitaddaction(ActionEvent event) throws IOException  {
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Units.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        units.getItems().clear();
        String stepp=unitfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Units.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        unitfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    
  
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  
  
  
  
  
  
  @FXML
    void editorprintaction(ActionEvent event) throws FileNotFoundException, IOException {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\index.html"));
    pw.append("<html lang=\"ar\">\n<head>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n\t\t<title>Kadysoft Ltd - Ahmed Elkady</title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line
              
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
              
              
              + "\n"); 
     
    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>");
    
    
    
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\index.html"));
        
    }
  
    
    
    @FXML
  void zoominaction(ActionEvent event) throws IOException  {
      
      this.view.setFontScale(this.view.getFontScale() + 1.0);
  }
  
  
  @FXML
  void zoomoutaction(ActionEvent event) throws IOException  {
      
      this.view.setFontScale(this.view.getFontScale() - 1.0);
  }
    
    
    
    
    
    @FXML
  void myexporttoexcelaction(ActionEvent event) throws IOException  {
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    
    
            Workbook workbook = new Workbook();
            workbook.loadFromHtml(pathy);

            //AutoFit rows
            Worksheet sheet=workbook.getWorksheets().get(0);
            sheet.setName("Made_By_Kadysoft_Ltd");
            
            sheet.autoFitRow(i);

            //Save the document to file
            workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx",FileFormat.Version2016);
            
            Desktop desk=Desktop.getDesktop();
            desk.open(new File (System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx"));
    
  }
    
    
    
    
    
  @FXML
  void exporttoexcelaction(ActionEvent event) throws IOException  {
      
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Recipes2Excel\\index.html"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
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
          this.pst.setString(4, "Recipe_Maker is exporting a system recipe to excel.");
          
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
  void openrecipesfolderaction(ActionEvent event) throws IOException {
      
      //Desktop desk=Desktop.getDesktop();
      //desk.open(new File (NewDir.file_dir));
      
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
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
  }
  
  @FXML
  void copyarecipepathaction(ActionEvent event) throws IOException {
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CopyARecipePath.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Recipe Copier ...");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
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
    createnewrecipe.setDisable(false);
  }
  
  @FXML
  void exceltohtmlaction(ActionEvent event) throws IOException {
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\ExcelToHTML\\index.html"));
    this.savetohtml.setDisable(false);
    
    
    
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
          this.pst.setString(4, "Recipe_Maker is converting an excel recipe to system.");
          
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
          
          savetohtml.fire();
          Stage jk = (Stage)this.createbtn.getScene().getWindow();
          jk.setIconified(true);
    
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
          this.pst.setString(2, "Recipe_Maker");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Recipe_Maker Logged Out.");
          
          this.pst.execute();
              }
              catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
          
          ////////////////////////////////////////////////
    
          
          
          ////////////////////////////////////////////////
          
          
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
  void stageactionnn(Event event) {
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
  void hidingaction(Event event) {
      whiskercode.requestFocus();
  }
  
  
  @FXML
  void unitaction(Event event) {
    this.units.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Units.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.units.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
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
      
      //////////////////////////////////////START///////////////////////////////////////
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
      String timeString2 = sdf2.format(d1);
      String value000 = timeString1;
      String value111 = timeString2;
      ComboBox myuser=new ComboBox ();
      myuser.setMinSize(150, 30);
      myuser.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      myuser.setPromptText("Choose One");
      myuser.setOnShown(evt -> {
          myuser.getItems().clear();
         try {
             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
             String line;
             while ((line = buf.readLine()) != null) {
             myuser.getItems().addAll(new String[] { line });
          } 
          buf.close();
          } catch (FileNotFoundException fileNotFoundException) {
    
          } catch (IOException iOException) {}
      });
      
      
      
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Choose Responsible");
      alert.setHeaderText("Please be careful, this info is important.");
      alert.setContentText("Hello, Please tell me: Who are you?.");
      alert.setGraphic(myuser);
      alert.setResizable(false);
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("primer-dark.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
      else if (option.get() == ButtonType.OK) {
          if (myuser.getSelectionModel().getSelectedItem()==null) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Please choose one user.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          }
          else {
              ////////////////////////Copy All Here/////////////////////////
              String theuser=myuser.getSelectionModel().getSelectedItem().toString();
              String dateandtime=value111+" - "+value000;
              
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
      this.textarea.appendText("<html lang=\"ar\" contenteditable>\n<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Brought To You By Kadysoft Ltd.</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body>\n\n");
      this.textarea.appendText("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
      this.textarea.appendText("<center><table id=\"exTable\" style=\"width: 1053px; height: 150px; text-align: center; border: 1px solid black; margin-left: -0.274977%;\"><tbody>\n\n<tr>\n\n\n\t<td style=\"width: 9.89918%; text-align: center; background-color: rgb(255, 153, 0); border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Stage</strong></span></td>\n\t<td style=\"width: 23.4647%; background-color: rgb(255, 153, 0); border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + stagee + " Recipe</strong></td>\n\t<td style=\"width: 8.45204%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 8.73694%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 16.1443%; border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><strong style=\"font-size: 12px;\">Date :&nbsp;</strong></td>\n\t<td style=\"width: 30.8642%; border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + datee + "</strong></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Cust :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + customerr + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Wash Name :</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + washnamee + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO No :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO Amount</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">KG</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + kgg + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Style Name</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + stylenamee + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Machine No</strong></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><strong style=\"font-size: 12px;\">Spining</strong></td>\n\n\n\n<td style=\"width: 8.92688%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Dryer No</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">PCS:</strong></span></td>\n\t<td colspan=\"3\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + pcss + "</strong></span></td></tr><tr>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Stage</strong></span></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + stagee + "</strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Action No</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Action Name</strong></td><td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Time(MIN)</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Temp</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Liters</strong></td><td style=\"width: 7.21747%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Amt</strong></td><td style=\"width: 6.83761%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Units</strong></td><td style=\"width: 14.5299%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Description</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Name</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical LOT No</strong></td>\n\n\t\n\n\n\t</tr><tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t\n\n\n\t</tr>\n\n\n\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>Whisker</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS    " + whiskerr + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10.0148%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>Hand Sand</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS    " + handd + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\" text-align: center; width: 10.0148%;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"3\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td></tr>\n\n\n");
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
      this.textarea.appendText("<html lang=\"ar\" contenteditable>\n<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Brought To You By Kadysoft Ltd.</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body>\n\n");
      this.textarea.appendText("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
      this.textarea.appendText("<center><table id=\"exTable\" style=\"width: 1053px; height: 150px; text-align: center; border: 1px solid black; margin-left: -0.274977%;\"><tbody>\n\n<tr>\n\n\n\t<td style=\"width: 9.89918%; text-align: center; background-color: rgb(255, 153, 0); border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Stage</strong></span></td>\n\t<td style=\"width: 23.4647%; background-color: rgb(255, 153, 0); border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + stagee + " Recipe</strong></td>\n\t<td style=\"width: 8.45204%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 8.73694%; border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"width: 16.1443%; border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><strong style=\"font-size: 12px;\">Date :&nbsp;</strong></td>\n\t<td style=\"width: 30.8642%; border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><strong style=\"font-size: 12px;\">" + datee + "</strong></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Cust :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + customerr + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Model  Logo : <img src=\"" +"file://"+NewDir.file_dirrr + "\\" + modell + ".bmp\" width=\"100\" height=\"100\"></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">Wash Name :</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + washnamee + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO No :</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">PO Amount</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">KG</strong></span></td>\n\t<td rowspan=\"2\" style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"3\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + kgg + "</strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Style Name</strong></td>\n\t<td colspan=\"3\" style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">" + stylenamee + "</strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t<td style=\"border-color: rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\"><br></strong></td>\n\t\n\t</tr>\n<tr>\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Machine No</strong></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><strong style=\"font-size: 12px;\">Spining</strong></td>\n\n\n\n<td style=\"width: 8.92688%; border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Dryer No</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><strong style=\"font-size: 12px;\">Operator</strong></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">PCS:</strong></span></td>\n\t<td colspan=\"3\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\">" + pcss + "</strong></span></td></tr><tr>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n\t<td style=\"width: 7.22892%; border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"width: 8.85122%; border: 1px solid rgb(152, 0, 0);\" \"=\"\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\n\n\n<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"></strong></span></td>\n\n\n\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"></strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"border: 1px solid rgb(152, 0, 0);\" colspan=\"2\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"border-color: rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td></tr>\n<tr>\n\n\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Action No</strong></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Action Name</strong></td><td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Time(MIN)</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Temp</strong></td>\n\t<td style=\"background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Liters</strong></td><td style=\"width: 7.21747%; background-color: rgb(255, 229, 153); border: 3px solid black\"><strong style=\"font-size: 12px;\">Amt</strong></td><td style=\"width: 6.83761%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Units</strong></td><td style=\"width: 14.5299%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Description</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical Name</strong></td><td style=\"width: 18.7085%; background-color: rgb(255, 229, 153); border: 3px solid black;\"><strong style=\"font-size: 12px;\">Chemical LOT No</strong></td>\n\n\t\n\n\n\t</tr><tr>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td colspan=\"2\" style=\"width: 13.2682%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t<td style=\"background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 7.21747%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 6.83761%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 14.5299%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td><td style=\"width: 18.7085%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><span style=\"font-size: 12px;\"><strong style=\"font-size: 12px;\"><br></strong></span></td>\n\t\n\n\n\t</tr>\n\n\n\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 229, 153); border: 1px solid rgb(152, 0, 0);\"><strong>Whisker</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS    " + whiskerr + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\"width: 10.0148%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%;  text-align: center; background-color: rgb(255, 229, 153); border: 1px solid rgb(152, 0, 0);\"><strong>Hand Sand</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><strong>DEERFOS    " + handd + "</strong></td>\n\t<td style=\"width: 10%;  text-align: center;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\"><br></td>\n\t<td style=\" text-align: center; width: 10.0148%;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0);\" colspan=\"6\"><br></td>\n\t\n\t\n\t\n\t\n\t</tr>\n<tr>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"2\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\" width: 10%;background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td>\n\t<td colspan=\"3\" style=\"width: 10%; background-color: rgb(255, 255, 255); border: 1px solid rgb(152, 0, 0); text-align: center;\"><br></td></tr>\n\n\n\n");
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
          this.pst.setString(1, dateandtime);
          this.pst.setString(2, theuser);
          this.pst.setString(3, MachineID);
          this.pst.setString(4, theuser+" is creating a new recipe its info "+washnamee +" for "+customerr);
          
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
          
    
              
              //////////////////////////////////////////////////////////////
          }
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't created.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      /////////////////////////////////////////END/////////////////////////////////////
      
          
    
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
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    File dialogResult = dialog.showSaveDialog(null);
    filePath = dialogResult.getAbsolutePath().toString();
    contentpath = filePath;
    String code = this.textarea.getText();
    OutputStream instream=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
    pw.println(code);
    pw.close();
    this.preview.setDisable(false);
    String stg = this.stage.getSelectionModel().getSelectedItem();
    String mod = this.model.getSelectionModel().getSelectedItem();
    String washn = this.washname.getText().replace(" ", "_");
    String pathu1 = NewDir.file_dir;
    String pathu2 = pathu1 + "\\" + stg + "\\" + mod + "\\" + washn + ".ks";
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
    OutputStream instream=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
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
      
      
      
      
      //////////////////////////////////////START///////////////////////////////////////
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
      String timeString2 = sdf2.format(d1);
      String value000 = timeString1;
      String value111 = timeString2;
      ComboBox myuser=new ComboBox ();
      myuser.setMinSize(150, 30);
      myuser.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      myuser.setPromptText("Choose One");
      myuser.setOnShown(evt -> {
          myuser.getItems().clear();
         try {
             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
             String line;
             while ((line = buf.readLine()) != null) {
             myuser.getItems().addAll(new String[] { line });
          } 
          buf.close();
          } catch (FileNotFoundException fileNotFoundException) {
    
          } catch (IOException iOException) {}
      });
      
      
      
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Choose Responsible");
      alert.setHeaderText("Please be careful, this info is important.");
      alert.setContentText("Hello, Please tell me: Who are you?.");
      alert.setGraphic(myuser);
      alert.setResizable(false);
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("primer-dark.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
      else if (option.get() == ButtonType.OK) {
          if (myuser.getSelectionModel().getSelectedItem()==null) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Please choose one user.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          }
          else {
              ////////////////////////Copy All Here/////////////////////////
              String theuser=myuser.getSelectionModel().getSelectedItem().toString();
              String dateandtime=value111 +" - "+value000;
              
              
              FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String thename=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    
    
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"<head>\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <title></title>\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-dialog.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-tour.min.css\" />\n" +
"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346&amp;g=1\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://cdn.bookingtimes.com/Scripts/jquery.slicknav.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://cdn.bookingtimes.com/Scripts/bootstrap-tour.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"./Scripts/tiny_mce/tinymce.min.js\" type=\"text/javascript\"></script>\n" +
"    <style>\n" +
"        #menuContainer {\n" +
"        background-color: black;\n" +
"        }\n" +
"    </style>\n" +
"    <script>\n" +
"        $(document).ready(function () {\n" +
"            $(\".modal\").on('shown', function () {\n" +
"                $(this).find(\"[autofocus]:first\").focus();\n" +
"            });\n" +
"            $('.modal').on('hidden.bs.modal', function () {\n" +
"                imageSelected(0, 0);\n" +
"            })\n" +
"        });\n" +
"        tinyMCE.init({\n" +
"            mode: \"specific_textareas\",\n" +
"            editor_selector: \"mceEditor\",\n" +
"            cleanup: false,\n" +
"			plugins: \"link,code,insertdatetime,preview,paste,table,visualblocks,fullscreen,image,emoticons,textcolor,colorpicker,lists,charmap,hr,print,autosave,charmap,codesample,colorpicker,fullpage,save,searchreplace,image,imagetools,help\",                         // Theme options - button# indicated the row# only\n" +
"            menu: {\n" +
"			    file: { title: 'File', items: 'print save |     autosave  charmap  codesample    | colorpicker fullpage searchreplace image imagetools' },\n" +
"                edit: { title: 'Edit', items: 'undo redo  | cut copy paste pastetext selectall | searchreplace' },\n" +
"                format: { title: 'Format', items: 'strikethrough superscript subscript | removeformat' },\n" +
"                view: { title: 'View', items: 'visualblocks visualaid | preview fullscreen | code' },\n" +
"                table: { title: 'Table', items: 'inserttable tableprops deletetable | cell row column' },\n" +
"				about: { title: 'About', items: 'help' }\n" +
"            },\n" +
"            images_dataimg_filter: function (img) {\n" +
"            return img.hasAttribute('internal-blob');\n" +
"            },\n" +
"            toolbar1: \"formatselect , fontsizeselect | bold italic underline |  outdent indent | bullist numlist | alignleft aligncenter alignright |  forecolor backcolor  |  inserttable tableprops deletetable | cell row column  |  table save print imagetools image noneditable fullpage fullscreen code autosave bbcode emoticons emotions | preview \",\n" +
"            style_formats: [{ title: 'h1', block: 'h1' },\n" +
"            { title: 'h2', block: 'h2' },\n" +
"            { title: 'h3', block: 'h3' },\n" +
"            { title: 'h4', block: 'h4' },\n" +
"            { title: 'h5', block: 'h5' }],\n" +
"            visualblocks_default_state: false,\n" +
"            end_container_on_empty_block: true,\n" +
"            resize: 'both',\n" +
"            browser_spellcheck: true,\n" +
"            paste_text_sticky: true,\n" +
"            paste_data_images: true,\n" +
"            inline_styles: true,\n" +
"            schema: 'html5',\n" +
"            valid_children: \"+body[style|meta],+a[*],+input[*],+a[div|p|span],+input[div|p|span]\",\n" +
"            extended_valid_elements: \"div[*],iframe[*],,a[*],p[*],img[*],input[*],script[*],meta[*]\",\n" +
"            allow_html_in_named_anchor: true,\n" +
"            remove_script_host: false,\n" +
"            convert_urls: false,\n" +
"            branding: false,\n" +
"            encoding: \"UTF-8\",\n" +
"            block_formats: 'Paragraph=p;Heading 2=h2;Heading 3=h3;Heading 4=h4;Heading 5=h5;Heading 6=h6;Address=address;Pre=pre',\n" +
"            theme_advanced_blockformats: 'p,address,pre,h1,h2,h3,h4,h5',\n" +
"            theme_advanced_buttons1_add_before: \"h1,h2,h3,h4,h5,h6,separator\",\n" +
"            theme_advanced_resizing: true,\n" +
"            init_instance_callback: function () { if (typeof tinyMCE_Init == \"function\") { tinyMCE_Init(); } },\n" +
"        });\n" +
"    </script>\n" +
"</head>\n" +
"<body>\n" +
"<center>\n" +
"        <div class=\"col-sm-9\">\n" +
"        <textarea rows=\"2\" cols=\"20\" id=\"txtBody\" class=\"mceEditor\" autocomplete=\"off\" style=\"height: 800px; width: 100%;\" aria-hidden=\"true\">\n" +
"			\n" +
"			\n" +
"			");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line
              
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
              
              .replace(" WIDTH=\"300\" HEIGHT=\"90\" ALT=\"DEVELOPED BY KADYSOFT LTD (AHMED ELKADY).\" STYLE=\"BORDER-COLOR:BLACK;BORDER-WIDTH:10PX;\">","").replace("<B>MR_MOHARAM SIGNATURE: </B><IMG SRC=\"FILE://Z:\\MODELS\\MR_MOHARAM.PNG\"","").replace("<B>MR_MOHAMED SIGNATURE: </B><IMG SRC=\"FILE://Z:\\MODELS\\MR_MOHAMED.PNG\"","") + "\n"); 
     
    pw.append("			\n" +
"			\n" +
"			</textarea>\n" +
"\n" +
"        </div>\n" +
"    </div>\n" +
"</center>\n" +
"</body>\n" +
"</html>");
    
   
    
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
    
    saverecipe.fire();
    Stage jk = (Stage)this.createbtn.getScene().getWindow();
    jk.setIconified(true);
    
     ///////////////Modify DB and Signature////////////////
          
          String filename=f.getName().replace(".html","").replace(".ks","");
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
          this.pst.setString(1, dateandtime);
          this.pst.setString(2, theuser);
          this.pst.setString(3, MachineID);
          this.pst.setString(4, theuser+" is editing a recipe called "+thename);
          
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
    
              
              //////////////////////////////////////////////////////////////
          }
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't edited.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      /////////////////////////////////////////END/////////////////////////////////////
      
      
      
      //////////////////////////////////////START///////////////////////////////////////
      
//      Date currentDate1 = GregorianCalendar.getInstance().getTime();
//      DateFormat df1 = DateFormat.getDateInstance();
//      String dateString1 = df1.format(currentDate1);
//      Date d1 = new Date();
//      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
//      String timeString1 = sdf1.format(d1);
//      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
//      String timeString2 = sdf2.format(d1);
//      String value000 = timeString1;
//      String value111 = timeString2;
//      ComboBox myuser=new ComboBox ();
//      myuser.setMinSize(150, 30);
//      myuser.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
//      myuser.setPromptText("Choose One");
//      myuser.setOnShown(evt -> {
//          myuser.getItems().clear();
//         try {
//             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
//             String line;
//             while ((line = buf.readLine()) != null) {
//             myuser.getItems().addAll(new String[] { line });
//          } 
//          buf.close();
//          } catch (FileNotFoundException fileNotFoundException) {
//    
//          } catch (IOException iOException) {}
//      });
//      
//      
//      
//      Alert alert = new Alert(AlertType.WARNING);
//      alert.setTitle("Choose Responsible");
//      alert.setHeaderText("Please be careful, this info is important.");
//      alert.setContentText("Hello, Please tell me: Who are you?.");
//      alert.setGraphic(myuser);
//      alert.setResizable(false);
//      DialogPane dialogPane = alert.getDialogPane();
//      dialogPane.getStylesheets().add(
//    getClass().getResource("primer-dark.css").toExternalForm());
//      Optional<ButtonType> option = alert.showAndWait();
//      if (option.get() == null) {} 
//      else if (option.get() == ButtonType.OK) {
//          if (myuser.getSelectionModel().getSelectedItem()==null) {
//              Notifications noti = Notifications.create();
//              noti.title("Fatal Error!");
//              noti.text("We Can't continue, Please choose one user.");
//              noti.position(Pos.CENTER);
//              noti.hideAfter(Duration.seconds(3));
//              noti.showError();
//          }
//          else {
//              ////////////////////////Copy All Here/////////////////////////
//              String theuser=myuser.getSelectionModel().getSelectedItem().toString();
//              String dateandtime=value111 +" - "+value000;
//              
//              
//    FileChooser fcho = new FileChooser();
//    String go = NewDir.file_dir;
//    fcho.setInitialDirectory(new File(go));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
//    fcho.setTitle("Kady Choose");
//    File f = fcho.showOpenDialog((Window)null);
//    String thename=f.getName().replace(".ks","").replace(".html","");
//    String pathy = f.getAbsolutePath().toString();
//    BufferedReader buf = new BufferedReader(new FileReader(pathy));
//    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\index.html"));
//    pw.append("<html lang=\"ar\">\n<head>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
//    String line;
//    while ((line = buf.readLine()) != null)  
//      pw.append(line.replace(" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd.\" style=\"border-color:black;border-width:10px;\">","").replace("<b>Mr_Moharam Signature: </b><img src=\"file://Z:\\Models\\Mr_Moharam.png\"","").replace("<b>Mr_Mohammed Signature: </b><img src=\"file://Z:\\Models\\Mr_Mohammed.png\"","") + "\n"); 
//     
//    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>");
//    
//    
//    
//    pw.close();
//    buf.close();
//    Desktop desk = Desktop.getDesktop();
//    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\index.html"));
//    
//     ///////////////Modify DB and Signature////////////////
//          
//          String filename=f.getName().replace(".html","").replace(".ks","");
//          Date currentDate = GregorianCalendar.getInstance().getTime();
//          DateFormat df = DateFormat.getDateInstance();
//          String dateString = df.format(currentDate);
//          Date d = new Date();
//          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//          String timeString = sdf.format(d);
//          String value0 = timeString;
//          try{
//              
//             String sql= "update Creation set Name='"+filename+"',Date='"+value0+"',Type='Pending', Revised_Date='Not_Revised' where Name='"+filename+"'";
//
//                pst=conn.prepareStatement(sql);
//                pst.execute();
//              }catch(Exception e){    
//            }
//            finally {
//                try{
//                    rs.close();
//                    pst.close();
//                }
//                catch(Exception e){
//                }
//          }
//          //////////////////////////////////////////////////////
//          
//    
//    this.saverecipe.setDisable(false);
//    
//    
//    
//          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            ////////////////////////////////////Audit/////////////////////////////////////
//          
////    Date currentDate = GregorianCalendar.getInstance().getTime();
////    DateFormat df = DateFormat.getDateInstance();
////    String dateString = df.format(currentDate);
////    Date d = new Date();
////    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////    String timeString = sdf.format(d);
//    String value1 = timeString;
//    
//    ////////////////Machine ID////////////////
//    
//     String command="wmic bios get serialnumber";
//              StringBuffer output=new StringBuffer();
//              try {
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                       output.append(linee+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
//                   //System.out.println(MachineID);
//    
//    //////////////////////////////////////////
//          
//          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
//          this.pst = this.conn.prepareStatement(sqla);
//          this.pst.setString(1, dateandtime);
//          this.pst.setString(2, theuser);
//          this.pst.setString(3, MachineID);
//          this.pst.setString(4, theuser+" is editing a recipe called "+thename);
//          
//          this.pst.execute();
//              }
//              catch (Exception e) {
//          JOptionPane.showMessageDialog(null, e);
//        } finally {
//          try {
//            this.rs.close();
//            this.pst.close();
//          } catch (Exception exception) {}
//        }  
//          
//          
//          //////////////////////////////////////////////////////////////////////////////
//          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    
//              
//              //////////////////////////////////////////////////////////////
//          }
//      }
//      else if (option.get() == ButtonType.CANCEL) {
//      Notifications noti = Notifications.create();
//      noti.title("Cancel!");
//      noti.text("Operation Cancelled, Recipe wasn't edited.");
//      noti.position(Pos.CENTER);
//      noti.hideAfter(Duration.seconds(3));
//      noti.showInformation();
//      } else {
//         
//      }
//      
//      /////////////////////////////////////////END/////////////////////////////////////
//      
      
      
          
          
    
    
  }
  
  /////////////////////////////////////////////////////Ahmed Elkady/////////////////////////////////////////////////////////////
  
  @FXML
  void editediteditaction(ActionEvent event) throws FileNotFoundException, IOException {
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Edit_A_Recipe.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Edit a Recipe");
    stg.centerOnScreen();
    stg.setResizable(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    Stage jk = (Stage)this.textarea.getScene().getWindow();
    jk.setIconified(true);
      
//      
//      //////////////////////////////////////START///////////////////////////////////////
//      
//      Date currentDate1 = GregorianCalendar.getInstance().getTime();
//      DateFormat df1 = DateFormat.getDateInstance();
//      String dateString1 = df1.format(currentDate1);
//      Date d1 = new Date();
//      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
//      String timeString1 = sdf1.format(d1);
//      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
//      String timeString2 = sdf2.format(d1);
//      String value000 = timeString1;
//      String value111 = timeString2;
//      ComboBox myuser=new ComboBox ();
//      myuser.setMinSize(150, 30);
//      myuser.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
//      myuser.setPromptText("Choose One");
//      myuser.setOnShown(evt -> {
//          myuser.getItems().clear();
//         try {
//             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
//             String line;
//             while ((line = buf.readLine()) != null) {
//             myuser.getItems().addAll(new String[] { line });
//          } 
//          buf.close();
//          } catch (FileNotFoundException fileNotFoundException) {
//    
//          } catch (IOException iOException) {}
//      });
//      
//      
//      
//      Alert alert = new Alert(AlertType.WARNING);
//      alert.setTitle("Choose Responsible");
//      alert.setHeaderText("Please be careful, this info is important.");
//      alert.setContentText("Hello, Please tell me: Who are you?.");
//      alert.setGraphic(myuser);
//      alert.setResizable(false);
//      DialogPane dialogPane = alert.getDialogPane();
//      dialogPane.getStylesheets().add(
//    getClass().getResource("primer-dark.css").toExternalForm());
//      Optional<ButtonType> option = alert.showAndWait();
//      if (option.get() == null) {} 
//      else if (option.get() == ButtonType.OK) {
//          if (myuser.getSelectionModel().getSelectedItem()==null) {
//              Notifications noti = Notifications.create();
//              noti.title("Fatal Error!");
//              noti.text("We Can't continue, Please choose one user.");
//              noti.position(Pos.CENTER);
//              noti.hideAfter(Duration.seconds(3));
//              noti.showError();
//          }
//          else {
//              ////////////////////////Copy All Here/////////////////////////
//              String theuser=myuser.getSelectionModel().getSelectedItem().toString();
//              String dateandtime=value111 +" - "+value000;
//              
//              
//              FileChooser fcho = new FileChooser();
//    String go = NewDir.file_dir;
//    fcho.setInitialDirectory(new File(go));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
//    fcho.setTitle("Kady Choose");
//    File f = fcho.showOpenDialog((Window)null);
//    String thename=f.getName().replace(".ks","").replace(".html","");
//    String pathy = f.getAbsolutePath().toString();
//    BufferedReader buf = new BufferedReader(new FileReader(pathy));
//    
//    
//    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
//    pw.append("<!DOCTYPE html>\n" +
//"<html lang=\"ar\">\n" +
//"<head>\n" +
//"    <meta charset=\"utf-8\" />\n" +
//"    <title></title>\n" +
//"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" />\n" +
//"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\" />\n" +
//"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-dialog.min.css\" />\n" +
//"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-tour.min.css\" />\n" +
//"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346\" rel=\"stylesheet\" type=\"text/css\">\n" +
//"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346&amp;g=1\" rel=\"stylesheet\" type=\"text/css\">\n" +
//"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\" type=\"text/javascript\"></script>\n" +
//"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n" +
//"    <script src=\"https://cdn.bookingtimes.com/Scripts/jquery.slicknav.min.js\" type=\"text/javascript\"></script>\n" +
//"    <script src=\"https://cdn.bookingtimes.com/Scripts/bootstrap-tour.min.js\" type=\"text/javascript\"></script>\n" +
//"    <script src=\"./Scripts/tiny_mce/tinymce.min.js\" type=\"text/javascript\"></script>\n" +
//"    <style>\n" +
//"        #menuContainer {\n" +
//"        background-color: black;\n" +
//"        }\n" +
//"    </style>\n" +
//"    <script>\n" +
//"        $(document).ready(function () {\n" +
//"            $(\".modal\").on('shown', function () {\n" +
//"                $(this).find(\"[autofocus]:first\").focus();\n" +
//"            });\n" +
//"            $('.modal').on('hidden.bs.modal', function () {\n" +
//"                imageSelected(0, 0);\n" +
//"            })\n" +
//"        });\n" +
//"        tinyMCE.init({\n" +
//"            mode: \"specific_textareas\",\n" +
//"            editor_selector: \"mceEditor\",\n" +
//"            cleanup: false,\n" +
//"			plugins: \"link,code,insertdatetime,preview,paste,table,visualblocks,fullscreen,image,emoticons,textcolor,colorpicker,lists,charmap,hr,print,autosave,charmap,codesample,colorpicker,fullpage,save,searchreplace,image,imagetools,help\",                         // Theme options - button# indicated the row# only\n" +
//"            menu: {\n" +
//"			    file: { title: 'File', items: 'print save |     autosave  charmap  codesample    | colorpicker fullpage searchreplace image imagetools' },\n" +
//"                edit: { title: 'Edit', items: 'undo redo  | cut copy paste pastetext selectall | searchreplace' },\n" +
//"                format: { title: 'Format', items: 'strikethrough superscript subscript | removeformat' },\n" +
//"                view: { title: 'View', items: 'visualblocks visualaid | preview fullscreen | code' },\n" +
//"                table: { title: 'Table', items: 'inserttable tableprops deletetable | cell row column' },\n" +
//"				about: { title: 'About', items: 'help' }\n" +
//"            },\n" +
//"            images_dataimg_filter: function (img) {\n" +
//"            return img.hasAttribute('internal-blob');\n" +
//"            },\n" +
//"            toolbar1: \"formatselect , fontsizeselect | bold italic underline |  outdent indent | bullist numlist | alignleft aligncenter alignright |  forecolor backcolor  |  inserttable tableprops deletetable | cell row column  |  table save print imagetools image noneditable fullpage fullscreen code autosave bbcode emoticons emotions | preview \",\n" +
//"            style_formats: [{ title: 'h1', block: 'h1' },\n" +
//"            { title: 'h2', block: 'h2' },\n" +
//"            { title: 'h3', block: 'h3' },\n" +
//"            { title: 'h4', block: 'h4' },\n" +
//"            { title: 'h5', block: 'h5' }],\n" +
//"            visualblocks_default_state: false,\n" +
//"            end_container_on_empty_block: true,\n" +
//"            resize: 'both',\n" +
//"            browser_spellcheck: true,\n" +
//"            paste_text_sticky: true,\n" +
//"            paste_data_images: true,\n" +
//"            inline_styles: true,\n" +
//"            schema: 'html5',\n" +
//"            valid_children: \"+body[style|meta],+a[*],+input[*],+a[div|p|span],+input[div|p|span]\",\n" +
//"            extended_valid_elements: \"div[*],iframe[*],,a[*],p[*],img[*],input[*],script[*],meta[*]\",\n" +
//"            allow_html_in_named_anchor: true,\n" +
//"            remove_script_host: false,\n" +
//"            convert_urls: false,\n" +
//"            branding: false,\n" +
//"            encoding: \"UTF-8\",\n" +
//"            block_formats: 'Paragraph=p;Heading 2=h2;Heading 3=h3;Heading 4=h4;Heading 5=h5;Heading 6=h6;Address=address;Pre=pre',\n" +
//"            theme_advanced_blockformats: 'p,address,pre,h1,h2,h3,h4,h5',\n" +
//"            theme_advanced_buttons1_add_before: \"h1,h2,h3,h4,h5,h6,separator\",\n" +
//"            theme_advanced_resizing: true,\n" +
//"            init_instance_callback: function () { if (typeof tinyMCE_Init == \"function\") { tinyMCE_Init(); } },\n" +
//"        });\n" +
//"    </script>\n" +
//"</head>\n" +
//"<body>\n" +
//"<center>\n" +
//"        <div class=\"col-sm-9\">\n" +
//"        <textarea rows=\"2\" cols=\"20\" id=\"txtBody\" class=\"mceEditor\" autocomplete=\"off\" style=\"height: 800px; width: 100%;\" aria-hidden=\"true\">\n" +
//"			\n" +
//"			\n" +
//"			");
//    String line;
//    while ((line = buf.readLine()) != null)  
//      pw.append(line.replace(" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">","").replace("<b>Mr_Moharam Signature: </b><img src=\"file://Z:\\Models\\Mr_Moharam.png\"","").replace("<b>Mr_Mohammed Signature: </b><img src=\"file://Z:\\Models\\Mr_Mohammed.png\"","") + "\n"); 
//     
//    pw.append("			\n" +
//"			\n" +
//"			</textarea>\n" +
//"\n" +
//"        </div>\n" +
//"    </div>\n" +
//"</center>\n" +
//"</body>\n" +
//"</html>");
//    
//   
//    
//    pw.close();
//    buf.close();
//    Desktop desk = Desktop.getDesktop();
//    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
//    
//     ///////////////Modify DB and Signature////////////////
//          
//          String filename=f.getName().replace(".html","").replace(".ks","");
//          Date currentDate = GregorianCalendar.getInstance().getTime();
//          DateFormat df = DateFormat.getDateInstance();
//          String dateString = df.format(currentDate);
//          Date d = new Date();
//          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//          String timeString = sdf.format(d);
//          String value0 = timeString;
//          try{
//              
//             String sql= "update Creation set Name='"+filename+"',Date='"+value0+"',Type='Pending',Revised_Date='Not_Revised' where Name='"+filename+"'";
//
//                pst=conn.prepareStatement(sql);
//                pst.execute();
//              }catch(Exception e){    
//            }
//            finally {
//                try{
//                    rs.close();
//                    pst.close();
//                }
//                catch(Exception e){
//                }
//          }
//          //////////////////////////////////////////////////////
//          
//    
//    this.saverecipe.setDisable(false);
//    
//    
//    
//          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//            ////////////////////////////////////Audit/////////////////////////////////////
//          
////    Date currentDate = GregorianCalendar.getInstance().getTime();
////    DateFormat df = DateFormat.getDateInstance();
////    String dateString = df.format(currentDate);
////    Date d = new Date();
////    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////    String timeString = sdf.format(d);
//    String value1 = timeString;
//    
//    ////////////////Machine ID////////////////
//    
//     String command="wmic bios get serialnumber";
//              StringBuffer output=new StringBuffer();
//              try {
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                       output.append(linee+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
//                   //System.out.println(MachineID);
//    
//    //////////////////////////////////////////
//          
//          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
//          this.pst = this.conn.prepareStatement(sqla);
//          this.pst.setString(1, dateandtime);
//          this.pst.setString(2, theuser);
//          this.pst.setString(3, MachineID);
//          this.pst.setString(4, theuser+" is editing a recipe called "+thename);
//          
//          this.pst.execute();
//              }
//              catch (Exception e) {
//          JOptionPane.showMessageDialog(null, e);
//        } finally {
//          try {
//            this.rs.close();
//            this.pst.close();
//          } catch (Exception exception) {}
//        }  
//          
//          
//          //////////////////////////////////////////////////////////////////////////////
//          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    
//              
//              //////////////////////////////////////////////////////////////
//          }
//      }
//      else if (option.get() == ButtonType.CANCEL) {
//      Notifications noti = Notifications.create();
//      noti.title("Cancel!");
//      noti.text("Operation Cancelled, Recipe wasn't edited.");
//      noti.position(Pos.CENTER);
//      noti.hideAfter(Duration.seconds(3));
//      noti.showInformation();
//      } else {
//         
//      }
//      
//      /////////////////////////////////////////END/////////////////////////////////////
//      
//      
      
          
          
    
    
  }
  
  
  ////////////////////////////////////////////////////////Aiar//////////////////////////////////////////////////////////////////
  
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
  void deleterowaction(ActionEvent event) {
    
      
      
      String code = (String)this.view.getEngine().executeScript("document.documentElement.outerHTML");
      org.jsoup.nodes.Document document = org.jsoup.Jsoup.parse(code);
      for( org.jsoup.nodes.Element element : document.select("td:eq(5)")) {
                String content = element.getElementsMatchingOwnText("N/A").text();
                if(content.equalsIgnoreCase("N/A")) {
                    element = element.parent();
                    element.remove();
                }
            }
         code = document.toString();
         view.getEngine().loadContent(code);
      
         
         
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
    
    
    
    view.setOnKeyReleased(gg -> {
          
        
    String p1 = NewDir.file_dir;
    String p2 = this.customer.getText();
    String p3 = this.washname.getText().replace(" ", "_");
    String stagename = this.stage.getSelectionModel().getSelectedItem();
    File gkk = new File(p1 + "\\" + stagename + "\\" + p2) ;
    String code = (String)this.view.getEngine().executeScript("document.documentElement.outerHTML");
    File gk = new File(p1 + "\\" + stagename + "\\" + p2 + "\\" + p3 + ".ks");
        try {
            gk.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(RecipeMakerController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    gkk.mkdirs();
    try {
      OutputStream instream=new FileOutputStream(gk);
      PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
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
   // this.units.getItems().addAll(new String[] { "KG", "GR", "GARDAL", " " });
  //  this.stage.getItems().addAll(new String[] { "DEVELOPMENT", "PRODUCTION", "PILOT", "BLANKET", "SHRINK" });
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
