package kadysoft.kady;

import com.jfoenix.controls.JFXTextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.*;
import java.util.stream.Collectors;

public class FuzzyReplaceApp extends Application {

    private final LevenshteinDistance distanceCalculator = new LevenshteinDistance();
    JFXTextArea referenceArea;
    JFXTextArea dataArea;
    public static String useb,drib;

    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        // Reference TextArea
        referenceArea = new JFXTextArea();
        //referenceArea.setEditable(false);
        referenceArea.setPromptText("Enter correct reference data (one per line)");
        referenceArea.getStyleClass().add("textarea");

        // Data TextArea
        dataArea = new JFXTextArea();
        dataArea.setPromptText("Enter data to correct (one per line)");
        dataArea.getStyleClass().add("textarea");

        // Scrollable containers
        ScrollPane refScroll = new ScrollPane(referenceArea);
        ScrollPane dataScroll = new ScrollPane(dataArea);
        refScroll.setFitToWidth(true);
        dataScroll.setFitToWidth(true);

        // Fuzzy Match Button
        Button matchButton = new Button("✨ Match and Replace");
        matchButton.getStyleClass().add("button");

        matchButton.setOnAction(e -> {
            Map<String, String> referenceMap = Arrays.stream(referenceArea.getText().split("\n"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toMap(
                            this::normalize,
                            s -> s,
                            (v1, v2) -> v1
                    ));

            List<String> referenceList = new ArrayList<>(referenceMap.keySet());

            List<String> corrected = Arrays.stream(dataArea.getText().split("\n"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(this::normalize)
                    .map(input -> {
                        String bestMatch = findClosest(input, referenceList);
                        return referenceMap.getOrDefault(bestMatch, input);
                    })
                    .collect(Collectors.toList());

            dataArea.setText(String.join("\n", corrected));
        });

        // Layout
        VBox layout = new VBox(15,
                new Label("🟢 Reference List (Correct Data)"),
                refScroll,
                new Label("🔴 Raw Data (To Correct)"),
                dataScroll,
                matchButton
        );
        layout.setPadding(new Insets(20));
        layout.getStyleClass().add("container");

        Scene scene = new Scene(layout, 700, 600);

        ////////////// Theme Loader //////////////
        BufferedReader bis = new BufferedReader(new FileReader("Themes.kady"));
        String themooo = bis.readLine();
        bis.close();
        URL cssUrl = getClass().getResource(themooo);
        if (cssUrl != null) {
            String cssPath = cssUrl.toExternalForm();
            scene.getStylesheets().add(cssPath);
            layout.getStylesheets().add(cssPath);
        } else {
            System.err.println("ERROR: theme not found!");
        }
        //////////////////////////////////////////

        primaryStage.setTitle("Fuzzy Reference Corrector");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

        // 🔥 Call getProcessForOrder immediately when app starts
        getProcessForOrder("PO123", "SAP001"); 
    }

    private String normalize(String input) {
        return input.toUpperCase()
                .replaceAll("[^A-Z0-9 ]", "")
                .replaceAll("\\s+", "_");
    }

    private String findClosest(String input, List<String> referenceList) {
        return referenceList.stream()
                .min(Comparator.comparingInt(ref -> distanceCalculator.apply(input, ref)))
                .orElse(input);
    }

    private String getProcessForOrder(String po, String sapCode) throws ClassNotFoundException {
        String result = "";
        referenceArea.clear();

        File settings = new File("DataBasesInfo.kady");
        String recipeDBPath = getRecipeDBPath(settings);
        Class.forName("org.sqlite.JDBC");
        String db2Path = "jdbc:sqlite:" + recipeDBPath;
        String query = "SELECT * FROM Creation";
        try (Connection conn2 = DriverManager.getConnection(db2Path);
             PreparedStatement pst2 = conn2.prepareStatement(query);
             ResultSet rs2 = pst2.executeQuery()) {

            while (rs2.next()) {
                String name = rs2.getString("Name");
                referenceArea.appendText(name + "\n");
            }
            result = "Loaded process list from DB.";

        } catch (SQLException e) {
            e.printStackTrace();
            result = "Error while loading processes: " + e.getMessage();
        }

        return result;
    }

    public String getRecipeDBPath(File settingsFile) {
        
      useb=System.getProperty("user.name");
      try {
          BufferedReader buf = new BufferedReader(new FileReader("PCs\\"+useb+".kady"));
          drib=buf.readLine();
          buf.close();   
          } catch (IOException ex) {       
      //Alert
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Fatal Error");
      alert.setContentText("Fatal Error while reading user file.\nWe can't find the specified file.");
      alert.setResizable(false);
      alert.showAndWait();
          }
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(settingsFile))) {
           
           String db_path=reader.readLine().replace("X:",drib+":");
           return db_path; 
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
