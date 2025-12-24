package kadysoft.kady;



import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.concurrent.Task;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class Chemical_Planner_Controller implements Initializable {

   ///////////////////////////////Important Directories////////////////////////////////////////////
   
    
    public static String models_file_path;
    public static String recipes_folder;
    
    
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement pst = null;
    
    ResultSet rss = null;
    Connection connn = null;
    PreparedStatement pstt = null;
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    
    @FXML
    private Hyperlink browselink;


    @FXML
    private WebView webview;

    //@FXML
    //private TableView<String> table;


    @FXML
    private ComboBox<String> model,recipe;

    @FXML
    private JFXTextField monthtf;
    

    @FXML
    private JFXButton fixchemic;

    
    @FXML
    private JFXTextField patch;



   
    @FXML
    private JFXButton get,clearal,adddbtn,deletebtn,exportbtn;

    @FXML
    private JFXTextField quantityyy,pcsss;

  
    
    @FXML
    private JFXTextArea lili;
    
    @FXML
    private ListView<String> l1;

    @FXML
    private ListView<String> l2;

    @FXML
    private ListView<String> l3;

    @FXML
    private ListView<String> l4;

    @FXML
    private ListView<String> l5;
    
    @FXML
    private ListView<String> l6;

    @FXML
    private ListView<String> l7;

    @FXML
    private ListView<String> l8;

    @FXML
    private ListView<String> l9;
    
    @FXML
    private ListView<String> l10;
    
    @FXML
    private ListView<String> l11;
    
    @FXML
    private ListView<String> l12;
    
    
    
    public static String stato="";
    
    public static String sheetpas=".";
    
    public static String sheetnam=".";
    
     private ScheduledExecutorService executorService;
     
     public static String woow=".";
    
     
     
     @FXML
    private TableView<ObservableList<String>> table;
    
    private ObservableList<ObservableList<String>> dataaa;
    
    
    public static String useb,drib;
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    @FXML
    private JFXTextField excelfile;
    
    @FXML
    private ListView<String> recipelistall;
    
    @FXML
    private JFXButton planall,clearlist;
    
    public static int potchh;
    
    public static String modelName;
    
    public static String nameWithoutExtension;
    
    public static String patcchh,messagee;
    
    
    
    @FXML
    private JFXCheckBox skiperr;
    
    
    @FXML
    private Label count,count2,count3;
    
    @FXML
    private JFXButton delsel;
    
    public static int skippp=0;
    
    
    
    @FXML
void delselaction(ActionEvent event) {
    // Get selected item
    String selectedItem = recipelistall.getSelectionModel().getSelectedItem();
    
    if (selectedItem != null) {
        // Remove from the observable list
        ObservableList<String> items = recipelistall.getItems();
        items.remove(selectedItem);

        // Refresh the ListView by reassigning the updated list
        recipelistall.setItems(FXCollections.observableArrayList(items));
        
        Platform.runLater(() -> {
        count.setText(Integer.toString(recipelistall.getItems().size())+" Items");
        });
    }
}

    
    
    
     // Helper method to get any cell value as String
    private static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }}
    
    @FXML
    void clearlistaction(ActionEvent event) {
        
        recipelistall.getItems().clear();
        
        Platform.runLater(() -> {
        count.setText(Integer.toString(recipelistall.getItems().size())+" Items");
        });
       
    }
    
    @FXML
    void recipelistalldd(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            List<File> files = event.getDragboard().getFiles();
            
            // Add each file path as a separate item in the ListView
            for (File file : files) {
                recipelistall.getItems().add(file.getAbsolutePath());
            }
            Platform.runLater(() -> {
            count.setText(Integer.toString(recipelistall.getItems().size())+" Items");
            });
            event.setDropCompleted(true);
            event.consume();
        }
    }

    @FXML
    void recipelistalldo(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }
    
    @FXML
void excelfileaction(MouseEvent eventoo)  {
    
     FileChooser fileChooser = new FileChooser();
     fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
     File file = fileChooser.showOpenDialog(null);
     String exxx=file.getAbsolutePath().toString();
        if (file != null) {
           excelfile.setText(exxx);
       }
   
}
    
    
    //.replace("X:",drib+":")
    
    












@FXML
void planallaction(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException {

    // التحقق من المدخلات
    if (recipelistall.getItems().size() == 0) {
        showErrorNotification("خطأ فادح", "يرجى إضافة ملفات الوصفات أولاً");
        recipelistall.requestFocus();
        return;
    }

    if (excelfile.getText().isEmpty()) {
        showErrorNotification("خطأ فادح", "يرجى اختيار ملف الإكسيل");
        excelfile.requestFocus();
        return;
    }

    String excelPath = excelfile.getText();
    if (!excelPath.toLowerCase().endsWith(".xlsx") && !excelPath.toLowerCase().endsWith(".xls")) {
        showErrorNotification("خطأ فادح", "الملف المختار ليس ملف إكسيل صالح");
        return;
    }

    if (!skiperr.isSelected()) {
        showErrorNotification("معلومة", "يرجى تفعيل خيار 'تخطي الأخطاء' للمتابعة");
        return;
    }

    // إعداد المتغيرات
    final int[] skippedCountArray = {0};
    final int[] successCountArray = {0};
    final StringBuilder failedRecipes = new StringBuilder();
    final StringBuilder failedReasons = new StringBuilder();
    messagee = "";

    Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {

            // إعلام البداية
            Platform.runLater(() -> {
                Notifications.create()
                        .title("بدء التخطيط")
                        .text("جاري معالجة " + recipelistall.getItems().size() + " ريسيبي...")
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.CENTER)
                        .showInformation();
            });

            // قراءة الإكسيل
            Map<String, String> recipeToPatchMap = new HashMap<>();
            try (FileInputStream fis = new FileInputStream(excelPath);
                 XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    Cell nameCell = row.getCell(0);
                    Cell patchCell = row.getCell(1);
                    if (nameCell != null && nameCell.getCellType() == CellType.STRING) {
                        String recipeName = nameCell.getStringCellValue().trim();
                        String patch = (patchCell != null) ? getCellValue(patchCell).toString().trim() : null;
                        if (patch != null && !patch.isEmpty()) {
                            recipeToPatchMap.put(recipeName, patch);
                        }
                    }
                }
            } catch (Exception e) {
                Platform.runLater(() -> showErrorNotification("خطأ في الإكسيل", "فشل في قراءة الملف: " + e.getMessage()));
                return null;
            }

            // مسح الجداول
            Platform.runLater(() -> {
                l1.getItems().clear(); l2.getItems().clear(); l3.getItems().clear();
                l4.getItems().clear(); l5.getItems().clear(); l6.getItems().clear();
                l7.getItems().clear(); l8.getItems().clear(); l9.getItems().clear();
                l10.getItems().clear(); l11.getItems().clear(); l12.getItems().clear();
            });

            // معالجة كل وصفة
            for (String filePath : recipelistall.getItems()) {
                if (isCancelled()) break;

                Path path = Paths.get(filePath);
                String fileName = path.getFileName().toString();
                String recipeName = fileName.substring(0, fileName.lastIndexOf('.'));
                String modelName = (path.getNameCount() >= 2) ? path.getName(path.getNameCount() - 2).toString() : "";

                String patch = recipeToPatchMap.get(recipeName);

                if (patch == null || patch.isEmpty()) {
                    failedRecipes.append("• ").append(recipeName).append(" (").append(modelName).append(")\n");
                    failedReasons.append("غير موجود في الإكسيل أو بدون Patch\n");
                    skippedCountArray[0]++;
                    Platform.runLater(() -> showWarningNotification("تخطي ريسيبي", recipeName + " → غير موجود أو بدون Patch"));
                    continue;
                }

                boolean success = processRecipeFile(filePath, recipeName, modelName, patch);

                if (success) {
                    successCountArray[0]++;
                    Platform.runLater(() -> showSuccessNotification("نجاح", recipeName + " → تمت المعالجة والإضافة بنجاح"));
                } else {
                    skippedCountArray[0]++;
                    failedRecipes.append("• ").append(recipeName).append(" (").append(modelName).append(")\n");
                    failedReasons.append("مشكلة في الكيماويات (لا كيماويات / سعر مفقود / أطوال غير متساوية)\n");
                    messagee += recipeName + "\n";
                    Platform.runLater(() -> showWarningNotification("فشل جزئي", recipeName + " → موجود Patch لكن مشكلة في الكيماويات"));
                }
            }

            // التقرير النهائي والإجراءات النهائية
            Platform.runLater(() -> {
                count3.setText(String.valueOf(skippedCountArray[0]));

                // حساب التكاليف الإضافية وحساب l8 و l12
                if (!l4.getItems().isEmpty()) {
                    l8.getItems().clear();
                    l3.getSelectionModel().select(0);
                    l4.getSelectionModel().select(0);
                    l11.getSelectionModel().select(0);
                    int ipp = 0;
                    while (ipp < l4.getItems().size()) {
                        l3.getSelectionModel().select(ipp);
                        l4.getSelectionModel().select(ipp);
                        l11.getSelectionModel().select(ipp);
                        String c1 = l3.getSelectionModel().getSelectedItem();
                        String c2 = l4.getSelectionModel().getSelectedItem();
                        String c3 = l11.getSelectionModel().getSelectedItem();
                        double x1 = Double.parseDouble(c1);
                        double x2 = Double.parseDouble(c2);
                        double x3 = Double.parseDouble(c3);
                        double res = x1 * x2;
                        double ress = x1 * x3;
                        l8.getItems().add(String.valueOf(res));
                        l12.getItems().add(String.valueOf(ress));
                        ipp++;
                    }
                    adddbtn.fire(); // تشغيل الإضافة للداتابيز مرة واحدة في النهاية
                }

                // تقرير نهائي مفصل
                StringBuilder finalReport = new StringBuilder();
                finalReport.append("📊 تقرير التخطيط النهائي 📊\n\n");
                finalReport.append("✅ إجمالي الريسيبيات: ").append(recipelistall.getItems().size()).append("\n");
                finalReport.append("✅ تمت المعالجة بنجاح: ").append(successCountArray[0]).append("\n");
                finalReport.append("  تم التخطي: ").append(skippedCountArray[0]).append("\n\n");
                count2.setText(Integer.toString(recipelistall.getItems().size())+"  Of");

                if (skippedCountArray[0] > 0) {
                    finalReport.append(" الريسيبيات التي تم تخطيها:\n");
                    finalReport.append(failedRecipes.toString());
                    finalReport.append("\nالأسباب:\n");
                    finalReport.append(failedReasons.toString());
                } else {
                    finalReport.append("🎉 جميع الريسيبيات تمت معالجتها بنجاح!\n");
                }

                Alert reportAlert = new Alert(Alert.AlertType.INFORMATION);
                reportAlert.setTitle("تقرير التخطيط");
                reportAlert.setHeaderText("تم الانتهاء من معالجة الريسيبيات");
                //reportAlert.setContentText(finalReport.toString());
                reportAlert.setGraphic(new JFXTextArea (finalReport.toString()));
                reportAlert.getDialogPane().setPrefSize(600, 350);
                DialogPane dialogPaneu = reportAlert.getDialogPane();
                dialogPaneu.getStylesheets().add(
              getClass().getResource("cupertino-light.css").toExternalForm());
                reportAlert.showAndWait();

                // إشعار سريع
                Notifications.create()
                        .title("اكتمل التخطيط")
                        .text("نجح: " + successCountArray[0] + " | تخطي: " + skippedCountArray[0])
                        .hideAfter(Duration.seconds(10))
                        .position(Pos.CENTER)
                        .showInformation();
            });

            return null;
        }
    };

    Thread thread = new Thread(task);
    thread.setDaemon(true);
    thread.start();
}

