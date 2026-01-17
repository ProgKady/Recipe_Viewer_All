package kadysoft.kady;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;


public class db {
   Connection conn = null;
   
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

   public static String useb;
   public static Connection java_db()  {
        useb=System.getProperty("user.name");
        File fff = new File ("PCs\\"+useb+".kady"); //Alert
        if (fff.exists()) {
            String dbvalue = getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "DataBase");
            try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+dbvalue);
            return conn;
            } catch (Exception gff) {   
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("Database not found, please go to settings to install database.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError(); 
            }
        }
        else {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("Sorry we face a problem : Call Ahmed Elkady To add you.\n\nPowered By Kadysoft Ltd - Ahmed Elkady.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
        }
        return null;
   }
}
