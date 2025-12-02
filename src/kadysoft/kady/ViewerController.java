package kadysoft.kady;

import com.gluonhq.charm.glisten.animation.PulseTransition;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Builder;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableFilter;

public class ViewerController   <T extends Comparable<T>> implements Initializable {
    
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  ToggleGroup tg;
  
  ToggleGroup sttt;
  
  @FXML
  private TableView table;
  
  @FXML
    private JFXTextField wordy;
  
  @FXML
  private Hyperlink link;
  
  @FXML
  private JFXRadioButton date;
  
  @FXML
  private JFXTextField content;
  
  @FXML
  private JFXRadioButton stage;
  
  @FXML
  private JFXRadioButton model;
  
  @FXML
  private JFXRadioButton name;
  
  @FXML
  private JFXRadioButton app;
  
  @FXML
  private JFXRadioButton pen;
  
  @FXML
  private JFXRadioButton rej;
  
  @FXML
  private JFXButton getallbtn;
  
  @FXML
  private JFXButton delete;
  
  @FXML
  private JFXButton logout;
  
  @FXML
  private JFXButton encryptbtn;
  
  @FXML
  private JFXButton sign;
  
  @FXML
  private TextArea areaaa;
  
  @FXML
  private JFXButton setme;
  
  @FXML
  private JFXButton decrypt;
  
  @FXML
  private JFXButton encrypt;
  
  @FXML
  private JFXButton report,printout;
  
  @FXML
  private ComboBox<String> signature;
  
  //////////////////////////////////////////////////////////////////////////////////////
  /*
  public  void addTextFilter(ObservableList<List<Object>> allData,
        JFXTextField filterField, TableView<List<Object>> table) {

    final List<TableColumn<List<Object>, ?>> columns = table.getColumns();

    FilteredList<List<Object>> filteredData = new FilteredList<>(allData);
    filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> {
        String text = wordy.getText();

        if (text == null || text.isEmpty()) {
            return null;
        }
        final String filterText = text.toLowerCase();

        return o -> {
            for (Object value : columns) {
                if (value != null && value.toString().toLowerCase().equals(filterText)) {
                    return true;
                }
            }
            return false;
        };
    }, filterField.textProperty()));

    SortedList<List<Object>> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(table.comparatorProperty());
    table.setItems(sortedData);
}
  */
  //////////////////////////////////////////////////////////////////////////////////////
  
  @FXML
    void printoutaction(ActionEvent event) throws FileNotFoundException, IOException {
        
        FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Editor\\index.html"));
    pw.append("<html lang=\"ar\">\n<head>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n\t\t<title>Kadysoft Ltd - Ahmed Elkady</title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line + "\n"); 
     
    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>");
    
    
    
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\index.html"));
        
    }
  
  
  
  
  
  
  @FXML
    void wordyaction(KeyEvent event) {
        
       
        
        
        
      
        
               
        
        
        /*
       
    /////////////////////////////////////////////////////////
    ObservableList<List<Object>> allData = table.getItems();
    
   final List<TableColumn<List<Object>, ?>> columns = table.getColumns();

    FilteredList<List<Object>> filteredData = new FilteredList<>(allData);
    
    filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> {
        String text = wordy.getText();

        if (text == null || text.isEmpty()) {
            return null;
        }
        final String filterText = text.toLowerCase();

        return o -> {
            for (Object value : columns) {
                if (value != null && value.toString().toLowerCase().contains(filterText)) {
                    return true;
                   
                   
                }
            }
            return false;
        };
    }, wordy.textProperty()));

    SortedList<List<Object>> sortedData = new SortedList<>(filteredData);
    sortedData.comparatorProperty().bind(table.comparatorProperty());
    table.setItems(sortedData);
    
    /////////////////////////////////////////////////////////
   */     
    }
  
  @FXML
  void openrecipesfolderaction(ActionEvent event) throws IOException {
      
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (NewDir.file_dir));
      
  }
  
  @FXML
  void logoutaction(ActionEvent event) throws SQLException, IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("LogIn_GUI.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("LogIn Window");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    Stage jk = (Stage)this.encrypt.getScene().getWindow();
    jk.close();
    
    
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
     String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
              try {
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String line="";
                   while ((line=sNumReader.readLine())!=null) {
                       output.append(line+"\n");
                   }
                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, value1);
          this.pst.setString(2, "Admin");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Admin Logged Out.");
          
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
          
          
    
  }
  
