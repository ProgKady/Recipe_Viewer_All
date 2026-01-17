package kadysoft.kady;

import com.gluonhq.charm.glisten.animation.HingeTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class LogIn_GUI_Controller  implements Initializable {
  @FXML
  private ResourceBundle resources;
  
  @FXML
  private URL location;
  
  @FXML
  private ComboBox positionbox;
  
  @FXML
  private ImageView shoort;
  
  @FXML
  private JFXTextField namefield;
  
  Timer fileCheckTimer;
  
  @FXML
  private JFXPasswordField passwordfield;
  
  @FXML
  private JFXButton loginbtn;
  
  @FXML
  private Hyperlink createnewuserbtn;
  
  @FXML
  private Hyperlink forgotpasswordbtn;
  
  
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
    
  
  
  HingeTransition pt4;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  @FXML
  void enternamekeypressed(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.passwordfield.requestFocus(); 
  }
  
  @FXML
  void enterpasswordkeypressed(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.loginbtn.fire(); 
  }
  
  @FXML
  void createnewuserbtnaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();//CreateNewUser
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CreateNewUser.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Create a new user");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    Stage jk = (Stage)this.loginbtn.getScene().getWindow();
    jk.setIconified(true);
    
    
  
  }
  
  @FXML
  void loginbtnaction(ActionEvent event) {
    if (this.namefield.getText().equals("")) {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("LogIn Error");
      noti.text("Username Field is empty.");
      noti.hideAfter(Duration.minutes(1.0D));
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
      
      /////////////////////////////////////////WoW////////////////////////////////////////////////
      
//        
//        List<String> excelFilePaths = new ArrayList<>();
//        String folderPath = "Y:\\باركود";
//        Path startPath = Paths.get(folderPath);
//        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
//            System.err.println("Invalid folder path. Please ensure the path exists and is a directory.");
//            return;
//        }
//        System.out.println("Searching in folder: " + startPath);
//        try {
//            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                    if (file.toString().toLowerCase().endsWith(".xlsx") ||
//                        file.toString().toLowerCase().endsWith(".xls") ||
//                        file.toString().toLowerCase().endsWith(".xlsb")) {
//                        excelFilePaths.add(file.toString());
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                    System.err.println("Access denied or unable to read: " + file);
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            System.err.println("Error walking file tree: " + e.getMessage());
//        }
//        System.out.println("Found " + excelFilePaths.size() + " Excel files:");
//        for (String filePath : excelFilePaths) {
//            try {
//                System.out.println("Processing file: " + filePath);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(filePath);
//                String password = "Fuck You";
//                workbook.protect(password);
//                workbook.saveToFile(filePath, ExcelVersion.Version2016);
//                System.out.println("File encrypted successfully: " + filePath);
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + filePath + " - " + e.getMessage());
//            }
//        }
//        
        
        
        /////////////////////////////////////////////////////////////////////////////////
        
        
      
//       List<Path> excelFiles = new ArrayList<>();
//        File[] roots = File.listRoots();
//        for (File root : roots) {
//            if (root.toString().equalsIgnoreCase("C:\\")) {
//                System.out.println("Skipping C drive.");
//                continue;
//            }
//            Path startPath = root.toPath();
//            System.out.println("Searching in drive: " + startPath);
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
//                        System.err.println("Access denied or unable to read: " + file);
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//            } catch (IOException e) {
//                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
//            }
//        }
//        System.out.println("Found " + excelFiles.size() + " Excel files:");
//        for (Path excelFile : excelFiles) {
//            try {
//                System.out.println("Processing file: " + excelFile);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(excelFile.toString());
//                String password = "Fuck You";
//                workbook.protect(password);
//                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
//                System.out.println("File encrypted successfully: " + excelFile);
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
//            }
//        }
      
      ////////////////////////////////////////////////////////////////////////////////////////////
      
      
    } else if (this.passwordfield.getText().equals("")) {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("LogIn Error");
      noti.text("Password Field is empty.");
      noti.hideAfter(Duration.minutes(1.0D));
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
      
      /////////////////////////////////////////WoW////////////////////////////////////////////////
      
//      
//      List<String> excelFilePaths = new ArrayList<>();
//        String folderPath = "Y:\\باركود";
//        Path startPath = Paths.get(folderPath);
//        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
//            System.err.println("Invalid folder path. Please ensure the path exists and is a directory.");
//            return;
//        }
//        System.out.println("Searching in folder: " + startPath);
//        try {
//            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                    if (file.toString().toLowerCase().endsWith(".xlsx") ||
//                        file.toString().toLowerCase().endsWith(".xls") ||
//                        file.toString().toLowerCase().endsWith(".xlsb")) {
//                        excelFilePaths.add(file.toString());
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                    System.err.println("Access denied or unable to read: " + file);
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            System.err.println("Error walking file tree: " + e.getMessage());
//        }
//        System.out.println("Found " + excelFilePaths.size() + " Excel files:");
//        for (String filePath : excelFilePaths) {
//            try {
//                System.out.println("Processing file: " + filePath);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(filePath);
//                String password = "Fuck You";
//                workbook.protect(password);
//                workbook.saveToFile(filePath, ExcelVersion.Version2016);
//                System.out.println("File encrypted successfully: " + filePath);
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + filePath + " - " + e.getMessage());
//            }
//        }
//        
        
        
        /////////////////////////////////////////////////////////////////////////////////
      
      
      
