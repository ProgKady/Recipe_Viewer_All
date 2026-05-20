package kadysoft.kady;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class FileEncryptor {

    private static final int TAG_LENGTH = 128;

    private static void writeInt(FileOutputStream fos, int value) throws Exception {
        fos.write(new byte[] {
                (byte)(value >> 24),
                (byte)(value >> 16),
                (byte)(value >> 8),
                (byte)value
        });
    }
    public static void encrypt(
            String input,
            String output,
            String password
    ) throws Exception {
        byte[] salt = CryptoUtils.generateSalt();
        byte[] iv = CryptoUtils.generateIV();
        SecretKey passwordKey = CryptoUtils.deriveKey(password, salt);
        SecretKey masterKey = KeyManager.generateMasterKey();
        Cipher keyCipher = Cipher.getInstance("AES");
        keyCipher.init(Cipher.ENCRYPT_MODE, passwordKey);
        byte[] encryptedMasterKey =
        keyCipher.doFinal(masterKey.getEncoded());
        Cipher fileCipher = Cipher.getInstance("AES/GCM/NoPadding");
        fileCipher.init(Cipher.ENCRYPT_MODE,
        masterKey,
        new GCMParameterSpec(TAG_LENGTH, iv));
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream(output);
        fos.write(salt);
        fos.write(iv);
        writeInt(fos, encryptedMasterKey.length);
        fos.write(encryptedMasterKey);
        byte[] buffer = new byte[4096];
        int read;
        while ((read = fis.read(buffer)) != -1) {
        byte[] enc = fileCipher.update(buffer, 0, read);
        if (enc != null) fos.write(enc);
        }
        byte[] finalBytes = fileCipher.doFinal();
        if (finalBytes != null) fos.write(finalBytes);
        fis.close();
        fos.close();
    }
}