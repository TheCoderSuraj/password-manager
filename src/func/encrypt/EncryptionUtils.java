package src.func.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionUtils {
    private static final String AES_ALGORITHM = "AES";
    private static SecretKey secretKey;
    private static String path = "test.txt";

    public static void init() {
        try {
            secretKey = generateSecretKey();
            storeSecretKey(secretKey);
            secretKey = retrieveSecretKey();
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
            Path filePath = Path.of(path);
            Files.write(filePath, encodedKey, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey retrieveSecretKey() {
        try {
            byte[] encodedKey = Files.readAllBytes(Path.of(path));
            return new SecretKeySpec(encodedKey, AES_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String plaintext) {
        try {
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Encrypt error: " + e.getMessage());
        }
        return null;
    }

    public static String decrypt(String ciphertext) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(ciphertext);
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("De-Encrypt error: " + e.getMessage());
            // e.printStackTrace();
        }
        return null;
    }

    // public static void main(String[] arg) {
    // init();
    // String plaintext = "Hello, World!";
    // String encryptedText = encrypt(plaintext);
    // String decryptedText = decrypt(encryptedText);

    // System.out.println("Plaintext: " + plaintext);
    // System.out.println("Encrypted Text: " + encryptedText);
    // System.out.println("Decrypted Text: " + decryptedText);
    // }
}