// دالة معالجة الوصفة (محدثة ومحسنة: إزالة الفلاتر الزائدة، تحسين التنظيف، إضافة لوج للتشخيص المؤقت، ترتيب أفضل)
private boolean processRecipeFile(String filePath, String recipeName, String modelName, String patch) {
    try {
        String content = readFileToString(filePath)
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
                .replaceAll("\\s+", " ")  // تحويل أي مسافات متعددة إلى مسافة واحدة
                .trim();

        // ملف مؤقت لتحليل Jsoup
        String tempFilePath = System.getProperty("user.home") + File.separator + "ruoo.ks";
        writeStringToFile(tempFilePath, content);

        Document doc = Jsoup.parse(new File(tempFilePath), "UTF-8");

        List<String> quantities = new ArrayList<>();
        List<String> chemicals = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        List<String> dilutions = new ArrayList<>();
        List<String> chemicalsss = new ArrayList<>(); // العمود 7 (الوصف أو الملاحظات)

        int skippedChemicals = 0;
        int totalRowsProcessed = 0;

        for (Element table : doc.select("table")) {
            for (Element row : table.select("tr")) {
                Elements tds = row.select("td");
                if (tds.size() < 9) continue; // الصفوف الناقصة نتجاهلها

                totalRowsProcessed++;

                String chemName = tds.get(8).text().trim();

                // فلاتر بسيطة ومنطقية فقط (إزالة الصفوف الواضح إنها عنوان أو فارغة)
                if (chemName.isEmpty() ||
                    chemName.equalsIgnoreCase("OLD STONE") ||
                    chemName.toUpperCase().contains("CHEMICAL") ||
                    chemName.toUpperCase().contains("RAW MATERIAL") ||
                    chemName.toUpperCase().contains("TOTAL") ||
                    chemName.toUpperCase().contains("TIME") ||
                    chemName.toUpperCase().contains("HOURS") ||
                    chemName.toUpperCase().contains("MINS")) {
                    // System.out.println("Skipped (header/empty): " + chemName); // يمكن تفعيلها للتشخيص
                    continue;
                }

                // إزالة الفلتر القاسي اللي كان بيستبعد أي اسم فيه رقم أو - أو _
                // دلوقتي بنعتمد بشكل أساسي على وجود السعر في ملف Prices.kady

                String price = findValueInKadyFile(chemName, NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Prices.kady", "=$");
                if (price == null || price.isEmpty()) {
                    skippedChemicals++;
                    // System.out.println("Skipped (no price found): " + chemName); // للتشخيص المؤقت
                    continue;
                }

                String dilution = findValueInKadyFile(chemName, NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Dilution.kady", "=");
                if (dilution == null || dilution.isEmpty()) dilution = "1.0";

                String amountStr = tds.get(5).text().trim().replace(",", ".");
                String unit = tds.get(6).text().trim().toUpperCase();

                double amount = 0.0;
                if (!amountStr.isEmpty() && isNumeric(amountStr)) {
                    amount = Double.parseDouble(amountStr);

                    if (unit.contains("GR") || unit.contains("GM") || unit.contains("GRAM")) {
                        amount /= 1000.0; // تحويل جرام إلى كيلو
                    } else if (unit.contains("GARDAL") || unit.contains("GARDEL") || unit.contains("GARD")) {
                        amount = chemName.equalsIgnoreCase("FOAM") ? 0.8 : amount * 12.0;
                    }
                    // يمكن إضافة وحدات أخرى هنا لو لزم الأمر
                }

                String formattedAmount = String.format("%.6f", amount)
                        .replaceAll("0*$", "")   // إزالة الأصفار الزائدة من الآخر
                        .replaceAll("\\.$", ""); // إزالة النقطة لو كانت آخر حاجة

                if (formattedAmount.isEmpty() || formattedAmount.equals(".")) formattedAmount = "0";

                // إضافة البيانات
                chemicals.add(chemName);
                prices.add(price);
                dilutions.add(dilution);
                quantities.add(formattedAmount);
                chemicalsss.add(tds.get(7).text().trim());

                // System.out.println("Added: " + chemName + " | Qty: " + formattedAmount + " KG"); // للتشخيص
            }
        }

        // لو مفيش مواد تم قبولها
        if (quantities.isEmpty()) {
            System.out.println("No valid chemicals found in file: " + filePath);
            return false;
        }

        // تحقق من سلامة البيانات
        if (quantities.size() != chemicals.size() ||
            quantities.size() != prices.size() ||
            quantities.size() != dilutions.size()) {
            System.err.println("Data inconsistency in recipe: " + recipeName);
            return false;
        }

        // إضافة البيانات إلى الواجهة (في الـ JavaFX thread)
        Platform.runLater(() -> {
            for (int i = 0; i < quantities.size(); i++) {
                l1.getItems().add(modelName);
                l2.getItems().add(recipeName);
                l3.getItems().add(patch);
                l4.getItems().add(quantities.get(i));
                l5.getItems().add("KG");
                l6.getItems().add(chemicalsss.get(i));
                l7.getItems().add(chemicals.get(i));
                l9.getItems().add(dilutions.get(i));
                l10.getItems().add(prices.get(i));

                double qty = Double.parseDouble(quantities.get(i));
                double dil = Double.parseDouble(dilutions.get(i));
                double prc = Double.parseDouble(prices.get(i));

                double costAfterDil = (qty / dil) * prc;
                l11.getItems().add(String.format("%.2f", costAfterDil));

                double totalCost = Double.parseDouble(patch) * costAfterDil;
                l12.getItems().add(String.format("%.2f", totalCost));
            }
        });

        // طباعة ملخص سريع (اختياري - يمكن حذفها لاحقًا)
        System.out.println("Processed: " + recipeName + " | Added: " + quantities.size() +
                " chemicals | Skipped (no price): " + skippedChemicals);

        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        // حذف الملف المؤقت لو موجود (اختياري للتنظيف)
        try {
            File temp = new File(System.getProperty("user.home") + File.separator + "ruoo.ks");
            if (temp.exists()) temp.delete();
        } catch (Exception ignored) {}
    }
}

// دوال مساعدة للإشعارات الملونة
private void showSuccessNotification(String title, String text) {
    Notifications.create().title(title).text(text).hideAfter(Duration.seconds(4)).position(Pos.BOTTOM_RIGHT).showConfirm();
}

private void showWarningNotification(String title, String text) {
    Notifications.create().title(title).text(text).hideAfter(Duration.seconds(6)).position(Pos.BOTTOM_RIGHT).showWarning();
}



// باقي الدوال المساعدة (readFileToString, writeStringToFile, findValueInKadyFile, isNumeric, getCellValue) تبقى زي ما هي


// دالة لقراءة ملف كامل كـ String في Java 8
private String readFileToString(String filePath) throws IOException {
    StringBuilder contentBuilder = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
        String line;
        while ((line = br.readLine()) != null) {
            contentBuilder.append(line).append("\n");
        }
    }
    return contentBuilder.toString();
}
// دالة لكتابة String في ملف في Java 8
private void writeStringToFile(String filePath, String content) throws IOException {
    try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
        writer.print(content);
    }
}
// دالة مساعدة للبحث في ملفات .kady
private String findValueInKadyFile(String key, String filePath, String separator) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(separator)) {
                String before = line.substring(0, line.indexOf(separator)).trim();
                if (before.equals(key)) {
                    return line.substring(line.indexOf(separator) + separator.length()).trim();
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}

// دالة مساعدة للتحقق من أن النص رقم
private boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) return false;
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}


// دالة مساعدة لعرض الـ Notifications (عشان نكررش الكود)
private void showErrorNotification(String title, String text) {
    Notifications noti = Notifications.create()
            .title(title)
            .text(text)
            .hideAfter(Duration.seconds(6))
            .position(Pos.CENTER);
    noti.showError();
}











