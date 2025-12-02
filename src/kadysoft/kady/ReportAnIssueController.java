package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

public class ReportAnIssueController implements Initializable {
   @FXML
   private ComboBox selectuser;
   @FXML
   private JFXTextField name;
   @FXML
   private JFXTextArea problem;
   @FXML
   private JFXButton send;
   @FXML
   private JFXTextField code;
   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pst = null;

   @FXML
   void sendaction(ActionEvent event) {
      String toool = this.selectuser.getSelectionModel().getSelectedItem().toString();
      String username = this.name.getText();
      String usercode = this.code.getText();
      String issue = this.problem.getText();
   //   int p = JOptionPane.showConfirmDialog((Component)null, "Are you sure you want to report your issue to the admin?", "Send", 0);
  //    if (p == 0) {
         try {
            String sql = "insert into Issues (Position,Name,Code,Issue) values (?,?,?,?) ";
            this.pst = this.conn.prepareStatement(sql);
            this.pst.setString(1, toool);
            this.pst.setString(2, username);
            this.pst.setString(3, usercode);
            this.pst.setString(4, issue);
            this.pst.execute();
        
            
          Alert aop=new Alert(Alert.AlertType.INFORMATION);
          aop.setHeaderText("Reporting a new issue!");
          aop.setTitle("Reporting a new issue");
          aop.setResizable(false);
          aop.setContentText("Issue sent successfully, go to the developer Ahmed Elkady to update your info.");
          aop.showAndWait();
      
      
          //  JOptionPane.showMessageDialog((Component)null, "Issue sent successfully, go to the developer Ahmed Elkady to update your info.");
            Stage jk = (Stage)this.code.getScene().getWindow();
            jk.close();
         } catch (Exception var17) {
            JOptionPane.showMessageDialog((Component)null, var17);
         } finally {
            try {
               this.rs.close();
               this.pst.close();
            } catch (Exception var16) {
            }

         }
    //  }

   }

   public void initialize(URL url, ResourceBundle rb) {
      Toolkit tool = Toolkit.getDefaultToolkit();
      tool.setLockingKeyState(20, true);
      this.selectuser.getItems().addAll(new Object[]{"Developer", "Admin","Recipe_Maker", "Viewer"});
      this.conn = db.java_db();
   }
}
