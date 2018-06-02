package util.exceptions;

/**
 *
 * @author luiz
 */
public class LoginException extends Exception {

    public LoginException() {
        super("error: erro de login");
    }

    public LoginException(String message) {
        super(message);
    }
    
}