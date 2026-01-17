package kadysoft.kady;



import java.io.BufferedReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class FileSearchApp extends Application {

    private TextArea textArea;
    private TextField searchField;
    
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
    
    

    @Override
    public void start(Stage primaryStage) {
        
        try {
            String fontPath = getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Fonts"); // غيّر المسار حسب مكان الخط عندك
            Font cairoSemiBold = Font.loadFont(new FileInputStream(fontPath), 18);
        } catch (FileNotFoundException ex) {
          
        }
        
        searchField = new TextField();
        searchField.setStyle(
                "-fx-font-family: 'Cairo SemiBold';" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: #333333;"
            );
        searchField.setPromptText("Enter word to search...");
        Label dropLabel = new Label("Drop files below:");
        dropLabel.setStyle(
                "-fx-font-family: 'Cairo SemiBold';" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: #333333;"
            );
        textArea = new TextArea();
        textArea.setStyle(
                "-fx-font-family: 'Cairo SemiBold';" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 16px;" +
                "-fx-text-fill: #333333;"
            );
        textArea.setPromptText("Results will appear here...");
        textArea.setEditable(false);
        VBox root = new VBox(10, searchField, dropLabel);
        root.setStyle("-fx-padding: 15;");
        root.setFillWidth(true);
        
        BorderPane bp=new BorderPane();
        bp.setStyle("-fx-padding: 15;");
        bp.setTop(root);
        bp.setCenter(textArea);
        
        Scene scene = new Scene(bp, 1700, 900);
        
        // Apply Cupertino Light theme
        scene.getStylesheets().add(getClass().getResource(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes")).toExternalForm());
        // Drag over
        scene.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != textArea && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            }
            event.consume();
        });

        
        
        
        
        // Drop
        scene.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                List<File> droppedFiles = db.getFiles();//////////////////////
                String word = searchField.getText().trim();///////////////////
                if (!word.isEmpty()) {
                    try {
                        handleFiles(droppedFiles, word);/////////////////
                    } catch (IOException ex) {
                        Logger.getLogger(FileSearchApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    textArea.setText("Please enter a word to search first!");
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
        primaryStage.setTitle("Recipe Search");
        //primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
private void handleFiles(List<File> droppedFiles, String searchWord) throws IOException {
    StringBuilder result = new StringBuilder();

    List<String> fileNames = droppedFiles.stream()
            .map(File::getName)
            .collect(Collectors.toList());

    result.append("Total files dropped: ").append(droppedFiles.size()).append("\n");
    result.append("Files: ").append(String.join(", ", fileNames)).append("\n\n");

    int foundCount = 0;
    int notFoundCount = 0;

    for (File file : droppedFiles) {
        // Always read UTF-8
        String contentt = new String(
            Files.readAllBytes(file.toPath()),
            StandardCharsets.UTF_8
        );
        // Decrypt
        String content = contentt
                .replace("ﬦ","A").replace("ﬧ","B").replace("ﬨ","C")
                .replace("﬩","D").replace("שׁ","E").replace("שׂ","F")
                .replace("שּׁ","G").replace("שּׂ","H").replace("אַ","I")
                .replace("אָ","J").replace("אּ","K").replace("בּ","L")
                .replace("גּ","M").replace("דּ","N").replace("הּ","O")
                .replace("וּ","P").replace("זּ","Q").replace("טּ","R")
                .replace("יּ","S").replace("ךּ","T").replace("כּ","U")
                .replace("לּ","V").replace("מּ","W").replace("נּ","X")
                .replace("סּ","Y").replace("ףּ","Z").replace("פּ","0")
                .replace("צּ","1").replace("קּ","2").replace("רּ","3")
                .replace("שּ","4").replace("תּ","5").replace("וֹ","6")
                .replace("בֿ","7").replace("כֿ","8").replace("פֿ","9")
                .replace("&nbsp;", "")
                .replace("\u00A0", ""); // non-breaking space
        // Case-insensitive search
        if (content.toLowerCase().contains(searchWord.toLowerCase())) {
            result.append("✅ موجودة في: ").append(file.getName()).append("\n");
            foundCount++;
        } else {
            result.append("❌ مش موجودة في: ").append(file.getName()).append("\n");
            notFoundCount++;
        }
    }

    result.append("\nSummary:\n")
            .append("✅ موجودة في ").append(foundCount).append(" files\n")
            .append("❌ مش موجودة في ").append(notFoundCount).append(" files\n");

    textArea.setText(result.toString());
}


    public static void main(String[] args) {
        launch(args);
    }
}








//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FileSearchApp extends Application {
//
//    private TextArea filesInputArea; // هنا تكتب مسارات الملفات
//    private TextArea resultArea;     // هنا تظهر النتائج
//    private TextField searchField;
//
//    @Override
//    public void start(Stage primaryStage) throws ClassNotFoundException {
//        searchField = new TextField();
//        searchField.setPromptText("Enter word to search...");
//
//        filesInputArea = new TextArea();
//        filesInputArea.setPromptText("Enter file paths here, one per line...");
//
//        // عند تشغيل البرنامج → يجيب الداتا من DB ويحطها في TextArea
//        loadFilePathsFromDB();
//
//        Button searchButton = new Button("Search");
//
//        resultArea = new TextArea();
//        resultArea.setPromptText("Results will appear here...");
//        resultArea.setEditable(false);
//
//        searchButton.setOnAction(e -> {
//            String word = searchField.getText().trim();
//            if (!word.isEmpty()) {
//                List<File> files = parseFilesFromInput();
//                handleFiles(files, word);
//            } else {
//                resultArea.setText("Please enter a word to search first!");
//            }
//        });
//
//        VBox root = new VBox(10, new Label("Search Word:"), searchField,
//                new Label("File Paths:"), filesInputArea,
//                searchButton, resultArea);
//        root.setStyle("-fx-padding: 15;");
//
//        Scene scene = new Scene(root, 700, 500);
//        scene.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
//
//        primaryStage.setTitle("File Search (Cupertino Light)");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void loadFilePathsFromDB() throws ClassNotFoundException {
//        StringBuilder paths = new StringBuilder();
//
//        Class.forName("org.sqlite.JDBC");
//        String url = "jdbc:sqlite:X:\\Recipe_System\\Database\\Recipe_System_DB.db"; // غير ده لمسار قاعدة بياناتك
//        String sql = "SELECT Path FROM Creation"; // غير اسم الجدول والعمود حسب DB
//
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                String path = rs.getString("Path");
//                paths.append(path).append("\n");
//            }
//
//            filesInputArea.setText(paths.toString());
//
//        } catch (SQLException e) {
//            filesInputArea.setText("⚠ Error loading file paths from DB!\n" + e.getMessage());
//        }
//    }
//
//    private List<File> parseFilesFromInput() {
//        List<File> files = new ArrayList<>();
//        String[] lines = filesInputArea.getText().split("\\r?\\n");
//        for (String line : lines) {
//            if (!line.trim().isEmpty()) {
//                File f = new File(line.trim());
//                if (f.exists() && f.isFile()) {
//                    files.add(f);
//                }
//            }
//        }
//        return files;
//    }
//
//    private void handleFiles(List<File> files, String searchWord) {
//        StringBuilder result = new StringBuilder();
//
//        result.append("Total files entered: ").append(files.size()).append("\n\n");
//
//        int foundCount = 0;
//        int notFoundCount = 0;
//
//        for (File file : files) {
//            try {
//                String content = new String(Files.readAllBytes(file.toPath()));
//
//                // case-insensitive search
//                if (content.toLowerCase().contains(searchWord.toLowerCase())) {
//                    result.append("✅ Found in: ").append(file.getName()).append("\n");
//                    foundCount++;
//                } else {
//                    result.append("❌ Not found in: ").append(file.getName()).append("\n");
//                    notFoundCount++;
//                }
//            } catch (IOException e) {
//                result.append("⚠ Error reading: ").append(file.getName()).append("\n");
//            }
//        }
//
//        result.append("\nSummary:\n")
//                .append("✅ Found in ").append(foundCount).append(" files\n")
//                .append("❌ Not found in ").append(notFoundCount).append(" files\n");
//
//        resultArea.setText(result.toString());
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
