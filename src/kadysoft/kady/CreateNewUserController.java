package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class CreateNewUserController implements Initializable {
  @FXML
  private ResourceBundle resources;
  
  @FXML
  private URL location;
  
  @FXML
  private ComboBox selectposition;
  
  @FXML
  private JFXTextField addname;
  
  @FXML
  private JFXPasswordField addpassword;
  
  @FXML
  private ComboBox selectquestion;
  
  @FXML
  private JFXTextField answer;
  
  @FXML
  private JFXButton signup;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  @FXML
  void selectquestionaction(Event event) {
    String toool = this.selectquestion.getSelectionModel().getSelectedItem().toString();
    this.answer.setDisable(false);
    this.signup.setDisable(false);
  }
  
  @FXML
  void signupaction(ActionEvent event) throws IOException {
    if (this.addname.getText().equals("")) {
      Alert al = new Alert(Alert.AlertType.ERROR);
      al.setTitle("Log In Information");
      al.setHeaderText("LogIn Error");
      al.setContentText("Username Field is empty");
      al.setResizable(false);
      al.showAndWait();
    } else if (this.addpassword.getText().equals("")) {
      Alert al = new Alert(Alert.AlertType.ERROR);
      al.setTitle("Log In Information");
      al.setHeaderText("LogIn Error");
      al.setContentText("Password Field is empty");
      al.setResizable(false);
      al.showAndWait();
    } else {
      String toool1 = this.selectquestion.getSelectionModel().getSelectedItem().toString();
      String toool2 = this.selectposition.getSelectionModel().getSelectedItem().toString();
      String username = this.addname.getText();
      String userpassword = this.addpassword.getText();
      String answerr = this.answer.getText();
    //  int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to sign up a new user?", "Add Record", 0);
   //   if (p == 0)
        try {
          String sql = "insert into Users (Position,Name,Password,Question,Answer) values (?,?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sql);
          this.pst.setString(1, toool2);
          this.pst.setString(2, username);
          this.pst.setString(3, userpassword);
          this.pst.setString(4, toool1);
          this.pst.setString(5, answerr);
          this.pst.execute();
          
        
          
       /*   
          Notifications noti = Notifications.create();
      noti.title("Creatin a new user!");
      noti.text("User Successfully Created");
      noti.position(Pos.CENTER);
      noti.showConfirm();
     */     
         // JOptionPane.showMessageDialog(null, "Data is saved successfully");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }  
      Stage jk = (Stage)this.addname.getScene().getWindow();
      jk.close();
      File fg = new File(System.getProperty("user.home") + "\\tandcrecipe.kady");
      fg.createNewFile();
      
          Alert aop=new Alert(AlertType.INFORMATION);
          aop.setHeaderText("Creatin a new user!");
          aop.setTitle("Creating A New User");
          aop.setResizable(false);
          aop.setContentText("User Successfully Created");
          aop.showAndWait();
      
      
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
          this.pst.setString(2, username);
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Created a new user.");
          
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
  }
  
  public void initialize(URL url, ResourceBundle rb) {
    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    this.selectquestion.getItems().addAll(new Object[] { "What is your mother's name?", "What is your wife's name?", "What is your dear teacher name?", "What is your dear friend name?" });
    this.selectposition.getItems().addAll(new Object[] { "Developer", "Admin","Recipe_Maker", "Viewer" });
    this.conn = db.java_db();
  }
}
