package kadysoft.kady;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableFilter;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class Data_Query_Controller implements Initializable {

  
    @FXML
    private JFXTextField code;

    @FXML
    private JFXTextField name,ref;

    @FXML
    private JFXTextField department;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField days;

    @FXML
    private JFXTextField enddate;

    @FXML
    private TableView<ObservableList<String>> table;
    
    public static String Filee;
    
    File selectedFile;
    
    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;
    
    @FXML
    private JFXButton refresh;

    
    @FXML
    private JFXButton clearall,deletee;
    
    
    
     @FXML
    void deleteeaction(ActionEvent event) {
        
        
        if (code.getText().isEmpty()||name.getText().isEmpty()||days.getText().isEmpty()||department.getText().isEmpty()) {
            
      Notifications noti = Notifications.create();
      noti.title("Fatal Error!");
      noti.text("Search user first");
      noti.position(Pos.CENTER);
      noti.showError();
            
        }
        
        else {
            
                
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Delete User");
               alert.setContentText("Are you sure, you wanna delete this user?");
               alert.setResizable(false);
               DialogPane dialogPaneef = alert.getDialogPane();
               dialogPaneef.getStylesheets().add(
             getClass().getResource("cupertino-dark.css").toExternalForm());
               ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");
               ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancel");
               Optional<ButtonType> result = alert.showAndWait();
               ButtonType button = result.orElse(ButtonType.CANCEL);
               if (button == ButtonType.OK) {
    
                    
          try {
      String sql = "delete from workers where code=? and name=? and department=? ";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, code.getText());
      this.pst.setString(2, name.getText());
      this.pst.setString(3, department.getText());
      this.pst.execute();
      
      Notifications noti = Notifications.create();
      noti.title("User Deleted!");
      noti.text("User Successfully Deleted");
      noti.position(Pos.CENTER);
      noti.showInformation();
      
      refresh.fire();
      
            }catch(Exception e){ 
            }
            finally {
            try{
                rs.close();
                pst.close(); 
            }catch(Exception e){
            
            }}
        
    
               }

               else {
    
                 
    
               }
        
        
        
            
            
        }
        
    
        
     
        
    }
   
    
    @FXML
    void clearallaction(ActionEvent event) {

          name.clear();
          department.clear();
          date.getEditor().clear();
          days.clear();
          enddate.clear();
          table.getColumns().clear();
         
        
    }
    
    
    
    @FXML
    void searchaction(ActionEvent event) {

         
        
        ///////////////////////////////////////////////////////////////////////////////////
        
        try {
      String sql = "select * from workers where Code=?";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, this.code.getText());
      this.rs = this.pst.executeQuery();
      
      String add2 = this.rs.getString("name");
      this.name.setText(add2);
      String add3 = this.rs.getString("department");
      this.department.setText(add3);
      String add4 = this.rs.getString("start_date");
      this.date.getEditor().setText(add4);
      String add5 = this.rs.getString("days");
      this.days.setText(add5);
      String add6 = this.rs.getString("end_date");
      this.enddate.setText(add6);
    
      ////////////////////////////////////////////////
    
    
      
    }
        
        catch (Exception exception) {
            
          name.clear();
          department.clear();
          date.getEditor().clear();
          days.clear();
          enddate.clear();
          
    } 
        finally {
      try {
        this.rs.close();
        this.pst.close();
      
      } catch (Exception exception) {}
    } 
        
        
        ////////////////////////////////////////////////////////////////////
       
        
        /////////////////////////////////////////////////////////////////////
        
        
    if(this.code.getText().equals("")||code.getText().equals(" ")) {
      
          name.clear();
          department.clear();
          date.getEditor().clear();
          days.clear();
          enddate.clear();
          
      
    } else {
      
    } 
    
    
        
        
    }
    
    
     @FXML
    void exportaction(ActionEvent event) throws FileNotFoundException, IOException {

       
       Workbook workbook = new XSSFWorkbook();
        Sheet spreadsheet = workbook.createSheet("PE");
        Row row = spreadsheet.createRow(0);
        for (int j = 0; j < table.getColumns().size(); j++) {
            row.createCell(j).setCellValue(table.getColumns().get(j).getText());
        }
        for (int i = 0; i < table.getItems().size(); i++) {
            row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < table.getColumns().size(); j++) {
                if(table.getColumns().get(j).getCellData(i) != null) { 
                    row.createCell(j).setCellValue(table.getColumns().get(j).getCellData(i).toString()); 
                }
                else {
                    row.createCell(j).setCellValue("");
                }   
            }
        }
        
        FileChooser dialog = new FileChooser();
        dialog.setInitialDirectory(new File(System.getProperty("user.home")+"\\Desktop"));
        dialog.setInitialFileName("PE");
        dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
        File dialogResult = dialog.showSaveDialog(null);
        String filePath = dialogResult.getAbsolutePath().toString();
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();
        Desktop desk=Desktop.getDesktop();
        desk.open(new File (filePath));
        
    
        
    }
    
    
    
    
    
    
     @FXML
    void addaction(ActionEvent event) {
        
        
        if (code.getText().isEmpty()||name.getText().isEmpty()||department.getText().isEmpty())  {
            
              Notifications noti = Notifications.create();
              noti.title("Unsuccessful");
              noti.text("Unsuccessful Addtion.\nSome fields are empty.");
              noti.hideAfter(Duration.seconds(5));
              noti.position(Pos.CENTER);
              noti.showError();
            
        }
        
        else {
            
        

        
       
                    try {
                            
          String reg = "insert into workers (code, name, department, start_date, days, end_date) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,code.getText());
          pst.setString(2,name.getText());
          pst.setString(3,department.getText());
          pst.setString(4,date.getValue().toString());
          pst.setString(5,days.getText());
          pst.setString(6,enddate.getText());
          pst.execute();
                            
                            
          refresh.fire();
          code.clear();
          name.clear();
          department.clear();
          date.getEditor().clear();
          days.clear();
          enddate.clear();
          
          
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                    
                    
        }
        
        
    }
    
    
    
    
    @FXML
  void getallaction(ActionEvent event) {
      
          try {
            updateDaysBeforeLoadingTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data_Query_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
     table.getColumns().clear();
        
        ////////////////////////////////////////////////////////////////////
        ObservableList <ObservableList> data;
        data=FXCollections.observableArrayList();
        
        ////////////////////////////////////////////////////////////////////
       
         try{
            
            String sql ="select * from workers";
            pst=conn.prepareStatement(sql);  
            rs=pst.executeQuery();
            
        ///////////////////////////////////////////////////////////////
            
        for (int i=0;i<rs.getMetaData().getColumnCount();i++) {
            final int j=i;
            TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                     return new SimpleStringProperty(param.getValue().get(j).toString());
                     
                }
                
            });
            table.getColumns().addAll(col);
            
        }
        
        //While getting info
        
        while (rs.next()) {
            ObservableList<String> row=FXCollections.observableArrayList();
            for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
            
        }
        
        table.setItems((ObservableList)data);
          
       ////////////////////////////////////////////////////////////////
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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
        
          TableFilter filter = new TableFilter(table);
         
      
    
      
  }
    
    
    
    @FXML
    void dateaction(ActionEvent event) {

LocalDate selectedDate = date.getValue(); // Get selected date from DatePicker
LocalDate today = LocalDate.now();        // Get current date

// Calculate absolute number of days between today and selected date
long dayss = Math.abs(ChronoUnit.DAYS.between(today, selectedDate));

// Calculate a future date: 10 days after the selected date
LocalDate futureDate = selectedDate.plusDays(10);

// Update UI elements
days.setText(Long.toString(dayss));
enddate.setText(futureDate.toString());
        
        
    }
    
   
    
    @FXML
    void newaction(ActionEvent event) {

          if (selectedFile == null) {
                ref.setText("select Excel file.");
                return;
            }
            String styleNumber = code.getText().trim();
            if (styleNumber.isEmpty()) {
                name.setText("Please enter a style number.");
                department.setText("Please enter a style number.");
                return;
            }
            searchExcelFile(selectedFile, styleNumber);
        
    }

    
      @FXML
    void refaction(MouseEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Excel Files", "*.xlsx")
        );
        File gfd=fileChooser.showOpenDialog(null);
        String ewrew=gfd.getAbsolutePath().toString();
        ref.setText(ewrew);
        
    }
    
    
    private void searchExcelFile(File file, String workerCode) {
    StringBuilder results = new StringBuilder();

    try (FileInputStream fis = new FileInputStream(file);
         Workbook workbook = new XSSFWorkbook(fis)) {

        boolean found = false;

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            results.append("Searching in sheet: ").append(sheetName).append("\n");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = getCellValueAsString(cell);
                    if (cellValue != null && cellValue.equalsIgnoreCase(workerCode)) {
                        found = true;

                        String namee = getCellValueAsString(row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL)); // Column 3
                        String departmente = getCellValueAsString(row.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL)); // Column 4
                        name.setText(namee);
                        department.setText(departmente);
                        System.out.println(namee);
                        System.out.println(departmente);
                        break;
//                        results.append("✔ Found at Row ").append(row.getRowNum() + 1)
//                                .append(":\n   → Name: ").append(name != null ? name : "Empty")
//                                .append("\n   → Department: ").append(department != null ? department : "Empty")
//                                .append("\n");
                    }
                }
            }

            results.append("\n");
        }

        if (!found) {
            results.append("Worker code '").append(workerCode).append("' not found in the workbook.");
        }

    } catch (IOException e) {
        results.append("❌ Error reading the Excel file: ").append(e.getMessage());
    }

  
}
    
    private String getCellValueAsString(Cell cell) {
    if (cell == null) return null;

    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue().trim();
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue().toString();
            } else {
                return String.format("%.0f", cell.getNumericCellValue());
            }
        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());
        case FORMULA:
            switch (cell.getCachedFormulaResultType()) {
                case STRING:
                    return cell.getRichStringCellValue().getString();
                case NUMERIC:
                    return String.format("%.0f", cell.getNumericCellValue());
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                default:
                    return null;
            }
        default:
            return null;
    }
}
    
    
    
    
    public void updateDaysBeforeLoadingTable() throws ClassNotFoundException {
    Class.forName("org.sqlite.JDBC");    
    String url = "jdbc:sqlite:C:\\PE\\Workers.db";
    String sql = "UPDATE workers " +
                 "SET days = MIN(10, CAST(julianday('now') - julianday(start_date) AS INTEGER)) " +
                 "WHERE days < 10;";
    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement()) {
        int rowsUpdated = stmt.executeUpdate(sql);
        System.out.println("Updated days for " + rowsUpdated + " users.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
   

 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        Filee=ref.getText();
        selectedFile=new File (Filee);
        conn = db.java_db();
        
           
 date.setConverter(new StringConverter<LocalDate>() {
 String pattern = "yyyy-MM-dd";
 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

 {
     date.setPromptText(pattern.toLowerCase());
 }

 @Override public String toString(LocalDate date) {
     if (date != null) {
         return dateFormatter.format(date);
     } else {
         return "";
     }
 }

 @Override public LocalDate fromString(String string) {
     if (string != null && !string.isEmpty()) {
         return LocalDate.parse(string, dateFormatter);
     } else {
         return null;
     }
 }
});
    
        try {
            updateDaysBeforeLoadingTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Data_Query_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
 refresh.fire();
 //Refresh here
 
 
 
 
        
    }    
    
}
