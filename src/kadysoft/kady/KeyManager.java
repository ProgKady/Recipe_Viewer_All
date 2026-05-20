package kadysoft.kady;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyManager {
    public static SecretKey generateMasterKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(256);
        return kg.generateKey();
    }
}