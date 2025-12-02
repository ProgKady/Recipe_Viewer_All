package newpackage;


import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class MovingCardApp extends Application {

    
    
    
    
    
    
    private final String[] messages = {
            "Welcome to JavaFX!",
            "Cupertino Light Style ?",
            "Moving Cards ?",
            "Dynamic Text Changes!",
            "Enjoy coding ?"
    };
    private int currentIndex = 0;
    private final Random random = new Random();
    
    
    
    
    
    
    @Override
    public void start(Stage stage) {
        
        
        
        
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #f9f9f9;");
        // ??????
        StackPane card = new StackPane();
        card.setMaxSize(250, 30);
        card.setStyle("-fx-background-radius:15;-fx-border-radius:15;");
        //card.setPrefSize(200, 100);
        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 15;" +
                "-fx-border-radius: 15;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 2, 2);"
        );
        // ??????
        ImageView avatar = new ImageView(new Image("https://www.w3schools.com/w3images/avatar2.png"));
        avatar.setFitWidth(50);
        avatar.setFitHeight(50);
        avatar.setPreserveRatio(true);
        avatar.setClip(new javafx.scene.shape.Circle(25, 25, 25)); // ?????? ?????
        // ????
        Label cardText = new Label(messages[0]);
        cardText.setStyle("-fx-font-size: 14px; -fx-text-fill: #333; -fx-font-family: 'Segoe UI';");
        VBox box = new VBox(10, avatar, cardText);
        box.setAlignment(Pos.CENTER);
        card.getChildren().add(box);
        root.getChildren().add(card);
        Scene scene = new Scene(root, 800, 600, Color.WHITE);
        stage.setScene(scene);
        stage.setTitle("Moving Card Demo");
        stage.show();
        // ???? ??????
        Timeline moveTimeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            double maxX = scene.getWidth() - card.getWidth();
            double maxY = scene.getHeight() - card.getHeight();
            double newX = random.nextDouble() * maxX - scene.getWidth() / 2;
            double newY = random.nextDouble() * maxY - scene.getHeight() / 2;
            Path path = new Path();
            path.getElements().add(new MoveTo(card.getTranslateX(), card.getTranslateY()));
            path.getElements().add(new LineTo(newX, newY));
            PathTransition transition = new PathTransition(Duration.seconds(2), path, card);
            transition.play();
        }));
        moveTimeline.setCycleCount(Timeline.INDEFINITE);
        moveTimeline.play();
        // ????? ????
        Timeline textTimeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            currentIndex = (currentIndex + 1) % messages.length;
            cardText.setText(messages[currentIndex]);
        }));
        textTimeline.setCycleCount(Timeline.INDEFINITE);
        textTimeline.play();
        
        
        
        
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
