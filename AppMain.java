import src.func.encrypt.MyCipher;
import src.ui.PassApp;

public class AppMain {
    public static void main(String[] args) {
        MyCipher.init();
        new PassApp();
    }
}