  @FXML
  void contentaction(KeyEvent event) throws SQLException {
    if (this.date.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Date=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else if (this.name.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Name=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else if (this.model.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Model=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else if (this.stage.isSelected()) {
      this.table.getColumns().clear();
      ObservableList<ObservableList> data = FXCollections.observableArrayList();
      try {
        String sql = "select * from Creation where Stage=?";
        this.pst = this.conn.prepareStatement(sql);
        this.pst.setString(1, this.content.getText());
        this.rs = this.pst.executeQuery();
        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
          final int j = i;
          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                }
              });
          this.table.getColumns().addAll(new Object[] { col });
        } 
        while (this.rs.next()) {
          ObservableList<String> row = FXCollections.observableArrayList();
          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
            row.add(this.rs.getString(j)); 
          data.add(row);
        } 
        this.table.setItems(data);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          this.rs.close();
          this.pst.close();
        } catch (Exception exception) {}
      } 
    } else {
      ImageView imgview = new ImageView();
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Please Choose One Filter Type.");
      noti.position(Pos.CENTER);
      noti.showWarning();
    } 
  }
  
  @FXML
  void deleteaction(ActionEvent event) throws SQLException {
      
      String lk=link.getText();
      
      if (!lk.contains("\\")) {
          Notifications noti = Notifications.create();
          noti.title("Delete!");
          noti.text("Please Select a recipe first!...");
          noti.position(Pos.CENTER);
          noti.showError();
      }
      else {
          
            ////////////////////////////////////////////////    
               
               
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Delete File");
      alert.setHeaderText("Are you sure want to move this Recipe to the Recycle Bin?");
      alert.setContentText(link.getText());

      // option != null.
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
         
      } else if (option.get() == ButtonType.OK) {
             try {
               
              
      String sql = "delete from Creation where Path=? ";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, this.link.getText());
      this.pst.execute();
      Notifications noti = Notifications.create();
      noti.title("Delete!");
      noti.text("Recipe Successfully Deleted");
      noti.position(Pos.CENTER);
      noti.showInformation();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    } 
    File fp = new File(this.link.getText().replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:"));
    fp.delete();
    this.table.getColumns().clear();
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
    try {
      String sql = "select * from Creation";
      this.pst = this.conn.prepareStatement(sql);
      this.rs = this.pst.executeQuery();
      for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
        final int j = i;
        TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
        col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
              public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
              }
            });
        this.table.getColumns().addAll(new Object[] { col });
      } 
      while (this.rs.next()) {
        ObservableList<String> row = FXCollections.observableArrayList();
        for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
          row.add(this.rs.getString(j)); 
        data.add(row);
      } 
      this.table.setItems(data);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
    
      } else if (option.get() == ButtonType.CANCEL) {
         Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't deleted.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      } else {
         
      }
               
               
               
         /////////////////////////////////////////////////   
          
          
       
      }
      
  }
  
  @FXML
  void setmeaction(ActionEvent event) throws IOException, InterruptedException {
    if (this.link.getText().contains("Recipe_System\\Recipes")) {
      if (this.app.isSelected()) {
        String lino = this.link.getText();
        try {
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          String value1 = dateString;
          String sql = "update Creation set Path='" + lino + "' ,Type= 'Approved', Revised_Date='" + timeString + "' where Path='" + lino + "'";
          this.pst = this.conn.prepareStatement(sql);
          this.pst.execute();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        } 
        Notifications noti = Notifications.create();
        noti.title("Update!");
        noti.text("Record Successfully Updated");
        noti.position(Pos.CENTER);
        noti.showConfirm();
        this.pen.setSelected(false);
        this.rej.setSelected(false);
        this.app.setSelected(false);
        this.table.getColumns().clear();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
          String sql = "select * from Creation";
          this.pst = this.conn.prepareStatement(sql);
          this.rs = this.pst.executeQuery();
          for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
            final int j = i;
            TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                  public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                  }
                });
            this.table.getColumns().addAll(new Object[] { col });
          } 
          while (this.rs.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
              row.add(this.rs.getString(j)); 
            data.add(row);
          } 
          this.table.setItems(data);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }
        
        
