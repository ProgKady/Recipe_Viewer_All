package kadysoft.kady;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
import javafx.scene.input.KeyEvent;
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
public class New_Entry_Controller implements Initializable {

  
   
    @FXML
    private JFXTextField code;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField department;

    @FXML
    private JFXTextField days1;

    @FXML
    private JFXTextField days111111111;

    @FXML
    private JFXTextField days11;

    @FXML
    private JFXTextField days111;

    @FXML
    private JFXTextField days1111;

    @FXML
    private JFXTextField days11111;

    @FXML
    private JFXTextField days111111;

    @FXML
    private JFXTextField days1111111;

    @FXML
    private JFXTextField days11111111;

    @FXML
    private JFXTextField days1111111111;

    @FXML
    private JFXTextField ref;

    @FXML
    private JFXButton deletee;
    
    public static String Filee,imoo1;
    
    public static File selectedFile;
    
    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;
    
    public static Workbook workbook;
    
    public static FileInputStream fis;
            
///////////////////////////////////////////////////////////////////////////////////
        
//    
//    
//Class.forName("org.sqlite.JDBC");
//String url = "jdbc:sqlite:"+vvaall;
//
//String query = "SELECT * FROM Recipe_Processes WHERE WashName LIKE ? AND Model LIKE ?";
//
//System.out.println("Processes");
//System.out.println();
//
//try (Connection conn = DriverManager.getConnection(url)) {
//    // First Query Execution
//    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
//        pstmt.setString(1, "%" + wassh + "%");
//        pstmt.setString(2, "%" + modo + "%");
//        ResultSet rs = pstmt.executeQuery();
//        boolean found = false;
//        while (rs.next()) {
//            found = true;
//            String proc = rs.getString("Processes");
//            proco=proc;
//            System.out.print(proc.replace(" - ", "\n"));
//        }
//        if (!found) {
//            //System.out.println("No orders found matching the criteria.");
//            Notifications noti = Notifications.create();
//            noti.title("Fatal Error!");
//            noti.text("No orders found matching the criteria. Ask KADINIO");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.seconds(4));
//            noti.showError();
//            Platform.runLater(() -> {
//            skippedorders.setText(Integer.toString(ski+1));
//            erra=erra+"\n"+"No orders found matching the criteria. Ask KADINIO";
//            });
//        }
//    } // rs and pstmt closed automatically
//
//   System.out.println();
//   System.out.println();
//   
//   
//    //Time Query
//    
//    
//    
//String query2 = "SELECT * FROM Timer WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//
//try (PreparedStatement pstmt2 = conn.prepareStatement(query2)) {
//    pstmt2.setString(1, "%" + wassh + "%");
//    pstmt2.setString(2, "%" + modo + "%");
//    pstmt2.setString(3, "%1%");
//    ResultSet rs2 = pstmt2.executeQuery();
//
//    boolean found2 = false;
//    double totalTime = 0; // Use double instead of int
//
//    while (rs2.next()) {
//        found2 = true;
//        String proc2 = rs2.getString("Time_In_Min_Updated");
//
//        if (proc2.equals("Hasnot_Updated_Yet")) {
//            proc2 = rs2.getString("Time_In_Min");
//        }
//
//        totalTime += Double.parseDouble(proc2); // FIXED: Use double instead of int
//        timo = String.valueOf(totalTime); // Set final time value
//        //System.out.println(totalTime+"  jjjjjjjjjjjjjjjjjjj");
//    }
//
//    
//
//    if (found2==false) {
//       
//    // Check if Shot 2 exists and add its time
//    String queryShot2 = "SELECT Time_In_Min_Updated, Time_In_Min FROM Timer_Three_Shots WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//    try (PreparedStatement pstmtShot2 = conn.prepareStatement(queryShot2)) {
//        pstmtShot2.setString(1, "%" + wassh + "%");
//        pstmtShot2.setString(2, "%" + modo + "%");
//        pstmtShot2.setString(3, "%1%");
//        ResultSet rsShot2 = pstmtShot2.executeQuery();
//
//        while (rsShot2.next()) {
//            String procShot2 = rsShot2.getString("Time_In_Min_Updated");
//            if (procShot2.equals("Hasnot_Updated_Yet")) {
//                procShot2 = rsShot2.getString("Time_In_Min");
//            }
//            totalTime += Double.parseDouble(procShot2); // FIXED
//        }
//    }
//    
//    
//    // Check if Shot 2 exists and add its time
//    String queryShot22 = "SELECT Time_In_Min_Updated, Time_In_Min FROM Timer_Three_Shots WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//    try (PreparedStatement pstmtShot2 = conn.prepareStatement(queryShot22)) {
//        pstmtShot2.setString(1, "%" + wassh + "%");
//        pstmtShot2.setString(2, "%" + modo + "%");
//        pstmtShot2.setString(3, "%2%");
//        ResultSet rsShot2 = pstmtShot2.executeQuery();
//
//        while (rsShot2.next()) {
//            String procShot2 = rsShot2.getString("Time_In_Min_Updated");
//            if (procShot2.equals("Hasnot_Updated_Yet")) {
//                procShot2 = rsShot2.getString("Time_In_Min");
//            }
//            totalTime += Double.parseDouble(procShot2); // FIXED
//            timo = String.valueOf(totalTime); // Set final time value
//        }
//    }
//    
//        
//    }
//    
////     else {
////                // If not found in either table, show error notification
////                Notifications noti = Notifications.create();
////                noti.title("Fatal Error!");
////                noti.text("No time for that order found. Ask KADINIO");
////                noti.position(Pos.CENTER);
////                noti.hideAfter(Duration.seconds(4));
////                noti.showError();
////            }
//        
//    
//}} catch (SQLException e) {
//    System.out.println(e.getMessage());
//    Platform.runLater(() -> {
//    skippedorders.setText(Integer.toString(ski+1));
//    erra=erra+"\n"+"No time for that order found. Ask KADINIO";
//    });
//}

    
    @FXML
    void coodeactionn(KeyEvent event) {
        String workerCode = code.getText().trim();
        if (workerCode.isEmpty()) {
            name.clear();
            department.clear();
            return;
        }

        new Thread(() -> {
            try {
                searchExcel(workerCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
 
    
    
     @FXML
    void deleteeaction(ActionEvent event) {
        
     
        
        
//      if (code.getText().isEmpty()||name.getText().isEmpty()||days.getText().isEmpty()||department.getText().isEmpty()) {
//            
//      Notifications noti = Notifications.create();
//      noti.title("Fatal Error!");
//      noti.text("Search user first");
//      noti.position(Pos.CENTER);
//      noti.showError();
//            
//        }
//        
//        else {
//            
//                
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//               alert.setTitle("Delete User");
//               alert.setContentText("Are you sure, you wanna delete this user?");
//               alert.setResizable(false);
//               DialogPane dialogPaneef = alert.getDialogPane();
//               dialogPaneef.getStylesheets().add(
//             getClass().getResource("cupertino-dark.css").toExternalForm());
//               ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Delete");
//               ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Cancel");
//               Optional<ButtonType> result = alert.showAndWait();
//               ButtonType button = result.orElse(ButtonType.CANCEL);
//               if (button == ButtonType.OK) {
//    
//                    
//          try {
//      String sql = "delete from workers where code=? and name=? and department=? ";
//      this.pst = this.conn.prepareStatement(sql);
//      this.pst.setString(1, code.getText());
//      this.pst.setString(2, name.getText());
//      this.pst.setString(3, department.getText());
//      this.pst.execute();
//      
//      Notifications noti = Notifications.create();
//      noti.title("User Deleted!");
//      noti.text("User Successfully Deleted");
//      noti.position(Pos.CENTER);
//      noti.showInformation();
//      
//      refresh.fire();
//      
//            }catch(Exception e){ 
//            }
//            finally {
//            try{
//                rs.close();
//                pst.close(); 
//            }catch(Exception e){
//            
//            }}
//        
//    
//               }
//
//               else {
//    
//                 
//    
//               }
//        
//        
//        
//            
//            
//        }
//        
    
        
     
        
    }
   
    
    
    @FXML
    void searchaction(ActionEvent event) {

//            
//        try {
//      String sql = "select * from Stock where Code=?";
//      this.pst = this.conn.prepareStatement(sql);
//      this.pst.setString(1, this.inputcode.getText());
//      this.rs = this.pst.executeQuery();
//      String add2 = this.rs.getString("Material_Name");
//      this.inputmaterialname.setText(add2);
//      String add3 = this.rs.getString("Stock");
//      this.inputstock.setText(add3);
//      
//      ////////////////////What We Added///////////////
//    
//      String add4 = this.rs.getString("Total_Price");
//      this.tp.setText(add4);
//    
//      ////////////////////////////////////////////////
//    
//    
//      
//    }
//        
//        catch (Exception exception) {
//            
//            inputmaterialname.clear();
//            inputstock.clear();
//            tp.clear();
//    } 
//        finally {
//      try {
//        this.rs.close();
//        this.pst.close();
//      
//      } catch (Exception exception) {}
//    } 
//        
//        
//        ////////////////////////////////////////////////////////////////////
//       
//        
//        /////////////////////////////////////////////////////////////////////
//        
//        
//    if(this.inputcode.getText().equals("")||inputcode.getText().equals(" ")) {
//      
//      this.inputmaterialname.clear();
//      this.inputstock.clear();
//      this.inputprice.clear();
//      this.inputsupplier.clear();
//      this.inputunit.clear();
//      
//      
//       tp.clear();
//      
//    } else {
//      
//    } 
//    
//    
//    
//        
//        ///////////////////////////////////////////////////////////////////////////////////
//           try {
//     
//      
//      String sql = "select * from Indexes where Code=?";
//      this.pst = this.conn.prepareStatement(sql);
//      this.pst.setString(1, this.inputcode.getText());
//      this.rs = this.pst.executeQuery();
//      String add4 = this.rs.getString("Unit_Price");
//      this.inputprice.setText(add4);
//      
//      String add44 = this.rs.getString("Supplier");
//      this.inputsupplier.setText(add44);
//      
//      String add444 = this.rs.getString("Unit");
//      this.inputunit.setText(add444);
//    
//      
//    }
//        
//        catch (Exception exception) {
//            
//            inputprice.clear();
//            inputsupplier.clear();
//            inputunit.clear();
//            
//            
//    } 
//        finally {
//      try {
//     
//        this.rs.close();
//        this.pst.close();
//      } catch (Exception exception) {}
//    } 
//        
//           KeyCode keycode = event.getCode();
//           if (keycode == KeyCode.ENTER)  {
//    //  statusbox.show();
//    }
//           
        
        ///////////////////////////////////////////////////////////////////////////////////
        
//        try {
//      String sql = "select * from workers where Code=?";
//      this.pst = this.conn.prepareStatement(sql);
//      this.pst.setString(1, this.code.getText());
//      this.rs = this.pst.executeQuery();
//      
//      String add2 = this.rs.getString("name");
//      this.name.setText(add2);
//      String add3 = this.rs.getString("department");
//      this.department.setText(add3);
//      String add4 = this.rs.getString("start_date");
//      this.date.getEditor().setText(add4);
//      String add5 = this.rs.getString("days");
//      this.days.setText(add5);
//      String add6 = this.rs.getString("end_date");
//      this.enddate.setText(add6);
//    
//      ////////////////////////////////////////////////
//    
//    
//      
//    }
//        
//        catch (Exception exception) {
//            
//          name.clear();
//          department.clear();
//          date.getEditor().clear();
//          days.clear();
//          enddate.clear();
//          
//    } 
//        finally {
//      try {
//        this.rs.close();
//        this.pst.close();
//      
//      } catch (Exception exception) {}
//    } 
//        
//        
//        ////////////////////////////////////////////////////////////////////
//       
//        
//        /////////////////////////////////////////////////////////////////////
//        
//        
//    if(this.code.getText().equals("")||code.getText().equals(" ")) {
//      
//          name.clear();
//          department.clear();
//          date.getEditor().clear();
//          days.clear();
//          enddate.clear();
//          
//      
//    } else {
//      
//    } 
//    
    
        
        
    }
    
    
    
    
    
    
     @FXML
    void addaction(ActionEvent event) {
        
        
//        if (code.getText().isEmpty()||name.getText().isEmpty()||department.getText().isEmpty())  {
//            
//              Notifications noti = Notifications.create();
//              noti.title("Unsuccessful");
//              noti.text("Unsuccessful Addtion.\nSome fields are empty.");
//              noti.hideAfter(Duration.seconds(5));
//              noti.position(Pos.CENTER);
//              noti.showError();
//            
//        }
//        
//        else {
//            
//        
//
//        
//       
//                    try {
//                            
//          String reg = "insert into workers (code, name, department, start_date, days, end_date) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,code.getText());
//          pst.setString(2,name.getText());
//          pst.setString(3,department.getText());
//          pst.setString(4,date.getValue().toString());
//          pst.setString(5,days.getText());
//          pst.setString(6,enddate.getText());
//          pst.execute();
//                            
//                            
//          refresh.fire();
//          code.clear();
//          name.clear();
//          department.clear();
//          date.getEditor().clear();
//          days.clear();
//          enddate.clear();
//          
//          
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                    
//                    
//        }
        
        
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
        selectedFile=new File (ewrew);
        
         
        try {
            org.apache.poi.util.IOUtils.setByteArrayMaxOverride(200_000_000);
            fis = new FileInputStream(selectedFile);
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
//    
//
//    private void searchExcel(String workerCode) throws IOException {
////        org.apache.poi.util.IOUtils.setByteArrayMaxOverride(200_000_000);
////        FileInputStream fis = new FileInputStream(ref.getText());
////        Workbook workbook = new XSSFWorkbook(fis);
//
//  try {
//            org.apache.poi.util.IOUtils.setByteArrayMaxOverride(200_000_000);
//            fis = new FileInputStream(selectedFile);
//            workbook = new XSSFWorkbook(fis);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//       boolean found = false;
//
//    Sheet sheet = workbook.getSheetAt(0); // ✅ Only search in the first sheet
//
//    int lastRow = sheet.getLastRowNum();
//    for (int r = 0; r <= lastRow; r++) {
//        Row row = sheet.getRow(r);
//        if (row == null) continue;
//
//        Cell codeCell = row.getCell(4); // Column E
//        String code = getCellValue(codeCell);
//
//        if (code.equalsIgnoreCase(workerCode)) {
//            String nameo = getCellValue(row.getCell(5));      // Column F
//            String departmento = getCellValue(row.getCell(13)); // Column N
//
//            if ("G".equalsIgnoreCase(departmento)) {
//                departmento = "1";
//            }
//
//            final String finalName = nameo;
//            final String finalDepartment = departmento;
//
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    name.setText(finalName);
//                    department.setText(finalDepartment);
//                }
//            });
//
//            found = true;
//            break; // ✅ STOP IMMEDIATELY when found
//        }
//    }
//
//    if (!found) {
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                name.setText("Not Found");
//                department.clear();
//            }
//        });
//    }
//
//    workbook.close();
//    fis.close();
//}
//    
   
    
//    
//    private String getCellValue(Cell cell) {
//        if (cell == null) return "";
//
//        if (cell.getCellType() == CellType.STRING) {
//            return cell.getStringCellValue().trim();
//        } else if (cell.getCellType() == CellType.NUMERIC) {
//            return String.valueOf((long) cell.getNumericCellValue());
//        } else if (cell.getCellType() == CellType.BOOLEAN) {
//            return String.valueOf(cell.getBooleanCellValue());
//        } else if (cell.getCellType() == CellType.FORMULA) {
//            try {
//                return cell.getStringCellValue().trim();
//            } catch (Exception e) {
//                return String.valueOf((long) cell.getNumericCellValue());
//            }
//        }
//
//        return "";
//    }
    
    
    
    
    
    private void searchExcel(String workerCode) throws IOException {
    List<String[]> csvRows = new ArrayList<>();

    try (FileInputStream fis = new FileInputStream(selectedFile);
         Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();

        for (int r = 0; r <= lastRow; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            int lastCell = row.getLastCellNum();
            String[] csvRow = new String[lastCell];

            for (int c = 0; c < lastCell; c++) {
                Cell cell = row.getCell(c);
                csvRow[c] = getCellValue(cell);
            }

            csvRows.add(csvRow);
        }

    } catch (IOException ex) {
        Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
        throw ex;
    }

    // ✅ Search in-memory CSV-like list
    boolean found = false;
    for (String[] row : csvRows) {
        if (row.length <= 4) continue;

        String code = row[4]; // Column E
        if (code.equalsIgnoreCase(workerCode)) {
            String nameo = (row.length > 5) ? row[5] : "";
            String departmento = (row.length > 13) ? row[13] : "";

            if ("G".equalsIgnoreCase(departmento)) {
                departmento = "1";
            }

            final String finalName = nameo;
            final String finalDepartment = departmento;

            Platform.runLater(() -> {
                name.setText(finalName);
                department.setText(finalDepartment);
            });

            found = true;
            break;
        }
    }

    if (!found) {
        Platform.runLater(() -> {
            name.setText("Not Found");
            department.clear();
        });
    }
}

    
    
    
    private String getCellValue(Cell cell) {
    if (cell == null) return "";

    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue().trim();
        case NUMERIC:
            return String.valueOf((long) cell.getNumericCellValue());
        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());
        case FORMULA:
            try {
                return cell.getStringCellValue().trim();
            } catch (Exception e) {
                return String.valueOf((long) cell.getNumericCellValue());
            }
        default:
            return "";
    }
}

    

    
    
    
//    
//    
//    
//    
//   private void searchExcelFile(File file, String workerCode) {
//    try (FileInputStream fis = new FileInputStream(file);
//         Workbook workbook = new XSSFWorkbook(fis)) {
//
//        boolean found = false;
//
//        outer:
//        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//            Sheet sheet = workbook.getSheetAt(i);
//            System.out.println("Searching in sheet: " + sheet.getSheetName());
//
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    String cellValue = getCellValueAsString(cell);
//                    System.out.println("Cell: " + cellValue);
//
//                    if (cellValue != null && cellValue.trim().equalsIgnoreCase(workerCode.trim())) {
//                        found = true;
//                        String namee = getCellValueAsString(row.getCell(2));
//                        String departmente = getCellValueAsString(row.getCell(5));
//
//                        String finalName = namee != null ? namee : "";
//                        String finalDep = (departmente != null && departmente.equals("G")) ? "1" : departmente;
//
//                        Platform.runLater(() -> {
//                            name.setText(finalName);
//                            department.setText(finalDep != null ? finalDep : "");
//                        });
//
//                        break outer;
//                    }
//                }
//            }
//        }
//
//        if (!found) {
//            Platform.runLater(() -> {
//                name.setText("Not Found");
//                department.clear();
//            });
//        }
//
//    } catch (IOException e) {
//        e.printStackTrace();
//        Platform.runLater(() -> ref.setText("❌ Error reading Excel: " + e.getMessage()));
//    }
//}
//
//
//    
//    
//    
//   private String getCellValueAsString(Cell cell) {
//    if (cell == null) return "";
//    switch (cell.getCellType()) {
//        case STRING: return cell.getStringCellValue();
//        case NUMERIC:
//            if (DateUtil.isCellDateFormatted(cell)) {
//                return cell.getDateCellValue().toString();
//            } else {
//                return String.valueOf((long) cell.getNumericCellValue());
//            }
//        case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
//        case FORMULA:
//            try {
//                return cell.getStringCellValue();
//            } catch (Exception e) {
//                return String.valueOf(cell.getNumericCellValue());
//            }
//        default: return "";
//    }
//}
//
//    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        try {
          BufferedReader buf = new BufferedReader(new FileReader("HR_Data.kady"));
          imoo1=buf.readLine();
          ref.setText(imoo1);
          buf.close();   
          } catch (IOException ex) {}
        
        
        Filee=ref.getText();
        selectedFile=new File (Filee);
        conn = db_w.java_db();
        
        
        
        try {
            org.apache.poi.util.IOUtils.setByteArrayMaxOverride(200_000_000);
            fis = new FileInputStream(selectedFile);
            workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(New_Entry_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
           
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
    
      
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value1 = timeString;
    date.getEditor().setText(value1);
 
        
    }    
    
}
