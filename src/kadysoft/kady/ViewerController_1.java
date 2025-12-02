package kadysoft.kady;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import static kadysoft.kady.ViewerController_1.drib;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import org.xhtmlrenderer.simple.Graphics2DRenderer;
import org.xml.sax.InputSource;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.geometry.Bounds;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.stage.Popup;
import javafx.stage.Screen;
import org.xml.sax.SAXException;

public class ViewerController_1  <T extends Comparable<T>>  implements Initializable {
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  ToggleGroup tg;
  
  @FXML
  private TableView table;
  
 // private TableView<ObservableList<String>> table;
  private ObservableList<String> storedRowData = null;
  
  
  
  @FXML
  private Hyperlink link;
  
  @FXML
  private JFXRadioButton date;
  
  @FXML
  private JFXTextField content;
  
  @FXML
    private WebView addo;
  
  @FXML
    private JFXButton performance;
  
  @FXML
  private JFXRadioButton stage;
  
  @FXML
  private CheckBox audit;
  
  @FXML
    private JFXButton openrecipesfolder,printic,getallbtn1;

    @FXML
    private JFXButton editorprint,chemicalplan;
  
  @FXML
  private JFXRadioButton model;
  
  @FXML
  private JFXRadioButton name;
  
  @FXML
  private JFXButton getallbtn,coster,aiaraiar;
  
  @FXML
  private Label adslabel,tablee,image;
  
  @FXML
  private ImageView adsimage;
  
//  @FXML
//  private Rectangle rectangle;
  
 
  
  @FXML
    private WebView marque;
  
  @FXML
  private JFXTextArea coode;
  
  public static String letterr,imoo,imoo1,imoo2,hihi;
  
  @FXML
  private JFXButton seepilot,timer;
  
  public static String useb,drib;
  
  @FXML
    private JFXButton recipeprocesses;

    @FXML
    private JFXButton calculatetime,coasterbtn;

    @FXML
    private Label openadmin;
    
    
    public static String theuserrr,passwordyyy;
    
   // List<String> messages;  
    
    
    
     public static String find;
  
    private double dx = 2; // سرعة X
    private double dy = 2; // سرعة Y
    private final Random random = new Random();
  
  
    public static String lproduct,rproduct,tempraturee,ftank,etank,cdosage,timer_temprature,oldtimemin,oldtimehour,oldtimemin2,oldtimehour2,msg;
    
    public static String passy,passyy,wifi;
    
    public static double loadstone,loadstone2;
    public static double removestone,removestone2;
    public static double cleaningstone,cleaningstone2;
    public static double extraction,extraction2;
    public static double loadremovestone,loadremovestone2;
    public static double loadremoveproduct,loadremoveproduct2,loadremoveproductall;
    public static double tempraturetime,tempraturetime2,tempraturetimeall;
    public static double chemicaldosage,chemicaldosage2,chemicaldosageall;
    public static double fillemptytank,fillemptytank2,fillemptytankall;
    public static double gdf1,gdf2,gmf1,gmf2;
    
    public static double stonabathth,stonabaththh;
    
    public static Elements domy;
    
    public static int bosbos,shoty;
  
  //////////////////////////////////////////////
  public static String bosboss;
  
  
  
      public static String stonn;
      public static String fomm;
      public static String hypoo;
      public static String enzymm;
      public static String moonn;
      public static String dryr11;
      public static String dryr22;
      public static String dryr33;
      
      public static String notifile;
      public static String notiimg;
      
      public static String repeats;
      public static String closes;
      
      public static double repeatd;
      public static double closed;
      
      Timer fileCheckTimer;
      
      Timer fileCheckTimer2;
      
      Timer fileCheckTimer3;
      
    @FXML
    private ImageView searchrecipe;
      
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



private int currentStep = 0;
private List<TourStep> steps = new ArrayList<>();
private Pane overlayPane;
String CONFIG_FILE = "config.txt";
@FXML private StackPane mainRoot;


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      
  
    
    @FXML
    private ListView<String> steplist;
    
    
    @FXML
    private JFXTextArea aero;
    
 
    
     @FXML
    void searchrecipeaction(MouseEvent event) {

        
        FileSearchApp fsa=new FileSearchApp();
        fsa.start(new Stage());
        
    }
    
    
     @FXML
    void coasteraction (ActionEvent event) throws IOException {
        
    Desktop dfdsg=Desktop.getDesktop();
    dfdsg.open(new File ("Coaster.exe"));
        
    }
    
    
    
    
    
    
    
    
     @FXML
    void chemicalplanaction(ActionEvent event) throws IOException {
        
        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Chemical_Planner.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Chemical Plan");
    stg.setResizable(true);
    stg.setScene(sce);
    stg.setMaximized(true);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
    }
    
    
    @FXML
    void performanceaction(ActionEvent event) throws IOException {
        
        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Performance.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Worker Performance");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
    }
    
    
    @FXML
    void aiaraiaraction(ActionEvent event) throws IOException {
        
        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Aiar.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("AIAR TOOL");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
    }
    
    
    
    
    
    
     @FXML
    void calculatetimeaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {

          String opaa=openadmin.getText();
        
        if (opaa.equals("Open Admin")) {
            
            //Noti to open admin
            
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Open Admin First.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
            
        }
        
        
        else {
            
            
            //Cal Time Here
            
            //oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
            
            
               
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();

InputStream inputinstream=new FileInputStream(recipepathy);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
coode.clear();
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
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\iq.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();

   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
   
   File inputFile = new File(System.getProperty("user.home")+"\\iq.ks"); //
   org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8"); //
   for (Element table : doc.select("tbody")) {
   for (Element row : table.select("tr")) {
   Elements tds = row.select("td");
   if (tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_]+")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
   else {
   String stringg=tds.get(2).text().replace(" CONT","").replace(" CONG","").replace("CONG","").replace(" cont","").replace(" CNTRL","").replace(" control","").replace(" CONTROL","").replace(" con","").replace(" CON","").replace(" CNTRL","").replace(" KONTROL","").replace("CONT","").replace("cont","").replace("CNTRL","").replace("control","").replace("CONTROL","").replace("con","").replace("CON","").replace("CNTRL","").replace("KONTROL","");
   
   if (stringg.contains("+")) {
   String sum1 = stringg;
   String[] numbers1 = sum1.split("\\+");
   int total1 = 0;
   for (String numStr1 : numbers1) {
   total1 += Integer.parseInt(numStr1);
   }
   time.add(total1);
   }
   
   else {
   int ioo=Integer.parseInt(stringg);
   time.add(ioo);     
   }
   }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            for (int i = 0; i < time.size(); i++)
                            sum += time.get(i);
                            timeSum.add(sum);
                            time.clear();
                            shots.add(dalil);}else {
                            
                        
                            
                            }}}
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          firstshot=timeSum.get(0);}
                          else if (shots.size()==2) {
                          firstshot=timeSum.get(0);
                          secondshot=timeSum.get(1)-timeSum.get(0);}
                          else {
                          
                       
                          
                          }
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Temp
   
      //try {
      //BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer_Temp.kady"));
      
      timer_temprature="30";
      
      //buf.close();
      //} catch (FileNotFoundException fileNotFoundException) {
      //} catch (IOException iOException) {}
   
                            int temp=0;
                            int temp2=0;
                            int temp3=0;
                            String timer_tempra=timer_temprature;
                            int timer_temp=Integer.parseInt(timer_tempra);
                            
                          
                            org.jsoup.nodes.Document docy = Jsoup.parse(inputFile, "UTF-8"); //      
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tempo); 
                                if (cvd2>timer_temp) { 
                                temp2+=1;
                                }
                                else {
                                }}break;
                             }
                            
                            else {
                           
                                String pattern = "[a-zA-Z_ _&_.]+";  
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                temp+=1;
                                }else {}}
                                
                            }}}}
                            
                            int tempall=0;
                            org.jsoup.nodes.Document docc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                String tempo=tds.get(3).text();
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                tempall+=1;}
                                else {}}else {}}}}
                            
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Stone Bath   
   
                            int stonebathh=0;
                            org.jsoup.nodes.Document doccc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : doccc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")||tds.get(7).text().matches("[0-9_-]+")) {}
                            else {
                            String erw=tds.get(7).text().toString();
                            if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL"))  {
                            stonebathh+=1;  
                            }else {}}}}
   
                            
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Get Water Bath  
    
    
                            
        
                            int waterbath=0;
                            int waterbath2=0;
                            org.jsoup.nodes.Document docu = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docu.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            if (tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tds.get(4).text()); 
                                waterbath2+=1;
                                
                                }
                                
                                break;
                                
                            }
                            
                            
                            else {
                           
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tds.get(4).text()); 
                               
                                waterbath+=1;
                                
                                }
                                
                            }
                            
                           }}}
                            
        
        
        
                            int waterbathall=0;
                            org.jsoup.nodes.Document dock = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : dock.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(4).text().isEmpty()||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else { 
                            String erw=tds.get(4).text().toString();
                            waterbathall+=1;
                            }}}
        
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Read Vars From File  
   
  //  try {
    //  BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer.kady"));
      
      lproduct="2.45";
      rproduct="0.5";
      tempraturee="1.5";
      ftank="1.5";
      etank="3.55";
      cdosage ="6.3";
      
    //  buf.close();
    //  } catch (FileNotFoundException fileNotFoundException) {
    //  } catch (IOException iOException) {}
   
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    String lproductt=lproduct;
    String rproductt=rproduct;
    String tempratureee=tempraturee;
    String ftankk=ftank;
    String etankk=etank;
    String cdosagee=cdosage;
    
    int bathnumm=bathnum;
    
    bosbos=bathnum;
    
    double firstshott=firstshot;
    double secondshott=secondshot;
    
    int tempp=temp;
    int tempp2=tempall-temp;
    int temppall=tempall;
    
    int waterbathx=waterbath;
    int waterbath2x=waterbathall-waterbath;
    int waterbathallx=waterbathall;
    
    int stonebathhh=stonebathh;
    
    loadremoveproduct=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime=tempp*Double.parseDouble(tempratureee);
    chemicaldosage=Double.parseDouble(cdosagee);
    fillemptytank=waterbathx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime2=tempp2*Double.parseDouble(tempratureee);
    chemicaldosage2=Double.parseDouble(cdosagee);
    fillemptytank2=waterbath2x*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetimeall=temppall*Double.parseDouble(tempratureee);
    chemicaldosageall=Double.parseDouble(cdosagee);
    fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    //Alert for Bath Here
    
    
    
    if (bathnumm==1) {
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
        
    }
    
    else if (bathnumm==2) {
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      ///////////yrtyrty///////////
      
      JFXTextField fsss=new JFXTextField ("");
      fsss.setPromptText("Write Stone Baths Number");
      fsss.setMinSize(300, 30);
      fsss.setLabelFloat(true);
      fsss.setStyle("-fx-font-weight:bold;");
      fsss.setEditable(true);
      Alert alertoo = new Alert(Alert.AlertType.INFORMATION);
      alertoo.setTitle("Stone Bath?");
      alertoo.setHeaderText("We found stone or foam "+stonebathhh+" times. for the second shot.");
      alertoo.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoo.setGraphic(fsss);
      alertoo.setResizable(false);
      DialogPane dialogPaneoo = alertoo.getDialogPane();
      dialogPaneoo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoio = alertoo.showAndWait();
      passyy=fsss.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoio.get() == null) {} 
      else if (optionoio.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone2=0;
          removestone2=0;
          cleaningstone2=0;
          extraction2=0;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone2=5.5;
          removestone2=4.15;
          cleaningstone2=15;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone2=16.5;
          removestone2=8.3;
          cleaningstone2=20;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone2=v2;
          removestone2=v1;
          cleaningstone2=0;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoio.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
        
    }
    
     
    
    
    /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
    
    
    if (bathnumm==1) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+"");
