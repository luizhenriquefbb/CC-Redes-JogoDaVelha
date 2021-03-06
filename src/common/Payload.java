package common;

/**
 * Wrapper for string to represent packet payloads
 *
 * 
 *
 */
public class Payload {
    public final String content;

    public Payload(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
