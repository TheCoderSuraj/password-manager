package src.models;

import src.func.encrypt.CipherNotInitException;
import src.func.encrypt.MyCipher;

public class PasswordModel {
    String website;
    String password;
    String username;

    public String getWebsite() {
        return website;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

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
        System.out.println("this is password: " + MyCipher.decrypt("FIBm1EilG8RUqcVowD4RcQ=="));
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
