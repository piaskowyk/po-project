package wallet.server.Exceptions;

public class UnpermittedCharsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Unpermited chars in url request";
    }
}
