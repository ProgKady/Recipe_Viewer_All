package kadysoft.kady;

import java.io.File;

public class PasswordMigration {

    public static void upgradeAllFiles(
            String folderPath,
            String oldPassword,
            String newPassword
    ) throws Exception {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (!file.isFile()) continue;
            if (!file.getName().endsWith(".enc")) continue;
            try {
                String temp = file.getAbsolutePath() + ".tmp";
                FileDecryptor.decrypt(
                        file.getAbsolutePath(),
                        temp,
                        oldPassword
                );
                FileEncryptor.encrypt(
                        temp,
                        file.getAbsolutePath(),
                        newPassword
                );
                new File(temp).delete();
                System.out.println("OK: " + file.getName());
            } catch (Exception ex) {
                System.out.println("FAIL: " + file.getName());
                ex.printStackTrace();
            }
        }
    }
}