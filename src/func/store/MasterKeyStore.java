package src.func.store;

import java.io.File;

import src.utils.MyPath;

public class MasterKeyStore {
    // private static boolean hasInitialized = false;
    // private static String masterKey = "";
    private static String masterKey = "Suraj@123";

    public static String getMasterKey() {
        return masterKey;
    }

    // public static void init() {
    // try {
    // if (!new File(MyPath.secretKeyPath).exists()) {

    // System.out.println("new key generated");
    // } else {

    // System.out.println("old key retrieved");
    // }
    // hasInitialized = true;
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    // public

}