aloo.setContentText("This Recipe Was One Shot:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
        
      /////////////////////////////////////////////////////////////////////////////////////////

 
      
    }
    
    else if (bathnumm==2) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
          
          
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+"");
aloo.setContentText("This Recipe Was Two Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////   
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
    
    
    else {
        
        //Noti
        
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, We don't have 3 shots in one recipe.\nWe are working on this feature\nCall Developer to calculate it for you in full version.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(5));
      noti.showError();
    }
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
            
            
            //oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
            
            
            
        }
            
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void openadminaction(MouseEvent event) {
        
        String opa=openadmin.getText();
        
        if (opa.equals("Open Admin")) {
            
            
      theuserrr="KADINIO";  
      //////////Get Password Here From DB//////////////////
      try {
      String sql = "select * from Timor where User=?";
      pst = conn.prepareStatement(sql);
      pst.setString(1, theuserrr);
      rs = pst.executeQuery();
      passwordyyy = rs.getString("Password");
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      } catch (Exception exception) {}
    } 
        
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write your password ...");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.WARNING);
      alerto.setTitle("UR Password?");
      alerto.setHeaderText("Please be careful, this info is important.");
      alerto.setContentText("Hello, Please tell me: your password?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      String passy=fss.getText();
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          if (passy.isEmpty()||passy.equals(" ")) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Password is incorrect or empty.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          }
          else {
              
              //////////Code Here.......
              
              if (passy.equals(passwordyyy)) {
                  
              Notifications noti = Notifications.create();
              noti.title("Great!");
              noti.text("Admin Opened.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showInformation();
              
              openadmin.setText("Close Admin");
                  
                  
              }
              
              else {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Password is incorrect.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
              }
              
              
          }
           
    }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't edited.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {}
    
    
            
            
        }
        
        else {
            
            openadmin.setText("Open Admin");
            
        }
   
      
      
      
      
    } 
    
    
    
    
    
    
    
    @FXML
    void recipeprocessesaction(ActionEvent event) {
        
        //Open Recipe
        //Pull Data
        //Show Alert
        //Add To List
        //Click Create Button To Create A Recipe
        //Start.................................
        
        
      FileChooser fcho = new FileChooser();
      //fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.png"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[]{"*.ks"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      
       ///Decrypt////////////////////////////////////
           try { 
    coode.clear();
    InputStream inputinstream=new FileInputStream(dirpathe);
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
        }catch (Exception g) {}
        //////////////////////////////////////////////

                            
        
       String stages=null;
       int bathnumzzz=0;
       String modu,comment;
    
        int ds=1;
                            Document docy = Jsoup.parse(coode.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")/*||tds.get(3).text().contains("extract")||tds.get(3).text().contains("EXTRACT")||tds.get(3).text().contains("extraction")||tds.get(3).text().contains("EXTRACTION")*/||tds.get(3).text().matches("[0-9]+")||tds.get(3).text().contains("REMOV")||tds.get(3).text().contains("REMOVE")||tds.get(3).text().contains("BATH")||tds.get(3).text().contains("SAME")||tds.get(3).text().contains("PATH")||tds.get(3).text().contains("SAM")||tds.get(3).text().contains("RPM")||tds.get(3).text().contains("KG")||tds.get(3).text().contains("PCS")||tds.get(3).text().contains("DRAIN")||tds.get(3).text().contains("RIMOV")||tds.get(3).text().contains("RIMOVE")) {}
                            else {
                            String tempo=tds.get(3).text();
                            if (tempo.contains("EXTRACT")||tempo.contains("Extract")||tempo.contains("extract")) {
                               
                                stages=stages+"\n"+"WASHING "+Integer.toString(ds++);
                                
                            }
                            
                            else {
                                
                                stages=stages+"\n"+tempo;
                                
                            }
                            }
                            
//                            
//                            String dalil=tds.get(3).text();
//                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
//                            for (int i = 0; i < 5; i++)
//                            shotsa.add(dalil);}else {
//                            }
                           }}
//                            bathnumzzz=shotsa.size();
//             //String arabic=stages.replaceAll("[^\\p{IsArabic}]","");
//             //String english=stages.replace(arabic,"");
//             
//             
        String arabicRegex = "[\\u0600-\\u06FF]+";
        Pattern pattern = Pattern.compile(arabicRegex);