//
//
//
///
//
//     @FXML
//void planallaction(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException {
//    
//    
//    
//    if (skiperr.isSelected()==true) {
//        
//        
//        
//    
//    
//    messagee="";
//    
//    Task<Void> task = new Task<Void>() {
//        @Override
//        protected Void call() throws Exception {
//            for (int i = 0; i < recipelistall.getItems().size(); i++) {
//                if (isCancelled()) break;
//                
//                int gh=i+1;
//                //int skippp=0;
//                
////                Platform.runLater(() -> {                 
////               count3.setText("0");       
////               });
//
//                String filePath = recipelistall.getItems().get(i); // Path
//                Path path = Paths.get(filePath);
//                String fileName = path.getFileName().toString();
//                nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf(".")); // Names
//                System.out.println(nameWithoutExtension);
//                int count = path.getNameCount();
//                if (count >= 2) { // Ensure there is at least one parent folder before the filename
//                modelName = path.getName(count - 2).toString();
//                System.out.println(modelName);
//                } else {}
//
//                // Clear UI lists inside Platform.runLater()
//                Platform.runLater(() -> {
//                    
//                    count2.setText(Integer.toString(gh) +"Of");       
//                    l1.getItems().clear();
//                    l2.getItems().clear();
//                    l3.getItems().clear();
//                    l4.getItems().clear();
//                    l5.getItems().clear();
//                    l6.getItems().clear();
//                    l7.getItems().clear();
//                    l8.getItems().clear();
//                    l9.getItems().clear();
//                    l10.getItems().clear();
//                    l11.getItems().clear();
//                    l12.getItems().clear();
//                    webview.getEngine().loadContent("");
//                    
//        Notifications noti = Notifications.create();
//        noti.title("Planning Operation");
//        noti.text("We will plan "+nameWithoutExtension+" recipe.");
//        noti.hideAfter(Duration.seconds(5));
//        noti.position(Pos.CENTER);
//        noti.showInformation();
//        
//       
//                    
//                    
//                });
//
//                // Read File Content
//                InputStream inputinstream = new FileInputStream(filePath);
//                BufferedReader bi = new BufferedReader(new InputStreamReader(inputinstream, "UTF-8"));
//                StringBuilder fileContent = new StringBuilder();
//                String line;
//                while ((line = bi.readLine()) != null) {
//                    fileContent.append("\n").append(line
//                            .replace("ﬦ", "A")
//                            .replace("ﬧ", "B")
//                            .replace("ﬨ", "C")
//                            .replace("﬩", "D")
//                            .replace("שׁ", "E")
//                            .replace("שׂ", "F")
//                            .replace("שּׁ", "G")
//                            .replace("שּׂ", "H")
//                            .replace("אַ", "I")
//                            .replace("אָ", "J")
//                            .replace("אּ", "K")
//                            .replace("בּ", "L")
//                            .replace("גּ", "M")
//                            .replace("דּ", "N")
//                            .replace("הּ", "O")
//                            .replace("וּ", "P")
//                            .replace("זּ", "Q")
//                            .replace("טּ", "R")
//                            .replace("יּ", "S")
//                            .replace("ךּ", "T")
//                            .replace("כּ", "U")
//                            .replace("לּ", "V")
//                            .replace("מּ", "W")
//                            .replace("נּ", "X")
//                            .replace("סּ", "Y")
//                            .replace("ףּ", "Z")
//                            .replace("פּ", "0")
//                            .replace("צּ", "1")
//                            .replace("קּ", "2")
//                            .replace("רּ", "3")
//                            .replace("שּ", "4")
//                            .replace("תּ", "5")
//                            .replace("וֹ", "6")
//                            .replace("בֿ", "7")
//                            .replace("כֿ", "8")
//                            .replace("פֿ", "9")
//                            .replace("&NBSP;", ""));
//                }
//                bi.close();
//                String finalContent = fileContent.toString();
//
//                // Update UI inside Platform.runLater()
//                Platform.runLater(() -> {
//                    //System.out.println(finalContent);
//                    lili.setText(finalContent);
//                    webview.getEngine().loadContent(finalContent);
//                });
//
//                // Save content to a file
//                try (OutputStream instreamm = new FileOutputStream(System.getProperty("user.home") + "\\ruoo.ks");
//                     PrintWriter pwe = new PrintWriter(new OutputStreamWriter(instreamm, "UTF-8"))) {
//                    pwe.println(finalContent);
//                }
//                
//                
//                //////////////////////////////////////////////////////////////////////////////////////
//                
//String filePathj = excelfile.getText(); // Get file path from input
//String searchText = nameWithoutExtension; // The text to search for
//
//// ✅ Check if the file is an Excel file (.xlsx or .xls)
//if (!filePathj.toLowerCase().endsWith(".xlsx") && !filePathj.toLowerCase().endsWith(".xls")) {
//   
//   
//   
//  
//}
//
////System.out.println("Processing file: " + filePathj);
////System.out.println("Searching for: " + searchText);
//
//try (FileInputStream fis = new FileInputStream(new File(filePathj));
//     XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//    Sheet sheet = workbook.getSheetAt(0); // Read the first sheet
//
//    for (Row row : sheet) {
//        for (Cell cell : row) {
//            if (cell.getCellType() == CellType.STRING && searchText.equals(cell.getStringCellValue().trim())) {
//                int nextCellIndex = cell.getColumnIndex() + 1; // Get next column index
//                Cell nextCell = row.getCell(nextCellIndex); // Get the next cell
//
//                if (nextCell != null) {
//                    patcchh = (getCellValue(nextCell)).toString();
//                }
//            }
//        }
//    }
//} catch (IOException e) {
//    e.printStackTrace();
//}
//
//    
//
//        
//                
//                /////////////////////////////////////////Plan/////////////////////////////////////////
//      
//                  
//         Platform.runLater(() -> {
//           
//           try{  
//             
//          
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//        
//       
//        
//        //String moodel=model.getSelectionModel().getSelectedItem().toString();
//        //String reciipe=woow;
//      
//////////////////////////////////////////////////
//File inputFile = new File(System.getProperty("user.home")+"\\ruoo.ks"); //
//org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
////Document docj = Jsoup.parse(codee);
//for (Element table : docj.select("TABLE")) {
//for (Element row : table.select("TR")) {
//Elements tds = row.select("TD");
//if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
//}
//else { 
//String string = tds.get(8).text();
//BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Prices.kady"));
//String lines;
//String linebeforeequal;
//String lineafterequal;
//boolean found = false;
//while ((lines = buf.readLine()) != null) {
//linebeforeequal = lines.substring(0, lines.indexOf("=$"));  // Item
//lineafterequal = lines.substring(lines.indexOf("=$") + 2);  // Price
//if (string.equals(linebeforeequal)) {
//l1.getItems().addAll(modelName);
//l2.getItems().addAll(nameWithoutExtension);
//l3.getItems().addAll(patcchh);
//l5.getItems().addAll("KG");
//l6.getItems().addAll(tds.get(7).text());
//l7.getItems().addAll(linebeforeequal);
//l10.getItems().addAll(lineafterequal);
////double number1 = Double.parseDouble(lineafterequal);
////pri1.add(number1);
////String itaam = linebeforeequal;
////nom1.add(itaam);
//found = true;
//break;
//}
//}
//buf.close();   
//}          
////////////////////////KG//////////////////////////
//String skip=tds.get(8).text();
//if (skip.equals("OLD STONE")) {   
//}
//else {
//if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
//else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
//double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
//String amm=Double.toString(am);
//if (amm.contains("E")) { 
//BigDecimal bd = new BigDecimal(amm);
//double val = bd.doubleValue();
//String vallo=Double.toString(val);
////qua1.add(val);
//l4.getItems().addAll(vallo);
//}
//else {
////qua1.add(am);
//l4.getItems().addAll(amm);
//}
//}
//
//else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
//||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
//String sky=tds.get(8).text();
//if (sky.equals("FOAM")) {
//double adddm=(4.0/5.0);
//String zxdz=Double.toString(adddm);
////qua1.add(am);
//l4.getItems().addAll(zxdz);
//}
//else {
//double amld=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
//String ddslsd=Double.toString(amld);
////qua1.add(am);
//l4.getItems().addAll(ddslsd);
//}
//}
//else {
//double number2 = Double.parseDouble(tds.get(5).text());
//String dfgwe=Double.toString(number2);
////qua1.add(number2);
//l4.getItems().addAll(dfgwe);
//}    
//}
////////////////////////////////////////////////
//if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
//}
//else {  
//String string = tds.get(8).text();
//BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Dilution.kady"));
//String linel;
//boolean found = false;
//while ((linel = buf.readLine()) != null) {
//String linebeforeequal = linel.substring(0, linel.indexOf("=")).trim();  // Item
//String lineafterequal = linel.substring(linel.indexOf("=") + 1).trim();  // Dilution
//if (string.equals(linebeforeequal)) {
//double number3 = Double.parseDouble(lineafterequal);
//String dsgfew=Double.toString(number3);
////dil1.add(number3);
//l9.getItems().addAll(dsgfew);
//found = true;
//break;
//}
//}
//if (!found) {
//double number3 = Double.parseDouble("1.0");
//String ty4554=Double.toString(number3);
////dil1.add(number3);
//l9.getItems().addAll(ty4554);
//}
//buf.close();
//}
/////////////////////////////////////////////////
//}}
//
//
//
//
//
//if (l4.getItems().size()!=l10.getItems().size()||l4.getItems().size()!=l9.getItems().size()||l4.getItems().size()!=l7.getItems().size()) { 
//
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//    
//    
//Notifications noti = Notifications.create();
//noti.title("Fatal Error!");
//noti.text("Error - Fix Chemicals First - "+nameWithoutExtension+"\nWe will skip it now");
//noti.position(Pos.CENTER);
//noti.hideAfter(Duration.seconds(10));
//noti.showError();
//
////cancel();  //deprecated
//
//
//messagee=messagee+nameWithoutExtension+"\n";
//
//
//skippp=skippp+1;
//Platform.runLater(() -> {                 
//count3.setText(Integer.toString(skippp));       
//});
//
//            
//}
//else {
////Show alert to write pcs.    
//for (int iy = 0; iy < l4.getItems().size(); iy++) {
//double ute1=Double.parseDouble(l4.getItems().get(iy));
//double ute2=Double.parseDouble(l9.getItems().get(iy));
//double ute3=Double.parseDouble(l10.getItems().get(iy));
//double tgewh=(ute1/ute2)*ute3;
//String jhkjh=Double.toString(tgewh);
//l11.getItems().addAll(  jhkjh  );
//
//}
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//       l8.getItems().clear();
//       l3.getSelectionModel().select(0);
//       l4.getSelectionModel().select(0);
//       
//       l11.getSelectionModel().select(0);
//       
//       int ipp=0;
//       
//       while (ipp<l4.getItems().size()) {
//           
//       l3.getSelectionModel().select(ipp);
//       l4.getSelectionModel().select(ipp);
//       
//       l11.getSelectionModel().select(ipp);
//       
//           
//       String c1=l3.getSelectionModel().getSelectedItem().toString();
//       String c2=l4.getSelectionModel().getSelectedItem().toString();
//       
//       String c3=l11.getSelectionModel().getSelectedItem().toString();
//       
//       
//       double x1=Double.parseDouble(c1);
//       double x2=Double.parseDouble(c2);
//       
//       double x3=Double.parseDouble(c3);
//       
//       double res=(x1*x2);
//       
//       double ress=(x1*x3);
//       
//       String result=Double.toString(res);
//       
//       String resultt=Double.toString(ress);
//       
//       l8.getItems().add(result);
//       
//       l12.getItems().add(resultt);
//       
//       ipp++;
//       
//           
//       }
//       //adddbtn.setVisible(true);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//Thread.sleep(500);
//adddbtn.fire();
//
//    }
//
//
//            
//           }
//           catch (Exception g) {}
//            
//              });       
//                
//
//                
//                //////////////////////////////////////////////////////////////////////////////////////
//                
//                
//                Thread.sleep(3000); // Sleep for 200ms
//            }
//            return null;
//        }
//    };
//    
//    task.setOnSucceeded(event1 -> {
//        
//        Notifications noti = Notifications.create();
//        noti.title("Successful Operation");
//        noti.text("All Recipes were planned successfully.");
//        noti.hideAfter(Duration.seconds(5));
//        noti.position(Pos.CENTER);
//        noti.showInformation();
//        
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//        webview.getEngine().loadContent("");
//        
//        Platform.runLater(() -> {                 
//        count3.setText(Integer.toString(skippp));       
//        });
//        
//      if (!messagee.equals("")) {
//        
//      Alert alert = new Alert(AlertType.INFORMATION);
//      alert.setTitle("Skipped Recipes");
//      alert.setHeaderText("All below recipes have errors with chemicals");
//      alert.setContentText(messagee+"\n\nPlease call Ahmed Elkady to fix them as soon as possible.");
//      DialogPane dialogPane = alert.getDialogPane();
//      dialogPane.getStylesheets().add(
//      getClass().getResource("primer-dark.css").toExternalForm());
//      alert.showAndWait();
//      
//    }
//        
//    });
//
//    Thread thread = new Thread(task);
//    thread.setDaemon(true); // Make it a daemon thread so it exits when the app closes
//    thread.start();
//
//        
//        
//    }
//    
//    
//    else {
//        
//        
//        
//    
//    
//    messagee="";
//    
//    Task<Void> task = new Task<Void>() {
//        @Override
//        protected Void call() throws Exception {
//            for (int i = 0; i < recipelistall.getItems().size(); i++) {
//                if (isCancelled()) break;
//                
//                int gh=i+1;
//                
////                Platform.runLater(() -> {                 
////               count3.setText("0");       
////               });
//
//                String filePath = recipelistall.getItems().get(i); // Path
//                Path path = Paths.get(filePath);
//                String fileName = path.getFileName().toString();
//                nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf(".")); // Names
//                System.out.println(nameWithoutExtension);
//                int count = path.getNameCount();
//                if (count >= 2) { // Ensure there is at least one parent folder before the filename
//                modelName = path.getName(count - 2).toString();
//                System.out.println(modelName);
//                } else {}
//
//                // Clear UI lists inside Platform.runLater()
//                Platform.runLater(() -> {
//                    
//                     count2.setText(Integer.toString(gh) +"Of");       
//                    l1.getItems().clear();
//                    l2.getItems().clear();
//                    l3.getItems().clear();
//                    l4.getItems().clear();
//                    l5.getItems().clear();
//                    l6.getItems().clear();
//                    l7.getItems().clear();
//                    l8.getItems().clear();
//                    l9.getItems().clear();
//                    l10.getItems().clear();
//                    l11.getItems().clear();
//                    l12.getItems().clear();
//                    webview.getEngine().loadContent("");
//                    
//        Notifications noti = Notifications.create();
//        noti.title("Planning Operation");
//        noti.text("We will plan "+nameWithoutExtension+" recipe.");
//        noti.hideAfter(Duration.seconds(5));
//        noti.position(Pos.CENTER);
//        noti.showInformation();
//            
//                    
//                });
//
//                // Read File Content
//                InputStream inputinstream = new FileInputStream(filePath);
//                BufferedReader bi = new BufferedReader(new InputStreamReader(inputinstream, "UTF-8"));
//                StringBuilder fileContent = new StringBuilder();
//                String line;
//
//                while ((line = bi.readLine()) != null) {
//                    fileContent.append("\n").append(line
//                            .replace("ﬦ", "A")
//                            .replace("ﬧ", "B")
//                            .replace("ﬨ", "C")
//                            .replace("﬩", "D")
//                            .replace("שׁ", "E")
//                            .replace("שׂ", "F")
//                            .replace("שּׁ", "G")
//                            .replace("שּׂ", "H")
//                            .replace("אַ", "I")
//                            .replace("אָ", "J")
//                            .replace("אּ", "K")
//                            .replace("בּ", "L")
//                            .replace("גּ", "M")
//                            .replace("דּ", "N")
//                            .replace("הּ", "O")
//                            .replace("וּ", "P")
//                            .replace("זּ", "Q")
//                            .replace("טּ", "R")
//                            .replace("יּ", "S")
//                            .replace("ךּ", "T")
//                            .replace("כּ", "U")
//                            .replace("לּ", "V")
//                            .replace("מּ", "W")
//                            .replace("נּ", "X")
//                            .replace("סּ", "Y")
//                            .replace("ףּ", "Z")
//                            .replace("פּ", "0")
//                            .replace("צּ", "1")
//                            .replace("קּ", "2")
//                            .replace("רּ", "3")
//                            .replace("שּ", "4")
//                            .replace("תּ", "5")
//                            .replace("וֹ", "6")
//                            .replace("בֿ", "7")
//                            .replace("כֿ", "8")
//                            .replace("פֿ", "9")
//                            .replace("&NBSP;", ""));
//                }
//                bi.close();
//                String finalContent = fileContent.toString();
//
//                // Update UI inside Platform.runLater()
//                Platform.runLater(() -> {
//                    //System.out.println(finalContent);
//                    lili.setText(finalContent);
//                    webview.getEngine().loadContent(finalContent);
//                });
//
//                // Save content to a file
//                try (OutputStream instreamm = new FileOutputStream(System.getProperty("user.home") + "\\ruoo.ks");
//                     PrintWriter pwe = new PrintWriter(new OutputStreamWriter(instreamm, "UTF-8"))) {
//                    pwe.println(finalContent);
//                }
//                
//                
//                //////////////////////////////////////////////////////////////////////////////////////
//                
//String filePathj = excelfile.getText(); // Get file path from input
//String searchText = nameWithoutExtension; // The text to search for
//
//// ✅ Check if the file is an Excel file (.xlsx or .xls)
//if (!filePathj.toLowerCase().endsWith(".xlsx") && !filePathj.toLowerCase().endsWith(".xls")) {
//   
//   
//   
//  
//}
//
////System.out.println("Processing file: " + filePathj);
////System.out.println("Searching for: " + searchText);
//
//try (FileInputStream fis = new FileInputStream(new File(filePathj));
//     XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//    Sheet sheet = workbook.getSheetAt(0); // Read the first sheet
//
//    for (Row row : sheet) {
//        for (Cell cell : row) {
//            if (cell.getCellType() == CellType.STRING && searchText.equals(cell.getStringCellValue().trim())) {
//                int nextCellIndex = cell.getColumnIndex() + 1; // Get next column index
//                Cell nextCell = row.getCell(nextCellIndex); // Get the next cell
//
//                if (nextCell != null) {
//                    patcchh = (getCellValue(nextCell)).toString();
//                }
//            }
//        }
//    }
//} catch (IOException e) {
//    e.printStackTrace();
//}
//
//    
//
//        
//                
//                /////////////////////////////////////////Plan/////////////////////////////////////////
//      
//                  
//         Platform.runLater(() -> {
//           
//           try{  
//             
//          
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//        
//       
//        
//        //String moodel=model.getSelectionModel().getSelectedItem().toString();
//        //String reciipe=woow;
//      
//////////////////////////////////////////////////
//File inputFile = new File(System.getProperty("user.home")+"\\ruoo.ks"); //
//org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
////Document docj = Jsoup.parse(codee);
//for (Element table : docj.select("TABLE")) {
//for (Element row : table.select("TR")) {
//Elements tds = row.select("TD");
//if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
//}
//else { 
//String string = tds.get(8).text();
//BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Prices.kady"));
//String lines;
//String linebeforeequal;
//String lineafterequal;
//boolean found = false;
//while ((lines = buf.readLine()) != null) {
//linebeforeequal = lines.substring(0, lines.indexOf("=$"));  // Item
//lineafterequal = lines.substring(lines.indexOf("=$") + 2);  // Price
//if (string.equals(linebeforeequal)) {
//l1.getItems().addAll(modelName);
//l2.getItems().addAll(nameWithoutExtension);
//l3.getItems().addAll(patcchh);
//l5.getItems().addAll("KG");
//l6.getItems().addAll(tds.get(7).text());
//l7.getItems().addAll(linebeforeequal);
//l10.getItems().addAll(lineafterequal);
////double number1 = Double.parseDouble(lineafterequal);
////pri1.add(number1);
////String itaam = linebeforeequal;
////nom1.add(itaam);
//found = true;
//break;
//}
//}
//buf.close();   
//}          
////////////////////////KG//////////////////////////
//String skip=tds.get(8).text();
//if (skip.equals("OLD STONE")) {   
//}
//else {
//if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
//else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
//double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
//String amm=Double.toString(am);
//if (amm.contains("E")) { 
//BigDecimal bd = new BigDecimal(amm);
//double val = bd.doubleValue();
//String vallo=Double.toString(val);
////qua1.add(val);
//l4.getItems().addAll(vallo);
//}
//else {
////qua1.add(am);
//l4.getItems().addAll(amm);
//}
//}
//
//else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
//||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
//String sky=tds.get(8).text();
//if (sky.equals("FOAM")) {
//double adddm=(4.0/5.0);
//String zxdz=Double.toString(adddm);
////qua1.add(am);
//l4.getItems().addAll(zxdz);
//}
//else {
//double amld=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
//String ddslsd=Double.toString(amld);
////qua1.add(am);
//l4.getItems().addAll(ddslsd);
//}
//}
//else {
//double number2 = Double.parseDouble(tds.get(5).text());
//String dfgwe=Double.toString(number2);
////qua1.add(number2);
//l4.getItems().addAll(dfgwe);
//}    
//}
////////////////////////////////////////////////
//if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
//}
//else {  
//String string = tds.get(8).text();
//BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Dilution.kady"));
//String linel;
//boolean found = false;
//while ((linel = buf.readLine()) != null) {
//String linebeforeequal = linel.substring(0, linel.indexOf("=")).trim();  // Item
//String lineafterequal = linel.substring(linel.indexOf("=") + 1).trim();  // Dilution
//if (string.equals(linebeforeequal)) {
//double number3 = Double.parseDouble(lineafterequal);
//String dsgfew=Double.toString(number3);
////dil1.add(number3);
//l9.getItems().addAll(dsgfew);
//found = true;
//break;
//}
//}
//if (!found) {
//double number3 = Double.parseDouble("1.0");
//String ty4554=Double.toString(number3);
////dil1.add(number3);
//l9.getItems().addAll(ty4554);
//}
//buf.close();
//}
/////////////////////////////////////////////////
//}}
//
//
//
//
//
//if (l4.getItems().size()!=l10.getItems().size()||l4.getItems().size()!=l9.getItems().size()||l4.getItems().size()!=l7.getItems().size()) { 
//
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//    
//    
//Notifications noti = Notifications.create();
//noti.title("Fatal Error!");
//noti.text("Error - Fix Chemicals First - "+nameWithoutExtension+"\nWe will exit now");
//noti.position(Pos.CENTER);
//noti.hideAfter(Duration.seconds(10));
//noti.showError();
//
//skippp=skippp+1;
//Platform.runLater(() -> {                 
//count3.setText(Integer.toString(skippp));       
//});
//
//
//cancel();  //deprecated
//
//
////messagee=messagee+nameWithoutExtension+"\n";
//
//            
//}
//else {
////Show alert to write pcs.    
//for (int iy = 0; iy < l4.getItems().size(); iy++) {
//double ute1=Double.parseDouble(l4.getItems().get(iy));
//double ute2=Double.parseDouble(l9.getItems().get(iy));
//double ute3=Double.parseDouble(l10.getItems().get(iy));
//double tgewh=(ute1/ute2)*ute3;
//String jhkjh=Double.toString(tgewh);
//l11.getItems().addAll(  jhkjh  );
//
//}
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//       l8.getItems().clear();
//       l3.getSelectionModel().select(0);
//       l4.getSelectionModel().select(0);
//       
//       l11.getSelectionModel().select(0);
//       
//       int ipp=0;
//       
//       while (ipp<l4.getItems().size()) {
//           
//       l3.getSelectionModel().select(ipp);
//       l4.getSelectionModel().select(ipp);
//       
//       l11.getSelectionModel().select(ipp);
//       
//           
//       String c1=l3.getSelectionModel().getSelectedItem().toString();
//       String c2=l4.getSelectionModel().getSelectedItem().toString();
//       
//       String c3=l11.getSelectionModel().getSelectedItem().toString();
//       
//       
//       double x1=Double.parseDouble(c1);
//       double x2=Double.parseDouble(c2);
//       
//       double x3=Double.parseDouble(c3);
//       
//       double res=(x1*x2);
//       
//       double ress=(x1*x3);
//       
//       String result=Double.toString(res);
//       
//       String resultt=Double.toString(ress);
//       
//       l8.getItems().add(result);
//       
//       l12.getItems().add(resultt);
//       
//       ipp++;
//       
//           
//       }
//       //adddbtn.setVisible(true);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//Thread.sleep(500);
//adddbtn.fire();
//
//    }
//          
//           }
//           catch (Exception g) {}
//            
//              });       
//                
//
//                
//                //////////////////////////////////////////////////////////////////////////////////////
// 
//                Thread.sleep(3000); // Sleep for 200ms
//            }
//            return null;
//        }
//    };
//    
//    task.setOnSucceeded(event1 -> {
//        
//        Notifications noti = Notifications.create();
//        noti.title("Successful Operation");
//        noti.text("All Recipes were planned successfully.");
//        noti.hideAfter(Duration.seconds(5));
//        noti.position(Pos.CENTER);
//        noti.showInformation();
//        
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//        webview.getEngine().loadContent("");
//        
//        
//        Platform.runLater(() -> {                 
//        count3.setText(Integer.toString(skippp));       
//        });
//        
////      if (!messagee.equals("")) {
////        
////      Alert alert = new Alert(AlertType.INFORMATION);
////      alert.setTitle("Skipped Recipes");
////      alert.setHeaderText("All below recipes have errors with chemicals");
////      alert.setContentText(messagee+"\n\nPlease call Ahmed Elkady to fix them as soon as possible.");
////      DialogPane dialogPane = alert.getDialogPane();
////      dialogPane.getStylesheets().add(
////      getClass().getResource("primer-dark.css").toExternalForm());
////      alert.showAndWait();
////      
////    }
//        
//    });
//
//    Thread thread = new Thread(task);
//    thread.setDaemon(true); // Make it a daemon thread so it exits when the app closes
//    thread.start();
//
//        
//        
//        
//    }
//    
//    
//    
//        
//    
//}
//
//    
//    


























    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    void quantityyyrel (KeyEvent event)  {
        
        KeyCode fsw=event.getCode();
        
        int qq1=Integer.parseInt(quantityyy.getText());
        int qq2=Integer.parseInt(pcsss.getText());
        
        int qq3=qq1/qq2;
        
        String gg=Integer.toString(qq3);
        
        patch.setText(gg);
        
        
    }
    
    
    
    @FXML
    void pcsssrel (KeyEvent event)  {
        
        
        KeyCode fsw=event.getCode();
        
        int qq1=Integer.parseInt(quantityyy.getText());
        int qq2=Integer.parseInt(pcsss.getText());
        
        int qq3=qq1/qq2;
        
        String gg=Integer.toString(qq3);
        
        patch.setText(gg);
        
        
    }
    
    
    
    
    @FXML
    void browselinkaction(ActionEvent event) throws FileNotFoundException, IOException  {
        
        
        //Browse For Recipe Theb set to recipe combo box
        
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();





        
        l1.getItems().clear();
        l2.getItems().clear();
        l3.getItems().clear();
        l4.getItems().clear();
        l5.getItems().clear();
        l6.getItems().clear();
        l7.getItems().clear();
        l8.getItems().clear();
        l9.getItems().clear();
        l10.getItems().clear();
        l11.getItems().clear();
        l12.getItems().clear();
        
        webview.getEngine().loadContent("");
        //table.getColumns().clear();
        //String selectedItem = recipe.getSelectionModel().getSelectedItem();
        //System.out.println(selectedItem);
        //recipe.getEditor().setText(recipe.getSelectionModel().getSelectedItem().toString());
        
        String path = recipepathy;

        String fileName = Paths.get(path).getFileName().toString(); // ahmed.ks
        String parentFolder = Paths.get(path).getParent().getFileName().toString(); // Ck
        
        String lin1,lin2,lin3;
        lin1=parentFolder;
        lin2=fileName.replace(".ks","").replace(".html","");
        
        model.getSelectionModel().select(lin1);
        recipe.getEditor().setText(lin2);
        woow=lin2;
        
        
        
        //lin3=NewDir.file_dir.replace("X:",drib+":")+"\\PRODUCTION\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe.
        
        //Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(recipepathy);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();


lili.appendText(      
            
             "<style>\n" +
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
            
         );


while ((lo=bi.readLine())!=null) {        
lili.appendText("\n"+lo
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
); 
}
bi.close();
String gf=lili.getText();
///////////Read Here/////////
String coco=gf;
webview.getEngine().loadContent(coco);
/////////////////////////////
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\ruoo.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();
    




//recipe.getEditor().setText(recipenami);
//
//        
//        l1.getItems().clear();
//        l2.getItems().clear();
//        l3.getItems().clear();
//        l4.getItems().clear();
//        l5.getItems().clear();
//        l6.getItems().clear();
//        l7.getItems().clear();
//        l8.getItems().clear();
//        l9.getItems().clear();
//        l10.getItems().clear();
//        l11.getItems().clear();
//        l12.getItems().clear();
//        
//        webview.getEngine().loadContent("");
//        //table.getColumns().clear();
//        
//        
//        String lin1,lin2,lin3;
//        lin1=model.getSelectionModel().getSelectedItem().toString();
//        lin2=recipe.getEditor().getText();
//        
//        
//      //  if (stato.equals("PILOT")) {
//            
//        lin3=NewDir.file_dir.replace("X:",drib+":")+"\\PILOT\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe. 
//            
//      //  }
//        
//      //  else {
//            
//       // lin3=NewDir.file_dir+"\\PRODUCTION\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe.
//            
//       // }
//        
//        //Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//InputStream inputinstream=new FileInputStream(lin3);
//BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//String lo;
//lili.clear();
//
//
//lili.appendText(      
//            
//             "<style>\n" +
//"        body {\n" +
//"            user-select: none;\n" +
//"            -webkit-user-select: none;\n" +
//"            -moz-user-select: none;\n" +
//"            -ms-user-select: none;\n" +
//"        }\n" +
//"    </style>"
//            
//          +"<script>\n" +
//"        document.addEventListener('dragstart', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('drop', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('contextmenu', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"  
//            
//            + "<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//             + ""
//            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
//            + ""
//            + "<script>\n" +
//"            \n" +
//"            document.addEventListener('keydown', event => {\n" +
//"  console.log(`User pressed: ${event.key}`);\n" +
//"  event.preventDefault();\n" +
//"  return false;\n" +
//"});\n" +
//"            \n" +
//"            </script>"
//            
//       +"<script>\n" +
//"        document.addEventListener('keydown', function (event) {\n" +
//"            // Disable specific keys or key combinations\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"     
//            
//         );
//
//while ((lo=bi.readLine())!=null) {        
//lili.appendText("\n"+lo
//.replace("ﬦ","A")
//.replace("ﬧ","B")
//.replace("ﬨ","C")
//.replace("﬩","D")
//.replace("שׁ","E")    
//.replace("שׂ","F")        
//.replace("שּׁ","G")         
//.replace("שּׂ","H")         
//.replace("אַ","I")         
//.replace("אָ","J")         
//.replace("אּ","K")         
//.replace("בּ","L")         
//.replace("גּ","M")         
//.replace("דּ","N")         
//.replace("הּ","O")         
//.replace("וּ","P")         
//.replace("זּ","Q")         
//.replace("טּ","R")         
//.replace("יּ","S")         
//.replace("ךּ","T")         
//.replace("כּ","U")         
//.replace("לּ","V")
//.replace("מּ","W")         
//.replace("נּ","X")         
//.replace("סּ","Y")         
//.replace("ףּ","Z")         
//.replace("פּ","0")         
//.replace("צּ","1")         
//.replace("קּ","2")         
//.replace("רּ","3")         
//.replace("שּ","4")         
//.replace("תּ","5")         
//.replace("וֹ","6")         
//.replace("בֿ","7")         
//.replace("כֿ","8")
//.replace("פֿ","9")
//.replace("&NBSP;","")                       
//); 
//}
//bi.close();
//String gf=lili.getText();
/////////////Read Here/////////
//String coco=gf;
//webview.getEngine().loadContent(coco);
///////////////////////////////
//OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\ruoo.ks");
//PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
//pwe.println(gf);
//pwe.close();
//    
//        
//stato="PILOT";
//        
        
    }
    
    
    
    
    
    
    @FXML
    void deletebtnaction(ActionEvent event) {
        
        
        deleteSelectedRows();
        
        
        
    }
    
    
    
    
    
    @FXML
    void exportbtnaction(ActionEvent event) throws FileNotFoundException, IOException  {
        
    
        /////////////////////////////////////////////////////////////////////////
      
     
            // Open FileChooser to save or load the Excel file
            
            if (sheetpas.equals(".")) {
              
                try {
                    
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
            dialog.setInitialFileName("Chemical_Plan");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
            File dialogResult = dialog.showSaveDialog(null);
            
            

            // Check if a file was chosen
            if (dialogResult != null) {
                String filePath = dialogResult.getAbsolutePath();
                
                sheetpas=filePath;
                
                XSSFWorkbook workbook;
                XSSFSheet sheet;

                File file = new File(filePath);
                // If the file already exists, open it, otherwise create a new workbook and sheet
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    workbook = new XSSFWorkbook(fis);
                    fis.close(); // Close input stream after loading
                } else {
                    workbook = new XSSFWorkbook(); // Create new workbook
                }
                
                
                
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:13;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Name");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Name");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("primer-dark.css").toExternalForm());
        alo.showAndWait();
        sheetnam=gr.getText();
                
      
             
                // Get or create the "KADY" sheet
                sheet = workbook.getSheet(gr.getText());
                if (sheet == null) {
                sheet = workbook.createSheet(gr.getText());
                }

                // Find the last row
                int lastRowNum = sheet.getLastRowNum();
                
                // Start writing from the next row
                Row row = sheet.createRow(lastRowNum + 1);

                // Assuming 'table' is a reference to a TableView in your JavaFX app
                for (int j = 0; j < table.getColumns().size(); j++) {
                    row.createCell(j).setCellValue(table.getColumns().get(j).getText());
                }

                // Iterate through table rows and write them to the Excel sheet
                for (int i = 0; i < table.getItems().size(); i++) {
                    row = sheet.createRow(i + lastRowNum + 1); // Continue writing after the last row
                    for (int j = 0; j < table.getColumns().size(); j++) {
                        Object cellData = table.getColumns().get(j).getCellData(i);
                        if (cellData != null) {
                            row.createCell(j).setCellValue(cellData.toString());
                        } else {
                            row.createCell(j).setCellValue("");
                        }
                    }
                }

                // Write the changes back to the file
                FileOutputStream fileOut = new FileOutputStream(filePath);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We wrote everything successfully!.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
      
      sheetpas=".";

                // Open the Excel file after saving
              //  Desktop desktop = Desktop.getDesktop();
              //  desktop.open(new File(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            
                    
                
                
                
            }
            
            
            
            
            else {
                
                
                    try {
            

        
                XSSFWorkbook workbook;
                XSSFSheet sheet;

                File file = new File(sheetpas);
                // If the file already exists, open it, otherwise create a new workbook and sheet
                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    workbook = new XSSFWorkbook(fis);
                    fis.close(); // Close input stream after loading
                } else {
                    workbook = new XSSFWorkbook(); // Create new workbook
                }
                
             
                // Get or create the "KADY" sheet
                sheet = workbook.getSheet(sheetnam);
                if (sheet == null) {
                    sheet = workbook.createSheet(sheetnam);
                }

                // Find the last row
                int lastRowNum = sheet.getLastRowNum();
                
                // Start writing from the next row
                Row row = sheet.createRow(lastRowNum + 1);

                // Assuming 'table' is a reference to a TableView in your JavaFX app
                for (int j = 0; j < table.getColumns().size(); j++) {
                    row.createCell(j).setCellValue(table.getColumns().get(j).getText());
                }

                // Iterate through table rows and write them to the Excel sheet
                for (int i = 0; i < table.getItems().size(); i++) {
                    row = sheet.createRow(i + lastRowNum + 1); // Continue writing after the last row
                    for (int j = 0; j < table.getColumns().size(); j++) {
                        Object cellData = table.getColumns().get(j).getCellData(i);
                        if (cellData != null) {
                            row.createCell(j).setCellValue(cellData.toString());
                        } else {
                            row.createCell(j).setCellValue("");
                        }
                    }
                }

                // Write the changes back to the file
                FileOutputStream fileOut = new FileOutputStream(sheetpas);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We wrote everything successfully!.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
      
      sheetpas=".";

                // Open the Excel file after saving
              //  Desktop desktop = Desktop.getDesktop();
              //  desktop.open(new File(filePath));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
                
                
                
                
            }
            
            
         
        /////////////////////////////////////////////////////////////////////////
           
        
    }
    
    
    @FXML
    void adddbtnaction(ActionEvent event) {
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
       int ippp=0;
       
       
       
       while (ippp<l4.getItems().size()) {
           
       l1.getSelectionModel().select(ippp);
       l2.getSelectionModel().select(ippp);
       l3.getSelectionModel().select(ippp);
       l4.getSelectionModel().select(ippp);
       l5.getSelectionModel().select(ippp);
       l6.getSelectionModel().select(ippp);
       l7.getSelectionModel().select(ippp);
       l8.getSelectionModel().select(ippp);
       l9.getSelectionModel().select(ippp);
       l10.getSelectionModel().select(ippp);
       l11.getSelectionModel().select(ippp);
       l12.getSelectionModel().select(ippp);
       
       
       String mnm=monthtf.getText();
           
       String c1=l1.getSelectionModel().getSelectedItem().toString();
       String c2=l2.getSelectionModel().getSelectedItem().toString();
       String c3=l3.getSelectionModel().getSelectedItem().toString();
       String c4=l4.getSelectionModel().getSelectedItem().toString();
       String c5=l5.getSelectionModel().getSelectedItem().toString();
       String c6=l6.getSelectionModel().getSelectedItem().toString();
       String c7=l7.getSelectionModel().getSelectedItem().toString();
       String c8=l8.getSelectionModel().getSelectedItem().toString();
       String c9=l9.getSelectionModel().getSelectedItem().toString();
       String c10=l10.getSelectionModel().getSelectedItem().toString();
       String c11=l11.getSelectionModel().getSelectedItem().toString();
       String c12=l12.getSelectionModel().getSelectedItem().toString();
       
      
       
       addRow(mnm,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
       
       ippp++;
       
           
       }
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    }
    
    
    public static int levenshteinDistance(String a, String b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];

    for (int i = 0; i <= a.length(); i++) {
        for (int j = 0; j <= b.length(); j++) {
            if (i == 0) {
                dp[i][j] = j;
            } else if (j == 0) {
                dp[i][j] = i;
            } else {
                dp[i][j] = Math.min(
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                    dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1)
                );
            }
        }
    }
    return dp[a.length()][b.length()];
}
    

    @FXML
    void fixchemicaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException  {
        
        
        
        
        
 //   Task<Void> taskk = new Task<Void>() {
   //     @Override
     //   protected Void call() throws Exception {
          
            
            for (int i = 0; i < recipelistall.getItems().size(); i++) {
              //  if (isCancelled()) break;
                
               
                //All code goes here
                
                String filePath = recipelistall.getItems().get(i); // Path
                Path path = Paths.get(filePath);
                String fileName = path.getFileName().toString();
                nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf(".")); // Names
                System.out.println(nameWithoutExtension);
                int count = path.getNameCount();
                if (count >= 2) { // Ensure there is at least one parent folder before the filename
                modelName = path.getName(count - 2).toString();
                System.out.println(modelName);
                } else {}
                
          
    lili.clear();
    InputStream inputinstream=new FileInputStream(recipelistall.getItems().get(i));
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        lili.appendText(liin.replace("ﬦ","A")
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
       .replace("&NBSP;","") +"\n");
    }
    bufy.close();
    
    
    
