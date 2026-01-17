
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.table.TableFilter;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class ReportsController implements Initializable {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
   

    @FXML
    private TableView<?> datatable;

    @FXML
    private JFXButton costbtn;

    @FXML
    private JFXButton processesbtn;

    @FXML
    private JFXButton typesbtn;
    
    @FXML
    private JFXButton timebtn;

    @FXML
    private JFXButton filterbtn2;
    
    @FXML
    private JFXButton delete;

    @FXML
    private JFXButton newstone;
    
    
    
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
    
    
    
    @FXML
    void costaction(ActionEvent event) {

        
        
        
Alert alerth = new Alert(Alert.AlertType.CONFIRMATION);
alerth.setTitle("Show Cost");
alerth.setHeaderText("Cost Result");
alerth.setContentText("Where do you wanna show? .......... Cost!");
ButtonType buttonTypeOneh = new ButtonType("DEVELOPMENT");
ButtonType buttonTypeCancelh = new ButtonType("PRODUCTION");
alerth.getButtonTypes().setAll(buttonTypeOneh, buttonTypeCancelh);
DialogPane dialogPaneih = alerth.getDialogPane();
dialogPaneih.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
Optional<ButtonType> resultsh = alerth.showAndWait();

if (resultsh.isPresent() && resultsh.get() == buttonTypeOneh) {
    
    //Development
    
       datatable.getColumns().clear();
             
    
    
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Development_Cost";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

                     
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
    
    
}


else {
    
    //Production
    datatable.getColumns().clear();
        
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Cost";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 


                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
          //  JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
    
    
}
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
        
    @FXML
    void newstoneaction(ActionEvent event) {

        
       datatable.getColumns().clear();   
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from GetterStone";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                   Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
              
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
         //   JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
        
        
        
        
    }

    
    
    
    
    @FXML
    void processesaction(ActionEvent event) {

        
       datatable.getColumns().clear();   
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Recipe_Processes";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                   Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

  
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
              
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
        
        
        
        
    }

    
    
    
    @FXML
    void timeaction(ActionEvent event) {
        
        
        
               
Alert alerth = new Alert(Alert.AlertType.CONFIRMATION);
alerth.setTitle("Show Time");
alerth.setHeaderText("Time Result");
alerth.setContentText("Where do you wanna show? .......... Time!");
ButtonType buttonTypeOneh = new ButtonType("DEVELOPMENT");
ButtonType buttonTypeCancelh = new ButtonType("PRODUCTION");
alerth.getButtonTypes().setAll(buttonTypeOneh, buttonTypeCancelh);
DialogPane dialogPaneih = alerth.getDialogPane();
dialogPaneih.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
Optional<ButtonType> resultsh = alerth.showAndWait();

if (resultsh.isPresent() && resultsh.get() == buttonTypeOneh) {
    
    //Development
    
                
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Recipes Time");
alert.setHeaderText("Recipe Time Viewer");
alert.setContentText("Choose one option to view recipes time: ");
ButtonType buttonTypeOne = new ButtonType("2 Shots");
ButtonType buttonTypeCancel = new ButtonType("3,4,5,6 Shots");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
    
    datatable.getColumns().clear();
          
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Development_Time_Two";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
         //   JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
    
}
if (results.isPresent() && results.get() == buttonTypeCancel) {
    
    datatable.getColumns().clear();
          
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Development_Time_Three";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
              
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
    
}
  
    
   
    
}


else {
    
    //Production
    
    
        
Alert alertr = new Alert(Alert.AlertType.CONFIRMATION);
alertr.setTitle("Recipes Time");
alertr.setHeaderText("Recipe Time Viewer");
alertr.setContentText("Choose one option to view recipes time: ");
ButtonType buttonTypeOner = new ButtonType("PRODUCTION");
ButtonType buttonTypeCancelr = new ButtonType("PILOT");
alertr.getButtonTypes().setAll(buttonTypeOner, buttonTypeCancelr);
DialogPane dialogPaneir = alertr.getDialogPane();
dialogPaneir.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
Optional<ButtonType> resultsr = alertr.showAndWait();
if (resultsr.isPresent() && resultsr.get() == buttonTypeOner) {
    
    //PRODUCTION
            
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Recipes Time");
alert.setHeaderText("Recipe Time Viewer");
alert.setContentText("Choose one option to view recipes time: ");
ButtonType buttonTypeOne = new ButtonType("2 Shots");
ButtonType buttonTypeCancel = new ButtonType("3 Shots");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
    
    datatable.getColumns().clear();
          
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Timer";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
          //  JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
    
}
if (results.isPresent() && results.get() == buttonTypeCancel) {
    
    datatable.getColumns().clear();
          
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Timer_Three_Shots";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
              
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
         //   JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
    
}
    
    
}
  


else {
    
    //PILOT
    
       datatable.getColumns().clear();   
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Timer_Pilot";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                   Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

    
    
}
        
    
}
        
        
        
    
        
        
        
    }

    
    
    
    
    
    
    @FXML
    void typesaction(ActionEvent event) {

       datatable.getColumns().clear(); 
          
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Recipe_Types";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                   Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
          //  JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);
        
          TableFilter filter = new TableFilter(datatable);

        
        
        
        
    }

    
    
    
    
     @FXML
    void deleteaction(ActionEvent event) throws FileNotFoundException, IOException {
        
        
           
        /////////////////////////////////////////////////////////////////////////
        
        Workbook workbook = new XSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("Kadysoft_Full_Report");

        Row row = spreadsheet.createRow(0);

        for (int j = 0; j < datatable.getColumns().size(); j++) {
            row.createCell(j).setCellValue(datatable.getColumns().get(j).getText());
        }

        for (int i = 0; i < datatable.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < datatable.getColumns().size(); j++) {
                if(datatable.getColumns().get(j).getCellData(i) != null) { 
                    row.createCell(j).setCellValue(datatable.getColumns().get(j).getCellData(i).toString()); 
                }
                else {
                    row.createCell(j).setCellValue("");
                }   
            }
        }

        FileChooser dialog = new FileChooser();
        dialog.setInitialDirectory(new File(System.getProperty("user.home")+"\\Desktop"));
        dialog.setInitialFileName("Kadysoft_Full_Report");
        dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
        File dialogResult = dialog.showSaveDialog(null);
        String filePath = dialogResult.getAbsolutePath().toString();
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();
        Desktop desk=Desktop.getDesktop();
        desk.open(new File (filePath));
        
        /////////////////////////////////////////////////////////////////////////
        
    }
    
    @FXML
    void updateation(ActionEvent event) {

        datatable.getColumns().clear();
        
        /////////////////////////////////////////////////////////
        
         ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
        
        
         try{
            
            String sql ="select * from Recipe_Types";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    Object cellValue = param.getValue().get(j); 
return new SimpleStringProperty(cellValue == null ? "NULL" : cellValue.toString()); 

 
                }
                
            });
            datatable.getColumns().addAll(col);
            
            
        }
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
               
String value = rs.getString(i); 
row.add(value == null ? "NULL" : value);
            }
            data.add(row);
            
        }
        
        datatable.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
          //  JOptionPane.showMessageDialog(null, e);
        }
        finally {
            
            try{
                
                rs.close();
                pst.close();

            }
            catch(Exception e){
                
            }
         } 
         
        // getauditbtn.setDisable(true);

        
        /////////////////////////////////////////////////////////
        
        
    }

    @FXML
    void filterbtn2action(ActionEvent event) {
////////////////////////////////////////////////////////////////////
        
datatable.getColumns().clear();
        
        
    }

    @FXML
    void filterbtnaction(ActionEvent event) {
 

    }

  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn=db.java_db();
        
        
        
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = timeString;
    

      try {
        String fontPath = getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Fonts"); // غيّر المسار حسب مكان الخط عندك
        javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
           
        }
    
        
    }    
    
}
