
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static kadysoft.kady.Preview.pathy;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */


public class Edit_A_RecipeController implements Initializable {

    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private MenuItem openarecipe;

    @FXML
    private WebView webview;

    @FXML
    private JFXTextArea area;

    @FXML
    private ComboBox<String> model;

    @FXML
    private JFXCheckBox signme;

    @FXML
    private JFXButton save;
    
    @FXML
    private Label pathth;

    @FXML
    private JFXTextField user;
    
    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;
    
   MenuItem m1;
   MenuItem m2;
   MenuItem m3;
   MenuItem m4;
   MenuItem m5;
   MenuItem m6;
   
   PrintWriter pw;

   
   @FXML
    void areaaction(MouseEvent event) {

        
        area.paste();
        
    }

    
    
    @FXML
    void modelaction(Event event) {

        
           this.model.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.model.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
    }
    
    
    
    
    
    @FXML
    void openarecipeaction(ActionEvent event) throws IOException {

        if (user.getText().isEmpty()) {
            //////////////////////////////////////START///////////////////////////////////////
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
      String timeString2 = sdf2.format(d1);
      String value000 = timeString1;
      String value111 = timeString2;
      ComboBox myuser=new ComboBox ();
      myuser.setMinSize(150, 30);
      myuser.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      myuser.setPromptText("Choose One");
      myuser.setOnShown(evt -> {
          myuser.getItems().clear();
         try {
             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
             String line;
             while ((line = buf.readLine()) != null) {
             myuser.getItems().addAll(new String[] { line });
          } 
          buf.close();
          } catch (FileNotFoundException fileNotFoundException) {
    
          } catch (IOException iOException) {}
      });
      
      
      
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Choose Responsible");
      alert.setHeaderText("Please be careful, this info is important.");
      alert.setContentText("Hello, Please tell me: Who are you?.");
      alert.setGraphic(myuser);
      alert.setResizable(false);
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("primer-dark.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
      else if (option.get() == ButtonType.OK) {
          if (myuser.getSelectionModel().getSelectedItem()==null) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Please choose one user.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          }
          else {
              ////////////////////////Copy All Here/////////////////////////
              String theuser=myuser.getSelectionModel().getSelectedItem().toString();
              user.setText(theuser);
              String dateandtime=value111 +" - "+value000;
                         
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String thename=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    pathth.setText(pathy);
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"<head>\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <title>Kadysoft Ltd - Ahmed Elkady</title>\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-dialog.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-tour.min.css\" />\n" +
"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346&amp;g=1\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://cdn.bookingtimes.com/Scripts/jquery.slicknav.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://cdn.bookingtimes.com/Scripts/bootstrap-tour.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"./Scripts/tiny_mce/tinymce.min.js\" type=\"text/javascript\"></script>\n" +
"    <style>\n" +
"        #menuContainer {\n" +
"        background-color: black;\n" +
"        }\n" +
"    </style>\n" +
"    <script>\n" +
"        $(document).ready(function () {\n" +
"            $(\".modal\").on('shown', function () {\n" +
"                $(this).find(\"[autofocus]:first\").focus();\n" +
"            });\n" +
"            $('.modal').on('hidden.bs.modal', function () {\n" +
"                imageSelected(0, 0);\n" +
"            })\n" +
"        });\n" +
"        tinyMCE.init({\n" +
"            mode: \"specific_textareas\",\n" +
"            editor_selector: \"mceEditor\",\n" +
"            cleanup: false,\n" +
"			plugins: \"link,code,insertdatetime,preview,paste,table,visualblocks,fullscreen,image,emoticons,textcolor,colorpicker,lists,charmap,hr,print,autosave,charmap,codesample,colorpicker,fullpage,save,searchreplace,image,imagetools,help\",                         // Theme options - button# indicated the row# only\n" +
"            menu: {\n" +
"			    file: { title: 'File', items: 'print save |     autosave  charmap  codesample    | colorpicker fullpage searchreplace image imagetools' },\n" +
"                edit: { title: 'Edit', items: 'undo redo  | cut copy paste pastetext selectall | searchreplace' },\n" +
"                format: { title: 'Format', items: 'strikethrough superscript subscript | removeformat' },\n" +
"                view: { title: 'View', items: 'visualblocks visualaid | preview fullscreen | code' },\n" +
"                table: { title: 'Table', items: 'inserttable tableprops deletetable | cell row column' },\n" +
"				about: { title: 'About', items: 'help' }\n" +
"            },\n" +
"            images_dataimg_filter: function (img) {\n" +
"            return img.hasAttribute('internal-blob');\n" +
"            },\n" +
"            toolbar1: \"formatselect , fontsizeselect | bold italic underline |  outdent indent | bullist numlist | alignleft aligncenter alignright |  forecolor backcolor  |  inserttable tableprops deletetable | cell row column  |  table save print imagetools image noneditable fullpage fullscreen code autosave bbcode emoticons emotions | preview \",\n" +
"            style_formats: [{ title: 'h1', block: 'h1' },\n" +
"            { title: 'h2', block: 'h2' },\n" +
"            { title: 'h3', block: 'h3' },\n" +
"            { title: 'h4', block: 'h4' },\n" +
"            { title: 'h5', block: 'h5' }],\n" +
"            visualblocks_default_state: false,\n" +
"            end_container_on_empty_block: true,\n" +
"            resize: 'both',\n" +
"            browser_spellcheck: true,\n" +
"            paste_text_sticky: true,\n" +
"            paste_data_images: true,\n" +
"            inline_styles: true,\n" +
"            schema: 'html5',\n" +
"            valid_children: \"+body[style|meta],+a[*],+input[*],+a[div|p|span],+input[div|p|span]\",\n" +
"            extended_valid_elements: \"div[*],iframe[*],,a[*],p[*],img[*],input[*],script[*],meta[*]\",\n" +
"            allow_html_in_named_anchor: true,\n" +
"            remove_script_host: false,\n" +
"            convert_urls: false,\n" +
"            branding: false,\n" +
"            encoding: \"UTF-8\",\n" +
"            block_formats: 'Paragraph=p;Heading 2=h2;Heading 3=h3;Heading 4=h4;Heading 5=h5;Heading 6=h6;Address=address;Pre=pre',\n" +
"            theme_advanced_blockformats: 'p,address,pre,h1,h2,h3,h4,h5',\n" +
"            theme_advanced_buttons1_add_before: \"h1,h2,h3,h4,h5,h6,separator\",\n" +
"            theme_advanced_resizing: true,\n" +
"            init_instance_callback: function () { if (typeof tinyMCE_Init == \"function\") { tinyMCE_Init(); } },\n" +
"        });\n" +
"    </script>\n" +
"</head>\n" +
"<body>\n" +
"<center>\n" +
"        <div class=\"col-sm-9\">\n" +
"        <textarea rows=\"2\" cols=\"20\" id=\"txtBody\" class=\"mceEditor\" autocomplete=\"off\" style=\"height: 800px; width: 100%;\" aria-hidden=\"true\">\n" +
"			\n" +
"			\n" +
"			");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line.replace(" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">","").replace("<b>Mr_Moharam Signature: </b><img src=\"file://Z:\\Models\\Mr_Moharam.png\"","").replace("<b>Mr_Mohammed Signature: </b><img src=\"file://Z:\\Models\\Mr_Mohammed.png\"","") + "\n"); 
     
    pw.append("			\n" +
"			\n" +
"			</textarea>\n" +
"\n" +
"        </div>\n" +
"    </div>\n" +
"</center>\n" +
"</body>\n" +
"</html>");
    
   
    
    pw.close();
    buf.close();
    URI uri = Paths.get(NewDir.file_dirrrr + "\\Editor\\kadysoft.html").toAbsolutePath().toUri();
    webview.getEngine().load(uri.toString());
    
//    Desktop desk = Desktop.getDesktop();
//    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
     ///////////////Modify DB and Signature////////////////
          
          String filename=f.getName().replace(".html","").replace(".ks","");
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          try{
              
             String sql= "update Creation set Name='"+filename+"',Date='"+value0+"',Type='Pending',Revised_Date='Not_Revised' where Name='"+filename+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
              }catch(Exception e){    
            }
            finally {
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){
                }
          }
          //////////////////////////////////////////////////////
          
   
    
    
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
     String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
              try {
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                       output.append(linee+"\n");
                   }
                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, dateandtime);
          this.pst.setString(2, theuser);
          this.pst.setString(3, MachineID);
          this.pst.setString(4, theuser+" is editing a recipe called "+thename);
          
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
    
              
              //////////////////////////////////////////////////////////////
          }
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't edited.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      /////////////////////////////////////////END/////////////////////////////////////
       
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        else {
             //////////////////////////////////////START///////////////////////////////////////
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
      String timeString2 = sdf2.format(d1);
      String value000 = timeString1;
      String value111 = timeString2;
      
    ////////////////////////Copy All Here/////////////////////////
             
    String dateandtime=value111 +" - "+value000;              
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String thename=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    pathth.setText(pathy);
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"<head>\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <title>Kadysoft Ltd - Ahmed Elkady</title>\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-dialog.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-tour.min.css\" />\n" +
"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346&amp;g=1\" rel=\"stylesheet\" type=\"text/css\">\n" +
"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://cdn.bookingtimes.com/Scripts/jquery.slicknav.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"https://cdn.bookingtimes.com/Scripts/bootstrap-tour.min.js\" type=\"text/javascript\"></script>\n" +
"    <script src=\"./Scripts/tiny_mce/tinymce.min.js\" type=\"text/javascript\"></script>\n" +
"    <style>\n" +
"        #menuContainer {\n" +
"        background-color: black;\n" +
"        }\n" +
"    </style>\n" +
"    <script>\n" +
"        $(document).ready(function () {\n" +
"            $(\".modal\").on('shown', function () {\n" +
"                $(this).find(\"[autofocus]:first\").focus();\n" +
"            });\n" +
"            $('.modal').on('hidden.bs.modal', function () {\n" +
"                imageSelected(0, 0);\n" +
"            })\n" +
"        });\n" +
"        tinyMCE.init({\n" +
"            mode: \"specific_textareas\",\n" +
"            editor_selector: \"mceEditor\",\n" +
"            cleanup: false,\n" +
"			plugins: \"link,code,insertdatetime,preview,paste,table,visualblocks,fullscreen,image,emoticons,textcolor,colorpicker,lists,charmap,hr,print,autosave,charmap,codesample,colorpicker,fullpage,save,searchreplace,image,imagetools,help\",                         // Theme options - button# indicated the row# only\n" +
"            menu: {\n" +
"			    file: { title: 'File', items: 'print save |     autosave  charmap  codesample    | colorpicker fullpage searchreplace image imagetools' },\n" +
"                edit: { title: 'Edit', items: 'undo redo  | cut copy paste pastetext selectall | searchreplace' },\n" +
"                format: { title: 'Format', items: 'strikethrough superscript subscript | removeformat' },\n" +
"                view: { title: 'View', items: 'visualblocks visualaid | preview fullscreen | code' },\n" +
"                table: { title: 'Table', items: 'inserttable tableprops deletetable | cell row column' },\n" +
"				about: { title: 'About', items: 'help' }\n" +
"            },\n" +
"            images_dataimg_filter: function (img) {\n" +
"            return img.hasAttribute('internal-blob');\n" +
"            },\n" +
"            toolbar1: \"formatselect , fontsizeselect | bold italic underline |  outdent indent | bullist numlist | alignleft aligncenter alignright |  forecolor backcolor  |  inserttable tableprops deletetable | cell row column  |  table save print imagetools image noneditable fullpage fullscreen code autosave bbcode emoticons emotions | preview \",\n" +
"            style_formats: [{ title: 'h1', block: 'h1' },\n" +
"            { title: 'h2', block: 'h2' },\n" +
"            { title: 'h3', block: 'h3' },\n" +
"            { title: 'h4', block: 'h4' },\n" +
"            { title: 'h5', block: 'h5' }],\n" +
"            visualblocks_default_state: false,\n" +
"            end_container_on_empty_block: true,\n" +
"            resize: 'both',\n" +
"            browser_spellcheck: true,\n" +
"            paste_text_sticky: true,\n" +
"            paste_data_images: true,\n" +
"            inline_styles: true,\n" +
"            schema: 'html5',\n" +
"            valid_children: \"+body[style|meta],+a[*],+input[*],+a[div|p|span],+input[div|p|span]\",\n" +
"            extended_valid_elements: \"div[*],iframe[*],,a[*],p[*],img[*],input[*],script[*],meta[*]\",\n" +
"            allow_html_in_named_anchor: true,\n" +
"            remove_script_host: false,\n" +
"            convert_urls: false,\n" +
"            branding: false,\n" +
"            encoding: \"UTF-8\",\n" +
"            block_formats: 'Paragraph=p;Heading 2=h2;Heading 3=h3;Heading 4=h4;Heading 5=h5;Heading 6=h6;Address=address;Pre=pre',\n" +
"            theme_advanced_blockformats: 'p,address,pre,h1,h2,h3,h4,h5',\n" +
"            theme_advanced_buttons1_add_before: \"h1,h2,h3,h4,h5,h6,separator\",\n" +
"            theme_advanced_resizing: true,\n" +
"            init_instance_callback: function () { if (typeof tinyMCE_Init == \"function\") { tinyMCE_Init(); } },\n" +
"        });\n" +
"    </script>\n" +
"</head>\n" +
"<body>\n" +
"<center>\n" +
"        <div class=\"col-sm-9\">\n" +
"        <textarea rows=\"2\" cols=\"20\" id=\"txtBody\" class=\"mceEditor\" autocomplete=\"off\" style=\"height: 800px; width: 100%;\" aria-hidden=\"true\">\n" +
"			\n" +
"			\n" +
"			");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line.replace(" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">","").replace("<b>Mr_Moharam Signature: </b><img src=\"file://Z:\\Models\\Mr_Moharam.png\"","").replace("<b>Mr_Mohammed Signature: </b><img src=\"file://Z:\\Models\\Mr_Mohammed.png\"","") + "\n"); 
     
    pw.append("			\n" +
"			\n" +
"			</textarea>\n" +
"\n" +
"        </div>\n" +
"    </div>\n" +
"</center>\n" +
"</body>\n" +
"</html>");
    
   
    pw.close();
    buf.close();
    URI uri = Paths.get(NewDir.file_dirrrr + "\\Editor\\kadysoft.html").toAbsolutePath().toUri();
    webview.getEngine().load(uri.toString());
    