//        
//        if (bathnumzzz==1) {
//            modu=stages+"\nWASHING 1";
//            comment="This Recipe is one shot.";
//        }
//        
//        else if (bathnumzzz==2) {
//            modu=stages+"\nWASHING 1\nnWASHING 2";
//            comment="This Recipe is two shot.";
//        }
//        
//        else if (bathnumzzz==3) {
//            modu=stages+"\nWASHING 1\nnWASHING 2\nnWASHING 3";
//            comment="This Recipe is three shot.";
//        }
//        
//        else {
//            modu=stages+"\nWASHING 1\n...";
//            comment="We Don't Know Number Of Shots.";
//        }
//        
        
        Matcher matcher = pattern.matcher(stages+"");
        String modifiedLine = matcher.replaceAll("\n");
        String lone=modifiedLine.replace("null","\n");
        
        StringBuilder result = new StringBuilder();
        String[] lines = lone.split("\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                result.append(line).append("\n");
            }
        }
             
             
            JFXTextArea kk=new JFXTextArea ();
            kk.setStyle("-fx-font-weight:bold;");
            kk.setEditable(true);
            kk.setText(result+"");
            Alert al=new Alert (Alert.AlertType.ERROR);
            al.setTitle("Recipe Viewer");
            al.setHeaderText("Here is your recipe Stages: ");
            al.setContentText("Please edit me if you found errors, iam not a human. Iam a computer\nMy developer is KADINIO.");
            al.setResizable(false);
            al.setGraphic(kk);
            DialogPane dialogPane = al.getDialogPane();
            dialogPane.getStylesheets().add(
          getClass().getResource("cupertino-light.css").toExternalForm());
            al.showAndWait();
            
           
        
        
    }
  
  
    
    
    
    
    
    
    
    
  
   @FXML
  void timeraction (ActionEvent event) throws IOException {
        
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Reports.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Create Report");
    stg.setResizable(true);
    stg.setMaximized(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
       
//    Stage stg = new Stage();
//    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeTime.fxml"));
//    Scene sce = new Scene(root);
//    stg.setTitle("Recipes Timer");
//    stg.setResizable(false);
//    stg.setScene(sce);
//    stg.centerOnScreen();
//    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
//    stg.show();
        
        
  }
  
  @FXML
  void costeraction (ActionEvent event) throws IOException {
        
       
          
      FileChooser fcho = new FileChooser();
      //fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.png"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[]{"*.ks"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
//      String recipenami=f.getName().replace(".ks","").replace(".html",""); 
      String dirpathe = f.getAbsolutePath().toString();
//      String didd1=NewDir.file_dir+"\\PRODUCTION\\";
//      String didd2="\\"+f.getName();
//      String didd3=NewDir.file_dir+"\\PILOT\\";
//      String modelooo=dirpathe.replace(didd1,"").replace(didd3,"").replace(didd2,"");
       ///Decrypt////////////////////////////////////
           try { 
    coode.clear();
    InputStream inputinstream=new FileInputStream(dirpathe);
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
        }catch (Exception g) {}
        //////////////////////////////////////////////

                            
        
       String proco=null;
       int bathnumzzzz=0;
       String moduu,commentt;
       
       String ston,fom,hypo,enzym,moon,dryr1,dryr2,dryr3;
       
       ston="No";
       fom="No";
       hypo="No";
       enzym="No";
       moon="No";
       dryr1="No";
       dryr2="No";
       dryr3="No";
       
       List<String> shots = new ArrayList<>();
    
       int bathnum=0;
       
        int dss=1;
                            org.jsoup.nodes.Document docy = Jsoup.parse(coode.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            
                            
                            
                            if (tds.get(7).text().contains("stone")||tds.get(7).text().contains("Stone")||tds.get(7).text().contains("STONE")) {
                                
                                ston="STONE";
                                stonn=ston;
                                
                            }
                            
                             else {
                                
                             //   stonn="-";
                               
                                stonn=ston;
                            }
                            
                            if (tds.get(7).text().contains("foam")||tds.get(7).text().contains("Foam")||tds.get(7).text().contains("FOAM")||tds.get(7).text().contains("BOOL")||tds.get(7).text().contains("BOOL فوم")) {
                                
                                fom="FOAM";
                                fomm=fom;
                                
                            }
                            
                             else {
                                
                               
                             //   fomm="-";
                               
                                fomm=fom;
                            }
                            
                            if (tds.get(7).text().contains("BLEACH")||tds.get(7).text().contains("HYPO")) {
                                
                                hypo="BLEACH";
                                hypoo=hypo;
                                
                            }
                            
                             else {
                                
                              
                             //   hypoo="-";
                              hypoo=hypo;
                                 
                                
                            }
                            
                            if (tds.get(7).text().contains("ENZYME")||tds.get(7).text().contains("ENZYM")||tds.get(7).text().contains("ACUDELL")||tds.get(7).text().contains("NSY")) {
                                
                                enzym="ENZYME";
                                enzymm=enzym;
                                
                            }
                            
                             else {
                                
                               
                             //   enzymm="-";
                                enzymm=enzym;
                                
                            }
                             
                            if (tds.get(3).text().contains("MOON WASH")||tds.get(3).text().contains("MOON")||tds.get(3).text().contains("Moon Wash")||tds.get(3).text().contains("MON WASH")) {
                                
                                moon="MOON WASH";
                                moonn=moon;
                                
                            }
                                   
                          
                            else {
                                
                                
                              //  moonn="-";
                                 moonn=moon;
                            }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            shots.add(dalil);}
                            else {
                            
                            
                            
                            }
                            
                           

                           }}
                            
                            
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          dryr1="DRYER 1";
                          dryr11=dryr1;
                          dryr22="No";
                          dryr33="No";
                          }
                          else if (shots.size()==2) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33="No";
                          }
                          else if (shots.size()==3) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr3="DRYER 3";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                          else {
                          dryr1="No";
                          dryr2="No";
                          dryr3="No";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                            
             
            JFXTextArea kk=new JFXTextArea ();
            kk.setStyle("-fx-font-weight:bold;");
            kk.setEditable(true);
            kk.setText("Stone: "+stonn+"\n"+"Foam: "+fomm+"\n"+"Bleach: "+hypoo+"\n"+"Enzyme: "+enzymm+"\n"+"Moon Wash: "+moonn+"\n"+"Dryer 1: "+dryr11+"\n"+"Dryer 2: "+dryr22+"\n"+"Dryer 3: "+dryr33+"\n");
            Alert al=new Alert (Alert.AlertType.ERROR);
            al.setTitle("Recipe Viewer");
            al.setHeaderText("Here is your recipe Type: ");
            al.setContentText("Please edit me if you found errors, iam not a human. Iam a computer\nMy developer is KADINIO.");
            al.setResizable(false);
            al.setGraphic(kk);
            DialogPane dialogPane = al.getDialogPane();
            dialogPane.getStylesheets().add(
          getClass().getResource("cupertino-light.css").toExternalForm());
            al.showAndWait();
            
           
      
      
      
      
      
      
      
      
      
      
//    Stage stg = new Stage();
//    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeCost.fxml"));
//    Scene sce = new Scene(root);
//    stg.setTitle("Recipes Cost");
//    stg.setResizable(false);
//    stg.setScene(sce);
//    stg.centerOnScreen();
//    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
//    stg.show();
//        
        
  }
  
  
  
  
  @FXML
    void tableeaction(MouseEvent event) throws IOException, InterruptedException {

        
        String wsa=link.getText();
        
        if (!wsa.contains(".ks")) {
            
        //Noti to choose one first
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, please choose one first.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
            
        }
        
        else {
      try {
          BufferedReader buf = new BufferedReader(new FileReader("Recipe_Drive_Letter.kady"));
          letterr=buf.readLine().replace("X:",drib);
          buf.close();
      }
      catch (Exception m) {
          
      }
      String pathy = link.getText().replace("\\","\\\\").replace("Z:",letterr+":").replace("X:",letterr+":").replace("V:",letterr+":").replace("W:",letterr+":");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe KADINIO has deleted or encrypted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
        
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
          File tw2o=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
          if (!tw2o.exists()) {
              tw2o.createNewFile();
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
    OutputStream instreamm=new FileOutputStream(tw2o);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println("<style>\n" +
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
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
             + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
       +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>");
    pwe.close();
    coode.clear();
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
       // إنشاء WebView وتحميل ملف HTML محلي
        WebView webviewt = new WebView();
        webviewt.setContextMenuEnabled(false);
        webviewt.setMinSize(1800, 800);
        webviewt.setZoom(1.0); // التكبير الافتراضي 100%

        String lkd = System.getProperty("user.home") + "\\Hehehe\\Roro.html";
        URI uris = Paths.get(lkd).toAbsolutePath().toUri();
        webviewt.getEngine().load(uris.toString());

        // سلايدر للتحكم في الزوم من 10% إلى 200%
        Slider zoomSlider = new Slider(0.1, 2.0, 1.0);
        zoomSlider.setShowTickLabels(true);
        zoomSlider.setShowTickMarks(true);
        zoomSlider.setMajorTickUnit(0.5);
        zoomSlider.setMinorTickCount(4);
        zoomSlider.setBlockIncrement(0.1);

        Label zoomLabel = new Label("Zoom: 100%");

        zoomSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double zoom = newVal.doubleValue();
            webviewt.setZoom(zoom);
            zoomLabel.setText(String.format("Zoom: %.0f%%", zoom * 100));
        });

        // VBox يحتوي على WebView والسلايدر
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        VBox.setVgrow(webviewt, Priority.ALWAYS);
        vbox.getChildren().addAll(webviewt, zoomLabel, zoomSlider);

        // وضع VBox داخل GridPane
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(vbox, 0, 0);

        // إنشاء Alert لعرض المحتوى
        Alert alol = new Alert(Alert.AlertType.INFORMATION);
        alol.setTitle("Preview a recipe");
        DialogPane dialogPane = alol.getDialogPane();
        dialogPane.setContent(gridpane);
        dialogPane.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        alol.setResizable(true);
        alol.showAndWait();
        
//        File nm=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
//        if (pathy.contains(".ks")) {
//          //  nm.delete();
//        }
//        else {
//            
//        }
           
    Thread.sleep(500);
    tw2o.delete();
        
        
      }
         
    } 
        
        
        
        
        
        
        
    }
  
  
  
  
  @FXML
    void imageaction(MouseEvent event) throws InterruptedException, IOException, ParserConfigurationException, SAXException {

 String ksFilePath=link.getText();
        
         if (!ksFilePath.endsWith(".ks")) {
            showNotification("Error", "I can't find the recipe, please choose one first.");
            return;
        }

        // Read Recipe_Drive_Letter.kady for letter replacement (your logic)
        try (BufferedReader buf = new BufferedReader(new FileReader("Recipe_Drive_Letter.kady"))) {
            letterr = buf.readLine().replace("X:", drib);
        } catch (Exception e) {
            // Ignore or log
        }

        String pathy = ksFilePath.replace("\\", "\\\\")
                .replace("Z:", letterr + ":")
                .replace("X:", letterr + ":")
                .replace("V:", letterr + ":")
                .replace("W:", letterr + ":");

        File ksFile = new File(pathy);
        if (!ksFile.exists()) {
            showNotification("Error", "I can't find the recipe, maybe KADINIO has deleted or encrypted it.");
            return;
        }

        // Read .ks file content and do your replacements to get HTML
        StringBuilder coodeText = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ksFile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                coodeText.append("\n").append(
                    line.replace("ﬦ", "A").replace("ﬧ", "B").replace("ﬨ", "C").replace("﬩", "D")
                        .replace("שׁ", "E").replace("שׂ", "F").replace("שּׁ", "G").replace("שּׂ", "H")
                        .replace("אַ", "I").replace("אָ", "J").replace("אּ", "K").replace("בּ", "L")
                        .replace("גּ", "M").replace("דּ", "N").replace("הּ", "O").replace("וּ", "P")
                        .replace("זּ", "Q").replace("טּ", "R").replace("יּ", "S").replace("ךּ", "T")
                        .replace("כּ", "U").replace("לּ", "V").replace("מּ", "W").replace("נּ", "X")
                        .replace("סּ", "Y").replace("ףּ", "Z").replace("פּ", "0").replace("צּ", "1")
                        .replace("קּ", "2").replace("רּ", "3").replace("שּ", "4").replace("תּ", "5")
                        .replace("וֹ", "6").replace("בֿ", "7").replace("כֿ", "8").replace("פֿ", "9")
                        .replace("&NBSP;", "")
                );
            }
        } catch (Exception e) {
            showNotification("Error", "Failed to read recipe file.");
            e.printStackTrace();
            return;
        }

        String htmlContent = coodeText.toString();

        // Choose directory to save the image
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose folder to save the recipe image");
        File selectedDir = directoryChooser.showDialog(null);

        if (selectedDir == null) {
            // User cancelled
            return;
        }

        
        // Prepare output file names
        //String baseFileName = new File(ksFilePath).getName().replace(".ks", "");
        //File pdfFile = new File(selectedDir, baseFileName + ".pdf");
        //File imageFile = new File(selectedDir, baseFileName + ".png");
        //pdfFile.createNewFile();
        //imageFile.createNewFile();
        
    String html = htmlContent;  // replace with your htmlContent
    int width = 5000, height = 3000;
    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
    .getDefaultScreenDevice().getDefaultConfiguration()
    .createCompatibleImage(width, height);
    Graphics graphics = image.createGraphics();
    JEditorPane jep = new JEditorPane("text/html", html);
    jep.setSize(width, height);
    jep.print(graphics);
    String baseFileName = new File(ksFilePath).getName().replace(".ks", "");
    File imageFile = new File(selectedDir, baseFileName + ".png");
    ImageIO.write(image, "png", imageFile);
    Desktop nsdf=Desktop.getDesktop();
    nsdf.open(imageFile);

        
        
    
    

        
    }
  
  
  
 private void showNotification(String title, String message) {
        Platform.runLater(() -> {
            Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
            ImageView imgview = new ImageView(img);
            Notifications noti = Notifications.create()
                    .title(title)
                    .text(message)
                    .graphic(imgview)
                    .position(Pos.CENTER)
                    .hideAfter(Duration.seconds(3));
            noti.show();
        });
  
 }
 
  
  @FXML
  void printicaction(ActionEvent event) throws IOException, InterruptedException {
      
       try {
          BufferedReader buf = new BufferedReader(new FileReader("Recipe_Drive_Letter.kady"));
          letterr=buf.readLine().replace("X:",drib);
          buf.close();
      }
      catch (Exception m) {
          
      }
      
    
                            
      String pathy = link.getText().replace("\\","\\\\").replace("Z:",letterr+":").replace("X:",letterr+":").replace("V:",letterr+":").replace("W:",letterr+":");
      File op = new File(pathy);
      
      
      if (!pathy.contains(".ks")||!pathy.contains(".ks")) {
          
          //Noti
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Please Choose One Recipe First.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
      }
      
      else {
         
          
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    
    OutputStream instreamm=new FileOutputStream("C:\\Editor\\index.html");
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.append("<html lang=\"ar\">\n<head><title>Kadysoft Ltd - Ahmed Elkady.</title>"
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
            
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
            + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
            
         +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"   
            
            
            + ""
            + "\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = bi.readLine()) != null)  
    pwe.append(line
            
            
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
    pwe.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>"); 
    pwe.close();
    bi.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File("C:\\Editor\\index.html")); 
    
    Thread.sleep(4000);
    
    File ggf=new File ("C:\\Editor\\index.html");
    PrintWriter pl=new PrintWriter(new FileWriter(ggf));
    pl.println("Powered By Kadysoft");
    pl.close();
    
      
          
          
      }
      
                            
          
      
      
    /////////////////0000000000000000000000  
  }
  
  
  
  
  @FXML
  void seepilotaction(ActionEvent event) throws IOException {
      
      
   DirectoryViewer hhii=new DirectoryViewer ();
   hhii.start(new Stage());
   
  }
  
  
  
  
  
  
  
  
  
  /////////////////////////////////////////START/////////////////////////////////////////////
  
  private void generateFinalHtml(String bodyContent, String headerText, int fromPage, int toPage,
                               String lotnumber, String entertime, String exittimee) {
    try {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><style>")
            .append("@media print {")
            .append("  body { margin: 0; }")
            .append("  .page { page-break-after: always; break-after: page; }")
            .append("}")
            .append("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: #fafafa; }")
            .append(".page { width: 210mm; height: 297mm; padding: 20mm; box-sizing: border-box; }")

            // تصميم كارد حديث أبيض وأسود
            .append(".header-box {")
            .append("  background: #ffffff;")
            .append("  border: 1.5px solid #333;")
            .append("  padding: 18px;")
            .append("  border-radius: 10px;")
            .append("  margin-bottom: 25px;")
            .append("  display: flex; flex-wrap: wrap; gap: 12px;")
            .append("  box-shadow: 0 2px 6px rgba(0,0,0,0.15);")
            .append("}")
            .append(".info-item {")
            .append("  background: #f2f2f2;")
            .append("  padding: 10px 16px;")
            .append("  border-radius: 6px;")
            .append("  font-size: 14px;")
            .append("  font-weight: bold;")
            .append("  color: #000;")
            .append("  border: 1px solid #ccc;")
            .append("}")
            .append("</style></head>")

            // منع التعديل والـ contextmenu
            .append("<body oncontextmenu='return false;' contenteditable='false'>");

        for (int i = fromPage; i <= toPage; i++) {
            html.append("<div class='page'>")
                .append("<div class='header-box'>")
                .append("<div class='info-item'>Patch NO: ").append(i).append("</div>")
                .append("<div class='info-item'>Entry Time: ").append(entertime).append("</div>")
                .append("<div class='info-item'>Exit Time: ").append(exittimee).append("</div>")
                .append("<div class='info-item'>LOT Number: ").append(lotnumber).append("</div>")
                .append("</div>")
                .append(bodyContent)
                .append("</div>");
        }

        html.append("</body></html>");

        File file = File.createTempFile("html_print_pages_", ".html");
try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
    writer.write(html.toString());
}


        String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; 
        new ProcessBuilder(chromePath, file.getAbsolutePath()).start();

    } catch (IOException e) {
        showAlert("Error", "Failed to generate or open the HTML file.");
        e.printStackTrace();
    }
}

  
  