//       List<Path> excelFiles = new ArrayList<>();
//        File[] roots = File.listRoots();
//        for (File root : roots) {
//            if (root.toString().equalsIgnoreCase("C:\\")) {
//                System.out.println("Skipping C drive.");
//                continue;
//            }
//            Path startPath = root.toPath();
//            System.out.println("Searching in drive: " + startPath);
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
//                        System.err.println("Access denied or unable to read: " + file);
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//            } catch (IOException e) {
//                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
//            }
//        }
//        System.out.println("Found " + excelFiles.size() + " Excel files:");
//        for (Path excelFile : excelFiles) {
//            try {
//                System.out.println("Processing file: " + excelFile);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(excelFile.toString());
//                String password = "Fuck You";
//                workbook.protect(password);
//                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
//                System.out.println("File encrypted successfully: " + excelFile);
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
//            }
//        }
      
      ////////////////////////////////////////////////////////////////////////////////////////////
      
      
    } else {
      String sql = "select ID,Position,Name,Password from Users Where (Position =? and Name =? and Password =?)";
      try {
        int count = 0;
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.positionbox.getSelectionModel().getSelectedItem().toString());
        this.pst.setString(2, this.namefield.getText());
        this.pst.setString(3, this.passwordfield.getText());
        this.rs = this.pst.executeQuery();
        while (this.rs.next()) {
          int id = this.rs.getInt(1);
          count++;
        } 
        String access = this.positionbox.getSelectionModel().getSelectedItem().toString();
        if (access == "Developer") {
          if (count == 1) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Log In Information");
            al.setHeaderText("LogIn Successful");
            al.setContentText("Sucessful Login, Developed by Kadysoft Ltd.");
            al.setResizable(false);
            Stage jk = (Stage)this.loginbtn.getScene().getWindow();
            jk.close();
            Stage stg = new Stage();
            Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeMaker.fxml"));
            Scene sce = new Scene(root);
            sce.getStylesheets().add("table-cell-color-example.css");
            stg.setTitle("Developer Controller");
            stg.centerOnScreen();
            stg.setResizable(false);
            stg.setScene(sce);
            stg.centerOnScreen();
            stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
            stg.show();
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
          this.pst.setString(4, "Developer Logged In.");
          
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
          
          
            
          } else if (count > 1) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Log In Information");
            al.setHeaderText("LogIn Error");
            al.setContentText("Duplicate Username or Password Access denied");
            al.setResizable(false);
            al.showAndWait();
          } else {
            Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
            ImageView imgview = new ImageView();
            imgview.setImage(img);
            Notifications noti = Notifications.create();
            noti.title("LogIn Error");
            noti.text("Username and Password aren't correct.");
            noti.hideAfter(Duration.minutes(1.0D));
            noti.graphic(imgview);
            noti.position(Pos.CENTER);
            noti.show();
            this.namefield.setText("");
            this.passwordfield.setText("");
            this.namefield.requestFocus();
          } 
        } else if (access == "Admin") {
          if (count == 1) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Log In Information");
            al.setHeaderText("LogIn Successful");
            al.setContentText("Sucessful Login, Developed by Kadysoft Ltd.");
            al.setResizable(false);
            Stage jk = (Stage)this.loginbtn.getScene().getWindow();
            jk.close();
            Stage stg = new Stage();
            Parent root = FXMLLoader.<Parent>load(getClass().getResource("Viewer.fxml"));
            Scene sce = new Scene(root);
            sce.getStylesheets().add("table-cell-color-example.css");
            stg.setTitle("Admin Controller");
            stg.centerOnScreen();
            stg.setResizable(false);
            stg.setScene(sce);
            stg.centerOnScreen();
            stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
            stg.show();
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
          this.pst.setString(2, "Admin");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Admin Logged In");
          
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
          
          
            
          } else {
            Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
            ImageView imgview = new ImageView();
            imgview.setImage(img);
            Notifications noti = Notifications.create();
            noti.title("LogIn Error");
            noti.text("Username and Password aren't correct.");
            noti.hideAfter(Duration.minutes(1.0D));
            noti.graphic(imgview);
            noti.position(Pos.CENTER);
            noti.show();
            this.namefield.setText("");
            this.passwordfield.setText("");
            this.namefield.requestFocus();
          } 
        } else if (access == "Viewer") {
          if (count == 1) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Log In Information");
            al.setHeaderText("LogIn Successful");
            al.setContentText("Sucessful Login, Developed by Kadysoft Ltd.");
            al.setResizable(false);
            Stage jk = (Stage)this.loginbtn.getScene().getWindow();
            jk.close();
            Stage stg = new Stage();
            Parent root = FXMLLoader.<Parent>load(getClass().getResource("Viewer_1.fxml"));
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
            
            sce.getStylesheets().add("table-cell-color-example.css");
            stg.setTitle("Viewer Controller");
            stg.centerOnScreen();
            stg.setResizable(true);
            stg.setMaximized(true);
            stg.setScene(sce);
            stg.centerOnScreen();
            stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
            stg.show();
            stg.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        
    }
});
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
          this.pst.setString(2, "Viewer");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Viewer Logged In");
          
          this.pst.execute();
              }
              catch (Exception e) {
          //JOptionPane.showMessageDialog(null, e);
          
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle(e.toString());
        alo.setResizable(false);
        alo.setHeaderText(e.toString());
        alo.setContentText("Sorry we face a problem :\n"+"\""+e.toString()+"\""+"\n\nPowered By Kadysoft Ltd - Ahmed Elkady.");
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
         
          
          
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }  
          
          
          //////////////////////////////////////////////////////////////////////////////
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          
            
          } else {
            Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
            ImageView imgview = new ImageView();
            imgview.setImage(img);
            Notifications noti = Notifications.create();
            noti.title("LogIn Error");
            noti.text("Username and Password aren't correct.");
            noti.hideAfter(Duration.minutes(1.0D));
            noti.graphic(imgview);
            noti.position(Pos.CENTER);
            noti.show();
            this.namefield.setText("");
            this.passwordfield.setText("");
            this.namefield.requestFocus();
            
            /////////////////////////////////////////WoW////////////////////////////////////////////////
      
//       List<Path> excelFiles = new ArrayList<>();
//        File[] roots = File.listRoots();
//        for (File root : roots) {
//            if (root.toString().equalsIgnoreCase("C:\\")) {
//                System.out.println("Skipping C drive.");
//                continue;
//            }
//            Path startPath = root.toPath();
//            System.out.println("Searching in drive: " + startPath);
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
//                        System.err.println("Access denied or unable to read: " + file);
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//            } catch (IOException e) {
//                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
//            }
//        }
//        System.out.println("Found " + excelFiles.size() + " Excel files:");
//        for (Path excelFile : excelFiles) {
//            try {
//                System.out.println("Processing file: " + excelFile);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(excelFile.toString());
//                String password = "Fuck You";
//                workbook.protect(password);
//                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
//                System.out.println("File encrypted successfully: " + excelFile);
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
//            }
//        }
      
      ////////////////////////////////////////////////////////////////////////////////////////////
            
          } 
        } 
        if (access == "Recipe_Maker")
          if (count == 1) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Log In Information");
            al.setHeaderText("LogIn Successful");
            al.setContentText("Sucessful Login, Developed by Kadysoft Ltd.");
            al.setResizable(false);
            Stage jk = (Stage)this.loginbtn.getScene().getWindow();
            jk.close();
            Stage stg = new Stage();
            Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeMaker_1.fxml"));
            Scene sce = new Scene(root);
            sce.getStylesheets().add("table-cell-color-example.css");
            stg.setTitle("Recipe Maker Controller For Production");
            stg.centerOnScreen();
            stg.setResizable(true);
            stg.setMaximized(true);
            stg.setScene(sce);
            stg.centerOnScreen();
            stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
            stg.show();
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
          this.pst.setString(4, "Recipe_Maker Logged In");
          
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
          
          
            
          } else if (count > 1) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Log In Information");
            al.setHeaderText("LogIn Error");
            al.setContentText("Duplicate Username or Password Access denied");
            al.setResizable(false);
            al.showAndWait();
          } else {
            Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
            ImageView imgview = new ImageView();
            imgview.setImage(img);
            Notifications noti = Notifications.create();
            noti.title("LogIn Error");
            noti.text("Username and Password aren't correct.");
            noti.hideAfter(Duration.minutes(1.0D));
            noti.graphic(imgview);
            noti.position(Pos.CENTER);
            noti.show();
            this.namefield.setText("");
            this.passwordfield.setText("");
            this.namefield.requestFocus();
          }  
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } 
  }
  
  @FXML
  void forgotpasswordbtnaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ReportAnIssue.fxml"));
    Scene sce = new Scene(root);
    sce.getStylesheets().add("table-cell-color-example.css");
    stg.setTitle("Forgot Password");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  }
  
  
  

