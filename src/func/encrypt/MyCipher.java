package src.func.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import src.utils.MyPath;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MyCipher {
    private static final String AES_ALGORITHM = "AES";
    private static SecretKey secretKey;
    private static boolean hasInitialized = false;

    public static void init() {
        try {
            if (!new File(MyPath.secretKeyPath).exists()) {
                secretKey = generateSecretKey();
                storeSecretKey(secretKey);
                System.out.println("new key generated");
            } else {
                secretKey = retrieveSecretKey();
                System.out.println("old  key retrieved");
            }
            hasInitialized = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    private static void storeSecretKey(SecretKey secretKey) {
        byte[] encodedKey = secretKey.getEncoded();
        try {
            Path filePath = Path.of(MyPath.secretKeyPath);
            Files.write(filePath, encodedKey, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey retrieveSecretKey() {
        try {
            byte[] encodedKey = Files.readAllBytes(Path.of(MyPath.secretKeyPath));
            return new SecretKeySpec(encodedKey, AES_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String plaintext) throws CipherNotInitException {
        if (!hasInitialized)
            throw new CipherNotInitException();
        try {
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println("Encrypt error: " + e.getMessage());
        }
        return null;
    }

    public static String decrypt(String ciphertext) throws CipherNotInitException {
        if (!hasInitialized)
            throw new CipherNotInitException();
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(ciphertext);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.err.println("De-Encrypt error: " + e.getMessage());
            // e.printStackTrace();
        }
        return null;
    }

}