//  
//   private void generateFinalHtml(String bodyContent, String headerText, int fromPage, int toPage, String lotnumber,String entertime, String exittimee) {
//        
//        try {
//            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
//            //String currentTime = formatter.format(LocalDateTime.now());
//            
//            
//
//            StringBuilder html = new StringBuilder();
//            html.append("<html><head><style>")
//                .append("@media print {")
//                .append("  body { margin: 0; }")
//                .append("  .page { page-break-after: always; break-after: page; }")
//                .append("}")
//                .append("body { font-family: Arial, sans-serif; margin: 0; padding: 0; }")
//                .append(".page { width: 210mm; height: 297mm; padding: 20mm; box-sizing: border-box; }")
//                .append(".header { font-weight: bold; font-size: 16pt; margin-bottom: 20px; }")
//                .append("</style></head><body>");
//
//            for (int i = fromPage; i <= toPage; i++) {
//                
//    html.append("<html>")
//    .append("<head>")
//    .append("<style>")
//    .append(".page { padding: 20px; font-family: Arial, sans-serif; }")
//    .append(".header-box {")
//        .append("border: 2px solid #444;")
//        .append("padding: 15px;")
//        .append("border-radius: 10px;")
//        .append("background-color: #f9f9f9;")
//        .append("margin-bottom: 20px;")
//        .append("display: flex;")
//        .append("flex-wrap: wrap;")
//        .append("gap: 10px;")
//    .append("}")
//    .append(".info-item {")
//        .append("background-color: #e0e0e0;")
//        .append("padding: 10px 15px;")
//        .append("border-radius: 8px;")
//        .append("box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);")
//        .append("font-size: 14px;")
//    .append("}")
//    .append("</style>")
//    .append("</head>")
//    .append("<body>")
//
//    .append("<div class='page'>")
//        .append("<div class='header-box'>")
//            //.append("<div class='info-item'><strong>Header:</strong> ").append(headerText).append("</div>")
//            .append("<div class='info-item'><strong>Patch NO:</strong> ").append(i).append("</div>")
//            .append("<div class='info-item'><strong>Entry Time:</strong> ").append(entertime).append("</div>")
//            .append("<div class='info-item'><strong>Exit Time:</strong> ").append(exittimee).append("</div>")
//            .append("<div class='info-item'><strong>LOT Number:</strong> ").append(lotnumber).append("</div>")
//        .append("</div>")
//
//        .append(bodyContent)
//
//    .append("</div>")
//
//    .append("</body>")
//    .append("</html>");
//
//            
//            }
//
//            html.append("</body></html>");
//
//            File file = File.createTempFile("html_print_pages_", ".html");
//            try (FileWriter writer = new FileWriter(file)) {
//                writer.write(html.toString());
//            }
//
//            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // Change if needed
//            new ProcessBuilder(chromePath, file.getAbsolutePath()).start();
//
//        } catch (IOException e) {
//            showAlert("Error", "Failed to generate or open the HTML file.");
//            e.printStackTrace();
//        }
//    }
//  
  
  private String readFile(File file) throws IOException {
        InputStream inputinstream=new FileInputStream(file);
        BufferedReader reader=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
        StringBuilder content = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
        content.append(line.replace("ﬦ","A")
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
       .replace("&NBSP;","")).append("\n");
        }
        reader.close();
        return content.toString();
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
  
  
  
  
  
  
  
  
  
  @FXML
    void editorprintaction(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException {
        
        
        
        
        if (audit.isSelected()==true) {
            
            //Audit
            
            
            File selectedHtmlFile;
        
            FileChooser fileChooser = new FileChooser();
            
            
            try {
          BufferedReader buf = new BufferedReader(new FileReader("RecipesPath.kady"));
          hihi=buf.readLine().replace("X:",drib+":");
          buf.close(); 
        } catch (FileNotFoundException ex) {    
        }
        String go = hihi;
        fileChooser.setInitialDirectory(new File(go));
            
            
            fileChooser.setTitle("Select Kadysoft File");
            fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("KADYSOFT Files", "*.ks")
            );
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                selectedHtmlFile = file;
                
                
        ////////////////////////////////////////////////////////////////
                
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Info & Range");
        //dialog.setWidth(1000);
        //dialog.setResizable(true);
        TextField headerField = new TextField("كل حاجة تمت بحب بواسطة كادي سوفت");
        headerField.setDisable(true);
        //headerField.setPromptText("Enter header text (bold)");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss a");
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.ofHours(3));
        String timeString = dtf.format(now);
        
        TextField enterr = new TextField(timeString);
        enterr.setPromptText("أدخل وقت الدخول ");
        
        TextField exitt = new TextField("04:00:00 PM");
        exitt.setPromptText("أدخل وقت الخروج ");
        
        TextField fromField = new TextField();
        fromField.setPromptText("(المكن) من");
        
        TextField toField = new TextField();
        toField.setPromptText("(المكن) الي");
        
        TextField lotnum = new TextField();
        lotnum.setPromptText("رقم اللوت");
        
        VBox vbox = new VBox(10,
            new Label("أدخل العنوان الرئيسي"), headerField,
            new Label("أدخل رينج المكن من والي"),
            new HBox(10, new Label("من"), fromField, new Label("الي:"), toField,
            new Label("رقم اللوت: "),lotnum),
                
            new HBox(10, new Label("وقت الدخول"), enterr,
            new Label("وقت الخروج"), exitt)
        );
        vbox.setMinSize(800, 180);
        vbox.setStyle("-fx-padding: 10;");
        dialog.getDialogPane().setContent(vbox);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        String css = getClass().getResource("cupertino-light.css").toExternalForm();
        dialog.getDialogPane().getStylesheets().add(css);
        
        dialog.showAndWait().ifPresent(type -> {
            if (type == ButtonType.OK) {
                String headerText = headerField.getText().trim();
                String fromStr = fromField.getText().trim();
                String toStr = toField.getText().trim();
                String lotnumber = lotnum.getText().trim();
                String entertime=enterr.getText().trim();
                String exittimee=exitt.getText().trim();
                if (headerText.isEmpty() || fromStr.isEmpty() || toStr.isEmpty()|| lotnumber.isEmpty()|| entertime.isEmpty()|| exittimee.isEmpty()) {
                    showAlert("Error", "All fields are required.");
                    return;
                }

                try {
                    int from = Integer.parseInt(fromStr);
                    int to = Integer.parseInt(toStr);
                    if (from > to || from < 1) {
                        showAlert("Error", "Invalid page range.");
                        return;
                    }
                    String content = readFile(selectedHtmlFile);
                    
                    ///////////////////////////////////////////////////////////FGHFFGHF////////////////////////////////////////////////
                    
//                       //Time Query

                     

//            DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("hh"); //Hour
//            String currentTimee = formatterr.format(LocalDateTime.now());
//            String ho=currentTimee;
//            System.out.println(ho);
//            
//            DateTimeFormatter formatterrr = DateTimeFormatter.ofPattern("mm"); //Minutes
//            String currentTimeee = formatterrr.format(LocalDateTime.now());
//            String min=currentTimeee;
//            System.out.println(min);
//                 
//        String path = selectedHtmlFile.getAbsolutePath().toString();
//        String[] parts = path.split("\\\\");
//        String modo = parts[parts.length - 2];
//        String wasshh = parts[parts.length - 1];
//        String wassh = wasshh.replace(".ks","");
//        
//        System.out.println(modo);
//        System.out.println(wassh);
//        
//        String timo;
//
//       
//double totalTime = 0;
//boolean found1 = false;
//boolean found2 = false;
//boolean found3 = false;
//
//// Query for Shot 1
//String queryShot1 = "SELECT * FROM Timer WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//pst = conn.prepareStatement(queryShot1);
//pst.setString(1, "%" + wassh + "%");
//pst.setString(2, "%" + modo + "%");
//pst.setString(3, "%1%");
//rs = pst.executeQuery();
//while (rs.next()) {
//    found1 = true;
//    found3 = true;
//    String proc = rs.getString("Time_In_Hour_Updated");
//    if (proc.equals("Hasnot_Updated_Yet")) {
//        proc = rs.getString("Time_In_Hour");
//    }
//    totalTime += Double.parseDouble(proc);
//}
//
//// Query for Shot 2
//String queryShot22 = "SELECT * FROM Timer WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//pst = conn.prepareStatement(queryShot22);
//pst.setString(1, "%" + wassh + "%");
//pst.setString(2, "%" + modo + "%");
//pst.setString(3, "%2%");
//rs = pst.executeQuery();
//while (rs.next()) {
//    found2 = true;
//    found3 = true;
//    String proc = rs.getString("Time_In_Hour_Updated");
//    if (proc.equals("Hasnot_Updated_Yet")) {
//        proc = rs.getString("Time_In_Hour");
//    }
//    totalTime += Double.parseDouble(proc);
//}
//
//if (found1 && found2) {
//    System.out.println("Shot 1 and 2 found. Total time: " + totalTime);
//} else if (found1) {
//    System.out.println("Only Shot 1 found. Time: " + totalTime);
//} else if (found2) {
//    System.out.println("Only Shot 2 found. Time: " + totalTime);
//} else {
//    System.out.println("No shots found.");
//}
//
//timo = String.valueOf(totalTime); // Store final time as string
//
//double d1=Double.parseDouble(timo);
//double d2=Double.parseDouble(ho);
//double d3=d1+d2;
//double d4=Math.ceil(d3);
//int d5=(int) d4;
//String exttimeo=Integer.toString(d5);
//
//
//    if (found3==false) {
//       
//double totalTimee = 0;
//boolean foundShot1 = false;
//boolean foundShot2 = false;
//boolean foundShot3 = false;
//
//// Array of shot numbers
//int[] shots = {1, 2, 3};
//
//for (int shot : shots) {
//    String query = "SELECT Time_In_Hour_Updated, Time_In_Hour FROM Timer_Three_Shots WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//    pst = conn.prepareStatement(query);
//    pst.setString(1, "%" + wassh + "%");
//    pst.setString(2, "%" + modo + "%");
//    pst.setString(3, "%" + shot + "%");
//    rs = pst.executeQuery();
//
//    while (rs.next()) {
//        String time = rs.getString("Time_In_Hour_Updated");
//        if (time.equals("Hasnot_Updated_Yet")) {
//            time = rs.getString("Time_In_Hour");
//        }
//        totalTimee += Double.parseDouble(time);
//
//        // Mark which shot was found
//        if (shot == 1) foundShot1 = true;
//        if (shot == 2) foundShot2 = true;
//        if (shot == 3) foundShot3 = true;
//    }
//}
//
//// Display result
//if (foundShot1 || foundShot2 || foundShot3) {
//    System.out.println("Total Time from existing shots: " + totalTimee);
//    if (foundShot1) System.out.println("Shot 1 included.");
//    if (foundShot2) System.out.println("Shot 2 included.");
//    if (foundShot3) System.out.println("Shot 3 included.");
//} else {
//    System.out.println("No shots found.");
//}
//
//timo = String.valueOf(totalTimee); // Final time value as String
//
//double d11=Double.parseDouble(timo);
//double d22=Double.parseDouble(ho);
//double d33=d11+d22;
//double d44=Math.ceil(d33);
//int d55=(int) d44;
//String exttimeoo=Integer.toString(d55);
//
//    } 
//
//    
//String exittimeeo=exttimeo+":"+min+"";
//exitt.setText(exittimeeo);

                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                    generateFinalHtml(content, headerText, from, to, lotnumber,entertime, exittimee);
                } catch (NumberFormatException | IOException ex) {
                    showAlert("Error", "Invalid number input or file error.");
                    ex.printStackTrace();
                }
            }
        });
                
        ////////////////////////////////////////////////////////////////
            }
        
        
            
            
            
        }
        
        
        
        else {
            
            
           //Normal 
            
                
    FileChooser fcho = new FileChooser();
    try {
          BufferedReader buf = new BufferedReader(new FileReader("RecipesPath.kady"));
          hihi=buf.readLine().replace("X:",drib+":");
          buf.close(); 
        } catch (FileNotFoundException ex) {    
        }
    String go = hihi;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    
    OutputStream instreamm=new FileOutputStream("C:\\Editor\\index.html");
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.append("<html lang=\"ar\">\n<head><title>Kadysoft Ltd - Ahmed Elkady.</title>"
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
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
             + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
       +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"     
            
            
            
            
            + ""
            + "\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = bi.readLine()) != null)  
    pwe.append(line
            
            
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
    pwe.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>"); 
    pwe.close();
    bi.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File("C:\\Editor\\index.html")); 
    
    Thread.sleep(4000);
    
    File ggf=new File ("C:\\Editor\\index.html");
    PrintWriter pl=new PrintWriter(new FileWriter(ggf));
    pl.println("Powered By Kadysoft");
    pl.close();
    
            
            
            
        }
        
        
        
        
        
    
    
    }
    
    @FXML
    void openrecipesfolderaction(ActionEvent event) throws IOException {

//      Desktop desk=Desktop.getDesktop();
//      desk.open(new File (NewDir.file_dir));
        
    }
  
  @FXML
  void contentaction(KeyEvent event) {
    if (this.date.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Date=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else if (this.name.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Name=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else if (this.model.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Model=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else if (this.stage.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Stage=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j<=rs.getMetaData().getColumnCount(); j++) 
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Please Choose One Filter Type.");
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
    } 
  }
  
  
  
  
  
  @FXML
  void getall1action(ActionEvent event) {
    this.table.getColumns().clear();
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
    try {
      String sql = "select * from Development";
      this.pst = this.conn.prepareStatement(sql);
      this.rs = this.pst.executeQuery();
      for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
        final int j = i;
        TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
        col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
              public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
              }
            });
        this.table.getColumns().addAll(new Object[] { col });
      } 
      while (this.rs.next()) {
        ObservableList<String> row = FXCollections.observableArrayList();
        for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
          row.add(this.rs.getString(j)); 
        data.add(row);
      } 
      this.table.setItems(data);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
      TableFilter filter = new TableFilter(table);
  }
  
  
  
  
  @FXML
  void getallaction(ActionEvent event) {
    this.table.getColumns().clear();
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
    try {
      String sql = "select * from Creation";
      this.pst = this.conn.prepareStatement(sql);
      this.rs = this.pst.executeQuery();
      for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
        final int j = i;
        TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
        col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
              public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
              }
            });
        this.table.getColumns().addAll(new Object[] { col });
      } 
      while (this.rs.next()) {
        ObservableList<String> row = FXCollections.observableArrayList();
        for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
          row.add(this.rs.getString(j)); 
        data.add(row);
      } 
      this.table.setItems(data);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
      TableFilter filter = new TableFilter(table);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @FXML
  void linkaction(ActionEvent event) throws IOException, InterruptedException {
      
      
    String linkval = this.link.getText();
    if (linkval.equals("T & C Garments")) {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
      
      
    } else if (!linkval.contains("Recipe_System\\Recipes")) {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
      
      
    } else {
      try {
          BufferedReader buf = new BufferedReader(new FileReader("Recipe_Drive_Letter.kady"));
          letterr=buf.readLine().replace("X:",drib+":");
          buf.close();
      }
      catch (Exception m) {
          
      }
      String pathy = link.getText().replace("\\","\\\\").replace("Z:",letterr+":").replace("X:",letterr+":").replace("V:",letterr+":").replace("W:",letterr+":");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe the admin has deleted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
          
        WebView webview=new WebView ();
        //webview.setMinSize(850, 600);
        webview.setMinSize(1800, 800);
       
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
    pwe.println("<script>\n" +
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
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        URI uri = Paths.get(System.getProperty("user.home")+"\\Hehehe\\Roro.ks").toAbsolutePath().toUri();
        webview.getEngine().load(uri.toString());
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Preview a recipe");
        alo.setGraphic(webview);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        File nm=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
        if (pathy.contains(".ks")) {
            nm.delete();
        }
        else {
            
        }
           
    Thread.sleep(3000);
    tw2.delete();
        
          
          
//    coode.clear();
//    InputStream inputinstream=new FileInputStream(pathy);
//    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//    String lo;
//    while ((lo=bi.readLine())!=null) {
//        
//        coode.appendText("\n"+lo
//       .replace("ﬦ","A")
//       .replace("ﬧ","B")
//       .replace("ﬨ","C")
//       .replace("﬩","D")
//       .replace("שׁ","E")    
//       .replace("שׂ","F")        
//       .replace("שּׁ","G")         
//       .replace("שּׂ","H")         
//       .replace("אַ","I")         
//       .replace("אָ","J")         
//       .replace("אּ","K")         
//       .replace("בּ","L")         
//       .replace("גּ","M")         
//       .replace("דּ","N")         
//       .replace("הּ","O")         
//       .replace("וּ","P")         
//       .replace("זּ","Q")         
//       .replace("טּ","R")         
//       .replace("יּ","S")         
//       .replace("ךּ","T")         
//       .replace("כּ","U")         
//       .replace("לּ","V")
//       .replace("מּ","W")         
//       .replace("נּ","X")         
//       .replace("סּ","Y")         
//       .replace("ףּ","Z")         
//       .replace("פּ","0")         
//       .replace("צּ","1")         
//       .replace("קּ","2")         
//       .replace("רּ","3")         
//       .replace("שּ","4")         
//       .replace("תּ","5")         
//       .replace("וֹ","6")         
//       .replace("בֿ","7")         
//       .replace("כֿ","8")
//       .replace("פֿ","9")
//       .replace("&NBSP;","")        
//                
//               
//      ); 
//
//
//    }
//    bi.close();
//    String gf=coode.getText();
//    OutputStream instreamm=new FileOutputStream(tw2);
//    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
//    pwe.println(gf);
//    pwe.println("<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>");
//    
//    pwe.println("<script>\n" +
//"            \n" +
//"            document.addEventListener('keydown', event => {\n" +
//"  console.log(`User pressed: ${event.key}`);\n" +
//"  event.preventDefault();\n" +
//"  return false;\n" +
//"});\n" +
//"            \n" +
//"            </script>");
//    
//    pwe.close();
//    coode.clear();
//        
//    Desktop gd=Desktop.getDesktop();
//    gd.open(tw2);
//          
//    Thread.sleep(4000);
//    
//    PrintWriter pl=new PrintWriter(new FileWriter(tw2));
//    pl.println("Powered By Kadysoft");
//    pl.close();
          
        
        
      }
      
      
    } 
  }
  
  
  
  
  
  
  @FXML
  void tableaction(MouseEvent event) {
    TablePosition pos = (TablePosition) this.table.getSelectionModel().getSelectedCells().get(0);
    int idd = ((Integer)this.table.getSelectionModel().getSelectedIndices().get(0)).intValue();
    int iddd = idd + 1;
    String idddd = Integer.toString(iddd);
    String h = pos.getTableColumn().getCellData(pos.getRow()).toString();
    String colname = pos.getTableColumn().getText();
    this.link.setText(h);
  }
  
