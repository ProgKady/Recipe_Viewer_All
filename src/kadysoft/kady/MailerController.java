


package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class MailerController implements Initializable {

    
    @FXML
    private JFXButton browse;

    @FXML
    private JFXTextField link;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXButton prepare;
    
    @FXML
    private JFXTextArea area;

    @FXML
    void browseaction(ActionEvent event) throws FileNotFoundException, IOException {

    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File (NewDir.file_dir));
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    link.setText(filePath);
    String filenamee= dialogResult.getName().replace(".ks","").replace(".html","");
    name.setText(filenamee);
    prepare.setDisable(false);
    BufferedReader buf=new BufferedReader (new FileReader (link.getText()));
    String line;
    while ((line=buf.readLine())!=null) {
    area.appendText(line+"\n");
    }
    buf.close();

    }

    @FXML
    void prepareaction(ActionEvent event) throws IOException {

        File ff=new File (System.getProperty("user.home")+"\\Desktop\\"+name.getText()+"_Kadysoft_Mailer.html");
        ff.createNewFile();
        PrintWriter pw=new PrintWriter(new BufferedWriter (new FileWriter (ff)));
        pw.println("<!DOCTYPE html>\n" +
"<html> \n" +
"<head>\n" +
"<meta charset=\"utf-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<meta name=\"generator\" content=\"RocketCake\">\n" +
"<title>Kadysoft Ltd</title>\n" +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"index_html.css\">\n" +
"<style>\n" +
"#button_40c8368a { vertical-align: bottom; position:relative; display: inline-block; \n" +
"width:100px; height:30px; background-color:#80079E; font-size:12pt; \n" +
"font-family:Arial, Helvetica, sans-serif; color:#FFFFFF; font-weight:bold;  }\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<center>\n" +
"<div class=\"textstyle1\">\n" +
"<div id=\"container_25ee779\"><div id=\"container_25ee779_padding\" ></div></div>  </div>\n" +
"<div class=\"textstyle2\">\n" +
"<h4 id=\"heading_e4bf9ac\">Kadysoft Ltd-Ahmed Elkady</h4>  </div>\n" +
"<div class=\"textstyle1\">\n" +
"<span class=\"textstyle3\"><br/></span> </div>");
        pw.println("\n\n\n"+area.getText()+"\n\n\n");
        pw.println("<form  action=\"https://docs.google.com/forms/d/e/1FAIpQLSfmAATREAn5yyduKeNaZWfE6SqO_EEqZV5tJrmy48XQ1Yv2FQ/formResponse?\"\n" +
"id=\"gform\" name=\"gform\" target=\"hidden_iframe\" onsubmit=\"submitted=true;\">\n" +
"<div id=\"form_6385801d_padding\" ><div class=\"textstyle1\">\n" +
"<input type=\"text\" value=\""+name.getText()+"\" title=\"\" name=\"entry.447699606\" class=\"form-control\"  id=\"entry.447699606\" placeholder=\"Recipe_Name\" required>\n" +
"<div id=\"container_64f37254\"><div id=\"container_64f37254_padding\" ></div></div>\n" +
"<input type=\"text\" value=\"\" title=\"\" name=\"entry.1239383718\" class=\"form-control\"  id=\"entry.1239383718\" list=\"exampleList\" placeholder=\"Status...\" required>\n" +
"<datalist id=\"exampleList\">\n" +
"<option value=\"Approve\">  \n" +
"<option value=\"Reject\">\n" +
"</datalist>\n" +
"<div id=\"container_65b495a2\"><div id=\"container_65b495a2_padding\" ></div></div>\n" +
"<input name=\"Button1\" type=\"submit\" value=\"Submit\" title=\"\"  id=\"button_40c8368a\" >\n" +
"</div>\n" +
"<div style=\"clear:both\"></div></div></form></div>\n" +
"<iframe name=\"hidden_iframe\" id=\"hidden_iframe\" style=\"display:none;\" onload=\"if(submitted){}\"></iframe>\n" +
"<div style=\"clear:both\"></div></div></div></div>\n" +
"<div style=\"clear:both\"></div></div></div></div>\n" +
"</center>\n" +
"</body>\n" +
"<script type=\"text/javascript\">var submitted=false;</script>\n" +
"<script type=\"text/javascript\">\n" +
"$('#gform').on('submit', function(e) {\n" +
"   $('#gform *').fadeOut(2000);\n" +
"    $('#gform').prepend('Successful Submission');\n" +
"});\n" +
"</script>\n" +
"<script async src=\"https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-8842279959307592\"\n" +
"crossorigin=\"anonymous\"></script>\n" +
"</html>");
        pw.close();
        
     
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We created a recipe for mailing, send it to any user via any service.\nPowered By Kadysoft Ltd.");
      noti.hideAfter(Duration.seconds(6));
      noti.position(Pos.CENTER);
      noti.showInformation();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
    }    
    
}