//        //Get Signature Value to add it to recipe
//        
//        String signname=signature.getSelectionModel().getSelectedItem();
//        String pathtosignature="file://"+NewDir.file_dirrrrr+"\\"+signname+".png";
//        
//        //Read it.
//        
//        try {
//      BufferedReader buf = new BufferedReader(new FileReader(lino));
//      String line;
//      while ((line = buf.readLine()) != null) {
//        areaaa.appendText(line);
//      } 
//      buf.close();
//      } 
//      catch (FileNotFoundException fileNotFoundException) {
//    
//      }
//        
//        //Write
//        
//        String col=areaaa.getText();
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(lino)));
//        pw.println(col);                                          
//        //pw.println("<hr>");
//        
//        pw.println("<b>"+signname+" Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"220\" height=\"80\" alt=\"Developed By Kadysoft Ltd.\" style=\"border-color:black;border-width:10px;\">");
//        pw.close();
        
        
        //signature.setDisable(true);
        
      } else if (this.pen.isSelected()) {
        String lino = this.link.getText();
        try {
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          String value1 = dateString;
          String sql = "update Creation set Path='" + lino + "' ,Type= 'Pending', Revised_Date='" + timeString + "' where Path='" + lino + "'";
          this.pst = this.conn.prepareStatement(sql);
          this.pst.execute();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        } 
        Notifications noti = Notifications.create();
        noti.title("Update!");
        noti.text("Record Successfully Updated");
        noti.position(Pos.CENTER);
        noti.showConfirm();
        this.pen.setSelected(false);
        this.rej.setSelected(false);
        this.app.setSelected(false);
        this.table.getColumns().clear();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
          String sql = "select * from Creation";
          this.pst = this.conn.prepareStatement(sql);
          this.rs = this.pst.executeQuery();
          for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
            final int j = i;
            TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                  public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                  }
                });
            this.table.getColumns().addAll(new Object[] { col });
          } 
          while (this.rs.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
              row.add(this.rs.getString(j)); 
            data.add(row);
          } 
          this.table.setItems(data);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        } 
        
        setme.setDisable(false);
        
        
      } else if (this.rej.isSelected()) {
        String lino = this.link.getText();
        try {
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          String value1 = dateString;
          String sql = "update Creation set Path='" + lino + "' ,Type= 'Rejected', Revised_Date='" + timeString + "' where Path='" + lino + "'";
          this.pst = this.conn.prepareStatement(sql);
          this.pst.execute();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        } 
        Notifications noti = Notifications.create();
        noti.title("Delete!");
        noti.text("Record Successfully Updated");
        noti.position(Pos.CENTER);
        noti.showConfirm();
        this.pen.setSelected(false);
        this.rej.setSelected(false);
        this.app.setSelected(false);
        this.table.getColumns().clear();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
          String sql = "select * from Creation";
          this.pst = this.conn.prepareStatement(sql);
          this.rs = this.pst.executeQuery();
          for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
            final int j = i;
            TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                  public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
                  }
                });
            this.table.getColumns().addAll(new Object[] { col });
          } 
          while (this.rs.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
              row.add(this.rs.getString(j)); 
            data.add(row);
          } 
          this.table.setItems(data);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }
        
        ////////////////////////Change Extension///////////////////////
         String lpo=link.getText().replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
         String newlpo=lpo.replace(".html",".kadysoft");
         
         String linet = "cmd /C COPY /Y "+lpo+" "+newlpo;
         Process p = Runtime.getRuntime().exec(linet);
         p.waitFor(); 
       //  Process process = Runtime.getRuntime().exec("cmd /c copy "+lpo+" "+newlpo);
         File fpp=new File (lpo);
         
        ///////////////////////////////////////////////////////////////
        encrypt.setVisible(true);
        setme.setDisable(false);
        fpp.delete();
        
      } else {
        ImageView imgview = new ImageView();
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("Please Select One Status To Set.");
        noti.position(Pos.CENTER);
        noti.showWarning();
      } 
    } else {
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.hideAfter(Duration.minutes(1.0D));
      noti.position(Pos.CENTER);
      noti.showWarning();
      this.app.setSelected(false);
      this.pen.setSelected(false);
      this.rej.setSelected(false);
    } 
  }
  
  @FXML
  void getallaction(ActionEvent event) {
    this.table.getColumns().clear();
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
    try {
      String sql = "select * from Creation";
      this.pst = this.conn.prepareStatement(sql);
      this.rs = this.pst.executeQuery();
      for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
        final int j = i;
        TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
        col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
              public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
              }
            });
        this.table.getColumns().addAll(new Object[] { col });
      } 
      while (this.rs.next()) {
        ObservableList<String> row = FXCollections.observableArrayList();
        for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
          row.add(this.rs.getString(j)); 
        data.add(row);
      } 
      this.table.setItems(data);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    } 
    
    
     TableFilter filter = new TableFilter(table);
   //  TableFilter<Object> tableFilter = new TableFilter<>(table);
