package kadysoft.kady;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class FileDecryptor {

    private static final int TAG_LENGTH = 128;

    private static int toInt(byte[] b) {
        return ((b[0] & 0xFF) << 24) |
               ((b[1] & 0xFF) << 16) |
               ((b[2] & 0xFF) << 8) |
               (b[3] & 0xFF);
    }
    public static void decrypt(
            String input,
            String output,
            String password
    ) throws Exception {
        FileInputStream fis = new FileInputStream(input);
        byte[] salt = new byte[16];
        fis.read(salt);
        byte[] iv = new byte[12];
        fis.read(iv);
        byte[] sizeBytes = new byte[4];
        fis.read(sizeBytes);
        int keySize = toInt(sizeBytes);
        byte[] encryptedMasterKey = new byte[keySize];
        fis.read(encryptedMasterKey);
        SecretKey passwordKey = CryptoUtils.deriveKey(password, salt);
        Cipher keyCipher = Cipher.getInstance("AES");
        keyCipher.init(Cipher.DECRYPT_MODE, passwordKey);
        byte[] masterKeyBytes =
        keyCipher.doFinal(encryptedMasterKey);
        SecretKey masterKey =
        new SecretKeySpec(masterKeyBytes, "AES");
        Cipher fileCipher = Cipher.getInstance("AES/GCM/NoPadding");
        fileCipher.init(Cipher.DECRYPT_MODE,
        masterKey,
        new GCMParameterSpec(TAG_LENGTH, iv));
        FileOutputStream fos = new FileOutputStream(output);
        byte[] buffer = new byte[4096];
        int read;
        while ((read = fis.read(buffer)) != -1) {
            byte[] dec = fileCipher.update(buffer, 0, read);
            if (dec != null) fos.write(dec);
        }
        byte[] finalBytes = fileCipher.doFinal();
        if (finalBytes != null) fos.write(finalBytes);
        fis.close();
        fos.close();
    }
}