//    String code = lili.getText();
//      if (!code.contains("TABLE")) {
//      Notifications noti = Notifications.create();
//      noti.title("Recipe Error");
//      noti.text("Maybe not a recipe, Open a recipe first!.");
//      noti.hideAfter(Duration.seconds(3));
//      noti.position(Pos.CENTER);
//      noti.showError();    
//        }
//        else {
//            org.jsoup.nodes.Document doc = Jsoup.parse(code);
//        for (Element table : doc.select("TABLE")) {
//        for (Element row : table.select("TR")) {
//            Elements tds = row.select("TD");
//            if (tds.get(7).text().isEmpty()) {   
//            }
//            else {  
//            ///////////////////////////////////////////////////////////////
//String string=tds.get(7).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {
//linebeforeequal=line.substring(0,line.indexOf("=")-0);
//lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
//if (string.equals(lineafterequal)) {
////System.out.println(string+" = "+linebeforeequal);
//String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
//tds.get(8).html(formattedText); // Use .html() instead of .text()     
////tds.get(8).text(linebeforeequal);
////System.out.println(tds.get(8).text());
//break;
//
//    }
//    else {
//        
//    }
//    
//}
//buf.close();
//
//             ///////////////////////////////////////////////////////////////
//               
//            }   
//         
//         
//        }}
//       lili.setText(doc.toString());
//        }



