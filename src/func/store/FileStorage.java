package src.func.store;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import src.func.encrypt.CipherNotInitException;
import src.func.encrypt.MyCipher;
import src.models.PasswordModel;
import src.utils.MyPath;

public class FileStorage {

    public static void addPassword(PasswordModel pass) throws IOException, CipherNotInitException {
        FileWriter fw = new FileWriter(MyPath.passwordsPath, true);
        fw.write(pass.toCSV());
        fw.close();
    }

    public static void addAfterDelete(ArrayList<PasswordModel> pass) throws IOException, CipherNotInitException {
        FileWriter fw = new FileWriter(MyPath.passwordsPath, false);
        for (PasswordModel pm : pass) {
            fw.write(pm.toCSV());
        }
        fw.close();
    }

    public static ArrayList<PasswordModel> retrievePasswords() throws IOException, CipherNotInitException {
        FileReader tr = new FileReader(MyPath.passwordsPath);
        try (Scanner sc = new Scanner(tr)) {
            ArrayList<PasswordModel> res = new ArrayList<PasswordModel>();
            while (sc.hasNextLine()) {
                res.add(new PasswordModel(sc.nextLine()));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MyCipher.init();
        PasswordModel pass = new PasswordModel("google.com", "test1", "suraj1");
        try {
            addPassword(pass);
            ArrayList<PasswordModel> pm;
            pm = retrievePasswords();
            System.out.println(pm);
            addAfterDelete(pm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
