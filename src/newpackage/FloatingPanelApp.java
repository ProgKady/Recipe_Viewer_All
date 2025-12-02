package newpackage;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class FloatingPanelApp extends Application {

    
    
    
    private double dx = 2; // سرعة X
    private double dy = 2; // سرعة Y
    private final Random random = new Random();
    
    
    

    @Override
    public void start(Stage stage) {
        
        
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #e3f2fd, #bbdefb);");
        // ====== الصورة المدورة ======
        
        
        Image image = new Image("https://www.w3schools.com/w3images/avatar2.png");
        ImageView avatar = new ImageView(image);
        avatar.setFitWidth(50);
        avatar.setFitHeight(50);
        avatar.setClip(new Circle(25, 25, 25));
        // ====== النص المتغير ======
        Label textLabel = new Label("أنقذوا غزة");
        textLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #2c3e50; -fx-font-weight: bold;");
        String[] messages = {
                "Welcome to JavaFX!",
                "This text changes!",
                "Cool floating panel 😎",
                "Keep watching...",
                "Endless movement!"
        };
        Timeline textTimeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> {
                    int index = random.nextInt(messages.length);
                    textLabel.setText(messages[index]);
                })
        );
        textTimeline.setCycleCount(Timeline.INDEFINITE);
        textTimeline.play();
        // ====== Panel فيها الصورة + النص ======
        HBox panel = new HBox(10, avatar, textLabel);
        panel.setPadding(new Insets(10));
        panel.setAlignment(Pos.CENTER_LEFT);
        panel.setStyle("-fx-background-color: white; -fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8,0,2,2);");
        StackPane container = new StackPane(panel);
        container.setMaxSize(250, 30);
        container.setStyle("-fx-background-radius:15;-fx-border-radius:15;");
        root.getChildren().add(container);
        // ====== حركة عشوائية للـ panel ======
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double x = container.getTranslateX() + dx;
                double y = container.getTranslateY() + dy;
                double width = root.getWidth() / 2 - 100; // حدود X
                double height = root.getHeight() / 2 - 60; // حدود Y
                if (x > width || x < -width) dx *= -1;
                if (y > height || y < -height) dy *= -1;
                container.setTranslateX(container.getTranslateX() + dx);
                container.setTranslateY(container.getTranslateY() + dy);
            }
        };
        timer.start();
        
        
        
        
        
        
        
        
        
        
        
        
        // ====== إعداد المشهد ======
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Floating Panel with Avatar & Changing Text");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