String code = lili.getText();
    
    if (!code.contains("TABLE")) {
        Notifications noti = Notifications.create();
        noti.title("Recipe Error");
        noti.text("Maybe not a recipe, Open a recipe first!.");
        noti.hideAfter(Duration.seconds(3));
        noti.position(Pos.CENTER);
        noti.showError();
    } else {
        org.jsoup.nodes.Document doc = Jsoup.parse(code);

        for (Element table : doc.select("TABLE")) {
            for (Element row : table.select("TR")) {
                Elements tds = row.select("TD");

                if (!tds.get(7).text().isEmpty()) {
                    String string = tds.get(7).text();
                    BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
                    String line;
                    String linebeforeequal = null;
                    String lineafterequal;
                    String bestMatch = null;
                    int minDistance = Integer.MAX_VALUE; // أقرب تشابه

                    while ((line = buf.readLine()) != null) {
                        linebeforeequal = line.substring(0, line.indexOf("="));
                        lineafterequal = line.substring(line.indexOf("=") + 1);

                        if (string.equalsIgnoreCase(lineafterequal)) {
                            bestMatch = linebeforeequal;
                            break;
                        } else {
                            int distance = levenshteinDistance(string, lineafterequal);
                            if (distance < minDistance) {
                                minDistance = distance;
                                bestMatch = linebeforeequal;
                            }
                        }
                    }
                    buf.close();

                    if (bestMatch != null) {
                        String formattedText = "<b style='display:block; text-align:center;'>" + bestMatch + "</b>";
                        tds.get(8).html(formattedText);
                    }
                }
            }
        }
        lili.setText(doc.toString());
    }






        
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=lili.getText();
    System.out.println(newrecipecode);
    
    String pos1=System.getProperty("user.home")+"\\Desktop\\Fixed_Recipes";
    File fos1=new File (pos1);
    if (!fos1.exists()) {
        fos1.mkdir();
    }
    File fos2=new File (fos1+"\\"+modelName);
    if (!fos2.exists()) {
        fos2.mkdir();
    }
    File fos3=new File (fos2+"\\"+nameWithoutExtension+".ks");
    if (!fos3.exists()) {
        fos3.createNewFile();
    }
    
    
    OutputStream instreamm=new FileOutputStream(fos3);
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode.replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ"));
       pwwc.close();
    
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We updated everything successfully!.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
    
                
                
          
                
            //    Thread.sleep(500); // Sleep for 200ms
          //  }
          //  return null;
        }
  //  };
    
