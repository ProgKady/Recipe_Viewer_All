/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kadysoft.kady;

import com.jfoenix.controls.JFXTreeView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TreeItem;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class PilotsController implements Initializable {

    public static String pilotpathh;
    
    public static File directory;
    
    @FXML
    private JFXTreeView<String> a;

     public static TreeItem<String> getNodesForDirectory(File directory) { //Returns a TreeItem representation of the specified directory
        
         directory=directory;
         TreeItem<String> root = new TreeItem<String>(directory.getName());
        for(File f : directory.listFiles()) {
            System.out.println("Loading " + f.getName());
            if(f.isDirectory()) { //Then we call the function recursively
                root.getChildren().add(getNodesForDirectory(f));
            } else {
                root.getChildren().add(new TreeItem<String>(f.getName()));
            }
        }
        return root;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
      
         try {
          BufferedReader buf = new BufferedReader(new FileReader("PilotPath.kady"));
          pilotpathh=buf.readLine();
          System.out.println(pilotpathh);
          buf.close(); 
          File choice=new File (pilotpathh);
          if(choice == null || ! choice.isDirectory()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Could not open directory");
                    alert.setContentText("The file is invalid.");
                    alert.showAndWait();
                } else {
    
                a.setRoot(getNodesForDirectory(choice));
                   
                }
        } catch (FileNotFoundException ex) {    
        } catch (IOException ex) {
        
      }
     
     
        
    }
    
 
    
    
}
