package newpackage;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;

public class ModernFeatureTour extends Application {

    
    
    
    private int currentStep = 0;
    private List<TourStep> steps = new ArrayList<>();
    private Pane overlayPane;
    private static final String CONFIG_FILE = "config.txt";

    
    
    
    
    
    @Override
    public void start(Stage stage) {
        // Example UI
        Button btn1 = new Button("Dashboard");
        Button btn2 = new Button("Settings");
        Button btn3 = new Button("Reports");
        HBox hbox = new HBox(20, btn1, btn2, btn3);
        hbox.setAlignment(Pos.CENTER);
        StackPane root = new StackPane(hbox);
        Scene scene = new Scene(root, 800, 600);

        
        
        try {
  if (isFirstLaunch()) {
  // Define guided tour steps
  steps.add(new TourStep(btn1, "This is the Dashboard where you can monitor activities."));
  steps.add(new TourStep(btn1, "Settings let you customize your preferences."));
  steps.add(new TourStep(btn1, "Reports give you detailed insights."));
  saveFirstLaunchFlag();
  } else {
  //showMainApp(primaryStage);
  }  
    
}
catch (Exception ee) {}
        
        
        
        
        stage.setTitle("Modern Feature Tour Example");
        stage.setScene(scene);
        stage.show();
        // Start tour
        showStep(root, scene);
    }

    
    private boolean isFirstLaunch() {
        File file = new File(CONFIG_FILE);
        return !file.exists();
    }

    private void saveFirstLaunchFlag() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            writer.write("launched=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showStep(StackPane root, Scene scene) {
        // ✅ If finished, remove overlay
        if (currentStep >= steps.size()) {
            if (overlayPane != null) {
                fadeOutAndRemove(root, overlayPane);
                overlayPane = null;
            }
            return;
        }
        TourStep step = steps.get(currentStep);
        Node target = step.node;
        // Remove old overlay
        if (overlayPane != null) {
            root.getChildren().remove(overlayPane);
        }
        // New overlay
        overlayPane = new Pane();
        overlayPane.setPickOnBounds(false);
        // Dark background
        Rectangle background = new Rectangle(scene.getWidth(), scene.getHeight(), Color.rgb(0, 0, 0, 0.6));
        // Highlight rectangle
        Rectangle highlight = new Rectangle();
        highlight.setArcWidth(20);
        highlight.setArcHeight(20);
        highlight.setFill(Color.TRANSPARENT);
        highlight.setStroke(Color.web("#03A9F4"));
        highlight.setStrokeWidth(3);
        highlight.setEffect(new DropShadow(20, Color.web("#03A9F4")));
        // Info card
        Label info = new Label(step.message);
        info.setWrapText(true);
        info.setMaxWidth(300);
        info.setStyle(
                "-fx-background-color: white; " +
                "-fx-padding: 15; " +
                "-fx-font-size: 14px; " +
                "-fx-background-radius: 12; " +
                "-fx-border-radius: 12; " +
                "-fx-border-color: #E0E0E0;" +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 8, 0, 0, 2);"
        );
        Button nextBtn = new Button(currentStep == steps.size() - 1 ? "انهاء" : "التالي →");
        nextBtn.setStyle("-fx-background-color: #03A9F4; -fx-text-fill: white; -fx-background-radius: 20; -fx-padding: 6 18;");
        nextBtn.setOnAction(e -> {
            currentStep++;
            showStep(root, scene);
        });
        Button skipBtn = new Button("تخطي");
        skipBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #FFFFFF; -fx-underline: true;");
        skipBtn.setOnAction(e -> {
            fadeOutAndRemove(root, overlayPane);
            overlayPane = null;
        });
        VBox card = new VBox(10, info, nextBtn, skipBtn);
        card.setAlignment(Pos.CENTER);
        overlayPane.getChildren().addAll(background, highlight, card);
        root.getChildren().add(overlayPane);
        // Position updater
        Runnable updateHighlight = () -> {
            Bounds bounds = target.localToScene(target.getBoundsInLocal());
            highlight.setX(bounds.getMinX() - 10);
            highlight.setY(bounds.getMinY() - 10);
            highlight.setWidth(bounds.getWidth() + 20);
            highlight.setHeight(bounds.getHeight() + 20);
            card.setLayoutX(bounds.getMinX());
            card.setLayoutY(bounds.getMaxY() + 20);
        };
        updateHighlight.run();
        scene.widthProperty().addListener((obs, o, n) -> updateHighlight.run());
        scene.heightProperty().addListener((obs, o, n) -> updateHighlight.run());
        target.layoutBoundsProperty().addListener((obs, o, n) -> updateHighlight.run());
        // Fade in animation
        FadeTransition fade = new FadeTransition(Duration.seconds(0.4), overlayPane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
    // Smooth fade out and remove
    private void fadeOutAndRemove(StackPane root, Pane pane) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.4), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(ev -> root.getChildren().remove(pane));
        fadeOut.play();
    }
    private static class TourStep {
        Node node;
        String message;
        TourStep(Node node, String message) {
            this.node = node;
            this.message = message;
        }
    }
    
    
    
    
    
    
    
    
    
    
    

    public static void main(String[] args) {
        launch();
    }
}
