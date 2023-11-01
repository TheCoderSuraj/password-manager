package src.func.store;

public class KeyNotInitException extends Exception {
    @Override
    public String getMessage() {
        return "MasterKeyStore not Initialized";
    }

    @Override
    public void printStackTrace() {
        System.out.println(
                "MasterKeyStore has not yet initialized.\nPlease call \n>>>>`MasterKeyStore.init()` \nbefore calling this method");
    }
}