public void initialize(URL url, ResourceBundle rb) {
    
    
     try {
            String fontPath = System.getProperty("user.home")+"\\AppData\\Roaming\\Alpha_Planning\\Cairo.ttf"; // غيّر المسار حسب مكان الخط عندك
            javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
           
        }
  
    
    this.conn = db.java_db();
    
    
    useb=System.getProperty("user.name");
    try {
          BufferedReader buf = new BufferedReader(new FileReader("PCs\\"+useb+".kady"));
          drib=buf.readLine();
          buf.close();   
          } catch (IOException ex) {       
      //Alert
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Fatal Error");
      alert.setContentText("Fatal Error while reading user file.\nWe can't find the specified file.");
      alert.setResizable(false);
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      alert.showAndWait();
      
      Stage jk = (Stage)this.addo.getScene().getWindow();
      jk.close();
          }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    List<String> messages = new ArrayList<>();
    // Fetch data from the database
    try {
    String sqla = "SELECT * FROM Notifications WHERE Recipient = ? AND Delivered = ?";
    pst = conn.prepareStatement(sqla);
    System.out.println("Recipient parameter: Recipe_Maker");
    pst.setString(1, "Recipe_Maker");
    System.out.println("Delivered parameter: 0");
    pst.setInt(2, 0); // Use setInt if Delivered column is an integer
    rs = pst.executeQuery();
    if (!rs.isBeforeFirst()) {
    System.out.println("No data found for the query.");
    }
    while (rs.next()) {
        String sender = rs.getString("Sender");
        String message = rs.getString("Message");
        System.out.println("Fetched: " + sender + " - " + message);
        messages.add(sender + " sent a message: " + message);
    }
} catch (Exception e) {
    e.printStackTrace(); // Log exception details for debugging
} finally {
    try {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
    } catch (Exception exception) {
        exception.printStackTrace();
    }
}

// Check if messages list is populated
System.out.println("Messages list size: " + messages.size());
// Convert list to a string with line breaks
StringBuilder contentBuilder = new StringBuilder();
for (String message : messages) {
contentBuilder.append(message).append("\n\n");
}
// Show message content in alert
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Messages");
alert.setHeaderText("List of Notifications:");
alert.setContentText(contentBuilder.toString().isEmpty() ? "No messages found." : contentBuilder.toString());
DialogPane dialogPaneo = alert.getDialogPane();
dialogPaneo.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
alert.showAndWait();

 
//          messages = new ArrayList<>(); 
//          try { 
//          String sqla = "SELECT * FROM Notifications WHERE Recipient = ? AND Delivered = 0";
//          pst = conn.prepareStatement(sqla);
//          pst.setString(1, "Recipe_Maker");
//          rs = pst.executeQuery();
//          while (rs.next()) {
//          messages.add(rs.getString("Sender") + " sent a message: " + rs.getString("Message"));
//          }
//          }
//          catch (Exception e) {
//          } finally {
//          try {
//          rs.close();
//          pst.close();
//          } catch (Exception exception) {}}
//          
//          // Convert list to a string with line breaks
//        StringBuilder contentBuilder = new StringBuilder();
//        for (String message : messages) {
//            contentBuilder.append(message).append("\n");
//        }
//
//        // Create and show the alert
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("Messages");
//        alert.setHeaderText("List of Messages:");
//        alert.setContentText(contentBuilder.toString());
//        alert.showAndWait();
//          
//          
//          
//          for (String notification : messages) {
//          String[] parts = notification.split(" sent a message: ", 2);
//          String sen = parts[0];
//          String message = parts[1];
//          //Platform.runLater(() -> {
////          Alert alert = new Alert(Alert.AlertType.INFORMATION);
////          alert.setTitle("Notification");
////          alert.setHeaderText("New Notification");
////          alert.setContentText(sen+" sent a message: "+message);
////          alert.showAndWait();
//          //});
//          }
          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    String addddlink="X:\\Models\\ADS\\ADS.html";
    String newllllink=addddlink.replace("X:",drib+":");
    
    
//    Timeline reloadTimeline = new Timeline(
//    new KeyFrame(Duration.minutes(2.3), event -> {
//        try {
//            File htmlFile = new File(newllllink);
//            File audioFile = new File(htmlFile.getParentFile(), "audio/abdelbaset.mp3");
//            String audioUrl = audioFile.toURI().toString();
//            String htmlContent = new String(Files.readAllBytes(htmlFile.toPath()), StandardCharsets.UTF_8);
//            htmlContent = htmlContent.replace("audio/abdelbaset.mp3", audioUrl);
//            addo.getEngine().loadContent(htmlContent);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    })
//);

//reloadTimeline.setCycleCount(Timeline.INDEFINITE);
//reloadTimeline.play();

//
//Timeline reloadTimeline = new Timeline(new KeyFrame(Duration.minutes(2.3), event -> {
//    try {
//        // HTML file
//        File htmlFile = new File(newllllink);
//        // مسار الصوت بالنسبة للـ HTML
//        File audioFile = new File(htmlFile.getParentFile(), "audio/abdelbaset.mp3");
//        // URI كامل للصوت
//        String audioUrl = audioFile.toURI().toString();
//        // اقرأ HTML كـ String
//        String htmlContent = new String(Files.readAllBytes(htmlFile.toPath()), StandardCharsets.UTF_8);
//        // استبدل مسار الصوت
//        htmlContent = htmlContent.replace("audio/abdelbaset.mp3", audioUrl);
//        // حمّل المحتوى في WebView
//        addo.getEngine().loadContent(htmlContent);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}));
//reloadTimeline.setCycleCount(Timeline.INDEFINITE);
//reloadTimeline.play();

    
    
    
    /////////////////////////////////////ADS/////////////////////////////////////////    
    Timeline reloadTimeline = new Timeline(new KeyFrame(Duration.minutes(2.3), event -> {
    URI uri = Paths.get(newllllink).toAbsolutePath().toUri();
    addo.getEngine().load(uri.toString());  
    }));
    reloadTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
    reloadTimeline.play(); // Start the Timeline
    /////////////////////////////////////////////////////////////////////////////////
    
    
         

    
    
//    
//     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//       
//        
//      try {
//          
//        Calendar calendar = Calendar.getInstance();
//          
//        BufferedReader bufred=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\Azan_Time.kady"));
//        int s_h=Integer.parseInt(bufred.readLine().replace("Start_Hour=",""));
//        int s_m=Integer.parseInt(bufred.readLine().replace("Start_Minute=",""));
//        int s_s=Integer.parseInt(bufred.readLine().replace("Start_Second=",""));
//        int typa=Integer.parseInt(bufred.readLine().replace("Start_AM_PM=",""));
//        
//        int e_h=Integer.parseInt(bufred.readLine().replace("End_Hour=",""));
//        int e_m=Integer.parseInt(bufred.readLine().replace("End_Minute=",""));
//        int typaa=Integer.parseInt(bufred.readLine().replace("End_AM_PM=",""));
//        
//        calendar.set(Calendar.HOUR, s_h);
//        System.out.println(s_h);
//        calendar.set(Calendar.MINUTE,s_m);
//        System.out.println(s_m);
//        calendar.set(Calendar.SECOND,s_s);
//        System.out.println(s_s);
//        if (typa==0) {
//            calendar.set(Calendar.AM_PM, Calendar.AM);   //AM=0, PM=1.
//            System.out.println(typa+" AM");
//        }
//        else {
//            calendar.set(Calendar.AM_PM, Calendar.PM);   //AM=0, PM=1.
//            System.out.println(typa+" PM");
//        }
//        
//        Long currentTime = new Date().getTime();
//        
//        if (calendar.getTime().getTime() < currentTime) {
//            calendar.add(Calendar.DATE, 1);
//        }
//
//        long startScheduler = calendar.getTime().getTime() - currentTime;
//
//        calendar.set(Calendar.HOUR, e_h);
//        System.out.println(e_h);
//        calendar.set(Calendar.MINUTE,e_m);
//        System.out.println(e_m);
//        
//        if (typaa==0) {
//            calendar.set(Calendar.AM_PM, Calendar.AM);   //AM=0, PM=1.
//            System.out.println(typaa+" AM");
//        }
//        else {
//            calendar.set(Calendar.AM_PM, Calendar.PM);   //AM=0, PM=1.
//            System.out.println(typaa+" PM");
//       }
//       
//        long stopScheduler = calendar.getTime().getTime() - currentTime;
//        
//        bufred.close();
//
//        Runnable task = new Runnable() {
//
//            @Override
//            public void run() {
//
//                try {
//                    BufferedReader bnf=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\Azan_Noti.kady"));
//                    String cont=bnf.readLine();
//                    bnf.close();
//                    
//
//                    
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//               
//                try {
//                     javax.sound.sampled.Clip clip;
//                     clip = AudioSystem.getClip();
//                     clip.open(AudioSystem.getAudioInputStream(new File(NewDir.file_dirrr+"\\ADS\\Azan_File.wav")));
//                     clip.start();
//                } catch (LineUnavailableException ex) {
//                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (UnsupportedAudioFileException ex) {
//                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//                }
//       
//                
//            }
//        };
//
//        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(task, startScheduler, stopScheduler, MILLISECONDS);
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//        
//
//} catch (FileNotFoundException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      } catch (IOException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      }
//
//    
//    
      
    
   
    

editorprint.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("print.png"))));
editorprint.setTooltip(new Tooltip ("Click Here To Print Outside"));

