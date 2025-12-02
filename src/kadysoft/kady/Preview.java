package kadysoft.kady;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Preview implements Initializable {
   @FXML
   WebView webview;
   MenuItem m1;
   MenuItem m2;
   MenuItem m3;
   MenuItem m4;
   MenuItem m5;
   MenuItem m6;
   static String pathy;

   @FXML
   void viewpress(KeyEvent event) {
   }

   public void initialize(URL url, ResourceBundle rb) {
      this.m1 = new MenuItem("Open Recipe");
      this.m1.setOnAction((uu) -> {
         FileChooser fcho = new FileChooser();
         String go = NewDir.file_dir;
         fcho.setInitialDirectory(new File(go));
         fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[]{"*.ks"}));
         fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
         fcho.setTitle("Kady Choose");
         File f = fcho.showOpenDialog((Window)null);
         pathy = f.getAbsolutePath().toString();
         String newpathyy=pathy.replace(".ks", ".html");
        String linet = "cmd /C copy /Y "+pathy+" "+newpathyy;
        Process p;
        
          try {
              p = Runtime.getRuntime().exec(linet);
              p.waitFor();
          } catch (IOException ex) {
              Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(Preview.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        URI uri = Paths.get(newpathyy).toAbsolutePath().toUri();
        webview.getEngine().load(uri.toString());
        File nm=new File (newpathyy);
        if (pathy.contains(".ks")) {
            nm.delete();
        }
        else {
            
        }
      });
      this.m2 = new MenuItem("Open In Browser");
      this.m2.setOnAction((uu) -> {
          String newpathyy=pathy.replace(".ks", ".html");
         Desktop des = Desktop.getDesktop();

         try {
            des.open(new File(newpathyy));
         } catch (IOException var3) {
         }

      });
      this.m3 = new MenuItem("Exit");
      this.m3.setOnAction((uu) -> {
         System.exit(0);
      });
      this.m5 = new MenuItem("Increase Scale");
      this.m5.setOnAction((uu) -> {
         this.webview.setFontScale(this.webview.getFontScale() + 1.0);
      });
      this.m6 = new MenuItem("Decrease Scale");
      this.m6.setOnAction((uu) -> {
         this.webview.setFontScale(this.webview.getFontScale() - 1.0);
      });
      this.m4 = new MenuItem("Print Recipe");
      this.m4.setOnAction((uu) -> {
         PrinterJob job = PrinterJob.createPrinterJob();
         job.showPrintDialog((Window)null);
         job.showPageSetupDialog((Window)null);
         this.webview.getEngine().print(job);
         job.endJob();
      });
      ContextMenu cm = new ContextMenu();
      cm.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      cm.getItems().addAll(new MenuItem[]{this.m1, this.m4, this.m5, this.m6, this.m3});
      this.webview.setContextMenuEnabled(false);
      this.webview.setOnMousePressed((e) -> {
         if (e.getButton() == MouseButton.SECONDARY) {
            cm.show(this.webview, e.getSceneX(), e.getSceneY());
         } else {
            cm.hide();
         }

      });
      
      
      
      this.webview.setOnKeyReleased((gg) -> {
         String code = (String)this.webview.getEngine().executeScript("document.documentElement.outerHTML");

         try {
            OutputStream instream=new FileOutputStream(pathy);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println();
            pw.print(code);
            pw.close();
         } catch (IOException var4) {
         }

      });
   }
}
