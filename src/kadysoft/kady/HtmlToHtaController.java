
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class HtmlToHtaController implements Initializable {

    
    @FXML
    private JFXTextField input;

    @FXML
    private JFXButton browse1;

    @FXML
    private JFXTextField filename;

    @FXML
    private JFXTextField output;

    @FXML
    private JFXButton browse2;

    @FXML
    private JFXTextField applicationname;

    @FXML
    private JFXTextField caption;

    @FXML
    private JFXTextField icon;

    @FXML
    private JFXTextField maxbutton;

    @FXML
    private JFXTextField showintaskbar;

    @FXML
    private JFXTextField minbutton;

    @FXML
    private JFXTextField innerborder;

    @FXML
    private JFXTextField navigable;

    @FXML
    private JFXTextField scroll;

    @FXML
    private JFXTextField scrollflat;

    @FXML
    private JFXTextField singleinstance;

    @FXML
    private JFXTextField systemmenu;

    @FXML
    private JFXTextField contextmenu;

    @FXML
    private JFXTextField selection;

    @FXML
    private JFXTextField version;

    @FXML
    private ComboBox<String> border;

    @FXML
    private ComboBox<String> borderstyle;

    @FXML
    private ComboBox<String> windowstate;

    @FXML
    private JFXButton convert,read;
    
    @FXML
    private JFXTextArea area;

    @FXML
    void browse1action(ActionEvent event) throws FileNotFoundException, IOException {

    input.clear();
    filename.clear();
    area.clear();
    FileChooser dialog = new FileChooser();
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    input.setText(filePath);
    String filenamee= dialogResult.getName().replace(".ks","").replace(".html", "");
    filename.setText(filenamee);
    
    read.fire();
    
    
        
    }
    
    
    @FXML
    void readaction(ActionEvent event) throws IOException {

        
    BufferedReader buf=new BufferedReader (new FileReader (input.getText()));
    String line;
    while ((line=buf.readLine())!=null) {
    area.appendText(line);
    }
    buf.close();
    
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have read the file successfully.");
      noti.hideAfter(Duration.seconds(2));
      noti.position(Pos.CENTER);
      noti.showInformation();
        
        
    }
    
    

    @FXML
    void browse2action(ActionEvent event) {

        
    output.clear();
    DirectoryChooser dialog = new DirectoryChooser();
    dialog.setTitle("Kadysoft Ltd.");
    File dialogResult = dialog.showDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    output.setText(filePath);
        
        
    }

    @FXML
    void convertaction(ActionEvent event) throws IOException {
        
   

        String code=area.getText();
        String filenamee=filename.getText();
        String outputdir=output.getText();
        
        String appname,captionn,iconn,minibutton,maxibutton,taskbar,innerborderr,navigablee,scrolll,scrollflatt,singleinstancee,sysmenuu,conmenuu,selectionn,versionn,borderr,borderstylee,windowstatee;
        
        appname=applicationname.getText();
        captionn=caption.getText();
        iconn=icon.getText();
        minibutton=minbutton.getText();
        maxibutton=maxbutton.getText();
        taskbar=showintaskbar.getText();
        innerborderr=innerborder.getText();
        navigablee=navigable.getText();
        scrolll=scroll.getText();
        scrollflatt=scrollflat.getText();
        singleinstancee=singleinstance.getText();
        sysmenuu=systemmenu.getText();
        conmenuu=contextmenu.getText();
        selectionn=selection.getText();
        versionn=version.getText();
        
        borderr=border.getSelectionModel().getSelectedItem().toString();
        borderstylee=borderstyle.getSelectionModel().getSelectedItem().toString();
        windowstatee=windowstate.getSelectionModel().getSelectedItem().toString();
        
        
String htatag="<HTA:APPLICATION id=\"Kadinio\"\n" +
"applicationName=\""+appname+"\"\n" +
"border=\""+borderr+"\"\n" +
"borderStyle=\""+borderstylee+"\"\n" +
"caption=\""+captionn+"\"\n" +
"icon=\""+iconn+"\"\n" +
"maximizeButton=\""+maxibutton+"\"\n" +
"minimizeButton=\""+minibutton+"\"\n" +
"showInTaskbar=\""+taskbar+"\"\n" +
"windowState=\""+windowstatee+"\"\n" +
"innerBorder=\""+innerborderr+"\"\n" +
"navigable=\""+navigablee+"\"\n" +
"scroll=\""+scrolll+"\"\n" +
"scrollFlat=\""+scrollflatt+"\"\n" +
"singleInstance=\""+singleinstancee+"\"\n" +
"sysMenu=\""+sysmenuu+"\"\n" +
"contextMenu=no\n" +
"selection=no\n" +
"version=\""+versionn+"\" />"
        + ""
        + "<style>\n" +
"        /* Disable text selection */\n" +
"        body {\n" +
"            -webkit-user-select: none;  /* For Chrome, Safari, and newer browsers */\n" +
"            -moz-user-select: none;     /* For Firefox */\n" +
"            -ms-user-select: none;      /* For Internet Explorer and Edge */\n" +
"            user-select: none;          /* Standard syntax */\n" +
"        }\n" +
"\n" +
"        /* Disable dragging of text and other elements */\n" +
"        body {\n" +
"            -webkit-user-drag: none;    /* For Chrome, Safari, and newer browsers */\n" +
"            user-drag: none;            /* Standard syntax */\n" +
"        }\n" +
"    </style>"
        + ""
        + ""
        + "<script>\n" +
"    // Prevent text selection\n" +
"    document.addEventListener('selectstart', function (e) {\n" +
"        e.preventDefault();\n" +
"    });\n" +
"\n" +
"    // Prevent dragging of elements\n" +
"    document.addEventListener('dragstart', function (e) {\n" +
"        e.preventDefault();\n" +
"    });\n" +
"</script>";
        
      
//String newcode=code.replace("</title>",htatag);

//File fe1=new File(outputdir+"\\"+filenamee);
//fe1.mkdir();

File fe2=new File(outputdir+"\\"+filenamee+".hta");
fe2.createNewFile();

PrintWriter pw=new PrintWriter (new FileWriter (fe2));
pw.println(htatag);
pw.println(code);

//Noti

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have created the application successfully.");
      noti.hideAfter(Duration.seconds(2));
      noti.position(Pos.CENTER);
      noti.showInformation();

Desktop desk;
desk=Desktop.getDesktop();
desk.open(fe2);

        
    }
    
    
    @FXML
    void iconclick(MouseEvent event) {

    icon.clear();
    FileChooser dialog = new FileChooser();
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("ICON Files", new String[] { "*.ico" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    icon.setText(filePath);
       
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        border.getItems().addAll("thin","dialog","none","thick");
        borderstyle.getItems().addAll("complex","normal","raised","static","sunken");
        windowstate.getItems().addAll("normal","minimize","maximize");
        
        border.getSelectionModel().select(0);
        borderstyle.getSelectionModel().select(1);
        windowstate.getSelectionModel().select(0);
        
        
        
        
    }    
    
}