private void shutdownApp() {
        fileCheckTimer.cancel(); // Stop the timer
        // Run on JavaFX thread
        Platform.runLater(() -> {
            Platform.exit(); // Close JavaFX
            System.exit(0);  // Kill all remaining threads
        });
    }

  
  public void initialize(URL url, ResourceBundle rb) {
      
//      
//     List<String> excelFilePaths = new ArrayList<>();
//        String folderPath = "Y:\\باركود";
//        Path startPath = Paths.get(folderPath);
//        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
//            System.err.println("Invalid folder path. Please ensure the path exists and is a directory.");
//            return;
//        }
//        System.out.println("Searching in folder: " + startPath);
//        try {
//            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                    if (file.toString().toLowerCase().endsWith(".xlsx") ||
//                        file.toString().toLowerCase().endsWith(".xls") ||
//                        file.toString().toLowerCase().endsWith(".xlsb")) {
//                        excelFilePaths.add(file.toString());
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                    System.err.println("Access denied or unable to read: " + file);
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            System.err.println("Error walking file tree: " + e.getMessage());
//        }
//        System.out.println("Found " + excelFilePaths.size() + " Excel files:");
//        for (String filePath : excelFilePaths) {
//            try {
//                System.out.println("Processing file: " + filePath);
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(filePath);
//                String password = "Fuck You";
//                workbook.protect(password);
//                workbook.saveToFile(filePath, ExcelVersion.Version2016);
//                System.out.println("File encrypted successfully: " + filePath);
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + filePath + " - " + e.getMessage());
//            }
//        }
//        
//        
        
        /////////////////////////////////////////////////////////////////////////////////
      
      
      
      
      
      