//ObservableList<Object> items = tableFilter.getBackingList();
    
  }
  
  @FXML
  void reportaction(ActionEvent event) throws IOException {
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
  //  String value1 = dateString;
   // String value11 = value1.replace("/", "_");
    String repname = "Report_Of_" + value00;
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      DateFormat dff = new SimpleDateFormat("dd/MM/yyyy");
      Date dd = new Date();
      String todate = dff.format(dd);
      Calendar cal = Calendar.getInstance();
      cal.add(5, -2);
      Date d1 = cal.getTime();
      String fromdate = dff.format(d1);
      String sql = "select * from Creation where Revised_Date between '" + fromdate + "' and '" + todate + "'";
      this.pst = this.conn.prepareStatement(sql);
      this.rs = this.pst.executeQuery();
      Document myDocument = new Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 11.0F, 11.0F, 11.0F, 11.0F, 11.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      Image image = Image.getInstance(NewDir.file_dirrr + "\\tandc.png");
      myDocument.add((Element)image);
      myDocument.add((Element)new Paragraph("--------------------"));
      myDocument.add((Element)new Paragraph("Report For The Last 3 Days Revised Recipes. ", FontFactory.getFont("Times-Bold", 20.0F, 1)));
      myDocument.add((Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Model", FontFactory.getFont("Times-Roman", 14.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Wash Name", FontFactory.getFont("Times-Roman", 14.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Creation Date", FontFactory.getFont("Times-Roman", 14.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Revised Date", FontFactory.getFont("Times-Roman", 14.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Status", FontFactory.getFont("Times-Roman", 14.0F, 1))));
      while (this.rs.next()) {
        table.addCell(new PdfPCell((Phrase)new Paragraph(this.rs.getString(4), FontFactory.getFont("Times-Roman", 12.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(this.rs.getString(5), FontFactory.getFont("Times-Roman", 12.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(this.rs.getString(2), FontFactory.getFont("Times-Roman", 12.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(this.rs.getString(8), FontFactory.getFont("Times-Roman", 12.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(this.rs.getString(7), FontFactory.getFont("Times-Roman", 12.0F, 0))));
      } 
      myDocument.add((Element)table);
      myDocument.add((Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      JFXTextArea gr = new JFXTextArea();
      gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      gr.setLabelFloat(true);
      gr.setPromptText("Click To Add Some Notes .... ");
      gr.setMinSize(500.0D, 250.0D);
      Alert alo = new Alert(Alert.AlertType.INFORMATION);
      alo.setTitle("Add Notes?");
      alo.setGraphic((Node)gr);
      alo.setResizable(false);
      alo.showAndWait();
      myDocument.add((Element)new Paragraph(gr.getText(), FontFactory.getFont("Courier-Bold", 17.0F, 1)));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert aloo = new Alert(Alert.AlertType.CONFIRMATION);
      aloo.setTitle("Info");
      aloo.setHeaderText("Info!");
      aloo.setContentText("Report was generated successfully");
      aloo.setResizable(true);
      aloo.showAndWait();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
  }
  
  
  
  
  
  @FXML
  void linkaction(ActionEvent event) throws IOException, InterruptedException {
      
      
    String linkval = this.link.getText();
    if (linkval.equals("T & C Garments")) {
      ImageView imgview = new ImageView();
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.hideAfter(Duration.minutes(1.0D));
      noti.position(Pos.CENTER);
      noti.showWarning();
      
      
    } else if (!linkval.contains("Recipe_System\\Recipes")) {
      ImageView imgview = new ImageView();
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.hideAfter(Duration.minutes(1.0D));
      noti.position(Pos.CENTER);
      noti.showWarning();
      
      
    } else {
      String path = this.link.getText().replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
      File op = new File(path);
      if (!op.exists()) {
        ImageView imgview = new ImageView();
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe the admin has deleted it.");
        noti.hideAfter(Duration.minutes(1.0D));
        noti.position(Pos.CENTER);
        noti.showWarning();
        
        
      } else {
          
        //Desktop desk = Desktop.getDesktop();
        //desk.open(new File(path));
        //////////////////////////////////////Web View Alert ///////////////////////////////
        WebView webview=new WebView ();
        webview.setMinSize(1200, 600);
        ScrollPane sp=new ScrollPane();
        sp.setMinSize(1200, 600);
        sp.setContent(webview);
        //webview.setContextMenuEnabled(true);
        //webview.setDisable(true);
        String newpathyy=path.replace(".ks", ".html");
        String linet = "cmd /C copy /Y "+path+" "+newpathyy;
        Process p = Runtime.getRuntime().exec(linet);
        p.waitFor();
        URI uri = Paths.get(newpathyy).toAbsolutePath().toUri();
        webview.getEngine().load(uri.toString());
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Preview a recipe");
        alo.setGraphic((Node)webview);
        alo.setResizable(false);
        alo.showAndWait();
        File nm=new File (newpathyy);
        if (path.contains(".ks")) {
            nm.delete();
        }
        else {
            
        }
        ////////////////////////////////////////////////////////////////////////////////////

      } 

    } 
    
  }
  
  
  
  
  
  @FXML
  void tableaction(MouseEvent event) throws FileNotFoundException, IOException {
    TablePosition pos = (TablePosition) this.table.getSelectionModel().getSelectedCells().get(0);
    int idd = ((Integer)this.table.getSelectionModel().getSelectedIndices().get(0)).intValue();
    int iddd = idd + 1;
    String idddd = Integer.toString(iddd);
    String h = pos.getTableColumn().getCellData(pos.getRow()).toString();
    String colname = pos.getTableColumn().getText();
    this.link.setText(h);
  }
  
  @FXML
  void signatureaction(ActionEvent event)  {
      
      
      
      setme.setDisable(false);
      
  }
  
  @FXML
  void encryptaction(ActionEvent event) throws IOException  {
      String lm=link.getText().replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
      String newlm=lm.replace(".ks",".kadysoft");
      try {
      BufferedReader buf = new BufferedReader(new FileReader(newlm));
      String line;
      while ((line = buf.readLine()) != null) {
        areaaa.appendText(line);
      } 
      buf.close();
    } 
    catch (FileNotFoundException fileNotFoundException) {
    
    }
      
      
      String codet = areaaa.getText();
      String newcodet=codet.replaceAll("table","tablee").replaceAll("tbody","tbodyy").replaceAll("tr","trr").replaceAll("td","tdd");
      OutputStream instream=new FileOutputStream(newlm);
      PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
      pw.println(newcodet);
      pw.close();
      
      
      encrypt.setVisible(false);
      areaaa.clear();
      
  }
  
  
  @FXML
  void decryptaction(ActionEvent event) throws IOException   {
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Decrypt.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Decrypt A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
  }
  
  @FXML
  void encryptbtnaction(ActionEvent event) throws IOException   {
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Encrypt.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Encrypt A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
  }
  
  
  @FXML
  void signaction(ActionEvent event) throws IOException   {
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Sign.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Sign A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
  }
  
  @FXML
  void showsigns(Event event)    {
      
      this.signature.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Signs.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.signature.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
      
  }
  
  public void initialize(URL url, ResourceBundle rb) {
      
      
   
      
      //////////////////////////////////////////////////////////////////////////////
      
      PulseTransition st;
      st=new PulseTransition(encrypt);
      st.setAutoReverse(true);
      st.setCycleCount(1000000000);
      st.play();
      
    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    this.tg = new ToggleGroup();
    this.sttt = new ToggleGroup();
    this.date.setToggleGroup(this.tg);
    this.stage.setToggleGroup(this.tg);
    this.name.setToggleGroup(this.tg);
    this.model.setToggleGroup(this.tg);
    this.app.setToggleGroup(this.sttt);
    this.pen.setToggleGroup(this.sttt);
    this.rej.setToggleGroup(this.sttt);
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    this.content.setText(timeString);
    this.conn = db.java_db();
    
    
    
    
       
      /////////////////////////////////////////////////////////////////////////////
    
      
//       final HourService hservice = new HourService();
//        hservice.setCalendarInstance(Calendar.getInstance());
//        hservice.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // Anonymous
//
//            @Override
//            public void handle(WorkerStateEvent t) {   
//                hservice.restart();
//            }
//        });
//        hservice.start();
//    
//      
//    
    
    
    
    
    
  }
}


////////////////////////////////////////////////////////////////////////////////

//   class HourService extends Service<Date>
//    {
//
//        private Calendar calendar;
//
//        public final void setCalendarInstance(Calendar c)
//        {
//            calendar = c;
//        }
//
//
//        @Override
//        protected Task<Date> createTask() {
//
//            return new Task<Date>() {
//
//                protected Date call()
//                {
//                    int secondsdelay = 14400;
//                    Date timeStarted = calendar.getTime();
//                    Date timeEnd = new Date(timeStarted.getTime() + 1000 * secondsdelay );//* 60 * 60);
//                    while( timeEnd.after(calendar.getTime()) )
//                    {
//                        try {
//                            Thread.sleep(500);
//                            calendar = Calendar.getInstance();
//                        } catch (InterruptedException e) {
//                            if (isCancelled()) {
//                                updateMessage("Cancelled");
//                                break;
//                            }
//                        }
//                    }
//                    //Close program here
//                    System.exit(0);
//                    return timeEnd;
//
//                }
//            };
//        }
//    }
////////////////////////////////////////////////////////////////////////////////
