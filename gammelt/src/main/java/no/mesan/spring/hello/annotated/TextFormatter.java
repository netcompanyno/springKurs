package no.mesan.spring.hello.annotated;


/** Format message as plain text. */
public class TextFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
        return greet + ", " + recipient + "!";
    }
}