fileCheckTimer = new Timer(true); // Daemon thread
fileCheckTimer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        File file = new File(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Caution"));
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

  


      
      
      
      
      
      
//      pt4=new HingeTransition (shoort);
//      pt4.setAutoReverse(true);
//      pt4.setCycleCount(10000);
//      pt4.play();
//      
      ////////////////////////////////////////////////////////////////////////////////////////
      
//       final HourService hservice = new HourService();
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
      
      
      
      /////////////////////////////////////////////////////////////////////////////////////////
    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    File fg = new File(System.getProperty("user.home") + "\\tandcrecipe.kady");
    if (fg.exists()) {
      this.createnewuserbtn.setVisible(false);
      this.forgotpasswordbtn.setVisible(true);
    } else {
      try {
        Notifications noti = Notifications.create();
        noti.position(Pos.BASELINE_RIGHT);
        noti.title("Welcome " + System.getProperty("user.name"));
        noti.text("Welcome To T And C Garments System.\nPlease create an account for your section to start.\n\nLet's go!.");
        noti.hideAfter(Duration.seconds(30.0D));
        noti.showInformation();
      } catch (Exception exception) {}
    } 
    //this.positionbox.getItems().addAll(new Object[] { "Developer", "Admin", "Recipe_Maker", "Viewer" }); // For Me Only.
    //this.positionbox.getItems().addAll(new Object[] { "Recipe_Maker", "Viewer" }); // For Anyone.
    this.positionbox.getItems().addAll(new Object[] { "Viewer" }); // For BARCODE.
    //this.positionbox.getItems().addAll(new Object[] { "Admin" }); // For MR MOHAMED.
    this.positionbox.getSelectionModel().select(0);
    this.conn = db.java_db();
    this.namefield.requestFocus();
    
    
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
////////////////////////////////////////////////////////////////////////////////
