package kadysoft.kady;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelSearchApp extends Application {

    private TextField codeField = new TextField();
    private TextField nameField = new TextField();
    private TextField departmentField = new TextField();
    private Label statusLabel = new Label("⏳ Loading Excel...");

    private Map<String, String[]> workerMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        codeField.setPromptText("Enter worker code");
        nameField.setPromptText("Name");
        departmentField.setPromptText("Department");
        nameField.setEditable(false);
        departmentField.setEditable(false);

        codeField.setOnKeyReleased(event -> {
            String code = codeField.getText().trim();
            if (code.isEmpty()) {
                nameField.clear();
                departmentField.clear();
                return;
            }
            searchWorker(code);
        });

        VBox root = new VBox(10, codeField, nameField, departmentField, statusLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Worker Lookup");
        primaryStage.show();

        loadExcelDataInBackground();
    }

    private void loadExcelDataInBackground() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    org.apache.poi.util.IOUtils.setByteArrayMaxOverride(200_000_000);
                    FileInputStream fis = new FileInputStream(new File("Z:\\Important\\HR laundry 2025\\Absence\\Absent 2025..xlsx"));
                    Workbook workbook = new XSSFWorkbook(fis);
                    Sheet sheet = workbook.getSheetAt(0); // Only first sheet

                    for (int r = 0; r <= sheet.getLastRowNum(); r++) {
                        Row row = sheet.getRow(r);
                        if (row == null) continue;

                        String code = getCellValue(row.getCell(4)); // E
                        String name = getCellValue(row.getCell(5)); // F
                        String dept = getCellValue(row.getCell(13)); // N

                        if (code != null && !code.isEmpty()) {
                            workerMap.put(code.toLowerCase(), new String[]{name, dept});
                        }
                    }

                    workbook.close();
                    fis.close();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            statusLabel.setText("✅ Excel loaded. Ready.");
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            statusLabel.setText("❌ Failed to load Excel.");
                        }
                    });
                }
            }
        }).start();
    }

    private void searchWorker(String code) {
        if (workerMap.isEmpty()) {
            nameField.setText("Please wait...");
            departmentField.clear();
            return;
        }

        String[] result = workerMap.get(code.toLowerCase());
        if (result != null) {
            String name = result[0];
            String department = result[1];
            if ("G".equalsIgnoreCase(department)) department = "1";

            nameField.setText(name);
            departmentField.setText(department);
        } else {
            nameField.setText("Not Found");
            departmentField.clear();
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        CellType type = cell.getCellType();

        if (type == CellType.STRING) {
            return cell.getStringCellValue().trim();
        } else if (type == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        } else if (type == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (type == CellType.FORMULA) {
            try {
                return cell.getStringCellValue().trim();
            } catch (Exception e) {
                return String.valueOf((long) cell.getNumericCellValue());
            }
        }
        return "";
    }

    public static void main(String[] args) {
        launch(args);
    }
}