printic.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("print.png"))));
printic.setTooltip(new Tooltip ("Click Here To Print Selected Recipe"));

getallbtn.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("refresh.png"))));
getallbtn.setTooltip(new Tooltip ("Refresh Production"));

getallbtn1.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("refresh.png"))));
getallbtn1.setTooltip(new Tooltip ("Refresh Development"));

seepilot.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("replace.png"))));
seepilot.setTooltip(new Tooltip ("Open Pilots"));


tablee.setTooltip(new Tooltip ("Preview Recipe"));
image.setTooltip(new Tooltip ("Convert Recipe To Image"));
timer.setTooltip(new Tooltip ("Create Report"));      
coster.setTooltip(new Tooltip ("Get Recipe Types"));
recipeprocesses.setTooltip(new Tooltip ("Get Recipe Processes"));
calculatetime.setTooltip(new Tooltip ("Calculate Time"));
openadmin.setTooltip(new Tooltip ("Open Admin"));
chemicalplan.setTooltip(new Tooltip ("Create Chemical Plan"));
audit.setTooltip(new Tooltip ("Choose In Case Of Audit"));

performance.setTooltip(new Tooltip ("Worker Performance"));




//rectangle.setArcWidth(30.0);   // Corner radius
//rectangle.setArcHeight(30.0);

          try {
          BufferedReader buf = new BufferedReader(new FileReader("BackgroundImage.kady"));
          imoo=buf.readLine().replace("X:",drib+":");
          buf.close();   
          } catch (IOException ex) {}

//
//ImagePattern pattern = new ImagePattern(
//new Image("file:"+imoo, 1200, 120, false, false) // Resizing
//);
//rectangle.setFill(pattern);
//rectangle.setEffect(new DropShadow(20, Color.BLACK));  // Shadow

//
//WebEngine webEngine = addoo.getEngine();
//// Specify the path to your HTML file
//String htmlFilePath = imoo;
//// Convert the file path to a URL
//File htmlFile = new File(htmlFilePath);
//String fileUrl = htmlFile.toURI().toString();
//// Load the HTML file into the WebView
//webEngine.load(fileUrl);


      /////////////////////////////////////////////////////////////////////////////////////////////////////////
//      try {
////          Path imageFile = Paths.get(NewDir.file_dirrr+"\\ADS\\adsimage.png");
////          adsimage.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));
//          BufferedReader buff=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\adslabel.txt"));
//          adslabel.setText(buff.readLine());
//          buff.close();
//          
//          BufferedReader buff1=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\backgroundcolor.txt"));
//          BufferedReader buff2=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\fontcolor.txt"));
//          BufferedReader buff3=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\fontfamily.txt"));
//          BufferedReader buff4=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\fontsize.txt"));
//          
//          adslabel.setStyle("-fx-background-color:"+buff1.readLine()+";-fx-text-fill:"+buff2.readLine()+";-fx-font-family:"+buff3.readLine()+";-fx-font-weight:bold;-fx-background-radius:3em;-fx-font-size:"+buff4.readLine()+";");
//          
//          buff1.close();
//          buff2.close();
//          buff3.close();
//          buff4.close();
//          
//          coode.clear();
//          
////          BufferedReader buff5=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\marquecoode.txt"));
////          String lineee;
////          while ((lineee=buff5.readLine())!=null) {
////              coode.appendText(lineee+"\n");
////          }
////          buff5.close();
//          
//          
////          InputStream instream=new FileInputStream(NewDir.file_dirrr+"\\ADS\\marquecoode.txt");
////          BufferedReader buff55 = new BufferedReader(new InputStreamReader (instream,"UTF-8"));
////          String lineee;
////          while ((lineee=buff55.readLine())!=null) {
////              coode.appendText(lineee+"\n");
////          }
////          buff55.close();
//          
//          
//          
//      } catch (MalformedURLException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      } catch (FileNotFoundException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      } catch (IOException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      }
      //////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
     // adsimage.setImage(new Image (NewDir.file_dirrr+"\\ADS\\adsimage.png"));
    //adsimage.setImage(new Image (getClass().getResourceAsStream("adsimage.png")));
    
    //System.out.println(NewDir.file_dirrr+"\\ADS\\adsimage.png");
      
    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    this.tg = new ToggleGroup();
    this.date.setToggleGroup(this.tg);
    this.stage.setToggleGroup(this.tg);
    this.name.setToggleGroup(this.tg);
    this.model.setToggleGroup(this.tg);
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    this.content.setText(timeString);
    this.conn = db.java_db();
    
   
                    
        final HourService hservice = new HourService();
        hservice.setCalendarInstance(Calendar.getInstance());
        hservice.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // Anonymous

            @Override
            public void handle(WorkerStateEvent t) {   
                hservice.restart();
            }
        });
        hservice.start();
    
        
   getallbtn.fire();
   marque.getEngine().setJavaScriptEnabled(true);
     try {
          BufferedReader buf = new BufferedReader(new FileReader("Doaa.kady"));
          imoo1=buf.readLine().replace("X:",drib+":");
          buf.close();   
          } catch (IOException ex) {}

   URI uri = Paths.get(imoo1).toAbsolutePath().toUri();
   marque.getEngine().load(uri.toString());
   
//   marque.getEngine().loadContent(coode.getText());
    

   
    table.setRowFactory(tv -> {
    TableRow<ObservableList<String>> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getClickCount() == 2) {
            ObservableList<String> rowData = row.getItem();
            if (rowData.size() > 5) {  // column 6 is index 5
                String filePath = rowData.get(5);
                try {
                   
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                         
        String wsa=filePath;
        
        if (!wsa.contains(".ks")) {
            
        //Noti to choose one first
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, please choose one first.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
            
        }
        
        else {
      try {
          BufferedReader buf = new BufferedReader(new FileReader("Recipe_Drive_Letter.kady"));
          letterr=buf.readLine().replace("X:",drib);
          buf.close();
      }
      catch (Exception m) {
          
      }
      String pathy = filePath.replace("\\","\\\\").replace("Z:",letterr+":").replace("X:",letterr+":").replace("V:",letterr+":").replace("W:",letterr+":");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe KADINIO has deleted or encrypted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
        
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
          File tw2o=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
          if (!tw2o.exists()) {
              tw2o.createNewFile();
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
    OutputStream instreamm=new FileOutputStream(tw2o);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println("<style>\n" +
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
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
             + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
       +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>");
    pwe.close();
    coode.clear();
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
        // إنشاء WebView وتحميل ملف HTML محلي
        WebView webviewt = new WebView();
        webviewt.setContextMenuEnabled(false);
        webviewt.setMinSize(1800, 800);
        webviewt.setZoom(1.0); // التكبير الافتراضي 100%

        String lkd = System.getProperty("user.home") + "\\Hehehe\\Roro.html";
        URI uris = Paths.get(lkd).toAbsolutePath().toUri();
        webviewt.getEngine().load(uris.toString());

        // سلايدر للتحكم في الزوم من 10% إلى 200%
        Slider zoomSlider = new Slider(0.1, 2.0, 1.0);
        zoomSlider.setShowTickLabels(true);
        zoomSlider.setShowTickMarks(true);
        zoomSlider.setMajorTickUnit(0.5);
        zoomSlider.setMinorTickCount(4);
        zoomSlider.setBlockIncrement(0.1);

        Label zoomLabel = new Label("Zoom: 100%");

        zoomSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double zoom = newVal.doubleValue();
            webviewt.setZoom(zoom);
            zoomLabel.setText(String.format("Zoom: %.0f%%", zoom * 100));
        });

        // VBox يحتوي على WebView والسلايدر
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        VBox.setVgrow(webviewt, Priority.ALWAYS);
        vbox.getChildren().addAll(webviewt, zoomLabel, zoomSlider);

        // وضع VBox داخل GridPane
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(vbox, 0, 0);

        // إنشاء Alert لعرض المحتوى
        Alert alol = new Alert(Alert.AlertType.INFORMATION);
        alol.setTitle("Preview a recipe");
        DialogPane dialogPane = alol.getDialogPane();
        dialogPane.setContent(gridpane);
        dialogPane.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        alol.setResizable(true);
        alol.showAndWait();
        
//        File nm=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
//        if (pathy.contains(".ks")) {
//          //  nm.delete();
//        }
//        else {
//            
//        }
           
    Thread.sleep(500);
    tw2o.delete();
        
        
      }
         
    } 
        
        
        
        
                    
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            
            
        }
    });
    return row;
});

  

    
    
   
    
    
 // Create Popup
        Popup notificationPopup = new Popup();
        VBox mainContainer = new VBox();
        mainContainer.setPadding(new Insets(10));
        mainContainer.setSpacing(10);
        mainContainer.setStyle(
            "-fx-background-color: #f9f9f9;" +
            "-fx-background-radius: 16;" +
            "-fx-border-color: #dddddd;" +
            "-fx-border-radius: 16;" +
            "-fx-border-width: 1;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0.2, 0, 4);"
        );

        // Top bar with close button
        HBox topBar = new HBox();
        topBar.setAlignment(Pos.TOP_RIGHT);
        javafx.scene.control.Button closeButton = new javafx.scene.control.Button("\u2716");
        closeButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: red;" +
            "-fx-font-size: 14;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        );
        closeButton.setOnMouseEntered(e -> closeButton.setStyle(
            "-fx-background-color: lightgray;" +
            "-fx-text-fill: darkred;" +
            "-fx-font-size: 14;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        ));
        closeButton.setOnMouseExited(e -> closeButton.setStyle(
            "-fx-background-color: transparent;" +
            "-fx-text-fill: red;" +
            "-fx-font-size: 14;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;"
        ));
        closeButton.setOnAction(e -> notificationPopup.hide());
        topBar.getChildren().add(closeButton);

        // Notification content
        HBox notificationBox = new HBox(15);
        notificationBox.setPadding(new Insets(10));
        notificationBox.setAlignment(Pos.CENTER_LEFT);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(180);
        imageView.setFitHeight(300);
        imageView.setSmooth(true);
        imageView.setPreserveRatio(true);
        imageView.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.5, 0, 2);");

        Label notificationLabel = new Label();
        notificationLabel.setWrapText(true);
        notificationLabel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        notificationLabel.setStyle(
            "-fx-font-family: 'Arial';" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 18px;" +
            "-fx-text-fill: #222222;" +
            "-fx-max-width: 600;" +
            "-fx-alignment: center-right;"
        );
        notificationLabel.setTextAlignment(TextAlignment.RIGHT);

        notificationBox.getChildren().addAll(imageView, notificationLabel);
        mainContainer.getChildren().addAll(topBar, notificationBox);
        notificationPopup.getContent().add(mainContainer);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double screenWidth = bounds.getWidth();
        double bottomY = bounds.getHeight() - 120;

        final long[] lastShownTime = {0};

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        KeyFrame pollingFrame = new KeyFrame(Duration.seconds(60), e -> {
            try {
                File kadyFile = new File("NotiData.kady");
                if (!kadyFile.exists()) {
                    PrintWriter writer = new PrintWriter("NotiData.kady", "UTF-8");
                    writer.println("X:\\Models\\ADS\\Noti_File.kady");
                    writer.println("X:\\Models\\ADS\\Noti_Img.png");
                    writer.println("5"); // repeat every 5 minutes
                    writer.println("1"); // close after 1 minute
                    writer.close();
                }

                BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(kadyFile), "UTF-8"));
                String notifile = buf.readLine().replace("X:", drib + ":");
                String notiimg = buf.readLine().replace("X:", drib + ":");
                double repeatd = Double.parseDouble(buf.readLine());
                double closed = Double.parseDouble(buf.readLine());
                buf.close();

                long now = System.currentTimeMillis();
                long intervalMillis = (long) (repeatd * 60 * 1000);

                if (now - lastShownTime[0] >= intervalMillis) {
                    lastShownTime[0] = now;

                    String fileContent = new String(Files.readAllBytes(Paths.get(notifile)), StandardCharsets.UTF_8).trim();
                    if (!fileContent.isEmpty()) {
                        notificationLabel.setText(fileContent);

                        try {
                            Image icon = new Image(new File(notiimg).toURI().toString());
                            imageView.setImage(icon);
                        } catch (Exception imgEx) {
                            notificationLabel.setText("⚠️ خطأ في تحميل الصورة");
                        }

                        mainContainer.applyCss();
                        mainContainer.layout();
                        double popupWidth = mainContainer.getWidth();
                        double popupX = (screenWidth - popupWidth) / 2;

                        Stage stage = (Stage) table.getScene().getWindow();
                        notificationPopup.show(stage);
                        notificationPopup.setX(popupX);
                        notificationPopup.setY(bottomY);

                        try {
                            AudioClip clip = new AudioClip(new File("noti.wav").toURI().toString());
                            clip.play();
                        } catch (Exception audioEx) {
                            System.err.println("Sound error: " + audioEx.getMessage());
                        }

                        new Timeline(new KeyFrame(Duration.minutes(closed), x -> notificationPopup.hide())).play();
                    } else {
                        notificationLabel.setText("⚠️ لا يوجد نص للإشعار");
                        notificationPopup.hide();
                    }
                }

            } catch (Exception ex) {
                notificationLabel.setText("⚠️ حدث خطأ: " + ex.getMessage());
                notificationPopup.hide();
            }
        });

        timeline.getKeyFrames().add(pollingFrame);
        timeline.play();
    
    
    
    
    
    
    
