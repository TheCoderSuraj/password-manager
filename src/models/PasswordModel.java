package src.models;

import src.func.encrypt.CipherNotInitException;
import src.func.encrypt.MyCipher;

public class PasswordModel {
    public String website;
    public String password;
    public String username;

    public PasswordModel(String website, String username, String password) {
        this.website = website;
        this.password = password;
        this.username = username;
    }

    public PasswordModel(String value) throws CipherNotInitException {
        String[] res = value.strip().split(",");
        website = res[0];
        username = res[1];
        password = MyCipher.decrypt(res[2]);
    }

    @Override
    public String toString() {
        return "PasswordModel [website=" + website + ", password=" + password + ", username=" + username + "]";
    }

    public String toCSV() throws CipherNotInitException {
        String pass = MyCipher.encrypt(password);
        return website + "," + username + "," + pass + "\n";
    }
}
