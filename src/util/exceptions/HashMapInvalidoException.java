package util.exceptions;

/**
 *
 * @author lhfba
 */
public class HashMapInvalidoException extends Exception {

    public HashMapInvalidoException() {
    }

    public HashMapInvalidoException(String string) {
        super("erro: "+ string);
    }
    
    
}
