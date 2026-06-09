
package newpackage;

import java.io.File;
import kadysoft.kady.FileDecryptor;


/**
 *
 * @author ahmed.elkady
 */
public class tests {


    
    public static void main(String[] args) {
       
    try {
    String result = "5132";
    File filee=new File ("C:\\Users\\ahmed.elkady\\Desktop\\testt\\testt.xlsx");
    if (filee == null) {
        System.out.println("Choose file first!");
        return;
    }
    
    String input = filee.getAbsolutePath();
    String tempOutput = input + ".tmp";
    System.out.println("Decrypting with password: " + result);
    FileDecryptor.decrypt(input, tempOutput, result);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        System.out.println("File decrypted successfully.");
    } else {
        System.out.println("Failed to replace original file.");
    }
} catch (Exception ex) {
    ex.printStackTrace();
    String errorMsg = "Wrong password or corrupted file.";
    if (ex.getClass().getSimpleName().contains("AEADBadTag") || 
        ex.getMessage() != null && ex.getMessage().contains("BadTag")) {
        errorMsg = "Wrong password! The key does not match the file.";
        System.out.println(errorMsg);
    }
    System.out.println("Decryption Failed!");
}






//try {
//
//    String password = "5132";
//    File filee=new File ("C:\\Users\\ahmed.elkady\\Desktop\\testt\\testt.xlsx");
//    if (filee == null) {
//        System.out.println("Choose file first!");
//        return;
//    }
//    String input = filee.getAbsolutePath();
//    String tempOutput = input + ".tmp";
//    System.out.println("Encrypting with password: " + password);
//    FileEncryptor.encrypt(input, tempOutput, password);
//    File original = new File(input);
//    File temp = new File(tempOutput);
//    if (original.exists()) {
//        original.delete();
//    }
//    if (temp.renameTo(original)) {
//        System.out.println("File encrypted successfully!");
//    } else {
//        System.out.println("Failed to replace original file.");
//    }
//} catch (Exception ex) {
//    ex.printStackTrace();
//    System.out.println("An error occurred during encryption.");
//}



     



        
    } 
}
