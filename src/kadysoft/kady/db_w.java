package kadysoft.kady;



import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class db_w {
   Connection conn = null;
   
 
   public static String useb,drib;

   public static Connection java_db() {
      
      
       try {
          
          Class.forName("org.sqlite.JDBC");
          Connection conn = DriverManager.getConnection("jdbc:sqlite:"+"Workers.db");
          return conn;
            
        } 
       catch (Exception var1) {
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle(var1.toString());
        alo.setResizable(false);
        alo.setHeaderText(var1.toString());
        alo.setContentText("Sorry we face a problem :\n"+"\""+var1.toString()+"\""+"\n\nPowered By Kadysoft Ltd - Ahmed Elkady.");
        alo.showAndWait();
        
        /////////////////////////////////////////////////////////
        
     
        
        /////////////////////////////////////////////////////////
        
        
          return null;
      }
      
   }
}