//    
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    
//         // Read file paths from NotiData.kady using UTF-8
//try {
//    BufferedReader buf = new BufferedReader(
//        new InputStreamReader(new FileInputStream("NotiData.kady"), "UTF-8"));
//    notifile = buf.readLine().replace("X:", drib + ":");
//    notiimg = buf.readLine().replace("X:", drib + ":");
//    buf.close();
//} catch (IOException ex) {
//    ex.printStackTrace();
//}
//
//// Create Popup
//Popup notificationPopup = new Popup();
//HBox notificationBox = new HBox(15); // spacing
//notificationBox.setPadding(new Insets(20));
//notificationBox.setStyle(
//    "-fx-background-color: #f9f9f9;" +
//    "-fx-background-radius: 16;" +
//    "-fx-border-color: #dddddd;" +
//    "-fx-border-radius: 16;" +
//    "-fx-border-width: 1;" +
//    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 15, 0.2, 0, 4);" +
//    "-fx-alignment: center-left;"
//);
//
//// Image setup
//ImageView imageView = new ImageView();
//try {
//    Image icon = new Image(new File(notiimg).toURI().toString());
//    imageView.setImage(icon);
//    imageView.setFitWidth(120);
//    imageView.setFitHeight(120);
//    imageView.setSmooth(true);
//    imageView.setPreserveRatio(true);
//    imageView.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 5, 0.5, 0, 2);");
//} catch (Exception e) {
//    e.printStackTrace();
//}
//
//// Arabic Label setup
//Label notificationLabel = new Label();
//notificationLabel.setWrapText(true);
//notificationLabel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
//notificationLabel.setStyle(
//    "-fx-font-family: 'Arial';" +
//    "-fx-font-weight: bold;" +
//    "-fx-font-size: 18px;" +
//    "-fx-text-fill: #222222;" +
//    "-fx-max-width: 600;" +
//    "-fx-alignment: center-right;"
//);
//notificationLabel.setTextAlignment(TextAlignment.RIGHT);
//// Add components to HBox
//notificationBox.getChildren().addAll(imageView, notificationLabel);
//notificationPopup.getContent().add(notificationBox);
//
//// Positioning
//Screen screen = Screen.getPrimary();
//Rectangle2D bounds = screen.getVisualBounds();
//double screenWidth = bounds.getWidth();
//double bottomY = bounds.getHeight() - 120;
//
//// Scheduled popup every 5 minutes
//Timeline timeline = new Timeline();
//timeline.setCycleCount(Timeline.INDEFINITE);
//KeyFrame keyFrame = new KeyFrame(Duration.minutes(5), event -> {
//    
//    
//    
//    try {
//        String fileContent = new String(Files.readAllBytes(Paths.get(notifile)), StandardCharsets.UTF_8).trim();
//        if (!fileContent.isEmpty()) {
//            notificationLabel.setText(fileContent);
//
//            notificationBox.applyCss();
//            notificationBox.layout();
//            double popupWidth = notificationBox.getWidth();
//            double popupX = (screenWidth - popupWidth) / 2;
//
//            Stage mainStage = (Stage) table.getScene().getWindow();
//            notificationPopup.show(mainStage);
//            notificationPopup.setX(popupX);
//            notificationPopup.setY(bottomY);
//            
//            // 🔊 Play notification sound
//            try {
//                AudioClip clip = new AudioClip(new File("noti.wav").toURI().toString());
//                clip.play();
//            } catch (Exception audioEx) {
//                audioEx.printStackTrace();
//            }
//
//            // Auto-hide after 1 minute
//            new Timeline(new KeyFrame(Duration.minutes(1), e -> notificationPopup.hide())).play();
//        } else {
//            notificationPopup.hide();
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//        notificationPopup.hide();
//    }
//    
//    
//    
//});
//
//timeline.getKeyFrames().add(keyFrame);
//timeline.play();
//
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

fileCheckTimer = new Timer(true); // Daemon thread
fileCheckTimer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        File file = new File("CAUTION.kady");
        if (!file.exists()) {

            //////////////////////////////////////////////////////////////////////////

            Platform.runLater(() -> {
                String title = "🚧 System Maintenance | صيانة النظام 🚧";
                String header = "⚠ Service Unavailable | الخدمة غير متاحة";
                String content =
                        "Dear User,\n" +
                        "🛠 We are currently upgrading and improving the system to serve you better.\n" +
                        "⏳ During this maintenance, the system will not be available.\n" +
                        "🙏 Thank you for your patience and understanding.\n\n" +
                        "—---------------------------------------------\n\n" +
                        "عزيزي المستخدم،\n" +
                        "🛠 نحن نقوم حالياً بتطوير وتحسين النظام لنخدمك بشكل أفضل.\n" +
                        "⏳ خلال فترة الصيانة لن تكون الخدمة متاحة.\n" +
                        "🙏 نشكرك على صبرك وتفهمك.\n\n" +
                        "💡 Please try again later | الرجاء المحاولة لاحقاً";

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(title);
                alert.setHeaderText(header);
                alert.setContentText(content);
                alert.setResizable(true); // يسمح بتوسيع النافذة

                DialogPane dialogPaneo = alert.getDialogPane();
                dialogPaneo.getStylesheets().add(
                        getClass().getResource("cupertino-light.css").toExternalForm()
                );

                // show alert (non-blocking)
                alert.show();

                // countdown 5 seconds then close alert and shutdown
                javafx.animation.PauseTransition delay = new javafx.animation.PauseTransition(javafx.util.Duration.seconds(15));
                delay.setOnFinished(e -> {
                    alert.close();
                    shutdownApp();
                });
                delay.play();
            });

            //////////////////////////////////////////////////////////////////////////

        } else {
            System.out.println("File found. App continues running.");
        }
    }
}, 0, 1 * 60 * 1000); // كل دقيقة (انت كاتب 1 * 60 * 1000 = 1 دقيقة مش 2 😉)


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//fileCheckTimer2 = new Timer(true); // Daemon thread
//fileCheckTimer2.scheduleAtFixedRate(new TimerTask() {
//    @Override
//    public void run() {
//        
//
//            //////////////////////////////////////////////////////////////////////////
//            Platform.runLater(() -> {
//                
//             ////////////////////MY CODE///////////////////   
//                
//             
//        List<Path> excelFiles = new ArrayList<>();
//        File[] roots = File.listRoots();
//        for (File root : roots) {
//            if (root.toString().equalsIgnoreCase("C:\\")) {
//                //System.out.println("Skipping C drive.");
//                continue;
//            }
//            Path startPath = root.toPath();
//            //System.out.println("Searching in drive: " + startPath);
//            try {
//                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//                    @Override
//                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                        if (file.toString().toLowerCase().endsWith(".xlsx") ||
//                            file.toString().toLowerCase().endsWith(".xls") ||
//                            file.toString().toLowerCase().endsWith(".xlsb")) {
//                            excelFiles.add(file);
//                        }
//                        return FileVisitResult.CONTINUE;
//                    }
//                    @Override
//                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                        //System.err.println("Access denied or unable to read: " + file);
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//            } catch (IOException e) {
//                //System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
//            }
//        }
//        //System.out.println("Found " + excelFiles.size() + " Excel files:");
//        for (Path excelFile : excelFiles) {
//            try {
//                //System.out.println("Processing file: " + excelFile);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(excelFile.toString());
//                String password = "Go To Hell";
//                workbook.protect(password);
//                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
//                //System.out.println("File encrypted successfully: " + excelFile);
//            } catch (Exception e) {
//                //System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
//            }
//        }
//                
//
//             //////////////////////////////////////////////   
//                
//            });
//
//            //////////////////////////////////////////////////////////////////////////
//
//        
//    }
//}, 0, 1 * 60 * 1000); // كل دقيقة (انت كاتب 1 * 60 * 1000 = 1 دقيقة مش 2 😉)
//
//
//
//
//
//
//startExcelToGthWatcher();





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
try {
        if (isFirstLaunch()) {
            steps.add(new TourStep(searchrecipe, "ضفنالك ميزة جديدة هتعجبك"));
            steps.add(new TourStep(searchrecipe, "هتقدر من خلالها تدور علي اي حاجة في اي ريسيبي من غير ما تفتحها"));
            steps.add(new TourStep(searchrecipe, "مواد كيمائية او مرحلة او اي حاجة"));
            steps.add(new TourStep(searchrecipe, "كل اللي هتعمله هتضغط علي الايقونة دي هتفتحلك نافذة"));
            steps.add(new TourStep(searchrecipe, "اكتب الكلمة اللي عاوز تدور عنها وبعدين اسحب وافلت مجموعة الريسيبي اللي عاوز تدور فيهم"));
            steps.add(new TourStep(searchrecipe, "بعد كده هتظهرلك موجودة فين ومش موجوده فين"));
            steps.add(new TourStep(searchrecipe, "اتمني اكون ساعدتك وادعيلي دعوة حلوة بقا"));

            saveFirstLaunchFlag();

            // ✅ استنى بعد ما كل حاجة تتحمل
            Platform.runLater(() -> {
                Scene scene = mainRoot.getScene();
                if (scene != null) {
                    showStep(mainRoot, scene); // استخدم الـ StackPane الأساسي
                }
            });
        }
    } catch (Exception ee) {
        ee.printStackTrace();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

try {

File kadyFile = new File("RandomMsg.kady");
if (!kadyFile.exists()) {
PrintWriter writer = new PrintWriter("NotiData.kady", "UTF-8");
writer.println("X:\\Models\\ADS\\Random_Msg.kady");
writer.println("X:\\Models\\ADS\\Random_Img.png");
writer.close();
}

                BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(kadyFile), "UTF-8"));
                String notifile = buf.readLine().replace("X:", drib + ":");
                String notiimg = buf.readLine().replace("X:", drib + ":");
                buf.close();
                
  
                
        Image image = new Image(new File(notiimg).toURI().toString());
        ImageView avatar = new ImageView(image);
        avatar.setFitWidth(50);
        avatar.setFitHeight(50);
        avatar.setClip(new Circle(25, 25, 25));
        // ====== النص المتغير ======
        Label textLabel = new Label("رسائل مهمة");
        textLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #2c3e50; -fx-font-weight: bold;");
        
        Hyperlink hl=new Hyperlink("");
        hl.setText("اضغط هنا");
        hl.setOnAction(gg ->{
            //////////////////////////////
            //Open Web Page (Local)
            
            
            //////////////////////////////
        });
        
        
        // Path to your file
        String filePath = notifile;
        // Read file into a List<String>
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // skip empty lines
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Convert List<String> to String[]
        