//    taskk.setOnSucceeded(event1 -> {
//        
//        Notifications noti = Notifications.create();
//        noti.title("Successful Operation");
//        noti.text("All Recipes were Fixed successfully.");
//        noti.hideAfter(Duration.seconds(5));
//        noti.position(Pos.CENTER);
//        noti.showInformation();
//        
//    });
//
//    Thread thread = new Thread(taskk);
//    thread.setDaemon(true); // Make it a daemon thread so it exits when the app closes
//    thread.start();
    
   
        
        
        
        
        
        
        
//        
//        String lin1,lin2,lin3;
//        lin1=model.getSelectionModel().getSelectedItem().toString();
//        lin2=woow;
//        //lin3=NewDir.file_dir+"\\PRODUCTION\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe.
//        
//        
//         if (stato.equals("PILOT")) {
//            
//        lin3=NewDir.file_dir.replace("X:",drib+":")+"\\PILOT\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe. 
//            
//        }
//        
//        else {
//            
//        lin3=NewDir.file_dir.replace("X:",drib+":")+"\\PRODUCTION\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe.
//            
//        }
//        
//        
//    lili.clear();
//    
//    InputStream inputinstream=new FileInputStream(lin3);
//    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//    
//    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
//    String liin;
//    
//    lili.appendText(      
//            
//             "<style>\n" +
//"        body {\n" +
//"            user-select: none;\n" +
//"            -webkit-user-select: none;\n" +
//"            -moz-user-select: none;\n" +
//"            -ms-user-select: none;\n" +
//"        }\n" +
//"    </style>"
//            
//          +"<script>\n" +
//"        document.addEventListener('dragstart', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('drop', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('contextmenu', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"  
//            
//            + "<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//             + ""
//            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
//            + ""
//            + "<script>\n" +
//"            \n" +
//"            document.addEventListener('keydown', event => {\n" +
//"  console.log(`User pressed: ${event.key}`);\n" +
//"  event.preventDefault();\n" +
//"  return false;\n" +
//"});\n" +
//"            \n" +
//"            </script>"
//            
//       +"<script>\n" +
//"        document.addEventListener('keydown', function (event) {\n" +
//"            // Disable specific keys or key combinations\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"     
//            
//         );
//
//    
//    
//    while ((liin=bufy.readLine())!=null) {
//        lili.appendText(liin.replace("ﬦ","A")
//       .replace("ﬧ","B")
//       .replace("ﬨ","C")
//       .replace("﬩","D")
//       .replace("שׁ","E")    
//       .replace("שׂ","F")        
//       .replace("שּׁ","G")         
//       .replace("שּׂ","H")         
//       .replace("אַ","I")         
//       .replace("אָ","J")         
//       .replace("אּ","K")         
//       .replace("בּ","L")         
//       .replace("גּ","M")         
//       .replace("דּ","N")         
//       .replace("הּ","O")         
//       .replace("וּ","P")         
//       .replace("זּ","Q")         
//       .replace("טּ","R")         
//       .replace("יּ","S")         
//       .replace("ךּ","T")         
//       .replace("כּ","U")         
//       .replace("לּ","V")
//       .replace("מּ","W")         
//       .replace("נּ","X")         
//       .replace("סּ","Y")         
//       .replace("ףּ","Z")         
//       .replace("פּ","0")         
//       .replace("צּ","1")         
//       .replace("קּ","2")         
//       .replace("רּ","3")         
//       .replace("שּ","4")         
//       .replace("תּ","5")         
//       .replace("וֹ","6")         
//       .replace("בֿ","7")         
//       .replace("כֿ","8")
//       .replace("פֿ","9")
//       .replace("&NBSP;","") +"\n");
//    }
//    bufy.close();
//    String code = lili.getText();
//      if (!code.contains("TABLE")) {
//      Notifications noti = Notifications.create();
//      noti.title("Recipe Error");
//      noti.text("Maybe not a recipe, Open a recipe first!.");
//      noti.hideAfter(Duration.seconds(3));
//      noti.position(Pos.CENTER);
//      noti.showError();    
//        }
//        else {
//            org.jsoup.nodes.Document doc = Jsoup.parse(code);
//        for (Element table : doc.select("TABLE")) {
//        for (Element row : table.select("TR")) {
//            Elements tds = row.select("TD");
//            if (tds.get(7).text().isEmpty()) {   
//            }
//            else {  
//             ///////////////////////////////////////////////////////////////
//String string=tds.get(7).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {
//linebeforeequal=line.substring(0,line.indexOf("=")-0);
//lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
//if (string.equals(lineafterequal)) {
////System.out.println(string+" = "+linebeforeequal);
//tds.get(8).text(linebeforeequal);
////System.out.println(tds.get(8).text());
//break;
//
//    }
//    else {
//        
//    }
//    
//}
//buf.close();
//
//             ///////////////////////////////////////////////////////////////
//               
//            }   
//         
//         
//        }}
//       lili.setText(doc.toString());
//        }
//        
//    ////////////////////////////////////////////////////////////////////////////    
//    String newrecipecode=lili.getText();
//    
//    OutputStream instreamm=new FileOutputStream(lin3);
//    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
//    
//    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
//    pwwc.println(newrecipecode.replace("A","ﬦ")
//       .replace("B","ﬧ")
//       .replace("C","ﬨ")
//       .replace("D","﬩")
//       .replace("E","שׁ")    
//       .replace("F","שׂ")        
//       .replace("G","שּׁ")         
//       .replace("H","שּׂ")         
//       .replace("I","אַ")         
//       .replace("J","אָ")         
//       .replace("K","אּ")         
//       .replace("L","בּ")         
//       .replace("M","גּ")         
//       .replace("N","דּ")         
//       .replace("O","הּ")         
//       .replace("P","וּ")         
//       .replace("Q","זּ")         
//       .replace("R","טּ")         
//       .replace("S","יּ")         
//       .replace("T","ךּ")         
//       .replace("U","כּ")         
//       .replace("V","לּ")
//       .replace("W","מּ")         
//       .replace("X","נּ")         
//       .replace("Y","סּ")         
//       .replace("Z","ףּ")
//                
//       .replace("0","פּ")         
//       .replace("1","צּ")         
//       .replace("2","קּ")         
//       .replace("3","רּ")         
//       .replace("4","שּ")         
//       .replace("5","תּ")         
//       .replace("6","וֹ")         
//       .replace("7","בֿ")         
//       .replace("8","כֿ")
//       .replace("9","פֿ")
//                
//       .replace("a","ﬦ")
//       .replace("b","ﬧ")
//       .replace("c","ﬨ")
//       .replace("d","﬩")
//       .replace("e","שׁ")    
//       .replace("f","שׂ")        
//       .replace("g","שּׁ")         
//       .replace("h","שּׂ")         
//       .replace("i","אַ")         
//       .replace("j","אָ")         
//       .replace("k","אּ")         
//       .replace("l","בּ")         
//       .replace("m","גּ")         
//       .replace("n","דּ")         
//       .replace("o","הּ")         
//       .replace("p","וּ")         
//       .replace("q","זּ")         
//       .replace("r","טּ")         
//       .replace("s","יּ")         
//       .replace("t","ךּ")         
//       .replace("u","כּ")         
//       .replace("v","לּ")
//       .replace("w","מּ")         
//       .replace("x","נּ")         
//       .replace("y","סּ")         
//       .replace("z","ףּ"));
//    pwwc.close();
//    
//      Notifications noti = Notifications.create();
//      noti.title("Successful Operation");
//      noti.text("We updated everything successfully!.\nRecipe will open now.");
//      noti.hideAfter(Duration.seconds(5));
//      noti.position(Pos.CENTER);
//      noti.showInformation();
    
        
        
    }
        
    
    
    @FXML
    void clearalaction(ActionEvent event)  {
        
        l1.getItems().clear();
        l2.getItems().clear();
        l3.getItems().clear();
        l4.getItems().clear();
        l5.getItems().clear();
        l6.getItems().clear();
        l7.getItems().clear();
        l8.getItems().clear();
        l9.getItems().clear();
        l10.getItems().clear();
        l11.getItems().clear();
        l12.getItems().clear();
        model.getSelectionModel().clearSelection();
        recipe.getEditor().clear();
        //patch.clear();
        webview.getEngine().loadContent("");
        //table.getColumns().clear();
        
    }
    
    
    
    @FXML
    void getaction(ActionEvent event) throws FileNotFoundException, IOException {
  
        l1.getItems().clear();
        l2.getItems().clear();
        l3.getItems().clear();
        l4.getItems().clear();
        l5.getItems().clear();
        l6.getItems().clear();
        l7.getItems().clear();
        l8.getItems().clear();
        l9.getItems().clear();
        l10.getItems().clear();
        l11.getItems().clear();
        l12.getItems().clear();
        
        String moodel=model.getSelectionModel().getSelectedItem().toString();
        String reciipe=woow;
        String patcch=patch.getText();
        int potch=Integer.parseInt(patcch);
      
////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\ruoo.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
}
else { 
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
boolean found = false;
while ((line = buf.readLine()) != null) {
linebeforeequal = line.substring(0, line.indexOf("=$"));  // Item
lineafterequal = line.substring(line.indexOf("=$") + 2);  // Price
if (string.equals(linebeforeequal)) {
l1.getItems().addAll(moodel);
l2.getItems().addAll(reciipe);
l3.getItems().addAll(patcch);
l5.getItems().addAll("KG");
l6.getItems().addAll(tds.get(7).text());

l7.getItems().addAll(linebeforeequal);
l10.getItems().addAll(lineafterequal);
//double number1 = Double.parseDouble(lineafterequal);
//pri1.add(number1);
//String itaam = linebeforeequal;
//nom1.add(itaam);
found = true;
break;
}
}
buf.close();   
}          
//////////////////////KG//////////////////////////
String skip=tds.get(8).text();
if (skip.equals("OLD STONE")) {   
}
else {
if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
String amm=Double.toString(am);
if (amm.contains("E")) { 
BigDecimal bd = new BigDecimal(amm);
double val = bd.doubleValue();
String vallo=Double.toString(val);
//qua1.add(val);
l4.getItems().addAll(vallo);
}
else {
//qua1.add(am);
l4.getItems().addAll(amm);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double adddm=(4.0/5.0);
String zxdz=Double.toString(adddm);
//qua1.add(am);
l4.getItems().addAll(zxdz);
}
else {
double amld=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
String ddslsd=Double.toString(amld);
//qua1.add(am);
l4.getItems().addAll(ddslsd);
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
String dfgwe=Double.toString(number2);
//qua1.add(number2);
l4.getItems().addAll(dfgwe);
}    
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
}
else {  
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr.replace("X:",drib+":") + "\\Recipe_Indexes\\Dilution.kady"));
String line;
boolean found = false;
while ((line = buf.readLine()) != null) {
String linebeforeequal = line.substring(0, line.indexOf("=")).trim();  // Item
String lineafterequal = line.substring(line.indexOf("=") + 1).trim();  // Dilution
if (string.equals(linebeforeequal)) {
double number3 = Double.parseDouble(lineafterequal);
String dsgfew=Double.toString(number3);
//dil1.add(number3);
l9.getItems().addAll(dsgfew);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
String ty4554=Double.toString(number3);
//dil1.add(number3);
l9.getItems().addAll(ty4554);
}
buf.close();
}
///////////////////////////////////////////////
}}





