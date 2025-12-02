package newpackage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
   public void start(Stage stage) throws Exception {
       
    //////////////////////////Add All Codes Here////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Read first and compare then write
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value1 = timeString;

    File ff=new File (System.getProperty("user.home")+"\\AppData\\Roaming\\.store_cfg");
    
    if (ff.exists()) {
        //Read then compare if equals 30 or more show alert and exit, if less don't do anything.
      BufferedReader buff=new BufferedReader(new FileReader(ff));
      String line;
      line=buff.readLine();
      buff.close();
      LocalDate d1 = LocalDate.parse(line, DateTimeFormatter.ISO_LOCAL_DATE);
      LocalDate d2 = LocalDate.parse(value1, DateTimeFormatter.ISO_LOCAL_DATE);
      Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
      long diffDays = diff.toDays();
      
      if (diffDays>=90) {

          System.out.println("Error");
         
          
      }
      
      else {
          // Do Nothing
          
          System.out.println(diffDays);
          
      }
    }
    else {
        //Write date for the first time.
        ff.createNewFile();
        PrintWriter pw=new PrintWriter (new FileWriter (ff));
        pw.print("2023-10-20");
        pw.close();
    }
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
     
    
      
   }

   public static void main(String[] args) {
      launch(args);
      
      
      
      
      
      
      
      
      
      
      
   }
}
