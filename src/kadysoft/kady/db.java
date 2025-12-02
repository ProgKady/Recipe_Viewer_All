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


public class db {
   Connection conn = null;
   
 
   public static String useb,drib;

   public static Connection java_db() {
       
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
      alert.showAndWait();
          }
      
       try {
          BufferedReader buf = new BufferedReader(new FileReader("DataBasesInfo.kady"));
          String db_path=buf.readLine().replace("X:",drib+":");
          buf.close();
          Class.forName("org.sqlite.JDBC");
          Connection conn = DriverManager.getConnection("jdbc:sqlite:"+db_path);
          return conn;
            
        } catch (FileNotFoundException ex) {
            
        Alert al=new Alert (Alert.AlertType.ERROR);
        al.setTitle("Database Error");
        al.setHeaderText("Database Error");
        al.setContentText("Database not found, please go to settings to install database.");
        al.setResizable(false);
        DialogPane dialogPane = al.getDialogPane();
        al.showAndWait();
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
        return null;
   }
}
