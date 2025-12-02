
package kadysoft.kady;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author gokhan.ozturk
 */
public class TestController implements Initializable {

    
   
    
    @FXML
    private Button click;

    @FXML
    void clickaction(ActionEvent event) throws SQLException, FileNotFoundException, IOException {

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String dbName = "Recipe_System_DB";
String excelFilePath = "D:\\KADY\\kady.xlsx";
String url = "jdbc:sqlite:" + "Z:\\Recipe_System\\Database\\" + dbName+ ".db";


        int batchSize = 20;
 
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator <Row> rowIterator = firstSheet.iterator();
 
            Connection connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO students (CODE, NAME, MANAGEMENT, SECTION, UNIT, HIRING_DATE) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);    
            
            /////////////////////////////////////////////////////////////////
            
            //ALTER TABLE employees ADD status VARCHAR;
            
            String sql1 = "ALTER TABLE students ADD CODE VARCHAR";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            
            String sql2 = "ALTER TABLE students ADD NAME VARCHAR";
            PreparedStatement statement2 = connection.prepareStatement(sql2); 
            
            String sql3 = "ALTER TABLE students ADD MANAGEMENT VARCHAR";
            PreparedStatement statement3 = connection.prepareStatement(sql3); 
            
            String sql4 = "ALTER TABLE students ADD SECTION VARCHAR";
            PreparedStatement statement4 = connection.prepareStatement(sql4); 
            
            String sql5 = "ALTER TABLE students ADD UNIT VARCHAR";
            PreparedStatement statement5 = connection.prepareStatement(sql5); 
            
            String sql6 = "ALTER TABLE students ADD HIRING_DATE VARCHAR";
            PreparedStatement statement6 = connection.prepareStatement(sql6); 
            
             ////////////////////////////////////////////////////////////////
            int count = 0;
             
            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0:
                        String name = nextCell.getStringCellValue();
                        statement.setString(1, name);
                        
                        break;
                    case 1:
                        Date enrollDate = nextCell.getDateCellValue();
                        statement.setTimestamp(2, new Timestamp(enrollDate.getTime()));
                        
                    case 2:
                        int progress = (int) nextCell.getNumericCellValue();
                        statement.setInt(3, progress);
                        break;
                        
                    default :
                        
                        String namee = nextCell.getStringCellValue();
                        statement.setString(1, namee);
                        
                         break;
                        
                        
                    }
 
                }
                
                statement.execute();
                 
                statement.addBatch();
                 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            // execute the remaining queries
            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 
    


        
        
        
        
        
      /*

        // Assign variables
Connection connection = null;
PreparedStatement statement = null;

String dbName = "Recipe_System_DB";
String excelFilePath = "D:\\KADY\\kady.xlsx";
String url = "jdbc:sqlite:" + "Z:\\Recipe_System\\Database\\" + dbName+ ".db";

// Create a connection to the database
connection = DriverManager.getConnection(url);
connection.setAutoCommit(false);

// Opening Worksheet
FileInputStream inputStream = new FileInputStream(excelFilePath);
Workbook workbook = new XSSFWorkbook(inputStream);
Sheet firstSheet = workbook.getSheetAt(0);  // first sheet

// Generate maximum number of column in sheet
int max=0;
Iterator<Row> rowIterator = firstSheet.iterator();
while (rowIterator.hasNext()) {
Row nextRow = rowIterator.next();
Iterator<Cell> cellIterator = nextRow.cellIterator();
int totalNoOfRows = firstSheet.getLastRowNum(); // To get the number of rows present in sheet
while (cellIterator.hasNext()) {
Cell nextCell = cellIterator.next();
int col1 = nextCell.getColumnIndex();
for (int row = 1; row <= totalNoOfRows; row++) {
if (col1 >= max)
max = col1;
}}}
// creating schema
ArrayList sch = new ArrayList();
ArrayList val = new ArrayList();
for (int first = 1; first <= max + 1; first++) {
sch.add("'" + first + "'");
val.add("?");
}
String schema = sch.toString().replace("[", "(").replace("]", ")").trim();
String values = val.toString().replace("[", "(").replace("]", ")").trim();

// execute queries using create statement
String table = "CREATE TABLE " + dbName + schema + ";";
Statement stmt = connection.createStatement();
stmt.executeUpdate(table);
String delete = "DELETE FROM " + dbName + ";";
//Statement stmt = connection.createStatement();
stmt.executeUpdate(delete);
// execute query using prepare statement
String insert = "INSERT INTO " + dbName + schema + "VALUES" + values + ";";
statement = connection.prepareStatement(insert);

// Read excel data
//Iterator<Row> rowIterator = firstSheet.iterator();
while (rowIterator.hasNext()) {
int cellCount = 0;
Row nextRow = rowIterator.next();
ArrayList<String> data = new ArrayList<String>();
data.clear();
Iterator<Cell> cellIterator = nextRow.cellIterator();
while (cellIterator.hasNext()) {
Cell nextCell = cellIterator.next();
int col = nextCell.getColumnIndex();
if (nextCell.getCellType() == CellType.STRING) {
data.add(cellCount, nextCell.getStringCellValue());
}
else if (nextCell.getCellType() == CellType.NUMERIC) {
data.add(cellCount, NumberToTextConverter.toText(nextCell.getNumericCellValue()));
}
statement.setString(col + 1, data.get(cellCount).toString());
cellCount += 1;
}

// Import data in batch using prepared statement methods
statement.addBatch();
statement.executeBatch();
statement.clearBatch();
}
// Closing workbook and database connection
workbook.close();
connection.commit();
connection.close();
        
   */     
 
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
    }    
    
}
