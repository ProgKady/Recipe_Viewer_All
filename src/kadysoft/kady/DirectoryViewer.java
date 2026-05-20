package kadysoft.kady;

import com.jfoenix.controls.*;
import java.awt.Desktop;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class DirectoryViewer extends Application {

    public static String pilotpathh;
    public static String useb, drib;
    private JFXTreeView<String> treeView;
    private JFXTextArea detailsArea;
    private WebView webView;
    private JFXTextField searchField;
    private TreeItem<String> rootItem;
    private JFXButton openInBrowserButton;
    public static String klll;

    // متغيرات البحث
    private final List<TreeItem<String>> searchResults = new ArrayList<>();
    private int currentResultIndex = -1;
    private Label resultLabel;
    
    
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
            javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
           
        }
        
        
        treeView = new JFXTreeView<>();
        treeView.setStyle("-fx-font-weight: bold; -fx-font-size: 14; -fx-background-color: #f4f4f4;");

        detailsArea = new JFXTextArea();
        detailsArea.setEditable(false);
        detailsArea.setPromptText("تفاصيل الملف...");
        detailsArea.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5;");

        webView = new WebView();
        webView.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5;");

        openInBrowserButton = new JFXButton("فتح في المتصفح");
        openInBrowserButton.setButtonType(JFXButton.ButtonType.RAISED);
        openInBrowserButton.setEffect(new DropShadow());
        openInBrowserButton.setStyle("-fx-font-weight: bold; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 3em;");
        openInBrowserButton.setDisable(true);
        openInBrowserButton.setOnAction(e -> openInExternalBrowser());

        searchField = new JFXTextField();
        searchField.setPromptText("ابحث في الملفات والمجلدات...");
        searchField.textProperty().addListener((obs, oldValue, newValue) -> performSearch(newValue));

        JFXButton loadButton = new JFXButton("تحميل Pilots");
        loadButton.setButtonType(JFXButton.ButtonType.RAISED);
        loadButton.setEffect(new DropShadow());
        loadButton.setStyle("-fx-font-weight: bold; -fx-background-color: #2196F3; -fx-text-fill: white; -fx-background-radius: 3em;");
        loadButton.setOnAction(e -> loadPilotDirectory());
        
        JFXButton printButton = new JFXButton("طباعة");
        printButton.setButtonType(JFXButton.ButtonType.RAISED);
        printButton.setEffect(new DropShadow());
        printButton.setStyle("-fx-font-weight: bold; -fx-background-color: #1006F3; -fx-text-fill: white; -fx-background-radius: 3em;");
        printButton.setOnAction(e -> {
            try {
                printPilotDirectory();
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DirectoryViewer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DirectoryViewer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(DirectoryViewer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                  Logger.getLogger(DirectoryViewer.class.getName()).log(Level.SEVERE, null, ex);
              }
        });
        

        // أزرار التنقل في نتائج البحث
        JFXButton prevButton = new JFXButton("← السابق");
        prevButton.setStyle("-fx-background-color: #ff9800; -fx-text-fill: white; -fx-background-radius: 20;");
        prevButton.setOnAction(e -> navigateSearchResult(false));

        JFXButton nextButton = new JFXButton("التالي →");
        nextButton.setStyle("-fx-background-color: #ff9800; -fx-text-fill: white; -fx-background-radius: 20;");
        nextButton.setOnAction(e -> navigateSearchResult(true));

        resultLabel = new Label("0 من 0");
        resultLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #555;");

        HBox searchBox = new HBox(10, searchField, prevButton, nextButton, resultLabel);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(searchField, Priority.ALWAYS);

        HBox topBar = new HBox(10, printButton,loadButton, searchBox);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;");

        VBox detailsPane = new VBox(10, new Label("تفاصيل الملف:"), detailsArea, openInBrowserButton);
        detailsPane.setPadding(new Insets(10));
        detailsPane.setStyle("-fx-background-color: #fafafa; -fx-border-radius: 5;");
        VBox.setVgrow(detailsArea, Priority.ALWAYS);

        VBox webPane = new VBox(10, new Label("عرض المحتوى:"), webView);
        webPane.setPadding(new Insets(10));
        webPane.setStyle("-fx-background-color: #fafafa; -fx-border-radius: 5;");
        VBox.setVgrow(webView, Priority.ALWAYS);

        JFXTabPane rightTabPane = new JFXTabPane();
        Tab webTab = new Tab("العرض", webPane);
        webTab.setClosable(false);
        Tab detailsTab = new Tab("التفاصيل", detailsPane);
        detailsTab.setClosable(false);
        rightTabPane.getTabs().addAll(webTab, detailsTab);

        VBox leftPane = new VBox(5, new Label("شجرة الملفات:"), treeView);
        leftPane.setPadding(new Insets(10));
        leftPane.setStyle("-fx-background-color: #ffffff; -fx-border-color: #cccccc; -fx-border-radius: 5;");
        VBox.setVgrow(treeView, Priority.ALWAYS);

        SplitPane splitPane = new SplitPane(leftPane, rightTabPane);
        splitPane.setDividerPositions(0.1);

        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setStyle("-fx-font-family: 'Cairo SemiBold';");
        root.setCenter(splitPane);

        // حدث اختيار عنصر في الشجرة
        treeView.getSelectionModel().selectedItemProperty().addListener((obs, old, newValue) -> {
            if (newValue != null && newValue.isLeaf()) {
                File file = new File(newValue.getValue());
                showFileDetails(file);
                if (file.getName().endsWith(".ks")) {
                    loadFileInWebView(file);
                    klll=newValue.getValue();
                    openInBrowserButton.setDisable(false);
                } else {
                    webView.getEngine().loadContent("<html><body><h3>هذا الملف غير مدعوم للعرض</h3></body></html>");
                    openInBrowserButton.setDisable(true);
                }
            } else {
                detailsArea.clear();
                detailsArea.setText("اختر ملف لعرض التفاصيل.");
                webView.getEngine().loadContent("");
                openInBrowserButton.setDisable(true);
            }
        });

        Scene scene = new Scene(root, 1300, 800);
        primaryStage.setScene(scene);
        
        
               //////////////////////////////Theme////////////////////////////////
    String themooo=getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Themes");
    // Check if CSS exists
    URL cssUrl = getClass().getResource(themooo);
    if (cssUrl == null) {
        System.err.println("ERROR: cupertino-dark.css not found in same package as controller!");
    } else {
        // Apply theme to both scene and root (ensures it always works)
        String cssPath = cssUrl.toExternalForm();
        scene.getStylesheets().add(cssPath);
        root.getStylesheets().add(cssPath);
    }
    ////////////////////////////////////////////////////////////////////
        
        primaryStage.setTitle("Pilot Viewer");
        primaryStage.setMaximized(true);
        primaryStage.show();

        Platform.runLater(() -> loadButton.fire());
    }

    private void loadPilotDirectory() {
        try {
            useb = System.getProperty("user.name");
            File pilotDir = new File(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Recipes") + "\\PILOT");

            if (!pilotDir.exists() || !pilotDir.isDirectory()) {
                showAlert("خطأ في المسار", "مجلد PILOT غير موجود أو غير صالح:\n" + pilotDir.getAbsolutePath());
                return;
            }

            rootItem = createLazyNode(pilotDir);
            rootItem.setExpanded(true);
            treeView.setRoot(rootItem);
            treeView.setShowRoot(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert("خطأ", "فشل تحميل المجلد: " + ex.getMessage());
        }
    }
    
    
    
    private void printPilotDirectory() throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException, Exception {
        
        
          
      
    
                            
    
      File op = new File(klll);
      
      
      if (!klll.contains(".ks")||!klll.contains(".ks")) {
          
          //Noti
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Please Choose One Recipe First.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
      }
      
      else {
         
          
          
                      ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (klll == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = klll;
    String nameofit=Paths.get(klll).getFileName().toString();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    //////////////////////////////////////////////////////////// 
          
          
          
    InputStream inputinstream=new FileInputStream(temp);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    
    OutputStream instreamm=new FileOutputStream(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.append("<html lang=\"ar\">\n<head><title>Kadysoft Ltd - Ahmed Elkady.</title>"
            + ""
            
            + "<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
            + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
            
         +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"   
            
            
            + ""
            + "\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = bi.readLine()) != null)  
    pwe.append(line
            
            
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")
            
            + "\n");   
    pwe.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>"); 
    pwe.close();
    bi.close();
    
    
    
    
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"))); 
    
    Thread.sleep(4000);
    
    File ggf=new File (getValueByKey(System.getProperty("user.home")+"\\setto.cfg", "Main_Editor"));
    PrintWriter pl=new PrintWriter(new FileWriter(ggf));
    pl.println("Powered By Kadysoft");
    pl.close();
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
          
          
      }
      
         
        
        
        
        
    }
    

    private TreeItem<String> createLazyNode(File file) {
        TreeItem<String> item = new TreeItem<>(file.getName());
        item.setValue(file.getAbsolutePath());

        Image icon = null;
        try {
            String iconPath = file.isDirectory() ? "folder.png" : "folderr.png";
            InputStream stream = getClass().getResourceAsStream(iconPath);
            if (stream != null) icon = new Image(stream);
        } catch (Exception ignored) {}

        if (icon != null) {
            ImageView iv = new ImageView(icon);
            iv.setFitHeight(16);
            iv.setFitWidth(16);
            item.setGraphic(iv);
        } else {
            item.setGraphic(new Label(file.isDirectory() ? "📁" : "📄"));
        }

        if (file.isDirectory()) {
            item.getChildren().add(new TreeItem<>("جاري التحميل..."));
            item.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) -> {
                if (isNowExpanded && item.getChildren().size() == 1 &&
                        "جاري التحميل...".equals(item.getChildren().get(0).getValue())) {
                    loadChildrenAsync(item, file);
                }
            });
        }
        return item;
    }

    private void loadChildrenAsync(TreeItem<String> parentItem, File directory) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isHidden()) continue;
                        Platform.runLater(() -> parentItem.getChildren().add(createLazyNode(f)));
                    }
                }
                return null;
            }

            @Override
            protected void succeeded() {
                Platform.runLater(() -> parentItem.getChildren().removeIf(
                        child -> "جاري التحميل...".equals(child.getValue())
                ));
            }
        };
        new Thread(task).start();
    }

    // ===================== البحث المُصلح والمطور =====================

    private void performSearch(String query) {
        if (rootItem == null) return;

        String lowerQuery = (query == null ? "" : query.trim().toLowerCase());

        searchResults.clear();
        currentResultIndex = -1;

        if (lowerQuery.isEmpty()) {
            resultLabel.setText("0 من 0");
            collapseAll(rootItem);
            return;
        }

        // جمع النتائج مع فتح المجلدات
        collectAllMatches(rootItem, lowerQuery);

        if (searchResults.isEmpty()) {
            resultLabel.setText("لا توجد نتائج");
            return;
        }

        // الانتقال لأول نتيجة
        currentResultIndex = 0;
        goToResult(currentResultIndex);
        resultLabel.setText("1 من " + searchResults.size());
    }

    private void collectAllMatches(TreeItem<String> item, String query) {
        // تحقق من التطابق في اسم الملف أو المسار
        String fileName = new File(item.getValue()).getName().toLowerCase();
        String fullPath = item.getValue().toLowerCase();

        if (fileName.contains(query) || fullPath.contains(query)) {
            searchResults.add(item);
            expandAllParents(item);
        }

        // إذا كان مجلد، نبحث داخل أولاده (حتى لو لم يتم تحميلهم بعد، لكن بما إننا lazy، لازم نضمن إنهم محملين؟ لا، لأن البحث يحصل بعد التحميل عادة)
        if (!item.isLeaf()) {
            for (TreeItem<String> child : item.getChildren()) {
                collectAllMatches(child, query);
            }
        }
    }

    private void expandAllParents(TreeItem<String> item) {
        TreeItem<String> parent = item.getParent();
        while (parent != null) {
            parent.setExpanded(true);
            parent = parent.getParent();
        }
    }

    private void collapseAll(TreeItem<String> item) {
        if (item == null || item.isLeaf()) return;
        item.setExpanded(false);
        for (TreeItem<String> child : item.getChildren()) {
            collapseAll(child);
        }
    }

    private void navigateSearchResult(boolean next) {
        if (searchResults.isEmpty()) return;

        if (next) {
            currentResultIndex = (currentResultIndex + 1) % searchResults.size();
        } else {
            currentResultIndex = (currentResultIndex - 1 + searchResults.size()) % searchResults.size();
        }

        goToResult(currentResultIndex);
        resultLabel.setText((currentResultIndex + 1) + " من " + searchResults.size());
    }

    private void goToResult(int index) {
        TreeItem<String> result = searchResults.get(index);

        // تحديد العنصر
        treeView.getSelectionModel().select(result);

        // فتح كل الأباء
        expandAllParents(result);

        // التمرير للعنصر
        int row = treeView.getRow(result);
        if (row >= 0) {
            treeView.scrollTo(row);
        }
    }

    // ===========================================================

    private void showFileDetails(File file) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            long sizeInBytes = Files.size(file.toPath());
            String size = String.format("%,d بايت", sizeInBytes);

            StringBuilder sb = new StringBuilder();
            sb.append("اسم الملف: ").append(file.getName()).append("\n");
            sb.append("المسار الكامل: ").append(file.getAbsolutePath()).append("\n");
            sb.append("الحجم: ").append(size).append("\n");
            sb.append("آخر تعديل: ").append(df.format(new Date(file.lastModified()))).append("\n");
            sb.append("نوع: ").append(file.isDirectory() ? "مجلد" : "ملف");

            detailsArea.setText(sb.toString());
        } catch (Exception ex) {
            detailsArea.setText("خطأ في قراءة التفاصيل: " + ex.getMessage());
        }
    }

    private void loadFileInWebView(File file) {
        try {
            
            
                            ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (file == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = file.getAbsolutePath();
    String nameofit=file.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
            
            
            
            StringBuilder content = new StringBuilder();
            BufferedReader bi = new BufferedReader(new InputStreamReader(new FileInputStream(temp), "UTF-8"));
            String line;
            while ((line = bi.readLine()) != null) {
                content.append("\n").append(line
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

            String htmlContent = content.toString() +
                    "<style>body { user-select: none; background: #fff; padding: 20px; font-family: Arial, sans-serif; }</style>" +
                    "<script>" +
                    "document.addEventListener('dragstart', e => e.preventDefault());" +
                    "document.addEventListener('drop', e => e.preventDefault());" +
                    "document.oncontextmenu = () => false;" +
                    "document.onkeydown = () => false;" +
                    "</script>\n<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>";
                   

            webView.getEngine().loadContent(htmlContent);
            
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////

        } catch (Exception ex) {
            webView.getEngine().loadContent("<html><body><h3 style='color:red;'>خطأ في تحميل المحتوى</h3></body></html>");
        }
    }

    private void openInExternalBrowser() {
        TreeItem<String> selected = treeView.getSelectionModel().getSelectedItem();
        if (selected == null || !selected.isLeaf()) return;

        File file = new File(selected.getValue());
        if (!file.getName().endsWith(".ks")) return;

        try {
            File tempDir = new File(System.getProperty("user.home") + "\\Hehehe");
            if (!tempDir.exists()) tempDir.mkdirs();

            File tempFile = new File(tempDir, "Roro.ks");
            
            
                            ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (file == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = file.getAbsolutePath();
    String nameofit=file.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
            

            StringBuilder content = new StringBuilder();
            BufferedReader bi = new BufferedReader(new InputStreamReader(new FileInputStream(temp), "UTF-8"));
            String line;
            while ((line = bi.readLine()) != null) {
                content.append("\n").append(line
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

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));
            pw.println(content.toString());
            pw.println("<style>body { user-select: none; }</style>");
            pw.println("<script>document.oncontextmenu = () => false; document.onkeydown = () => false;</script>");
            pw.close();
            
                        	
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
            

            Desktop.getDesktop().open(tempFile);

            new Thread(() -> {
                try {
                    Thread.sleep(4000);
                    PrintWriter pl = new PrintWriter(tempFile);
                    pl.println("Powered By Kadysoft");
                    pl.close();
                } catch (Exception ignored) {}
            }).start();

        } catch (Exception ex) {
            showAlert("خطأ", "فشل الفتح في المتصفح: " + ex.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}