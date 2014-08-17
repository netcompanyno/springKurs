package no.mesan.spring.hello.felles;

/** Format message as plain text. */
public class TextFormatter {
    public String format(final String greet, final String recipient) {
        return greet + ", " + recipient + "!";
    }
}
