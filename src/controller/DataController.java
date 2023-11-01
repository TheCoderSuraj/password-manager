package src.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Comparator;
// import java.util.HashSet;
// import java.util.Set;

import src.func.encrypt.CipherNotInitException;
import src.func.store.FileStorage;
import src.models.PasswordModel;

public class DataController {
    static ArrayList<PasswordModel> passwords = new ArrayList<PasswordModel>();
    // static Set<String> websites = new HashSet<String>();
    static HashMap<String, Object> data = new HashMap<String, Object>();

    public static ArrayList<PasswordModel> getPasswords() {
        return passwords;
    }

    public static HashMap<String, Object> getData() {
        return data;
    }

    // public static Set<String> getWebsites() {
    // return websites;
    // }

    public static void init() {
        try {
            passwords = FileStorage.retrievePasswords();
            // passwords.sort(new Comparator<PasswordModel>() {

            // @Override
            // public int compare(PasswordModel pass1, PasswordModel pass2) {
            // return pass1.website.compareTo(pass2.website);
            // }

            // });
            for (PasswordModel pass : passwords) {
                // websites.add(pass.website);
                data.put(pass.website, pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addPassword(PasswordModel pass) throws IOException, CipherNotInitException {
        FileStorage.addPassword(pass);
        passwords.add(pass);
        data.put(pass.website, pass);
        // websites.add(pass.website);
    }

}
