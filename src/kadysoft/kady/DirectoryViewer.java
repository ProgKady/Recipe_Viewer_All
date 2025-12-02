package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTreeView;
import java.awt.Desktop;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TreeItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DirectoryViewer extends Application {

    public static String pilotpathh;
    JFXTextArea coode;
    public static String useb, drib;
    public static JFXTreeView<String> a;
    JFXButton c;

    @Override
    public void start(Stage primaryStage) {
        coode = new JFXTextArea();
        a = new JFXTreeView<>();
        a.setStyle("-fx-font-weight:bold;-fx-font-size:14;");

        a.setOnMouseClicked(g -> {
            String hhhg = a.getSelectionModel().getSelectedItem().toString()
                    .replace("TreeItem [ value: ", "").replace(" ]", "");
            File filoo = new File(hhhg);

            try {
                File on1 = new File(System.getProperty("user.home") + "\\Hehehe");
                if (!on1.exists()) on1.mkdir();
                File tw2 = new File(System.getProperty("user.home") + "\\Hehehe\\Roro.ks");
                if (!tw2.exists()) tw2.createNewFile();

                coode.clear();
                InputStream inputinstream = new FileInputStream(hhhg);
                BufferedReader bi = new BufferedReader(new InputStreamReader(inputinstream, "UTF-8"));
                String lo;
                while ((lo = bi.readLine()) != null) {
                    coode.appendText("\n" + lo
                            .replace("ﬦ", "A").replace("ﬧ", "B").replace("ﬨ", "C").replace("﬩", "D")
                            .replace("שׁ", "E").replace("שׂ", "F").replace("שּׁ", "G").replace("שּׂ", "H")
                            .replace("אַ", "I").replace("אָ", "J").replace("אּ", "K").replace("בּ", "L")
                            .replace("גּ", "M").replace("דּ", "N").replace("הּ", "O").replace("וּ", "P")
                            .replace("זּ", "Q").replace("טּ", "R").replace("יּ", "S").replace("ךּ", "T")
                            .replace("כּ", "U").replace("לּ", "V").replace("מּ", "W").replace("נּ", "X")
                            .replace("סּ", "Y").replace("ףּ", "Z").replace("פּ", "0").replace("צּ", "1")
                            .replace("קּ", "2").replace("רּ", "3").replace("שּ", "4").replace("תּ", "5")
                            .replace("וֹ", "6").replace("בֿ", "7").replace("כֿ", "8").replace("פֿ", "9")
                            .replace("&NBSP;", "")
                    );
                }
                bi.close();

                String gf = coode.getText();
                OutputStream instreamm = new FileOutputStream(tw2);
                PrintWriter pwe = new PrintWriter(new OutputStreamWriter(instreamm, "UTF-8"));
                pwe.println(gf);

                pwe.println("<style>body { user-select: none; }</style>");
                pwe.println("<script>document.addEventListener('dragstart', e => e.preventDefault());" +
                        "document.addEventListener('drop', e => e.preventDefault());" +
                        "document.addEventListener('contextmenu', e => e.preventDefault());</script>");
                pwe.println("<script>window.addEventListener('contextmenu', e => e.preventDefault());</script>");
                pwe.println("<script>document.addEventListener('keydown', event => {" +
                        "console.log(`User pressed: ${event.key}`); event.preventDefault(); return false;});</script>");
                pwe.close();

                coode.clear();
                Desktop.getDesktop().open(tw2);
                Thread.sleep(4000);

                PrintWriter pl = new PrintWriter(new FileWriter(tw2));
                pl.println("Powered By Kadysoft");
                pl.close();
            } catch (Exception h) {
            }

            if (hhhg.contains(".ks")) {
                
                
                
           
                
                
                
              
            }
        });

        BorderPane b = new BorderPane();
        c = new JFXButton("Load Pilots");
        c.setButtonType(JFXButton.ButtonType.RAISED);
        c.setEffect(new DropShadow());
        c.setStyle("-fx-font-weight:bold;-fx-background-radius:3em;");
        c.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                useb = System.getProperty("user.name");
                try {
                    BufferedReader buf = new BufferedReader(new FileReader("PCs\\" + useb + ".kady"));
                    drib = buf.readLine();
                    buf.close();
                } catch (IOException ex) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Fatal Error");
                    alert.setContentText("Can't read user file.");
                    alert.setResizable(false);
                    alert.showAndWait();
                }

                try {
                    BufferedReader buf = new BufferedReader(new FileReader("PilotPath.kady"));
                    pilotpathh = buf.readLine().replace("X:", drib + ":");
                    buf.close();
                } catch (IOException ex) {
                    Logger.getLogger(DirectoryViewer.class.getName()).log(Level.SEVERE, null, ex);
                }

                File choice = new File(pilotpathh);
                if (choice == null || !choice.isDirectory()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Directory Error");
                    alert.setContentText("Invalid directory.");
                    alert.showAndWait();
                } else {
                    a.setRoot(getNodesForDirectory(choice));
                }
            }
        });

        b.setTop(c);
        b.setCenter(a);
        primaryStage.setScene(new Scene(b, 800, 600));
        primaryStage.setTitle("Pilot Viewer");
        primaryStage.setMaximized(true);
        primaryStage.show();
        c.fire();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public TreeItem<String> getNodesForDirectory(File directory) {
        TreeItem<String> root = new TreeItem<>(directory.getPath(), new ImageView(
                new Image(getClass().getResourceAsStream("folder.png"))
        ));

        for (File f : directory.listFiles()) {
            if (f.isDirectory()) {
                TreeItem<String> dirItem = getNodesForDirectory(f);
                dirItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("folder.png"))));
                root.getChildren().add(dirItem);
            } else {
                TreeItem<String> fileItem = new TreeItem<>(f.getPath());
                fileItem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("folderr.png"))));
                root.getChildren().add(fileItem);
            }
        }

        return root;
    }
}