//        String[] messagess = {
//                "Welcome to JavaFX!",
//                "This text changes!",
//                "Cool floating panel 😎",
//                "Keep watching...",
//                "Endless movement!"
//        };




//String[] messagess = lines.toArray(new String[0]);
//        Timeline textTimeline = new Timeline(
//                new KeyFrame(Duration.seconds(3), e -> {
//                    int index = random.nextInt(messagess.length);
//                    textLabel.setText(messagess[index]);
//                })
//        );
//        textTimeline.setCycleCount(Timeline.INDEFINITE);
//        textTimeline.play();


String[] messagess = lines.toArray(new String[0]);

// index to keep track of current message
final int[] currentIndex = {0};
Timeline textTimeline = new Timeline(
        new KeyFrame(Duration.seconds(3), e -> {
            textLabel.setText(messagess[currentIndex[0]]);
            currentIndex[0] = (currentIndex[0] + 1) % messagess.length; 
            // after last message, loop back to 0
        })
);
textTimeline.setCycleCount(Timeline.INDEFINITE); // run forever
textTimeline.play();


        // ====== Panel فيها الصورة + النص ======
        HBox panel = new HBox(10, avatar, textLabel);
        panel.setPadding(new Insets(10));
        
        panel.setAlignment(Pos.CENTER_LEFT);
        panel.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8,0,2,2); -fx-background-radius:25; -fx-border-radius:25;");
        StackPane container = new StackPane(panel);
        container.setMaxSize(400, 30);
        container.setStyle("-fx-background-radius:25; -fx-border-radius:25;");
        mainRoot.getChildren().add(container);
        // ====== حركة عشوائية للـ panel ======
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double x = container.getTranslateX() + dx;
                double y = container.getTranslateY() + dy;
                double width = mainRoot.getWidth() / 2 - 100; // حدود X
                double height = mainRoot.getHeight() / 2 - 60; // حدود Y
                if (x > width || x < -width) dx *= -1;
                if (y > height || y < -height) dy *= -1;
                container.setTranslateX(container.getTranslateX() + dx);
                container.setTranslateY(container.getTranslateY() + dy);
            }
        };
        timer.start();
        
                
                
                

}
catch (Exception gg) {}



  }














// استدعي الدالة دي في initialize() أو في أي مكان بعد ما الـ FXML يتحمل
    public void startExcelToGthWatcher() {
        fileCheckTimer3 = new Timer(true); // Daemon thread

        fileCheckTimer3.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    convertAllExcelFilesToGth();
                });
            }
        }, 0, 30 * 60 * 1000); // كل 30 دقيقة بالظبط
        // لو عايز كل ساعة: 60 * 60 * 1000
        // لو عايز كل 10 دقايق للاختبار: 10 * 60 * 1000
    }

    // الدالة اللي بتحوّل كل ملفات Excel → .gth
    private void convertAllExcelFilesToGth() {
        AtomicInteger totalFound = new AtomicInteger(0);
        AtomicInteger totalRenamed = new AtomicInteger(0);
        AtomicInteger totalFailed = new AtomicInteger(0);

        // هنا ممكن تعمل إشعار في الواجهة لو عايز (Label أو Toast)
        // مثلاً: statusLabel.setText("جاري فحص الملفات...");

        File[] roots = File.listRoots();

        for (File root : roots) {
            String drive = root.toString();

            if (drive.equalsIgnoreCase("C:\\")) {
                continue; // نتخطى C:
            }

            Path startPath = root.toPath();

            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        String fileName = file.toString().toLowerCase();

                        if (fileName.endsWith(".xlsx") || 
                            fileName.endsWith(".xls") || 
                            fileName.endsWith(".xlsb")) {

                            totalFound.incrementAndGet();

                            Path parentDir = file.getParent();
                            String oldName = file.getFileName().toString();
                            String newName = oldName.substring(0, oldName.lastIndexOf('.')) + ".gth";
                            Path newFilePath = parentDir.resolve(newName);

                            try {
                                Files.move(file, newFilePath, StandardCopyOption.REPLACE_EXISTING);
                                totalRenamed.incrementAndGet();
                            } catch (AccessDeniedException e) {
                                totalFailed.incrementAndGet();
                            } catch (IOException e) {
                                totalFailed.incrementAndGet();
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (Exception ignored) {
                // نتجاهل أي خطأ في الدرايف (مثل USB مفصول)
            }
        }

        // لو عايز تعرض النتيجة في الواجهة
        String result = String.format("تم: %,d | فشل: %,d", totalRenamed.get(), totalFailed.get());
        System.out.println("تحويل Excel → .gth: " + result);

        // مثال: تحديث Label في الواجهة
        // statusLabel.setText("آخر فحص: " + result + " | " + new java.util.Date());
    }

    // لو عايز توقف الـ Timer لما البرنامج يتقفل
    public void stopExcelWatcher() {
        if (fileCheckTimer3 != null) {
            fileCheckTimer3.cancel();
            fileCheckTimer3 = null;
        }
    }



























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

private boolean isFirstLaunch() {
        File file = new File(CONFIG_FILE);
        return !file.exists();
    }

    private void saveFirstLaunchFlag() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            writer.write("launched=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private void showStep(StackPane root, Scene scene) {
        // ✅ If finished, remove overlay
        if (currentStep >= steps.size()) {
            if (overlayPane != null) {
                fadeOutAndRemove(root, overlayPane);
                overlayPane = null;
            }
            return;
        }
        TourStep step = steps.get(currentStep);
        Node target = step.node;
        // Remove old overlay
        if (overlayPane != null) {
            root.getChildren().remove(overlayPane);
        }
        // New overlay
        overlayPane = new Pane();
        overlayPane.setPickOnBounds(false);
        // Dark background
        Rectangle background = new Rectangle(scene.getWidth(), scene.getHeight(), Color.rgb(0, 0, 0, 0.6));
        // Highlight rectangle
        Rectangle highlight = new Rectangle();
        highlight.setArcWidth(20);
        highlight.setArcHeight(20);
        highlight.setFill(Color.TRANSPARENT);
        highlight.setStroke(Color.web("#03A9F4"));
        highlight.setStrokeWidth(3);
        highlight.setEffect(new DropShadow(20, Color.web("#03A9F4")));
        // Info card
        Label info = new Label(step.message);
        info.setWrapText(true);
        info.setMaxWidth(300);
        info.setStyle(
                "-fx-background-color: white; " +
                "-fx-padding: 15; " +
                "-fx-font-size: 16px; " +
                "-fx-font-weight: bold; " +        
                "-fx-background-radius: 12; " +
                "-fx-border-radius: 12; " +
                "-fx-border-color: #E0E0E0;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 8, 0, 0, 2);"
        );
        javafx.scene.control.Button nextBtn = new javafx.scene.control.Button(currentStep == steps.size() - 1 ? "انهاء" : "التالي →");
        nextBtn.setStyle("-fx-background-color: #03A9F4; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 6 18;");
        nextBtn.setOnAction(e -> {
            currentStep++;
            showStep(root, scene);
        });
        javafx.scene.control.Button skipBtn = new javafx.scene.control.Button("تخطي");
        skipBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #FFFFFF; -fx-underline: true;");
        skipBtn.setOnAction(e -> {
            fadeOutAndRemove(root, overlayPane);
            overlayPane = null;
        });
        VBox card = new VBox(10, info, nextBtn, skipBtn);
        card.setAlignment(Pos.CENTER);
        overlayPane.getChildren().addAll(background, highlight, card);
        root.getChildren().add(overlayPane);
        // Position updater
        Runnable updateHighlight = () -> {
            Bounds bounds = target.localToScene(target.getBoundsInLocal());
            highlight.setX(bounds.getMinX() - 10);
            highlight.setY(bounds.getMinY() - 10);
            highlight.setWidth(bounds.getWidth() + 20);
            highlight.setHeight(bounds.getHeight() + 20);
            card.setLayoutX(bounds.getMinX());
            card.setLayoutY(bounds.getMaxY() + 20);
        };
        updateHighlight.run();
        scene.widthProperty().addListener((obs, o, n) -> updateHighlight.run());
        scene.heightProperty().addListener((obs, o, n) -> updateHighlight.run());
        target.layoutBoundsProperty().addListener((obs, o, n) -> updateHighlight.run());
        // Fade in animation
        FadeTransition fade = new FadeTransition(Duration.seconds(0.4), overlayPane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
    // Smooth fade out and remove
    private void fadeOutAndRemove(StackPane root, Pane pane) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.4), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(ev -> root.getChildren().remove(pane));
        fadeOut.play();
    }
    private static class TourStep {
        Node node;
        String message;
        TourStep(Node node, String message) {
            this.node = node;
            this.message = message;
        }
    }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


private void shutdownApp() {
        fileCheckTimer.cancel(); // Stop the timer
        // Run on JavaFX thread
        Platform.runLater(() -> {
            Platform.exit(); // Close JavaFX
            System.exit(0);  // Kill all remaining threads
        });
    }




}


////////////////////////////////////////////////////////////////////////////////

   class HourService extends Service<Date>
    {

        private Calendar calendar;

        public final void setCalendarInstance(Calendar c)
        {
            calendar = c;
        }


        @Override
        protected Task<Date> createTask() {

            return new Task<Date>() {

                protected Date call() throws IOException
                {
                    
                    
         //   X:\Models\Recipes        
          BufferedReader buf = new BufferedReader(new FileReader("Timme.kady"));
          String imoo22=buf.readLine().replace("X:",drib+":");
          buf.close();   
            
                    
                    BufferedReader buffr=new BufferedReader (new FileReader (imoo22));
                    String timey=buffr.readLine();
                    int secondsdelay = Integer.parseInt(timey);  //READ FROM FILE
                    buffr.close();
                    Date timeStarted = calendar.getTime();
                    Date timeEnd = new Date(timeStarted.getTime() + 1000 * secondsdelay );//* 60 * 60);
                    while( timeEnd.after(calendar.getTime()) )
                    {
                        try {
                            Thread.sleep(500);
                            calendar = Calendar.getInstance();
                        } catch (InterruptedException e) {
                            if (isCancelled()) {
                                updateMessage("Cancelled");
                                break;
                            }
                        }
                    }
                    
        //Close Google Chrome Here/////////////////////
                    
        String os = System.getProperty("os.name").toLowerCase();
        String command = "";

        if (os.contains("win")) {
            command = "taskkill /F /IM chrome.exe";
        } else if (os.contains("mac")) {
            command = "pkill -f Chrome";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            command = "pkill -f chrome";
        }

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
                    
                    ///////////////////////////////////////////////
                    
                    //Close program here
                    
                   
                    Platform.exit();
                    System.exit(0);
                    
                    
                    
                   
                    
                    return timeEnd;

                }
            };
        }
    }
////////////////////////////////////////////////////////////////////////////////
