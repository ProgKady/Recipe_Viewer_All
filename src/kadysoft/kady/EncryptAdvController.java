
package kadysoft.kady;
import static com.google.common.base.Charsets.UTF_8;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.controlsfx.control.Notifications;



/**
 * FXML Controller class
 *
 * @author KADY
 */


public class EncryptAdvController implements Initializable {

   
    @FXML
    private JFXButton decrypt;

    
    
    @FXML
    private JFXTextField recipe;
    
    
    
    @FXML
    private JFXPasswordField filename;

    
    
    @FXML
    private TextArea area,area1;

    
    
    @FXML
    private JFXTextField destination;

    
private static final int PBKDF2_ITERATION_COUNT = 300_000;
private static final int PBKDF2_SALT_LENGTH = 16; //128 bits
private static final int AES_KEY_LENGTH = 256; //in bits
// An initialization vector size
private static final int GCM_NONCE_LENGTH = 12; //96 bits
// An authentication tag size
private static final int GCM_TAG_LENGTH = 128; //in bits
    
    
    @FXML
    void decryptaction(ActionEvent event) throws IOException {

        
        
        String recipepath=recipe.getText();
        String destinationpath=destination.getText();
        String filopass=filename.getText();
        area.clear();
        area1.clear();
        
        //Reading only
        
      try {
      BufferedReader buf = new BufferedReader(new FileReader(recipepath));
      String line;
      while ((line = buf.readLine()) != null) {
        area.appendText(line);
      } 
      buf.close();
    } 
    catch (FileNotFoundException fileNotFoundException) {
    
    }
      
      //GetText
      //////////////////////////Encryption Code////////////////////////////////
      
      
    try {
    SecureRandom secureRandom = SecureRandom.getInstanceStrong();
    // Derive the key, given password and salt
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
    // A salt is a unique, randomly generated string
    // that is added to each password as part of the hashing process
    byte[] salt = new byte[PBKDF2_SALT_LENGTH];
    secureRandom.nextBytes(salt);
    KeySpec keySpec =
        new PBEKeySpec(filopass.toCharArray(), salt, PBKDF2_ITERATION_COUNT, AES_KEY_LENGTH);
    byte[] secret = factory.generateSecret(keySpec).getEncoded();
    SecretKey key = new SecretKeySpec(secret, "AES");

    // AES-GCM encryption
    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    // A nonce or an initialization vector is a random value chosen at encryption time
    // and meant to be used only once
    byte[] nonce = new byte[GCM_NONCE_LENGTH];
    secureRandom.nextBytes(nonce);
    // An authentication tag
    GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, nonce);
    cipher.init(Cipher.ENCRYPT_MODE, key, gcmParameterSpec);
    byte[] encrypted = cipher.doFinal(area.getText().getBytes());
    // Salt and nonce can be stored together with the encrypted data
    // Both salt and nonce have fixed length, so can be prefixed to the encrypted data
    ByteBuffer byteBuffer = ByteBuffer.allocate(salt.length + nonce.length + encrypted.length);
    byteBuffer.put(salt);
    byteBuffer.put(nonce);
    byteBuffer.put(encrypted);
    area1.appendText(Base64.getEncoder().encodeToString(encrypted));
    
    //System.out.println(Base64.getEncoder().encodeToString(encrypted));
    
    System.out.println(area1.getText());
    
    File ff1=new File (destinationpath);
    ff1.createNewFile();
    
   // File ff2=new File (recipepath);  //Delete
    
    
    //PrintWriter pw=new PrintWriter (new FileWriter (ff1));
    //pw.println(area1.getText());
    //pw.close();
    
    
//            Notifications noti = Notifications.create();
//            noti.title("Successful");
//            noti.text("Successful Encryption.");
//            noti.hideAfter(Duration.seconds(3));
//            noti.position(Pos.CENTER);
//            noti.show();
    
   // ff2.delete();
    
  } catch (Exception e) {
    throw new RuntimeException(e);
  }
      
    //  byte[] encrypted = encryptAES256(area.getText().getBytes(UTF_8), filopass);
  
    
      
      /////////////////////////////////////////////////////////////////////////
     
            Notifications noti = Notifications.create();
            noti.title("Successful!");
            noti.text("We encrypted it successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
        
    }
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void desaction(MouseEvent event) {

        
        
//    destination.clear();
//    DirectoryChooser dialog = new DirectoryChooser();
//    dialog.setInitialDirectory(new File (NewDir.file_dir));
//    dialog.setTitle("Kadysoft Ltd.");
//    File dialogResult = dialog.showDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    destination.setText(filePath);
        


    }
    
    

    @FXML
    void recaction(MouseEvent event) {
    
    recipe.clear();
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File (NewDir.file_dir));
    //dialog.setInitialFileName("Kadysoft Ltd.");
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    //dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", new String[] { "*.*" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    recipe.setText(filePath);
    String filenameeold= dialogResult.getName();  //with des
    String filenameenew= dialogResult.getName().replace(".ks","").replace(".html",""); //without des
    String newdes1=filePath.replace(filenameeold,"");
    String newdes2=newdes1+filenameenew+".KS_ENC";
    destination.setText(newdes2);
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
        
    }    
    
}
