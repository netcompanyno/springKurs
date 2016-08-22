package no.mesan.spring.xml;

/** Format message as plain text. */
public class TextFormatter implements Formatter {
    @Override
    public String format(final String greet, final String recipient) {
        return greet + ", " + recipient + "!";
    }
}