if (l4.getItems().size()!=l10.getItems().size()||l4.getItems().size()!=l9.getItems().size()||l4.getItems().size()!=l7.getItems().size()) { 

        l1.getItems().clear();
        l2.getItems().clear();
        l3.getItems().clear();
        l4.getItems().clear();
        l5.getItems().clear();
        l6.getItems().clear();
        l7.getItems().clear();
        l8.getItems().clear();
        l9.getItems().clear();
        l10.getItems().clear();
        l11.getItems().clear();
        l12.getItems().clear();
    
    
Notifications noti = Notifications.create();
noti.title("Fatal Error!");
noti.text("Error - Fix Chemicals First!");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(5));
noti.showError();


  
            
}
else {
//Show alert to write pcs.    
for (int i = 0; i < l4.getItems().size(); i++) {
double ute1=Double.parseDouble(l4.getItems().get(i));
double ute2=Double.parseDouble(l9.getItems().get(i));
double ute3=Double.parseDouble(l10.getItems().get(i));
double tgewh=(ute1/ute2)*ute3;
String jhkjh=Double.toString(tgewh);
l11.getItems().addAll(  jhkjh  );

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       l8.getItems().clear();
       l3.getSelectionModel().select(0);
       l4.getSelectionModel().select(0);
       
       l11.getSelectionModel().select(0);
       
       int ipp=0;
       
       while (ipp<l4.getItems().size()) {
           
       l3.getSelectionModel().select(ipp);
       l4.getSelectionModel().select(ipp);
       
       l11.getSelectionModel().select(ipp);
       
           
       String c1=l3.getSelectionModel().getSelectedItem().toString();
       String c2=l4.getSelectionModel().getSelectedItem().toString();
       
       String c3=l11.getSelectionModel().getSelectedItem().toString();
       
       
       double x1=Double.parseDouble(c1);
       double x2=Double.parseDouble(c2);
       
       double x3=Double.parseDouble(c3);
       
       double res=(x1*x2);
       
       double ress=(x1*x3);
       
       String result=Double.toString(res);
       
       String resultt=Double.toString(ress);
       
       l8.getItems().add(result);
       
       l12.getItems().add(resultt);
       
       ipp++;
       
           
       }
       adddbtn.setVisible(true);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    }

        
        
        
        
    }
    
    
//    @FXML
//    void quantityrel(KeyEvent event) {
//
//        int qq=Integer.parseInt(quantity1.getText());
//        int nn=Integer.parseInt(mno1.getText());
//        
//        int newpp=qq/nn;
//        
//        patch1.setText(Integer.toString(newpp));
//        
//        
//    }

//    @FXML
//    void qurel(KeyEvent event) {
//
//        int qq=Integer.parseInt(quantity.getText());
//        int nn=Integer.parseInt(mno.getText());
//        
//        int newpp=qq/nn;
//        
//        patch.setText(Integer.toString(newpp));
//        
//        
//    }
    
    
    
    
    
//    @FXML
//    void getnewaction(ActionEvent event) {
//
//        
//        
//        getnewpane.setVisible(true);
//        getoldpane.setVisible(false);
//        oldypane.setVisible(false);
//        webview.setVisible(true);
//        
//        opennewrecipeadv.setDisable(false);
//        recentfiles.setDisable(false);
//        savetodb.setDisable(false);
//        
//        exporttomenu.setDisable(true);
//        
//        
//        
//        
//    }

    
    
    
    
//    
//    @FXML
//    void getoldaction(ActionEvent event) {
//
//        
//        
//        getnewpane.setVisible(false);
//        getoldpane.setVisible(true);
//        oldypane.setVisible(true);
//        webview.setVisible(false);
//        
//        opennewrecipeadv.setDisable(true);
//        recentfiles.setDisable(true);
//        savetodb.setDisable(true);
//        
//        exporttomenu.setDisable(false);
//        
//        
//    }

    
   @FXML
    void amountrell(KeyEvent event) { 
    }
         
    
    
@FXML
    void totrel(KeyEvent event) {   
    }
    
