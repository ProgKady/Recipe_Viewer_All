package kadysoft.kady;

import java.io.File;

public class PasswordChanger {

    public static void changePassword(
            String file,
            String oldPassword,
            String newPassword
    ) throws Exception {
        File temp = new File(file + ".tmp");
        try {
            FileDecryptor.decrypt(file, temp.getPath(), oldPassword);
            FileEncryptor.encrypt(temp.getPath(), file, newPassword);
        } finally {
            temp.delete();
        }
    }
}