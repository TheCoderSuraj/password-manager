package src.func.encrypt;

public class CipherNotInitException extends Exception {

    @Override
    public String getMessage() {
        return "MyCipher not Initialized";
    }

    @Override
    public void printStackTrace() {
        System.out.println(
                "MyCipher has not yet initialized.\nPlease call \n>>>>`MyCipher.init()` \nbefore calling this method");
    }

}
