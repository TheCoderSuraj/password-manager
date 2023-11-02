package src.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import src.func.encrypt.CipherNotInitException;
import src.func.store.FileStorage;
import src.models.PasswordModel;
import src.utils.MyPath;

public class DataController {
    static ArrayList<PasswordModel> passwords = new ArrayList<PasswordModel>();
    // static HashMap<String, Object> data = new HashMap<String, Object>();

    public static ArrayList<PasswordModel> getPasswords() {
        return passwords;
    }

    // public static HashMap<String, Object> getData() {
    // return data;
    // }
    public static Set<String> getWebsites() {
        ArrayList<String> res = new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        for (PasswordModel psModel : passwords) {
            set.add(psModel.getWebsite());
        }
        return set;
    }

    public static ArrayList<PasswordModel> getWebsiteData(String url) {
        ArrayList<PasswordModel> pass = new ArrayList<PasswordModel>();
        for (PasswordModel passwordModel : passwords) {
            if (passwordModel.getWebsite().equals(url)) {
                pass.add(passwordModel);
                // System.out.println("we got one more");
            }
        }
        // System.out.println("our data size: " + pass.size());
        return pass;
    }

    private static void rewriteData() {
        try {
            FileStorage.addAfterDelete(passwords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public static Set<String> getWebsites() {
    // return websites;
    // }

    public static void init() {
        try {
            File file = new File(MyPath.dirPath);
            if (!file.isDirectory() || !file.exists()) {
                file.mkdirs();
            }

            if (!new File(MyPath.passwordsPath).exists()) {
                return;
            }

            passwords = FileStorage.retrievePasswords();

            for (PasswordModel pass : passwords) {
                // websites.add(pass.website);
                // data.put(pass.getWebsite(), pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPassword(PasswordModel pass) throws IOException, CipherNotInitException {
        FileStorage.addPassword(pass);
        passwords.add(pass);
        // data.put(pass.getWebsite(), pass);
        // websites.add(pass.website);
    }

    public static void deletePassword(PasswordModel pass) {
        System.out.println(passwords.size());
        passwords.remove(pass);
        rewriteData();
        System.out.println(passwords.size());
    }

    public static void updatePassword(PasswordModel old, PasswordModel pass) {
        int index = passwords.indexOf(old);
        passwords.set(index, pass);
        rewriteData();
    }

}
