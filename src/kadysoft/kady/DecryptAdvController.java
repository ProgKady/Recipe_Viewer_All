
package kadysoft.kady;
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
import java.security.spec.KeySpec;
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


public class DecryptAdvController implements Initializable {

   
    @FXML
    private JFXButton decrypt;

    @FXML
    private JFXTextField recipe;
    
    @FXML
    private JFXPasswordField filename;

    @FXML
    private TextArea area;

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
        String filoname=filename.getText();
        
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
      
     
      //////////////////////////Decryption Code////////////////////////////////
      
      
      
       try {
    // Salt and nonce have to be extracted
    ByteBuffer byteBuffer = ByteBuffer.wrap(area.getText().getBytes());
    byte[] salt = new byte[PBKDF2_SALT_LENGTH];
    byteBuffer.get(salt);
    byte[] nonce = new byte[GCM_NONCE_LENGTH];
    byteBuffer.get(nonce);
    byte[] cipherBytes = new byte[byteBuffer.remaining()];
    byteBuffer.get(cipherBytes);

    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
    KeySpec keySpec =
        new PBEKeySpec(filoname.toCharArray(), salt, PBKDF2_ITERATION_COUNT, AES_KEY_LENGTH);
    byte[] secret = factory.generateSecret(keySpec).getEncoded();
    SecretKey key = new SecretKeySpec(secret, "AES");

    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    // If encrypted data is altered, during decryption authentication tag verification will fail
    // resulting in AEADBadTagException
    GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, nonce);
    cipher.init(Cipher.DECRYPT_MODE, key, gcmParameterSpec);
    
    
//    File ff1=new File (destinationpath);
//    ff1.createNewFile();
//    
//    File ff2=new File (recipepath);  //Delete
//    
//    
//    PrintWriter pw=new PrintWriter (new FileWriter (ff1));
//    pw.println(encrypted);
//    pw.close();
//    
//    ff2.delete();
    
    
  } catch (Exception e) {
    throw new RuntimeException(e);
  }
      
      
      /////////////////////////////////////////////////////////////////////////
     
            Notifications noti = Notifications.create();
            noti.title("Successful!");
            noti.text("We decrypted it successfully.");
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
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft_Encrypted Files", new String[] { "*.KS_ENC" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    recipe.setText(filePath);
    String filenameeold= dialogResult.getName();  //with des
    String filenameenew= dialogResult.getName().replace(".KS_ENC",""); //without des
    String newdes1=filePath.replace(filenameeold,"");
    String newdes2=newdes1+filenameenew+".ks";
    destination.setText(newdes2);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
        
    }    
    
}
