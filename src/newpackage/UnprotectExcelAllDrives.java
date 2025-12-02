package newpackage;

//import com.spire.xls.Workbook;
//import com.spire.xls.Worksheet;
//import com.spire.xls.ExcelVersion;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UnprotectExcelAllDrives {
//
//    public static void main(String[] args) {
//
//        String password = "Go To Hell";   // الباسورد اللي اتعمل بيه حماية الشيتات
//        List<Path> excelFiles = new ArrayList<>();
//
//        File[] roots = File.listRoots();
//        for (File root : roots) {
//
//            // تجاهل Drive C
//            if (root.toString().equalsIgnoreCase("C:\\")) {
//                System.out.println("Skipping C drive.");
//                continue;
//            }
//
//            Path startPath = root.toPath();
//            System.out.println("Searching in drive: " + startPath);
//
//            try {
//                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//
//                    @Override
//                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                        String f = file.toString().toLowerCase();
//
//                        if (f.endsWith(".xlsx") || f.endsWith(".xls") || f.endsWith(".xlsb")) {
//                            excelFiles.add(file);
//                        }
//
//                        return FileVisitResult.CONTINUE;
//                    }
//
//                    @Override
//                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                        System.err.println("Access denied: " + file);
//                        return FileVisitResult.CONTINUE;
//                    }
//
//                });
//            } catch (Exception e) {
//                System.err.println("Error scanning drive " + root + ": " + e.getMessage());
//            }
//        }
//
//        System.out.println("Found Excel files: " + excelFiles.size());
//
//        // فك حماية كل ملف
//        for (Path excelFile : excelFiles) {
//            try {
//                System.out.println("Processing: " + excelFile);
//
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(excelFile.toString());
//
//                int sheetCount = workbook.getWorksheets().getCount();
//
//                for (int i = 0; i < sheetCount; i++) {
//                    try {
//                        Worksheet sheet = workbook.getWorksheets().get(i);
//                        sheet.unprotect(password);
//                        System.out.println("Unprotected sheet: " + sheet.getName());
//                    } catch (Exception ex) {
//                        // تجاهل أي شيت مش مقفول أو باسورد غلط
//                    }
//                }
//
//                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
//                workbook.dispose();
//
//                System.out.println("✔ DONE: " + excelFile);
//
//            } catch (Exception e) {
//                System.out.println("❌ FAILED: " + excelFile + "    Reason: " + e.getMessage());
//            }
//        }
//
//        System.out.println("FINISHED.");
//    }
//}





//
//import com.spire.xls.ExcelVersion;
//import com.spire.xls.Workbook;
//import com.spire.xls.Worksheet;
//
//import java.io.IOException;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UnprotectExcelAllDrives {
//
//    public static void main(String[] args) {
//
//        List<String> excelFilePaths = new ArrayList<>();
//
//        // ضع المسار هنا
//        String folderPath = "C:\\Users\\Ahmed.ElKady\\Desktop\\ooooo";
//
//        Path startPath = Paths.get(folderPath);
//
//        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
//            System.err.println("Invalid folder path. Please ensure the path exists and is a directory.");
//            return;
//        }
//
//        System.out.println("Searching in folder: " + startPath);
//
//        try {
//            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
//
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
//                    String f = file.toString().toLowerCase();
//                    if (f.endsWith(".xlsx") || f.endsWith(".xls") || f.endsWith(".xlsb")) {
//                        excelFilePaths.add(file.toString());
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) {
//                    System.err.println("Access denied or unable to read: " + file);
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//
//        } catch (IOException e) {
//            System.err.println("Error walking file tree: " + e.getMessage());
//        }
//
//        System.out.println("Found " + excelFilePaths.size() + " Excel files:");
//
//        // الباسورد اللي اتعمل بيه حماية الشيتات
//        String password = "5132";
//
//        for (String filePath : excelFilePaths) {
//            try {
//                System.out.println("Processing file: " + filePath);
//
//                Workbook workbook = new Workbook();
//                workbook.loadFromFile(filePath);
//
//                // عدد كل الشيتات
//                int sheetCount = workbook.getWorksheets().getCount();
//
//                // فك الحماية في كل شيت
//                for (int i = 0; i < sheetCount; i++) {
//                    try {
//                        Worksheet sheet = workbook.getWorksheets().get(i);
//                        sheet.unprotect(password);
//                        System.out.println("Unprotected sheet: " + sheet.getName());
//                    } catch (Exception ignored) {
//                        // تجاهل الشيتات غير المحمية أو التي لا تقبل الباسورد
//                    }
//                }
//
//                // حفظ الملف بعد فك الحماية
//                workbook.saveToFile(filePath, ExcelVersion.Version2016);
//                workbook.dispose();
//
//                System.out.println("File unprotected successfully: " + filePath);
//
//            } catch (Exception e) {
//                System.err.println("Unable to process file: " + filePath + " - " + e.getMessage());
//            }
//        }
//    }
//}