//    
//
//    @FXML
//    void readoutrecipeaction1(Event event) {
//    }
//
//    
    
    
//
//    @FXML
//    void readrecipeaction1(Event event) throws ClassNotFoundException, SQLException {
//
//   
//// recipe1.getItems().clear();
//    
//     try {
//         
//    String sql = "select DISTINCT Wash_Name from Chemical_Plan ORDER BY Wash_Name";
//    pst = conn.prepareStatement(sql);
//    rs = pst.executeQuery();
//    
//    while (rs.next()) {
////        String io=rs.getString("Wash_Name");
////        if (io.equals(io)) {
////            recipe1.getItems().add(io);
////            continue;
////        }
////        else {
////            recipe1.getItems().add(io);
////        }
//      //  recipe1.getItems().addAll(rs.getString("Wash_Name"));
//        
//    }
//    
//        
//    }
//    catch (Exception m) {
//        
//    }
//    
//   
//      
//           
//    finally {
//            try{
//                rs.close();
//                pst.close();
//            }
//            catch(Exception e){    
//            }
//            
//    }
//    
//
//
//        
//        
//        
//    }

    
    
//    @FXML
//    void exporttoexcelaction(ActionEvent event) throws FileNotFoundException, IOException {
//    }
//    
//    
//
//    @FXML
//    void displaydataaction(ActionEvent event) throws IOException {
//
//        //FXML 
//        
//    Stage kady = new Stage();
//    Parent root = FXMLLoader.<Parent>load(getClass().getResource("DisplayChemicalPlan.fxml"));
//    Scene scene = new Scene(root);
//    kady.setTitle("Chemical Plan Viewer");
//    kady.centerOnScreen();
//    kady.setResizable(false);
//    kady.centerOnScreen();
//    kady.setScene(scene);
//    kady.show();
////    Stage jk = (Stage)this.date.getScene().getWindow();
////    jk.setIconified(true);
//        
//        
//    }
//    
    
    
//    @FXML
//    void exporttodbaction(ActionEvent event) {  
//    }
//    
//    
//
//    @FXML
//    void fullreportaction(ActionEvent event) {  
//    }
//
//    @FXML
//    void opennewrecipeadvaction(ActionEvent event) {   
//    }

    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @FXML
    void readmodelaction(Event event) {

         this.model.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(models_file_path));
      String line;
      while ((line = buf.readLine()) != null) {
        this.model.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        
    }

    @FXML
    void readoutmodelaction(Event event) {

        
        recipe.getItems().clear();
        
    }

    
    
    @FXML
    void readoutrecipeaction(Event event) throws FileNotFoundException, IOException {

        
        l1.getItems().clear();
        l2.getItems().clear();
        l3.getItems().clear();
        l4.getItems().clear();
        l5.getItems().clear();
        l6.getItems().clear();
        l7.getItems().clear();
        l8.getItems().clear();
        l9.getItems().clear();
        l10.getItems().clear();
        l11.getItems().clear();
        l12.getItems().clear();
        
        webview.getEngine().loadContent("");
        //table.getColumns().clear();
        
          String selectedItem = recipe.getSelectionModel().getSelectedItem();

System.out.println(selectedItem);
        
        recipe.getEditor().setText(recipe.getSelectionModel().getSelectedItem().toString());
        
        String lin1,lin2,lin3;
        lin1=model.getSelectionModel().getSelectedItem().toString();
        lin2=recipe.getSelectionModel().getSelectedItem().toString();
        lin3=NewDir.file_dir.replace("X:",drib+":")+"\\PRODUCTION\\"+lin1+"\\"+lin2+".ks";  //Path To Recipe.
        
        //Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(lin3);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();


lili.appendText(      
            
             "<style>\n" +
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
            
         );


while ((lo=bi.readLine())!=null) {        
lili.appendText("\n"+lo
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
); 
}
bi.close();
String gf=lili.getText();
///////////Read Here/////////
String coco=gf;
webview.getEngine().loadContent(coco);
/////////////////////////////
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\ruoo.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();
    
        
    }

    
    
    
     @FXML
    void readrecipeaction(Event event) throws ClassNotFoundException, SQLException {
      
    }

  
    
    
    
    
    
    
    
   
    
    

    @FXML
    void savetodbaction(ActionEvent event) {
    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = DateFormat.getDateInstance();
            String dateString = df.format(currentDate);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            String timeString = sdf.format(d);
            String dayoftoday = timeString;
            //date.setText(dayoftoday);
            //date1.setText(dayoftoday);
            
        LocalDate today = LocalDate.now();
        int monthNumber = today.getMonthValue(); // 1 = January, 12 = December
        monthtf.setText(Integer.toString(monthNumber));
     
        this.conn = db.java_db();
        
        
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
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("cupertino-dark.css").toExternalForm());
      alert.showAndWait();
      
      Stage jk = (Stage)this.patch.getScene().getWindow();
      jk.close();
          }
        
       
     
    models_file_path=NewDir.file_dirr.replace("X:",drib+":")+"\\Models.kady";
    recipes_folder=NewDir.file_dir.replace("X:",drib+":");
    
    
        /////////////////////////////////////////////////////////////////////////////////////////////////
        
        dataaa = FXCollections.observableArrayList();
        
        TableColumn<ObservableList<String>, String> Col0 = new TableColumn<>("Month");
        Col0.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(0)));
         
        TableColumn<ObservableList<String>, String> Col1 = new TableColumn<>("Model");
        Col1.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(1)));

        TableColumn<ObservableList<String>, String> Col2 = new TableColumn<>("Wash Name");
        Col2.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(2)));
        
        TableColumn<ObservableList<String>, String> Col3 = new TableColumn<>("Patch");
        Col3.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(3)));
        
        TableColumn<ObservableList<String>, String> Col4 = new TableColumn<>("Quantity");
        Col4.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(4)));
        
        TableColumn<ObservableList<String>, String> Col5 = new TableColumn<>("Units");
        Col5.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(5)));
        
        TableColumn<ObservableList<String>, String> Col6 = new TableColumn<>("Chemicals");
        Col6.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(6)));
        
        TableColumn<ObservableList<String>, String> Col7 = new TableColumn<>("Chemical Names");
        Col7.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(7)));
        
        TableColumn<ObservableList<String>, String> Col8 = new TableColumn<>("Total Quantities");
        Col8.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(8)));
        
        TableColumn<ObservableList<String>, String> Col9 = new TableColumn<>("Dilution");
        Col9.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(9)));
        
        TableColumn<ObservableList<String>, String> Col10 = new TableColumn<>("Price");
        Col10.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(10)));
        
        TableColumn<ObservableList<String>, String> Col11 = new TableColumn<>("Unit Price");
        Col11.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(11)));
        
        TableColumn<ObservableList<String>, String> Col12 = new TableColumn<>("Total Price");
        Col12.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(12)));

        
        
        table.getColumns().addAll(Col0,Col1, Col2, Col3, Col4, Col5, Col6, Col7, Col8, Col9, Col10, Col11,Col12);
        table.setItems(dataaa);
        
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        TableFilter filter = new TableFilter(table);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        
        
          executorService = Executors.newSingleThreadScheduledExecutor();

        // Load items when the ComboBox is opened
        recipe.setOnShowing(event -> loadAllItems());

        // Listener for text changes in the ComboBox editor
        recipe.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
            String modell = model.getSelectionModel().getSelectedItem(); // Get selected model
            if (modell == null) return; // Ensure a model is selected

            // Load filtered items based on the current text input
            loadFilteredItems(modell, newValue.trim());
        });

        // Listener for item selection in the ComboBox
        recipe.setOnAction(this::handleRecipeSelection);
        
     
        skiperr.setOnAction(sdfds -> {
    
    skiperr.setSelected(true);
    
    if (!skiperr.isSelected()) {
        
        skiperr.setSelected(true);
        return;
        
    }
    
    skiperr.setSelected(true);
    
    
});
   
        
   
    }
    
    

 // Method to load all items for the ComboBox based on the selected model
    private void loadAllItems() {
        String modell = model.getSelectionModel().getSelectedItem();
        if (modell == null) return; // Prevent NullPointerException

        // Execute loading in a separate thread
        executorService.execute(() -> {
            try {
                String sql = "SELECT * FROM Creation WHERE Model=?";
                try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setString(1, modell);
                    try (ResultSet rs = pst.executeQuery()) {
                        // Clear previous items in the UI thread
                        Platform.runLater(() -> recipe.getItems().clear());
                        while (rs.next()) {
                            String name = rs.getString("Name");
                            // Ensure that UI updates are done on the JavaFX thread
                            Platform.runLater(() -> recipe.getItems().add(name));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log exceptions for debugging
            }
        });
    }

    // Method to load filtered items based on user input
    private void loadFilteredItems(String modell, String searchText) {
        executorService.execute(() -> {
            try {
                String sql = "SELECT * FROM Creation WHERE Model=? AND Name LIKE ?";
                try (PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setString(1, modell);
                    pst.setString(2, searchText + "%"); // Fetch items starting with the typed letters

                    try (ResultSet rs = pst.executeQuery()) {
                        // Clear previous items in the UI thread
                        Platform.runLater(() -> recipe.getItems().clear());
                        while (rs.next()) {
                            String name = rs.getString("Name");
                            // Ensure that UI updates are done on the JavaFX thread
                            Platform.runLater(() -> recipe.getItems().add(name));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log exceptions for debugging
            }
        });
    }

    // Method to handle item selection in the ComboBox
    private void handleRecipeSelection(ActionEvent event) {
        String selectedItem = recipe.getSelectionModel().getSelectedItem(); // Get selected item
        if (selectedItem != null) {
            recipe.getEditor().setText(selectedItem); // Set the editor text to the selected item
            // Optional: Close the ComboBox dropdown
            recipe.hide();
            System.out.println("Selected Item: " + selectedItem); // Log the selected item
            woow=selectedItem;
        } else {
            System.out.println("No item selected."); // Log if no item was selected
        }
    }

    // Ensure to clean up resources when no longer needed
    public void shutdownExecutor() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    
    
     private void addRow(String monthh, String modell, String washnamee, String patchh, String quantityy, String unitss, String chemicall, String chemicalnamee, String totalquantityy, String dilutionn, String pricee, String unitpricee, String totalpricee) {
       
        if (!monthh.isEmpty() && !modell.isEmpty() && !washnamee.isEmpty() && !patchh.isEmpty() && !quantityy.isEmpty() && !unitss.isEmpty() && !chemicall.isEmpty() && !chemicalnamee.isEmpty() && !totalquantityy.isEmpty() && !dilutionn.isEmpty() && !pricee.isEmpty() && !unitpricee.isEmpty() && !totalpricee.isEmpty()) {
            ObservableList<String> newRow = FXCollections.observableArrayList( monthh,modell,  washnamee,  patchh,  quantityy,  unitss,  chemicall,  chemicalnamee,  totalquantityy,  dilutionn,  pricee,  unitpricee, totalpricee);
            dataaa.add(newRow);
        } else {
        } 
    }

   
   private void deleteSelectedRows() {
        // Get selected rows
        ObservableList<ObservableList<String>> selectedItems = table.getSelectionModel().getSelectedItems();
        // Remove selected rows from the data list
        dataaa.removeAll(selectedItems);
        
        table.getSelectionModel().clearSelection();
    }
    
   
   
   
   
   
   
   
   
   
   
   
    
    
}