//    Desktop desk = Desktop.getDesktop();
//    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
     ///////////////Modify DB and Signature////////////////
          
          String filename=f.getName().replace(".html","").replace(".ks","");
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          try{
              
             String sql= "update Creation set Name='"+filename+"',Date='"+value0+"',Type='Pending',Revised_Date='Not_Revised' where Name='"+filename+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
              }catch(Exception e){    
            }
            finally {
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){
                }
          }
          //////////////////////////////////////////////////////
          
   
    
    
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
     String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
              try {
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                       output.append(linee+"\n");
                   }
                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, dateandtime);
          this.pst.setString(2, user.getText());
          this.pst.setString(3, MachineID);
          this.pst.setString(4, user.getText()+" is editing a recipe called "+thename);
          
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
    
              
              //////////////////////////////////////////////////////////////
          
      
      
      
      /////////////////////////////////////////END/////////////////////////////////////
      
        }
         
     
      
        
        
    }

    
    
    
    
    
    @FXML
    void saveaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {

         if (signme.isSelected()==true) {
       
       
            String codee=area.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=model.getSelectionModel().getSelectedItem().toString();
            String linkk=pathth.getText();
            
            OutputStream instream=new FileOutputStream(linkk);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft Ltd - Ahmed Elkady</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
//            Stage jk = (Stage)this.save.getScene().getWindow();
//            jk.close();

      Notifications noti = Notifications.create();
      noti.title("Successful!");
      noti.text("We saved everything successfully.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(2));
      noti.showInformation();
      
      webview.getEngine().loadContent("");
      area.clear();
      pathth.setText("Kadysoft Ltd.");
   
       /////////////////////////////////////////////////// 
   
       
       
   }
   
   
   else {
       
       
            String codee=area.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=model.getSelectionModel().getSelectedItem().toString();
            String linkk=pathth.getText();
            
            OutputStream instream=new FileOutputStream(linkk);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft Ltd - Ahmed Elkady</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
//            Stage jk = (Stage)this.save.getScene().getWindow();
//            jk.close();

      Notifications noti = Notifications.create();
      noti.title("Successful!");
      noti.text("We saved everything successfully.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(2));
      noti.showInformation();
      
      webview.getEngine().loadContent("");
      area.clear();
      pathth.setText("Kadysoft Ltd.");
   
       /////////////////////////////////////////////////// 
   
       
   }
   
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        this.conn = db.java_db();
        
        
        this.m1 = new MenuItem("Open Recipe");
      this.m1.setOnAction((uu) -> {
         FileChooser fcho = new FileChooser();
         String go = NewDir.file_dir;
         fcho.setInitialDirectory(new File(go));
         fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[]{"*.ks"}));
         fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
         fcho.setTitle("Kady Choose");
         File f = fcho.showOpenDialog((Window)null);
         pathy = f.getAbsolutePath().toString();
         String newpathyy=pathy.replace(".ks", ".html");
        String linet = "cmd /C copy /Y "+pathy+" "+newpathyy;
        Process p;
        
          try {
              p = Runtime.getRuntime().exec(linet);
              p.waitFor();
          } catch (IOException ex) {
              Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        URI uri = Paths.get(newpathyy).toAbsolutePath().toUri();
        webview.getEngine().load(uri.toString());
        File nm=new File (newpathyy);
        if (pathy.contains(".ks")) {
            nm.delete();
        }
        else {
            
        }
      });
      this.m2 = new MenuItem("Open In Browser");
      this.m2.setOnAction((uu) -> {
          String newpathyy=pathy.replace(".ks", ".html");
         Desktop des = Desktop.getDesktop();

         try {
            des.open(new File(newpathyy));
         } catch (IOException var3) {
         }

      });
      this.m3 = new MenuItem("Exit");
      this.m3.setOnAction((uu) -> {
         System.exit(0);
      });
      this.m5 = new MenuItem("Increase Scale");
      this.m5.setOnAction((uu) -> {
         this.webview.setFontScale(this.webview.getFontScale() + 1.0);
      });
      this.m6 = new MenuItem("Decrease Scale");
      this.m6.setOnAction((uu) -> {
         this.webview.setFontScale(this.webview.getFontScale() - 1.0);
      });
      this.m4 = new MenuItem("Print Recipe");
      this.m4.setOnAction((uu) -> {
         PrinterJob job = PrinterJob.createPrinterJob();
         job.showPrintDialog((Window)null);
         job.showPageSetupDialog((Window)null);
         this.webview.getEngine().print(job);
         job.endJob();
      });
      ContextMenu cm = new ContextMenu();
      cm.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      cm.getItems().addAll(new MenuItem[]{ this.m5, this.m6, this.m3});
      this.webview.setContextMenuEnabled(false);
      this.webview.setOnMousePressed((e) -> {
         if (e.getButton() == MouseButton.SECONDARY) {
            cm.show(this.webview, e.getSceneX(), e.getSceneY());
         } else {
            cm.hide();
         }

      });
      
      
        
        
        
        
    }    
    
}
